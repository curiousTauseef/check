/*
 * (C) Copyright IBM Corp 2003
 */
//$Id: SoftReference.java,v 1.3 2004/02/07 03:49:22 steveb-oss Exp $
package java.lang.ref;

import com.ibm.JikesRVM.memoryManagers.mmInterface.MM_Interface;

/**
 * Implementation of java.lang.ref.SoftReference for JikesRVM.
 * @author Chris Hoffmann
 */
public class SoftReference extends Reference {

  public SoftReference(Object referent) {
    super(referent);
    MM_Interface.addSoftReference(this);
  }

  public SoftReference(Object referent, ReferenceQueue q) {
    super(referent, q);
    MM_Interface.addSoftReference(this);
  }
  
}
