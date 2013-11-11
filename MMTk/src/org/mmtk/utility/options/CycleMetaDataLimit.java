/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2004
 */
package org.mmtk.utility.options;

/**
 * Trigger cycle detection if the meta data volume grows to this limit.
 *
 * @author Daniel Frampton
 * @version $Revision: 1.1 $
 * @date $Date: 2004/12/16 06:13:00 $
 */
public class CycleMetaDataLimit extends PagesOption {
  /**
   * Create the option.
   */
  public CycleMetaDataLimit() {
    super("Cycle Meta Data Limit", 
          "Trigger cycle detection if the meta data volume grows to this limit",
          4096);
  }
}
