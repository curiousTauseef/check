/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: opcode_tab.java,v 1.5 2002/08/15 20:30:16 sjfink-oss Exp $
package com.ibm.JikesRVM;

/**
 * Structure for the D and XL forms, PowerPC instruction set 
 *
 * @author John Waley
 * @see PPC_Disassembler 
 */
class opcode_tab {  

  int format;
  String mnemonic;

  opcode_tab(int format, String mnemonic) {
    this.format = format;
    this.mnemonic = mnemonic;
  }

}
