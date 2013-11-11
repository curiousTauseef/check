/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2004
 */
package org.mmtk.utility.options;

/**
 * Should we use a generational approach to cycle detection?
 *
 * @author Daniel Frampton
 * @version $Revision: 1.1 $
 * @date $Date: 2004/12/16 06:13:01 $
 */
public class GenCycleDetection extends BooleanOption {
  /**
   * Create the option.
   */
  public GenCycleDetection() {
    super("Gen Cycle Detection", 
          "Should we use a generational approach to cycle detection?",
          false);
  }
}
