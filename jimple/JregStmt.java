/** Jreg added statement */
package soot.jimple;

import soot.*;
import soot.util.*;


public interface JregStmt extends Stmt, Switchable
{
  public String getJasminLine();
  public boolean hasValue();
  public Value getValue();
}
