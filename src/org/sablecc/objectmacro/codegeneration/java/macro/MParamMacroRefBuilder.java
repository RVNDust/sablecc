/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;

public class MParamMacroRefBuilder {

  private final String pName;
  private final String pIndexBuilder;
  private final MParamMacroRefBuilder mParamMacroRefBuilder = this;
  private final List<Object> eContextParam = new LinkedList<Object>();
  private final List<Object> eContextName = new LinkedList<Object>();
  private final List<Object> eGetInternalTail = new LinkedList<Object>();
  private final List<Object> eNone = new LinkedList<Object>();
  private final List<Object> eBeforeFirst = new LinkedList<Object>();
  private final List<Object> eSeparator = new LinkedList<Object>();
  private final List<Object> eAfterLast = new LinkedList<Object>();

  public MParamMacroRefBuilder(String pName, String pIndexBuilder) {
    if(pName == null) throw new NullPointerException();
    this.pName = pName;
    if(pIndexBuilder == null) throw new NullPointerException();
    this.pIndexBuilder = pIndexBuilder;
  }

  public MContextParam newContextParam() {
    MContextParam lContextParam = new MContextParam();
    this.eContextParam.add(lContextParam);
    return lContextParam;
  }

  public MContextName newContextName(String pContextName) {
    MContextName lContextName = new MContextName(pContextName);
    this.eContextName.add(lContextName);
    return lContextName;
  }

  public MGetInternalTail newGetInternalTail() {
    MGetInternalTail lGetInternalTail = new MGetInternalTail();
    this.eGetInternalTail.add(lGetInternalTail);
    return lGetInternalTail;
  }

  public MNone newNone() {
    MNone lNone = new MNone();
    this.eNone.add(lNone);
    return lNone;
  }

  public MBeforeFirst newBeforeFirst() {
    MBeforeFirst lBeforeFirst = new MBeforeFirst();
    this.eBeforeFirst.add(lBeforeFirst);
    return lBeforeFirst;
  }

  public MSeparator newSeparator() {
    MSeparator lSeparator = new MSeparator();
    this.eSeparator.add(lSeparator);
    return lSeparator;
  }

  public MAfterLast newAfterLast() {
    MAfterLast lAfterLast = new MAfterLast();
    this.eAfterLast.add(lAfterLast);
    return lAfterLast;
  }

  String pName() {
    return this.pName;
  }

  String pIndexBuilder() {
    return this.pIndexBuilder;
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
    sb.append("    private String build");
    sb.append(rName());
    sb.append("(");
    for(Object oContextParam : this.eContextParam) {
      sb.append(oContextParam.toString());
    }
    sb.append("){");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        StringBuilder sb");
    sb.append(rIndexBuilder());
    sb.append(" = new StringBuilder();");
    sb.append(System.getProperty("line.separator"));
    sb.append("        Context local_context = ");
    if(this.eContextName.size() == 0) {
      sb.append("context");
    }
    for(Object oContextName : this.eContextName) {
      sb.append(oContextName.toString());
    }
    sb.append(";");
    sb.append(System.getProperty("line.separator"));
    sb.append("        Macro macros[] = this.list_");
    sb.append(rName());
    for(Object oGetInternalTail : this.eGetInternalTail) {
      sb.append(oGetInternalTail.toString());
    }
    sb.append(";");
    sb.append(System.getProperty("line.separator"));
    sb.append("        ");
    for(Object oNone : this.eNone) {
      sb.append(oNone.toString());
    }
    sb.append("        boolean first = true;");
    sb.append(System.getProperty("line.separator"));
    sb.append("        int i = 0;");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        for(Macro macro : macros){");
    sb.append(System.getProperty("line.separator"));
    sb.append("            ");
    for(Object oBeforeFirst : this.eBeforeFirst) {
      sb.append(oBeforeFirst.toString());
    }
    sb.append("            ");
    for(Object oSeparator : this.eSeparator) {
      sb.append(oSeparator.toString());
    }
    sb.append(System.getProperty("line.separator"));
    sb.append("            sb");
    sb.append(rIndexBuilder());
    sb.append(".append(macro.build(local_context));");
    sb.append(System.getProperty("line.separator"));
    sb.append("            i++;");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("            ");
    for(Object oAfterLast : this.eAfterLast) {
      sb.append(oAfterLast.toString());
    }
    sb.append("        }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        return sb");
    sb.append(rIndexBuilder());
    sb.append(".toString();");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

}
