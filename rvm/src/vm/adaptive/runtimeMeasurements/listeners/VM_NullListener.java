/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: VM_NullListener.java,v 1.6 2004/09/09 06:33:41 steveb-oss Exp $
package com.ibm.JikesRVM.adaptive;

import org.vmmagic.pragma.*;

/**
 * A VM_NullListener is an object that is invoked when
 * online measurement information must be collected.
 *
 * Defines update's interface.
 *
 * @author Peter Sweeney
 * @date   2 June 2000
 */

abstract class VM_NullListener extends VM_Listener implements Uninterruptible {
  /**
   * Entry point when listener is awoken.
   * @param whereFrom Was this a yieldpoint in a PROLOGUE, BACKEDGE, or
   *             EPILOGUE?
   */
  abstract public void update(int whereFrom);
}
