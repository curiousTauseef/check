/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2004
 */
package org.mmtk.policy;

import org.mmtk.utility.alloc.BumpPointer;

import org.vmmagic.pragma.*;

/**
 * This class implements unsynchronized (local) elements of an
 * immortal space. Allocation is via the bump pointer 
 * (@see BumpPointer). 
 *
 * @see BumpPointer
 * @see ImmortalSpace 
 *
 * @author Daniel Frampton
 * @author <a href="http://cs.anu.edu.au/~Steve.Blackburn">Steve Blackburn</a>
 * @version $Revision: 1.1 $
 * @date $Date: 2004/11/18 04:56:39 $
 */
public final class ImmortalLocal extends BumpPointer 
  implements Uninterruptible  {
  public final static String Id = "$Id: ImmortalLocal.java,v 1.1 2004/11/18 04:56:39 steveb-oss Exp $"; 

  /**
   * Constructor
   *
   * @param space The space to bump point into.
   */
  public ImmortalLocal(ImmortalSpace space) {
    super(space, true);
  }

  /**
   * Re-associate this bump pointer with a different space. Also 
   * reset the bump pointer so that it will use the new space
   * on the next call to <code>alloc</code>.
   *
   * @param space The space to associate the bump pointer with.
   */
  public void rebind(ImmortalSpace space) {
    super.rebind(space);
  }
}
