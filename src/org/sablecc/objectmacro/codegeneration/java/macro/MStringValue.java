/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

public class MStringValue {

  private final String pString;
  private final MStringValue mStringValue = this;

  public MStringValue(String pString) {
    if(pString == null) throw new NullPointerException();
    this.pString = pString;
  }

  String pString() {
    return this.pString;
  }

  private String rString() {
    return this.mStringValue.pString();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("\"");
    sb.append(rString());
    sb.append("\"");
    return sb.toString();
  }

}
