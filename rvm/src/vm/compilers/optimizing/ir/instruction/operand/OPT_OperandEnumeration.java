/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: OPT_OperandEnumeration.java,v 1.4 2002/08/23 11:28:44 dgrove-oss Exp $
package com.ibm.JikesRVM.opt.ir;

/**
 * Extend java.util.Enumeration to avoid downcasts from object.
 *
 * @author Igor Pechtchanski
 */
public interface OPT_OperandEnumeration extends java.util.Enumeration {
  /** Same as nextElement but avoid the need to downcast from Object */
  public OPT_Operand next();
}

