/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2004
 */
package org.mmtk.utility.options;

/**
 * Should the VM wait for the visualiser to connect?
 *
 * @author Daniel Frampton
 * @version $Revision: 1.1 $
 * @date $Date: 2004/12/16 06:13:00 $
 */
public class GCspyWait extends BooleanOption {
  /**
   * Create the option
   */
  public GCspyWait() {
    super("GCSpy Wait", 
          "Should the VM wait for the visualiser to connect?",
          false);
  }
}
