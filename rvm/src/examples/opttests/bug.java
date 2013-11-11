/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: bug.java,v 1.2 2001/11/06 21:47:54 pfs-oss Exp $
/**
 * @author unascribed
 */
class bug {

   static byte x[] = {-1};
   
   public static void main(String args[]) {
      int X = x[0];
      int Y;
      if (X == 0)
         Y = 0;
      else if (X > 0)
         Y = 1;
     else
         Y = -1;
     System.out.println(Y);
   }
}
