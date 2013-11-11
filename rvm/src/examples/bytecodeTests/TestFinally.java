/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: TestFinally.java,v 1.3 2003/10/30 19:07:12 augart-oss Exp $
/**
 * @author unascribed
 */
class TestFinally
   {
   static int
   foo()
      {
      try 
         {
         int a = 1;
         int b = 0;
         return a / b;
         }

      catch(Exception e)
         {
         return 1;
         }

      finally 
         {
         return 2;
         }

      // not reached
      }
   
   public static void 
   main(String args[])
      {
   // VM.boot();
      runTest();
      }

   public static void runTest()
      {
      SystemOut.println("TestFinally");

      SystemOut.println(foo());
      
      try 
         {
         SystemOut.println("hi");      // jsr
         return;
         }

      finally 
         {
         SystemOut.println("bye");
         }                              // ret
      }
   }
