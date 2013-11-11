/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: TestBarrier.java,v 1.2 2001/11/06 21:47:19 pfs-oss Exp $
/**
 * @author unascribed
 */

class TestBarrier {
  
  static Object[] array = new Object[10]; 
  static test     Test  = new test();

  public static void main(String args[]) {
      run(new Object());
  }


  static boolean run(Object o) {
     boolean result = false;
     Test.field = o;
     array[0] = o;
     if (o == null) 
        result = true;
     return result;
  }


  static class test {
     Object field; 
  }
}
