/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: OPT_GraphNodeEnumeration.java,v 1.4 2002/08/20 21:38:03 sjfink-oss Exp $
package com.ibm.JikesRVM.opt;

/**
 *  Generic interface for enumerations of graph nodes.  All graph
 * implementations should make sure that their enumerations of graph
 * nodes implement this interface, and all graph utilities that need
 * to enumerate nodes should use this interface.
 *
 * @author Julian Dolby
 *
 * @see OPT_Graph
 * @see OPT_GraphNode
 */
interface OPT_GraphNodeEnumeration extends java.util.Enumeration
{

  /**
   *  Return the next graph node in the enumeration.
   * @return the next graph node in the enumeration
   */
  OPT_GraphNode next ();
}



