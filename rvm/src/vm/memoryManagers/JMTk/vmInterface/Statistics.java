/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2004
 *
 * (C) Copyright IBM Corp. 2001, 2003
 */
package org.mmtk.vm;

import org.mmtk.utility.Constants;
import com.ibm.JikesRVM.VM_Time;
import com.ibm.JikesRVM.memoryManagers.mmInterface.MM_Interface;

import org.vmmagic.unboxed.*;
import org.vmmagic.pragma.*;

/**
 * $Id: Statistics.java,v 1.17 2005/01/19 02:49:05 steveb-oss Exp $ 
 *
 * @author <a href="http://cs.anu.edu.au/~Steve.Blackburn">Steve Blackburn</a>
 * @author Perry Cheng
 *
 * @version $Revision: 1.17 $
 * @date $Date: 2005/01/19 02:49:05 $
 */
public class Statistics implements Constants, Uninterruptible {
  /**
   * Returns the number of collections that have occured.
   *
   * @return The number of collections that have occured.
   */
  public static final int getCollectionCount()
    throws UninterruptiblePragma {
    return MM_Interface.getCollectionCount();
  }

  /**
   * Read cycle counter
   */
  public static long cycles() {
    return VM_Time.cycles();
  }

  /**
   * Convert cycles to milliseconds
   */
  public static double cyclesToMillis(long c) {
    return VM_Time.cyclesToMillis(c);
  }

  /**
   * Convert cycles to seconds
   */
  public static double cyclesToSecs(long c) {
    return VM_Time.cyclesToSecs(c);
  }

  /**
   * Convert milliseconds to cycles
   */
  public static long millisToCycles(double t) {
    return VM_Time.millisToCycles(t);
  }

  /**
   * Convert seconds to cycles
   */
  public static long secsToCycles(double t) {
    return VM_Time.secsToCycles(t);
  }
}
