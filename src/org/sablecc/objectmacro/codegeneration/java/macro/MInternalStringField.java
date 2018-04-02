/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

<<<<<<< HEAD
<<<<<<< HEAD
public class MInternalStringField {

  private final String pName;
  private final MInternalStringField mInternalStringField = this;

  public MInternalStringField(String pName) {
    if(pName == null) throw new NullPointerException();
    this.pName = pName;
  }

  String pName() {
    return this.pName;
  }

  private String rName() {
    return this.mInternalStringField.pName();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("    private Map<Context, String> field_");
    sb.append(rName());
    sb.append(" = new LinkedHashMap<>();");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

=======
=======
>>>>>>> object-macro2.1
import java.util.*;

public class MInternalStringField extends Macro{

    private String field_Name;


    public MInternalStringField(String pName){

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

        internalsInitializer.setInternalStringField(this);
    }

   @Override
    public String build(){

        BuildState buildState = this.build_state;

        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("InternalStringField");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;

        

        

        StringBuilder sb0 = new StringBuilder();

        sb0.append("    private Map<Context, String> field_");
        sb0.append(buildName());
        sb0.append(" = new LinkedHashMap<>();");

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
