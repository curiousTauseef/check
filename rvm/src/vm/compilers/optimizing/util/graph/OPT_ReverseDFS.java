/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: OPT_ReverseDFS.java,v 1.5 2002/08/20 21:38:06 sjfink-oss Exp $
package com.ibm.JikesRVM.opt;

/**
 * @author Mauricio J. Serrano
 * @author John Whaley
 */
class OPT_ReverseDFS extends OPT_DFS {

  OPT_ReverseDFS (OPT_Graph net) {
    super(net);
  }

  OPT_ReverseDFS (OPT_GraphNodeEnumeration nodes) {
    super(nodes);
  }

  protected OPT_GraphNodeEnumeration getConnected (OPT_GraphNode n) {
    return  n.inNodes();
  }
}
