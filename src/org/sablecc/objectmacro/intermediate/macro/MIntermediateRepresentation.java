/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.intermediate.macro;

import java.util.*;

public class MIntermediateRepresentation {

  private final List<Object> eMacro = new LinkedList<Object>();

  public MIntermediateRepresentation() {
  }

  public MMacro newMacro() {
    MMacro lMacro = new MMacro();
    this.eMacro.add(lMacro);
    return lMacro;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for(Object oMacro : this.eMacro) {
      sb.append(oMacro.toString());
    }
    return sb.toString();
  }

}
