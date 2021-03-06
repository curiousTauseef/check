/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: TypeComparator.java,v 1.4 2003/01/09 13:03:31 dgrove-oss Exp $

import com.ibm.JikesRVM.classloader.VM_Type;

/**
 * @author Perry Cheng
 */
class TypeComparator implements java.util.Comparator {
    
  public int compare (Object a, Object b) {
    if (a == null) return 1;
    if (b == null) return -1;
    if ((a instanceof VM_Type) && (b instanceof VM_Type)) {
      VM_Type aa = (VM_Type) a;
      VM_Type bb = (VM_Type) b;
      if (aa.bootBytes > bb.bootBytes) return -1;
      if (aa.bootBytes < bb.bootBytes) return 1;
      return 0;
    }
    return 0;
  }
}
