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

    private MMacroH currentMacroH;
    private MMacroC currentMacroC;
    private String currentMacroName;

    private String currentParamName;
    private MMacroBuilder currentMacroBuilder;

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
    }

    @Override
    public void inAMacro(
            AMacro node) {
        currentMacroName = GenerationUtils.buildNameCamelCase(node.getNames());

        this.currentMacroH = new MMacroH(currentMacroName);
        this.currentMacroC = new MMacroC(currentMacroName);

        this.currentMacroBuilder = new MMacroBuilder();
        this.currentMacroC.addMacroBuilder(this.currentMacroBuilder);
    }

    @Override
    public void outAMacro(
            AMacro node) {
        GenerationUtils.writeFile(this.packageDirectory, currentMacroName+".h",
                this.currentMacroH.build());
        GenerationUtils.writeFile(this.packageDirectory, currentMacroName+".c",
                this.currentMacroC.build());

    }

    @Override
    public void caseAInternal(
            AInternal node) {

    }

    @Override
    public void outAInternal(
            AInternal node) {

    }

    @Override
    public void caseAParam(
            AParam node) {
        String paramName = this.currentParamName
                = GenerationUtils.buildNameCamelCase(node.getNames());

        if (node.getType() instanceof AStringType) {

            this.currentMacroH.addFields(new MFieldStringDeclaration(paramName));
            this.currentMacroH.addFunctions(new MGetterStringH(paramName));
            this.currentMacroH.addFunctions(new MSetterStringH(paramName));
            this.currentMacroH.addMethods(new MGetterStringVtH(paramName));
            this.currentMacroH.addMethods(new MSetterStringVtH(paramName));

            this.currentMacroC.addFieldInitializers(new MFieldStringInitializer(paramName));
            this.currentMacroC.addFunctionNames(new MFunctionRefs("get",paramName));
            this.currentMacroC.addFunctionNames(new MFunctionRefs("set",paramName));
            this.currentMacroC.addFunctions(new MGetterStringC(paramName));
            this.currentMacroC.addFunctions(new MSetterStringC(paramName));
        }
        else if (node.getType() instanceof AMacroRefsType) {
            this.currentMacroH.addFields(new MFieldMacroDeclaration(paramName));
//            this.currentMacroH.addFunctions(new MGetterMacroH(paramName));
//            this.currentMacroH.addMethods(new MGetterMacroVtH(paramName));

            this.currentMacroC.addFieldInitializers(new MFieldMacroInitializer(paramName));
            this.currentMacroC.addFunctionNames(new MFunctionRefs("get",paramName));
            this.currentMacroC.addFunctionNames(new MFunctionRefs("set",paramName));
//            this.currentMacroC.addFunctions(new MGetterMacroC(paramName));
        }
    }

    @Override
    public void outAParam(
            AParam node) {

    }

    @Override
    public void caseAStringValue(
            AStringValue node) {

    }

}