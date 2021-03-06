/*
 * (C) Copyright IBM Corp. 2002
 */
//$Id: OPT_ReverseFilteredDFSenumerateByFinish.java,v 1.5 2003/12/05 23:49:09 augart-oss Exp $
package com.ibm.JikesRVM.opt;

/**
 * @author Julian Dolby
 * @date May 20, 2002
 */

class OPT_ReverseFilteredDFSenumerateByFinish extends OPT_ReverseDFSenumerateByFinish {

    private final OPT_GraphEdgeFilter filter;

    OPT_ReverseFilteredDFSenumerateByFinish(OPT_Graph net, 
                                            OPT_GraphNodeEnumeration nodes,
                                            OPT_GraphEdgeFilter filter)
    {
        super(net, nodes);
        this.filter = filter;
    }

    protected OPT_GraphNodeEnumeration getConnected (OPT_GraphNode n) {
        return filter.inNodes( n );
    }

}
