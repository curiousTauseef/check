/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: OPT_SingletonSet.java,v 1.6 2002/08/20 21:39:24 sjfink-oss Exp $
package com.ibm.JikesRVM.opt;

/**
 * @author Mauricio J. Serrano
 * @author John Whaley
 */
class OPT_SingletonSet extends java.util.AbstractSet {
  Object o;

  OPT_SingletonSet (Object o) {
    this.o = o;
  }

  public boolean contains (Object o) {
    return  this.o == o;
  }

  public int hashCode () {
    return  this.o.hashCode();
  }

  public java.util.Iterator iterator () {
    return  new OPT_SingletonIterator(o);
  }

  public int size () {
    return  1;
  }

  public Object[] toArray() {
    Object[] a = new Object[1];
    a[0] = o;
    return  a;
  }
}
