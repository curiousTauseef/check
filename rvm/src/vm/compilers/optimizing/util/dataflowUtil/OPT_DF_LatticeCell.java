/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: OPT_DF_LatticeCell.java,v 1.5 2002/08/20 21:37:33 sjfink-oss Exp $
package com.ibm.JikesRVM.opt;

import  java.util.*;

/**
 * OPT_DF_LatticeCell.java
 *
 * Represents a single lattice cell in a dataflow equation system.
 *
 * @author Stephen Fink
 */
interface OPT_DF_LatticeCell extends OPT_GraphNode {

  /** 
   * Returns an enumeration of the equations in which this
   * lattice cell is used.
   * @return an enumeration of the equations in which this
   * lattice cell is used
   */
  public java.util.Iterator getUses ();

  /** 
   * Returns an enumeration of the equations in which this
   * lattice cell is defined.
   * @return an enumeration of the equations in which this
   * lattice cell is defined
   */
  public java.util.Iterator getDefs ();

  /** 
   * Return a string representation of the cell
   * @return a string representation of the cell
   */
  public abstract String toString ();

  /** 
   * Note that this variable appears on the RHS of an equation 
   *
   * @param eq the equation
   */
  public void addUse (OPT_DF_Equation eq);

  /** 
   * Note that this variable appears on the LHS of an equation 
   *
   * @param eq the equation
   */
  public void addDef (OPT_DF_Equation eq);
}



