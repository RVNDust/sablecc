/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

<<<<<<< HEAD
<<<<<<< HEAD
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
=======
import java.util.*;

>>>>>>> Mise à jour Visiteur - Build OK
public class MInternalStringSetter extends Macro{
>>>>>>> Changement Objectmacro-back
=======
>>>>>>> Revert "Changement Objectmacro-back"
=======
public class MInternalStringSetter extends Macro{
>>>>>>> MaJ Fichier de Macro + Generation
=======
>>>>>>> Revert "MaJ Fichier de Macro + Generation"

<<<<<<< HEAD
=======
=======
import java.util.*;

public class MInternalStringSetter extends Macro{

>>>>>>> object-macro2.1
    private String field_Name;


    public MInternalStringSetter(String pName){

        this.setPName(pName);


    }

    private void setPName( String pName ){
        if(pName == null){
            throw ObjectMacroException.parameterNull("Name");
        }

        this.field_Name = pName;
    }

    private String buildName(){

        return this.field_Name;
    }

    private String getName(){

        return this.field_Name;
    }


    @Override
    void apply(
            InternalsInitializer internalsInitializer){

        internalsInitializer.setInternalStringSetter(this);
    }

   @Override
    public String build(){

        BuildState buildState = this.build_state;

        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("InternalStringSetter");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;

        

        

        StringBuilder sb0 = new StringBuilder();

        sb0.append("    void set");
        sb0.append(buildName());
        sb0.append("(");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            Context context,");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            String value) ");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        if(value == null)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            throw new RuntimeException(\"value cannot be null here\");");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        this.field_");
        sb0.append(buildName());
        sb0.append(".put(context, value);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    }");

        buildState.setExpansion(sb0.toString());
        return sb0.toString();
    }

    @Override
    String build(Context context) {
        return build();
    }
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> Mise à jour Visiteur - Build OK
}
=======
}
>>>>>>> Correctifs objectmacro2-java(back)
=======
}
>>>>>>> object-macro2.1
