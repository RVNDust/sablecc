/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

public class MInitInternalValue {

  private final String pParamName;
  private final MInitInternalValue mInitInternalValue = this;

  public MInitInternalValue(String pParamName) {
    if(pParamName == null) throw new NullPointerException();
    this.pParamName = pParamName;
  }

  String pParamName() {
    return this.pParamName;
  }

  private String rParamName() {
    return this.mInitInternalValue.pParamName();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("    this.");
    sb.append(rParamName());
    sb.append("Value = new InternalValue(this.list_");
    sb.append(rParamName());
<<<<<<< HEAD
<<<<<<< HEAD
    sb.append(", this.");
    sb.append(rParamName());
    sb.append("Context, this.");
    sb.append(rParamName());
    sb.append("Directives);");
=======
    sb.append(", ");
    sb.append(rParamName());
    sb.append("Context);");
>>>>>>> Add structure which contains list of macros and the context associated
=======
    sb.append(", this.");
    sb.append(rParamName());
    sb.append("Context, this.");
    sb.append(rParamName());
    sb.append("Directives);");
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

}
