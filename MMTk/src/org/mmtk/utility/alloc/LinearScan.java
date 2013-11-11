/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2004
 */
//$Id: LinearScan.java,v 1.1 2004/11/18 04:56:39 steveb-oss Exp $
package org.mmtk.utility.alloc;

import org.vmmagic.unboxed.*;
import org.vmmagic.pragma.*;

/**
 * Callbacks from BumpPointer during a linear scan are dispatched through
 * a subclass of this object.
 *
 * @author Daniel Frampton 
 * @version $Revision: 1.1 $
 * @date    $Date: 2004/11/18 04:56:39 $
 */
abstract public class LinearScan implements Uninterruptible {
  /**
   * Scan an object. 
   *
   * @param object The object to scan
   */
  abstract public void scan(ObjectReference object);
}
