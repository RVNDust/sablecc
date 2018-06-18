/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.c.macro;

import java.util.*;

public class MInternalsInitializerC extends Macro{
    
    private final List<Macro> list_ParentInternalsSetterC;
    
    private DSeparator ParentInternalsSetterCSeparator;
    
    private DBeforeFirst ParentInternalsSetterCBeforeFirst;
    
    private DAfterLast ParentInternalsSetterCAfterLast;
    
    private DNone ParentInternalsSetterCNone;
    
    private final InternalValue ParentInternalsSetterCValue;
    
    private final List<Macro> list_Includes;
    
    private DSeparator IncludesSeparator;
    
    private DBeforeFirst IncludesBeforeFirst;
    
    private DAfterLast IncludesAfterLast;
    
    private DNone IncludesNone;
    
    private final InternalValue IncludesValue;
    
    
    private final Context ParentInternalsSetterCContext = new Context();
    
    private final Context IncludesContext = new Context();
    
    
    public MInternalsInitializerC(){
    
        this.list_ParentInternalsSetterC = new ArrayList<>();
        this.list_Includes = new ArrayList<>();
    
        this.ParentInternalsSetterCValue = new InternalValue(this.list_ParentInternalsSetterC, this.ParentInternalsSetterCContext);
        this.IncludesValue = new InternalValue(this.list_Includes, this.IncludesContext);
    }
    
    
    public void addParentInternalsSetterC(MParentInternalsSetterC macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("ParentInternalsSetterC");
        }
                if(this.build_state != null){
                    throw ObjectMacroException.cannotModify("ParentInternalsSetterC");
                }
    
        this.list_ParentInternalsSetterC.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }
    
    public void addIncludes(MInclude macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("Includes");
        }
                if(this.build_state != null){
                    throw ObjectMacroException.cannotModify("Include");
                }
    
        this.list_Includes.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }
    
    
    private String buildParentInternalsSetterC(){
        StringBuilder sb = new StringBuilder();
        Context local_context = ParentInternalsSetterCContext;
        List<Macro> macros = this.list_ParentInternalsSetterC;
    
        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;
    
        if(this.ParentInternalsSetterCNone != null){
            sb.append(this.ParentInternalsSetterCNone.apply(i, "", nb_macros));
        }
    
        for(Macro macro : macros){
            expansion = macro.build(local_context);
    
            if(this.ParentInternalsSetterCBeforeFirst != null){
                expansion = this.ParentInternalsSetterCBeforeFirst.apply(i, expansion, nb_macros);
            }
    
            if(this.ParentInternalsSetterCAfterLast != null){
                expansion = this.ParentInternalsSetterCAfterLast.apply(i, expansion, nb_macros);
            }
    
            if(this.ParentInternalsSetterCSeparator != null){
                expansion = this.ParentInternalsSetterCSeparator.apply(i, expansion, nb_macros);
            }
    
            sb.append(expansion);
            i++;
        }
    
        return sb.toString();
    }
    
    private String buildIncludes(){
        StringBuilder sb = new StringBuilder();
        Context local_context = IncludesContext;
        List<Macro> macros = this.list_Includes;
    
        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;
    
        if(this.IncludesNone != null){
            sb.append(this.IncludesNone.apply(i, "", nb_macros));
        }
    
        for(Macro macro : macros){
            expansion = macro.build(local_context);
    
            if(this.IncludesBeforeFirst != null){
                expansion = this.IncludesBeforeFirst.apply(i, expansion, nb_macros);
            }
    
            if(this.IncludesAfterLast != null){
                expansion = this.IncludesAfterLast.apply(i, expansion, nb_macros);
            }
    
            if(this.IncludesSeparator != null){
                expansion = this.IncludesSeparator.apply(i, expansion, nb_macros);
            }
    
            sb.append(expansion);
            i++;
        }
    
        return sb.toString();
    }
    
    
    private InternalValue getParentInternalsSetterC(){
        return this.ParentInternalsSetterCValue;
    }
    
    private InternalValue getIncludes(){
        return this.IncludesValue;
    }
    
    private void initParentInternalsSetterCInternals(Context context){
        for(Macro macro : this.list_ParentInternalsSetterC){
            macro.apply(new InternalsInitializer("ParentInternalsSetterC"){
                @Override
                void setParentInternalsSetterC(MParentInternalsSetterC mParentInternalsSetterC){
                
                    
                    
                }
            });
        }
    }
    
    private void initIncludesInternals(Context context){
        for(Macro macro : this.list_Includes){
            macro.apply(new InternalsInitializer("Includes"){
                @Override
                void setInclude(MInclude mInclude){
                
                    
                    
                }
            });
        }
    }
    
    
    private void initParentInternalsSetterCDirectives(){
        StringBuilder sb0 = new StringBuilder();
        sb0.append(LINE_SEPARATOR);
        this.ParentInternalsSetterCSeparator = new DSeparator(sb0.toString());
        this.ParentInternalsSetterCValue.setSeparator(this.ParentInternalsSetterCSeparator);
    }
    
    private void initIncludesDirectives(){
        StringBuilder sb0 = new StringBuilder();
        sb0.append(LINE_SEPARATOR);
        this.IncludesSeparator = new DSeparator(sb0.toString());
        this.IncludesValue.setSeparator(this.IncludesSeparator);
    }
    
    @Override
     void apply(
             InternalsInitializer internalsInitializer){
    
         internalsInitializer.setInternalsInitializerC(this);
     }
    
    
    @Override
    public String build(){
    
        BuildState buildState = this.build_state;
    
        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("InternalsInitializerC");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;
        List<String> indentations = new LinkedList<>();
        StringBuilder sbIndentation = new StringBuilder();
    
        initParentInternalsSetterCDirectives();
        initIncludesDirectives();
        
        initParentInternalsSetterCInternals(null);
        initIncludesInternals(null);
    
        StringBuilder sb0 = new StringBuilder();
    
        MHeader minsert_1 = new MHeader();
        
        
        sb0.append(minsert_1.build(null));
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("#");
        sb0.append("include<stdlib.h>");
        sb0.append(LINE_SEPARATOR);
        sb0.append("#");
        sb0.append("include<stdio.h>");
        sb0.append(LINE_SEPARATOR);
        sb0.append("#");
        sb0.append("include<string.h>");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("#");
        sb0.append("include \"Stringbuilder.h\"");
        sb0.append(LINE_SEPARATOR);
        sb0.append("#");
        sb0.append("include \"LinkedList.h\"");
        sb0.append(LINE_SEPARATOR);
        sb0.append("#");
        sb0.append("include \"Map.h\"");
        sb0.append(LINE_SEPARATOR);
        sb0.append("#");
        sb0.append("include \"Context.h\"");
        sb0.append(LINE_SEPARATOR);
        sb0.append("#");
        sb0.append("include \"InternalValue.h\"");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append(buildIncludes());
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("#");
        sb0.append("include \"InternalsInitializer.h\"");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("struct InternalsInitializer_VT VT_InternalsInitializer = ");
        sb0.append("{");
        sb0.append("0, &HT_InternalsInitializer};");
        sb0.append(LINE_SEPARATOR);
        sb0.append("void* HT_InternalsInitializer[] = ");
        sb0.append("{");
        sb0.append("&VT_InternalsInitializer};");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("InternalsInitializer* new_InternalsInitializer(char* paramName)");
        sb0.append(LINE_SEPARATOR);
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    InternalsInitializer* internalInitializer = malloc(sizeof(InternalsInitializer));");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    internalInitializer->vt = &VT_InternalsInitializer;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    internalInitializer->paramName = paramName;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    return internalInitializer;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("}");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("void free_InternalsInitializer(InternalsInitializer* this)");
        sb0.append(LINE_SEPARATOR);
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    //TODO");
        sb0.append(LINE_SEPARATOR);
        sb0.append("}");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append(buildParentInternalsSetterC());
    
        buildState.setExpansion(sb0.toString());
        return sb0.toString();
    }
    
    
    @Override
    String build(Context context) {
     return build();
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