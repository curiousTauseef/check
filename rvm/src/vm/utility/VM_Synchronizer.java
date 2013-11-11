/*
 * (C) Copyright IBM Corp. 2001
 */

// $Id: VM_Synchronizer.java,v 1.4 2002/08/15 14:07:09 sjfink-oss Exp $
package com.ibm.JikesRVM;

/**
 * This class defines an object which should always be allocated a
 * thin lock, since it is likely to be synchronized.
 *
 * @author Stephen Fink
 */
public class VM_Synchronizer implements VM_SynchronizedObject {
}
