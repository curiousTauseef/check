/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2004
 */
package org.mmtk.utility.options;

import org.mmtk.plan.BasePlan;

/**
 * Provide an lower and upper bound on nursery size. This option is not intended to
 * be created directly, but via NurserySize.
 *
 * @author Daniel Frampton
 * @version $Revision: 1.1 $
 * @date $Date: 2004/12/16 06:13:00 $
 */
public class FixedNursery extends PagesOption {
  // values
  BoundedNursery boundedNursery;

  /**
   * Create the option
   */
  public FixedNursery(BoundedNursery boundedNursery) {
    super("Fixed Nursery",
          "Fix the minimum and maximum size of the nursery to this value",
          BasePlan.DEFAULT_MIN_NURSERY);
    this.boundedNursery = boundedNursery; 
  }

  /**
   * Nursery can not be empty.
   */ 
  protected void validate() {
    failIf(value <= 0, "Can not have an empty nursery"); 
    // Update upper bound.
    boundedNursery.setBytes(this.getBytes());
  }
}
