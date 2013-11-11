/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: testCounts.java,v 1.3 2003/12/05 23:45:06 augart-oss Exp $
/**
 * @author unascribed
 */
class testCounts
{
    public static void main() {
        bar(100);
    }

  public static void bar(int n) {
        int a[] = new int[n];
        int length = a.length;

        for(int i = 0 ; i < length ; i++ )
        {
            a[i] = a[i] + 1;
        }
    }

    static int foo(int a[], int i) {
        return a[i];
    }
}
