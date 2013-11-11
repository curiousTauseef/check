/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: virtual.java,v 1.3 2003/12/05 23:45:06 augart-oss Exp $
/**
 * @author unascribed
 */

import java.io.*;

public class virtual {
  static boolean run() {
    int i = iter(5);
    System.out.println("Virtual returned: " + i);
    return true;
  }

  static int[] num = new int[4];
  static int cnt;

  int f1, f2;

 public static int iter(int n) {
        virtual lo = new virtual(5);
        lo.f1 = lo.f2+1;
        cnt = 1000;
        lo.f1 = lo.abc(200);
         return lo.f1 + lo.f2;
  }

  virtual(int i) { f1 = i; f2= i+4; }

   int abc(int a) { 
         f1 = f1 + a; f2 = f2 + a*10;
         return virtual.cnt + f1 + f2;
   }
}

