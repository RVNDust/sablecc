/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

<<<<<<< HEAD
public class MStringParam {
=======
import java.util.*;

public class MStringParam extends Macro{
<<<<<<< HEAD
>>>>>>> Mise à jour Visiteur - Build OK

  private final String pName;
  private final MStringParam mStringParam = this;

  public MStringParam(String pName) {
    if(pName == null) throw new NullPointerException();
    this.pName = pName;
  }

  String pName() {
    return this.pName;
  }

  private String rName() {
    return this.mStringParam.pName();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("String p");
    sb.append(rName());
    return sb.toString();
  }

<<<<<<< HEAD
=======
=======

    private String field_Name;


    public MStringParam(String pName){

        this.setPName(pName);


    }

    private void setPName( String pName ){
        if(pName == null){
            throw ObjectMacroException.parameterNull("Name");
        }

        this.field_Name = pName;
    }

>>>>>>> Correctifs objectmacro2-java(back)
    private String buildName(){

        return this.field_Name;
    }

    private String getName(){

        return this.field_Name;
    }


    @Override
    void apply(
            InternalsInitializer internalsInitializer){

        internalsInitializer.setStringParam(this);
    }

   @Override
    public String build(){

        BuildState buildState = this.build_state;

        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("StringParam");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;

        

        

        StringBuilder sb0 = new StringBuilder();

        sb0.append("String p");
        sb0.append(buildName());

        buildState.setExpansion(sb0.toString());
        return sb0.toString();
    }

    @Override
    String build(Context context) {
        return build();
    }
<<<<<<< HEAD
>>>>>>> Mise à jour Visiteur - Build OK
}
=======
}
>>>>>>> Correctifs objectmacro2-java(back)
