/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: VM_JNIConstants.java,v 1.6 2004/06/17 21:34:42 augart-oss Exp $
package com.ibm.JikesRVM.jni;

/**
 * Constants for JNI support
 *
 * @author Ton Ngo
 * @author Steve Smith
 */
interface VM_JNIConstants {
  //-#if RVM_WITH_POWEROPEN_ABI
  // index of IP in the linkage triplet
  static final int IP = 0;                    

  // index of TOC in the linkage triplet
  static final int TOC = 1;
  //-#endif
}

