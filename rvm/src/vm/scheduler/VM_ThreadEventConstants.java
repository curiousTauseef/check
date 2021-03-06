/*
 * (C) Copyright IBM Corp. 2002
 */
// $Id: VM_ThreadEventConstants.java,v 1.3 2003/08/22 13:10:46 dgrove-oss Exp $

package com.ibm.JikesRVM;

/**
 * Constants specifying the state of a {@link VM_Thread} waiting
 * on a {@link VM_ThreadEventWaitQueue}. 
 *
 * @author David Hovemeyer
 *
 * @see VM_ThreadEventWaitQueue
 */
public interface VM_ThreadEventConstants {
  /**
   * Thread is waiting on the queue.
   */
  public static final int WAIT_PENDING = 0;

  /**
   * Set if thread is suspended while executing native code.
   */
  public static final int WAIT_NATIVE = 1;

  /**
   * Set if thread has been marked to be taken off the wait queue.
   * Possible reasons:
   * <ul>
   * <li> the event it was waiting for occurred,
   * <li> the wait timed out, or
   * <li> the thread was interrupted
   * </ul>
   */
  public static final int WAIT_FINISHED = 2;

  /**
   * The event wait timed out.
   */
  public static final int WAIT_TIMEOUT = 4;

  /**
   * The thread was interrupted before the event or the timeout occurred.
   */
  public static final int WAIT_INTERRUPTED = 8;

  /**
   * Used to specify that a wait should block indefinitely
   * (i.e., no timeout).
   */
  public static final long WAIT_INFINITE = -1;
}
