/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2004
 */
package org.mmtk.utility.options;

/**
 * When printing statistics, should statistics for each gc-mutator phase be printed?
 *
 * @author Daniel Frampton
 * @version $Revision: 1.1 $
 * @date $Date: 2004/12/16 06:13:01 $
 */
public class PrintPhaseStats extends BooleanOption {
  /**
   * Create the option.
   */
  public PrintPhaseStats() {
    super("Print Phase Stats", 
          "When printing statistics, should statistics for each gc-mutator phase be printed?",
          false);
  }
}
