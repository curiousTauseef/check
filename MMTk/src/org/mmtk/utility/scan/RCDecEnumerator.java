/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2003
 */
//$Id: RCDecEnumerator.java,v 1.5 2004/09/18 03:59:12 steveb-oss Exp $
package org.mmtk.utility.scan;

import org.mmtk.vm.Plan;

import org.vmmagic.unboxed.*;
import org.vmmagic.pragma.*;

/**
 * A pointer enumeration class.  This class is used by the reference
 * counting collector to do recursive decrement.
 *
 * @author Ian Warrington
 * @version $Revision: 1.5 $
 * @date $date: $
 */
public class RCDecEnumerator extends Enumerate implements Uninterruptible {
  /**
   * Enumerate a pointer.  In this case it is a decrement event.
   *
   * @param location The address of the field being enumerated.
   */
  public void enumeratePointerLocation(Address location) throws InlinePragma {
    Plan.getInstance().enumerateDecrementPointerLocation(location);
  }
}
