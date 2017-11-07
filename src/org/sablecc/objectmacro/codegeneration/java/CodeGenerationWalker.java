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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.sablecc.exception.*;
import org.sablecc.objectmacro.codegeneration.*;
import org.sablecc.objectmacro.codegeneration.java.macro.*;
import org.sablecc.objectmacro.exception.*;
import org.sablecc.objectmacro.intermediate.syntax3.analysis.*;
import org.sablecc.objectmacro.intermediate.syntax3.node.*;
import org.sablecc.objectmacro.util.Utils;

public class CodeGenerationWalker
        extends DepthFirstAdapter {

    private static final String CONTEXT_STRING = "Context";

    private static final String INSERT_VAR_NAME = "insert_";

    private static final String SEPARATOR_DIRECTIVE = "separator";

    private static final String AFTER_LAST_DIRECTIVE = "afterlast";

    private static final String NONE_DIRECTIVE = "none";

    private static final String BEFORE_FIRST_DIRECTIVE = "beforefirst";

    private final IntermediateRepresentation ir;

    private final File packageDirectory;

    private MMacro currentMacro;

    private MConstructor currentConstructor;

    private MSuperMacro superMacro;

    private MInternalsInitializer mInternalsInitializer;

    private MContext mContext;

    private MMacroBuilder currentMacroBuilder;

    private MApplyInternalsInitializer currentApplyInitializer;

    private MRedefinedInternalsSetter currentRedefinedInternalsSetter;

    private Integer indexBuilder = 0;

    private Integer indexInsert = 0;

    private String currentMacroName;

    private final Map<String, MMacro> macros;

    private String currentContext;

    private MInsertMacroPart currentInsertMacroPart;

    private List<String> contextNames = new ArrayList<>();

    private List<String> createdBuilders = new ArrayList<>();

    private boolean isCurrentMacroPackageProtected = false;

    private List<String> currentParameters = new ArrayList<>();

    private MSeparator currentSeparator;

    private MAfterLast currentAfterLast;

    private MBeforeFirst currentBeforeFirst;

    private MNone currentNone;

    private MParamMacroRef currentParamMacroRef;

    public CodeGenerationWalker(
            IntermediateRepresentation ir,
            File packageDirectory,
            Map<String, MMacro> macros) {

        this.ir = ir;
        this.packageDirectory = packageDirectory;
        this.macros = macros;
    }

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

        return macroName.toString();
    }

    private String buildName(
            LinkedList<TString> name_parts){

        StringBuilder macroName = new StringBuilder();
        for(TString partName : name_parts){
            macroName.append(string(partName));
        }

        return macroName.toString();
    }

    private void writeFile(
            String fileName,
            String content){

        File destination = new File(this.packageDirectory, fileName);

        try {
            FileWriter fw = new FileWriter(destination);
            fw.write(content);
            fw.close();
        }
        catch (IOException e) {
            throw CompilerException.outputError(destination.toString(), e);
        }
    }

    private String getLetterFromInteger(
            Integer i){

        return i > 0 && i < 27 ? String.valueOf((char) (i + 64)) : null;
    }

    @Override
    public void inAIntermediateRepresentation(
            AIntermediateRepresentation node) {

        this.superMacro = new MSuperMacro();
        this.mInternalsInitializer = new MInternalsInitializer();
        this.mContext = new MContext();

        if(!this.ir.getDestinationPackage().equals("")){
            String destinationPackage = this.ir.getDestinationPackage();
            this.superMacro.newPackageDeclaration(destinationPackage);
            this.mInternalsInitializer.newPackageDeclaration(destinationPackage);
            this.mContext.newPackageDeclaration(destinationPackage);

        }

        this.superMacro.newImportJavaUtil();
        this.mInternalsInitializer.newImportJavaUtil();

    }

    @Override
    public void outAIntermediateRepresentation(
            AIntermediateRepresentation node) {

        writeFile("Macro.java", this.superMacro.toString());
        writeFile("Context.java", this.mContext.toString());
        writeFile("InternalsInitializer.java", this.mInternalsInitializer.toString());

        MParameterNull mParameterNull = new MParameterNull();
        MIncorrectType mIncorrectType = new MIncorrectType();
        MObjectMacroErrorHead mObjectMacroErrorHead = new MObjectMacroErrorHead();
        MMacroNullInList mMacroNullInList = new MMacroNullInList();
        MObjectMacroException mObjectMacroException = new MObjectMacroException();

        if(!this.ir.getDestinationPackage().equals("")){
            String destinationPackage = this.ir.getDestinationPackage();
            mIncorrectType.newPackageDeclaration(destinationPackage);
            mParameterNull.newPackageDeclaration(destinationPackage);
            mObjectMacroErrorHead.newPackageDeclaration(destinationPackage);
            mMacroNullInList.newPackageDeclaration(destinationPackage);
            mObjectMacroException.newPackageDeclaration(destinationPackage);

        }

        writeFile("MIncorrectType.java", mIncorrectType.toString());
        writeFile("MParameterNull.java", mParameterNull.toString());
        writeFile("MObjectMacroErrorHead.java", mObjectMacroErrorHead.toString());
        writeFile("MMacroNullInList.java", mMacroNullInList.toString());
        writeFile("ObjectMacroException.java", mObjectMacroException.toString());
    }

    @Override
    public void inAMacro(
            AMacro node) {

        String macroName = buildNameCamelCase(node.getNames());
        this.currentMacro = this.macros.get(macroName);
        this.contextNames = new ArrayList<>();

        if(this.currentMacro == null){
            throw new InternalException("currentMacro cannot be null here");
        }

        if (!this.ir.getDestinationPackage().equals("")) {

            this.currentMacro.newPackageDeclaration(this.ir.getDestinationPackage());
        }

        this.currentConstructor
                = this.currentMacro.newConstructor(macroName);
        this.currentMacroBuilder = this.currentMacro.newMacroBuilder();

        if(node.getInternals().size() > 0){
            isCurrentMacroPackageProtected = true;
            this.mInternalsInitializer.newParentInternalsSetter(macroName);
            this.currentMacro.newRedefinedApplyInitializer(macroName);
            this.currentMacroBuilder.newContextParam();
            this.currentMacroBuilder.newContextExpansion();
            this.currentMacroBuilder.newNewContextExpansion();
            this.currentMacro.newImportJavaUtil();
        }
        else{
            this.currentMacroBuilder.newPublic();
        }
    }

    @Override
    public void caseAInternal(
            AInternal node) {

        String paramName = buildNameCamelCase(node.getNames());
        this.indexBuilder = 0;

        if(node.getType() instanceof AStringType){
            this.currentMacro
                    .newInternalStringField(paramName);
            this.currentMacro.newInternalStringSetter(paramName);
            MParamStringRef mParamStringRef = this.currentMacro.newParamStringRef(paramName);
            mParamStringRef.newContextParam();
            mParamStringRef.newGetInternalTail();

        }
        else if(node.getType() instanceof AMacroRefsType){

            this.currentMacro
                    .newInternalMacroField(paramName);
            this.currentMacro.newContextField(paramName);

            this.currentParamMacroRef = this.currentMacro.newParamMacroRef(paramName, String.valueOf(this.indexBuilder));
            this.currentParamMacroRef.newContextParam();
            this.currentParamMacroRef.newGetInternalTail();
            this.currentParamMacroRef.newContextName(paramName.concat(CONTEXT_STRING));

            for (PDirective directive : node.getDirectives()) {
                directive.apply(this);
            }

            this.indexBuilder = 0;

            this.currentContext = paramName.concat(CONTEXT_STRING);
            this.contextNames.add(currentContext);
            this.currentApplyInitializer =
                    this.currentMacro.newInternalMacroSetter(paramName)
                            .newApplyInternalsInitializer(paramName);

        }
        else{
            throw new InternalException("case unhandled");
        }

        node.getType().apply(this);
        outAInternal(node);
    }

    @Override
    public void outAInternal(
            AInternal node) {

        this.currentContext = null;
        this.currentApplyInitializer = null;
        this.indexBuilder = 0;
        this.indexInsert = 0;
        this.currentParamMacroRef = null;
        this.createdBuilders.clear();
    }

    @Override
    public void caseAParam(
            AParam node) {

        String paramName = buildNameCamelCase(node.getNames());

        if(node.getType() instanceof AStringType){

            this.currentMacro.newParamStringField(paramName);
            this.currentMacro.newParamStringRef(paramName);
            this.currentMacro.newParamStringSetter(paramName);

            this.currentConstructor.newStringParam(paramName);

        }
        else if(node.getType() instanceof AMacroRefsType){

            this.currentMacro.newParamMacroField(paramName);
            this.currentMacro.newContextField(paramName);

            this.currentParamMacroRef = this.currentMacro.newParamMacroRef(
                    paramName, String.valueOf(this.indexBuilder));
            this.currentParamMacroRef.newContextName(paramName.concat(CONTEXT_STRING));

            for (PDirective directive : node.getDirectives()) {
                directive.apply(this);
            }

            this.currentContext = paramName.concat(CONTEXT_STRING);
            this.indexBuilder = 0;

            MParamMacroSetter mParamMacroSetter = this.currentMacro.newParamMacroSetter(paramName);
            mParamMacroSetter.newParamArg(paramName);
            mParamMacroSetter.newMacroParam(paramName);

            this.currentConstructor.newMacroParam(paramName);
            this.currentApplyInitializer = mParamMacroSetter.newApplyInternalsInitializer(paramName);
            this.contextNames.add(currentContext);
        }
        else{
            throw new InternalException("case unhandled");
        }

        this.currentParameters.add(paramName);
        node.getType().apply(this);
        outAParam(node);
    }

    @Override
    public void outAParam(AParam node) {

        this.currentContext = null;
        this.currentApplyInitializer = null;
        this.indexBuilder = 0;
        this.indexInsert = 0;
        this.createdBuilders.clear();
        this.currentParamMacroRef = null;
    }

    @Override
    public void inADirective(
            ADirective node) {

        String directive_name = buildName(node.getNames());

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
        }
    }

    @Override
    public void outADirective(
            ADirective node) {

        this.currentSeparator = null;
        this.currentAfterLast = null;
        this.currentBeforeFirst = null;
        this.currentNone = null;
    }

    @Override
    public void inAMacroRef(
            AMacroRef node) {

        this.currentMacroName = buildNameCamelCase(node.getNames());

        if(this.currentContext == null){
            return;
        }

        this.currentRedefinedInternalsSetter = this.currentApplyInitializer.newRedefinedInternalsSetter(
                    currentMacroName);

    }

    @Override
    public void outAMacroRef(
            AMacroRef node) {

        this.currentMacroName = null;
    }

    @Override
    public void inAStringValue(
            AStringValue node) {

        this.indexBuilder++;
        String index_builder = String.valueOf(this.indexBuilder);
        boolean anyContext = this.currentContext != null;

        if(anyContext){
            this.currentRedefinedInternalsSetter.newInitStringBuilder(index_builder);

            this.currentRedefinedInternalsSetter.newSetInternal(
                    this.currentMacroName,
                    buildNameCamelCase(node.getParamName()),
                    this.currentContext).newStringBuilderBuild(index_builder);
        }
        else{

            index_builder = getLetterFromInteger(this.indexBuilder);

            if(this.createdBuilders.contains(index_builder)){
                this.indexBuilder++;
                index_builder = getLetterFromInteger(this.indexBuilder);
            }

            this.currentInsertMacroPart.newInitStringBuilder(index_builder);

            this.currentInsertMacroPart.newSetInternal(
                    INSERT_VAR_NAME.concat(String.valueOf(this.indexInsert)),
                    buildNameCamelCase(node.getParamName()),
                    "null").newStringBuilderBuild(index_builder);

            this.createdBuilders.add(index_builder);
        }
    }

    @Override
    public void caseAStringTextPart(
            AStringTextPart node) {

        String index_builder = String.valueOf(this.indexBuilder);

        if(this.currentContext != null
                && this.currentRedefinedInternalsSetter != null){

            this.currentRedefinedInternalsSetter.newStringPart(
                    escapedString(node.getString()),
                    String.valueOf(this.indexBuilder));

        }
        else {

            String string = escapedString(node.getString());

            if(this.currentInsertMacroPart != null){
                index_builder = getLetterFromInteger(this.indexBuilder);
                this.currentInsertMacroPart.newStringPart(
                        string,
                        index_builder);
            }
            else if(this.currentNone != null){
                this.currentNone.newStringPart(
                        string,
                        index_builder);

            }else if(this.currentBeforeFirst != null){
                this.currentBeforeFirst.newStringPart(
                        string,
                        index_builder);

            }else if(this.currentAfterLast != null){
                this.currentAfterLast.newStringPart(
                        string,
                        index_builder);

            }else if(this.currentSeparator != null){
                this.currentSeparator.newStringPart(
                        string,
                        index_builder);
            }
        }
    }

    @Override
    public void caseAVarTextPart(
            AVarTextPart node) {

        String index_builder = String.valueOf(this.indexBuilder);

        if(this.currentContext != null
                && this.currentRedefinedInternalsSetter != null){

            this.currentRedefinedInternalsSetter.newParamInsertPart(
                    buildNameCamelCase(node.getNames()),
                    String.valueOf(this.indexBuilder));

        }
        else {
            String param_name = buildNameCamelCase(node.getNames());

            if(this.currentInsertMacroPart != null){
                index_builder = getLetterFromInteger(this.indexBuilder);
                this.currentInsertMacroPart.newParamInsertPart(
                        param_name,
                        index_builder);
            }
            else if(this.currentNone != null){
                this.currentNone.newParamInsertPart(
                        param_name,
                        index_builder);

            }else if(this.currentBeforeFirst != null){
                this.currentBeforeFirst.newParamInsertPart(
                        param_name,
                        index_builder);

            }else if(this.currentAfterLast != null){
                this.currentAfterLast.newParamInsertPart(
                        param_name,
                        index_builder);

            }else if(this.currentSeparator != null){
                this.currentSeparator.newParamInsertPart(
                        param_name,
                        index_builder);
            }
        }
    }

    @Override
    public void caseAEolTextPart(
            AEolTextPart node) {

        String index_builder = String.valueOf(indexBuilder);

        if(this.currentContext != null
                && this.currentRedefinedInternalsSetter != null){

            this.currentRedefinedInternalsSetter.newEolPart(index_builder);

        }
        else {

            if(this.currentInsertMacroPart != null){
                index_builder = getLetterFromInteger(this.indexBuilder);
                this.currentInsertMacroPart.newEolPart(
                        index_builder);
            }
            else if(this.currentNone != null){
                this.currentNone.newEolPart(index_builder);

            }else if(this.currentBeforeFirst != null){
                this.currentBeforeFirst.newEolPart(index_builder);

            }else if(this.currentAfterLast != null){
                this.currentAfterLast.newEolPart(index_builder);

            }else if(this.currentSeparator != null){
                this.currentSeparator.newEolPart(index_builder);
            }
        }
    }

    @Override
    public void caseAInsertTextPart(
            AInsertTextPart node) {

        MInsertMacroPart tempInsertMacroPart = this.currentInsertMacroPart;
        AMacroRef macroRef = (AMacroRef) node.getMacroRef();
        String macro_name = buildNameCamelCase(macroRef.getNames());
        String index_builder = String.valueOf(this.indexBuilder);

        this.indexInsert++;
        String index_insert = String.valueOf(this.indexInsert);

        if(this.currentContext != null
                && this.currentRedefinedInternalsSetter != null){
            this.currentInsertMacroPart =
                    this.currentRedefinedInternalsSetter.newInsertMacroPart(
                            macro_name,
                            index_builder,
                            index_insert);

        }else{
            if(tempInsertMacroPart != null){
                this.currentInsertMacroPart =
                        tempInsertMacroPart.newInsertMacroPart(
                                macro_name,
                                index_builder,
                                index_insert);
            }
            else if(this.currentNone != null){
                this.currentInsertMacroPart =
                    this.currentNone.newInsertMacroPart(macro_name,
                            index_builder,
                            index_insert);

            }else if(this.currentBeforeFirst != null){
                this.currentInsertMacroPart =
                        this.currentBeforeFirst.newInsertMacroPart(macro_name,
                            index_builder,
                            index_insert);

            }else if(this.currentAfterLast != null){
                this.currentInsertMacroPart =
                    this.currentAfterLast.newInsertMacroPart(macro_name,
                            index_builder,
                            index_insert);

            }else if(this.currentSeparator != null){
                this.currentInsertMacroPart =
                    this.currentSeparator.newInsertMacroPart(macro_name,
                            index_builder,
                            index_insert);
            }
        }

        String tempContext = this.currentContext;
        String tempMacroName = this.currentMacroName;
        Integer tempIndex = this.indexBuilder;
        this.currentContext = null;

        node.getMacroRef().apply(this);

        this.indexBuilder = tempIndex;
        this.currentContext = tempContext;
        this.currentMacroName = tempMacroName;
        this.currentInsertMacroPart = tempInsertMacroPart;

    }

    @Override
    public void outAVarValue(
            AVarValue node) {

        if(this.currentContext != null){
            this.currentRedefinedInternalsSetter.newSetInternal(
                    this.currentMacroName,
                    buildNameCamelCase(node.getParamName()),
                    this.currentContext)
                    .newMacroArg(buildNameCamelCase(node.getNames()));

        }
        else{
            this.currentInsertMacroPart.newSetInternal(
                    INSERT_VAR_NAME.concat(String.valueOf(this.indexInsert)),
                    buildNameCamelCase(node.getParamName()),
                    "null")
                    .newMacroArg(buildNameCamelCase(node.getNames()));

        }
    }

    @Override
    public void outAMacro(
            AMacro node) {

        for(TString string : node.getInitOrder()){
            String param_name = Utils.toCamelCase(string(string));
            if(this.currentParameters.contains(param_name)){
                this.currentConstructor.newSetParam(param_name).newParamArg(param_name);
            }
        }

        String macroName = buildNameCamelCase(node.getNames());
        writeFile("M" + macroName + ".java", this.currentMacro.toString());

        this.contextNames = null;
        this.currentMacro = null;
        this.currentConstructor = null;
        this.isCurrentMacroPackageProtected = false;
        this.currentParameters.clear();
    }

    @Override
    public void caseAStringMacroPart(AStringMacroPart node) {

        this.currentMacroBuilder.newStringPart(
                escapedString(node.getString()),
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
        String macro_name = buildNameCamelCase(macroRef.getNames());
        this.indexInsert++;

        this.currentInsertMacroPart =
                this.currentMacroBuilder.newInsertMacroPart(
                        macro_name, String.valueOf(indexBuilder), String.valueOf(indexInsert));

        Integer tempIndexBuilder = this.indexBuilder;

        node.getMacroRef().apply(this);

        this.indexBuilder = tempIndexBuilder;
        this.currentInsertMacroPart = null;
    }

    @Override
    public void outAVarMacroPart(
            AVarMacroPart node) {

        MParamInsertPart mParamInsertPart =
                this.currentMacroBuilder.newParamInsertPart(
                    buildNameCamelCase(node.getNames()),
                    String.valueOf(indexBuilder));

        if(this.isCurrentMacroPackageProtected){
            mParamInsertPart.newContextArg();
        }
    }
}
