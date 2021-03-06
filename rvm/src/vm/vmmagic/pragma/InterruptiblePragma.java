/*
 * (C) Copyright IBM Corp. 2002, 2003, 2004
 */
//$Id: InterruptiblePragma.java,v 1.1 2004/09/09 06:40:51 steveb-oss Exp $
package org.vmmagic.pragma; 

import com.ibm.JikesRVM.classloader.*;

/**
 * A pragma that can be used to declare that a 
 * particular method is interruptible.  
 * Used to override the class-wide pragma
 * implied by implementing {@link Uninterruptible}.
 * 
 * @author Dave Grove
 */
public class InterruptiblePragma extends PragmaException {
  private static final VM_TypeReference me = getTypeRef("Lorg/vmmagic/pragma/InterruptiblePragma;");
  public static boolean declaredBy(VM_Method method) {
    return declaredBy(me, method);
  }
}
