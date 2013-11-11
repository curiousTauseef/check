/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: OPT_InlineOracle.java,v 1.5 2002/08/23 11:34:36 dgrove-oss Exp $
package com.ibm.JikesRVM.opt;

/**
 * Oracle interface: the compiler queries this oracle to decide whether
 * to inline a call site.
 *
 * @author Stephen Fink
 */
public interface OPT_InlineOracle {

  /**
   * Should we inline a particular call site?
   * @param state information needed to make the inlining decision
   * @return an OPT_InlineDecision with the result
   */
  public OPT_InlineDecision shouldInline (com.ibm.JikesRVM.opt.ir.OPT_CompilationState state);
}



