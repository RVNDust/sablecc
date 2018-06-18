/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.c.macro;

import java.util.*;

public class MInitInternalsCall extends Macro{
    
    private String field_ParamName;
    
    private final List<Macro> list_ContextArg;
    
    private DSeparator ContextArgSeparator;
    
    private DBeforeFirst ContextArgBeforeFirst;
    
    private DAfterLast ContextArgAfterLast;
    
    private DNone ContextArgNone;
    
    private final InternalValue ContextArgValue;
    
    private Map<Context, String> field_MacroName = new LinkedHashMap<>();
    
    
    private final Context ContextArgContext = new Context();
    
    
    public MInitInternalsCall(String pParamName){
    
            this.setPParamName(pParamName);
        this.list_ContextArg = new ArrayList<>();
    
        this.ContextArgValue = new InternalValue(this.list_ContextArg, this.ContextArgContext);
    }
    
    
    private void setPParamName( String pParamName ){
        if(pParamName == null){
            throw ObjectMacroException.parameterNull("ParamName");
        }
    
        this.field_ParamName = pParamName;
    }
    
    public void addContextArg(MContextArg macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("ContextArg");
        }
        
    
        this.list_ContextArg.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }
    
        void setMacroName(
                Context context,
                String value) {
    
            if(value == null){
                throw new RuntimeException("value cannot be null here");
            }
    
            this.field_MacroName.put(context, value);
        }
    
    
    private String buildParamName(){
    
        return this.field_ParamName;
    }
    
    private String buildContextArg(){
        StringBuilder sb = new StringBuilder();
        Context local_context = ContextArgContext;
        List<Macro> macros = this.list_ContextArg;
    
        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;
    
        if(this.ContextArgNone != null){
            sb.append(this.ContextArgNone.apply(i, "", nb_macros));
        }
    
        for(Macro macro : macros){
            expansion = macro.build(local_context);
    
            if(this.ContextArgBeforeFirst != null){
                expansion = this.ContextArgBeforeFirst.apply(i, expansion, nb_macros);
            }
    
            if(this.ContextArgAfterLast != null){
                expansion = this.ContextArgAfterLast.apply(i, expansion, nb_macros);
            }
    
            if(this.ContextArgSeparator != null){
                expansion = this.ContextArgSeparator.apply(i, expansion, nb_macros);
            }
    
            sb.append(expansion);
            i++;
        }
    
        return sb.toString();
    }
    
    private String buildMacroName(Context context){
    
        return this.field_MacroName.get(context);
    }
    
    
    private String getParamName(){
    
        return this.field_ParamName;
    }
    
    private InternalValue getContextArg(){
        return this.ContextArgValue;
    }
    
    private String getMacroName(Context context){
    
        return this.field_MacroName.get(context);
    }
    
    private void initContextArgInternals(Context context){
        for(Macro macro : this.list_ContextArg){
            macro.apply(new InternalsInitializer("ContextArg"){
                @Override
                void setContextArg(MContextArg mContextArg){
                
                    
                    
                }
            });
        }
    }
    
    
    private void initContextArgDirectives(){
        StringBuilder sb0 = new StringBuilder();
        sb0.append("NULL");
        this.ContextArgNone = new DNone(sb0.toString());
        this.ContextArgValue.setNone(this.ContextArgNone);
    }
    
    @Override
     void apply(
             InternalsInitializer internalsInitializer){
    
         internalsInitializer.setInitInternalsCall(this);
     }
    
    
    @Override
    public String build(Context context){
    
        BuildState buildState = this.build_states.get(context);
    
        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("InitInternalsCall");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_states.put(context, buildState);
        List<String> indentations = new LinkedList<>();
        StringBuilder sbIndentation = new StringBuilder();
    
        initContextArgDirectives();
        
        initContextArgInternals(context);
    
        StringBuilder sb0 = new StringBuilder();
    
        sb0.append("M");
        sb0.append(buildMacroName(context));
        sb0.append("_init");
        sb0.append(buildParamName());
        sb0.append("Internals(");
        sb0.append(buildContextArg());
        sb0.append(");");
    
        buildState.setExpansion(sb0.toString());
        return sb0.toString();
    }
    
    
    private String applyIndent(
                            String macro,
                            String indent){

            StringBuilder sb = new StringBuilder();
            String[] lines = macro.split( "\n");

            if(lines.length > 1){
                for(int i = 0; i < lines.length; i++){
                    String line = lines[i];
                    sb.append(indent).append(line);

                    if(i < lines.length - 1){
                        sb.append(LINE_SEPARATOR);
                    }
                }
            }
            else{
                sb.append(indent).append(macro);
            }

            return sb.toString();
    }
}