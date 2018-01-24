/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;

public class MSuperMacro {

  private final List<Object> ePackageDeclaration = new LinkedList<Object>();
  private final List<Object> eImportJavaUtil = new LinkedList<Object>();

  public MSuperMacro() {
  }

  public MPackageDeclaration newPackageDeclaration(String pPackageName) {
    MPackageDeclaration lPackageDeclaration = new MPackageDeclaration(pPackageName);
    this.ePackageDeclaration.add(lPackageDeclaration);
    return lPackageDeclaration;
  }

  public MImportJavaUtil newImportJavaUtil() {
    MImportJavaUtil lImportJavaUtil = new MImportJavaUtil();
    this.eImportJavaUtil.add(lImportJavaUtil);
    return lImportJavaUtil;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(new MHeader().toString());
    if(this.ePackageDeclaration.size() > 0) {
      sb.append(System.getProperty("line.separator"));
    }
    for(Object oPackageDeclaration : this.ePackageDeclaration) {
      sb.append(oPackageDeclaration.toString());
    }
    for(Object oImportJavaUtil : this.eImportJavaUtil) {
      sb.append(oImportJavaUtil.toString());
    }
    sb.append(System.getProperty("line.separator"));
    sb.append("public abstract class Macro {");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
<<<<<<< HEAD
    sb.append("    final static String LINE_SEPARATOR = System.getProperty(\"line.separator\");");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    BuildState build_state = null;");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    final Map<Context, BuildState> build_states = new LinkedHashMap<>();");
=======
    sb.append("    public final static String LINE_SEPARATOR = System.getProperty(\"line.separator\");");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    public String expansion;");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    public boolean built = false;");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    public Map<Context, String> expansions = new LinkedHashMap<>();");
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    public String build(){");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        throw new RuntimeException(\"build cannot be invoked here\");");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    String build(");
    sb.append(System.getProperty("line.separator"));
    sb.append("            Context context){");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        throw new RuntimeException(\"build cannot be invoked here\");");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    void apply(");
    sb.append(System.getProperty("line.separator"));
    sb.append("            InternalsInitializer internalsInitializer){");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        throw new RuntimeException(\"apply cannot be called here\");");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("}");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

}
