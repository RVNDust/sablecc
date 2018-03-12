<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Add copyrights
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
<<<<<<< HEAD
package org.sablecc.objectmacro.walker;

=======
package org.sablecc.objectmacro.walker;

import org.sablecc.objectmacro.exception.CompilerException;
<<<<<<< HEAD
import org.sablecc.objectmacro.structure.Insert;
>>>>>>> Split DefinitionCollector into MacroReferenceCollector and ParamReferenceCollector
=======
>>>>>>> Add line and pos to a param reference in order to get the line and position in an error
=======
package org.sablecc.objectmacro.walker;

>>>>>>> Add copyrights
import org.sablecc.objectmacro.syntax3.analysis.DepthFirstAdapter;
import org.sablecc.objectmacro.structure.GlobalIndex;
import org.sablecc.objectmacro.structure.Macro;
import org.sablecc.objectmacro.structure.Param;
import org.sablecc.objectmacro.syntax3.node.*;
import org.sablecc.objectmacro.util.Utils;

<<<<<<< HEAD
<<<<<<< HEAD
=======
/**
 * Created by lam on 06/09/17.
 */
>>>>>>> Split DefinitionCollector into MacroReferenceCollector and ParamReferenceCollector
=======
>>>>>>> Add copyrights
public class ParamReferenceCollector
        extends DepthFirstAdapter {

    private final GlobalIndex globalIndex;

    private Macro currentMacro;

    private Param currentParam;

    public ParamReferenceCollector(
            GlobalIndex globalIndex) {

        this.globalIndex = globalIndex;
    }

    @Override
    public void inAMacro(
            AMacro node) {

        this.currentMacro = this.globalIndex.getMacro(node.getName());
    }

    @Override
    public void outAMacro(
            AMacro node) {

        this.currentMacro = null;
    }

    @Override
    public void caseAVarStringPart(
            AVarStringPart node) {

        if(this.currentParam != null){
            this.currentParam.addParamReference(
                    new TIdentifier(
                            Utils.getVarName(
<<<<<<< HEAD
<<<<<<< HEAD
                                    node.getVariable()), node.getVariable().getLine(), node.getVariable().getPos()));
=======
                                    node.getVariable())));
>>>>>>> Split DefinitionCollector into MacroReferenceCollector and ParamReferenceCollector
=======
                                    node.getVariable()), node.getVariable().getLine(), node.getVariable().getPos()));
>>>>>>> Add line and pos to a param reference in order to get the line and position in an error
        }
    }

    @Override
    public void caseAVarStaticValue(
            AVarStaticValue node) {

        if(this.currentParam != null){
            this.currentParam.addParamReference(node.getIdentifier());
        }
    }

    @Override
    public void inAParam(
            AParam node) {

        this.currentParam = this.currentMacro
                .getParam(node.getName());
    }

    @Override
    public void outAParam(
            AParam node) {

        this.currentParam = null;
    }

    @Override
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public void inAInternal(
            AInternal node) {

        this.currentParam = this.currentMacro
                .getParam(node.getName());
    }

    @Override
    public void outAInternal(
            AInternal node) {

        this.currentParam = null;
=======
    public void caseAStringType(
            AStringType node) {

        this.currentMacro.setParamToString(
                this.currentParam.getNameDeclaration());
>>>>>>> Split DefinitionCollector into MacroReferenceCollector and ParamReferenceCollector
=======
    public void inAInternal(
            AInternal node) {

        this.currentParam = this.currentMacro
                .getParam(node.getName());
    }

    @Override
    public void outAInternal(
            AInternal node) {

        this.currentParam = null;
>>>>>>> Remove arguments in macro references in internal declaration
=======
    public void caseAStringType(
            AStringType node) {

        this.currentMacro.setParamToString(
                this.currentParam.getNameDeclaration());
>>>>>>> Changement Objectmacro-back
=======
    public void inAInternal(
            AInternal node) {

        this.currentParam = this.currentMacro
                .getParam(node.getName());
    }

    @Override
    public void outAInternal(
            AInternal node) {

        this.currentParam = null;
>>>>>>> Revert "Changement Objectmacro-back"
    }
}
