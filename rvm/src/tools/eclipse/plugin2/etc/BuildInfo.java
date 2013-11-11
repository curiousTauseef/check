/*
 * (C) Copyright IBM Corp 2001,2002
 *
 * ==========
 * $Source: /cvsroot/jikesrvm/rvm/src/tools/eclipse/plugin2/etc/BuildInfo.java,v $
 * $Revision: 1.3 $
 * $Date: 2002/10/28 20:57:04 $
 * $Author: dolby-oss $
 * $Id: BuildInfo.java,v 1.3 2002/10/28 20:57:04 dolby-oss Exp $
 */

package com.ibm.jikesrvm.eclipse.jdt.launching;

/**
 * @author Jeffrey Palm
 */
public interface BuildInfo {
  public final static String         TIME = "@long.date@";
  public final static java.util.Date DATE = new java.util.Date(TIME);
}
