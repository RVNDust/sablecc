/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

<<<<<<< HEAD
public class MContextBuildState {

  public MContextBuildState() {
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("this.build_states.get(context)");
    return sb.toString();
  }

=======
import java.util.*;

public class MContextBuildState extends Macro{

    public MContextBuildState(){
    }
    @Override
    void apply(
            InternalsInitializer internalsInitializer){

        internalsInitializer.setContextBuildState(this);
    }

    @Override
    public String build(){

        BuildState buildState = this.build_state;

        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("ContextBuildState");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;

        
        
        StringBuilder sb0 = new StringBuilder();

        sb0.append("this.build_states.get(context)");

        buildState.setExpansion(sb0.toString());
        return sb0.toString();
    }

    @Override
    String build(Context context) {
        return build();
    }
>>>>>>> Mise à jour Visiteur - Build OK
}
