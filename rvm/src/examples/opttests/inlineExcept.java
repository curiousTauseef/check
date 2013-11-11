/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: inlineExcept.java,v 1.2 2001/11/06 21:48:07 pfs-oss Exp $
/**
 * simple test of inlining & exception handling
 *
 * @author unascribed
 */

final class inlineExcept {
  public static void main(String[] args) {
    run();
  }

  public static boolean run() {
    try {
      foo();
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Caught IOOBE in foo");
    }
    return true;
  }

  static void foo() {
    bar();
  }

  static void bar() {
    throw new IndexOutOfBoundsException();
  }
}
