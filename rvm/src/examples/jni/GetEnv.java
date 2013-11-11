/*
 * (C) Copyright IBM Corp. 2002
 * $Id: GetEnv.java,v 1.3 2003/12/05 23:45:01 augart-oss Exp $
 */

/* Test the JavaVM and GetEnv JNI functionality 
 * 
 * @author Julian Dolby
 */
class GetEnv {

    private static void javaCall() {
        System.err.println("called into Java");
    }

    private static native void nativeCall();

    public static void main(String args[]) {    
        System.err.println("starting");

        System.loadLibrary("getenv");
        System.err.println("loaded libgetenv");

        nativeCall();
        System.err.println("nativeCall completed");

    }

}
