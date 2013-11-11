/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: OPT_BitSetMapping.java,v 1.4 2002/08/20 21:39:05 sjfink-oss Exp $
package com.ibm.JikesRVM.opt;

/** 
 * An object that implements a bijection between whole numbers and
 * objects.
 *
 * @author Stephen Fink
 */
public interface OPT_BitSetMapping {
  /**
   * Return the object numbered n.
   */
  public Object getMappedObject(int n);

  /**
   * Return the number of a given object.
   */
  public int getMappedIndex(Object o);

  /**
   * Return the size of the domain of the bijection. 
   */
  public int getMappingSize();
}
