/* This file was generated by SableCC's ObjectMacro. */

package org.test.back_old;

import java.util.*;

public class MF extends Macro{

    private final List<Macro> list_X;

    private DSeparator XSeparator;

    private DBeforeFirst XBeforeFirst;

    private DAfterLast XAfterLast;

    private DNone XNone;

    private final InternalValue XValue;

    private final List<Macro> list_Y;

    private DSeparator YSeparator;

    private DBeforeFirst YBeforeFirst;

    private DAfterLast YAfterLast;

    private DNone YNone;

    private final InternalValue YValue;

    private final Context XContext = new Context();
    private final Context YContext = new Context();

    public MF(){

    this.list_X = new ArrayList<>();
    this.list_Y = new ArrayList<>();

    this.XValue = new InternalValue(this.list_X, this.XContext);
    this.YValue = new InternalValue(this.list_Y, this.YContext);
    }

    public void addX(MG macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("X");
        }
                if(this.build_state != null){
            throw ObjectMacroException.cannotModify("F");
        }

        this.list_X.add(macro);
    }

    public void addY(MH macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("Y");
        }
                if(this.build_state != null){
            throw ObjectMacroException.cannotModify("F");
        }

        this.list_Y.add(macro);
    }

    private String buildX(){
        StringBuilder sb = new StringBuilder();
        Context local_context = XContext;
        List<Macro> macros = this.list_X;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if(this.XNone != null){
            sb.append(this.XNone.apply(i, "", nb_macros));
        }

        for(Macro macro : macros){
            expansion = macro.build(local_context);

            if(this.XBeforeFirst != null){
                expansion = this.XBeforeFirst.apply(i, expansion, nb_macros);
            }

            if(this.XAfterLast != null){
                expansion = this.XAfterLast.apply(i, expansion, nb_macros);
            }

            if(this.XSeparator != null){
                expansion = this.XSeparator.apply(i, expansion, nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
    }

    private String buildY(){
        StringBuilder sb = new StringBuilder();
        Context local_context = YContext;
        List<Macro> macros = this.list_Y;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if(this.YNone != null){
            sb.append(this.YNone.apply(i, "", nb_macros));
        }

        for(Macro macro : macros){
            expansion = macro.build(local_context);

            if(this.YBeforeFirst != null){
                expansion = this.YBeforeFirst.apply(i, expansion, nb_macros);
            }

            if(this.YAfterLast != null){
                expansion = this.YAfterLast.apply(i, expansion, nb_macros);
            }

            if(this.YSeparator != null){
                expansion = this.YSeparator.apply(i, expansion, nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
    }

    private InternalValue getX(){
        return this.XValue;
    }

    private InternalValue getY(){
        return this.YValue;
    }
    private void initXInternals(Context context){
        for(Macro macro : this.list_X){
            macro.apply(new InternalsInitializer("X"){
@Override
void setG(MG mG){

                mG.setZ(XContext, getY());
}
});
        }
    }

    private void initYInternals(Context context){
        for(Macro macro : this.list_Y){
            macro.apply(new InternalsInitializer("Y"){
@Override
void setH(MH mH){

        }
});
        }
    }

    private void initXDirectives(){
            }

    private void initYDirectives(){
            }
    @Override
    void apply(
            InternalsInitializer internalsInitializer){

        internalsInitializer.setF(this);
    }

    @Override
    public String build(){

        BuildState buildState = this.build_state;

        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("F");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;

                initXDirectives();
                initYDirectives();
        
                initXInternals(null);
                initYInternals(null);
        
        StringBuilder sb0 = new StringBuilder();

        sb0.append(buildY());
        sb0.append(" ");
        sb0.append(buildX());

        buildState.setExpansion(sb0.toString());
        return sb0.toString();
    }

    @Override
    String build(Context context) {
        return build();
    }
}
