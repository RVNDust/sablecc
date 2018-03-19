/* This file was generated by SableCC's ObjectMacro. */

package org.test.back;

import java.util.*;

public class MK extends Macro{

    private Map<Context, String> field_A = new LinkedHashMap<>();


    public MK(){



    }

    void setA(
            Context context,
            String value) {

        if(value == null){
            throw new RuntimeException("value cannot be null here");
        }

        this.field_A.put(context, value);
    }

    private String buildA(Context context){

        return this.field_A.get(context);
    }

    private String getA(Context context){

        return this.field_A.get(context);
    }


    @Override
    void apply(
            InternalsInitializer internalsInitializer){

        internalsInitializer.setK(this);
    }

   @Override
    public String build(Context context){

        BuildState buildState = this.build_states.get(context);

        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("K");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_states.put(context, buildState);

        

        

        StringBuilder sb0 = new StringBuilder();

        sb0.append(buildA(context));

        buildState.setExpansion(sb0.toString());
        return sb0.toString();
    }

}