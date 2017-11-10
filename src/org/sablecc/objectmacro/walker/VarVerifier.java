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

package org.sablecc.objectmacro.walker;

import org.sablecc.exception.*;
import org.sablecc.objectmacro.exception.CompilerException;
import org.sablecc.objectmacro.structure.*;
import org.sablecc.objectmacro.syntax3.analysis.*;
import org.sablecc.objectmacro.syntax3.node.*;
import org.sablecc.objectmacro.util.Utils;

import java.util.HashSet;
import java.util.Set;

public class VarVerifier
        extends DepthFirstAdapter {

    private final GlobalIndex globalIndex;

    private Macro currentMacro;

    private Param paramsList[];

    private Integer currentIndex = 0;

    public VarVerifier(
            GlobalIndex globalIndex) {

        if (globalIndex == null) {
            throw new InternalException("globalIndex may not be null");
        }

        this.globalIndex = globalIndex;
    }

    @Override
    public void inAMacro(
            AMacro node) {

        this.currentMacro = this.globalIndex.getMacro(node.getName());
    }

    @Override
    public void inAMacroReference(
            AMacroReference node) {

        Macro referencedMacro = this.globalIndex.getMacro(node.getName());

        this.paramsList = new Param[referencedMacro.getAllInternals().size()];
        referencedMacro.getAllInternals().toArray(this.paramsList);
        this.currentIndex = 0;
    }

    @Override
    public void caseAStringStaticValue(
            AStringStaticValue node) {

        Param currentParam = this.paramsList[this.currentIndex++];
        AMacroReference macroReference = (AMacroReference) node.parent();

        //The internal corresponding to currentIndex must be of type String here
        if(!currentParam.isString()){

            throw CompilerException.incorrectArgumentType("Macro", "String",
                    macroReference.getName().getLine(), macroReference.getName().getPos());
        }

        //Apply to each part in case of insert
        Integer tempIndex = this.currentIndex;
        Param tempParams[] = this.paramsList;

        for(PStringPart value : node.getParts()){
            value.apply(this);
        }

        this.currentIndex = tempIndex;
        this.paramsList = tempParams;
    }

    @Override
    public void caseAVarStaticValue(
            AVarStaticValue node) {

        Param expectedParam = this.paramsList[this.currentIndex++];
        Param providedParam = this.currentMacro.getParam(node.getIdentifier());
        Set<String> expectedMacrosType = new HashSet<>();
        Set<String> providedMacrosType = new HashSet<>();

        if(expectedParam.isString()
                && !providedParam.isString()){

            throw CompilerException.incorrectArgumentType(
                    "String", "Macro",
                    node.getIdentifier().getLine(), node.getIdentifier().getPos());
        }

        for(AMacroReference macroReference : expectedParam.getMacroReferences()){
            expectedMacrosType.add(macroReference.getName().getText());
        }

        for(AMacroReference macroReference : providedParam.getMacroReferences()){
            providedMacrosType.add(macroReference.getName().getText());
        }

        if(!expectedMacrosType.containsAll(providedMacrosType)){

            throw CompilerException.incorrectMacroType(
                    expectedMacrosType,
                    providedMacrosType, currentIndex, node.getIdentifier());
        }

        this.currentMacro.setParamUsed(node.getIdentifier());
    }

    @Override
    public void caseAVarMacroBodyPart(
            AVarMacroBodyPart node) {

        this.currentMacro.setParamUsed(
                new TIdentifier(Utils.getVarName(
                                    node.getVariable()),
                                    node.getVariable().getLine(), node.getVariable().getPos()));

    }
}
