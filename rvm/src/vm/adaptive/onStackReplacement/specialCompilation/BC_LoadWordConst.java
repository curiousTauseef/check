/*
 * (C) Copyright IBM Corp 2002
 */
//$Id: BC_LoadWordConst.java,v 1.1 2004/10/25 11:50:23 dgrove-oss Exp $

package com.ibm.JikesRVM.OSR;

import org.vmmagic.unboxed.*;

/**
 * load a word constant on the stack
 *
 * @author Kris Venstermans
 */
public class BC_LoadWordConst extends OSR_PseudoBytecode {
  private final static int bsize = 2+BYTES_IN_ADDRESS;
  private final Word wbits;
  
  public BC_LoadWordConst(Word bits) {
    this.wbits = bits;
  }

  public byte[] getBytes() {
    byte[] codes = initBytes(bsize, PSEUDO_LoadWordConst);
    word2bytes(codes, 2, wbits);
    return codes;
  }

  public int getSize() {
    return bsize; 
  }
 
  public int stackChanges() {
        return +1;
  }

  public String toString() {
    return "LoadWord "+wbits;  
  }
}
