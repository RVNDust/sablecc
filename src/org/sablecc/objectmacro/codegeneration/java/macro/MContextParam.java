/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

<<<<<<< HEAD
public class MContextParam {

  public MContextParam() {
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Context context");
    return sb.toString();
  }

=======
import java.util.*;

public class MContextParam extends Macro{



    public MContextParam(){



    }





    @Override
    void apply(
            InternalsInitializer internalsInitializer){

        internalsInitializer.setContextParam(this);
    }

   @Override
    public String build(){

        BuildState buildState = this.build_state;

        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("ContextParam");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;

        

        

        StringBuilder sb0 = new StringBuilder();

        sb0.append("Context context");

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
