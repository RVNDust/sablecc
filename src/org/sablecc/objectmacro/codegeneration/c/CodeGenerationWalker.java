/* This file is part of SableCC ( http://sablecc.org ).
 *
 * See the NOTICE file distributed with this work for copyright information.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sablecc.objectmacro.codegeneration.c;

import org.sablecc.exception.InternalException;
import org.sablecc.objectmacro.codegeneration.IntermediateRepresentation;
import org.sablecc.objectmacro.codegeneration.c.macro.*;
import org.sablecc.objectmacro.codegeneration.java.macro.MMacro;
import org.sablecc.objectmacro.codegeneration.java.structure.Macro;
import org.sablecc.objectmacro.intermediate.syntax3.analysis.DepthFirstAdapter;
import org.sablecc.objectmacro.intermediate.syntax3.node.*;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CodeGenerationWalker extends
        DepthFirstAdapter {

    private final IntermediateRepresentation ir;

    private final File packageDirectory;

    private MSuperMacroH mSuperMacroH;
    private MSuperMacroC mSuperMacroC;

    private MLinkedListH mLinkedListH;
    private MLinkedListC mLinkedListC;
    private MLinkedListNodeH mLinkedListNodeH;
    private MLinkedListNodeC mLinkedListNodeC;

    private MStringBuilderH mStringbuilderH;
    private MStringBuilderC mStringbuilderC;

    private MMapH mMapH;
    private MMapC mMapC;

    private MContextH mContextH;
    private MContextC mContextC;

    private MInternalsInitializerH mInternalsInitializerH;
    private MInternalsInitializerC mInternalsInitializerC;

    private MClassInternalValueH mClassInternalValueH;
    private MClassInternalValueC mClassInternalValueC;

    private MMacroH currentMacroH;
    private MMacroC currentMacroC;
    private String currentMacroName;
    private MConstructorH currentConstructorH;
    private MConstructorC currentConstructorC;
    private MParamMacroArgH currentMParamMacroArgH;
    private MParamMacroArgC currentMParamMacroArgC;
    private MParamMacroArgType currentParamMacroArgType;
    private MAddMacroH currentMAddMacroH;
    private MAddMacroVtH currentMAddMacroVtH;
    private MAddMacroC currentMAddMacroC;
    private String currentMacroRefName;
    private MRedefInternalsInitializerH currentRedefInternalsInitializerH;
    private MRedefInternalsInitializerC currentRedefInternalsInitializerC;
    private MRedefParentInternalsSetterC currentRedefParentInternalsSetterC;

    private final Map<String, Macro> macros;
    private Macro currentMacro;
    private String currentParamName;
    private String currentContextName;
    private List<String> contextNames = new ArrayList<>();
    private MMacroBuilder currentMacroBuilder;
    private MParamRefBuilderH currentParamRefBuilderH;
    private MParamMacroRefBuilder currentParamMacroRefBuilder;
    private MInsertMacroPart currentInsertMacroPart;
    private MInitDirectivesH currentInitDirectivesH;
    private MInitDirectivesC currentInitDirectivesC;
    private MNewDirective currentDirective;
    private Integer indexBuilder = 0;
    private Integer indexInsert = 0;
    private Integer indexRedefInternalInitializers = 0;
    private List<MAddIndent> indentations = new LinkedList<>();
    private MAddIndent currentAddIndent;
    private List<Integer> currentlyUsed = new ArrayList<>();
    private boolean currentMacroHasInternals;

    private List<String> createdBuilders = new ArrayList<>();
    private List<Integer> createdInserts = new ArrayList<>();

    public CodeGenerationWalker(
            IntermediateRepresentation ir,
            File packageDirectory,
            Map<String, Macro> macros) {
        this.ir = ir;
        this.packageDirectory = packageDirectory;
        this.macros = macros;
    }

    @Override
    public void inAIntermediateRepresentation(
            AIntermediateRepresentation node) {

        this.mSuperMacroH = new MSuperMacroH();
        this.mSuperMacroC = new MSuperMacroC();

        this.mLinkedListH = new MLinkedListH();
        this.mLinkedListC = new MLinkedListC();
        this.mLinkedListNodeH = new MLinkedListNodeH();
        this.mLinkedListNodeC = new MLinkedListNodeC();

        this.mStringbuilderH = new MStringBuilderH();
        this.mStringbuilderC = new MStringBuilderC();

        this.mMapH = new MMapH();
        this.mMapC = new MMapC();

        this.mContextH = new MContextH();
        this.mContextC = new MContextC();

        this.mInternalsInitializerH = new MInternalsInitializerH();
        this.mInternalsInitializerC = new MInternalsInitializerC();

        this.mClassInternalValueH = new MClassInternalValueH();
        this.mClassInternalValueC = new MClassInternalValueC();
    }

    @Override
    public void outAIntermediateRepresentation(
            AIntermediateRepresentation node) {

        GenerationUtils.writeFile(this.packageDirectory, "Macro.h",
                this.mSuperMacroH.build());
        GenerationUtils.writeFile(this.packageDirectory, "Macro.c",
                this.mSuperMacroC.build());

        GenerationUtils.writeFile(this.packageDirectory, "LinkedList.h",
                this.mLinkedListH.build());
        GenerationUtils.writeFile(this.packageDirectory, "LinkedList.c",
                this.mLinkedListC.build());
        GenerationUtils.writeFile(this.packageDirectory, "LinkedListNode.h",
                this.mLinkedListNodeH.build());
        GenerationUtils.writeFile(this.packageDirectory, "LinkedListNode.c",
                this.mLinkedListNodeC.build());

        GenerationUtils.writeFile(this.packageDirectory, "Stringbuilder.h",
                this.mStringbuilderH.build());
        GenerationUtils.writeFile(this.packageDirectory, "Stringbuilder.c",
                this.mStringbuilderC.build());

        GenerationUtils.writeFile(this.packageDirectory, "Map.h",
                this.mMapH.build());
        GenerationUtils.writeFile(this.packageDirectory, "Map.c",
                this.mMapC.build());

        GenerationUtils.writeFile(this.packageDirectory, "Context.h",
                this.mContextH.build());
        GenerationUtils.writeFile(this.packageDirectory, "Context.c",
                this.mContextC.build());

        GenerationUtils.writeFile(this.packageDirectory, "InternalsInitializer.h",
                this.mInternalsInitializerH.build());
        GenerationUtils.writeFile(this.packageDirectory, "InternalsInitializer.c",
                this.mInternalsInitializerC.build());

        GenerationUtils.writeFile(this.packageDirectory, "InternalValue.h",
                this.mClassInternalValueH.build());
        GenerationUtils.writeFile(this.packageDirectory, "InternalValue.c",
                this.mClassInternalValueC.build());
    }

    @Override
    public void inAMacro(
            AMacro node) {
        this.currentMacroName = GenerationUtils.buildNameCamelCase(node.getNames());
        this.contextNames = new ArrayList<>();

        this.currentMacro = this.macros.get(this.currentMacroName);

        this.currentMacroH = new MMacroH(currentMacroName);
        this.currentMacroC = new MMacroC(currentMacroName);

        this.currentConstructorH = new MConstructorH();
        this.currentConstructorC = new MConstructorC();
        this.currentMacroH.addConstructor(this.currentConstructorH);
        this.currentMacroC.addConstructor(this.currentConstructorC);

        this.currentMacroH.addStrSplitFunction(new MStrSplitFunctionH());
        this.currentMacroC.addStrSplitFunction(new MStrSplitFunctionC());

        this.mInternalsInitializerH.addParentInternalsSetterVtH(new MParentInternalsSetterVtH(this.currentMacroName));
        this.mInternalsInitializerH.addParentInternalsSetterH(new MParentInternalsSetterH(this.currentMacroName));
        this.mInternalsInitializerC.addParentInternalsSetterC(new MParentInternalsSetterC(this.currentMacroName));
        this.mInternalsInitializerC.addIncludes(new MInclude(this.currentMacroName));

        this.currentMacroHasInternals = node.getInternals().size() > 0;

        if (this.currentMacroHasInternals) {
            this.currentMacroBuilder = new MMacroBuilder("");

            this.currentMacroH.addContextParam(new MContextParam());
            this.currentMacroBuilder.addContextParam(new MContextParam());
        }
        else
        {
            this.currentMacroBuilder = new MMacroBuilder("Hidden");

            MEmptyBuilderWithContext mEmptyBuilderWithContext = new MEmptyBuilderWithContext();
            mEmptyBuilderWithContext.addContextParam(new MContextParam());

            this.currentMacroH.addContextParam(new MContextParam());

            this.currentMacroC.addEmptyBuilderWithContext(mEmptyBuilderWithContext);
        }

        this.currentMacroC.addMacroBuilder(this.currentMacroBuilder);
    }

    @Override
    public void outAMacro(
            AMacro node) {
        GenerationUtils.writeFile(this.packageDirectory, "M"+currentMacroName+".h",
                this.currentMacroH.build());
        GenerationUtils.writeFile(this.packageDirectory, "M"+currentMacroName+".c",
                this.currentMacroC.build());


        this.currentMacroH = null;
        this.currentMacroC = null;
        this.currentConstructorH = null;
        this.currentConstructorC = null;
        this.currentMacroBuilder = null;

        this.currentMacro = null;
    }

    @Override
    public void caseAInternal(
            AInternal node) {
        String paramName = GenerationUtils.buildNameCamelCase(node.getNames());

        if (node.getType() instanceof AStringType) {
            this.currentMacroH.addFields(new MInternalFieldDeclaration(paramName));
            this.currentMacroH.addFunctions(new MInternalStringGetterH(paramName));
            this.currentMacroH.addFunctions(new MInternalStringSetterH(paramName));
            this.currentMacroH.addMethods(new MInternalStringGetterVtH(paramName));
            this.currentMacroH.addMethods(new MInternalStringSetterVtH(paramName));

            this.currentConstructorC.addFieldInitializers(new MInternalFieldInitializer(paramName));

            this.currentMacroC.addFunctionNames(new MFunctionRefs("get", paramName));
            this.currentMacroC.addInternalFunctions(new MInternalStringGetter(paramName));

            this.currentMacroC.addFunctionNames(new MFunctionRefs("set", paramName));
            this.currentMacroC.addFunctions(new MInternalStringSetter(paramName));

            this.currentMacroH.addFunctions(new MInternalRefBuilderH(paramName));
            this.currentMacroC.addInternalFunctions(new MInternalStringRefBuilder(paramName));
        }
        else if(node.getType() instanceof AMacroRefsType)
        {
            this.currentMacroH.addFields(new MInternalFieldDeclaration(paramName));
            this.currentMacroH.addFunctions(new MInternalRefBuilderH(paramName));
            this.currentMacroH.addFunctions(new MInternalMacroRefH(paramName));
            this.currentMacroH.addMethods(new MInternalMacroRefVtH(paramName));
            this.currentMacroH.addFunctions(new MInternalMacroSetterH(paramName));
            this.currentMacroH.addMethods(new MInternalMacroSetterVtH(paramName));

            this.currentConstructorC.addFieldInitializers(new MInternalFieldInitializer(paramName));

            this.currentMacroC.addFunctionNames(new MFunctionRefs("get", paramName));
            this.currentMacroC.addFunctions(new MInternalMacroRefC(paramName));

            this.currentMacroC.addFunctionNames(new MFunctionRefs("set", paramName));
            this.currentMacroC.addFunctions(new MInternalMacroSetter(paramName));

            this.indexBuilder = 0;

            this.currentMacroC.addInternalFunctions(new MInternalMacroRefBuilder(paramName));
        }
    }

    @Override
    public void outAInternal(
            AInternal node) {
        if(this.currentRedefInternalsInitializerH != null && this.currentRedefInternalsInitializerC != null)
        {
            GenerationUtils.writeFile(this.packageDirectory, "InternalsInitializer_redef" + this.indexRedefInternalInitializers + ".h",
                    this.currentRedefInternalsInitializerH.build());
            GenerationUtils.writeFile(this.packageDirectory, "InternalsInitializer_redef" + this.indexRedefInternalInitializers + ".c",
                    this.currentRedefInternalsInitializerC.build());
        }

        this.indexBuilder = 0;
        this.indexInsert = 0;
        this.currentContextName = null;
        this.currentRedefInternalsInitializerH = null;
        this.currentRedefInternalsInitializerC = null;
        this.currentParamMacroRefBuilder = null;
        this.createdBuilders = new ArrayList<>();
        this.createdInserts = new ArrayList<>();
    }

    @Override
    public void caseAParam(
            AParam node) {
        String paramName = this.currentParamName
                = GenerationUtils.buildNameCamelCase(node.getNames());

        if (node.getType() instanceof AStringType) {

            //Adding external function
            this.currentMacroH.addFields(new MFieldStringDeclaration(paramName));

            MParamStringArg mParamStringArg = new MParamStringArg();
            mParamStringArg.addParamType(new MParamArgType("char*"));
            mParamStringArg.addParamArg(new MParamArgName(paramName));

            MAddStringH mAddStringH = new MAddStringH(paramName);
            mAddStringH.addParamArg(mParamStringArg);

            MAddStringVtH mAddStringVtH = new MAddStringVtH(paramName);
            mAddStringVtH.addParamArg(mParamStringArg);

            MAddStringC mAddStringC = new MAddStringC(paramName);
            mAddStringC.addParamArg(mParamStringArg);
            mAddStringC.addParamValue(new MParamArgName(paramName));


            this.currentMacroH.addFunctions(mAddStringH);
            this.currentMacroH.addMethods(mAddStringVtH);

            this.currentConstructorC.addFieldInitializers(new MFieldStringInitializer(paramName));
            this.currentMacroC.addFunctionNames(new MFunctionRefs("add",paramName));
            this.currentMacroC.addFunctions(mAddStringC);

            //Adding internals functions
            MParamStringRefBuilder mParamStringRefBuilder = new MParamStringRefBuilder(paramName);
            MParamStringGetter mParamStringGetter = new MParamStringGetter(paramName);

            this.currentMacroC.addInternalFunctions(mParamStringRefBuilder);
            this.currentMacroC.addInternalFunctions(mParamStringGetter);

            this.currentParamRefBuilderH = new MParamRefBuilderH(paramName);
            this.currentMacroH.addFunctions(this.currentParamRefBuilderH);
        }
        else if (node.getType() instanceof AMacroRefsType) {
            this.currentContextName = paramName.concat(GenerationUtils.CONTEXT_STRING);


            this.currentMacroH.addFields(new MFieldMacroDeclaration(paramName));
            this.currentMacroH.addFields(new MDirectiveFieldsDeclaration(paramName));
            this.currentMacroH.addFields(new MInternalMacrosValueField(paramName));

            this.currentMAddMacroH = new MAddMacroH(paramName);

            this.currentMAddMacroVtH = new MAddMacroVtH(paramName);

            this.currentMAddMacroC = new MAddMacroC(paramName);

            this.currentMacroH.addFunctions(this.currentMAddMacroH);
            this.currentMacroH.addMethods(this.currentMAddMacroVtH);

            this.currentConstructorC.addFieldInitializers(new MFieldMacroInitializer(paramName));
            this.currentConstructorC.addInternalValuesInitializers(new MInitInternalValue(paramName));

            this.currentInitDirectivesH = new MInitDirectivesH(paramName);
            this.currentInitDirectivesC = new MInitDirectivesC(paramName);
            this.currentMacroH.addInitDirectives(this.currentInitDirectivesH);
            this.currentMacroC.addInitDirectives(this.currentInitDirectivesC);

            for (PDirective directive : node.getDirectives()) {
                directive.apply(this);
            }

            this.indexBuilder = 0;

            MInitInternalsCall mInitInternalsCall = new MInitInternalsCall(paramName);
            this.currentMacroBuilder.addInternalCalls(mInitInternalsCall);

            this.currentMacroBuilder.addDirectiveCalls(new MInitDirectiveCall(paramName));

            this.currentMacroC.addFunctionNames(new MFunctionRefs("add",paramName));
            this.currentMacroC.addFunctions(this.currentMAddMacroC);

            MParamMacroRefVtH mParamMacroRefVtH = new MParamMacroRefVtH(paramName);
            MParamMacroRefH mParamMacroRefH = new MParamMacroRefH(paramName);
            MParamMacroRefC mParamMacroRefC = new MParamMacroRefC(paramName);

            this.currentMacroH.addFunctions(mParamMacroRefH);
            this.currentMacroH.addMethods(mParamMacroRefVtH);

            this.currentMacroC.addFunctionNames(new MFunctionRefs("get",paramName));
            this.currentMacroC.addFunctions(mParamMacroRefC);


            this.currentParamRefBuilderH = new MParamRefBuilderH(paramName);
            this.currentMacroH.addFunctions(this.currentParamRefBuilderH);

            this.currentRedefInternalsInitializerH = new MRedefInternalsInitializerH(Integer.toString(this.indexRedefInternalInitializers));
            this.currentRedefInternalsInitializerC = new MRedefInternalsInitializerC(Integer.toString(this.indexRedefInternalInitializers));
        }

        node.getType().apply(this);
        outAParam(node);
    }

    @Override
    public void outAParam(
            AParam node) {
        if(this.currentRedefInternalsInitializerH != null && this.currentRedefInternalsInitializerC != null)
        {
            GenerationUtils.writeFile(this.packageDirectory, "InternalsInitializer_redef" + this.indexRedefInternalInitializers + ".h",
                    this.currentRedefInternalsInitializerH.build());
            GenerationUtils.writeFile(this.packageDirectory, "InternalsInitializer_redef" + this.indexRedefInternalInitializers + ".c",
                    this.currentRedefInternalsInitializerC.build());
        }

        this.currentParamName = null;
        this.currentContextName = null;
        this.currentRedefInternalsInitializerH = null;
        this.currentRedefInternalsInitializerC = null;
        this.currentRedefParentInternalsSetterC = null;
        this.indexBuilder = 0;
        this.indexInsert = 0;
        this.currentInitDirectivesH = null;
        this.currentInitDirectivesC = null;
        this.createdBuilders = new ArrayList<>();
        this.createdInserts = new ArrayList<>();
        this.currentParamMacroRefBuilder = null;
    }

    @Override
    public void inADirective(
            ADirective node) {

        String directive_name
                = GenerationUtils.buildNameCamelCase(node.getNames());

        this.currentDirective = new MNewDirective(directive_name,
                this.indexBuilder.toString());
        this.currentInitDirectivesC.addNewDirective(this.currentDirective);
    }

    @Override
    public void outADirective(
            ADirective node) {

        this.indexBuilder++;
        this.currentDirective = null;
    }

    @Override
    public void inAMacroRef(
            AMacroRef node) {

        String macro_ref_name = this.currentMacroRefName
                = GenerationUtils.buildNameCamelCase(node.getNames());

        if(this.currentContextName != null)
        {
            this.currentMacroC.addIncludes(new MInclude(macro_ref_name));

            this.currentParamMacroRefBuilder = new MParamMacroRefBuilder(this.currentParamName, macro_ref_name);
            this.currentMacroC.addInternalFunctions(this.currentParamMacroRefBuilder);

            this.currentMParamMacroArgH = new MParamMacroArgH();
            this.currentMAddMacroH.addParamArgs(this.currentMParamMacroArgH);
            this.currentMAddMacroVtH.addParamArgs(this.currentMParamMacroArgH);

            this.currentMParamMacroArgC = new MParamMacroArgC();
            this.currentMAddMacroC.addParamArg(this.currentMParamMacroArgC);

            this.currentParamMacroArgType = new MParamMacroArgType(macro_ref_name);

            this.currentMParamMacroArgH.addParamType(this.currentParamMacroArgType);
            this.currentMParamMacroArgC.addParamType(this.currentParamMacroArgType);

            this.currentRedefParentInternalsSetterC = new MRedefParentInternalsSetterC(macro_ref_name);
            this.currentRedefInternalsInitializerC.addRedefParentInternalsSetterC(this.currentRedefParentInternalsSetterC);
        }
    }

    @Override
    public void outAMacroRef(
            AMacroRef node) {

        this.currentMacroRefName = null;
        this.currentParamMacroArgType = null;
        this.currentMParamMacroArgH = null;
        this.currentMParamMacroArgC = null;
    }

    @Override
    public void caseAStringValue(
            AStringValue node) {
        this.indexBuilder++;
        String index_builder = String.valueOf(this.indexBuilder);
        boolean anyContext = this.currentContextName != null;

        if(anyContext)
        {
            MInitStringBuilder mInitStringBuilder = new MInitStringBuilder(index_builder);
            this.currentRedefParentInternalsSetterC.addMacroBodyParts(mInitStringBuilder);

            MSetInternal mSetInternal = new MSetInternal(GenerationUtils.buildNameCamelCase(node.getParamName()),
                    this.currentContextName);
            this.currentRedefParentInternalsSetterC.addSetInternals(mSetInternal);
            mSetInternal.addSetParams(new MStringBuilderBuild(index_builder));

            for (PTextPart part : node.getParts()) {
                part.apply(this);
            }
        }
        else
        {
            index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);

            while (this.createdBuilders.contains(index_builder)) {
                this.indexBuilder++;
                index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);
            }

            this.currentInsertMacroPart.addMacroBodyParts(new MInitStringBuilder(index_builder));
            this.createdBuilders.add(index_builder);

            Integer tempIndexBuilder = this.indexBuilder;
            Integer tempIndexInsert = this.indexInsert;

            for (PTextPart part : node.getParts()) {
                part.apply(this);
            }

            this.indexBuilder = tempIndexBuilder;
            this.indexInsert = tempIndexInsert;

            MSetInternal mSetInternal = new MSetInternal(
                    GenerationUtils.buildNameCamelCase(node.getParamName()),
                    "NULL");
            this.currentInsertMacroPart.addSetInternals(mSetInternal);
            mSetInternal.addSetParams(new MStringBuilderBuild(index_builder));
        }

    }

    @Override
    public void caseAStringTextPart(
            AStringTextPart node) {

        String index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);

        if (this.currentContextName != null
                && this.currentRedefParentInternalsSetterC != null) {

            this.currentRedefParentInternalsSetterC
                    .addMacroBodyParts(new MStringPart(
                            GenerationUtils.escapedString(node.getString()),
                            String.valueOf(this.indexBuilder)));
        }
        else {
            String string = GenerationUtils.escapedString(node.getString());

            if (this.currentInsertMacroPart != null) {
                index_builder = GenerationUtils
                        .getLetterFromInteger(this.indexBuilder);

                this.currentInsertMacroPart.addMacroBodyParts(
                        new MStringPart(string, index_builder));
            }
            else if (this.currentDirective != null) {
                index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);
                this.currentDirective.addMacroBodyParts(
                        new MStringPart(string, index_builder));
            }
            else if (this.currentAddIndent != null) {
                this.currentAddIndent.addMacroBodyParts(
                        new MStringPart(string, GenerationUtils.INDENTATION));
            }
        }
    }

    @Override
    public void caseAVarTextPart(
            AVarTextPart node) {
        String index_builder = String.valueOf(this.indexBuilder);
        String param_name = GenerationUtils.buildNameCamelCase(node.getNames());

        if (this.currentContextName != null
                && this.currentRedefParentInternalsSetterC != null) {

            this.currentRedefParentInternalsSetterC.addMacroBodyParts(
                    new MParamInsertPart(param_name, index_builder));
        }
        else
        {
            if (this.currentInsertMacroPart != null) {
                index_builder = GenerationUtils
                        .getLetterFromInteger(this.indexBuilder);
                this.currentInsertMacroPart.addMacroBodyParts(
                        new MParamInsertPart(param_name, index_builder));
            }
            else if (this.currentDirective != null) {
                this.currentDirective.addMacroBodyParts(
                        new MParamInsertPart(param_name, index_builder));
            }
            else if (this.currentAddIndent != null) {
                this.currentAddIndent.addMacroBodyParts(new MParamInsertPart(
                        param_name, GenerationUtils.INDENTATION));
            }
        }
    }

    @Override
    public void caseAEolTextPart(
            AEolTextPart node) {

        String index_builder = String.valueOf(this.indexBuilder);

        if (this.currentContextName != null
                && this.currentRedefParentInternalsSetterC != null) {

            this.currentRedefParentInternalsSetterC
                    .addMacroBodyParts(new MEolPart(index_builder));
        }
        else {

            if (this.currentInsertMacroPart != null) {
                index_builder = GenerationUtils
                        .getLetterFromInteger(this.indexBuilder);
                this.currentInsertMacroPart
                        .addMacroBodyParts(new MEolPart(index_builder));
            }
            else if (this.currentDirective != null) {
                this.currentDirective
                        .addMacroBodyParts(new MEolPart(index_builder));
            }
            else if (this.currentAddIndent != null) {
                this.currentAddIndent.addMacroBodyParts(
                        new MEolPart(GenerationUtils.INDENTATION));
            }
        }
    }

    @Override
    public void caseAInsertTextPart(
            AInsertTextPart node) {

        MInsertMacroPart tempInsertMacroPart = this.currentInsertMacroPart;
        AMacroRef macroRef = (AMacroRef) node.getMacroRef();
        String macro_name
                = GenerationUtils.buildNameCamelCase(macroRef.getNames());
        this.currentMacroC.addIncludes(new MInclude(macro_name));
        String index_builder = String.valueOf(this.indexBuilder);

        // Avoid declaring insert of the same name
        while (this.createdInserts.contains(this.indexInsert)) {
            this.indexInsert++;
        }

        String index_insert = String.valueOf(this.indexInsert);

        if (this.currentContextName != null
                && this.currentRedefParentInternalsSetterC != null) {

            this.currentInsertMacroPart = new MInsertMacroPart(index_builder, index_insert, macro_name);
            this.currentRedefParentInternalsSetterC
                    .addMacroBodyParts(this.currentInsertMacroPart);
        }
        else {
            if (tempInsertMacroPart != null) {
                index_builder = GenerationUtils
                        .getLetterFromInteger(this.indexBuilder);

                this.currentInsertMacroPart = new MInsertMacroPart(index_builder, index_insert, macro_name);
                tempInsertMacroPart
                        .addMacroBodyParts(this.currentInsertMacroPart);

            }
            else if (this.currentDirective != null) {
                this.currentInsertMacroPart = new MInsertMacroPart(index_builder, index_insert, macro_name);
                this.currentDirective
                        .addMacroBodyParts(this.currentInsertMacroPart);
            }
            else if (this.currentAddIndent != null) {
                MInsertMacroPart mInsertMacroPart = new MInsertMacroPart(GenerationUtils.INDENTATION, index_insert, macro_name);
                this.currentInsertMacroPart = mInsertMacroPart;
                this.currentAddIndent.addMacroBodyParts(mInsertMacroPart);
            }
        }
        this.createdInserts.add(this.indexInsert);

        String tempContext = this.currentContextName;
        String tempMacroName = this.currentMacroRefName;
        Integer tempIndex = this.indexBuilder;
        Integer tempIndexInsert = this.indexInsert;
        this.currentContextName = null;

        node.getMacroRef().apply(this);

        this.indexBuilder = tempIndex;
        this.indexInsert = tempIndexInsert;
        this.currentContextName = tempContext;
        this.currentMacroRefName = tempMacroName;
        this.currentInsertMacroPart = tempInsertMacroPart;
    }

    @Override
    public void outAVarValue(
            AVarValue node) {

        String var_name = GenerationUtils.buildNameCamelCase(node.getNames());

        if (this.currentContextName != null) {

            MSetInternal mSetInternal
                    = new MSetInternal(GenerationUtils
                            .buildNameCamelCase(node.getParamName()),
                    this.currentContextName);
            MParamRef paramRef = new MParamRef(var_name, "this");
            this.currentRedefParentInternalsSetterC.addSetInternals(mSetInternal);
            mSetInternal.addSetParams(paramRef);

            if (this.currentMacro.getInternalsName().contains(var_name)) {
                paramRef.addGetParams(new MContextName(
                        GenerationUtils.CONTEXT_STRING.toLowerCase()));
            }
        }
        else {
            MSetInternal mSetInternal = new MSetInternal(GenerationUtils.buildNameCamelCase(node.getParamName()),
                    "NULL");
            this.currentInsertMacroPart.addSetInternals(mSetInternal);
            MParamRef mParamRef = new MParamRef(var_name, "this");
            mSetInternal.addSetParams(mParamRef);

            if (this.currentMacro.getInternalsName().contains(var_name)) {
                mParamRef.addGetParams(new MContextArg());
            }
        }
    }

    @Override
    public void caseAIndentMacroPart(
            AIndentMacroPart node) {

        this.currentlyUsed.add(this.indexBuilder);
        this.indexBuilder++;
        // Avoid declaring insert of the same name
        while (this.createdBuilders
                .contains(String.valueOf(this.indexBuilder))) {
            this.indexBuilder++;
        }
        String index_builder = String.valueOf(this.indexBuilder);
        this.currentMacroBuilder
                .addMacroBodyParts(new MInitStringBuilder(index_builder));
        MAddIndent mAddIndent = new MAddIndent();
        this.currentAddIndent = mAddIndent;
        this.currentMacroBuilder.addMacroBodyParts(mAddIndent);
        this.createdBuilders.add(index_builder);

        // To avoid modification on indexes
        Integer tempIndexBuilder = this.indexBuilder;
        Integer tempIndexInsert = this.indexInsert;

        for (PTextPart part : node.getTextPart()) {
            part.apply(this);
        }

        this.indexBuilder = tempIndexBuilder;
        this.indexInsert = tempIndexInsert;

        this.indentations.add(this.currentAddIndent);
        this.currentAddIndent = null;
    }

    @Override
    public void caseAEndIndentMacroPart(
            AEndIndentMacroPart node) {

        String index_indent = String.valueOf(this.indexBuilder);
        this.indexBuilder
                = this.currentlyUsed.remove(this.currentlyUsed.size() - 1);
        this.indentations.remove(this.indentations.size() - 1);
        this.currentMacroBuilder.addMacroBodyParts(new MIndentPart(
                String.valueOf(this.indexBuilder), index_indent));
    }

    @Override
    public void caseAStringMacroPart(
            AStringMacroPart node) {
        MStringPart mStringPart = new MStringPart(GenerationUtils.escapedString(node.getString()), String.valueOf(this.indexBuilder));
        this.currentMacroBuilder.addMacroBodyParts(mStringPart);
    }

    @Override
    public void caseAInsertMacroPart(
            AInsertMacroPart node) {

        AMacroRef macroRef = (AMacroRef) node.getMacroRef();
        String macro_name
                = GenerationUtils.buildNameCamelCase(macroRef.getNames());
        this.currentMacroC.addIncludes(new MInclude(macro_name));
        this.indexInsert++;

        this.currentInsertMacroPart = new MInsertMacroPart(String.valueOf(this.indexBuilder), String.valueOf(this.indexInsert), macro_name);
        this.currentMacroBuilder.addMacroBodyParts(this.currentInsertMacroPart);

        this.createdInserts.add(this.indexInsert);
        Integer tempIndexBuilder = this.indexBuilder;
        Integer tempIndexInsert = this.indexInsert;

        node.getMacroRef().apply(this);

        this.indexInsert = tempIndexInsert;
        this.indexBuilder = tempIndexBuilder;
        this.currentInsertMacroPart = null;
    }

    @Override
    public void outAVarMacroPart(
            AVarMacroPart node) {

        String param_name = GenerationUtils.buildNameCamelCase(node.getNames());
        MParamInsertPart mParamInsertPart = new MParamInsertPart(param_name,
                String.valueOf(this.indexBuilder));

        if (this.currentMacro.getInternalsName().contains(param_name)) {
            mParamInsertPart.addContextArg(new MContextArg());
        }

        this.currentMacroBuilder.addMacroBodyParts(mParamInsertPart);
    }
}