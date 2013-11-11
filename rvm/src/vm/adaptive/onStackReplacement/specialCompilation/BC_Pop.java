/*
 * (C) Copyright IBM Corp 2002
 */
//$Id: BC_Pop.java,v 1.2 2003/12/05 23:45:43 augart-oss Exp $

package com.ibm.JikesRVM.OSR;
/**
 *  pop
 *
 * @author Feng Qian
 */
public class BC_Pop extends OSR_PseudoBytecode {
  public byte[] getBytes() {
    byte[] codes = new byte[1];
    codes[0] = 87;
    return codes;
  }

  public int getSize() {
    return 1;
  }

  public int stackChanges() {
        return -1;
  }

  public String toString() {
    return "Pop";
  }
}
