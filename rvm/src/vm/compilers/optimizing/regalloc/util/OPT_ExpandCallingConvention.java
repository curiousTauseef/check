/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: OPT_ExpandCallingConvention.java,v 1.4 2002/08/23 11:35:26 dgrove-oss Exp $
package com.ibm.JikesRVM.opt;


/**
 *  Phase for expanding the calling convention
 *  @author Michael Hind
 */
final class OPT_ExpandCallingConvention extends OPT_CompilerPhase {

  public boolean printingEnabled (OPT_Options options, boolean before) {
    return  options.PRINT_CALLING_CONVENTIONS && !before;
  }

  public final String getName() { 
    return "Expand Calling Convention"; 
  }

  public final void perform(com.ibm.JikesRVM.opt.ir.OPT_IR ir)  {
    OPT_CallingConvention.expandCallingConventions(ir);
  }
}
