/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: VM_Reportable.java,v 1.4 2002/08/27 02:45:16 hind-oss Exp $
package com.ibm.JikesRVM.adaptive;

/**
 * Interface for all reportable objects that are managed by the runtime
 * measurements.
 *
 * @author Peter Sweeney
 */

interface VM_Reportable { 
  /**
   * generate a report
   */
  void report(); 
  /**
   * reset (clear) data set being gathered
   */
  void reset();  
}







