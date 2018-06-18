/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.c.macro;

import java.util.*;

public class MRedefParentInternalsSetterC extends Macro{
    
    private String field_Name;
    
    private final List<Macro> list_MacroBodyParts;
    
    private DSeparator MacroBodyPartsSeparator;
    
    private DBeforeFirst MacroBodyPartsBeforeFirst;
    
    private DAfterLast MacroBodyPartsAfterLast;
    
    private DNone MacroBodyPartsNone;
    
    private final InternalValue MacroBodyPartsValue;
    
    private final List<Macro> list_SetInternals;
    
    private DSeparator SetInternalsSeparator;
    
    private DBeforeFirst SetInternalsBeforeFirst;
    
    private DAfterLast SetInternalsAfterLast;
    
    private DNone SetInternalsNone;
    
    private final InternalValue SetInternalsValue;
    
    private Map<Context, String> field_RedefIndex = new LinkedHashMap<>();
    
    
    private final Context MacroBodyPartsContext = new Context();
    
    private final Context SetInternalsContext = new Context();
    
    
    public MRedefParentInternalsSetterC(String pName){
    
            this.setPName(pName);
        this.list_MacroBodyParts = new ArrayList<>();
        this.list_SetInternals = new ArrayList<>();
    
        this.MacroBodyPartsValue = new InternalValue(this.list_MacroBodyParts, this.MacroBodyPartsContext);
        this.SetInternalsValue = new InternalValue(this.list_SetInternals, this.SetInternalsContext);
    }
    
    
    private void setPName( String pName ){
        if(pName == null){
            throw ObjectMacroException.parameterNull("Name");
        }
    
        this.field_Name = pName;
    }
    
    public void addMacroBodyParts(MInitStringBuilder macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("MacroBodyParts");
        }
        
    
        this.list_MacroBodyParts.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }
    
    public void addMacroBodyParts(MStringPart macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("MacroBodyParts");
        }
        
    
        this.list_MacroBodyParts.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }
    
    public void addMacroBodyParts(MParamInsertPart macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("MacroBodyParts");
        }
        
    
        this.list_MacroBodyParts.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }
    
    public void addMacroBodyParts(MEolPart macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("MacroBodyParts");
        }
        
    
        this.list_MacroBodyParts.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }
    
    public void addMacroBodyParts(MInsertMacroPart macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("MacroBodyParts");
        }
        
    
        this.list_MacroBodyParts.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }
    
    public void addSetInternals(MSetInternal macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("SetInternals");
        }
        
    
        this.list_SetInternals.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }
    
        void setRedefIndex(
                Context context,
                String value) {
    
            if(value == null){
                throw new RuntimeException("value cannot be null here");
            }
    
            this.field_RedefIndex.put(context, value);
        }
    
    
    private String buildName(){
    
        return this.field_Name;
    }
    
    private String buildMacroBodyParts(){
        StringBuilder sb = new StringBuilder();
        Context local_context = MacroBodyPartsContext;
        List<Macro> macros = this.list_MacroBodyParts;
    
        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;
    
        if(this.MacroBodyPartsNone != null){
            sb.append(this.MacroBodyPartsNone.apply(i, "", nb_macros));
        }
    
        for(Macro macro : macros){
            expansion = macro.build(local_context);
    
            if(this.MacroBodyPartsBeforeFirst != null){
                expansion = this.MacroBodyPartsBeforeFirst.apply(i, expansion, nb_macros);
            }
    
            if(this.MacroBodyPartsAfterLast != null){
                expansion = this.MacroBodyPartsAfterLast.apply(i, expansion, nb_macros);
            }
    
            if(this.MacroBodyPartsSeparator != null){
                expansion = this.MacroBodyPartsSeparator.apply(i, expansion, nb_macros);
            }
    
            sb.append(expansion);
            i++;
        }
    
        return sb.toString();
    }
    
    private String buildSetInternals(){
        StringBuilder sb = new StringBuilder();
        Context local_context = SetInternalsContext;
        List<Macro> macros = this.list_SetInternals;
    
        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;
    
        if(this.SetInternalsNone != null){
            sb.append(this.SetInternalsNone.apply(i, "", nb_macros));
        }
    
        for(Macro macro : macros){
            expansion = macro.build(local_context);
    
            if(this.SetInternalsBeforeFirst != null){
                expansion = this.SetInternalsBeforeFirst.apply(i, expansion, nb_macros);
            }
    
            if(this.SetInternalsAfterLast != null){
                expansion = this.SetInternalsAfterLast.apply(i, expansion, nb_macros);
            }
    
            if(this.SetInternalsSeparator != null){
                expansion = this.SetInternalsSeparator.apply(i, expansion, nb_macros);
            }
    
            sb.append(expansion);
            i++;
        }
    
        return sb.toString();
    }
    
    private String buildRedefIndex(Context context){
    
        return this.field_RedefIndex.get(context);
    }
    
    
    private String getName(){
    
        return this.field_Name;
    }
    
    private InternalValue getMacroBodyParts(){
        return this.MacroBodyPartsValue;
    }
    
    private InternalValue getSetInternals(){
        return this.SetInternalsValue;
    }
    
    private String getRedefIndex(Context context){
    
        return this.field_RedefIndex.get(context);
    }
    
    private void initMacroBodyPartsInternals(Context context){
        for(Macro macro : this.list_MacroBodyParts){
            macro.apply(new InternalsInitializer("MacroBodyParts"){
                @Override
                void setInitStringBuilder(MInitStringBuilder mInitStringBuilder){
                
                    
                    
                }@Override
                void setStringPart(MStringPart mStringPart){
                
                    
                    
                }@Override
                void setParamInsertPart(MParamInsertPart mParamInsertPart){
                
                    
                    mParamInsertPart.setMacroName(MacroBodyPartsContext, getName());
                }@Override
                void setEolPart(MEolPart mEolPart){
                
                    
                    
                }@Override
                void setInsertMacroPart(MInsertMacroPart mInsertMacroPart){
                
                    
                    mInsertMacroPart.setMacroName(MacroBodyPartsContext, getName());
                }
            });
        }
    }
    
    private void initSetInternalsInternals(Context context){
        for(Macro macro : this.list_SetInternals){
            macro.apply(new InternalsInitializer("SetInternals"){
                @Override
                void setSetInternal(MSetInternal mSetInternal){
                
                    
                    mSetInternal.setMacroName(SetInternalsContext, getName());mSetInternal.setIndexInsert(SetInternalsContext, getRedefIndex(context));
                }
            });
        }
    }
    
    
    private void initMacroBodyPartsDirectives(){
        StringBuilder sb0 = new StringBuilder();
        sb0.append(LINE_SEPARATOR);
        this.MacroBodyPartsSeparator = new DSeparator(sb0.toString());
        this.MacroBodyPartsValue.setSeparator(this.MacroBodyPartsSeparator);
    }
    
    private void initSetInternalsDirectives(){
        
    }
    
    @Override
     void apply(
             InternalsInitializer internalsInitializer){
    
         internalsInitializer.setRedefParentInternalsSetterC(this);
     }
    
    
    @Override
    public String build(Context context){
    
        BuildState buildState = this.build_states.get(context);
    
        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("RedefParentInternalsSetterC");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_states.put(context, buildState);
        List<String> indentations = new LinkedList<>();
        StringBuilder sbIndentation = new StringBuilder();
    
        initMacroBodyPartsDirectives();
        initSetInternalsDirectives();
        
        initMacroBodyPartsInternals(context);
        initSetInternalsInternals(context);
    
        StringBuilder sb0 = new StringBuilder();
    
        sb0.append("void InternalsInitializer_redef");
        sb0.append(buildRedefIndex(context));
        sb0.append("_set");
        sb0.append(buildName());
        sb0.append("(InternalsInitializer_redef");
        sb0.append(buildRedefIndex(context));
        sb0.append(" *this, M");
        sb0.append(buildName());
        sb0.append(" *m");
        sb0.append(buildName());
        sb0.append(")");
        sb0.append(LINE_SEPARATOR);
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        StringBuilder sb1 = new StringBuilder();
        sbIndentation = new StringBuilder();
        sbIndentation.append("    ");
        indentations.add(sbIndentation.toString());
        sb1.append(buildMacroBodyParts());
        sb1.append(LINE_SEPARATOR);
        sb1.append(buildSetInternals());
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