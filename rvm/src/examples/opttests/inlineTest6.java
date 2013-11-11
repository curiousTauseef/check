/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: inlineTest6.java,v 1.3 2003/12/05 23:45:06 augart-oss Exp $
/**
 * @author unascribed
 */

class inlineTest6
{
  static int
  run()
  {
    int i = sum(100);
    int j = sum(200);
 
    return i+j;
  }

  static int sum(int i) {
    int j;
    if (i == 0)
        j = i;
    else
        j = sum(i-1) + i;
    return j;
  }
}
