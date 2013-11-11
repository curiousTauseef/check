/*
 * (C) Copyright IBM Corp. 2001
 */
// $Id: VM_MethodNameFunction.java,v 1.6 2002/08/27 02:45:17 hind-oss Exp $
package com.ibm.JikesRVM.adaptive;

import com.ibm.JikesRVM.VM_CompiledMethod;
import com.ibm.JikesRVM.VM_CompiledMethods;

/**
 * VM_MethodNameFunction.java
 *
 * @author Stephen Fink
 *
 * This class takes a compiled method id and returns a string
 * representation of the method name.
 *
 **/

class VM_MethodNameFunction implements VM_CounterNameFunction {

   /**
    * @param key the compiled method id of a method
    */
   public String getName(int key) {
     VM_CompiledMethod cm = VM_CompiledMethods.getCompiledMethod(key);
     if (cm == null) {
       return "OBSOLETE";
     } else {
       return cm.getMethod().toString();
     }
   }
}
