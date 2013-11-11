/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: TestSuspend.java,v 1.2 2001/11/06 21:49:21 pfs-oss Exp $
/**
 * @author unascribed
 */
class TestSuspend extends Thread {
  
  static Thread sleeper;

  public static void main(String args[]) throws Exception {
    System.out.println("TestSuspend");
    sleeper = Thread.currentThread();
    TestSuspend waker = new TestSuspend();
    waker.start();
    System.out.println(Thread.currentThread().getName() + ": suspending");
    sleeper.suspend();
    System.out.println(Thread.currentThread().getName() + ": resumed");
    System.out.println("main: bye");
  }
  
  public void run() {
    try {
      Thread.currentThread().sleep(5000);
    } catch (Exception e) {
      e.printStackTrace();
    }
    sleeper.resume();
  }
  
}
