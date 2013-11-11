/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: VM_SaveVolatile.java,v 1.1 2003/01/09 13:13:34 dgrove-oss Exp $
package com.ibm.JikesRVM;

/**
 * Methods of a class that implements this interface
 * are treated specially by the machine code compiler:
 * the method prologue saves all the volatile registers
 * and the method epilogue restores all the volatile registers
 *
 * @author Bowen Alpern
 * @author Derek Lieber
 */
public interface VM_SaveVolatile  { }
