/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Revert "Changement Objectmacro-back"
import java.util.*;

public class MParamStringRef {

  private final String pName;
  private final MParamStringRef mParamStringRef = this;
  private final List<Object> eContextParam = new LinkedList<Object>();
  private final List<Object> eGetInternalTail = new LinkedList<Object>();

  public MParamStringRef(String pName) {
    if(pName == null) throw new NullPointerException();
    this.pName = pName;
  }

  public MContextParam newContextParam() {
    MContextParam lContextParam = new MContextParam();
    this.eContextParam.add(lContextParam);
    return lContextParam;
  }

  public MGetInternalTail newGetInternalTail() {
    MGetInternalTail lGetInternalTail = new MGetInternalTail();
    this.eGetInternalTail.add(lGetInternalTail);
    return lGetInternalTail;
  }

  String pName() {
    return this.pName;
  }

  private String rName() {
    return this.mParamStringRef.pName();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    sb.append("    private String get");
    sb.append(rName());
    sb.append("(");
=======
    sb.append("    private String build");
    sb.append(rName());
    sb.append("(");
    sb.append(System.getProperty("line.separator"));
    sb.append("            ");
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
    sb.append("    private String get");
    sb.append(rName());
    sb.append("(");
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
=======
    sb.append("    private String get");
    sb.append(rName());
    sb.append("(");
>>>>>>> Revert "Changement Objectmacro-back"
    for(Object oContextParam : this.eContextParam) {
      sb.append(oContextParam.toString());
    }
    sb.append("){");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        return this.field_");
    sb.append(rName());
    for(Object oGetInternalTail : this.eGetInternalTail) {
      sb.append(oGetInternalTail.toString());
    }
    sb.append(";");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }
<<<<<<< HEAD
=======
public class MParamStringRef extends Macro{
>>>>>>> Changement Objectmacro-back
=======
>>>>>>> Revert "Changement Objectmacro-back"

}
