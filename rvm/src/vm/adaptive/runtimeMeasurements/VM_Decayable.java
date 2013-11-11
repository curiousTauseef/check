/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: VM_Decayable.java,v 1.4 2002/08/27 02:45:16 hind-oss Exp $
package com.ibm.JikesRVM.adaptive;

/**
 *  This interface defines the decay method.  Implementors are 
 *  eligible for decay if they register with the 
 *  VM_RuntimeMeasurements class.
 *
 *  @author Michael Hind
 */

interface VM_Decayable {

  /**
   *  Called periodically when it is time to decay runtime mesaurment data
   */
  public void decay();

}





