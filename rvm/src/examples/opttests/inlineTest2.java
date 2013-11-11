/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: inlineTest2.java,v 1.2 2001/11/06 21:48:11 pfs-oss Exp $
/**
 * @author unascribed
 */

class inlineTest2
{
  static int
  run()
  {
    int i = l2i( 0x000000000fffffffL);
    int j = l2i( 0x0000000000ffffffL);

    return i+j;
  }

  static int l2i(long i) {
    return (int)i;
  }
}

