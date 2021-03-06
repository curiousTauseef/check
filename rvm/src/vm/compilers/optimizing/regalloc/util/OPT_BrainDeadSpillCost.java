/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: OPT_BrainDeadSpillCost.java,v 1.5 2002/08/23 11:35:24 dgrove-oss Exp $
package com.ibm.JikesRVM.opt;

import com.ibm.JikesRVM.opt.ir.OPT_IR;

/**
 * An object that returns an estimate of the relative cost of spilling a 
 * symbolic register.
 *
 * This implementation returns a cost of zero for all registers.
 *
 * @author Stephen Fink
 */
class OPT_BrainDeadSpillCost extends OPT_SpillCostEstimator {

  OPT_BrainDeadSpillCost(OPT_IR ir) {
    calculate(ir);
  }

  /**
   * Calculate the estimated cost for each register.
   * This brain-dead version does nothing.
   */
  void calculate(OPT_IR ir) {
  }
}
