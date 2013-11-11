/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: TestAll.java,v 1.3 2003/10/30 19:07:12 augart-oss Exp $
/**
 * @author unascribed
 */

class TestAll
   {
   public static void main(String args[])
      throws Throwable
      {
   // if (VM.runningVM == false) VM.boot();
      runTest();
      }

   public static void runTest()
      throws Throwable
      {
      SystemOut.println("TestAll");

      // same order as in Makefile
      
      TestConstants.runTest();
      TestStackAccess.runTest();
      TestFieldAccess.runTest();
      TestArrayAccess.runTest();
      TestReturn.runTest();
      TestCompare.runTest();
//      TestConversions.runTest();
      TestConversions_toHex.runTest();
//      TestArithmetic.runTest();
      TestArithmetic_toHex.runTest();
      TestMath.runTest();
      TestMath_toHex.runTest();
      TestSwitch.runTest();
      TestStaticCall.runTest();
      TestVirtualCall.runTest();
      TestInterfaceCall.runTest();
      TestSpecialCall.runTest();
      TestClassInitializer.runTest();
      TestThrow.runTest();
      TestFinally.runTest();
      TestInstanceOf.runTest();
      TestClone.runTest();
      TestMonitorUnwind.runTest();
      TestGC.runTest();
//    TestReflection.runTest();      //!!TODO
//    TestClassLoading.runTest();    //!!TODO
//    TestStackTrace.runTest();      //!!TODO
//    TestMetaclass.runTest();       //!!TODO
//    TestNotification.runTest();    //!!TODO
      }
   }
