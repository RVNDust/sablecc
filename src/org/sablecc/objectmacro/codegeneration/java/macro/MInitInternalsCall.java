/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

<<<<<<< HEAD
<<<<<<< HEAD
import java.util.*;

=======
>>>>>>> Init internals before building the macro instead at the add or addAll methods
=======
import java.util.*;

>>>>>>> Lazy initialization in build method instead of eager initialization in add methods
public class MInitInternalsCall {

  private final String pParamName;
  private final MInitInternalsCall mInitInternalsCall = this;
<<<<<<< HEAD
<<<<<<< HEAD
  private final List<Object> eContextArg = new LinkedList<Object>();

  MInitInternalsCall(String pParamName) {
<<<<<<< HEAD
=======

  public MInitInternalsCall(String pParamName) {
>>>>>>> Init internals before building the macro instead at the add or addAll methods
=======
  private final List<Object> eContextArg = new LinkedList<Object>();

  public MInitInternalsCall(String pParamName) {
>>>>>>> Lazy initialization in build method instead of eager initialization in add methods
=======
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
    if(pParamName == null) throw new NullPointerException();
    this.pParamName = pParamName;
  }

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Lazy initialization in build method instead of eager initialization in add methods
  public MContextArg newContextArg() {
    MContextArg lContextArg = new MContextArg();
    this.eContextArg.add(lContextArg);
    return lContextArg;
  }

<<<<<<< HEAD
=======
>>>>>>> Init internals before building the macro instead at the add or addAll methods
=======
>>>>>>> Lazy initialization in build method instead of eager initialization in add methods
  String pParamName() {
    return this.pParamName;
  }

  private String rParamName() {
    return this.mInitInternalsCall.pParamName();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    sb.append("        init");
=======
    sb.append("init");
>>>>>>> Lazy initialization in build method instead of eager initialization in add methods
=======
    sb.append("        init");
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
    sb.append(rParamName());
    sb.append("Internals(");
    if(this.eContextArg.size() == 0) {
      sb.append("null");
    }
    for(Object oContextArg : this.eContextArg) {
      sb.append(oContextArg.toString());
    }
    sb.append(");");
    sb.append(System.getProperty("line.separator"));
<<<<<<< HEAD
<<<<<<< HEAD
    sb.append("        ");
=======
    sb.append("init");
    sb.append(rParamName());
    sb.append("Internals();");
    sb.append(System.getProperty("line.separator"));
>>>>>>> Init internals before building the macro instead at the add or addAll methods
=======
>>>>>>> Lazy initialization in build method instead of eager initialization in add methods
=======
    sb.append("        ");
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
    return sb.toString();
  }

}
