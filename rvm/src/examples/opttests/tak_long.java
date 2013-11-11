/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: tak_long.java,v 1.3 2003/12/05 23:45:06 augart-oss Exp $
/**
 * @author unascribed
 */
public class tak_long {

  // long tak(long x, long y, long z);

  /*
  public static void main(String argv[])
  {
        int i;
        System.out.println("Tak is running\n");
        //for (i=0; i<1000; i++){
          long result = tak(18,12,6);
        System.out.println(result + "\n");
        //}

        //System.exit(0);
  }
  */

  static boolean run() {
    long i = tak_long.tak(18L, 12L, 6L);
    System.out.println("Tak_long returned: " + i);
    return true;
  }

static long tak(long x, long y, long z)
{
   if (y >= x)
   {
      return z;
   }
   else
   {
      return tak(tak (x-1, y, z),
                 tak (y-1, z, x),
                 tak (z-1, x, y));
   }
}

}
