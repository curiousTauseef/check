/*
 * (C) Copyright IBM Corp. 2001
 */
// $Id: VM_MachineCode.java,v 1.6 2003/09/25 16:55:12 dgrove-oss Exp $
package com.ibm.JikesRVM;

/** 
 * @author Julian Dolby
 */
public class VM_MachineCode {
  private VM_CodeArray instructions;
  private int[] bytecodeMap;

  public VM_MachineCode (VM_CodeArray i, int[] bm) {
    instructions = i;
    bytecodeMap  = bm;
  }

  public final VM_CodeArray getInstructions () {
    return instructions;
  }

  public final int[] getBytecodeMap () {
    return bytecodeMap;
  }

  //-#if RVM_WITH_OSR
  public void setBytecodeMap(int b2m[]) {
    bytecodeMap = b2m;
  }
  //-#endif
}
