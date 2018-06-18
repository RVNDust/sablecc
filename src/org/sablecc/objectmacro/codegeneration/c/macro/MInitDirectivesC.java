/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.c.macro;

import java.util.*;

public class MInitDirectivesC extends Macro{
    
    private String field_ParamName;
    
    private final List<Macro> list_NewDirective;
    
    private DSeparator NewDirectiveSeparator;
    
    private DBeforeFirst NewDirectiveBeforeFirst;
    
    private DAfterLast NewDirectiveAfterLast;
    
    private DNone NewDirectiveNone;
    
    private final InternalValue NewDirectiveValue;
    
    private Map<Context, String> field_MacroName = new LinkedHashMap<>();
    
    
    private final Context NewDirectiveContext = new Context();
    
    
    public MInitDirectivesC(String pParamName){
    
            this.setPParamName(pParamName);
        this.list_NewDirective = new ArrayList<>();
    
        this.NewDirectiveValue = new InternalValue(this.list_NewDirective, this.NewDirectiveContext);
    }
    
    
    private void setPParamName( String pParamName ){
        if(pParamName == null){
            throw ObjectMacroException.parameterNull("ParamName");
        }
    
        this.field_ParamName = pParamName;
    }
    
    public void addNewDirective(MNewDirective macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("NewDirective");
        }
        
    
        this.list_NewDirective.add(macro);
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
    
    private String buildNewDirective(){
        StringBuilder sb = new StringBuilder();
        Context local_context = NewDirectiveContext;
        List<Macro> macros = this.list_NewDirective;
    
        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;
    
        if(this.NewDirectiveNone != null){
            sb.append(this.NewDirectiveNone.apply(i, "", nb_macros));
        }
    
        for(Macro macro : macros){
            expansion = macro.build(local_context);
    
            if(this.NewDirectiveBeforeFirst != null){
                expansion = this.NewDirectiveBeforeFirst.apply(i, expansion, nb_macros);
            }
    
            if(this.NewDirectiveAfterLast != null){
                expansion = this.NewDirectiveAfterLast.apply(i, expansion, nb_macros);
            }
    
            if(this.NewDirectiveSeparator != null){
                expansion = this.NewDirectiveSeparator.apply(i, expansion, nb_macros);
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
    
    private InternalValue getNewDirective(){
        return this.NewDirectiveValue;
    }
    
    private String getMacroName(Context context){
    
        return this.field_MacroName.get(context);
    }
    
    private void initNewDirectiveInternals(Context context){
        for(Macro macro : this.list_NewDirective){
            macro.apply(new InternalsInitializer("NewDirective"){
                @Override
                void setNewDirective(MNewDirective mNewDirective){
                
                    
                    mNewDirective.setMacroName(NewDirectiveContext, getMacroName(context));mNewDirective.setParamName(NewDirectiveContext, getParamName());
                }
            });
        }
    }
    
    
    private void initNewDirectiveDirectives(){
        StringBuilder sb0 = new StringBuilder();
        sb0.append(LINE_SEPARATOR);
        this.NewDirectiveSeparator = new DSeparator(sb0.toString());
        this.NewDirectiveValue.setSeparator(this.NewDirectiveSeparator);
    }
    
    @Override
     void apply(
             InternalsInitializer internalsInitializer){
    
         internalsInitializer.setInitDirectivesC(this);
     }
    
    
    @Override
    public String build(Context context){
    
        BuildState buildState = this.build_states.get(context);
    
        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("InitDirectivesC");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_states.put(context, buildState);
        List<String> indentations = new LinkedList<>();
        StringBuilder sbIndentation = new StringBuilder();
    
        initNewDirectiveDirectives();
        
        initNewDirectiveInternals(context);
    
        StringBuilder sb0 = new StringBuilder();
    
        sb0.append("void M");
        sb0.append(buildMacroName(context));
        sb0.append("_init");
        sb0.append(buildParamName());
        sb0.append("Directives(M");
        sb0.append(buildMacroName(context));
        sb0.append(" *this)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        StringBuilder sb1 = new StringBuilder();
        sbIndentation = new StringBuilder();
        sbIndentation.append("    ");
        indentations.add(sbIndentation.toString());
        sb1.append(buildNewDirective());
        sb0.append(applyIndent(sb1.toString(), indentations.remove(indentations.size() - 1)));
        sb0.append(LINE_SEPARATOR);
        sb0.append("}");
    
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