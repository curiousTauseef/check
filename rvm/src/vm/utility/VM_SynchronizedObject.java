/*
 * (C) Copyright IBM Corp. 2001
 */

// $Id: VM_SynchronizedObject.java,v 1.4 2002/08/15 14:07:08 sjfink-oss Exp $
package com.ibm.JikesRVM;

/**
 * This interface designates an object which should always be allocated a
 * thin lock, since it is likely to be synchronized.
 *
 * @author Stephen Fink
 */
public interface VM_SynchronizedObject {
}
