/*
 * (C) Copyright IBM Corp 2003
 */
//$Id: WeakReference.java,v 1.4 2004/02/07 03:49:22 steveb-oss Exp $
package java.lang.ref;

import com.ibm.JikesRVM.memoryManagers.mmInterface.MM_Interface;

/**
 * Implementation of java.lang.ref.WeakReference for JikesRVM.
 * 
 * @author Chris Hoffmann
 * @see java.util.WeakHashMap
 */
public class WeakReference extends Reference {

  public WeakReference(Object referent) {
    super(referent);
    MM_Interface.addWeakReference(this);
  }

  public WeakReference(Object referent, ReferenceQueue q) {
    super(referent, q);
    MM_Interface.addWeakReference(this);
  }

}
