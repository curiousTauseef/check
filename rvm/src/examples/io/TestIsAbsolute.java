/*
 * (C) Copyright IBM Corp., 2002.
 *
 * ==========
 * $Source: /cvsroot/jikesrvm/rvm/src/examples/io/TestIsAbsolute.java,v $
 * $Revision: 1.3 $
 * $Date: 2002/10/28 20:57:04 $
 * $Author: dolby-oss $
 * $Id: TestIsAbsolute.java,v 1.3 2002/10/28 20:57:04 dolby-oss Exp $
 */

import java.io.File;

/**
 * Tests whether isAbsolute() handles zero-length names
 * correctly.  Used to throw a NullPointerException.
 *
 * @author Jeffrey Palm
 * @since  28 Jun 2002
 */
public class TestIsAbsolute {
  public static void main(String[] args) throws Exception {
    if (new File("").isAbsolute()) {
      throw new Error("empty filenames should be !isAbsolute");
    }      
  }
}
