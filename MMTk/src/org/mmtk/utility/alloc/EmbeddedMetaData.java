/*
 * (C) Copyright Department of Computer Science,
 *     Australian National University. 2004
 */
package org.mmtk.utility.alloc;

import org.mmtk.policy.MarkSweepLocal;
import org.mmtk.utility.Memory;
import org.mmtk.utility.Constants;

import org.vmmagic.unboxed.*;
import org.vmmagic.pragma.*;

/**
 * This plan implements constants and access methods for meta data
 * that is embeded in allocation spaces (rather than kept on the
 * side).  The basic idea is that meta data be embeded at a very
 * coarse power of two granularity for fast access, minimal wastage
 * and by making the regions coarse, the contigious meta-data will be
 * relatively large and thus the probability of L1 conflict misses
 * will be reduced (as compared with embedding meta-data at the start
 * of each page which will cause those few cache lines corresponding
 * to the start of each page to be heavily conflicted).
 *
 * $Id: EmbeddedMetaData.java,v 1.7 2005/01/19 02:49:03 steveb-oss Exp $
 *
 * @author <a href="http://cs.anu.edu.au/~Steve.Blackburn">Steve Blackburn</a>
 * @version $Revision: 1.7 $
 * @date $Date: 2005/01/19 02:49:03 $
 */
public final class EmbeddedMetaData implements Constants, Uninterruptible {

  /* The (log of the) size of each region of meta data management */
  public static final int LOG_BYTES_IN_REGION = 22;
  public static final int BYTES_IN_REGION = 1<<LOG_BYTES_IN_REGION;
  private static final Word REGION_MASK = Word.fromInt(BYTES_IN_REGION - 1);
  public static final int LOG_PAGES_IN_REGION = LOG_BYTES_IN_REGION - LOG_BYTES_IN_PAGE;
  public static final int PAGES_IN_REGION = 1<<LOG_PAGES_IN_REGION;

  /**
   * Given an address, return the begining of the meta data for the
   * region containing the address.  This is a fast operation because
   * it only involves masking out low order bits.
   *
   * @param address The address whose meta data is sought.
   * @return The address of the start of the meta data for the meta
   * region in which the address is located.
   */
  public static final Address getMetaDataBase(Address address) 
    throws InlinePragma {
    return address.toWord().and(REGION_MASK.not()).toAddress();
  }

  /**
   * Given an address, the density (coverage) of a meta data type, and
   * the granularity (alignment) of the meta data, return the offset
   * into the meta data the address.
   *
   * @param address The address whose meta data offset is sought.
   * @param logCoverage The log base two of the coverage of the meta
   * data in question. For example, a value of 4 would indicate a
   * coverage of 16; one metadata byte for every 16 bytes of data.
   * @param logAlign The log base two of the aligment or granularity
   * of the meta-data (it may be arranged in bytes, words, double
   * words etc).
   * @return The offset into the meta-data for this region, given the
   * specified address and coverage and aligment requirements.
   */
  public static final Extent getMetaDataOffset(Address address,
                                                  int logCoverage,
                                                  int logAlign) {
    return address.toWord().and(REGION_MASK).rshl(logCoverage+logAlign).lsh(logAlign).toExtent();
  }
}
