/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: OPT_ValueGraphParamLabel.java,v 1.3 2002/08/20 21:35:18 sjfink-oss Exp $
package com.ibm.JikesRVM.opt;

/**
 * Represent a value that is a parameter
 *
 * @author Dave Grove
 */
class OPT_ValueGraphParamLabel {
  int paramNum;
  
  OPT_ValueGraphParamLabel(int pn) {
    paramNum = pn;
  }

  public String toString() {
    return "formal"+paramNum;
  }
}
