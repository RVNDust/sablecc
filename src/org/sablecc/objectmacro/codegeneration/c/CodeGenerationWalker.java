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
import org.sablecc.objectmacro.exception.CompilerException;
import org.sablecc.objectmacro.intermediate.syntax3.analysis.DepthFirstAdapter;
import org.sablecc.objectmacro.intermediate.syntax3.node.*;
import org.sablecc.sablecc.codegeneration.java.macro.MNode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class CodeGenerationWalker extends
        DepthFirstAdapter {

    private final IntermediateRepresentation ir;

    private final File packageDirectory;

    private MSuperMacroH mSuperMacroH;
    private MSuperMacroC mSuperMacroC;

    private MLinkedListH mLinkedListH;
    private MLinkedListC mLinkedListC;
    private MLinkedListNodeH mLinkedListNodeH;

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
    }

    @Override
    public void inAMacro(
            AMacro node) {
    }

    @Override
    public void outAMacro(
            AMacro node) {

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