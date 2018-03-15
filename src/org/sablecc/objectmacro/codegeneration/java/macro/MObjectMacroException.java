/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;

public class MObjectMacroException {

  private final List<Object> ePackageDeclaration = new LinkedList<Object>();

  public MObjectMacroException() {
  }

  public MPackageDeclaration newPackageDeclaration(String pPackageName) {
    MPackageDeclaration lPackageDeclaration = new MPackageDeclaration(pPackageName);
    this.ePackageDeclaration.add(lPackageDeclaration);
    return lPackageDeclaration;
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
    sb.append(System.getProperty("line.separator"));
    sb.append("public class ObjectMacroException");
    sb.append(System.getProperty("line.separator"));
    sb.append("        extends RuntimeException{");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    private ObjectMacroException(");
    sb.append(System.getProperty("line.separator"));
    sb.append("            String message){");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        super(message);");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        if(message == null){");
    sb.append(System.getProperty("line.separator"));
    sb.append("            throw new RuntimeException(\"message may not be null\");");
    sb.append(System.getProperty("line.separator"));
    sb.append("        }");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    private ObjectMacroException(");
    sb.append(System.getProperty("line.separator"));
    sb.append("            String message,");
    sb.append(System.getProperty("line.separator"));
    sb.append("            Throwable cause) {");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        super(message, cause);");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        if (message == null) {");
    sb.append(System.getProperty("line.separator"));
    sb.append("            throw new RuntimeException(\"message may not be null\");");
    sb.append(System.getProperty("line.separator"));
    sb.append("        }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        if (cause == null) {");
    sb.append(System.getProperty("line.separator"));
    sb.append("            throw new RuntimeException(\"cause may not be null\");");
    sb.append(System.getProperty("line.separator"));
    sb.append("        }");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    static ObjectMacroException incorrectType(");
    sb.append(System.getProperty("line.separator"));
    sb.append("            String type,");
    sb.append(System.getProperty("line.separator"));
    sb.append("            String param_name){");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        return new ObjectMacroException(");
    sb.append(System.getProperty("line.separator"));
    sb.append("                new MIncorrectType(type, param_name).toString());");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    static ObjectMacroException macroNull(");
    sb.append(System.getProperty("line.separator"));
    sb.append("            Integer index,");
    sb.append(System.getProperty("line.separator"));
    sb.append("            String paramName){");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        return new ObjectMacroException(");
    sb.append(System.getProperty("line.separator"));
    sb.append("                new MMacroNullInList(String.valueOf(index), paramName).toString());");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    static ObjectMacroException parameterNull(");
    sb.append(System.getProperty("line.separator"));
    sb.append("            String paramName){");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        return new ObjectMacroException(new MParameterNull(paramName).toString());");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Init internals before building the macro instead at the add or addAll methods
=======
>>>>>>> Revert "MaJ Fichier de Macro + Generation"
    sb.append("    static ObjectMacroException cyclicReference(");
    sb.append(System.getProperty("line.separator"));
    sb.append("            String macroName){");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        return new ObjectMacroException(new MCyclicReference(macroName).toString());");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    static ObjectMacroException cannotModify(");
    sb.append(System.getProperty("line.separator"));
    sb.append("            String macroName){");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        return new ObjectMacroException(new MCannotModify(macroName).toString());");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
>>>>>>> Init internals before building the macro instead at the add or addAll methods
=======
>>>>>>> Revert "MaJ Fichier de Macro + Generation"
    sb.append("}");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

}
