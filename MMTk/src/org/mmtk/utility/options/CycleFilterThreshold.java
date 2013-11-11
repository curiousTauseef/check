/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2004
 */
package org.mmtk.utility.options;

/**
 * Trigger cycle buffer filtering if the space available falls below this threshold. 
 *
 * @author Daniel Frampton
 * @version $Revision: 1.1 $
 * @date $Date: 2004/12/16 06:13:00 $
 */
public class CycleFilterThreshold extends PagesOption {
  /**
   * Create the option.
   */
  public CycleFilterThreshold() {
    super("Cycle Filter Threshold", 
          "Trigger cycle buffer filtering if the space available falls below this threshold",
          512);
  }
}
