/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: OPT_GraphEdge.java,v 1.4 2002/08/20 21:37:57 sjfink-oss Exp $
package com.ibm.JikesRVM.opt;

/**
 *  Graph representations that use explicit ede objects should have
 * their edge objects implement this interface.
 *
 * @author Mauricio J. Serrano
 * @author John Whaley
 */
interface OPT_GraphEdge {

    OPT_GraphNode from();

    OPT_GraphNode to();

}



