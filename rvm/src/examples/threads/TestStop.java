/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: TestStop.java,v 1.2 2001/11/06 21:49:17 pfs-oss Exp $
/**
 * @author unascribed
 */
class TestStop
   {
   public static void 
   main(String args[])
      throws Exception
      {
      System.out.println("TestStop");
      
      System.out.println(Thread.currentThread().getName() + ": creating");
      TestStopWorker w = new TestStopWorker();
      
      System.out.println(Thread.currentThread().getName() + ": starting");
      w.start();
      while (TestStopWorker.ready == false)
         try { Thread.currentThread().sleep(1000); } catch (InterruptedException e) {}

      System.out.println(Thread.currentThread().getName() + ": sending interrupt to " + w.getName());
      w.stop(new ClassNotFoundException());

      System.out.println(Thread.currentThread().getName() + ": waiting for TestStopWorker to die");
      while (w.isAlive())
         try { Thread.currentThread().sleep(1000); } catch (InterruptedException e) {}

      System.out.println("main: bye");
      }
   }
