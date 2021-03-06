/*
 * (C) Copyright IBM Corp. 2001
 */
//OPT_VisGraph.java
//$Id: OPT_VisGraph.java,v 1.3 2002/08/20 21:38:37 sjfink-oss Exp $
package com.ibm.JikesRVM.opt;

import java.util.Enumeration;

/**
 * OPT_VisGraph provides the minimum set of routines for graph
 * visualization.  The graph nodes and edges should implement OPT_VisNode
 * and OPT_VisEdge interfaces respectively.
 *
 * @author Igor Pechtchanski
 * @see OPT_VisNode
 * @see OPT_VisEdge
 */

public interface OPT_VisGraph {
  /**
   * Returns the nodes of the graph.
   * Each of the nodes has to implement the OPT_VisNode interface
   * @return the enumeration that would list the nodes of the graph
   */
  public Enumeration nodes();
}

