/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: OPT_EmptyEnumerator.java,v 1.6 2002/08/23 11:36:02 dgrove-oss Exp $
package com.ibm.JikesRVM.opt;

import  java.util.Enumeration;
import  java.util.NoSuchElementException;

/**
 * Enumeration that doesn't have any elements.
 * Use the EMPTY object to access.
 * 
 * @author Igor Pechtchanski
 */
public final class OPT_EmptyEnumerator
    implements Enumeration {
  public static final OPT_EmptyEnumerator EMPTY = new OPT_EmptyEnumerator();

  public boolean hasMoreElements () {
    return  false;
  }

  public Object nextElement () {
    throw  new NoSuchElementException();
  }

  private OPT_EmptyEnumerator () {
  }
}



