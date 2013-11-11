/*
 * (C) Copyright IBM Corp. 2002
 */
//$Id: OPT_GraphEdgeFilter.java,v 1.4 2002/08/20 21:37:59 sjfink-oss Exp $
package com.ibm.JikesRVM.opt;

/**
 * @author Julian Dolby
 * @date May 20, 2002
 */

interface OPT_GraphEdgeFilter {

    OPT_GraphNodeEnumeration inNodes(OPT_GraphNode node);

    OPT_GraphNodeEnumeration outNodes(OPT_GraphNode node);

}
