/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2003
 */
package org.mmtk.utility;

import org.mmtk.utility.options.*;

import org.vmmagic.unboxed.*;
import org.vmmagic.pragma.*;

/*
 * @author <a href="http://cs.anu.edu.au/~Steve.Blackburn">Steve Blackburn</a>
 * @version $Revision: 1.15 $
 * @date $Date: 2004/12/16 06:12:59 $
 */
abstract class CycleDetector implements Uninterruptible {
  public final static String Id = "$Id: CycleDetector.java,v 1.15 2004/12/16 06:12:59 steveb-oss Exp $"; 

  protected static CycleFilterThreshold cycleFilterThreshold;
  protected static CycleMetaDataLimit cycleMetaDataLimit;
  protected static CycleTriggerThreshold cycleTriggerThreshold;

  static {
    cycleFilterThreshold = new CycleFilterThreshold();
    cycleMetaDataLimit = new CycleMetaDataLimit();
    cycleTriggerThreshold = new CycleTriggerThreshold();
  }

  abstract boolean collectCycles(int count, boolean time);
  abstract void possibleCycleRoot(ObjectReference object);
}
