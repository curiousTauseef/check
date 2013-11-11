/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2004
 */
package org.mmtk.utility.options;

/**
 * Should we shrink/grow the heap to adjust to application working set?
 *
 * @author Daniel Frampton
 * @version $Revision: 1.1 $
 * @date $Date: 2004/12/16 06:13:01 $
 */
public class VariableSizeHeap extends BooleanOption {
  /**
   * Create the option.
   */
  public VariableSizeHeap() {
    super("Variable Size Heap", 
          "Should we shrink/grow the heap to adjust to application working set?",
          true);
  }
}
