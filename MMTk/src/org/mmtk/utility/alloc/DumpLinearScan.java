/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2004
 */
//$Id: DumpLinearScan.java,v 1.1 2004/11/18 04:56:39 steveb-oss Exp $
package org.mmtk.utility.alloc;

import org.mmtk.vm.ObjectModel;
import org.mmtk.utility.Log;

import org.vmmagic.unboxed.*;
import org.vmmagic.pragma.*;

/**
 * Simple linear scan to dump object information. 
 *
 * @author Daniel Frampton 
 * @version $Revision: 1.1 $
 * @date    $Date: 2004/11/18 04:56:39 $
 */
final public class DumpLinearScan extends LinearScan implements Uninterruptible {
  /**
   * Scan an object. 
   *
   * @param object The object to scan
   */
  public void scan(ObjectReference object) throws InlinePragma {
    Log.write("[");
    Log.write(object.toAddress());
    Log.write("], SIZE = ");
    Log.writeln(ObjectModel.getCurrentSize(object));
  }
}
