/*
 * (C) Copyright IBM Corp. 2001
 */
// $Id: RunCaffeine.java,v 1.3 2003/10/30 19:07:12 augart-oss Exp $
/**
 * @author Julian Dolby
 */
class RunCaffeine {

  public static void main(String[] args) {
    BenchmarkUnit bu;

    bu = new BenchmarkUnit(new SieveAtom());
    runTest(bu);

    bu = new BenchmarkUnit(new LoopAtom());
    runTest(bu);

    bu = new BenchmarkUnit(new LogicAtom());
    runTest(bu);

    bu = new BenchmarkUnit(new StringAtom());
    runTest(bu);

    bu = new BenchmarkUnit(new FloatAtom());
    runTest(bu);

    bu = new BenchmarkUnit(new MethodAtom());
    runTest(bu);

    bu = new BenchmarkUnit(new SieveAtom());
    runTest(bu);

    bu = new BenchmarkUnit(new LoopAtom());
    runTest(bu);

    bu = new BenchmarkUnit(new LogicAtom());
    runTest(bu);

    bu = new BenchmarkUnit(new StringAtom());
    runTest(bu);

    bu = new BenchmarkUnit(new FloatAtom());
    runTest(bu);

    bu = new BenchmarkUnit(new MethodAtom());
    runTest(bu);

  }


  static void runTest(BenchmarkUnit benchmark) {
    try {
      System.out.println(benchmark.testName()+" score:\t"+benchmark.testScore());
    }
    catch (Throwable x) { x.printStackTrace(System.err); }
  }
}
