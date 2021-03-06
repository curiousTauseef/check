/*
 * (C) Copyright IBM Corp. 2002
 */
//$Id: VM_TimeoutException.java,v 1.1 2002/10/08 21:25:07 dolby-oss Exp $

package com.ibm.JikesRVM;

/**
 * Exception to indicate that a blocking call has timed out.
 * This is purposely not a subtype of any library exception class,
 * because in the context of the VM it is sometimes not possible
 * to know what the calling method wants.  For example, InterruptedException,
 * SocketTimeoutException, etc.
 *
 * @author David Hovemeyer
 */
public class VM_TimeoutException extends Exception {
  public VM_TimeoutException(String msg) {
    super(msg);
  }
}
