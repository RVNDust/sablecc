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

package org.sablecc.objectmacro.structure;

import org.sablecc.exception.*;
<<<<<<< HEAD
import org.sablecc.objectmacro.exception.*;
=======
import org.sablecc.objectmacro.exception.CompilerException;
>>>>>>> ObjectMacro2 syntaxic/lexical/semantic analysis
import org.sablecc.objectmacro.syntax3.node.*;
<<<<<<< HEAD

import java.util.*;
=======
>>>>>>> Clean up code, add comments

import java.util.*;

public class Param {

    private final GlobalIndex globalIndex;
<<<<<<< HEAD
=======

    private final AParam declaration;
>>>>>>> Verification macro existence when adding a new macro reference

    private final Macro parent;

    private final Set<AMacroReference> macroReferences = new LinkedHashSet<>();

<<<<<<< HEAD
    private final Map<String, AMacroReference> macroReferencesName = new HashMap<>();

    private final Map<String, Param> paramReferences = new LinkedHashMap<>();
=======
    private final Macro parent;

    private final Set<AMacroReference> macroReferences = new LinkedHashSet<>();

    private final Map<String, AMacroReference> macroReferencesName = new HashMap<>();

    private final Map<String, Param> paramReferences = new LinkedHashMap<>();

    private final Map<String, Directive> directives = new HashMap<>();

    private final Set<Directive> allDirectives = new LinkedHashSet<>();
>>>>>>> ObjectMacro2 syntaxic/lexical/semantic analysis

    private boolean isUsed;

    private boolean isString;

    Param(
<<<<<<< HEAD
            Macro macro,
            GlobalIndex globalIndex) {
=======
            AParam declaration,
<<<<<<< HEAD
            Macro macro) {
>>>>>>> ObjectMacro2 syntaxic/lexical/semantic analysis
=======
            Macro macro,
            GlobalIndex globalIndex) {
>>>>>>> Verification macro existence when adding a new macro reference

        if (macro == null) {
            throw new InternalException("scope may not be null");
        }

<<<<<<< HEAD
        if(globalIndex == null){
            throw new InternalException("globalIndex may not be null");
        }

        this.parent = macro;
        this.globalIndex = globalIndex;
=======
        if (macro == null) {
            throw new InternalException("scope may not be null");
        }

        if(globalIndex == null){
            throw new InternalException("globalIndex may not be null");
        }

        this.declaration = declaration;
        this.parent = macro;
        this.globalIndex = globalIndex;
    }

    public Directive newDirective(
            ADirective directive) {

        String optionName = directive.getName().getText();
        if (this.directives.containsKey(optionName)) {
            throw CompilerException.duplicateOption(
                    directive, this.directives.get(optionName).getDeclaration());
        }

        Directive newDirective = new Directive(directive, this);
        this.directives.put(
                optionName, newDirective);
        this.allDirectives.add(newDirective);

        return newDirective;
    }

    public void addMacroReference(
            AMacroReference macroRef){

        if(macroRef == null){
            throw new InternalException("Macro reference cannot be null");
        }

        TIdentifier identifier = macroRef.getName();

        if(this.globalIndex.getMacro(identifier) == null){
            throw CompilerException.unknownMacro(identifier);
        }

        if(this.macroReferencesName.containsKey(identifier.getText())){
            throw CompilerException.duplicateMacroRef(macroRef.getName(), getDeclaration().getName());
        }

        this.macroReferences.add(macroRef);
        this.macroReferencesName.put(identifier.getText(), macroRef);

    }

    public void addParamReference(
            TIdentifier paramName){

        if(paramName == null){
            throw new InternalException("param cannot be null");
        }

        String name = paramName.getText();

        if(name.equals(getName())){
            throw CompilerException.selfReference(paramName, getNameDeclaration());
        }

        Param newParamRef = this.parent.getParam(paramName);

        if(newParamRef == null){
            throw new InternalException("parameter may not be null");
        }

        this.paramReferences.put(name, newParamRef);
    }

    public Set<Directive> getAllDirectives(){
        return this.allDirectives;
    }

    public Set<AMacroReference> getMacroReferences(){
        return this.macroReferences;
>>>>>>> ObjectMacro2 syntaxic/lexical/semantic analysis
    }

<<<<<<< HEAD
    public void addMacroReference(
            AMacroReference macroRef){

        if(macroRef == null){
            throw new InternalException("Macro reference cannot be null");
        }

        TIdentifier identifier = macroRef.getName();

        if(this.globalIndex.getMacro(identifier) == null){
            throw CompilerException.unknownMacro(identifier);
        }

        if(this.macroReferencesName.containsKey(identifier.getText())){
            throw CompilerException.duplicateMacroRef(macroRef.getName(), getNameDeclaration());
        }

        this.macroReferences.add(macroRef);
        this.macroReferencesName.put(identifier.getText(), macroRef);
    }

<<<<<<< HEAD
    public void addParamReference(
            TIdentifier paramName){

        if(paramName == null){
            throw new InternalException("param cannot be null");
        }

        String name = paramName.getText();
        if(name.equals(getName())){
            throw CompilerException.selfReference(paramName, getNameDeclaration());
        }

        Param newParamRef = this.parent.getParam(paramName);
        if(newParamRef == null){
            throw new InternalException("parameter may not be null");
        }

        this.paramReferences.put(name, newParamRef);
=======
    public TIdentifier getNameDeclaration() {
        return this.declaration.getName();
    }

    public String getName() {
        return this.declaration.getName().getText();
>>>>>>> Clean up code, add comments
    }

<<<<<<< HEAD
    public Set<AMacroReference> getMacroReferences(){
        return this.macroReferences;
    }

    public TIdentifier getNameDeclaration(){
        return null;
=======
=======
>>>>>>> Split DefinitionCollector into MacroReferenceCollector and ParamReferenceCollector
    public AParam getDeclaration(){
        return this.declaration;
>>>>>>> ObjectMacro2 syntaxic/lexical/semantic analysis
    }

<<<<<<< HEAD
    public String getName() {
        return null;
    }

=======
>>>>>>> Clean up code, add comments
    public boolean isUsed() {
        return this.isUsed;
    }

    void setUsed() {
        this.isUsed = true;
    }

    public boolean isString(){
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> ObjectMacro2 syntaxic/lexical/semantic analysis
=======
>>>>>>> Clean up code, add comments
        return this.isString;
    }

    void setString(){
<<<<<<< HEAD
<<<<<<< HEAD
        this.isString = true;
    }

    Set<Param> getDirectParamReferences(){

        Set<Param> directlyParams = new HashSet<>();
        for(Param param : this.paramReferences.values()){
            directlyParams.add(param);
        }

        return Collections.unmodifiableSet(directlyParams);
    }

    public Macro getParent(){
        return this.parent;
=======

=======
>>>>>>> Clean up code, add comments
        this.isString = true;
>>>>>>> ObjectMacro2 syntaxic/lexical/semantic analysis
    }

    public Set<Param> getDirectParamReferences(){

        Set<Param> directlyParams = new HashSet<>();
        for(Param param : this.paramReferences.values()){
            directlyParams.add(param);
        }

        return Collections.unmodifiableSet(directlyParams);
    }

    public Macro getParent(){
        return this.parent;
    }
}
