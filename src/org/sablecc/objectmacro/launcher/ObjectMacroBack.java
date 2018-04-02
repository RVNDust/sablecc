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

package org.sablecc.objectmacro.launcher;

import java.io.*;

import org.sablecc.exception.*;
import org.sablecc.objectmacro.codegeneration.*;
import org.sablecc.objectmacro.codegeneration.java.*;
import org.sablecc.objectmacro.errormessage.*;
import org.sablecc.objectmacro.exception.*;
import org.sablecc.objectmacro.intermediate.syntax3.lexer.Lexer;
import org.sablecc.objectmacro.intermediate.syntax3.lexer.LexerException;
import org.sablecc.objectmacro.intermediate.syntax3.node.Start;
import org.sablecc.objectmacro.intermediate.syntax3.parser.Parser;
import org.sablecc.objectmacro.intermediate.syntax3.parser.ParserException;
import org.sablecc.util.*;

/**
 * The main class of ObjectMacroBack.
 */
public class ObjectMacroBack {

    /** Prevents instantiation of this class. */
    private ObjectMacroBack() {

        throw new InternalException("this class may not have instances");
    }

    /** Launches ObjectMacroBack. */
    public static void main(
            String[] args) {

        try {
            compile(args);
        }
        catch (CompilerException e) {
            System.err.print(e.getMessage());
            System.err.flush();
            System.exit(1);
        }
        catch (ParserException e) {
            int start = e.getMessage().indexOf(' ');
            System.err.print(new MSyntaxError(e.getToken().getLine() + "", e
                    .getToken().getPos() + "", e.getToken().getClass()
                    .getSimpleName().substring(1).toLowerCase(), e.getToken()
                    .getText(), e.getMessage().substring(start)));
            System.err.flush();
            System.exit(1);
        }
        catch (LexerException e) {
            int start = e.getMessage().indexOf('[') + 1;
            int end = e.getMessage().indexOf(',');
            String line = e.getMessage().substring(start, end);

            start = e.getMessage().indexOf(',') + 1;
            end = e.getMessage().indexOf(']');
            String pos = e.getMessage().substring(start, end);

            start = e.getMessage().indexOf(' ') + 1;

            System.err.print(new MLexicalError(line, pos, e.getMessage()
                    .substring(start)));
            System.err.flush();
            System.exit(1);
        }
        catch (InternalException e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            pw.flush();
            System.err.print(new MInternalError(sw.toString(), e.getMessage()));
            System.err.flush();
            System.exit(1);
        }

        // finish gracefully
        System.exit(0);
    }

    /**
     * Parses the provided arguments and launches macro compilation.
     */
    public static void compile(
            String[] arguments)
            throws ParserException, LexerException {

<<<<<<< HEAD
<<<<<<< HEAD
        // default target is java-constructor
        String targetLanguage = "java-constructor";
=======
        // default target is java
        String targetLanguage = "java";
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
        // default target is java-constructor
        String targetLanguage = "java-constructor";
>>>>>>> Clean up code, add comments

        // default destination directory is current working directory
        File destinationDirectory = new File(System.getProperty("user.dir"));

        // default destination package is anonymous
        String destinationPackage = "";

        // default option values
        boolean generateCode = true;
        Verbosity verbosity = Verbosity.INFORMATIVE;
        Strictness strictness = Strictness.STRICT;

        // parse command line arguments
        ArgumentCollection argumentCollection = new ArgumentCollection(
                arguments);

        // handle option arguments
        for (OptionArgument optionArgument : argumentCollection
                .getOptionArguments()) {

            switch (optionArgument.getOption()) {

            case LIST_TARGETS:
                System.out.println("Available targets:");
<<<<<<< HEAD
<<<<<<< HEAD
                System.out.println(" java-constructor (default)");
=======
                System.out.println(" java (default)");
                System.out.println(" c");
                System.out.println(" scala");
                System.out.println(" intermediate");
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
                System.out.println(" java-constructor (default)");
>>>>>>> Clean up code, add comments
                return;

            case TARGET:
                targetLanguage = optionArgument.getOperand();
                break;

            case DESTINATION:
                destinationDirectory = new File(optionArgument.getOperand());
                break;

            case PACKAGE:
                destinationPackage = optionArgument.getOperand();
                break;

            case GENERATE:
                generateCode = true;
                break;

            case NO_CODE:
                generateCode = false;
                break;

            case LENIENT:
                strictness = Strictness.LENIENT;
                break;

            case STRICT:
                strictness = Strictness.STRICT;
                break;

            case QUIET:
                verbosity = Verbosity.QUIET;
                break;

            case INFORMATIVE:
                verbosity = Verbosity.INFORMATIVE;
                break;

            case VERBOSE:
                verbosity = Verbosity.VERBOSE;
                break;

            case VERSION:
<<<<<<< HEAD
<<<<<<< HEAD
                System.out.println("ObjectMacro-back, part of SableCC version "
=======
                System.out.println("ObjectMacroBack, part of SableCC version "
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
                System.out.println("ObjectMacro-back, part of SableCC version "
>>>>>>> Invalid suffix intermediate
                        + Version.VERSION);
                return;

            case HELP:
<<<<<<< HEAD
<<<<<<< HEAD
                System.out.println("Usage: objectmacro backend "
                        + Option.getShortHelpMessage() + " file.intermediate");
=======
                System.out.println("Usage: objectmacro "
<<<<<<< HEAD
                        + Option.getShortHelpMessage() + " file.objectmacro");
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
=======
                System.out.println("Usage: objectmacro backend "
>>>>>>> Invalid suffix intermediate
                        + Option.getShortHelpMessage() + " file.intermediate");
>>>>>>> Clean up code, add comments
                System.out.println("Options:");
                System.out.println(Option.getLongHelpMessage());
                return;

            default:
                throw new InternalException("unhandled option "
                        + optionArgument.getOption());
            }
        }

        switch (verbosity) {
        case INFORMATIVE:
        case VERBOSE:
            System.out.println();
            System.out.println("ObjectMacroBack, part of SableCC version "
                    + Version.VERSION);
            System.out
                    .println("by Etienne M. Gagnon <egagnon@j-meg.com> and other contributors.");
            System.out.println();
            break;
        }

        // handle text arguments
        if (argumentCollection.getTextArguments().size() == 0) {
            System.out.println("Usage: objectmacro "
<<<<<<< HEAD
<<<<<<< HEAD
                    + Option.getShortHelpMessage() + " file.intermediate");
=======
                    + Option.getShortHelpMessage() + " file.objectmacro");
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
                    + Option.getShortHelpMessage() + " file.intermediate");
>>>>>>> Clean up code, add comments
            return;
        }
        else if (argumentCollection.getTextArguments().size() > 1) {
            throw CompilerException.invalidArgumentCount();
        }

        // check target
<<<<<<< HEAD
<<<<<<< HEAD
        if (!(targetLanguage.equals("java-constructor"))) {
=======
        if (!(targetLanguage.equals("java")
                || targetLanguage.equals("intermediate")
                || targetLanguage.equals("c") || targetLanguage.equals("scala"))) {
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
        if (!(targetLanguage.equals("java-constructor"))) {
>>>>>>> Clean up code, add comments
            throw CompilerException.unknownTarget(targetLanguage);
        }

        // check argument
        TextArgument textArgument = argumentCollection.getTextArguments()
                .get(0);

        File macroFile = new File(textArgument.getText());

<<<<<<< HEAD
<<<<<<< HEAD
        if (!textArgument.getText().endsWith(".intermediate")) {
            throw CompilerException.invalidIntermediateSuffix(textArgument.getText());
        }

=======
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
        if (!textArgument.getText().endsWith(".intermediate")) {
            throw CompilerException.invalidIntermediateSuffix(textArgument.getText());
        }

>>>>>>> Clean up code, add comments
        if (!macroFile.exists()) {
            throw CompilerException.missingMacroFile(textArgument.getText());
        }

        if (!macroFile.isFile()) {
            throw CompilerException.macroNotFile(textArgument.getText());
        }

        compile(macroFile, targetLanguage, destinationDirectory,
                destinationPackage, generateCode, strictness, verbosity);
    }

    /**
     * Compiles the provided macro file.
     */
    private static void compile(
            File macroFile,
            String targetLanguage,
            File destinationDirectory,
            String destinationPackage,
            boolean generateCode,
            Strictness strictness,
            Verbosity verbosity)
            throws ParserException, LexerException {

        switch (verbosity) {
        case INFORMATIVE:
        case VERBOSE:
            System.out.println("Compiling \"" + macroFile + "\"");
            break;
        }

        Start ast;

        try {
            FileReader fr = new FileReader(macroFile);
            BufferedReader br = new BufferedReader(fr);
            PushbackReader pbr = new PushbackReader(br, 1024);

            switch (verbosity) {
            case VERBOSE:
                System.out.println(" Parsing");
                break;
            }

            ast = new Parser(new Lexer(pbr)).parse();

            pbr.close();
            br.close();
            fr.close();
        }
        catch (IOException e) {
            throw CompilerException.inputError(macroFile.toString(), e);
        }

        IntermediateRepresentation ir = new IntermediateRepresentation(
                ast.getPIntermediateRepresentation(), macroFile, destinationDirectory,
                destinationPackage);

        CodeGenerator codeGenerator = new JavaCodeGenerator(ir);
        codeGenerator.generateCode();

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Clean up code, add comments
        if (targetLanguage.equals("java-constructor")) {
            codeGenerator = new JavaCodeGenerator(ir);
        }
        else {
            throw new InternalException("unhandled case");
        }

        switch (verbosity) {
        case VERBOSE:
            System.out.println(" Verifying target-specific semantics");
            break;
        }

        codeGenerator.verifyTargetSpecificSemantics(strictness);

        if (generateCode) {
            switch (verbosity) {
            case VERBOSE:
                System.out.println(" Generating code");
                break;
            }

            codeGenerator.generateCode();
        }
<<<<<<< HEAD
=======
//        if (targetLanguage.equals("java")) {
//            codeGenerator = new JavaCodeGenerator(ir);
//        }
//        else if (targetLanguage.equals("intermediate")) {
//            codeGenerator = new IntermediateCodeGenerator(ir);
//        }
//        else if (targetLanguage.equals("c")) {
//            codeGenerator = new CCodeGenerator(ir);
//        }
//        else if (targetLanguage.equals("scala")) {
//            codeGenerator = new ScalaCodeGenerator(ir);
//        }
//        else {
//            throw new InternalException("unhandled case");
//        }
//
//        switch (verbosity) {
//        case VERBOSE:
//            System.out.println(" Verifying target-specific semantics");
//            break;
//        }
//
//        codeGenerator.verifyTargetSpecificSemantics(strictness);
//
//        if (generateCode) {
//            switch (verbosity) {
//            case VERBOSE:
//                System.out.println(" Generating code");
//                break;
//            }
//
//            codeGenerator.generateCode();
//        }
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
>>>>>>> Clean up code, add comments
    }
}
