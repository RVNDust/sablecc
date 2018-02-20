/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

<<<<<<< HEAD
<<<<<<< HEAD
public class MInternalMacroSetter {

  private final String pParamName;
  private final MInternalMacroSetter mInternalMacroSetter = this;

  public MInternalMacroSetter(String pParamName) {
    if(pParamName == null) throw new NullPointerException();
    this.pParamName = pParamName;
  }

  String pParamName() {
    return this.pParamName;
  }

  private String rParamName() {
    return this.mInternalMacroSetter.pParamName();
=======
import java.util.*;

=======
>>>>>>> Add structure which contains list of macros and the context associated
public class MInternalMacroSetter {

  private final String pParamName;
  private final MInternalMacroSetter mInternalMacroSetter = this;

  public MInternalMacroSetter(String pParamName) {
    if(pParamName == null) throw new NullPointerException();
    this.pParamName = pParamName;
  }

  String pParamName() {
    return this.pParamName;
  }

<<<<<<< HEAD
  private String rName() {
    return this.mInternalMacroSetter.pName();
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
  private String rParamName() {
    return this.mInternalMacroSetter.pParamName();
>>>>>>> Init internals before building the macro instead at the add or addAll methods
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("    void set");
<<<<<<< HEAD
<<<<<<< HEAD
    sb.append(rParamName());
=======
    sb.append(rName());
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
    sb.append(rParamName());
>>>>>>> Init internals before building the macro instead at the add or addAll methods
    sb.append("(");
    sb.append(System.getProperty("line.separator"));
    sb.append("            Context context,");
    sb.append(System.getProperty("line.separator"));
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    sb.append("            InternalValue internal_value) {");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        if(internal_value == null){");
    sb.append(System.getProperty("line.separator"));
    sb.append("            throw new RuntimeException(\"macros cannot be null\");");
=======
    sb.append("            Macro macros[]) {");
=======
    sb.append("            List<Macro> macros) {");
>>>>>>> Removed in constructor initialization and add lazy initialization
=======
    sb.append("            InternalValue internal_value) {");
>>>>>>> Add structure which contains list of macros and the context associated
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        if(internal_value == null){");
    sb.append(System.getProperty("line.separator"));
    sb.append("            throw new RuntimeException(\"macros cannot be null\");");
    sb.append(System.getProperty("line.separator"));
    sb.append("        }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
<<<<<<< HEAD
    sb.append("        final List<Macro> tempMacros = new ArrayList<>();");
    sb.append(System.getProperty("line.separator"));
    sb.append("        int i = 0;");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        for(Macro macro : macros){");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("            if(macro == null){");
    sb.append(System.getProperty("line.separator"));
    sb.append("                throw ObjectMacroException.macroNull(i, \"param_name\");");
    sb.append(System.getProperty("line.separator"));
    sb.append("            }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("            ");
    for(Object oApplyInternalsInitializer : this.eApplyInternalsInitializer) {
      sb.append(oApplyInternalsInitializer.toString());
    }
    sb.append(System.getProperty("line.separator"));
<<<<<<< HEAD
    sb.append("            tempMacros[i++] = macro;");
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
    sb.append("            tempMacros.add(macro);");
>>>>>>> Removed in constructor initialization and add lazy initialization
    sb.append(System.getProperty("line.separator"));
    sb.append("        }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
=======
>>>>>>> Add structure which contains list of macros and the context associated
    sb.append("        this.list_");
<<<<<<< HEAD
<<<<<<< HEAD
    sb.append(rParamName());
    sb.append(".put(context, internal_value);");
=======
    sb.append(rName());
=======
    sb.append(rParamName());
<<<<<<< HEAD
>>>>>>> Init internals before building the macro instead at the add or addAll methods
    sb.append(".put(context, tempMacros);");
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
    sb.append(".put(context, internal_value);");
>>>>>>> Add structure which contains list of macros and the context associated
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

}
