/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2004
 */
package org.mmtk.utility.options;

/**
 * Should finalization be disabled?
 *
 * @author Daniel Frampton
 * @version $Revision: 1.1 $
 * @date $Date: 2004/12/16 06:13:01 $
 */
public class NoFinalizer extends BooleanOption {
  /**
   * Create the option.
   */
  public NoFinalizer() {
    super("No Finalizer", 
          "Should finalization be disabled?",
          false);
  }
}
