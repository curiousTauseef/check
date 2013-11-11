/*
 * (C) Copyright IBM Corp. 2002
 */
//$Id: classB.java,v 1.1 2002/06/27 13:52:46 dgrove-oss Exp $

package test;

/**
 * @author Igor Pechtchanski
 */
public class classB extends classA implements interfaceB {
  public static void load() {}
  public void fum() { System.out.println("fum()"); }
}

