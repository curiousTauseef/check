/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2004
 */
package org.mmtk.utility.options;

/**
 * Should memory be protected on release?
 *
 * @author Daniel Frampton
 * @version $Revision: 1.1 $
 * @date $Date: 2004/12/16 06:13:01 $
 */
public class ProtectOnRelease extends BooleanOption {
  /**
   * Create the option.
   */
  public ProtectOnRelease() {
    super("Protect On Release", 
          "Should memory be protected on release?",
          false);
  }
}
