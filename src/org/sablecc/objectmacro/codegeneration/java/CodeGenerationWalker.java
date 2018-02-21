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

package org.sablecc.objectmacro.codegeneration.java;

import java.io.*;
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.*;
=======
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
import java.util.*;
>>>>>>> Moved utils files for generation to another walker

import org.sablecc.exception.*;
import org.sablecc.objectmacro.codegeneration.*;
import org.sablecc.objectmacro.codegeneration.java.macro.*;
import org.sablecc.objectmacro.codegeneration.java.structure.Macro;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import org.sablecc.objectmacro.exception.*;
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
=======
>>>>>>> Moved utils files for generation to another walker
import org.sablecc.objectmacro.intermediate.syntax3.analysis.*;
import org.sablecc.objectmacro.intermediate.syntax3.node.*;

public class CodeGenerationWalker
        extends DepthFirstAdapter {
<<<<<<< HEAD
<<<<<<< HEAD
=======

<<<<<<< HEAD
    private static final String CONTEXT_STRING = "Context";

    private static final String INSERT_VAR_NAME = "insert_";

    private static final String SEPARATOR_DIRECTIVE = "separator";

    private static final String AFTER_LAST_DIRECTIVE = "afterlast";

    private static final String NONE_DIRECTIVE = "none";

    private static final String BEFORE_FIRST_DIRECTIVE = "beforefirst";
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1

=======
>>>>>>> Moved utils files for generation to another walker
    private final IntermediateRepresentation ir;

    private final File packageDirectory;

<<<<<<< HEAD
<<<<<<< HEAD
    /**
     * List of macros in the file
     */
    private final Map<String, Macro> macros;

    /**
     * Object Macro with name and list of internals and parameters
     */
    private Macro currentMacro;

    /**
     * Current parameter name
     */
    private String currentParamName;

    /**
     * Macro representing the super class Macro
     */
    private MSuperMacro superMacro;

    /**
     * Macro representing an internal initializer super class
     */
    private MInternalsInitializer mInternalsInitializer;

    /**
     * Macro representing the class macro
     */
    private MMacro currentMacroToBuild;

    /**
     * Macro representing the constructor of a macro
     */
    private MConstructor currentConstructor;

    /**
     * Macro representing the method builder
     */
    private MMacroBuilder currentMacroBuilder;

    /**
     * Macro representing the apply internal initializer inside the method init internals
     */
    private MApplyInternalsInitializer currentApplyInitializer;

    /**
     * Macro representing the apply internal initializer inside the method addAll
     */
    private MApplyInternalsInitializer currentAddAllApplyInitializer;

    /**
     * Macro representing the redefined internals setter inside in apply initializer
     */
    private MRedefinedInternalsSetter currentRedefinedInternalsSetter;

    /**
     * Index of the current builder to avoid creating 2 StringBuilder of the same name
     */
    private Integer indexBuilder = 0;

    /**
     * Index of the current builder to avoid creating 2 macro objects for inserts of the same name
     */
    private Integer indexInsert = 0;

    /**
     * Created StringBuilders in the children of a AParameter node or AInternal node
     * This list is reset in the internal or parameter node's out
     */
    private List<String> createdBuilders = new ArrayList<>();

    /**
     * Created macro objects for inserts in the children of a AParameter node or AInternal node
     * This list is reset in the internal or parameter node's out
     */
    private List<Integer> createdInserts = new ArrayList<>();

    /**
     * Name of the current macro which is referenced
     */
    private String currentMacroRefName;

    /**
     * Name of the current context
     */
    private String currentContextName;

    /**
     * Names of all contexts created for the current Macro
     */
    private List<String> contextNames = new ArrayList<>();

    /**
     * Macro representing an insert in a macro body
     */
    private MInsertMacroPart currentInsertMacroPart;

    /**
     * Macro representing a parameter's builder
     */
    private MParamMacroRefBuilder currentParamMacroRefBuilder;

    /**
     * Macro representing the method to initialize directives
     */
    private MInitDirectives currentInitDirectives;

    /**
     * Macro representing the creation of an object Directive
     */
    private MNewDirective currentDirective;

    /**
     * Macro representing the creation of an object of the directive None
     */
    private MSetNoneDirective mSetNoneDirective;

    /**
     * Boolean to test whether the macro has or does not have internals
     */
    private boolean currentMacroHasInternals;
=======
    private MMacro currentMacro;
=======
    private MMacro currentMacroToBuild;

    private Macro currentMacro;
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name

    private MConstructor currentConstructor;

    private MSuperMacro superMacro;

    private MInternalsInitializer mInternalsInitializer;

    private MMacroBuilder currentMacroBuilder;

    private MApplyInternalsInitializer currentApplyInitializer;

    private MApplyInternalsInitializer currentAddAllApplyInitializer;

    private MRedefinedInternalsSetter currentRedefinedInternalsSetter;

    private Integer indexBuilder = 0;

    private Integer indexInsert = 0;

    private String currentMacroRefName;

    private final Map<String, Macro> macros;

    private String currentContextName;

    private MInsertMacroPart currentInsertMacroPart;

    private List<String> contextNames = new ArrayList<>();

    private List<String> createdBuilders = new ArrayList<>();

    private List<Integer> createdInserts = new ArrayList<>();

    private MParamMacroRefBuilder currentParamMacroRefBuilder;

    private MInitDirectives currentInitDirectives;

    private MNewDirective currentDirective;

<<<<<<< HEAD
<<<<<<< HEAD
    private MParamMacroRef currentParamMacroRef;
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
    private MParamMacroRefBuilder currentParamMacroRefBuilder;
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
=======
    private MSetNoneDirective mSetNoneDirective;
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives

    //Used only to check whether its a parameter or an internal, for parameter its set but for internal its null
    private String currentParamName;

    private boolean currentMacroHasInternals;

    public CodeGenerationWalker(
            IntermediateRepresentation ir,
            File packageDirectory,
<<<<<<< HEAD
<<<<<<< HEAD
            Map<String, Macro> macros) {
=======
            Map<String, MMacro> macros) {
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
            Map<String, Macro> macros) {
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name

        this.ir = ir;
        this.packageDirectory = packageDirectory;
        this.macros = macros;
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
    private String string(
            TString tString) {

        String string = tString.getText();
        int length = string.length();
        return string.substring(1, length - 1);
    }

    private String escapedString(
            TString tString) {

        StringBuilder sb = new StringBuilder();
        String s = string(tString);
        boolean escaped = false;
        for (char c : s.toCharArray()) {
            if (escaped) {
                escaped = false;

                if (c == '\\') {
                    sb.append('\\');
                    sb.append('\\');
                }
                else if (c == '\'') {
                    sb.append('\'');
                }
                else {
                    throw new InternalException("unhandled case");
                }
            }
            else if (c == '\\') {
                escaped = true;
            }
            else if (c == '\"') {
                sb.append('\\');
                sb.append('\"');
            }
            else {
                sb.append(c);
            }
        }

        if (escaped) {
            throw new InternalException("incomplete escape");
        }

        return sb.toString();
    }

    private String buildNameCamelCase(
            LinkedList<TString> name_parts){

        StringBuilder macroName = new StringBuilder();
        for(TString partName : name_parts){
            macroName.append(Utils.toCamelCase(string(partName)));
        }
=======
>>>>>>> Moved utils files for generation to another walker


    private String getLetterFromInteger(
            Integer i){

        return i > 0 && i < 27 ? String.valueOf((char) (i + 64)) : null;
    }

>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
    @Override
    public void inAIntermediateRepresentation(
            AIntermediateRepresentation node) {

        this.superMacro = new MSuperMacro();
        this.mInternalsInitializer = new MInternalsInitializer();
<<<<<<< HEAD
<<<<<<< HEAD
=======
        this.mContext = new MContext();
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
>>>>>>> Moved utils files for generation to another walker

        if(!this.ir.getDestinationPackage().equals("")){
            String destinationPackage = this.ir.getDestinationPackage();
            this.superMacro.newPackageDeclaration(destinationPackage);
            this.mInternalsInitializer.newPackageDeclaration(destinationPackage);
<<<<<<< HEAD
<<<<<<< HEAD
=======
            this.mContext.newPackageDeclaration(destinationPackage);
<<<<<<< HEAD

>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
>>>>>>> Clean up code, add comments
=======
>>>>>>> Moved utils files for generation to another walker
        }

        this.superMacro.newImportJavaUtil();
        this.mInternalsInitializer.newImportJavaUtil();

    }

    @Override
    public void outAIntermediateRepresentation(
            AIntermediateRepresentation node) {

<<<<<<< HEAD
<<<<<<< HEAD
        GenerationUtils.writeFile(this.packageDirectory, "Macro.java", this.superMacro.toString());
        GenerationUtils
                .writeFile(this.packageDirectory,"InternalsInitializer.java", this.mInternalsInitializer.toString());
=======
        writeFile("Macro.java", this.superMacro.toString());
        writeFile("Context.java", this.mContext.toString());
        writeFile("InternalsInitializer.java", this.mInternalsInitializer.toString());

        MParameterNull mParameterNull = new MParameterNull();
        MIncorrectType mIncorrectType = new MIncorrectType();
        MObjectMacroErrorHead mObjectMacroErrorHead = new MObjectMacroErrorHead();
        MMacroNullInList mMacroNullInList = new MMacroNullInList();
        MCyclicReference mCyclicReference = new MCyclicReference();
        MCannotModify mCannotModify = new MCannotModify();
        MObjectMacroException mObjectMacroException = new MObjectMacroException();

        if(!this.ir.getDestinationPackage().equals("")){
            String destinationPackage = this.ir.getDestinationPackage();
            mIncorrectType.newPackageDeclaration(destinationPackage);
            mParameterNull.newPackageDeclaration(destinationPackage);
            mObjectMacroErrorHead.newPackageDeclaration(destinationPackage);
            mMacroNullInList.newPackageDeclaration(destinationPackage);
            mCyclicReference.newPackageDeclaration(destinationPackage);
            mCannotModify.newPackageDeclaration(destinationPackage);
            mObjectMacroException.newPackageDeclaration(destinationPackage);

        }

        writeFile("MIncorrectType.java", mIncorrectType.toString());
        writeFile("MParameterNull.java", mParameterNull.toString());
        writeFile("MObjectMacroErrorHead.java", mObjectMacroErrorHead.toString());
        writeFile("MMacroNullInList.java", mMacroNullInList.toString());
        writeFile("MCyclicReference.java", mCyclicReference.toString());
        writeFile("MCannotModify.java", mCannotModify.toString());
        writeFile("ObjectMacroException.java", mObjectMacroException.toString());
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
        GenerationUtils.writeFile(this.packageDirectory, "Macro.java", this.superMacro.toString());
        GenerationUtils
                .writeFile(this.packageDirectory,"InternalsInitializer.java", this.mInternalsInitializer.toString());
>>>>>>> Moved utils files for generation to another walker
    }

    @Override
    public void inAMacro(
            AMacro node) {

<<<<<<< HEAD
<<<<<<< HEAD
        String macroName = GenerationUtils.buildNameCamelCase(node.getNames());
        if(!this.macros.containsKey(macroName)){
            throw new InternalException(macroName + " does not exist");
        }

        this.currentMacro = this.macros.get(macroName);
        this.currentMacroToBuild = this.currentMacro.getMacro();
        this.contextNames = new ArrayList<>();

        if(this.currentMacroToBuild == null){
            throw new InternalException("currentMacroToBuild cannot be null here");
        }

        if (!this.ir.getDestinationPackage().equals("")) {
            this.currentMacroToBuild.newPackageDeclaration(this.ir.getDestinationPackage());
        }

        this.currentConstructor = this.currentMacroToBuild.newConstructor(macroName);
        this.currentMacroBuilder = this.currentMacroToBuild.newMacroBuilder(macroName);
<<<<<<< HEAD

        this.mInternalsInitializer.newParentInternalsSetter(macroName);
        this.currentMacroToBuild.newRedefinedApplyInitializer(macroName);

        this.currentMacroToBuild.newImportJavaUtil();
        this.currentMacroHasInternals = node.getInternals().size() > 0;

        if(this.currentMacroHasInternals){
            //method build is package protected so a context parameter to build the current macro
            this.currentMacroBuilder.newContextParam();
            this.currentMacroBuilder.newContextBuildState();
            this.currentMacroBuilder.newNewBuildState();
        }
        else{
            this.currentMacroBuilder.newPublic();
            this.currentMacroToBuild.newEmptyBuilderWithContext();
=======
        String macroName = buildNameCamelCase(node.getNames());
=======
        String macroName = GenerationUtils.buildNameCamelCase(node.getNames());
>>>>>>> Moved utils files for generation to another walker
        if(!this.macros.containsKey(macroName)){
            throw new InternalException(macroName + " does not exist");
        }

        this.currentMacro = this.macros.get(macroName);
        this.currentMacroToBuild = this.currentMacro.getMacro();
        this.contextNames = new ArrayList<>();

        if(this.currentMacroToBuild == null){
            throw new InternalException("currentMacroToBuild cannot be null here");
        }

        if (!this.ir.getDestinationPackage().equals("")) {
            this.currentMacroToBuild.newPackageDeclaration(this.ir.getDestinationPackage());
        }

        this.currentConstructor = this.currentMacroToBuild.newConstructor(macroName);
        this.currentMacroBuilder = this.currentMacroToBuild.newMacroBuilder();
=======
>>>>>>> Add BuildState class in order to do a cheap cycle verification on build method

        this.mInternalsInitializer.newParentInternalsSetter(macroName);
        this.currentMacroToBuild.newRedefinedApplyInitializer(macroName);

        this.currentMacroToBuild.newImportJavaUtil();
        this.currentMacroHasInternals = node.getInternals().size() > 0;

        if(this.currentMacroHasInternals){
            //method build is package protected so a context parameter to build the current macro
            this.currentMacroBuilder.newContextParam();
            this.currentMacroBuilder.newContextBuildState();
            this.currentMacroBuilder.newNewBuildState();
        }
        else{
            this.currentMacroBuilder.newPublic();
<<<<<<< HEAD
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
            this.currentMacroToBuild.newEmptyBuilderWithContext();
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> Now macro without internals has a builder with context that only return build
=======
            this.currentMacroBuilder.newBuildVerification(macroName);
>>>>>>> Init internals before building the macro instead at the add or addAll methods
=======
>>>>>>> Add BuildState class in order to do a cheap cycle verification on build method
        }
    }

    @Override
    public void caseAInternal(
            AInternal node) {

<<<<<<< HEAD
<<<<<<< HEAD
        String paramName = GenerationUtils.buildNameCamelCase(node.getNames());

        if(node.getType() instanceof AStringType){
            this.currentMacroToBuild.newInternalStringField(paramName);
            this.currentMacroToBuild.newInternalStringSetter(paramName);

            MParamStringRefBuilder mParamStringRefBuilder = this.currentMacroToBuild
                    .newParamStringRefBuilder(paramName);
            mParamStringRefBuilder.newContextParam();
            mParamStringRefBuilder.newGetInternalTail();

            MParamStringRef mParamStringRef = this.currentMacroToBuild.newParamStringRef(paramName);
            mParamStringRef.newContextParam();
            mParamStringRef.newGetInternalTail();
        }
        else if(node.getType() instanceof AMacroRefsType){
            this.currentMacroToBuild.newInternalMacroField(paramName);
<<<<<<< HEAD

            this.currentMacroToBuild.newInternalMacroRefBuilder(paramName);
            this.currentMacroToBuild.newInternalMacroRef(paramName);

            this.indexBuilder = 0;
            this.currentMacroToBuild.newInternalMacroSetter(paramName);
=======
        String paramName = buildNameCamelCase(node.getNames());
=======
        String paramName = GenerationUtils.buildNameCamelCase(node.getNames());
>>>>>>> Moved utils files for generation to another walker

        if(node.getType() instanceof AStringType){
            this.currentMacroToBuild.newInternalStringField(paramName);
            this.currentMacroToBuild.newInternalStringSetter(paramName);

            MParamStringRefBuilder mParamStringRefBuilder = this.currentMacroToBuild
                    .newParamStringRefBuilder(paramName);
            mParamStringRefBuilder.newContextParam();
            mParamStringRefBuilder.newGetInternalTail();

            MParamStringRef mParamStringRef = this.currentMacroToBuild.newParamStringRef(paramName);
            mParamStringRef.newContextParam();
            mParamStringRef.newGetInternalTail();
        }
        else if(node.getType() instanceof AMacroRefsType){
            this.currentMacroToBuild.newInternalMacroField(paramName);
            this.currentMacroToBuild.newContextField(paramName);
=======
>>>>>>> Add structure which contains list of macros and the context associated

            this.currentMacroToBuild.newInternalMacroRefBuilder(paramName);
            this.currentMacroToBuild.newInternalMacroRef(paramName);

            this.indexBuilder = 0;
<<<<<<< HEAD

            this.currentContextName = paramName.concat(GenerationUtils.CONTEXT_STRING);
            this.contextNames.add(currentContextName);
            this.currentApplyInitializer =
                    this.currentMacroToBuild.newInternalMacroSetter(paramName)
                            .newApplyInternalsInitializer(paramName);
<<<<<<< HEAD

>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
>>>>>>> Removed in constructor initialization and add lazy initialization
=======
            this.currentMacroToBuild.newInternalMacroSetter(paramName);
>>>>>>> Add structure which contains list of macros and the context associated
        }
        else{
            throw new InternalException("case unhandled");
        }
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
        node.getType().apply(this);
        outAInternal(node);
    }

    @Override
    public void outAInternal(
            AInternal node) {

<<<<<<< HEAD
<<<<<<< HEAD
        this.currentContextName = null;
        this.currentApplyInitializer = null;
        this.indexBuilder = 0;
        this.indexInsert = 0;
        this.currentParamMacroRefBuilder = null;
        this.createdBuilders = new ArrayList<>();
        this.createdInserts = new ArrayList<>();
=======
        this.currentContext = null;
=======
        this.currentContextName = null;
>>>>>>> Moved utils files for generation to another walker
        this.currentApplyInitializer = null;
        this.indexBuilder = 0;
        this.indexInsert = 0;
        this.currentParamMacroRefBuilder = null;
<<<<<<< HEAD
        this.createdBuilders.clear();
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
        this.createdBuilders = new ArrayList<>();
<<<<<<< HEAD
>>>>>>> fix creating same string builder in macro body
=======
        this.createdInserts = new ArrayList<>();
>>>>>>> Fix index inserts when creating 2 inserts in 2 different stringValue of a same macro reference
    }

    @Override
    public void caseAParam(
            AParam node) {

<<<<<<< HEAD
<<<<<<< HEAD
        String paramName = this.currentParamName = GenerationUtils.buildNameCamelCase(node.getNames());

        if(node.getType() instanceof AStringType){
            this.currentMacroToBuild.newParamStringField(paramName);
            this.currentMacroToBuild.newParamStringRefBuilder(paramName);
            this.currentMacroToBuild.newParamStringRef(paramName);

            MParamStringSetter mParamStringSetter = this.currentMacroToBuild.newParamStringSetter(paramName);
            mParamStringSetter.newParamArg(paramName);
            mParamStringSetter.newStringParam(paramName);

            this.currentConstructor.newStringParam(paramName);
            this.currentConstructor.newSetParam(paramName).newParamArg(paramName);
        }
        else if(node.getType() instanceof AMacroRefsType){

            this.currentMacroToBuild.newParamMacroField(paramName);
            this.currentMacroToBuild.newContextField(paramName);
            this.currentMacroToBuild.newDirectivesField(paramName);
            this.currentMacroToBuild.newInternalMacrosValueField(paramName);

            this.currentParamMacroRefBuilder = this.currentMacroToBuild.newParamMacroRefBuilder(
                    paramName, String.valueOf(this.indexBuilder));
            this.currentParamMacroRefBuilder.newContextName(paramName.concat(
                    GenerationUtils.CONTEXT_STRING));
            this.currentMacroToBuild.newParamMacroRef(paramName);

            this.currentInitDirectives = this.currentMacroToBuild.newInitDirectives(paramName);
=======
        String paramName = buildNameCamelCase(node.getNames());
=======
        String paramName = this.currentParamName = GenerationUtils.buildNameCamelCase(node.getNames());
>>>>>>> Add structure which contains list of macros and the context associated

        if(node.getType() instanceof AStringType){
            this.currentMacroToBuild.newParamStringField(paramName);
            this.currentMacroToBuild.newParamStringRefBuilder(paramName);
            this.currentMacroToBuild.newParamStringRef(paramName);

            MParamStringSetter mParamStringSetter = this.currentMacroToBuild.newParamStringSetter(paramName);
            mParamStringSetter.newParamArg(paramName);
            mParamStringSetter.newStringParam(paramName);

            this.currentConstructor.newStringParam(paramName);
            this.currentConstructor.newSetParam(paramName).newParamArg(paramName);
        }
        else if(node.getType() instanceof AMacroRefsType){

            this.currentMacroToBuild.newParamMacroField(paramName);
            this.currentMacroToBuild.newContextField(paramName);
            this.currentMacroToBuild.newDirectivesField(paramName);
            this.currentMacroToBuild.newInternalMacrosValueField(paramName);

            this.currentParamMacroRefBuilder = this.currentMacroToBuild.newParamMacroRefBuilder(
                    paramName, String.valueOf(this.indexBuilder));
<<<<<<< HEAD
<<<<<<< HEAD
            this.currentParamMacroRef.newContextName(paramName.concat(CONTEXT_STRING));
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
            this.currentParamMacroRefBuilder.newContextName(paramName.concat(CONTEXT_STRING));
=======
            this.currentParamMacroRefBuilder.newContextName(paramName.concat(
                    GenerationUtils.CONTEXT_STRING));
>>>>>>> Add structure which contains list of macros and the context associated
            this.currentMacroToBuild.newParamMacroRef(paramName);
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name

            this.currentInitDirectives = this.currentMacroToBuild.newInitDirectives(paramName);

            for (PDirective directive : node.getDirectives()) {
                directive.apply(this);
            }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
            this.currentContextName = paramName.concat(GenerationUtils.CONTEXT_STRING);
            this.indexBuilder = 0;

            MInitInternalsCall mInitInternalsCall = this.currentMacroBuilder.newInitInternalsCall(paramName);
            MAddAll mAddAll = this.currentMacroToBuild.newAddAll(paramName);

            this.currentAddAllApplyInitializer = mAddAll.newApplyInternalsInitializer(paramName);
            this.currentApplyInitializer = this.currentMacroToBuild.newInitInternalsMethod(paramName)
                                                .newApplyInternalsInitializer(paramName);

            this.contextNames.add(this.currentContextName);
<<<<<<< HEAD
            this.currentConstructor.newInitMacroParam(paramName);
            this.currentConstructor.newInitInternalValue(paramName);
            this.currentMacroBuilder.newInitDirectivesCall(paramName);

            if(this.currentMacroHasInternals){
                mInitInternalsCall.newContextArg();
            }
            else{
                mAddAll.newIsBuilt(this.currentMacro.getName());
            }
=======
            this.currentContext = paramName.concat(CONTEXT_STRING);
=======
            this.currentContextName = this.currentParamName.concat(
                    GenerationUtils.CONTEXT_STRING);
>>>>>>> Moved utils files for generation to another walker
=======
            this.currentContextName = paramName.concat(GenerationUtils.CONTEXT_STRING);
>>>>>>> Add structure which contains list of macros and the context associated
            this.indexBuilder = 0;

            MAddAll mAddAll = this.currentMacroToBuild.newAddAll(paramName);

            this.currentAddAllApplyInitializer = mAddAll.newApplyInternalsInitializer(paramName);
            this.currentApplyInitializer = this.currentMacroToBuild.newInitInternalsMethod(paramName)
<<<<<<< HEAD
                            .newApplyInternalsInitializer(paramName);
            this.contextNames.add(currentContext);
<<<<<<< HEAD
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
            this.currentConstructor.newInitMacroParam(paramName);
>>>>>>> Init internals before building the macro instead at the add or addAll methods
=======
                                                .newApplyInternalsInitializer(paramName);

            this.contextNames.add(currentContextName);
            this.currentConstructor.newInitMacroParam(paramName);
            this.currentConstructor.newInitInternalValue(paramName);
<<<<<<< HEAD
>>>>>>> Add structure which contains list of macros and the context associated
=======
=======
            this.currentConstructor.newInitMacroParam(paramName);
            this.currentConstructor.newInitInternalValue(paramName);
            this.currentMacroBuilder.newInitDirectivesCall(paramName);
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives

            if(this.currentMacroHasInternals){
                mInitInternalsCall.newContextArg();
            }
            else{
                mAddAll.newIsBuilt(this.currentMacro.getName());
            }
>>>>>>> Add BuildState class in order to do a cheap cycle verification on build method
        }
        else{
            throw new InternalException("case unhandled");
        }

<<<<<<< HEAD
<<<<<<< HEAD
=======
        this.currentParameters.add(paramName);
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
        node.getType().apply(this);
        outAParam(node);
    }

    @Override
<<<<<<< HEAD
<<<<<<< HEAD
    public void outAParam(
            AParam node) {

        this.currentParamName = null;
        this.currentContextName = null;
        this.currentApplyInitializer = null;
        this.currentRedefinedInternalsSetter = null;
        this.indexBuilder = 0;
        this.indexInsert = 0;
        this.createdBuilders = new ArrayList<>();
        this.createdInserts = new ArrayList<>();
        this.currentParamMacroRefBuilder = null;
        this.currentInitDirectives = null;
<<<<<<< HEAD
=======
    public void outAParam(AParam node) {
=======
    public void outAParam(
            AParam node) {
>>>>>>> Add structure which contains list of macros and the context associated

        this.currentParamName = null;
        this.currentContextName = null;
        this.currentApplyInitializer = null;
        this.currentRedefinedInternalsSetter = null;
        this.indexBuilder = 0;
        this.indexInsert = 0;
<<<<<<< HEAD
        this.createdBuilders.clear();
<<<<<<< HEAD
        this.currentParamMacroRef = null;
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
=======
        this.createdBuilders = new ArrayList<>();
<<<<<<< HEAD
>>>>>>> fix creating same string builder in macro body
=======
        this.createdInserts = new ArrayList<>();
>>>>>>> Fix index inserts when creating 2 inserts in 2 different stringValue of a same macro reference
        this.currentParamMacroRefBuilder = null;
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
=======
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
    }

    @Override
    public void inADirective(
            ADirective node) {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        String directive_name = GenerationUtils.buildNameCamelCase(node.getNames());

        if(directive_name.equals(GenerationUtils.NONE_DIRECTIVE)){
            this.currentMacroToBuild.newNoneDirectiveField(this.currentParamName);
            this.currentParamMacroRefBuilder.newApplyNoneDirective();
            this.mSetNoneDirective = this.currentInitDirectives
                    .newSetNoneDirective(this.currentParamName, this.indexBuilder.toString());
        }
        else{
            this.currentDirective = this.currentInitDirectives
                    .newNewDirective(this.currentParamName, directive_name, this.indexBuilder.toString());
=======
        String directive_name = buildName(node.getNames());
        switch (directive_name) {

<<<<<<< HEAD
        if(directive_name.equals(SEPARATOR_DIRECTIVE)){
            this.currentSeparator = this.currentParamMacroRef.newSeparator();
        }
        else if(directive_name.equals(AFTER_LAST_DIRECTIVE)){
            this.currentAfterLast = this.currentParamMacroRef.newAfterLast();
        }
        else if(directive_name.equals(BEFORE_FIRST_DIRECTIVE)){
            this.currentBeforeFirst = this.currentParamMacroRef.newBeforeFirst();
        }
        else if(directive_name.equals(NONE_DIRECTIVE)){
            this.currentNone = this.currentParamMacroRef.newNone();
        }
        else{
            throw new InternalException("case unhandled");
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
            case SEPARATOR_DIRECTIVE:
=======
        String directive_name = GenerationUtils.buildName(node.getNames());
        switch (directive_name) {

            case GenerationUtils.SEPARATOR_DIRECTIVE:
>>>>>>> Moved utils files for generation to another walker
                this.currentSeparator = this.currentParamMacroRefBuilder.newSeparator();
                break;

            case GenerationUtils.AFTER_LAST_DIRECTIVE:
                this.currentAfterLast = this.currentParamMacroRefBuilder.newAfterLast();
                break;

            case GenerationUtils.BEFORE_FIRST_DIRECTIVE:
                this.currentBeforeFirst = this.currentParamMacroRefBuilder
                        .newBeforeFirst();
                break;

            case GenerationUtils.NONE_DIRECTIVE:
                this.currentNone = this.currentParamMacroRefBuilder.newNone();
                break;

            default:
                throw new InternalException("case unhandled");
>>>>>>> Clean up code, add comments
=======
        String directive_name = GenerationUtils.buildNameCamelCase(node.getNames());

        if(directive_name.equals(GenerationUtils.NONE_DIRECTIVE)){
            this.currentMacroToBuild.newNoneDirectiveField(this.currentParamName);
            this.currentParamMacroRefBuilder.newApplyNoneDirective();
            this.mSetNoneDirective = this.currentInitDirectives
                    .newSetNoneDirective(this.currentParamName, this.indexBuilder.toString());
        }
        else{
            this.currentDirective = this.currentInitDirectives
                    .newNewDirective(this.currentParamName, directive_name, this.indexBuilder.toString());
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
        }
    }

    @Override
    public void outADirective(
            ADirective node) {

<<<<<<< HEAD
<<<<<<< HEAD
        this.indexBuilder++;
        this.currentDirective = null;
        this.mSetNoneDirective = null;
=======
        this.currentSeparator = null;
        this.currentAfterLast = null;
        this.currentBeforeFirst = null;
        this.currentNone = null;
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
        this.indexBuilder++;
        this.currentDirective = null;
        this.mSetNoneDirective = null;
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
    }

    @Override
    public void inAMacroRef(
            AMacroRef node) {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        String macro_ref_name = this.currentMacroRefName = GenerationUtils.buildNameCamelCase(node.getNames());

        if(this.currentContextName != null){
            this.currentRedefinedInternalsSetter =
                    this.currentApplyInitializer.newRedefinedInternalsSetter(macro_ref_name);

            MSingleAdd mSingleAdd = this.currentMacroToBuild.newSingleAdd(macro_ref_name, this.currentParamName);
            if(!this.currentMacroHasInternals){
                mSingleAdd.newIsBuilt(this.currentMacro.getName());
            }

            this.currentAddAllApplyInitializer.newRedefinedInternalsSetter(macro_ref_name);
        }
=======
        this.currentMacroName = buildNameCamelCase(node.getNames());

        if(this.currentContext != null){
            this.currentRedefinedInternalsSetter = this.currentApplyInitializer.newRedefinedInternalsSetter(
                    currentMacroName);
<<<<<<< HEAD

>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
=======
        this.currentMacroRefName = buildNameCamelCase(node.getNames());
=======
        this.currentMacroRefName = GenerationUtils.buildNameCamelCase(node.getNames());
>>>>>>> Moved utils files for generation to another walker
=======
        String macro_ref_name = this.currentMacroRefName = GenerationUtils.buildNameCamelCase(node.getNames());
>>>>>>> Add structure which contains list of macros and the context associated

        if(this.currentContextName != null){
            this.currentRedefinedInternalsSetter =
                    this.currentApplyInitializer.newRedefinedInternalsSetter(macro_ref_name);

<<<<<<< HEAD
<<<<<<< HEAD
        if(this.currentEmptyApplyInitializer != null){
            this.currentEmptyRedefinedInternalsSetter =
                    this.currentEmptyApplyInitializer.newRedefinedInternalsSetter(
                            currentMacroRefName);
>>>>>>> Init internals before building the macro instead at the add or addAll methods
=======
            this.currentMacroToBuild.newSingleAdd(macro_ref_name, this.currentParamName);
=======
            MSingleAdd mSingleAdd = this.currentMacroToBuild.newSingleAdd(macro_ref_name, this.currentParamName);
            if(!this.currentMacroHasInternals){
                mSingleAdd.newIsBuilt(this.currentMacro.getName());
            }

>>>>>>> Add BuildState class in order to do a cheap cycle verification on build method
            this.currentAddAllApplyInitializer.newRedefinedInternalsSetter(macro_ref_name);
>>>>>>> Add structure which contains list of macros and the context associated
        }
>>>>>>> Clean up code, add comments
    }

    @Override
    public void outAMacroRef(
            AMacroRef node) {

<<<<<<< HEAD
<<<<<<< HEAD
        this.currentMacroRefName = null;
    }

    @Override
    public void caseAStringValue(
=======
        this.currentMacroName = null;
=======
        this.currentMacroRefName = null;
>>>>>>> Init internals before building the macro instead at the add or addAll methods
    }

    @Override
<<<<<<< HEAD
    public void inAStringValue(
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
    public void caseAStringValue(
>>>>>>> indexInsert could be modified in the children nodes of stringValue
            AStringValue node) {

        this.indexBuilder++;
        String index_builder = String.valueOf(this.indexBuilder);
<<<<<<< HEAD
<<<<<<< HEAD
        boolean anyContext = this.currentContextName != null;
=======
        boolean anyContext = this.currentContext != null;
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
        boolean anyContext = this.currentContextName != null;
>>>>>>> Moved utils files for generation to another walker

        if(anyContext){
            this.currentRedefinedInternalsSetter.newInitStringBuilder(index_builder);

            this.currentRedefinedInternalsSetter.newSetInternal(
<<<<<<< HEAD
<<<<<<< HEAD
                    this.currentMacroRefName,
                    GenerationUtils.buildNameCamelCase(node.getParamName()),
                    this.currentContextName).newStringBuilderBuild(index_builder);

            for(PTextPart part : node.getParts()){
                part.apply(this);
            }
        }
        else{
            index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);
<<<<<<< HEAD

            //Avoid declaring stringbuilder of the same name
            while(this.createdBuilders.contains(index_builder)){
                this.indexBuilder++;
                index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);
            }

            this.currentInsertMacroPart.newInitStringBuilder(index_builder);
            this.createdBuilders.add(index_builder);

            //To avoid modification on indexes
            Integer tempIndexBuilder = this.indexBuilder;
            Integer tempIndexInsert = this.indexInsert;

            for(PTextPart part : node.getParts()){
                part.apply(this);
            }

            this.indexBuilder = tempIndexBuilder;
            this.indexInsert = tempIndexInsert;

            this.currentInsertMacroPart.newSetInternal(
                    GenerationUtils.INSERT_VAR_NAME.concat(String.valueOf(this.indexInsert)),
                    GenerationUtils.buildNameCamelCase(node.getParamName()),
                    "null").newStringBuilderBuild(index_builder);
=======
                    this.currentMacroName,
=======
                    this.currentMacroRefName,
<<<<<<< HEAD
>>>>>>> Init internals before building the macro instead at the add or addAll methods
                    buildNameCamelCase(node.getParamName()),
                    this.currentContext).newStringBuilderBuild(index_builder);
=======
                    GenerationUtils.buildNameCamelCase(node.getParamName()),
                    this.currentContextName).newStringBuilderBuild(index_builder);
>>>>>>> Moved utils files for generation to another walker

            for(PTextPart part : node.getParts()){
                part.apply(this);
            }
        }
        else{
            index_builder = getLetterFromInteger(this.indexBuilder);
=======
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives

            //Avoid declaring stringbuilder of the same name
            while(this.createdBuilders.contains(index_builder)){
                this.indexBuilder++;
                index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);
            }

            this.currentInsertMacroPart.newInitStringBuilder(index_builder);
            this.createdBuilders.add(index_builder);

            //To avoid modification on indexes
            Integer tempIndexBuilder = this.indexBuilder;
            Integer tempIndexInsert = this.indexInsert;

            for(PTextPart part : node.getParts()){
                part.apply(this);
            }

            this.indexBuilder = tempIndexBuilder;
            this.indexInsert = tempIndexInsert;

            this.currentInsertMacroPart.newSetInternal(
                    GenerationUtils.INSERT_VAR_NAME.concat(String.valueOf(this.indexInsert)),
                    GenerationUtils.buildNameCamelCase(node.getParamName()),
                    "null").newStringBuilderBuild(index_builder);
<<<<<<< HEAD

<<<<<<< HEAD
            this.createdBuilders.add(index_builder);
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
>>>>>>> indexInsert could be modified in the children nodes of stringValue
=======
>>>>>>> Fix index inserts when creating 2 inserts in 2 different stringValue of a same macro reference
        }
    }

    @Override
    public void caseAStringTextPart(
            AStringTextPart node) {

        String index_builder = String.valueOf(this.indexBuilder);

<<<<<<< HEAD
<<<<<<< HEAD
        if(this.currentContextName != null
                && this.currentRedefinedInternalsSetter != null){

            this.currentRedefinedInternalsSetter.newStringPart(
                    GenerationUtils.escapedString(node.getString()),
                    String.valueOf(this.indexBuilder));
        }
        else {
            String string = GenerationUtils.escapedString(node.getString());

            if(this.currentInsertMacroPart != null){
                index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);
=======
        if(this.currentContext != null
=======
        if(this.currentContextName != null
>>>>>>> Moved utils files for generation to another walker
                && this.currentRedefinedInternalsSetter != null){

            this.currentRedefinedInternalsSetter.newStringPart(
                    GenerationUtils.escapedString(node.getString()),
                    String.valueOf(this.indexBuilder));
        }
        else {
            String string = GenerationUtils.escapedString(node.getString());

            if(this.currentInsertMacroPart != null){
<<<<<<< HEAD
                index_builder = getLetterFromInteger(this.indexBuilder);
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
                index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
                this.currentInsertMacroPart.newStringPart(
                        string,
                        index_builder);
            }
<<<<<<< HEAD
<<<<<<< HEAD
            else if(this.currentDirective != null){
                this.currentDirective.newStringPart(
                        string,
                        index_builder);
            }
            else if(this.mSetNoneDirective != null){
                this.mSetNoneDirective.newStringPart(
=======
            else if(this.currentNone != null){
                this.currentNone.newStringPart(
                        string,
                        index_builder);
            }
            else if(this.currentBeforeFirst != null){
                this.currentBeforeFirst.newStringPart(
                        string,
                        index_builder);
            }
            else if(this.currentAfterLast != null){
                this.currentAfterLast.newStringPart(
                        string,
                        index_builder);
            }
            else if(this.currentSeparator != null){
                this.currentSeparator.newStringPart(
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
            else if(this.currentDirective != null){
                this.currentDirective.newStringPart(
                        string,
                        index_builder);
            }
            else if(this.mSetNoneDirective != null){
                this.mSetNoneDirective.newStringPart(
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
                        string,
                        index_builder);
            }
        }
    }

    @Override
    public void caseAVarTextPart(
            AVarTextPart node) {

        String index_builder = String.valueOf(this.indexBuilder);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        String param_name = GenerationUtils.buildNameCamelCase(node.getNames());
        if(this.currentContextName != null
                && this.currentRedefinedInternalsSetter != null){

            this.currentRedefinedInternalsSetter.newParamInsertPart(
                    param_name,
                    index_builder);
        }
        else {
            if(this.currentInsertMacroPart != null){
                index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);
<<<<<<< HEAD
=======

=======
        String param_name = buildNameCamelCase(node.getNames());
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
        if(this.currentContext != null
=======
        String param_name = GenerationUtils.buildNameCamelCase(node.getNames());
        if(this.currentContextName != null
>>>>>>> Moved utils files for generation to another walker
                && this.currentRedefinedInternalsSetter != null){

            this.currentRedefinedInternalsSetter.newParamInsertPart(
                    param_name,
                    index_builder);
        }
        else {
            if(this.currentInsertMacroPart != null){
                index_builder = getLetterFromInteger(this.indexBuilder);
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
                this.currentInsertMacroPart.newParamInsertPart(
                        param_name,
                        index_builder);
            }
<<<<<<< HEAD
<<<<<<< HEAD
            else if(this.currentDirective != null){
                this.currentDirective.newParamInsertPart(
                        param_name,
                        index_builder);
            }
            else if(this.mSetNoneDirective != null){
                this.mSetNoneDirective.newParamInsertPart(
=======
            else if(this.currentNone != null){
                this.currentNone.newParamInsertPart(
                        param_name,
                        index_builder);
            }
            else if(this.currentBeforeFirst != null){
                this.currentBeforeFirst.newParamInsertPart(
                        param_name,
                        index_builder);
            }
            else if(this.currentAfterLast != null){
                this.currentAfterLast.newParamInsertPart(
                        param_name,
                        index_builder);
            }
            else if(this.currentSeparator != null){
                this.currentSeparator.newParamInsertPart(
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
            else if(this.currentDirective != null){
                this.currentDirective.newParamInsertPart(
                        param_name,
                        index_builder);
            }
            else if(this.mSetNoneDirective != null){
                this.mSetNoneDirective.newParamInsertPart(
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
                        param_name,
                        index_builder);
            }
        }
    }

    @Override
    public void caseAEolTextPart(
            AEolTextPart node) {

        String index_builder = String.valueOf(indexBuilder);

<<<<<<< HEAD
<<<<<<< HEAD
        if(this.currentContextName != null
                && this.currentRedefinedInternalsSetter != null){

            this.currentRedefinedInternalsSetter.newEolPart(index_builder);
=======
        if(this.currentContext != null
                && this.currentRedefinedInternalsSetter != null){

            this.currentRedefinedInternalsSetter.newEolPart(index_builder);

>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
        if(this.currentContextName != null
                && this.currentRedefinedInternalsSetter != null){

            this.currentRedefinedInternalsSetter.newEolPart(index_builder);
>>>>>>> Moved utils files for generation to another walker
        }
        else {

            if(this.currentInsertMacroPart != null){
<<<<<<< HEAD
<<<<<<< HEAD
                index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);
                this.currentInsertMacroPart.newEolPart(
                        index_builder);
            }
            else if(this.currentDirective != null){
                this.currentDirective.newEolPart(index_builder);
            }
            else if(this.mSetNoneDirective != null){
                this.mSetNoneDirective.newEolPart(index_builder);
=======
                index_builder = getLetterFromInteger(this.indexBuilder);
=======
                index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
                this.currentInsertMacroPart.newEolPart(
                        index_builder);
            }
            else if(this.currentDirective != null){
                this.currentDirective.newEolPart(index_builder);
            }
<<<<<<< HEAD
            else if(this.currentAfterLast != null){
                this.currentAfterLast.newEolPart(index_builder);
            }
            else if(this.currentSeparator != null){
                this.currentSeparator.newEolPart(index_builder);
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
            else if(this.mSetNoneDirective != null){
                this.mSetNoneDirective.newEolPart(index_builder);
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
            }
        }
    }

    @Override
    public void caseAInsertTextPart(
            AInsertTextPart node) {

        MInsertMacroPart tempInsertMacroPart = this.currentInsertMacroPart;
        AMacroRef macroRef = (AMacroRef) node.getMacroRef();
<<<<<<< HEAD
<<<<<<< HEAD
        String macro_name = GenerationUtils.buildNameCamelCase(macroRef.getNames());
        String index_builder = String.valueOf(this.indexBuilder);

        //Avoid declaring insert of the same name
        while(this.createdInserts.contains(this.indexInsert)){
            this.indexInsert++;
        }

        String index_insert = String.valueOf(this.indexInsert);

        if(this.currentContextName != null
                && this.currentRedefinedInternalsSetter != null){

=======
        String macro_name = buildNameCamelCase(macroRef.getNames());
=======
        String macro_name = GenerationUtils.buildNameCamelCase(macroRef.getNames());
>>>>>>> Moved utils files for generation to another walker
        String index_builder = String.valueOf(this.indexBuilder);

        //Avoid declaring insert of the same name
        while(this.createdInserts.contains(this.indexInsert)){
            this.indexInsert++;
        }

        String index_insert = String.valueOf(this.indexInsert);

        if(this.currentContextName != null
                && this.currentRedefinedInternalsSetter != null){
<<<<<<< HEAD
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======

>>>>>>> Moved utils files for generation to another walker
            this.currentInsertMacroPart =
                    this.currentRedefinedInternalsSetter.newInsertMacroPart(
                            macro_name,
                            index_builder,
                            index_insert);
<<<<<<< HEAD
<<<<<<< HEAD
        }
        else{
            if(tempInsertMacroPart != null){
                index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);
<<<<<<< HEAD

=======

        }else{
=======
        }
        else{
>>>>>>> Moved utils files for generation to another walker
            if(tempInsertMacroPart != null){
<<<<<<< HEAD
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
                index_builder = getLetterFromInteger(this.indexBuilder);
=======
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives

>>>>>>> fix creating same string builder in macro body
                this.currentInsertMacroPart =
                        tempInsertMacroPart.newInsertMacroPart(
                                macro_name,
                                index_builder,
                                index_insert);
<<<<<<< HEAD
<<<<<<< HEAD

            }
            else if(this.currentDirective != null){
<<<<<<< HEAD
                this.currentInsertMacroPart =
                    this.currentDirective.newInsertMacroPart(macro_name,
                            index_builder,
                            index_insert);

            }
            else if(this.mSetNoneDirective != null){
                this.currentInsertMacroPart =
                        this.mSetNoneDirective.newInsertMacroPart(macro_name,
                                index_builder,
                                index_insert);
            }
        }
        this.createdInserts.add(this.indexInsert);

        String tempContext = this.currentContextName;
        String tempMacroName = this.currentMacroRefName;
        Integer tempIndex = this.indexBuilder;
        Integer tempIndexInsert = this.indexInsert;
        this.currentContextName = null;
=======
=======

>>>>>>> fix creating same string builder in macro body
            }
            else if(this.currentNone != null){
=======
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
                this.currentInsertMacroPart =
                    this.currentDirective.newInsertMacroPart(macro_name,
                            index_builder,
                            index_insert);

            }
            else if(this.mSetNoneDirective != null){
                this.currentInsertMacroPart =
                        this.mSetNoneDirective.newInsertMacroPart(macro_name,
                                index_builder,
                                index_insert);
            }
        }
        this.createdInserts.add(this.indexInsert);

        String tempContext = this.currentContextName;
        String tempMacroName = this.currentMacroRefName;
        Integer tempIndex = this.indexBuilder;
        Integer tempIndexInsert = this.indexInsert;
<<<<<<< HEAD
        this.currentContext = null;
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
        this.currentContextName = null;
>>>>>>> Moved utils files for generation to another walker

        node.getMacroRef().apply(this);

        this.indexBuilder = tempIndex;
<<<<<<< HEAD
<<<<<<< HEAD
        this.indexInsert = tempIndexInsert;
        this.currentContextName = tempContext;
        this.currentMacroRefName = tempMacroName;
=======
=======
        this.indexInsert = tempIndexInsert;
<<<<<<< HEAD
>>>>>>> indexInsert could be modified in the children nodes of stringValue
        this.currentContext = tempContext;
<<<<<<< HEAD
        this.currentMacroName = tempMacroName;
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
=======
        this.currentContextName = tempContext;
>>>>>>> Moved utils files for generation to another walker
        this.currentMacroRefName = tempMacroName;
>>>>>>> Init internals before building the macro instead at the add or addAll methods
        this.currentInsertMacroPart = tempInsertMacroPart;

    }

    @Override
    public void outAVarValue(
            AVarValue node) {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        String var_name = GenerationUtils.buildNameCamelCase(node.getNames());

        if(this.currentContextName != null){

            MParamRef paramRef = this.currentRedefinedInternalsSetter.newSetInternal(
                        this.currentMacroRefName,
                        GenerationUtils.buildNameCamelCase(node.getParamName()),
                        this.currentContextName)
<<<<<<< HEAD
                        .newParamRef(var_name);

            if(this.currentMacro.getInternalsName().contains(var_name)){
                paramRef.newContextName(GenerationUtils.CONTEXT_STRING.toLowerCase());
            }
        }
        else{
            MParamRef mParamRef =
                    this.currentInsertMacroPart.newSetInternal(
                            GenerationUtils.INSERT_VAR_NAME.concat(String.valueOf(this.indexInsert)),
                            GenerationUtils.buildNameCamelCase(node.getParamName()),
                            "null").newParamRef(var_name);

            if(this.currentMacro.getInternalsName().contains(var_name)){
                mParamRef.newContextArg();
            }
=======
=======
        String var_name = buildNameCamelCase(node.getNames());

>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
        if(this.currentContext != null){
=======
        String var_name = GenerationUtils.buildNameCamelCase(node.getNames());

        if(this.currentContextName != null){
>>>>>>> Moved utils files for generation to another walker

            MParamRef paramRef = this.currentRedefinedInternalsSetter.newSetInternal(
                    this.currentMacroRefName,
                    buildNameCamelCase(node.getParamName()),
                    this.currentContext)
=======
>>>>>>> Add structure which contains list of macros and the context associated
                        .newParamRef(var_name);

            if(this.currentMacro.getInternalsName().contains(var_name)){
                paramRef.newContextName(GenerationUtils.CONTEXT_STRING.toLowerCase());
            }
        }
        else{
<<<<<<< HEAD
            this.currentInsertMacroPart.newSetInternal(
                    INSERT_VAR_NAME.concat(String.valueOf(this.indexInsert)),
                    buildNameCamelCase(node.getParamName()),
                    "null")
                    .newMacroArg(buildNameCamelCase(node.getNames()));

>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
            MParamRef mParamRef =
                    this.currentInsertMacroPart.newSetInternal(
                            GenerationUtils.INSERT_VAR_NAME.concat(String.valueOf(this.indexInsert)),
                            GenerationUtils.buildNameCamelCase(node.getParamName()),
                            "null").newParamRef(var_name);

            if(this.currentMacro.getInternalsName().contains(var_name)){
                mParamRef.newContextArg();
            }
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
        }
    }

    @Override
    public void outAMacro(
            AMacro node) {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        String macroName = GenerationUtils.buildNameCamelCase(node.getNames());
        GenerationUtils.writeFile(this.packageDirectory, "M" + macroName + ".java", this.currentMacroToBuild.toString());

        this.contextNames = null;
        this.currentMacroToBuild = null;
        this.currentConstructor = null;
        this.currentMacro = null;
        this.currentMacroHasInternals = false;
    }

    @Override
    public void caseAStringMacroPart(
            AStringMacroPart node) {

        this.currentMacroBuilder.newStringPart(
                GenerationUtils.escapedString(node.getString()),
=======
        for(TString string : node.getInitOrder()){
            String param_name = Utils.toCamelCase(string(string));
            if(this.currentParameters.contains(param_name)){
                this.currentConstructor.newSetParam(param_name).newParamArg(param_name);
            }
        }

=======
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
        String macroName = buildNameCamelCase(node.getNames());
        writeFile("M" + macroName + ".java", this.currentMacroToBuild.toString());
=======
        String macroName = GenerationUtils.buildNameCamelCase(node.getNames());
        GenerationUtils.writeFile(this.packageDirectory, "M" + macroName + ".java", this.currentMacroToBuild.toString());
>>>>>>> Moved utils files for generation to another walker

        this.contextNames = null;
        this.currentMacroToBuild = null;
        this.currentConstructor = null;
        this.currentMacro = null;
        this.currentMacroHasInternals = false;
    }

    @Override
    public void caseAStringMacroPart(
            AStringMacroPart node) {

        this.currentMacroBuilder.newStringPart(
<<<<<<< HEAD
                escapedString(node.getString()),
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
                GenerationUtils.escapedString(node.getString()),
>>>>>>> Moved utils files for generation to another walker
                String.valueOf(indexBuilder));
    }

    @Override
    public void outAEolMacroPart(
            AEolMacroPart node) {

        this.currentMacroBuilder.newEolPart(String.valueOf(indexBuilder));
    }

    @Override
    public void caseAInsertMacroPart(
            AInsertMacroPart node) {

        AMacroRef macroRef = (AMacroRef) node.getMacroRef();
<<<<<<< HEAD
<<<<<<< HEAD
        String macro_name = GenerationUtils.buildNameCamelCase(macroRef.getNames());
=======
        String macro_name = buildNameCamelCase(macroRef.getNames());
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
        String macro_name = GenerationUtils.buildNameCamelCase(macroRef.getNames());
>>>>>>> Moved utils files for generation to another walker
        this.indexInsert++;

        this.currentInsertMacroPart =
                this.currentMacroBuilder.newInsertMacroPart(
                        macro_name, String.valueOf(indexBuilder), String.valueOf(indexInsert));

<<<<<<< HEAD
<<<<<<< HEAD
        this.createdInserts.add(this.indexInsert);
        Integer tempIndexBuilder = this.indexBuilder;
        Integer tempIndexInsert = this.indexInsert;

        node.getMacroRef().apply(this);

        this.indexInsert = tempIndexInsert;
=======
=======
        this.createdInserts.add(this.indexInsert);
>>>>>>> Fix index inserts when creating 2 inserts in 2 different stringValue of a same macro reference
        Integer tempIndexBuilder = this.indexBuilder;
        Integer tempIndexInsert = this.indexInsert;

        node.getMacroRef().apply(this);

<<<<<<< HEAD
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
        this.indexInsert = tempIndexInsert;
>>>>>>> indexInsert could be modified in the children nodes of stringValue
        this.indexBuilder = tempIndexBuilder;
        this.currentInsertMacroPart = null;
    }

    @Override
    public void outAVarMacroPart(
            AVarMacroPart node) {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        String param_name = GenerationUtils.buildNameCamelCase(node.getNames());
        MParamInsertPart mParamInsertPart =
                this.currentMacroBuilder.newParamInsertPart(
                        param_name,
                        String.valueOf(indexBuilder));

        if(this.currentMacro.getInternalsName().contains(param_name)){
            mParamInsertPart.newContextArg();
        }
    }
=======
//
//    private final IntermediateRepresentation ir;
//
//    private final File packageDirectory;
//
//    private MText currentText;
//
//    private MMacro currentMacro;
//
//    private MTextInsertPart currentTextInsertPart;
//
//    private MNone currentNone;
//
//    private MSeparator currentSeparator;
//
//    private MBeforeFirst currentBeforeFirst;
//
//    private MAfterLast currentAfterLast;
//
//    private MBeforeOne currentBeforeOne;
//
//    private MAfterOne currentAfterOne;
//
//    private MBeforeMany currentBeforeMany;
//
//    private MAfterMany currentAfterMany;
//
//    private MTextInsert currentTextInsert;
//
//    private MInlineText currentInlineText;
//
//    public CodeGenerationWalker(
//            IntermediateRepresentation ir,
//            File packageDirectory) {
//
//        this.ir = ir;
//        this.packageDirectory = packageDirectory;
//    }
//
//    private String string(
//            TString tString) {
//
//        String string = tString.getText();
//        int length = string.length();
//        return string.substring(1, length - 1);
//    }
//
//    private String escapedString(
//            TString tString) {
//
//        StringBuilder sb = new StringBuilder();
//        String s = string(tString);
//        boolean escaped = false;
//        for (char c : s.toCharArray()) {
//            if (escaped) {
//                escaped = false;
//
//                if (c == '\\') {
//                    sb.append('\\');
//                    sb.append('\\');
//                }
//                else if (c == '\'') {
//                    sb.append('\'');
//                }
//                else {
//                    throw new InternalException("unhandled case");
//                }
//            }
//            else if (c == '\\') {
//                escaped = true;
//            }
//            else if (c == '\"') {
//                sb.append('\\');
//                sb.append('\"');
//            }
//            else {
//                sb.append(c);
//            }
//        }
//
//        if (escaped) {
//            throw new InternalException("incomplete escape");
//        }
//
//        return sb.toString();
//    }
//
//    private boolean bool(
//            PBoolean pBoolean) {
//
//        if (pBoolean instanceof ATrueBoolean) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public void inAText(
//            AText node) {
//
//        this.currentText = new MText(string(node.getName()));
//
//        if (!this.ir.getDestinationPackage().equals("")) {
//            this.currentText.newPackageDeclaration(this.ir
//                    .getDestinationPackage());
//        }
//
//        for (TString param : node.getParams()) {
//            this.currentText.newParamField(string(param));
//            this.currentText.newParamParam(string(param));
//            this.currentText.newParamConstructorInit(string(param));
//            this.currentText.newParam(string(param));
//        }
//
//        if (bool(node.getSelfRef())) {
//            this.currentText.newSelfRefText();
//        }
//
//        for (TString ancersorRef : node.getAncestorRefs()) {
//            this.currentText.newAncestorField(string(ancersorRef));
//            this.currentText.newAncestorParam(string(ancersorRef));
//            this.currentText.newAncestorConstructorInit(string(ancersorRef));
//        }
//    }
//
//    @Override
//    public void outAText(
//            AText node) {
//
//        File destination = new File(this.packageDirectory, "M"
//                + string(node.getName()) + ".java");
//
//        try {
//            FileWriter fw = new FileWriter(destination);
//            fw.write(this.currentText.toString());
//            fw.close();
//        }
//        catch (IOException e) {
//            throw CompilerException.outputError(destination.toString(), e);
//        }
//
//        this.currentText = null;
//    }
//
//    @Override
//    public void inAMacro(
//            AMacro node) {
//
//        this.currentMacro = new MMacro(string(node.getName()));
//
//        if (!this.ir.getDestinationPackage().equals("")) {
//            this.currentMacro.newPackageDeclaration(this.ir
//                    .getDestinationPackage());
//        }
//
//        if (bool(node.getIsPublic())) {
//            this.currentMacro.newPublic();
//        }
//
//        if (node.getExpands().size() > 0) {
//            this.currentMacro.newImportJavaUtil();
//        }
//
//        for (TString param : node.getParams()) {
//            this.currentMacro.newParamField(string(param));
//            this.currentMacro.newParamParam(string(param));
//            this.currentMacro.newParamConstructorInit(string(param));
//            this.currentMacro.newParam(string(param));
//        }
//
//        if (bool(node.getSelfRef())) {
//            this.currentMacro.newSelfRefMacro();
//        }
//
//        for (TString ancersorRef : node.getAncestorRefs()) {
//            this.currentMacro.newAncestorField(string(ancersorRef));
//            this.currentMacro.newAncestorParam(string(ancersorRef));
//            this.currentMacro.newAncestorConstructorInit(string(ancersorRef));
//        }
//
//        for (TString expand : node.getExpands()) {
//            this.currentMacro.newExpandField(string(expand));
//        }
//    }
//
//    @Override
//    public void outAMacro(
//            AMacro node) {
//
//        File destination = new File(this.packageDirectory, "M"
//                + string(node.getName()) + ".java");
//
//        try {
//            FileWriter fw = new FileWriter(destination);
//            fw.write(this.currentMacro.toString());
//            fw.close();
//        }
//        catch (IOException e) {
//            throw CompilerException.outputError(destination.toString(), e);
//        }
//
//        this.currentMacro = null;
//    }
//
//    @Override
//    public void outAParamRef(
//            AParamRef node) {
//
//        if (this.currentText != null) {
//            this.currentText.newParamRef(string(node.getName()),
//                    string(node.getContext()));
//        }
//        else if (this.currentMacro != null) {
//            this.currentMacro.newParamRef(string(node.getName()),
//                    string(node.getContext()));
//        }
//        else {
//            throw new InternalException("unhandled case");
//        }
//    }
//
//    @Override
//    public void outAExpandedMacro(
//            AExpandedMacro node) {
//
//        MMacroCreator macroCreator = this.currentMacro
//                .newMacroCreator(string(node.getName()));
//
//        for (TString param : node.getParams()) {
//            macroCreator.newParamParam(string(param));
//            macroCreator.newParamArg(string(param));
//        }
//
//        for (TString ancestorRef : node.getAncestorRefs()) {
//            macroCreator.newAncestorArg(string(ancestorRef));
//        }
//
//        for (TString expand : node.getExpands()) {
//            macroCreator.newAddToExpand(string(expand));
//        }
//    }
//
//    @Override
//    public void outAStringTextPart(
//            AStringTextPart node) {
//
//        this.currentText.newStringPart(escapedString(node.getString()));
//    }
//
//    @Override
//    public void outAEolTextPart(
//            AEolTextPart node) {
//
//        this.currentText.newEolPart();
//    }
//
//    @Override
//    public void outAParamInsertTextPart(
//            AParamInsertTextPart node) {
//
//        this.currentText.newParamInsertPart(string(node.getParamInsert()));
//    }
//
//    @Override
//    public void inATextInsertTextPart(
//            ATextInsertTextPart node) {
//
//        this.currentTextInsertPart = this.currentText.newTextInsertPart();
//    }
//
//    @Override
//    public void outATextInsertTextPart(
//            ATextInsertTextPart node) {
//
//        this.currentTextInsertPart = null;
//    }
//
//    @Override
//    public void outAStringMacroPart(
//            AStringMacroPart node) {
//
//        this.currentMacro.newStringPart(escapedString(node.getString()));
//    }
//
//    @Override
//    public void outAEolMacroPart(
//            AEolMacroPart node) {
//
//        this.currentMacro.newEolPart();
//    }
//
//    @Override
//    public void outAParamInsertMacroPart(
//            AParamInsertMacroPart node) {
//
//        this.currentMacro.newParamInsertPart(string(node.getParamInsert()));
//    }
//
//    @Override
//    public void inATextInsertMacroPart(
//            ATextInsertMacroPart node) {
//
//        this.currentTextInsertPart = this.currentMacro.newTextInsertPart();
//    }
//
//    @Override
//    public void outATextInsertMacroPart(
//            ATextInsertMacroPart node) {
//
//        this.currentTextInsertPart = null;
//    }
//
//    @Override
//    public void caseAExpandInsert(
//            AExpandInsert node) {
//
//        MExpandInsertPart currentExpandInsertPart = this.currentMacro
//                .newExpandInsertPart(string(node.getName()));
//
//        if (node.getNone() != null) {
//            this.currentNone = currentExpandInsertPart.newNone();
//            node.getNone().apply(this);
//            this.currentNone = null;
//        }
//
//        if (node.getSeparator() != null) {
//            this.currentSeparator = currentExpandInsertPart.newSeparator();
//            node.getSeparator().apply(this);
//            this.currentSeparator = null;
//        }
//        else {
//            currentExpandInsertPart.newNoSeparator();
//        }
//
//        if (node.getBeforeFirst() != null) {
//            this.currentBeforeFirst = currentExpandInsertPart.newBeforeFirst();
//            node.getBeforeFirst().apply(this);
//            this.currentBeforeFirst = null;
//        }
//
//        if (node.getAfterLast() != null) {
//            this.currentAfterLast = currentExpandInsertPart.newAfterLast();
//            node.getAfterLast().apply(this);
//            this.currentAfterLast = null;
//        }
//
//        if (node.getBeforeOne() != null) {
//            this.currentBeforeOne = currentExpandInsertPart.newBeforeOne();
//            node.getBeforeOne().apply(this);
//            this.currentBeforeOne = null;
//        }
//
//        if (node.getAfterOne() != null) {
//            this.currentAfterOne = currentExpandInsertPart.newAfterOne();
//            node.getAfterOne().apply(this);
//            this.currentAfterOne = null;
//        }
//
//        if (node.getBeforeMany() != null) {
//            this.currentBeforeMany = currentExpandInsertPart.newBeforeMany();
//            node.getBeforeMany().apply(this);
//            this.currentBeforeMany = null;
//        }
//
//        if (node.getAfterMany() != null) {
//            this.currentAfterMany = currentExpandInsertPart.newAfterMany();
//            node.getAfterMany().apply(this);
//            this.currentAfterMany = null;
//        }
//    }
//
//    @Override
//    public void caseATextInsert(
//            ATextInsert node) {
//
//        MTextInsert oldTextInsert = this.currentTextInsert;
//
//        if (oldTextInsert != null) {
//            this.currentTextInsert = oldTextInsert.newTextInsert(string(node
//                    .getName()));
//        }
//        else if (this.currentNone != null) {
//            this.currentTextInsert = this.currentNone.newTextInsert(string(node
//                    .getName()));
//        }
//        else if (this.currentSeparator != null) {
//            this.currentTextInsert = this.currentSeparator
//                    .newTextInsert(string(node.getName()));
//        }
//        else if (this.currentBeforeFirst != null) {
//            this.currentTextInsert = this.currentBeforeFirst
//                    .newTextInsert(string(node.getName()));
//        }
//        else if (this.currentAfterLast != null) {
//            this.currentTextInsert = this.currentAfterLast
//                    .newTextInsert(string(node.getName()));
//        }
//        else if (this.currentBeforeOne != null) {
//            this.currentTextInsert = this.currentBeforeOne
//                    .newTextInsert(string(node.getName()));
//        }
//        else if (this.currentAfterOne != null) {
//            this.currentTextInsert = this.currentAfterOne
//                    .newTextInsert(string(node.getName()));
//        }
//        else if (this.currentBeforeMany != null) {
//            this.currentTextInsert = this.currentBeforeMany
//                    .newTextInsert(string(node.getName()));
//        }
//        else if (this.currentAfterMany != null) {
//            this.currentTextInsert = this.currentAfterMany
//                    .newTextInsert(string(node.getName()));
//        }
//        else if (this.currentTextInsertPart != null) {
//            this.currentTextInsert = this.currentTextInsertPart
//                    .newTextInsert(string(node.getName()));
//        }
//        else {
//            throw new InternalException("unhandled case");
//        }
//
//        for (PValue arg : node.getArgs()) {
//            arg.apply(this);
//        }
//
//        for (TString ancestorRef : node.getAncestorRefs()) {
//            this.currentTextInsert.newTextInsertAncestor(string(ancestorRef));
//        }
//
//        this.currentTextInsert = oldTextInsert;
//    }
//
//    @Override
//    public void inAInlineTextValue(
//            AInlineTextValue node) {
//
//        if (this.currentTextInsert != null) {
//            this.currentInlineText = this.currentTextInsert.newInlineText();
//        }
//        else if (this.currentNone != null) {
//            this.currentInlineText = this.currentNone.newInlineText();
//        }
//        else if (this.currentSeparator != null) {
//            this.currentInlineText = this.currentSeparator.newInlineText();
//        }
//        else if (this.currentBeforeFirst != null) {
//            this.currentInlineText = this.currentBeforeFirst.newInlineText();
//        }
//        else if (this.currentAfterLast != null) {
//            this.currentInlineText = this.currentAfterLast.newInlineText();
//        }
//        else if (this.currentBeforeOne != null) {
//            this.currentInlineText = this.currentBeforeOne.newInlineText();
//        }
//        else if (this.currentAfterOne != null) {
//            this.currentInlineText = this.currentAfterOne.newInlineText();
//        }
//        else if (this.currentBeforeMany != null) {
//            this.currentInlineText = this.currentBeforeMany.newInlineText();
//        }
//        else if (this.currentAfterMany != null) {
//            this.currentInlineText = this.currentAfterMany.newInlineText();
//        }
//        else {
//            throw new InternalException("unhandled case");
//        }
//    }
//
//    @Override
//    public void outAInlineTextValue(
//            AInlineTextValue node) {
//
//        if (this.currentTextInsert != null) {
//            this.currentInlineText = null;
//        }
//        else if (this.currentNone != null) {
//            this.currentInlineText = null;
//        }
//        else if (this.currentSeparator != null) {
//            this.currentInlineText = null;
//        }
//        else if (this.currentBeforeFirst != null) {
//            this.currentInlineText = null;
//        }
//        else if (this.currentAfterLast != null) {
//            this.currentInlineText = null;
//        }
//        else if (this.currentBeforeOne != null) {
//            this.currentInlineText = null;
//        }
//        else if (this.currentAfterOne != null) {
//            this.currentInlineText = null;
//        }
//        else if (this.currentBeforeMany != null) {
//            this.currentInlineText = null;
//        }
//        else if (this.currentAfterMany != null) {
//            this.currentInlineText = null;
//        }
//        else {
//            throw new InternalException("unhandled case");
//        }
//    }
//
//    @Override
//    public void outAStringInlineText(
//            AStringInlineText node) {
//
//        this.currentInlineText.newInlineString(escapedString(node.getString()));
//    }
//
//    @Override
//    public void outAEolInlineText(
//            AEolInlineText node) {
//
//        this.currentInlineText.newInlineEol();
//    }
//
//    @Override
//    public void outAParamInsertValue(
//            AParamInsertValue node) {
//
//        if (this.currentTextInsert != null) {
//            this.currentTextInsert
//                    .newParamInsert(string(node.getParamInsert()));
//        }
//        else if (this.currentNone != null) {
//            this.currentNone.newParamInsert(string(node.getParamInsert()));
//        }
//        else if (this.currentSeparator != null) {
//            this.currentSeparator.newParamInsert(string(node.getParamInsert()));
//        }
//        else if (this.currentBeforeFirst != null) {
//            this.currentBeforeFirst
//                    .newParamInsert(string(node.getParamInsert()));
//        }
//        else if (this.currentAfterLast != null) {
//            this.currentAfterLast.newParamInsert(string(node.getParamInsert()));
//        }
//        else if (this.currentBeforeOne != null) {
//            this.currentBeforeOne.newParamInsert(string(node.getParamInsert()));
//        }
//        else if (this.currentAfterOne != null) {
//            this.currentAfterOne.newParamInsert(string(node.getParamInsert()));
//        }
//        else if (this.currentBeforeMany != null) {
//            this.currentBeforeMany
//                    .newParamInsert(string(node.getParamInsert()));
//        }
//        else if (this.currentAfterMany != null) {
//            this.currentAfterMany.newParamInsert(string(node.getParamInsert()));
//        }
//        else {
//            throw new InternalException("unhandled case");
//        }
//    }
>>>>>>> Comment Code generation to compile ObjectMacro
=======
=======
        String param_name = buildNameCamelCase(node.getNames());
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
=======
        String param_name = GenerationUtils.buildNameCamelCase(node.getNames());
>>>>>>> Moved utils files for generation to another walker
        MParamInsertPart mParamInsertPart =
                this.currentMacroBuilder.newParamInsertPart(
                        param_name,
                        String.valueOf(indexBuilder));

        if(this.currentMacro.getInternalsName().contains(param_name)){
            mParamInsertPart.newContextArg();
        }
    }
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
}
