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

package org.sablecc.sablecc.semantics;

import java.util.*;

import org.sablecc.exception.*;
import org.sablecc.sablecc.syntax3.node.*;

public class Grammar
        extends Declaration {

    private AGrammar declaration;

    private Map<Node, Object> nodeMap = new HashMap<Node, Object>();

    private Map<TIdentifier, Declaration> declarationResolutionMap = new HashMap<TIdentifier, Declaration>();

    private Map<Token, Expression> inlinedExpressionResolutionMap = new HashMap<Token, Expression>();

    private Map<TIdentifier, Alternative> alternativeResolutionMap = new HashMap<TIdentifier, Alternative>();

    private NameSpace parserNameSpace = new NameSpace();

    private NameSpace treeNameSpace = new NameSpace();

    private int nextInternalNameIndex = 1;

    // Cached values

    private String name;

    private Token location;

    Grammar(
            AGrammar declaration) {

        this.declaration = declaration;
        this.nodeMap.put(declaration, this);
        this.parserNameSpace.add(this);
        this.treeNameSpace.add(this);
    }

    @Override
    public String getName() {

        if (this.name == null) {
            this.name = getLocation().getText();
        }

        return this.name;
    }

    @Override
    public String getLookupName() {

        return getName();
    }

    @Override
    public Token getLocation() {

        if (this.location == null) {
            this.location = this.declaration.getName();
        }

        return this.location;
    }

    public Expression getExpression(
            Node declaration) {

        return (Expression) this.nodeMap.get(declaration);
    }

    public Production getProduction(
            AParserProduction declaration) {

        return (Production) this.nodeMap.get(declaration);
    }

    public Production getProduction(
            ATreeProduction declaration) {

        return (Production) this.nodeMap.get(declaration);
    }

    public Alternative getAlternative(
            AAlternative declaration) {

        return (Alternative) this.nodeMap.get(declaration);
    }

    public Element getElement(
            AElement declaration) {

        return (Element) this.nodeMap.get(declaration);
    }

    public Declaration getDeclarationResolution(
            TIdentifier identifier) {

        return this.declarationResolutionMap.get(identifier);
    }

    public Expression getExpressionResolution(
            TIdentifierChar node) {

        return this.inlinedExpressionResolutionMap.get(node);
    }

    public Expression getExpressionResolution(
            TChar node) {

        return this.inlinedExpressionResolutionMap.get(node);
    }

    public Expression getExpressionResolution(
            TIdentifierString node) {

        return this.inlinedExpressionResolutionMap.get(node);
    }

    public Expression getExpressionResolution(
            TString node) {

        return this.inlinedExpressionResolutionMap.get(node);
    }

    public Expression getExpressionResolution(
            TEndKeyword node) {

        return this.inlinedExpressionResolutionMap.get(node);
    }

    public Alternative getAlternativeResolution(
            TIdentifier identifier) {

        return this.alternativeResolutionMap.get(identifier);
    }

    void addExpression(
            Node declaration) {

        Expression expression = new Expression(this, declaration);
        expression.setInternalName(expression.getName());
        this.nodeMap.put(declaration, expression);
        this.parserNameSpace.add(expression);
        this.treeNameSpace.add(expression);
    }

    void addInlinedExpression(
            Node declaration) {

        Expression expression = new Expression(this, declaration);
        String name = expression.getName();
        if (name != null) {
            expression.setInternalName(name);
        }
        else {
            expression.setInternalName("." + this.nextInternalNameIndex++);
        }

        Declaration previousDeclaration = this.parserNameSpace.get(expression
                .getLookupName());

        // only add new expression if it's a new declaration or if it redeclares
        // a normal expression
        if (previousDeclaration == null
                || previousDeclaration.getLocation() instanceof TIdentifier) {
            this.nodeMap.put(declaration, expression);
            this.parserNameSpace.add(expression);
            this.treeNameSpace.add(expression);
        }
        else {
            this.nodeMap.put(declaration, previousDeclaration);
        }
    }

    void addProduction(
            AParserProduction declaration) {

        Production production = new Production(this, declaration);
        production.setInternalName(production.getName());
        this.nodeMap.put(declaration, production);
        this.parserNameSpace.add(production);
    }

    void addProduction(
            ATreeProduction declaration) {

        Production production = new Production(this, declaration);
        production.setInternalName(production.getName());
        this.nodeMap.put(declaration, production);
        this.treeNameSpace.add(production);
    }

    void addAlternative(
            Production production,
            AAlternative declaration) {

        Alternative alternative = new Alternative(this, production, declaration);
        this.nodeMap.put(declaration, alternative);
    }

    void addElement(
            Alternative alternative,
            AElement declaration) {

        Element element = new Element(this, alternative, declaration);
        this.nodeMap.put(declaration, element);
    }

    void resolveExpression(
            ANameExpression nameExpression) {

        TIdentifier nameIdentifier = nameExpression.getIdentifier();
        String name = nameIdentifier.getText();
        Declaration declaration = this.parserNameSpace.get(name);

        if (declaration == null) {
            declaration = this.treeNameSpace.get(name);

            if (declaration == null) {
                throw SemanticException.semanticError("No \"" + name
                        + "\" has been declared.", nameIdentifier);
            }

            if (!(declaration instanceof Expression)) {
                throw SemanticException.semanticError("\"" + name
                        + "\" is not an expression.", nameIdentifier);
            }

            throw new InternalException(
                    "an expression must be in both parser and tree name spaces");
        }

        if (!(declaration instanceof Expression)) {
            throw SemanticException.semanticError("\"" + name
                    + "\" is not an expression.", nameIdentifier);
        }

        this.declarationResolutionMap.put(nameIdentifier, declaration);
    }

    void resolveTreeNameUnit(
            ANameUnit nameUnit) {

        TIdentifier nameIdentifier = nameUnit.getIdentifier();
        String name = nameIdentifier.getText();
        Declaration declaration = this.treeNameSpace.get(name);

        if (declaration == null) {
            declaration = this.parserNameSpace.get(name);

            if (declaration == null) {
                throw SemanticException.semanticError("No \"" + name
                        + "\" has been declared.", nameIdentifier);
            }

            throw SemanticException.semanticError("\"" + name
                    + "\" is not a tree production.", nameIdentifier);
        }

        this.declarationResolutionMap.put(nameIdentifier, declaration);
    }

    void resolveIdentifierCharUnit(
            AIdentifierCharUnit identifierCharUnit) {

        TIdentifierChar identifierChar = identifierCharUnit.getIdentifierChar();
        String text = identifierChar.getText();
        String name = text.substring(1, text.length() - 1);
        resolveInlinedExpression(name, identifierChar);
    }

    void resolveCharUnit(
            ACharUnit charUnit) {

        TChar charToken = charUnit.getChar();
        String name = charToken.getText();
        resolveInlinedExpression(name, charToken);
    }

    void resolveIdentifierStringUnit(
            AIdentifierStringUnit identifierStringUnit) {

        TIdentifierString identifierString = identifierStringUnit
                .getIdentifierString();
        String text = identifierString.getText();
        String name = text.substring(1, text.length() - 1);
        resolveInlinedExpression(name, identifierString);
    }

    void resolveStringUnit(
            AStringUnit stringUnit) {

        TString stringToken = stringUnit.getString();
        String name = stringToken.getText();
        resolveInlinedExpression(name, stringToken);
    }

    void resolveEndUnit(
            AEndUnit endUnit) {

        TEndKeyword endKeyword = endUnit.getEndKeyword();
        resolveInlinedExpression("end", endKeyword);
    }

    void resolveParserIdentifier(
            TIdentifier identifier) {

        String name = identifier.getText();
        Declaration declaration = this.parserNameSpace.get(name);

        if (declaration == null) {
            declaration = this.treeNameSpace.get(name);

            if (declaration == null) {
                throw SemanticException.semanticError("No \"" + name
                        + "\" has been declared.", identifier);
            }

            throw SemanticException.semanticError("\"" + name
                    + "\" is not a parser production.", identifier);
        }

        if (!(declaration instanceof Production)
                && !(declaration instanceof Expression)) {
            throw SemanticException.semanticError("\"" + name
                    + "\" is not a production or an expression.", identifier);
        }

        this.declarationResolutionMap.put(identifier, declaration);
    }

    void resolveTreeIdentifier(
            TIdentifier identifier) {

        String name = identifier.getText();
        Declaration declaration = this.treeNameSpace.get(name);

        if (declaration == null) {
            declaration = this.parserNameSpace.get(name);

            if (declaration == null) {
                throw SemanticException.semanticError("No \"" + name
                        + "\" has been declared.", identifier);
            }

            throw SemanticException.semanticError("\"" + name
                    + "\" is not a tree production.", identifier);
        }

        if (!(declaration instanceof Production)
                && !(declaration instanceof Expression)) {
            throw SemanticException.semanticError("\"" + name
                    + "\" is not a production or an expression.", identifier);
        }

        this.declarationResolutionMap.put(identifier, declaration);
    }

    void resolveAlternativeIdentifiers(
            Production production,
            LinkedList<TIdentifier> identifiers) {

        for (TIdentifier identifier : identifiers) {
            resolveAlternativeIdentifier(production, identifier);
        }
    }

    void resolveAlternativeIdentifier(
            Production production,
            TIdentifier identifier) {

        String name = identifier.getText();
        Alternative alternative = production.getAlternative(name);

        if (alternative == null) {
            if (production.hasAlternative(name)) {
                throw SemanticException.semanticError("Production \""
                        + production.getName() + "\" has two \"" + name
                        + "\" alternatives (or more).", identifier);
            }

            throw SemanticException.semanticError(
                    "\"" + name + "\" is not an alternative of production \""
                            + production.getName() + "\".", identifier);
        }

        this.alternativeResolutionMap.put(identifier, alternative);
    }

    private void resolveInlinedExpression(
            String name,
            Token location) {

        Declaration declaration = this.parserNameSpace.get(name);

        if (declaration == null) {
            declaration = this.treeNameSpace.get(name);

            if (declaration == null) {
                throw SemanticException.semanticError("No \"" + name
                        + "\" has been declared.", location);
            }

            if (!(declaration instanceof Expression)) {
                throw SemanticException.semanticError("\"" + name
                        + "\" is not an expression.", location);
            }

            throw new InternalException(
                    "an expression must be in both parser and tree name spaces");
        }

        if (!(declaration instanceof Expression)) {
            throw SemanticException.semanticError("\"" + name
                    + "\" is not an expression.", location);
        }

        this.inlinedExpressionResolutionMap.put(location,
                (Expression) declaration);
    }
}
