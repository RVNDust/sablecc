/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Revert "Changement Objectmacro-back"
=======
>>>>>>> Revert "MaJ Fichier de Macro + Generation"
public class MInternalStringSetter {

  private final String pName;
  private final MInternalStringSetter mInternalStringSetter = this;

  public MInternalStringSetter(String pName) {
    if(pName == null) throw new NullPointerException();
    this.pName = pName;
  }

  String pName() {
    return this.pName;
  }

  private String rName() {
    return this.mInternalStringSetter.pName();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    sb.append("    void set");
=======
    sb.append("    public void set");
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
    sb.append("    void set");
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
=======
    sb.append("    void set");
>>>>>>> Revert "Changement Objectmacro-back"
=======
    sb.append("    void set");
>>>>>>> Revert "MaJ Fichier de Macro + Generation"
    sb.append(rName());
    sb.append("(");
    sb.append(System.getProperty("line.separator"));
    sb.append("            Context context,");
    sb.append(System.getProperty("line.separator"));
    sb.append("            String value) {");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        if(value == null){");
    sb.append(System.getProperty("line.separator"));
    sb.append("            throw new RuntimeException(\"value cannot be null here\");");
    sb.append(System.getProperty("line.separator"));
    sb.append("        }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        this.field_");
    sb.append(rName());
    sb.append(".put(context, value);");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }
<<<<<<< HEAD
<<<<<<< HEAD
=======
public class MInternalStringSetter extends Macro{
>>>>>>> Changement Objectmacro-back
=======
>>>>>>> Revert "Changement Objectmacro-back"
=======
public class MInternalStringSetter extends Macro{
>>>>>>> MaJ Fichier de Macro + Generation
=======
>>>>>>> Revert "MaJ Fichier de Macro + Generation"

}
