/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: ExceptionTest7.java,v 1.2 2001/11/06 21:47:02 pfs-oss Exp $
/**
 * @author unascribed
 */

class ExceptionTest7 {


  static int testa[] = null; //new int[3];
  public static void main(String[] args) {

    run();
  }

 public static boolean run() {
    try {
      foo();
    } catch (IndexOutOfBoundsException e5) {
      System.out.println(" IndexOutOfBoundsException caught");
    } catch (NullPointerException e) {
      System.out.println(" NullPointerException");
    }
    System.out.println(" At End");

    return true;
  }

  public static void foo() {
      testa[4] = 0;
  }

}
