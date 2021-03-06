/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2004
 */
package org.mmtk.utility.options;

import org.mmtk.plan.BasePlan;

/**
 * GCspy Tile Size.
 *
 * @author Daniel Frampton
 * @version $Revision: 1.1 $
 * @date $Date: 2004/12/16 06:13:00 $
 */
public class GCspyTileSize extends IntOption {
  /**
   * Create the option.
   */
  public GCspyTileSize() {
    super("GCspy Tile Size",
          "GCspy Tile Size",
          131072);
  }

  /**
   * Ensure the tile size is positive
   */
  protected void validate() {
    failIf(this.value <= 0, "Unreasonable gcspy tilesize");
  }
}
