/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: VM_BasicBlockFactory.java,v 1.2 2004/11/05 17:51:46 hoffmann-oss Exp $
package com.ibm.JikesRVM;

/**
 * @author Perry Cheng
 */
public final class VM_BasicBlockFactory {

  private int nextBlockNumber = VM_BasicBlock.STARTBBNUMBER;

 // This should be the usual constructor, we know the start, but don't
 // yet know the end. No predecessors.
 VM_BasicBlock newBlock (int startval) {
   int blockNumber = nextBlockNumber ++;
   return new VM_BasicBlock(startval, blockNumber);
 }

 public int getNumberofBlocks() {
   return (nextBlockNumber -1);
 }

}
