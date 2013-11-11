/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2003
 */
//$Id: RCSanityEnumerator.java,v 1.5 2004/10/18 11:13:47 steveb-oss Exp $
package org.mmtk.utility.scan;

import org.mmtk.policy.RefCountLocal;

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
public class RCSanityEnumerator extends Enumerate 
  implements Uninterruptible {
  private RefCountLocal rc;

  /**
   * Constructor.
   *
   * @param plan The plan instance with respect to which the
   * enumeration will occur.
   */
  public RCSanityEnumerator(RefCountLocal rc) {
    this.rc = rc;
  }

  /**
   * Enumerate a pointer.  In this case it is a decrement event.
   *
   * @param location The address of the field being enumerated.
   */
  public void enumeratePointerLocation(Address location) 
    throws InlinePragma {
    ObjectReference object = location.loadObjectReference();
    if (!object.isNull()) {
      rc.sanityTraceEnqueue(object, location);
    }
  }
}
