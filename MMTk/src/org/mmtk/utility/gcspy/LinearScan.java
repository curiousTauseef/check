/*
 * (C) Copyright Richard Jones, 2004
 * Computing Laboratory, University of Kent at Canterbury
 * All rights reserved.
 */
package org.mmtk.utility.gcspy;

import org.mmtk.utility.gcspy.drivers.AbstractDriver;

import org.vmmagic.unboxed.*;
import org.vmmagic.pragma.*;

/**
 * This class is only necessary because we cannot implement 
 * org.mmtk.utility.alloc.LinearScan as an interface since the invokeinterface
 * bytecode is forbidden in uninterruptibel code. Yuck!
 *
 * $Id: LinearScan.java,v 1.1 2004/12/06 05:25:21 steveb-oss Exp $
 *
 * @author <a href="http://www.ukc.ac.uk/people/staff/rej">Richard Jones</a>
 * @version $Revision: 1.1 $
 * @date $Date: 2004/12/06 05:25:21 $
 */
public class LinearScan extends org.mmtk.utility.alloc.LinearScan
  implements Uninterruptible {
  
  private final AbstractDriver driver;

  public LinearScan (AbstractDriver d) { driver = d; }

  public void scan(ObjectReference obj) { driver.scan(obj);  }
}
  
