/* This file was generated by SableCC's ObjectMacro. */

package org.test.back;

import java.util.*;

public class MB extends Macro{

    private String field_O;
    private final List<Macro> list_S;
    private DSeparator SSeparator;

    private DBeforeFirst SBeforeFirst;

    private DAfterLast SAfterLast;

    private DNone SNone;
    private final InternalValue SValue;
    private Map<Context, InternalValue> list_P = new LinkedHashMap<>();

    private final Context SContext = new Context();

    public MB(String pO){

        this.setPO(pO);

    this.list_S = new ArrayList<>();

    this.SValue = new InternalValue(this.list_S, this.SContext);
    }

    private void setPO( String pO ){
        if(pO == null){
            throw ObjectMacroException.parameterNull("O");
        }

        this.field_O = pO;
    }
    public void addS(MC macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("S");
        }
        

        this.list_S.add(macro);
    }
    void setP(
                Context context,
                InternalValue internal_value) {

            if(internal_value == null){
                throw new RuntimeException("macros cannot be null");
            }

            this.list_P.put(context, internal_value);
        }

    private String buildO(){

        return this.field_O;
    }
    private String buildS(){
        StringBuilder sb = new StringBuilder();
        Context local_context = SContext;
        List<Macro> macros = this.list_S;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if(this.SNone != null){
            sb.append(this.SNone.apply(i, "", nb_macros));
        }

        for(Macro macro : macros){
            expansion = macro.build(local_context);

            if(this.SBeforeFirst != null){
                expansion = this.SBeforeFirst.apply(i, expansion, nb_macros);
            }

            if(this.SAfterLast != null){
                expansion = this.SAfterLast.apply(i, expansion, nb_macros);
            }

            if(this.SSeparator != null){
                expansion = this.SSeparator.apply(i, expansion, nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
    }
    private String buildP(){
        StringBuilder sb = new StringBuilder();
        Context local_context = context;
        List<Macro> macros = this.list_P;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if(this.PNone != null){
            sb.append(this.PNone.apply(i, "", nb_macros));
        }

        for(Macro macro : macros){
            expansion = macro.build(local_context);

            if(this.PBeforeFirst != null){
                expansion = this.PBeforeFirst.apply(i, expansion, nb_macros);
            }

            if(this.PAfterLast != null){
                expansion = this.PAfterLast.apply(i, expansion, nb_macros);
            }

            if(this.PSeparator != null){
                expansion = this.PSeparator.apply(i, expansion, nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
    }

    private String getO(){

        return this.field_O;
    }
    private InternalValue getS(){
        return this.SValue;
    }
    private InternalValue getP(Context context){
        return this.list_P.get(context);
    }
    private void initSInternals(Context context){
        for(Macro macro : this.list_S){
            macro.apply(new InternalsInitializer("S"){
@Override
void setC(MC mC){

    
            mC.setQ(SContext, getO());        mC.setR(SContext, getO());
}
});
        }
    }

    private void initSDirectives(){
        
    }
    @Override
    void apply(
            InternalsInitializer internalsInitializer){

        internalsInitializer.setB(this);
    }

   @Override
    public String build(Context context){

        BuildState buildState = this.build_states.get(context);

        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("B");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_states.put(context, buildState);

        initSDirectives();

        initSInternals(context);

        StringBuilder sb0 = new StringBuilder();

        sb0.append("============== B ===============");
        sb0.append(LINE_SEPARATOR);
        sb0.append("P : ");
        sb0.append(buildP(context));
        sb0.append(LINE_SEPARATOR);
        sb0.append("S : ");
        sb0.append(buildS());

        buildState.setExpansion(sb0.toString());
        return sb0.toString();
    }

}