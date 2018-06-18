/* This file was generated by SableCC's ObjectMacro. */package org.sablecc.objectmacro.codegeneration.c.macro;import java.util.*;public class MMacroBuilder extends Macro{        private final List<Macro> list_ContextParam;        private DSeparator ContextParamSeparator;        private DBeforeFirst ContextParamBeforeFirst;        private DAfterLast ContextParamAfterLast;        private DNone ContextParamNone;        private final InternalValue ContextParamValue;        private final List<Macro> list_DirectiveCalls;        private DSeparator DirectiveCallsSeparator;        private DBeforeFirst DirectiveCallsBeforeFirst;        private DAfterLast DirectiveCallsAfterLast;        private DNone DirectiveCallsNone;        private final InternalValue DirectiveCallsValue;        private final List<Macro> list_InternalCalls;        private DSeparator InternalCallsSeparator;        private DBeforeFirst InternalCallsBeforeFirst;        private DAfterLast InternalCallsAfterLast;        private DNone InternalCallsNone;        private final InternalValue InternalCallsValue;        private final List<Macro> list_MacroBodyParts;        private DSeparator MacroBodyPartsSeparator;        private DBeforeFirst MacroBodyPartsBeforeFirst;        private DAfterLast MacroBodyPartsAfterLast;        private DNone MacroBodyPartsNone;        private final InternalValue MacroBodyPartsValue;        private String field_Hidden;        private Map<Context, String> field_MacroName = new LinkedHashMap<>();            private final Context ContextParamContext = new Context();        private final Context DirectiveCallsContext = new Context();        private final Context InternalCallsContext = new Context();        private final Context MacroBodyPartsContext = new Context();            public MMacroBuilder(String pHidden){            this.list_ContextParam = new ArrayList<>();        this.list_DirectiveCalls = new ArrayList<>();        this.list_InternalCalls = new ArrayList<>();        this.list_MacroBodyParts = new ArrayList<>();            this.setPHidden(pHidden);            this.ContextParamValue = new InternalValue(this.list_ContextParam, this.ContextParamContext);        this.DirectiveCallsValue = new InternalValue(this.list_DirectiveCalls, this.DirectiveCallsContext);        this.InternalCallsValue = new InternalValue(this.list_InternalCalls, this.InternalCallsContext);        this.MacroBodyPartsValue = new InternalValue(this.list_MacroBodyParts, this.MacroBodyPartsContext);    }            public void addContextParam(MContextParam macro){        if(macro == null){            throw ObjectMacroException.parameterNull("ContextParam");        }                    this.list_ContextParam.add(macro);        this.children.add(macro);        Macro.cycleDetector.detectCycle(this, macro);    }        public void addDirectiveCalls(MInitDirectiveCall macro){        if(macro == null){            throw ObjectMacroException.parameterNull("DirectiveCalls");        }                    this.list_DirectiveCalls.add(macro);        this.children.add(macro);        Macro.cycleDetector.detectCycle(this, macro);    }        public void addInternalCalls(MInitInternalsCall macro){        if(macro == null){            throw ObjectMacroException.parameterNull("InternalCalls");        }                    this.list_InternalCalls.add(macro);        this.children.add(macro);        Macro.cycleDetector.detectCycle(this, macro);    }        public void addMacroBodyParts(MInitStringBuilder macro){        if(macro == null){            throw ObjectMacroException.parameterNull("MacroBodyParts");        }                    this.list_MacroBodyParts.add(macro);        this.children.add(macro);        Macro.cycleDetector.detectCycle(this, macro);    }        public void addMacroBodyParts(MStringPart macro){        if(macro == null){            throw ObjectMacroException.parameterNull("MacroBodyParts");        }                    this.list_MacroBodyParts.add(macro);        this.children.add(macro);        Macro.cycleDetector.detectCycle(this, macro);    }        public void addMacroBodyParts(MParamInsertPart macro){        if(macro == null){            throw ObjectMacroException.parameterNull("MacroBodyParts");        }                    this.list_MacroBodyParts.add(macro);        this.children.add(macro);        Macro.cycleDetector.detectCycle(this, macro);    }        public void addMacroBodyParts(MEolPart macro){        if(macro == null){            throw ObjectMacroException.parameterNull("MacroBodyParts");        }                    this.list_MacroBodyParts.add(macro);        this.children.add(macro);        Macro.cycleDetector.detectCycle(this, macro);    }        public void addMacroBodyParts(MInsertMacroPart macro){        if(macro == null){            throw ObjectMacroException.parameterNull("MacroBodyParts");        }                    this.list_MacroBodyParts.add(macro);        this.children.add(macro);        Macro.cycleDetector.detectCycle(this, macro);    }        public void addMacroBodyParts(MAddIndent macro){        if(macro == null){            throw ObjectMacroException.parameterNull("MacroBodyParts");        }                    this.list_MacroBodyParts.add(macro);        this.children.add(macro);        Macro.cycleDetector.detectCycle(this, macro);    }        public void addMacroBodyParts(MIndentPart macro){        if(macro == null){            throw ObjectMacroException.parameterNull("MacroBodyParts");        }                    this.list_MacroBodyParts.add(macro);        this.children.add(macro);        Macro.cycleDetector.detectCycle(this, macro);    }        private void setPHidden( String pHidden ){        if(pHidden == null){            throw ObjectMacroException.parameterNull("Hidden");        }            this.field_Hidden = pHidden;    }            void setMacroName(                Context context,                String value) {                if(value == null){                throw new RuntimeException("value cannot be null here");            }                this.field_MacroName.put(context, value);        }            private String buildContextParam(){        StringBuilder sb = new StringBuilder();        Context local_context = ContextParamContext;        List<Macro> macros = this.list_ContextParam;            int i = 0;        int nb_macros = macros.size();        String expansion = null;            if(this.ContextParamNone != null){            sb.append(this.ContextParamNone.apply(i, "", nb_macros));        }            for(Macro macro : macros){            expansion = macro.build(local_context);                if(this.ContextParamBeforeFirst != null){                expansion = this.ContextParamBeforeFirst.apply(i, expansion, nb_macros);            }                if(this.ContextParamAfterLast != null){                expansion = this.ContextParamAfterLast.apply(i, expansion, nb_macros);            }                if(this.ContextParamSeparator != null){                expansion = this.ContextParamSeparator.apply(i, expansion, nb_macros);            }                sb.append(expansion);            i++;        }            return sb.toString();    }        private String buildDirectiveCalls(){        StringBuilder sb = new StringBuilder();        Context local_context = DirectiveCallsContext;        List<Macro> macros = this.list_DirectiveCalls;            int i = 0;        int nb_macros = macros.size();        String expansion = null;            if(this.DirectiveCallsNone != null){            sb.append(this.DirectiveCallsNone.apply(i, "", nb_macros));        }            for(Macro macro : macros){            expansion = macro.build(local_context);                if(this.DirectiveCallsBeforeFirst != null){                expansion = this.DirectiveCallsBeforeFirst.apply(i, expansion, nb_macros);            }                if(this.DirectiveCallsAfterLast != null){                expansion = this.DirectiveCallsAfterLast.apply(i, expansion, nb_macros);            }                if(this.DirectiveCallsSeparator != null){                expansion = this.DirectiveCallsSeparator.apply(i, expansion, nb_macros);            }                sb.append(expansion);            i++;        }            return sb.toString();    }        private String buildInternalCalls(){        StringBuilder sb = new StringBuilder();        Context local_context = InternalCallsContext;        List<Macro> macros = this.list_InternalCalls;            int i = 0;        int nb_macros = macros.size();        String expansion = null;            if(this.InternalCallsNone != null){            sb.append(this.InternalCallsNone.apply(i, "", nb_macros));        }            for(Macro macro : macros){            expansion = macro.build(local_context);                if(this.InternalCallsBeforeFirst != null){                expansion = this.InternalCallsBeforeFirst.apply(i, expansion, nb_macros);            }                if(this.InternalCallsAfterLast != null){                expansion = this.InternalCallsAfterLast.apply(i, expansion, nb_macros);            }                if(this.InternalCallsSeparator != null){                expansion = this.InternalCallsSeparator.apply(i, expansion, nb_macros);            }                sb.append(expansion);            i++;        }            return sb.toString();    }        private String buildMacroBodyParts(){        StringBuilder sb = new StringBuilder();        Context local_context = MacroBodyPartsContext;        List<Macro> macros = this.list_MacroBodyParts;            int i = 0;        int nb_macros = macros.size();        String expansion = null;            if(this.MacroBodyPartsNone != null){            sb.append(this.MacroBodyPartsNone.apply(i, "", nb_macros));        }            for(Macro macro : macros){            expansion = macro.build(local_context);                if(this.MacroBodyPartsBeforeFirst != null){                expansion = this.MacroBodyPartsBeforeFirst.apply(i, expansion, nb_macros);            }                if(this.MacroBodyPartsAfterLast != null){                expansion = this.MacroBodyPartsAfterLast.apply(i, expansion, nb_macros);            }                if(this.MacroBodyPartsSeparator != null){                expansion = this.MacroBodyPartsSeparator.apply(i, expansion, nb_macros);            }                sb.append(expansion);            i++;        }            return sb.toString();    }        private String buildHidden(){            return this.field_Hidden;    }        private String buildMacroName(Context context){            return this.field_MacroName.get(context);    }            private InternalValue getContextParam(){        return this.ContextParamValue;    }        private InternalValue getDirectiveCalls(){        return this.DirectiveCallsValue;    }        private InternalValue getInternalCalls(){        return this.InternalCallsValue;    }        private InternalValue getMacroBodyParts(){        return this.MacroBodyPartsValue;    }        private String getHidden(){            return this.field_Hidden;    }        private String getMacroName(Context context){            return this.field_MacroName.get(context);    }        private void initContextParamInternals(Context context){        for(Macro macro : this.list_ContextParam){            macro.apply(new InternalsInitializer("ContextParam"){                @Override                void setContextParam(MContextParam mContextParam){                                                                        }            });        }    }        private void initDirectiveCallsInternals(Context context){        for(Macro macro : this.list_DirectiveCalls){            macro.apply(new InternalsInitializer("DirectiveCalls"){                @Override                void setInitDirectiveCall(MInitDirectiveCall mInitDirectiveCall){                                                        mInitDirectiveCall.setMacroName(DirectiveCallsContext, getMacroName(context));                }            });        }    }        private void initInternalCallsInternals(Context context){        for(Macro macro : this.list_InternalCalls){            macro.apply(new InternalsInitializer("InternalCalls"){                @Override                void setInitInternalsCall(MInitInternalsCall mInitInternalsCall){                                                        mInitInternalsCall.setMacroName(InternalCallsContext, getMacroName(context));                }            });        }    }        private void initMacroBodyPartsInternals(Context context){        for(Macro macro : this.list_MacroBodyParts){            macro.apply(new InternalsInitializer("MacroBodyParts"){                @Override                void setInitStringBuilder(MInitStringBuilder mInitStringBuilder){                                                                        }@Override                void setStringPart(MStringPart mStringPart){                                                                        }@Override                void setParamInsertPart(MParamInsertPart mParamInsertPart){                                                        mParamInsertPart.setMacroName(MacroBodyPartsContext, getMacroName(context));                }@Override                void setEolPart(MEolPart mEolPart){                                                                        }@Override                void setInsertMacroPart(MInsertMacroPart mInsertMacroPart){                                                        mInsertMacroPart.setMacroName(MacroBodyPartsContext, getMacroName(context));                }@Override                void setAddIndent(MAddIndent mAddIndent){                                                        mAddIndent.setMacroName(MacroBodyPartsContext, getMacroName(context));                }@Override                void setIndentPart(MIndentPart mIndentPart){                                                        mIndentPart.setMacroName(MacroBodyPartsContext, getMacroName(context));                }            });        }    }            private void initContextParamDirectives(){//        StringBuilder sb0 = new StringBuilder();//////        sb1.append(", ");//////        this.ContextParamBeforeFirst = new DBeforeFirst(sb0.toString());//////        this.ContextParamValue.setBeforeFirst(this.ContextParamBeforeFirst);    }        private void initDirectiveCallsDirectives(){        StringBuilder sb0 = new StringBuilder();        sb0.append(LINE_SEPARATOR);        this.DirectiveCallsSeparator = new DSeparator(sb0.toString());        this.DirectiveCallsValue.setSeparator(this.DirectiveCallsSeparator);    }        private void initInternalCallsDirectives(){        StringBuilder sb0 = new StringBuilder();        sb0.append(LINE_SEPARATOR);        this.InternalCallsSeparator = new DSeparator(sb0.toString());        this.InternalCallsValue.setSeparator(this.InternalCallsSeparator);    }        private void initMacroBodyPartsDirectives(){        StringBuilder sb0 = new StringBuilder();        sb0.append(LINE_SEPARATOR);        this.MacroBodyPartsSeparator = new DSeparator(sb0.toString());        this.MacroBodyPartsValue.setSeparator(this.MacroBodyPartsSeparator);    }        @Override     void apply(             InternalsInitializer internalsInitializer){             internalsInitializer.setMacroBuilder(this);     }            @Override    public String build(Context context){            BuildState buildState = this.build_states.get(context);            if(buildState == null){            buildState = new BuildState();        }        else if(buildState.getExpansion() == null){            throw ObjectMacroException.cyclicReference("MacroBuilder");        }        else{            return buildState.getExpansion();        }        this.build_states.put(context, buildState);        List<String> indentations = new LinkedList<>();        StringBuilder sbIndentation = new StringBuilder();            initContextParamDirectives();        initDirectiveCallsDirectives();        initInternalCallsDirectives();        initMacroBodyPartsDirectives();                initContextParamInternals(context);        initDirectiveCallsInternals(context);        initInternalCallsInternals(context);        initMacroBodyPartsInternals(context);            StringBuilder sb0 = new StringBuilder();            sb0.append("char* M");        sb0.append(buildMacroName(context));        sb0.append("_build");        sb0.append(buildHidden());        sb0.append("(M");        sb0.append(buildMacroName(context));        sb0.append("* this");        sb0.append(buildContextParam());        sb0.append(")");        sb0.append(LINE_SEPARATOR);        sb0.append("{");        sb0.append(LINE_SEPARATOR);        sb0.append("    LinkedList *indentations = new_LinkedList();");        sb0.append(LINE_SEPARATOR);        sb0.append("    Stringbuilder *sbIndentation = new_Stringbuilder(5);");        sb0.append(LINE_SEPARATOR);        StringBuilder sb1 = new StringBuilder();        sbIndentation = new StringBuilder();        sbIndentation.append("    ");        indentations.add(sbIndentation.toString());        sb1.append(buildDirectiveCalls());        sb1.append(LINE_SEPARATOR);        sb1.append(buildInternalCalls());        sb0.append(applyIndent(sb1.toString(), indentations.remove(indentations.size() - 1)));        sb0.append(LINE_SEPARATOR);        sb0.append(LINE_SEPARATOR);        sb0.append("    Stringbuilder *sb0 = new_Stringbuilder(5);");        sb0.append(LINE_SEPARATOR);        sb0.append(LINE_SEPARATOR);        StringBuilder sb2 = new StringBuilder();        sbIndentation = new StringBuilder();        sbIndentation.append("    ");        indentations.add(sbIndentation.toString());        sb2.append(buildMacroBodyParts());        sb0.append(applyIndent(sb2.toString(), indentations.remove(indentations.size() - 1)));        sb0.append(LINE_SEPARATOR);        sb0.append("    return sb0->vt->toString(sb0);");        sb0.append(LINE_SEPARATOR);        sb0.append("}");            buildState.setExpansion(sb0.toString());        return sb0.toString();    }            private String applyIndent(                            String macro,                            String indent){            StringBuilder sb = new StringBuilder();            String[] lines = macro.split( "\n");            if(lines.length > 1){                for(int i = 0; i < lines.length; i++){                    String line = lines[i];                    sb.append(indent).append(line);                    if(i < lines.length - 1){                        sb.append(LINE_SEPARATOR);                    }                }            }            else{                sb.append(indent).append(macro);            }            return sb.toString();    }}