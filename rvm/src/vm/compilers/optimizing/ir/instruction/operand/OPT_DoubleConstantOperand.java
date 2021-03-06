/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: OPT_DoubleConstantOperand.java,v 1.10 2005/02/25 18:48:34 dgrove-oss Exp $
package com.ibm.JikesRVM.opt.ir;

import com.ibm.JikesRVM.*;
import org.vmmagic.unboxed.Offset;

/**
 * Represents a constant double operand.
 *
 * @see OPT_Operand
 * @author John Whaley
 * @modified Mauricio Serrano 6/6/98
 */

public final class OPT_DoubleConstantOperand extends OPT_ConstantOperand implements VM_SizeConstants{

  /**
   * Value of this operand.
   */
  public double value;

  /**
   * Offset in JTOC where this double constant lives. (0 for constants
   * obtained from constant folding)
   */
  public Offset offset;

  /**
   * Constructs a new double constant operand with the specified value.
   *
   * @param v value
   */
  public OPT_DoubleConstantOperand(double v) {
    value = v;
    if (v == 0.) {
      offset = VM_Entrypoints.zeroDoubleField.getOffset();
    } else if (v == 1.) {
      offset = VM_Entrypoints.oneDoubleField.getOffset();
    } else {
      offset = Offset.zero();
    }
  }

  /**
   * Constructs a new double constant operand with the specified value and JTOC offset.
   *
   * @param v value
   * @param i offset in the jtoc
   */
  public OPT_DoubleConstantOperand(double v, Offset i) {
    value = v;
    offset = i;
  }

  /**
   * Return a new operand that is semantically equivalent to <code>this</code>.
   * 
   * @return a copy of <code>this</code>
   */
  public OPT_Operand copy() {
    return new OPT_DoubleConstantOperand(value, offset);
  }

  /**
   * Are two operands semantically equivalent?
   *
   * @param op other operand
   * @return   <code>true</code> if <code>this</code> and <code>op</code>
   *           are semantically equivalent or <code>false</code> 
   *           if they are not.
   */
  public boolean similar(OPT_Operand op) {
    return (op instanceof OPT_DoubleConstantOperand)&&
           (value == ((OPT_DoubleConstantOperand)op).value);
  }

  /**
   * Returns the string representation of this operand.
   *
   * @return a string representation of this operand.
   */
  public String toString() {
    return Double.toString(value)+"D";
  }

}
