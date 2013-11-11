/*
 * (C) Copyright IBM Corp. 2002
 */
//$Id: OPT_FilteredDFSenumerateByFinish.java,v 1.5 2003/12/05 23:49:09 augart-oss Exp $
package com.ibm.JikesRVM.opt;

/**
 * @author Steve Fink
 * @date May 20, 2002
 */

class OPT_FilteredDFSenumerateByFinish extends OPT_DFSenumerateByFinish {

    private final OPT_GraphEdgeFilter filter;

    OPT_FilteredDFSenumerateByFinish(OPT_Graph net, 
                                     OPT_GraphNodeEnumeration nodes,
                                     OPT_GraphEdgeFilter filter)
    {
        super(net, nodes);
        this.filter = filter;
    }

    protected OPT_GraphNodeEnumeration getConnected (OPT_GraphNode n) {
        return filter.outNodes( n );
    }

}
