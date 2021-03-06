/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: OPT_GraphElement.java,v 1.5 2002/08/20 21:38:01 sjfink-oss Exp $
package com.ibm.JikesRVM.opt;

/**
 *  Many clients of graph methods expect their graph nodes to
 * implement a pair of scratch fields, one of int type and one of
 * object type.  This is a fairly evil thing to do, but it is deeply
 * embedded in many places, and this interface can be used for such
 * clients.  It is not recommended, to put it mildly.
 *
 * @deprecated
 *
 * @see OPT_Graph
 *
 * @author Julian Dolby
 *
 */
interface OPT_GraphElement {

  /** 
   * read the scratch field of object type
   * @return the contents of the Object scratch field
   * @deprecated
   */
  Object getScratchObject ();

  /** 
   * set the scratch field of object type
   * @param obj the new contents of the Object scratch field
   * @deprecated
   */
  Object setScratchObject (Object obj);

  /** 
   * read the scratch field of int type
   * @return the contents of the int scratch field
   * @deprecated
   */
  int getScratch ();

  /** 
   * set the scratch field of int type
   * @param scratch the new contents of the int scratch field
   * @deprecated
   */
  int setScratch (int scratch);
}
