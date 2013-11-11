/*
 * (C) Copyright IBM Corp. 2003
 */
//$Id: SelectTest.java,v 1.2 2003/03/27 14:28:30 dgrove-oss Exp $ 

/**
 * Simple test to see if hijacking of select works.
 * 
 * @author Dave Grove
 */
class SelectTest {

  public static native void doit();

  public static void main(String args[]) {
    System.loadLibrary("SelectTest");
    doit();
  }
}
