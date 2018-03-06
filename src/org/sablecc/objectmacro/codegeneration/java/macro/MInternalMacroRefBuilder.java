/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

public class MInternalMacroRefBuilder {

  private final String pInternalName;
  private final MInternalMacroRefBuilder mInternalMacroRefBuilder = this;

  public MInternalMacroRefBuilder(String pInternalName) {
    if(pInternalName == null) throw new NullPointerException();
    this.pInternalName = pInternalName;
  }

  String pInternalName() {
    return this.pInternalName;
  }

  private String rInternalName() {
    return this.mInternalMacroRefBuilder.pInternalName();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("    private String build");
    sb.append(rInternalName());
    sb.append("(Context context){");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        InternalValue macros = this.list_");
    sb.append(rInternalName());
    sb.append(".get(context);");
    sb.append(System.getProperty("line.separator"));
    sb.append("        return macros.build();");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

}
