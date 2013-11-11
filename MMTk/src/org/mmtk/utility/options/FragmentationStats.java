/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2004
 */
package org.mmtk.utility.options;

/**
 * Option to print fragmentation information for the free list.
 *
 * @author Daniel Frampton
 * @version $Revision: 1.1 $
 * @date $Date: 2004/12/16 06:13:00 $
 */
public class FragmentationStats extends BooleanOption {
  /**
   * Create the option. 
   */
  public FragmentationStats() {
    super("Fragmentation Stats", 
          "Should we print fragmentation statistics for the free list allocator?",
          false);
  }
}
