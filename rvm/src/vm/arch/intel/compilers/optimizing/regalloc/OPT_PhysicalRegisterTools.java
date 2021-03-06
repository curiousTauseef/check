/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: OPT_PhysicalRegisterTools.java,v 1.11 2004/10/21 16:54:43 dgrove-oss Exp $
package com.ibm.JikesRVM.opt;
import com.ibm.JikesRVM.*;

import com.ibm.JikesRVM.opt.ir.*;

/**
 * This abstract class provides a set of useful methods for
 * manipulating physical registers for an IR.
 *
 * @author Jong-Deok Choi
 * @author Dave Grove
 * @author Mauricio Serrano
 * @author John Whaley
 * @author Stephen Fink
 */
abstract class OPT_PhysicalRegisterTools extends OPT_GenericPhysicalRegisterTools{

  /**
   * Return the governing IR.
   */
  abstract OPT_IR getIR();

  /**
   * Create an MIR instruction to move rhs into lhs
   */
  static OPT_Instruction makeMoveInstruction(OPT_RegisterOperand lhs, 
                                             OPT_RegisterOperand rhs) {
    if (rhs.register.isInteger() || rhs.register.isLong() || rhs.register.isAddress()) {
      if (VM.VerifyAssertions) 
        VM._assert(lhs.register.isInteger() || lhs.register.isLong() || lhs.register.isAddress());
      return MIR_Move.create(IA32_MOV, lhs, rhs);
    } else if (rhs.register.isFloatingPoint()) {
      if (VM.VerifyAssertions) 
        VM._assert(lhs.register.isFloatingPoint());
      return MIR_Move.create(IA32_FMOV, lhs, rhs);
    } else {
      OPT_OptimizingCompilerException.TODO("OPT_PhysicalRegisterTools.makeMoveInstruction");
      return null;
    }
  }
}
