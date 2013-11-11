/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2004
 */
package org.mmtk.vm;

import org.mmtk.plan.*;


/**
 * $Id: Plan.java,v 1.2 2005/01/18 03:22:03 steveb-oss Exp $ 
 *
 * @author <a href="http://cs.anu.edu.au/~Steve.Blackburn">Steve Blackburn</a>
 * @author Perry Cheng
 * @author <a href="http://www.cs.ukc.ac.uk/~rej">Richard Jones</a>
 *
 * @version $Revision: 1.2 $
 * @date $Date: 2005/01/18 03:22:03 $
 */
public class Plan extends SemiSpace {

  /***********************************************************************
   *
   * Class variables
   */

  /**
   * <code>true</code> if built with GCSpy
   */
  public static final boolean WITH_GCSPY = false;

  /**
   * Gets the plan instance associated with the current processor.
   *
   * @return the plan instance for the current processor
   */
  public static Plan getInstance() 
  {
    return null;
  }
}
