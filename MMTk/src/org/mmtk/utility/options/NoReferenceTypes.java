/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2004
 */
package org.mmtk.utility.options;

/**
 * Should reference type processing be disabled?
 *
 * @author Daniel Frampton
 * @version $Revision: 1.1 $
 * @date $Date: 2004/12/16 06:13:01 $
 */
public class NoReferenceTypes extends BooleanOption {
  /**
   * Create the option.
   */
  public NoReferenceTypes() {
    super("No Reference Types", 
          "Should reference type processing be disabled?",
          false);
  }
}
