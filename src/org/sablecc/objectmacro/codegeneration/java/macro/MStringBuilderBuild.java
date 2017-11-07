/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

public class MStringBuilderBuild {

  private final String pIndexBuilder;
  private final MStringBuilderBuild mStringBuilderBuild = this;

  public MStringBuilderBuild(String pIndexBuilder) {
    if(pIndexBuilder == null) throw new NullPointerException();
    this.pIndexBuilder = pIndexBuilder;
  }

  String pIndexBuilder() {
    return this.pIndexBuilder;
  }

  private String rIndexBuilder() {
    return this.mStringBuilderBuild.pIndexBuilder();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("sb");
    sb.append(rIndexBuilder());
    sb.append(".toString()");
    return sb.toString();
  }

}
