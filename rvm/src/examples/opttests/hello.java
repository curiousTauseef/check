/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: hello.java,v 1.2 2001/11/06 21:48:04 pfs-oss Exp $
/**
 * @author unascribed
 */

class hello {
  static boolean run() {
    String str = world();
    System.out.println("Hello returned: " + str);
    return true;
  }

  static final String hi = "hello world";

  static void one() {
     two(hi);
  }

  static void two(String s) {
     System.out.println(s);
  }

  static void three() {
     System.out.println();
  }

  static String world() {
    return hi;
  }
}
