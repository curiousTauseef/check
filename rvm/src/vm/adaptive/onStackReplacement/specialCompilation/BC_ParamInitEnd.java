/*
 * (C) Copyright IBM Corp 2002
 */
//$Id: BC_ParamInitEnd.java,v 1.2 2003/12/05 23:45:43 augart-oss Exp $

package com.ibm.JikesRVM.OSR;
/**
 *  LocalInitEnd
 *
 * @author Feng Qian
 */
public class BC_ParamInitEnd extends OSR_PseudoBytecode {
  public byte[] getBytes() {
        return initBytes(2, PSEUDO_ParamInitEnd);
  }

  public int getSize() {
    return 2;
  }

  public int stackChanges() {
        return 0;
  }

  public String toString() {
    return "ParamInitEnd";
  }
}
