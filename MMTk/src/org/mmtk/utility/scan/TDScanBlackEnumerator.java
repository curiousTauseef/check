/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2003
 */
//$Id: TDScanBlackEnumerator.java,v 1.5 2004/10/18 11:13:47 steveb-oss Exp $
package org.mmtk.utility.scan;

import org.mmtk.utility.TrialDeletion;

import org.vmmagic.unboxed.*;
import org.vmmagic.pragma.*;

/**
 * A pointer enumeration class.  This class is used by the trial
 * deletion cycle detector to perform transitive closure of its
 * "scan black" phase.
 *
 * @author <a href="http://cs.anu.edu.au/~Steve.Blackburn">Steve Blackburn</a>
 * @version $Revision: 1.5 $
 * @date $date: $
 */
public class TDScanBlackEnumerator extends Enumerate implements Uninterruptible {
  private TrialDeletion td;

  /**
   * Constructor.
   *
   * @param plan The plan instance with respect to which the
   * enumeration will occur.
   */
  public TDScanBlackEnumerator(TrialDeletion td) {
    this.td = td;
  }

  /**
   * Enumerate a pointer.  In this case it is a scan black event.
   *
   * @param location The address of the field being enumerated.
   */
  public void enumeratePointerLocation(Address objLoc) 
    throws InlinePragma {
    td.enumerateScanBlack(objLoc.loadObjectReference());
  }
}
