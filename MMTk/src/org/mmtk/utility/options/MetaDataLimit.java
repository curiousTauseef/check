/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2004
 */
package org.mmtk.utility.options;

/**
 * Provide a bound on how much metadata is allowed before a GC is triggered.
 *
 * @author Daniel Frampton
 * @version $Revision: 1.1 $
 * @date $Date: 2004/12/16 06:13:01 $
 */
public class MetaDataLimit extends PagesOption {
  /**
   * Create the option.
   */
  public MetaDataLimit() {
    super("Meta Data Limit", 
          "Trigger a GC if the meta data volume grows to this limit",
          4096);
  }
}
