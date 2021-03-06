/*
 * (C) Copyright IBM Corp 2002, 2004
 */
//$Id: VMSystem.java,v 1.10 2005/02/28 13:08:35 dgrove-oss Exp $
package java.lang;

import com.ibm.JikesRVM.VM;
import com.ibm.JikesRVM.VM_ObjectModel;
import com.ibm.JikesRVM.VM_Runtime;
import com.ibm.JikesRVM.VM_Statics;
import com.ibm.JikesRVM.VM_SysCall; // for VM_SysCall.sysGetenv
import com.ibm.JikesRVM.VM_Time;

import com.ibm.JikesRVM.classloader.VM_Array;
import com.ibm.JikesRVM.classloader.VM_Atom;
import com.ibm.JikesRVM.classloader.VM_Class;
import com.ibm.JikesRVM.classloader.VM_Field;

import java.lang.reflect.Field;
import java.util.Properties;
import java.io.*;

import org.vmmagic.unboxed.Offset;

/**
 * Library support interface of Jikes RVM
 *
 * @author Julian Dolby
 *
 */
final class VMSystem {


  static void arraycopy(Object src, int srcPos, Object dst, int dstPos, int len) {
    try {
      if (src == null || dst == null)    VM_Runtime.raiseNullPointerException();
      else if (src instanceof char[])    VM_Array.arraycopy((char[])src, srcPos, (char[])dst, dstPos, len);
      else if (src instanceof boolean[]) VM_Array.arraycopy((boolean[])src, srcPos, (boolean[])dst, dstPos, len);
      else if (src instanceof byte[])    VM_Array.arraycopy((byte[])src, srcPos, (byte[])dst, dstPos, len);
      else if (src instanceof short[])   VM_Array.arraycopy((short[])src, srcPos, (short[])dst, dstPos, len);
      else if (src instanceof int[])     VM_Array.arraycopy((int[])src, srcPos, (int[])dst, dstPos, len);
      else if (src instanceof long[])    VM_Array.arraycopy((long[])src, srcPos, (long[])dst, dstPos, len);
      else if (src instanceof float[])   VM_Array.arraycopy((float[])src, srcPos, (float[])dst, dstPos, len);
      else if (src instanceof double[])  VM_Array.arraycopy((double[])src, srcPos, (double[])dst, dstPos, len);
      else                               VM_Array.arraycopy((Object[])src, srcPos, (Object[])dst, dstPos, len);
    } catch (ClassCastException e) {
      VM_Runtime.raiseArrayStoreException();
    }
  }
    
  static int identityHashCode(Object o) {
    return o == null ? 0 : VM_ObjectModel.getObjectHashCode(o);
  }

  static boolean isWordsBigEndian() {
    return !VM.LittleEndian;
  }

  public static long currentTimeMillis() {
    return VM_Time.currentTimeMillis();
  }

  static void setIn(InputStream in) {
    try {
      VM_Field inField = 
        ((VM_Class)JikesRVMSupport.getTypeForClass(System.class))
        .findDeclaredField( 
                           VM_Atom.findOrCreateUnicodeAtom("in"), 
                           VM_Atom.findOrCreateUnicodeAtom("Ljava/io/InputStream;"));

      inField.setObjectValueUnchecked(null, in);
    } catch (Exception e) {
      throw new Error( e.toString() );
    }
  }

  static void setOut(PrintStream out) {
    try {
      VM_Field outField = 
        ((VM_Class)JikesRVMSupport.getTypeForClass(System.class))
        .findDeclaredField( 
                           VM_Atom.findOrCreateUnicodeAtom("out"), 
                           VM_Atom.findOrCreateUnicodeAtom("Ljava/io/PrintStream;"));

      outField.setObjectValueUnchecked(null, out);
    } catch (Exception e) {
      throw new Error( e.toString() );
    }
  }

  static void setErr(PrintStream err) {
    try {
      VM_Field errField = 
        ((VM_Class)JikesRVMSupport.getTypeForClass(System.class))
        .findDeclaredField( 
                           VM_Atom.findOrCreateUnicodeAtom("err"), 
                           VM_Atom.findOrCreateUnicodeAtom("Ljava/io/PrintStream;"));

      errField.setObjectValueUnchecked(null, err);
    } catch (Exception e) {
      throw new Error( e.toString() );
    }
  }

  static InputStream makeStandardInputStream() { return null; }

  static PrintStream makeStandardOutputStream() { return null; }

  static PrintStream makeStandardErrorStream() { return null; }

  static String internString(String string) {
    try {
      return (String)
        VM_Statics.getSlotContentsAsObject(Offset.fromIntSignExtend( 
            VM_Statics.findOrCreateStringLiteral(VM_Atom.findOrCreateUnicodeAtom(string))));
    } catch (UTFDataFormatException ex) {
      throw new InternalError( ex.toString() );
    }
  }

  /** Get the value of an environment variable.  
   */
  static String getenv(String envarName) {
    
    byte[] buf = new byte[128]; // Modest amount of space for starters.  

    byte[] nameBytes = envarName.getBytes();

    int len = VM_SysCall.sysGetenv(nameBytes, buf, buf.length);

    if (len < 0)                // not set.
      return null;

    if (len > buf.length ) {
      buf = new byte[len];
      VM_SysCall.sysGetenv(nameBytes, buf, len);
    }

    return new String(buf, 0, len);
  }

}
