/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: TestInstanceOf.java,v 1.3 2003/12/05 23:45:05 augart-oss Exp $
/**
 * @author unascribed
 */
class TestInstanceOf
{
  public static void main(String args[])
  {
    // VM.boot();
    run();
  }
  
  static boolean testSuccess = true;

  static boolean[] boolTest = new boolean[4];

  public static boolean run()
  {
    System.out.print("TestInstanceOf");
    
    Object o1     = new TestInstanceOf();   // source: a reference
    Object o2[]   = new TestInstanceOf[2];  // source: an array of references
    Object o3[][] = new Object[2][];        // source: an array of arrays
    o3[0]  = new TestInstanceOf[4];
    o3[1]  = new TestInstanceOf[4];
    int    o4[]   = new int [2];            // source: an array of primitives
    
    test(o1);
    if (!((boolTest[0])&&(!boolTest[1])&&(!boolTest[2])&&(!boolTest[3]))) {
      System.out.print("\nwant: true false false false\n got: ");  
      System.out.println(boolTest[0] + " " + boolTest[1] + 
                         " " + boolTest[2] + " " + boolTest[3]);
      testSuccess = false;
    }
    
    test(o2);
    if (!((!boolTest[0])&&(boolTest[1])&&(!boolTest[2])&&(!boolTest[3]))) { 
      System.out.print("\nwant: false true false false\n got: ");  
      System.out.println(boolTest[0] + " " + boolTest[1] + 
                         " " + boolTest[2] + " " + boolTest[3]);
      testSuccess = false;
    }
    
    test(o3);
    if (!((!boolTest[0])&&(!boolTest[1])&&(!boolTest[2])&&(!boolTest[3]))) { 
      System.out.print("\nwant: false false false false\n got: "); 
      System.out.println(boolTest[0] + " " + boolTest[1] + 
                         " " + boolTest[2] + " " + boolTest[3]);
      testSuccess = false;
    }
    
    test(o4);
    if (!((!boolTest[0])&&(!boolTest[1])&&(!boolTest[2])&&(boolTest[3]))) { 
      System.out.print("\nwant: false false false true\n got: ");  
      System.out.println(boolTest[0] + " " + boolTest[1] + 
                         " " + boolTest[2] + " " + boolTest[3]);
      testSuccess = false;
    }

    o1 = (TestInstanceOf)o1;   //  ok
    System.out.println("\nwant: class cast exception");
    testcast(new String("hello"));

    if (testSuccess)
      System.out.println(" succeeded.");
    else
      System.out.println(" failed. ***************\n\n");       
    
    return testSuccess;
  }

  static Object testcast(Object o1) {
       Object o = null;
       try {
        o = (String)o1;
       }
       catch (ClassCastException e)
       {
       System.out.println(" got: class cast exception");
       }
       try {
        o = (StringBuffer)o1;
       }
       catch (ClassCastException e)
       {
       System.out.println(" got: class cast exception");
       }
     return o;
  }


  static void test(Object o)
  {
    boolTest[0] = o instanceof TestInstanceOf    ;  // target: a reference
    boolTest[1] = o instanceof TestInstanceOf[]  ;  // target: an array of references
    boolTest[2] = o instanceof TestInstanceOf[][];  // target: an array of arrays
    boolTest[3] = o instanceof int []            ;  // target: an array of primitives
    
    //    System.out.println(b1 + " " + b2 + " " + b3 + " " + b4);
  }
}
