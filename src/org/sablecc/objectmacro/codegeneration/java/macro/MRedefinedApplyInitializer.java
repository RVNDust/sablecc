/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

<<<<<<< HEAD
public class MRedefinedApplyInitializer {

  private final String pName;
  private final MRedefinedApplyInitializer mRedefinedApplyInitializer = this;

  public MRedefinedApplyInitializer(String pName) {
    if(pName == null) throw new NullPointerException();
    this.pName = pName;
  }

  String pName() {
    return this.pName;
  }

  private String rName() {
    return this.mRedefinedApplyInitializer.pName();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("    @Override");
    sb.append(System.getProperty("line.separator"));
    sb.append("    void apply(");
    sb.append(System.getProperty("line.separator"));
    sb.append("            InternalsInitializer internalsInitializer){");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        internalsInitializer.set");
    sb.append(rName());
    sb.append("(this);");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

=======
import java.util.*;

public class MRedefinedApplyInitializer extends Macro{

    private String field_Name;

    public MRedefinedApplyInitializer(String pName){

        this.setPName(pName);
    }

    private void setPName(String pName){
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

        internalsInitializer.setRedefinedApplyInitializer(this);
    }

    @Override
    public String build(){

        BuildState buildState = this.build_state;

        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("RedefinedApplyInitializer");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;

        
        
        StringBuilder sb0 = new StringBuilder();

        sb0.append("    @Override");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    void apply(");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            InternalsInitializer internalsInitializer)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        internalsInitializer.set");
        sb0.append(buildName());
        sb0.append("(this);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    }");

        buildState.setExpansion(sb0.toString());
        return sb0.toString();
    }

    @Override
    String build(Context context) {
        return build();
    }
>>>>>>> Mise à jour Visiteur - Build OK
}
