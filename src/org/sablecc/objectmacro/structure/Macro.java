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

import java.util.*;

import org.sablecc.exception.*;
import org.sablecc.objectmacro.exception.*;
import org.sablecc.objectmacro.syntax3.node.*;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import org.sablecc.util.ComponentFinder;
import org.sablecc.util.Progeny;
=======
import org.sablecc.objectmacro.util.Utils;
<<<<<<< HEAD
>>>>>>> ObjectMacro2 syntaxic/lexical/semantic analysis
=======
=======
>>>>>>> Clean up some unused code
import org.sablecc.util.ComponentFinder;
import org.sablecc.util.Progeny;
>>>>>>> Add cyclic semantic verification using component finder and progeny

public class Macro{

    private final GlobalIndex globalIndex;

    private final AMacro declaration;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    private final Set<External> allParams = new LinkedHashSet<>();

    private final Map<String, External> namedParams = new HashMap<>();

    private final Set<Internal> allInternals = new LinkedHashSet<>();

    private final Map<String, Internal> namedInternals = new HashMap<>();

    private ComponentFinder<Param> paramsComponentFinder;
=======
    private final Set<Param> allParams = new LinkedHashSet<>();
=======
    private final Set<External> allParams = new LinkedHashSet<>();
>>>>>>> Remove arguments in macro references in internal declaration
=======
    private final Set<Param> allParams = new LinkedHashSet<>();
>>>>>>> Changement Objectmacro-back
=======
    private final Set<External> allParams = new LinkedHashSet<>();
>>>>>>> Revert "Changement Objectmacro-back"

    private final Map<String, External> namedParams = new HashMap<>();

    private final Set<Internal> allInternals = new LinkedHashSet<>();

    private final Map<String, Internal> namedInternals = new HashMap<>();

<<<<<<< HEAD
<<<<<<< HEAD
    private Set<Insert> inserts = new LinkedHashSet<>();
>>>>>>> ObjectMacro2 syntaxic/lexical/semantic analysis

=======
>>>>>>> Clean up some unused code
=======
=======
import org.sablecc.util.ComponentFinder;
import org.sablecc.util.Progeny;

public class Macro{

    private final GlobalIndex globalIndex;

    private final AMacro declaration;

    private final Set<External> allParams = new LinkedHashSet<>();

    private final Map<String, External> namedParams = new HashMap<>();

    private final Set<Internal> allInternals = new LinkedHashSet<>();

    private final Map<String, Internal> namedInternals = new HashMap<>();

>>>>>>> object-macro2.1
    private ComponentFinder<Param> paramsComponentFinder;

>>>>>>> Update initialization order using linearisation created in the component finder
    Macro(
            GlobalIndex globalIndex,
            AMacro declaration) {

        if (globalIndex == null) {
            throw new InternalException("globalIndex may not be null");
        }

        if (declaration == null) {
            throw new InternalException("declaration may not be null");
        }

        this.globalIndex = globalIndex;
        this.declaration = declaration;
    }
<<<<<<< HEAD

    public Param newParam(
            AParam param){

        if(param == null){
            throw new InternalException("AParam should not be null");
<<<<<<< HEAD
=======

    public Param newParam(
            AParam param){

        if(param == null){
            throw new InternalException("AParam should not be null");
=======
>>>>>>> object-macro2.1
        }

        TIdentifier name = param.getName();
        String stringName = name.getText();
<<<<<<< HEAD

        if(containsKeyInInternals(stringName) || containsKeyInParams(stringName)){
            throw CompilerException.duplicateDeclaration(name, getNameDeclaration());
>>>>>>> ObjectMacro2 syntaxic/lexical/semantic analysis
        }

<<<<<<< HEAD
<<<<<<< HEAD
        this.namedParams.put(stringName, newParam);
        this.allParams.add(newParam);

        return newParam;
    }

<<<<<<< HEAD
        TIdentifier name = param.getName();
        String stringName = name.getText();

        if(containsKeyInInternals(stringName) || containsKeyInParams(stringName)){
            throw CompilerException.duplicateDeclaration(name, getNameDeclaration());
        }

<<<<<<< HEAD
<<<<<<< HEAD
        External newParam = new External(param, this, this.globalIndex);
=======
        Param newParam = new Param(param, this, this.globalIndex);
>>>>>>> Verification macro existence when adding a new macro reference
=======
        External newParam = new External(param, this, this.globalIndex);
>>>>>>> Remove arguments in macro references in internal declaration
=======
        Param newParam = new Param(param, this, this.globalIndex);
>>>>>>> Changement Objectmacro-back
=======
        External newParam = new External(param, this, this.globalIndex);
>>>>>>> Revert "Changement Objectmacro-back"
        this.namedParams.put(stringName, newParam);
        this.allParams.add(newParam);

=======

        if(containsKeyInInternals(stringName) || containsKeyInParams(stringName)){
            throw CompilerException.duplicateDeclaration(name, getNameDeclaration());
        }

        External newParam = new External(param, this, this.globalIndex);
        this.namedParams.put(stringName, newParam);
        this.allParams.add(newParam);

>>>>>>> object-macro2.1
        return newParam;
    }

    public Param newInternal(
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
            AInternal param){

        if(param == null){
            throw new InternalException("AParam should not be null");
        }

        TIdentifier name = param.getName();
        String stringName = name.getText();

        Param duplicateDeclaration = getParamOrNull(name);
        if(duplicateDeclaration != null){
            throw CompilerException.duplicateDeclaration(name, duplicateDeclaration.getNameDeclaration());
        }

        Internal newInternal = new Internal(param, this, this.globalIndex);
        this.allInternals.add(newInternal);
        this.namedInternals.put(stringName, newInternal);

        return newInternal;
    }

    private Param getParamOrNull(
            TIdentifier var){

        Param toReturn = null;
        String name = var.getText();
        if(containsKeyInParams(name)){
            toReturn = this.namedParams.get(name);
        }

        if(containsKeyInInternals(name)){
            toReturn = this.namedInternals.get(name);
        }

        return toReturn;
    }

    public Param getParam(
            TIdentifier variable){

        Param param = getParamOrNull(variable);
        if(param == null){
            throw CompilerException.unknownParam(variable);
        }

        return param;
    }

    public void setParamUsed(
            TIdentifier variable){

        this.getParam(variable).setUsed();
    }

    public void setParamToString(
            TIdentifier variable){

        this.getParam(variable).setString();
    }

=======
    public Param newContext(
=======
>>>>>>> Rename Context by Internal
            AParam param){
=======
            AInternal param){
>>>>>>> Remove arguments in macro references in internal declaration
=======
            AParam param){
>>>>>>> Changement Objectmacro-back
=======
            AInternal param){
>>>>>>> Revert "Changement Objectmacro-back"

        if(param == null){
            throw new InternalException("AParam should not be null");
        }

        TIdentifier name = param.getName();
        String stringName = name.getText();

        Param duplicateDeclaration = getParamOrNull(name);
        if(duplicateDeclaration != null){
            throw CompilerException.duplicateDeclaration(name, duplicateDeclaration.getNameDeclaration());
        }

        Internal newInternal = new Internal(param, this, this.globalIndex);
        this.allInternals.add(newInternal);
        this.namedInternals.put(stringName, newInternal);

        return newInternal;
    }

    private Param getParamOrNull(
            TIdentifier var){

        Param toReturn = null;
        String name = var.getText();
        if(containsKeyInParams(name)){
            toReturn = this.namedParams.get(name);
        }

        if(containsKeyInInternals(name)){
            toReturn = this.namedInternals.get(name);
        }

        return toReturn;
    }

    public Param getParam(
            TIdentifier variable){

        Param param = getParamOrNull(variable);
        if(param == null){
            throw CompilerException.unknownParam(variable);
        }

        return param;
    }

    public void setParamUsed(
            TIdentifier variable){

        this.getParam(variable).setUsed();
    }

    public void setParamToString(
            TIdentifier variable){

        this.getParam(variable).setString();
    }


    public AMacro getDeclaration() {
<<<<<<< HEAD
>>>>>>> ObjectMacro2 syntaxic/lexical/semantic analysis

    public AMacro getDeclaration() {
=======
>>>>>>> Cleanup some code
=======
            AInternal param){

        if(param == null){
            throw new InternalException("AParam should not be null");
        }

        TIdentifier name = param.getName();
        String stringName = name.getText();

        Param duplicateDeclaration = getParamOrNull(name);
        if(duplicateDeclaration != null){
            throw CompilerException.duplicateDeclaration(name, duplicateDeclaration.getNameDeclaration());
        }

        Internal newInternal = new Internal(param, this, this.globalIndex);
        this.allInternals.add(newInternal);
        this.namedInternals.put(stringName, newInternal);

        return newInternal;
    }

    private Param getParamOrNull(
            TIdentifier var){

        Param toReturn = null;
        String name = var.getText();
        if(containsKeyInParams(name)){
            toReturn = this.namedParams.get(name);
        }

        if(containsKeyInInternals(name)){
            toReturn = this.namedInternals.get(name);
        }

        return toReturn;
    }

    public Param getParam(
            TIdentifier variable){

        Param param = getParamOrNull(variable);
        if(param == null){
            throw CompilerException.unknownParam(variable);
        }

        return param;
    }

    public void setParamUsed(
            TIdentifier variable){

        this.getParam(variable).setUsed();
    }

    public void setParamToString(
            TIdentifier variable){

        this.getParam(variable).setString();
    }


    public AMacro getDeclaration() {
>>>>>>> object-macro2.1
        return this.declaration;
    }

    public TIdentifier getNameDeclaration() {
        return this.declaration.getName();
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public String getName(){
        return this.declaration.getName().getText();
    }

    public Set<External> getAllParams(){
        return this.allParams;
    }

    public Set<Internal> getAllInternals(){
        return this.allInternals;
    }

    private boolean containsKeyInInternals(
            String name){

        if(name == null){
            throw new InternalException("Name should not be null");
        }

        return this.namedInternals.containsKey(name);
    }

    private boolean containsKeyInParams(
            String name){

        if(name == null){
            throw new InternalException("Name should not be null");
        }

        return this.namedParams.containsKey(name);
    }

    public List<String> getInternalsName(){
        List<String> paramsName = new LinkedList<>();
        for(Param internal : this.getAllInternals()){
            paramsName.add(internal.getName());
        }

        return paramsName;
    }

    public void detectParamsCyclicReference(){
        Progeny<Param> referencedParamProgeny = new Progeny<Param>() {

            @Override
            protected Set<Param> getChildrenNoCache(
                    Param param) {

                Set<Param> children = new LinkedHashSet<>();
                children.addAll(param.getDirectParamReferences());
                return children;
            }
        };

        Set<Param> params = new LinkedHashSet<>();
        params.addAll(this.getAllInternals());
        params.addAll(this.getAllParams());
        this.paramsComponentFinder =
                new ComponentFinder<>(params, referencedParamProgeny);

        for(Param param : params){
            Param representative = this.paramsComponentFinder.getRepresentative(param);
            if(param != representative){
                throw CompilerException.cyclicReference(param.getNameDeclaration(), representative.getNameDeclaration());
            }
        }
    }

    public ComponentFinder<Param> getComponentFinder(){
        return this.paramsComponentFinder;
=======
    GlobalIndex getGlobalIndex(){
        return this.globalIndex;
    }

=======
>>>>>>> Add internals name in intermediate representation in args
    public String getName(){
        return this.declaration.getName().getText();
    }

    public Set<External> getAllParams(){
        return this.allParams;
    }

    public Set<Internal> getAllInternals(){
        return this.allInternals;
    }

    private boolean containsKeyInInternals(
=======
    public String getName(){
        return this.declaration.getName().getText();
    }

    public Set<External> getAllParams(){
        return this.allParams;
    }

    public Set<Internal> getAllInternals(){
        return this.allInternals;
    }

    private boolean containsKeyInInternals(
            String name){

        if(name == null){
            throw new InternalException("Name should not be null");
        }

        return this.namedInternals.containsKey(name);
    }

    private boolean containsKeyInParams(
>>>>>>> object-macro2.1
            String name){

        if(name == null){
            throw new InternalException("Name should not be null");
        }

<<<<<<< HEAD
        return this.namedInternals.containsKey(name);
    }

    private boolean containsKeyInParams(
            String name){

        if(name == null){
            throw new InternalException("Name should not be null");
        }

        return this.namedParams.containsKey(name);
    }

<<<<<<< HEAD
    public boolean isUsing(
            Macro macro){

        return isReferencedInParams(macro) || isReferencedInInserts(macro) || isReferencedInInternals(macro);
    }

    private boolean isReferencedInParams(
            Macro macro){

        for(Param parameter : getAllParams()){
            if(parameter.getMacroReferenceOrNull(macro.getName()) != null){
                return true;
            }
        }

        return false;
    }

    private boolean isReferencedInInternals(
            Macro macro){

        for(Param parameter : getAllInternals()){
            if(parameter.getMacroReferenceOrNull(macro.getName()) != null){
                return true;
            }
        }

        return false;
    }

    private boolean isReferencedInInserts(
            Macro macro){

        for(Insert insert : getInserts()){
            if(insert.getReferencedMacro() == macro){
                return true;
            }
        }

        return false;
>>>>>>> ObjectMacro2 syntaxic/lexical/semantic analysis
    }

=======
>>>>>>> Clean up some unused code
    public List<String> getInternalsName(){
        List<String> paramsName = new LinkedList<>();
        for(Param internal : this.getAllInternals()){
            paramsName.add(internal.getName());
        }

        return paramsName;
    }

=======
        return this.namedParams.containsKey(name);
    }

    public List<String> getInternalsName(){
        List<String> paramsName = new LinkedList<>();
        for(Param internal : this.getAllInternals()){
            paramsName.add(internal.getName());
        }

        return paramsName;
    }

>>>>>>> object-macro2.1
    public void detectParamsCyclicReference(){
        Progeny<Param> referencedParamProgeny = new Progeny<Param>() {

            @Override
            protected Set<Param> getChildrenNoCache(
                    Param param) {

                Set<Param> children = new LinkedHashSet<>();
                children.addAll(param.getDirectParamReferences());
                return children;
            }
        };

        Set<Param> params = new LinkedHashSet<>();
        params.addAll(this.getAllInternals());
        params.addAll(this.getAllParams());
        this.paramsComponentFinder =
                new ComponentFinder<>(params, referencedParamProgeny);

        for(Param param : params){
            Param representative = this.paramsComponentFinder.getRepresentative(param);
            if(param != representative){
                throw CompilerException.cyclicReference(param.getNameDeclaration(), representative.getNameDeclaration());
            }
        }
    }

    public ComponentFinder<Param> getComponentFinder(){
        return this.paramsComponentFinder;
    }
}
