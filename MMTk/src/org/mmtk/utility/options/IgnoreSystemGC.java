/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2004
 */
package org.mmtk.utility.options;

/**
 * Should we ignore calls to java.lang.System.gc?
 * 
 * @author Daniel Frampton
 * @version $Revision: 1.1 $
 * @date $Date: 2004/12/16 06:13:01 $
 */
public class IgnoreSystemGC extends BooleanOption {
  /**
   * Create the option.
   */
  public IgnoreSystemGC() {
    super("Ignore System GC", 
          "Should we ignore calls to java.lang.System.gc?",
          false);
  }
}
