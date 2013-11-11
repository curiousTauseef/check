/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: TestStopWorker.java,v 1.3 2003/12/05 23:45:07 augart-oss Exp $
/**
 * @author unascribed
 */
class TestStopWorker extends Thread
   {
   static boolean ready;

   TestStopWorker()
      {
      setName("worker");
      }

   public void
   run() //- overrides Thread
      {
      try {
          System.out.println(Thread.currentThread().getName() + ": running");
          ready = true;
          for (;;) { 
              Thread.yield();
          }
      }
      catch (Exception e) {
          System.out.println(Thread.currentThread().getName() + ": received interrupt " + e);
      }
      }
}
