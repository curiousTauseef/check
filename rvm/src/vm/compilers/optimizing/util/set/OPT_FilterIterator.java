/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: OPT_FilterIterator.java,v 1.7 2002/08/20 21:39:17 sjfink-oss Exp $
package com.ibm.JikesRVM.opt;

/**
 * A <code>FilterIterator</code> filters and maps a source
 * <code>Iterator</code> to generate a new one.
 *
 * @author Mauricio J. Serrano
 * @author John Whaley
 */
public class OPT_FilterIterator
    implements java.util.Iterator {
  final java.util.Iterator i;
  final Filter f;
  private Object next = null;
  private boolean done = false;

  public OPT_FilterIterator(java.util.Iterator i, Filter f) {
    this.i = i;
    this.f = f;
    advance();
  }

  private void advance() {
    while (i.hasNext()) {
      next = i.next();
      if (f.isElement(next))
        return;
    }
    done = true;
  }

  public Object next() {
    if (done)
      throw  new java.util.NoSuchElementException();
    Object o = next;
    advance();
    return  f.map(o);
  }

  public boolean hasNext() {
    return  !done;
  }

  public void remove () {
    throw  new java.lang.UnsupportedOperationException();
  }

  public static class Filter {                  // override with your mapping.

    public boolean isElement(Object o) {
      return  true;
    }

    public Object map(Object o) {
      return  o;
    }
  }
}
