/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: OPT_CompoundEnumerator.java,v 1.5 2002/08/23 11:36:00 dgrove-oss Exp $
package com.ibm.JikesRVM.opt;

import java.util.*;

/** 
 * @author Mauricio J. Serrano
 * @author John Whaley
 */
public class OPT_CompoundEnumerator implements Enumeration {
  private final Enumeration first;    
  private final Enumeration second;

  public OPT_CompoundEnumerator(Enumeration first, Enumeration second) {
    this.first = first;
    this.second = second;
  }

  public boolean hasMoreElements() {
    return first.hasMoreElements()||second.hasMoreElements();
  }

  public Object nextElement() {
    if (first.hasMoreElements())
      return first.nextElement();
    else
      return second.nextElement();
  }
}
