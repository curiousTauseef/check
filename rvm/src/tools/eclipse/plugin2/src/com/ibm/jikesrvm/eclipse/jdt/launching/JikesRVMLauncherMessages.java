/*
 * (C) Copyright IBM Corp 2001,2002
 *
 * ==========
 * $Source: /cvsroot/jikesrvm/rvm/src/tools/eclipse/plugin2/src/com/ibm/jikesrvm/eclipse/jdt/launching/JikesRVMLauncherMessages.java,v $
 * $Revision: 1.5 $
 * $Date: 2003/08/29 16:51:59 $
 * $Author: augart-oss $
 * $Id: JikesRVMLauncherMessages.java,v 1.5 2003/08/29 16:51:59 augart-oss Exp $
 */
package com.ibm.jikesrvm.eclipse.jdt.launching;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author Jeffrey Palm
 */
public class JikesRVMLauncherMessages {

  private static final String RESOURCE_BUNDLE= 
    //"org.eclipse.jdt.internal.launching.jikesrvm2.JikesRVMLauncherMessages";
    "com.ibm.jikesrvm.eclipse.jdt.launching.JikesRVMLauncherMessages";

  private static ResourceBundle resources = ResourceBundle.getBundle(RESOURCE_BUNDLE);

  public static String getString(String key) {
    try {
      return resources.getString(key);
    } catch (MissingResourceException e) {
      return "!" + key + "!";
    }
  }

  private JikesRVMLauncherMessages() {}

}
