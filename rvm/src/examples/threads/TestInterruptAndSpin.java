/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: TestInterruptAndSpin.java,v 1.3 2003/12/05 23:45:07 augart-oss Exp $

/**
 * Test to ensure that InterruptedException can't
 * be thrown out of thin air (i.e., backedge yieldpoints).
 * The original VM_Thread.externalInterrupt related code
 * was far too willing to throw InterruptedExceptions
 * in places where they should not have originated.
 *
 * @author David Hovemeyer
 */
public class TestInterruptAndSpin {
  public static void main(String[] argv) {
    try {

      // Ensure that there is another thread to run
      Thread t = new Thread() {
        public void run() {
          while (true)
            Thread.yield();
        }
      };
      t.setDaemon(true);
      t.start();

      Thread.currentThread().interrupt();

      // Long running loop, should yield at some point
      int count = 0;
      for (int i = 0; i < 10000000; ++i)
        count += i;
      System.out.println("count is " + count);

      if (count == 17)
        throw new InterruptedException("Dummy"); // placate compiler

      System.out.println("TestInterruptAndSpin SUCCESS");

    }
    catch (InterruptedException e){
      // This should not have happened
      System.out.println("TestInterruptAndSpin FAILED");
    }
  }
}
