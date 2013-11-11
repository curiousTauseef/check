/*
 * (C) Copyright IBM Corp. 2001
 */
//$Id: TestWrite.java,v 1.2 2001/11/06 21:49:10 pfs-oss Exp $
import java.io.ObjectOutputStream;

/**
 * @author unascribed
 */
class TestWrite
{
  public static void main(String args[]) {
    try {
      TestSerialization ts = new TestSerialization();
      ObjectOutputStream out = new ObjectOutputStream(System.out);
      out.writeObject(ts);
    } catch (java.io.IOException e) {
      e.printStackTrace(System.err);
    }
  }
}

