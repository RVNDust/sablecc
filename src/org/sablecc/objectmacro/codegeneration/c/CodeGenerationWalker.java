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
import org.sablecc.objectmacro.intermediate.syntax3.analysis.DepthFirstAdapter;
import org.sablecc.objectmacro.intermediate.syntax3.node.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

    private String currentParamName;
    private MMacroBuilder currentMacroBuilder;
    private MParamRefBuilderH currentParamRefBuilderH;
    private MParamMacroRefBuilder currentParamMacroRefBuilder;
    private MInsertMacroPart currentInsertMacroPart;
    private int indexBuilder = 0;
    private int indexInsert = 0;

    private List<Integer> createdBuilders = new ArrayList<>();
    private List<Integer> createdInserts = new ArrayList<>();

    public CodeGenerationWalker(
            IntermediateRepresentation ir,
            File packageDirectory) {
        this.ir = ir;
        this.packageDirectory = packageDirectory;
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
    }

    @Override
    public void inAMacro(
            AMacro node) {
        currentMacroName = GenerationUtils.buildNameCamelCase(node.getNames());

        this.currentMacroH = new MMacroH(currentMacroName);
        this.currentMacroC = new MMacroC(currentMacroName);

        this.currentConstructorH = new MConstructorH();
        this.currentConstructorC = new MConstructorC();
        this.currentMacroH.addConstructor(this.currentConstructorH);
        this.currentMacroC.addConstructor(this.currentConstructorC);

        this.currentMacroBuilder = new MMacroBuilder();
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

    }

    @Override
    public void caseAInternal(
            AInternal node) {
        String paramName = GenerationUtils.buildNameCamelCase(node.getNames());

        this.indexBuilder = 0;

        if (node.getType() instanceof AStringType) {

        }
    }

    @Override
    public void outAInternal(
            AInternal node) {
        this.indexBuilder = 0;
        this.indexInsert = 0;
    }

    @Override
    public void caseAParam(
            AParam node) {
        String paramName = this.currentParamName
                = GenerationUtils.buildNameCamelCase(node.getNames());

        this.indexBuilder = 0;

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
            this.currentMacroH.addFields(new MFieldMacroDeclaration(paramName));

            this.currentMAddMacroH = new MAddMacroH(paramName);

            this.currentMAddMacroVtH = new MAddMacroVtH(paramName);

            this.currentMAddMacroC = new MAddMacroC(paramName);

            this.currentMacroH.addFunctions(this.currentMAddMacroH);
            this.currentMacroH.addMethods(this.currentMAddMacroVtH);

            this.currentConstructorC.addFieldInitializers(new MFieldMacroInitializer(paramName));
            this.currentMacroC.addFunctionNames(new MFunctionRefs("add",paramName));
            this.currentMacroC.addFunctions(this.currentMAddMacroC);

            this.currentParamRefBuilderH = new MParamRefBuilderH(paramName);
            this.currentMacroH.addFunctions(this.currentParamRefBuilderH);
        }

        node.getType().apply(this);
        outAParam(node);
    }

    @Override
    public void outAParam(
            AParam node) {
        this.indexBuilder = 0;
        this.indexInsert = 0;
    }

    @Override
    public void inAMacroRef(
            AMacroRef node) {

        String macro_ref_name = this.currentMacroRefName
                = GenerationUtils.buildNameCamelCase(node.getNames());

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

    }

    @Override
    public void caseAVarTextPart(
            AVarTextPart node) {
        String index_builder = String.valueOf(this.indexBuilder);
        String param_name = GenerationUtils.buildNameCamelCase(node.getNames());

        index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);

        if(this.currentInsertMacroPart != null)
        {
            this.currentInsertMacroPart.addMacroBodyParts(new MParamInsertPart(param_name, index_builder));
        }

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
        this.indexInsert++;

        this.currentInsertMacroPart = new MInsertMacroPart(String.valueOf(this.indexBuilder), String.valueOf(this.indexInsert));
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
        this.currentMacroBuilder.addMacroBodyParts(mParamInsertPart);
    }
}