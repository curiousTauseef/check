/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: milestone.java,v 1.2 2001/11/06 21:48:30 pfs-oss Exp $
/**
 * Use the following command to compile the program with full debug output:
 *
 *  jsh java optCompilerDriver +depgraph +ir +low +burs +regalloc milestone 
 *
 * @author unascribed
 */

final class milestone
{
  static int add(int a, int b)
  {
    return a + b;
  }
}

