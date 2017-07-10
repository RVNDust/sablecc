/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

public class MApplyNoneDirective {

  private final MParamMacroRefBuilder mParamMacroRefBuilder;

  MApplyNoneDirective(MParamMacroRefBuilder mParamMacroRefBuilder) {
    if(mParamMacroRefBuilder == null) throw new NullPointerException();
    this.mParamMacroRefBuilder = mParamMacroRefBuilder;
  }

  private String rName() {
    return this.mParamMacroRefBuilder.pName();
  }

  private String rIndexBuilder() {
    return this.mParamMacroRefBuilder.pIndexBuilder();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("        if(this.");
    sb.append(rName());
    sb.append("None != null){");
    sb.append(System.getProperty("line.separator"));
    sb.append("            sb");
    sb.append(rIndexBuilder());
    sb.append(".append(this.");
    sb.append(rName());
    sb.append("None.apply(i, \"\", nb_macros));");
    sb.append(System.getProperty("line.separator"));
    sb.append("        }");
    sb.append(System.getProperty("line.separator"));
    sb.append("        ");
    return sb.toString();
  }

}