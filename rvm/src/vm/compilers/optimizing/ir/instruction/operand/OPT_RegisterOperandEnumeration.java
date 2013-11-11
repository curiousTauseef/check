/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: OPT_RegisterOperandEnumeration.java,v 1.4 2002/08/23 11:28:47 dgrove-oss Exp $
package com.ibm.JikesRVM.opt.ir;

/**
 * Extend java.util.Enumeration to avoid downcasts from object.
 *
 * @author Dave Grove
 */
public interface OPT_RegisterOperandEnumeration extends java.util.Enumeration {
  /** Same as nextElement but avoid the need to downcast from Object */
  public OPT_RegisterOperand next();
}

