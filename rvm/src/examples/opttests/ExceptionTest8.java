/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: ExceptionTest8.java,v 1.3 2003/12/05 23:45:04 augart-oss Exp $
/**
 * @author unascribed
 */

class ExceptionTest8 {

    public static void main(String[] args) {
        int x = 7;
        while (--x > 0) {
            try {
                try {
                    if (args[0].equals("null"))
                        throw new NullPointerException();
                } finally {
                    if (args[0].equals("cast"))
                        throw new ClassCastException();
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

}
