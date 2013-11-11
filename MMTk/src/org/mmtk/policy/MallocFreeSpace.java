/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2003
 */
package org.mmtk.policy;

import org.mmtk.utility.heap.FreeListPageResource;
import org.mmtk.utility.Log;
import org.mmtk.utility.Constants;

import org.vmmagic.unboxed.*;
import org.vmmagic.pragma.*;

/**
 * JREG Extension
 */
public final class MallocFreeSpace extends Space
  implements Constants, Uninterruptible {

  public static final int LOCAL_GC_BITS_REQUIRED = 0;
  public static final int GLOBAL_GC_BITS_REQUIRED = 0;
  public static final int GC_HEADER_WORDS_REQUIRED = 0;

  /** Create this space. All constructors need to be provided.
   *  pr is used to allocated pages in a free-list manner
   **/
  public MallocFreeSpace(String name, int pageBudget, float frac) {
      super(name, false, false, frac);
      pr = new FreeListPageResource(pageBudget, this, start, extent, 
              MallocFreeLocal.META_DATA_PAGES_PER_REGION);
  }

  public final void release(Address start) throws InlinePragma {
      ((FreeListPageResource) pr).releasePages(start); 
  }

  public final ObjectReference traceObject(ObjectReference object)
      throws InlinePragma {
      return object;
  }

}
