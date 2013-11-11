/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: stack.java,v 1.2 2001/11/06 21:48:36 pfs-oss Exp $
/**
 * @author unascribed
 */

public class stack {

  public static void main(String arg[]) {
    int disk = 3;
    if (arg.length > 0) disk = Integer.parseInt(arg[0]);
    overflow(disk);
  }

  public static void overflow(int n) {
    if (n > 0)
       overflow(n-1);
  }
}
