/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: inlineTest.java,v 1.2 2001/11/06 21:48:09 pfs-oss Exp $
/**
 * @author unascribed
 */

class inlineTest
{
  static int
  run()
  {
    int i = l2i( 0x000000007fffffffL);

    return i;
  }

  static int l2i(long i) {
    return (int)i;
  }
}

