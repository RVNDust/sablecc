/* This file was generated by SableCC's ObjectMacro. */

package org.test.back_old;

import java.util.*;

public class MI extends Macro{

    private final List<Macro> list_Y;

    private DSeparator YSeparator;

    private DBeforeFirst YBeforeFirst;

    private DAfterLast YAfterLast;

    private DNone YNone;

    private final InternalValue YValue;

    private final List<Macro> list_Z;

    private DSeparator ZSeparator;

    private DBeforeFirst ZBeforeFirst;

    private DAfterLast ZAfterLast;

    private DNone ZNone;

    private final InternalValue ZValue;

    private final Context YContext = new Context();
    private final Context ZContext = new Context();

    public MI(){

    this.list_Y = new ArrayList<>();
    this.list_Z = new ArrayList<>();

    this.YValue = new InternalValue(this.list_Y, this.YContext);
    this.ZValue = new InternalValue(this.list_Z, this.ZContext);
    }

    public void addY(MK macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("Y");
        }
                if(this.build_state != null){
            throw ObjectMacroException.cannotModify("I");
        }

        this.list_Y.add(macro);
    }

    public void addZ(MK macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("Z");
        }
                if(this.build_state != null){
            throw ObjectMacroException.cannotModify("I");
        }

        this.list_Z.add(macro);
    }

    public void addZ(MJ macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("Z");
        }
                if(this.build_state != null){
            throw ObjectMacroException.cannotModify("I");
        }

        this.list_Z.add(macro);
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

    private String buildZ(){
        StringBuilder sb = new StringBuilder();
        Context local_context = ZContext;
        List<Macro> macros = this.list_Z;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if(this.ZNone != null){
            sb.append(this.ZNone.apply(i, "", nb_macros));
        }

        for(Macro macro : macros){
            expansion = macro.build(local_context);

            if(this.ZBeforeFirst != null){
                expansion = this.ZBeforeFirst.apply(i, expansion, nb_macros);
            }

            if(this.ZAfterLast != null){
                expansion = this.ZAfterLast.apply(i, expansion, nb_macros);
            }

            if(this.ZSeparator != null){
                expansion = this.ZSeparator.apply(i, expansion, nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
    }

    private InternalValue getY(){
        return this.YValue;
    }

    private InternalValue getZ(){
        return this.ZValue;
    }
    private void initYInternals(Context context){
        for(Macro macro : this.list_Y){
            macro.apply(new InternalsInitializer("Y"){
@Override
void setK(MK mK){

            StringBuilder sb1 = new StringBuilder();

        sb1.append("lala");
            mK.setA(YContext, sb1.toString());
}
});
        }
    }

    private void initZInternals(Context context){
        for(Macro macro : this.list_Z){
            macro.apply(new InternalsInitializer("Z"){
@Override
void setK(MK mK){

            StringBuilder sb1 = new StringBuilder();

        sb1.append("On est dans i");
            mK.setA(ZContext, sb1.toString());
}
@Override
void setJ(MJ mJ){

                mJ.setY(ZContext, getY());
}
});
        }
    }

    private void initYDirectives(){
            }

    private void initZDirectives(){
            }
    @Override
    void apply(
            InternalsInitializer internalsInitializer){

        internalsInitializer.setI(this);
    }

    @Override
    public String build(){

        BuildState buildState = this.build_state;

        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("I");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;

                initYDirectives();
                initZDirectives();
        
                initYInternals(null);
                initZInternals(null);
        
        StringBuilder sb0 = new StringBuilder();

        sb0.append(buildY());
        sb0.append(LINE_SEPARATOR);
        sb0.append(buildZ());

        buildState.setExpansion(sb0.toString());
        return sb0.toString();
    }

    @Override
    String build(Context context) {
        return build();
    }
}
