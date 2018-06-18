/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.c.macro;

import java.util.*;

public class MInternalsInitializerH extends Macro{
    
    private final List<Macro> list_ParentInternalsSetterVtH;
    
    private DSeparator ParentInternalsSetterVtHSeparator;
    
    private DBeforeFirst ParentInternalsSetterVtHBeforeFirst;
    
    private DAfterLast ParentInternalsSetterVtHAfterLast;
    
    private DNone ParentInternalsSetterVtHNone;
    
    private final InternalValue ParentInternalsSetterVtHValue;
    
    private final List<Macro> list_ParentInternalsSetterH;
    
    private DSeparator ParentInternalsSetterHSeparator;
    
    private DBeforeFirst ParentInternalsSetterHBeforeFirst;
    
    private DAfterLast ParentInternalsSetterHAfterLast;
    
    private DNone ParentInternalsSetterHNone;
    
    private final InternalValue ParentInternalsSetterHValue;
    
    
    private final Context ParentInternalsSetterVtHContext = new Context();
    
    private final Context ParentInternalsSetterHContext = new Context();
    
    
    public MInternalsInitializerH(){
    
        this.list_ParentInternalsSetterVtH = new ArrayList<>();
        this.list_ParentInternalsSetterH = new ArrayList<>();
    
        this.ParentInternalsSetterVtHValue = new InternalValue(this.list_ParentInternalsSetterVtH, this.ParentInternalsSetterVtHContext);
        this.ParentInternalsSetterHValue = new InternalValue(this.list_ParentInternalsSetterH, this.ParentInternalsSetterHContext);
    }
    
    
    public void addParentInternalsSetterVtH(MParentInternalsSetterVtH macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("ParentInternalsSetterVtH");
        }
                if(this.build_state != null){
                    throw ObjectMacroException.cannotModify("ParentInternalsSetterVtH");
                }
    
        this.list_ParentInternalsSetterVtH.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }
    
    public void addParentInternalsSetterH(MParentInternalsSetterH macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("ParentInternalsSetterH");
        }
                if(this.build_state != null){
                    throw ObjectMacroException.cannotModify("ParentInternalsSetterH");
                }
    
        this.list_ParentInternalsSetterH.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }
    
    
    private String buildParentInternalsSetterVtH(){
        StringBuilder sb = new StringBuilder();
        Context local_context = ParentInternalsSetterVtHContext;
        List<Macro> macros = this.list_ParentInternalsSetterVtH;
    
        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;
    
        if(this.ParentInternalsSetterVtHNone != null){
            sb.append(this.ParentInternalsSetterVtHNone.apply(i, "", nb_macros));
        }
    
        for(Macro macro : macros){
            expansion = macro.build(local_context);
    
            if(this.ParentInternalsSetterVtHBeforeFirst != null){
                expansion = this.ParentInternalsSetterVtHBeforeFirst.apply(i, expansion, nb_macros);
            }
    
            if(this.ParentInternalsSetterVtHAfterLast != null){
                expansion = this.ParentInternalsSetterVtHAfterLast.apply(i, expansion, nb_macros);
            }
    
            if(this.ParentInternalsSetterVtHSeparator != null){
                expansion = this.ParentInternalsSetterVtHSeparator.apply(i, expansion, nb_macros);
            }
    
            sb.append(expansion);
            i++;
        }
    
        return sb.toString();
    }
    
    private String buildParentInternalsSetterH(){
        StringBuilder sb = new StringBuilder();
        Context local_context = ParentInternalsSetterHContext;
        List<Macro> macros = this.list_ParentInternalsSetterH;
    
        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;
    
        if(this.ParentInternalsSetterHNone != null){
            sb.append(this.ParentInternalsSetterHNone.apply(i, "", nb_macros));
        }
    
        for(Macro macro : macros){
            expansion = macro.build(local_context);
    
            if(this.ParentInternalsSetterHBeforeFirst != null){
                expansion = this.ParentInternalsSetterHBeforeFirst.apply(i, expansion, nb_macros);
            }
    
            if(this.ParentInternalsSetterHAfterLast != null){
                expansion = this.ParentInternalsSetterHAfterLast.apply(i, expansion, nb_macros);
            }
    
            if(this.ParentInternalsSetterHSeparator != null){
                expansion = this.ParentInternalsSetterHSeparator.apply(i, expansion, nb_macros);
            }
    
            sb.append(expansion);
            i++;
        }
    
        return sb.toString();
    }
    
    
    private InternalValue getParentInternalsSetterVtH(){
        return this.ParentInternalsSetterVtHValue;
    }
    
    private InternalValue getParentInternalsSetterH(){
        return this.ParentInternalsSetterHValue;
    }
    
    private void initParentInternalsSetterVtHInternals(Context context){
        for(Macro macro : this.list_ParentInternalsSetterVtH){
            macro.apply(new InternalsInitializer("ParentInternalsSetterVtH"){
                @Override
                void setParentInternalsSetterVtH(MParentInternalsSetterVtH mParentInternalsSetterVtH){
                
                    
                    
                }
            });
        }
    }
    
    private void initParentInternalsSetterHInternals(Context context){
        for(Macro macro : this.list_ParentInternalsSetterH){
            macro.apply(new InternalsInitializer("ParentInternalsSetterH"){
                @Override
                void setParentInternalsSetterH(MParentInternalsSetterH mParentInternalsSetterH){
                
                    
                    
                }
            });
        }
    }
    
    
    private void initParentInternalsSetterVtHDirectives(){
        StringBuilder sb0 = new StringBuilder();
        sb0.append(LINE_SEPARATOR);
        this.ParentInternalsSetterVtHSeparator = new DSeparator(sb0.toString());
        this.ParentInternalsSetterVtHValue.setSeparator(this.ParentInternalsSetterVtHSeparator);
    }
    
    private void initParentInternalsSetterHDirectives(){
        StringBuilder sb0 = new StringBuilder();
        sb0.append(LINE_SEPARATOR);
        this.ParentInternalsSetterHSeparator = new DSeparator(sb0.toString());
        this.ParentInternalsSetterHValue.setSeparator(this.ParentInternalsSetterHSeparator);
    }
    
    @Override
     void apply(
             InternalsInitializer internalsInitializer){
    
         internalsInitializer.setInternalsInitializerH(this);
     }
    
    
    @Override
    public String build(){
    
        BuildState buildState = this.build_state;
    
        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("InternalsInitializerH");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;
        List<String> indentations = new LinkedList<>();
        StringBuilder sbIndentation = new StringBuilder();
    
        initParentInternalsSetterVtHDirectives();
        initParentInternalsSetterHDirectives();
        
        initParentInternalsSetterVtHInternals(null);
        initParentInternalsSetterHInternals(null);
    
        StringBuilder sb0 = new StringBuilder();
    
        MHeader minsert_1 = new MHeader();
        
        
        sb0.append(minsert_1.build(null));
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("#");
        sb0.append("ifndef INTERNALSINITIALIZER_H");
        sb0.append(LINE_SEPARATOR);
        sb0.append("#");
        sb0.append("define INTERNALSINITIALIZER_H");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("extern struct InternalsInitializer_VT VT_InternalsInitializer;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("extern void *HT_InternalsInitializer[];");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("typedef struct InternalsInitializer");
        sb0.append(LINE_SEPARATOR);
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    struct InternalsInitializer_VT (*vt);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    char* paramName;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("} InternalsInitializer;");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("typedef struct InternalsInitializer_VT");
        sb0.append(LINE_SEPARATOR);
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    int hl;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    void* (*ht)[];");
        sb0.append(LINE_SEPARATOR);
        StringBuilder sb1 = new StringBuilder();
        sbIndentation = new StringBuilder();
        sbIndentation.append("    ");
        indentations.add(sbIndentation.toString());
        sb1.append(buildParentInternalsSetterVtH());
        sb0.append(applyIndent(sb1.toString(), indentations.remove(indentations.size() - 1)));
        sb0.append(LINE_SEPARATOR);
        sb0.append("} InternalsInitializer_VT;");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("InternalsInitializer* new_InternalsInitializer(char* paramName);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("void free_InternalsInitializer(struct InternalsInitializer*);");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append(buildParentInternalsSetterH());
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("#");
        sb0.append("endif //INTERNALSINITIALIZER_H");
    
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