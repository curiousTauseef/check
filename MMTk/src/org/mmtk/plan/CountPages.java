/*
 *
 * JFREE Extension : 
 * */
package org.mmtk.plan;

import org.mmtk.utility.Log;
import org.mmtk.vm.Plan;
import org.mmtk.policy.Space;

import org.vmmagic.unboxed.*;
import org.vmmagic.pragma.*;

public class CountPages implements Uninterruptible {

    public static final boolean counting = true;

    /* individual counts */

    private static long totalN = 0;
    private static long totalS = 0;

    private static long allocN = 0;
    private static long allocS = 0;

    private static long curN = 0;
    private static long curS = 0;

    private static long maxN   = 0;
    private static long maxS   = 0;


    private static int gccycles = 0;

    /* MS  space */

    /* freed by jfree from last GC */
    private static long freedN = 0;
    private static long freedS = 0;

    /* freed by jfree from beginning until last GC */
    private static long tfreedN = 0;
    private static long tfreedS = 0;

    /* freed by gc during last GC */
    private static long lastfreeCellsN = 0;
    private static long lastfreeCellsS = 0;

    /* freed by gc during last GC */
    private static long freeCellsN = 0;
    private static long freeCellsS = 0;

    /* freed by gc before last GC */
    private static long tgfreedN = 0;
    private static long tgfreedS = 0;

    /* Same on Large Obejct  space */

    private static long lfreedN = 0;
    private static long lfreedS = 0;

    private static long ltfreedN = 0;
    private static long ltfreedS = 0;

    private static long lgfreedN = 0;
    private static long lgfreedS = 0;

    private static long ltgfreedN = 0;
    private static long ltgfreedS = 0;

    public static void alloc(int size, boolean large) throws InlinePragma {
        totalN++;
        totalS += size;
        allocN++;
        allocS += size;
        curN ++;
        curS += size;
        if (curN > maxN)
            maxN = curN;
        if (curS > maxS)
            maxS = curS;
    }

    static boolean gc_active = true;
    static int measure = 0;
    public static void largefreed(int size) {
        if (gc_active) {
            lgfreedN ++;
            lgfreedS += size;
        }
        else {
            lfreedN ++;
            lfreedS += size;
        }
        curN --;
        curS -= size;
        gc_active = true;
    }

    public static void prepareForLarge() throws InlinePragma {
        gc_active = false;
    }

    public static void jfreed(int size) throws InlinePragma {
        freedN ++;
        freedS += size;
        curN --;
        curS -= size;
    }

    public static void beforeGC() throws InlinePragma {
        freeCellsN = 0;
        freeCellsS = 0;
    }

    public static void afterGC() throws InlinePragma {
        lastfreeCellsN = freeCellsN;
        lastfreeCellsS = freeCellsS;
        freeCellsN = 0;
        freeCellsS = 0;
    }

    static int aN = 0;
    static int aS = 0;
    public static void gcfreed2(int size) throws InlinePragma {
        aN++;
        aS += size;
    }

    public static void gcfreed(int size) throws InlinePragma {
        freeCellsN++;
        freeCellsS += size;
    }

    public static void donegc() throws InlinePragma {
        Log.writeln();
        long gfreedN = freeCellsN - lastfreeCellsN;
        long gfreedS = freeCellsS - lastfreeCellsS;
        printOMcounts("g:    ", freeCellsN,  freeCellsS);
        Log.writeln();
        printOMcounts("a:    ", aN,  aS);

        if (gfreedN < 0 || gfreedS < 0) {
            Log.write(" < zero ??? ");
            gfreedN = 0;
            gfreedS = 0;
        }
        curN -= (gfreedN);
        curS -= (gfreedS);
        

        Log.write(    " This GC cycle: ");
        printPadded(3, ++gccycles);
        Log.writeln();
        printOMcounts("Total Alloc:    ", totalN,  totalS);
        Log.writeln();
        printOMcounts("Recent Alloc:   ", allocN,  allocS);
        Log.writeln();
        printOMcounts("Watermark:      ", maxN,  maxS);
        Log.writeln();
        printOMcounts("Current:        ", curN,  curS);
        Log.writeln();
        printOMcounts("Small jfreed    ", freedN,  freedS);
        Log.writeln();

        printOMcounts("Small gced      ", gfreedN, gfreedS);
        Log.writeln();
        printOMcounts("Large jfreed    ", lfreedN,  lfreedS);
        Log.writeln();
        printOMcounts("Large gced      ", lgfreedN, lgfreedS);
        Log.writeln();

        Log.write(    " Ratio (F/F+GC):");
        printRatio(freedN, gfreedN);
        printRatio(freedS, gfreedS);
        Log.writeln();

        Log.write(    " Ratio - large: ");
        printRatio(lfreedN, lgfreedN);
        printRatio(lfreedS, lgfreedS);
        Log.writeln();

        Log.write(    " Ratio - total: ");
        printRatio(freedN + lfreedN, gfreedN + lgfreedN);
        printRatio(freedS + lfreedS, gfreedS + lgfreedS);
        Log.writeln();
        
        tfreedN += freedN;
        tfreedS += freedS;
        freedN = 0;
        freedS = 0;

        tgfreedN += gfreedN;
        tgfreedS += gfreedS;
        gfreedN = 0;
        gfreedS = 0;

        lastfreeCellsN = freeCellsN;
        lastfreeCellsS = freeCellsS;

        freeCellsN = 0;
        freeCellsS = 0;
        
        ltfreedN += lfreedN;
        ltfreedS += lfreedS;
        lfreedN = 0;
        lfreedS = 0;

        ltgfreedN += lgfreedN;
        ltgfreedS += lgfreedS;
        lgfreedN = 0;
        lgfreedS = 0;


        allocN = 0;
        allocS = 0;
        
        aN = 0;
        aS = 0;
    }

    private static int maxpages  = 0;

    private static int currpages = 0;

    public static void updateCount() throws InlinePragma {
        currpages = Plan.getPagesReserved();
        if (currpages > maxpages) 
            maxpages = currpages;
    }

    public static void printusage() throws InlinePragma {
        updateCount();
        donegc();
        Log.writeln("[------ End of excution -----]");
        int PAGES_MB = 2;
        Log.write("  - Pages watermark = \t\t");
        Space.printPages(maxpages,PAGES_MB);
        Log.writeln();
        Log.writeln();
        Log.write(  "# gc cycles:     ");
        printPadded(40, gccycles);
        /* readable format */
        Log.writeln();
        printOMcounts("Total allocated: "   , totalN, totalS);
        Log.writeln();
        printOMcounts("Watermark      : "   , maxN, maxS);
        Log.writeln();
        printOMcounts("Total jfreed   : "   , 
                tfreedN + ltfreedN, tfreedS + ltfreedS);
        Log.writeln();
        printOMcounts("Total gc- freed: "   , 
                tgfreedN + ltgfreedN, tgfreedS + ltgfreedS);
        Log.writeln();
        Log.write(" Average  Ratio (%): ");
        printRatio(tfreedN + ltfreedN, tgfreedN + ltgfreedN);
        printRatio(tfreedS + ltfreedS, tgfreedS + ltgfreedS);

        /* csv format */
        Log.writeln("------");
        Log.write("csv,");
        printPadded(10, gccycles);
        Log.write(',');
        printPadded(10, totalN);
        Log.write(',');
        printPadded(10, maxN);
        Log.write(',');
        printPadded(10, tfreedN);
        Log.write(',');
        printPadded(10, ltfreedN);
        Log.write(',');
        printPadded(10, tgfreedN);
        Log.write(',');
        printPadded(10, ltgfreedN);
        Log.write(',');
        printPadded(10, totalS);
        Log.write(',');
        printPadded(10, maxS);
        Log.write(',');
        printPadded(10, tfreedS);
        Log.write(',');
        printPadded(10, ltfreedS);
        Log.write(',');
        printPadded(10, tgfreedS);
        Log.write(',');
        printPadded(10, ltgfreedS);
        Log.write(',');
        Log.writeln();
        Log.writeln("[-----------------------------]");
    }

    private static void printOMcounts(String title, long c1, long c2) 
        throws InlinePragma {
        Log.write(title);
        printPadded(10, c1);
        Log.write(" obj   ");
        printPadded(10, c2);
        Log.write(" b (");
        printPadded(4, c2/1000000);
        Log.write(" Mb)");
    }

    private static void printRatio(long a, long b) 
        throws InlinePragma {
        long c = (a + b);
        printPadded(2, ((c == 0) ? 0 : a*100/c));
        Log.write(" %");
    }

    private static void printPadded(int size, long number) 
        throws InlinePragma {
        if (number == 0)
            size--;
        long c = number;
        while (c > 0) {
            size --;
            c = c / 10;
        }
        while (size > 0) {
            Log.write(' ');
            size--;
        }
        Log.write(number);
    }

}
