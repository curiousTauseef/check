/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: OPT_EmptyIterator.java,v 1.6 2002/08/20 21:39:10 sjfink-oss Exp $
package com.ibm.JikesRVM.opt;

/**
 * @author Mauricio J. Serrano
 * @author John Whaley
 */
class OPT_EmptyIterator implements java.util.Iterator {

  public boolean hasNext () {
    return  false;
  }

  public Object next () {
    throw  new java.util.NoSuchElementException();
  }

  public void remove () {
    throw new OPT_OptimizingCompilerException("EmptyIterator.remove called");
  }

  public static OPT_EmptyIterator INSTANCE = new OPT_EmptyIterator();
}



