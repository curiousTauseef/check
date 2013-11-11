/*
 * JREG Extension
 * MM with explicit deallocation
 */
package org.mmtk.plan;

import org.mmtk.policy.MallocFreeSpace;
import org.mmtk.policy.MallocFreeLocal;
import org.mmtk.policy.Space;
import org.mmtk.policy.Space;
import org.mmtk.utility.alloc.*;
import org.mmtk.utility.CallSite;
import org.mmtk.utility.heap.*;
import org.mmtk.utility.scan.*;
import org.mmtk.utility.Log;
import org.mmtk.vm.Assert;
import org.mmtk.vm.ObjectModel;
import org.mmtk.vm.Collection;
import org.vmmagic.unboxed.*;
import org.vmmagic.pragma.*;

import com.ibm.JikesRVM.VM_JavaHeaderConstants;
import com.ibm.JikesRVM.VM_JavaHeader;


/**
 * This class implements a simple allocator no collection, only
 * explicit deallocation
 */
public class MallocFree 
    extends StopTheWorldGC 
    implements Uninterruptible {

    public static final boolean MOVES_OBJECTS = false;
    public static final int GC_HEADER_BITS_REQUIRED = 0;
    public static final int GC_HEADER_WORDS_REQUIRED = 0;
    public static final int ALLOCATORS = BASE_ALLOCATORS;

    // spaces
    private static Space defaultSpace = new
        MallocFreeSpace("dea", DEFAULT_POLL_FREQUENCY, (float) 0.6); 
    private static final int DS = defaultSpace.getDescriptor();

    // allocators
    private MallocFreeLocal def;

    public MallocFree() { 
        def = new MallocFreeLocal(defaultSpace);
    }

    public static final void boot() throws InterruptiblePragma {
        StopTheWorldGC.boot();
    }

    private static long maxsize;
    private static long size;
    private static long immortalSize;
    private static long totalSize;
    private static long realTotalSize;
    private static long realMaxsize;
    private static long realSize;
    private static long smallSize;
    private static long realSmallSize;
    private static long bigSize;
    private static long realBigSize;
    private static long smallNo;
    private static long realSmallNo;
    private static long bigNo;
    private static long realBigNo;
    private static long delSmallSize;
    private static long delRealSmallSize;
    private static long delBigSize;
    private static long delRealBigSize;
    private static long delSmallNo;
    private static long delRealSmallNo;
    private static long delBigNo;
    private static long delRealBigNo;


    public final Address alloc(int bytes, int align, int offset, int allocator)
        throws InlinePragma {
    	Address result;
        if (bytes > 8180 && allocator == ALLOC_DEFAULT) 
            allocator = ALLOC_LOS;

        switch (allocator) {
            case ALLOC_IMMORTAL:  // no immortal
                result = immortal.alloc(bytes, align, offset);
                immortalSize += bytes;

                break;

            case ALLOC_LOS:  
                result = los.alloc(bytes, align, offset);

                break;

            case  ALLOC_DEFAULT: 
                result = def.alloc(bytes, align, offset, true);

                break;
            default:
                if (Assert.VERIFY_ASSERTIONS) 
                    Assert.fail("No such allocator"); 
                return Address.zero();
        }
        
        return result;
    }

    public final void postAlloc(ObjectReference object, 
            ObjectReference typeRef, 
            int bytes, int allocator) throws InlinePragma {
        switch (allocator) {
            case ALLOC_IMMORTAL: 
                immortalSpace.postAlloc(object);
                return;
            case      ALLOC_LOS: 
                loSpace.initializeHeader(object);
            case  ALLOC_DEFAULT: 
                return;
            default:
                if (Assert.VERIFY_ASSERTIONS) 
                    Assert.fail("No such allocator"); 
        }
    }
    public final Address allocCopy(ObjectReference original, int bytes, 
            int align, int offset) throws InlinePragma {
        Assert.fail("no allocCopy in noGC");
        //    return Address.zero();   // Trips some intel opt compiler bug...
        return Address.max();
    }

    public final void postCopy(ObjectReference ref, ObjectReference typeRef, 
                               int bytes) {
        Assert.fail("no postCopy in noGC");
    } 

    protected final Space getSpaceFromAllocator(Allocator a) {
        if (a == def) return defaultSpace;
        return super.getSpaceFromAllocator(a);
    }

    protected final Allocator getAllocatorFromSpace(Space space) {
        if (space == defaultSpace) return def;
        return super.getAllocatorFromSpace(space);
    }

    public final AllocAdvice getAllocAdvice(MMType type, int bytes,
            CallSite callsite, AllocAdvice hint) {
        return null;
    }

    public final boolean poll(boolean mustCollect, Space space) 
        throws LogicallyUninterruptiblePragma {
        if (!initialized || collectionsInitiated > 0 || space == metaDataSpace)
            return false;

        if (getPagesAvail() <= 0) 
            pollnospace++;

        return false;
    }

    protected final void globalPrepare() {
      //loSpace.prepare();
      //def.prepare();
    }

    protected final void threadLocalPrepare(int count) {
    }

    protected final void threadLocalRelease(int count) {
    }

    protected final void globalRelease() {
      //loSpace.release();
      //def.release();
    }


    public static final ObjectReference traceObject(ObjectReference object) 
        throws InlinePragma {
        //return object;
        if (object.isNull()) return object;
        else if (Space.isInSpace(DS, object))
            return defaultSpace.traceObject(object);
        return Space.getSpaceForObject(object).traceObject(object);
    }

    public static final ObjectReference traceObject(ObjectReference object,
            boolean root) {
        return traceObject(object);
    }

    public static final boolean isLive(ObjectReference object) {
        if (object.isNull()) return false;
        return true;
    }

    protected static final int getPagesReserved() {
        return getPagesUsed();
    }

    protected static final int getPagesUsed() {
        int pages = defaultSpace.reservedPages();
        pages += immortalSpace.reservedPages();
        pages += loSpace.reservedPages();
        pages += metaDataSpace.reservedPages();
        return pages;
    }

    protected static final int getPagesAvail() {
        return getTotalPages() - getPagesReserved();
    }


    public final void show() {
        //def.show();
    }

    /** deallocate an object :-) */
    public final void freeObject(ObjectReference tofree) {
        //removeObject(ObjectModel.refToAddress(tofree));
        if (tofree == null || 
                Space.isInSpace(IMMORTAL,tofree) ||
                Space.isInSpace(META,tofree)) {
            return;
        }

        if (Space.isInSpace(LOS,tofree)) {
            Address cell = ObjectModel.refToAddress(tofree);
//if (loSpace.setFree(tofree))  {
                CountPages.prepareForLarge();
                los.freeExternal(cell);
//            }
            return;
        }
        else if (Space.isInSpace(DS,tofree)) {
            def.freeInMallocFree(tofree);
            return;
        }
        /* Assert.fail("Free called in invalid space"); */
    }

    /** stat gathering */

    static private int pollnospace = 0;

    static private int watermark = 0;
    static private int maxpages[] = new int[4];
    static private int objectsAlloc[] = new int[4];
    static private int bytesRequested[] = new int[4];
    
    static public int bytesAlloc[] = new int[4];    
    static public int bytesFreed[] = new int[4];
    static public int objectsFreed[] = new int[4];

    public void planExit(int value){
        CountPages.printusage();
        Log.writeln();
        Log.writeln("[------ End of execution -----]");
        Log.writeln();
        Log.writeln();
        Log.write("Total memory watermark = ");
        writeMb(watermark * BYTES_IN_PAGE);
        Log.writeln();
        /* 
        Log.write("Meta/Imm/Large/Def watermark = ");
        writeMb(maxpages[0] * BYTES_IN_PAGE); Log.write(", ");
        writeMb(maxpages[1] * BYTES_IN_PAGE); Log.write(", ");
        writeMb(maxpages[2] * BYTES_IN_PAGE); Log.write(", ");
        writeMb(maxpages[3] * BYTES_IN_PAGE); 
        Log.writeln();
        Log.writeln();
        Log.write("Total (Imm/Large/Def) alloc objs  = ");
        Log.write(objectsAlloc[0]); Log.write(" (");
        Log.write(objectsAlloc[1]); Log.write(", ");
        Log.write(objectsAlloc[2]); Log.write(", ");
        Log.write(objectsAlloc[3]); Log.write(")");
        Log.writeln();
        Log.write("Total (Imm/Large/Def) freed objs  = ");
        Log.write(objectsFreed[0]); Log.write(" (");
        Log.write(objectsFreed[1]); Log.write(", ");
        Log.write(objectsFreed[2]); Log.write(", ");
        Log.write(objectsFreed[3]); Log.write(")");
        Log.writeln();
        Log.writeln();
        Log.write("Total (Imm/Large/Def) space req   = ");
        writeMb(bytesRequested[0]); Log.write(" (");
        writeMb(bytesRequested[1]); Log.write(", ");
        writeMb(bytesRequested[2]); Log.write(", ");
        writeMb(bytesRequested[3]); Log.write(")");
        Log.writeln();
        Log.write("Total (Imm/Large/Def) space alloc = ");
        writeMb(bytesAlloc[0]); Log.write(" (");
        writeMb(bytesAlloc[1]); Log.write(", ");
        writeMb(bytesAlloc[2]); Log.write(", ");
        writeMb(bytesAlloc[3]); Log.write(")");
        Log.writeln();
        Log.write("Total (Imm/Large/Def) space freed = ");
        writeMb(bytesFreed[0]); Log.write(" (");
        writeMb(bytesFreed[1]); Log.write(", ");
        writeMb(bytesFreed[2]); Log.write(", ");
        writeMb(bytesFreed[3]); Log.write(")");
        Log.writeln();
        */
        Log.writeln();
        Log.write("Java/GC/Misc header bytes = ");
        Log.write(VM_JavaHeaderConstants.JAVA_HEADER_BYTES);
        Log.write(" ");
        Log.write(VM_JavaHeaderConstants.GC_HEADER_BYTES);
        Log.write(" ");
        Log.write(VM_JavaHeaderConstants.MISC_HEADER_BYTES);
        Log.writeln();
        Log.write("Available bits = ");
        Log.write(VM_JavaHeaderConstants.NUM_AVAILABLE_BITS);
        Log.writeln();
    }

    private void writeMb(int bytes) {
        if (bytes < 1024) {
            Log.write(bytes);
            Log.write( "b");
            return;
        }
        else if (bytes < 1024 * 1024) {
            Log.write(bytes/1024);
            Log.write(".");
            Log.write((bytes%1024) * 10 / 1024);
            Log.write("Kb");
            return;
        }
        else {
            int kbytes = bytes / 1024;
            Log.write(kbytes/1024);
            Log.write(".");
            kbytes = kbytes%1024;
            int frac = kbytes * 100 / 1024; 
            if (frac < 10) Log.write("0");
            Log.write(frac);
            Log.write("Mb");
        }
    } 
}

