/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2004
 */
package org.mmtk.utility.options;

/**
 * Echo when options are set?
 *
 * @author Daniel Frampton
 * @version $Revision: 1.1 $
 * @date $Date: 2004/12/16 06:13:00 $
 */
public class EchoOptions extends BooleanOption {
  /**
   * Create the option.
   */
  public EchoOptions() {
    super("Echo Options", 
          "Echo when options are set?",
          false);
  }
}
