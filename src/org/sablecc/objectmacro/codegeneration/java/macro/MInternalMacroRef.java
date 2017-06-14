/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

public class MInternalMacroRef {

  private final String pParamName;
  private final MInternalMacroRef mInternalMacroRef = this;

  public MInternalMacroRef(String pParamName) {
    if(pParamName == null) throw new NullPointerException();
    this.pParamName = pParamName;
  }

  String pParamName() {
    return this.pParamName;
  }

  private String rParamName() {
    return this.mInternalMacroRef.pParamName();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("    private InternalValue get");
    sb.append(rParamName());
    sb.append("(Context context){");
    sb.append(System.getProperty("line.separator"));
    sb.append("        return this.list_");
    sb.append(rParamName());
    sb.append(".get(context);");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

}
