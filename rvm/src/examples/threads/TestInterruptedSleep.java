/*
 * (C) Copyright IBM 2002
 */
// $Id: TestInterruptedSleep.java,v 1.4 2003/12/05 23:45:07 augart-oss Exp $

/**
 * Test that Thread.sleep() can be interrupted.
 *
 * @author David Hovemeyer
 */
public class TestInterruptedSleep {

  public static void main(String[] argv) {
    final Thread mainThread = Thread.currentThread();

    new Thread() {
      public void run() {
        try {
          Thread.sleep(1000);
        }
        catch (InterruptedException e) {
        }

        mainThread.interrupt();
      }
    }.start();

    try {
      Thread.sleep(2000);
    }
    catch (InterruptedException e) {
      System.out.println("TestInterruptedSleep SUCCESS");
      System.exit(0);
    }

    System.out.println("TestInterruptedSleep FAILED");
  }

}
