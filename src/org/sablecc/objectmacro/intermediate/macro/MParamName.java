/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.intermediate.macro;

public class MParamName {

  private final String pParamName;
  private final MParamName mParamName = this;

  public MParamName(String pParamName) {
    if(pParamName == null) throw new NullPointerException();
    this.pParamName = pParamName;
  }

  String pParamName() {
    return this.pParamName;
  }

  private String rParamName() {
    return this.mParamName.pParamName();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
<<<<<<< HEAD
<<<<<<< HEAD
    sb.append("    ParamName { Name = '");
=======
    sb.append("    ParamName { '");
>>>>>>> Add internals name in intermediate representation in args
=======
    sb.append("    ParamName { Name = '");
>>>>>>> Add cyclic semantic verification using component finder and progeny
    sb.append(rParamName());
    sb.append("' }");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

}
