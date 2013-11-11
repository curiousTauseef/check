/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: OPT_AggregateReplacer.java,v 1.4 2002/08/20 21:34:33 sjfink-oss Exp $
package com.ibm.JikesRVM.opt;

/**
 * Class that performs scalar replacement of aggregates
 *
 * @author Stephen Fink
 */
public interface OPT_AggregateReplacer {

  /** 
   * Perform the transformation
   */
  public abstract void transform ();
}
