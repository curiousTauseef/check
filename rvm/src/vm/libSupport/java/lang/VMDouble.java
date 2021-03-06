/*
 * (C) Copyright IBM Corp 2003
 */
//$Id: VMDouble.java,v 1.1 2003/07/19 11:00:12 dgrove-oss Exp $
package java.lang;

import com.ibm.JikesRVM.VM_Magic;

/**
 * Double <==> long bit transfer for Jikes RVM.
 * 
 * @author Dave Grove
 */
final class VMDouble {

  static long doubleToLongBits(double value) {
    long val = VM_Magic.doubleAsLongBits(value);
    long exponent = val & 0x7ff0000000000000L;
    long mantissa = val & 0x000fffffffffffffL;
    if (exponent ==  0x7ff0000000000000L && mantissa != 0) {
      return 0x7ff8000000000000L;
    } else {
      return val;
    }
  }

  static long doubleToRawLongBits(double value) {
    return VM_Magic.doubleAsLongBits(value);
  }

  static double longBitsToDouble(long bits) {
    return VM_Magic.longBitsAsDouble(bits);
  }
}
