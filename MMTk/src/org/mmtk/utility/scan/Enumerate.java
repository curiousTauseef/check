/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2003
 */
//$Id: Enumerate.java,v 1.4 2004/09/09 06:33:55 steveb-oss Exp $
package org.mmtk.utility.scan;

import org.vmmagic.unboxed.*;
import org.vmmagic.pragma.*;

/**
 * Callbacks from ScanObject to Plan.enumeratePointerLocation are
 * dispatched through an object of this class, so that we have the
 * opportunity to change the behaviour through sub-classing. <p>
 *
 * @author Robin Garner
 * @version $Revision: 1.4 $
 * @date    $Date: 2004/09/09 06:33:55 $
 */

abstract public class Enumerate implements Uninterruptible {
  abstract public void enumeratePointerLocation(Address location);
}
