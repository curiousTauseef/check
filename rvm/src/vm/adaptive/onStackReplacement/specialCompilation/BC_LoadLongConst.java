/*
 * (C) Copyright IBM Corp 2002
 */
//$Id: BC_LoadLongConst.java,v 1.2 2003/12/05 23:45:43 augart-oss Exp $

package com.ibm.JikesRVM.OSR;
/**
 * load a long constant on the stack
 *
 * @author Feng Qian
 */
public class BC_LoadLongConst extends OSR_PseudoBytecode {
  private final static int bsize = 10;
  private final long lbits;
  
  public BC_LoadLongConst(long bits) {
    this.lbits = bits;
  }

  public byte[] getBytes() {
    byte[] codes = initBytes(bsize, PSEUDO_LoadLongConst);
    long2bytes(codes, 2, lbits);
    return codes;
  }

  public int getSize() {
    return bsize;
  }

  public int stackChanges() {
        return 2;
  }

  public String toString() {
    return "LoadLong "+lbits;
  }
}
