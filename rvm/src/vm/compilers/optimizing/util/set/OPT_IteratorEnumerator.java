/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: OPT_IteratorEnumerator.java,v 1.6 2002/08/20 21:39:18 sjfink-oss Exp $
package com.ibm.JikesRVM.opt;

/**
 * An <code>IteratorEnumerator</code> converts an <code>Iterator</code>
 * into an <code>Enumeration</code>.
 *
 * @author Stephen Fink
 */
public class OPT_IteratorEnumerator
    implements java.util.Enumeration {
  private final java.util.Iterator i;

  public OPT_IteratorEnumerator(java.util.Iterator i) {
    this.i = i;
  }

  public boolean hasMoreElements() {
    return  i.hasNext();
  }

  public Object nextElement() {
    return  i.next();
  }
}
