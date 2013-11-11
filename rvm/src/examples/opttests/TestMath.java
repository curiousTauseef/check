/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: TestMath.java,v 1.2 2001/11/06 21:47:39 pfs-oss Exp $
/**
 * @author unascribed
 */

class TestMath
   {
   public static void main(String args[])
      {
      run();
      }

   public static boolean run()
      {
      System.out.println("TestMath");

      System.out.println("-- Math.floor --");
      
      System.out.println("\nwant: 1.0 \ngot:  " + Math.floor(1.6));
      System.out.println("\nwant: 1.0 \ngot:  " + Math.floor(1.5));
      System.out.println("\nwant: 1.0 \ngot:  " + Math.floor(1.4));
      System.out.println("\nwant: 1.0 \ngot:  " + Math.floor(1.0));

      System.out.println("\nwant: -2.0 \ngot:  " + Math.floor(-2.0));
      System.out.println("\nwant: -2.0 \ngot:  " + Math.floor(-1.6));
      System.out.println("\nwant: -2.0 \ngot:  " + Math.floor(-1.5));
      System.out.println("\nwant: -2.0 \ngot:  " + Math.floor(-1.4));

      System.out.println("-- Math.ceil --");
      
      System.out.println("\nwant: 2.0 \ngot:  " + Math.ceil(1.6));
      System.out.println("\nwant: 2.0 \ngot:  " + Math.ceil(1.5));
      System.out.println("\nwant: 2.0 \ngot:  " + Math.ceil(1.4));
      System.out.println("\nwant: 1.0 \ngot:  " + Math.ceil(1.0));

      System.out.println("\nwant: -2.0 \ngot:  " + Math.ceil(-2.0));
      System.out.println("\nwant: -1.0 \ngot:  " + Math.ceil(-1.6));
      System.out.println("\nwant: -1.0 \ngot:  " + Math.ceil(-1.5));
      System.out.println("\nwant: -1.0 \ngot:  " + Math.ceil(-1.4));

      return true;
      }
   }
