/* This file was generated by SableCC's ObjectMacro. */

package org.test.back;

import java.util.*;

public class MH extends Macro{

    private final List<Macro> list_Lala;
    private DSeparator LalaSeparator;

    private DBeforeFirst LalaBeforeFirst;

    private DAfterLast LalaAfterLast;

    private DNone LalaNone;
    private final InternalValue LalaValue;

    private final Context LalaContext = new Context();

    public MH(){


    this.list_Lala = new ArrayList<>();

    this.LalaValue = new InternalValue(this.list_Lala, this.LalaContext);
    }

    public void addLala(MF macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("Lala");
        }
                if(this.build_state != null){
            throw ObjectMacroException.cannotModify("F");
        }

        this.list_Lala.add(macro);
    }

    private String buildLala(){
        StringBuilder sb = new StringBuilder();
        Context local_context = LalaContext;
        List<Macro> macros = this.list_Lala;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if(this.LalaNone != null){
            sb.append(this.LalaNone.apply(i, "", nb_macros));
        }

        for(Macro macro : macros){
            expansion = macro.build(local_context);

            if(this.LalaBeforeFirst != null){
                expansion = this.LalaBeforeFirst.apply(i, expansion, nb_macros);
            }

            if(this.LalaAfterLast != null){
                expansion = this.LalaAfterLast.apply(i, expansion, nb_macros);
            }

            if(this.LalaSeparator != null){
                expansion = this.LalaSeparator.apply(i, expansion, nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
    }

    private InternalValue getLala(){
        return this.LalaValue;
    }
    private void initLalaInternals(Context context){
        for(Macro macro : this.list_Lala){
            macro.apply(new InternalsInitializer("Lala"){
@Override
void setF(MF mF){

    
    
}
});
        }
    }

    private void initLalaDirectives(){
        
    }
    @Override
    void apply(
            InternalsInitializer internalsInitializer){

        internalsInitializer.setH(this);
    }

   @Override
    public String build(){

        BuildState buildState = this.build_state;

        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("H");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;

        initLalaDirectives();

        initLalaInternals(null);

        StringBuilder sb0 = new StringBuilder();

        sb0.append(buildLala());

        buildState.setExpansion(sb0.toString());
        return sb0.toString();
    }

    @Override
    String build(Context context) {
        return build();
    }
}