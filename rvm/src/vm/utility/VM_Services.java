/*
 * (C) Copyright IBM Corp. 2001
 */

// $Id: VM_Services.java,v 1.7 2004/09/09 06:34:03 steveb-oss Exp $
package com.ibm.JikesRVM;

import org.vmmagic.pragma.*;

/**
 *  Various service utilities.  This is a common place for some shared utility routines
 *
 * @author Janice Shepherd
 * @date 28 Nov 2001
 */
public class VM_Services {

  /**
   * Utility printing function.
   * @param i
   * @param blank
   */
  public static String getHexString(int i, boolean blank) {
    StringBuffer buf = new StringBuffer(8);
    for (int j = 0; j < 8; j++, i <<= 4) {
      int n = i >>> 28;
      if (blank && (n == 0) && (j != 7)) {
        buf.append(' ');
      } else {
        buf.append(Character.forDigit(n, 16));
        blank = false;
      }
    }
    return buf.toString();
  }
  
  public static void breakStub() throws NoInlinePragma {
  }
}
