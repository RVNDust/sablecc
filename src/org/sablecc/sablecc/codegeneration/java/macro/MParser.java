/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.sablecc.codegeneration.java.macro;

import java.util.*;

public class MParser {

    private final List<Object> eDefaultPackage_SpecifiedPackage = new LinkedList<Object>();

    private final List<Object> eLrStateSingleton = new LinkedList<Object>();

    public MParser() {

    }

    public MLrStateSingleton newLrStateSingleton(
            String pNumber) {

        MLrStateSingleton lLrStateSingleton = new MLrStateSingleton(pNumber);
        this.eLrStateSingleton.add(lLrStateSingleton);
        return lLrStateSingleton;
    }

    public MDefaultPackage newDefaultPackage(
            String pLanguageName) {

        MDefaultPackage lDefaultPackage = new MDefaultPackage(pLanguageName);
        this.eDefaultPackage_SpecifiedPackage.add(lDefaultPackage);
        return lDefaultPackage;
    }

    public MSpecifiedPackage newSpecifiedPackage(
            String pLanguageName,
            String pPackage) {

        MSpecifiedPackage lSpecifiedPackage = new MSpecifiedPackage(
                pLanguageName, pPackage);
        this.eDefaultPackage_SpecifiedPackage.add(lSpecifiedPackage);
        return lSpecifiedPackage;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(new MHeader().toString());
        if (this.eDefaultPackage_SpecifiedPackage.size() > 0) {
            sb.append(System.getProperty("line.separator"));
        }
        for (Object oDefaultPackage_SpecifiedPackage : this.eDefaultPackage_SpecifiedPackage) {
            sb.append(oDefaultPackage_SpecifiedPackage.toString());
        }
        sb.append(System.getProperty("line.separator"));
        sb.append("import java.io.*;");
        sb.append(System.getProperty("line.separator"));
        sb.append("import java.util.*;");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("public class Parser {");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("  private final Lexer lexer;");
        sb.append(System.getProperty("line.separator"));
        sb.append("  private final ParseStack stack = new ParseStack();");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("  public Parser(Reader reader) {");
        sb.append(System.getProperty("line.separator"));
        sb.append("    this.lexer = new Lexer(reader);");
        sb.append(System.getProperty("line.separator"));
        sb.append("  }");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("  public Node parse()");
        sb.append(System.getProperty("line.separator"));
        sb
                .append("      throws ParserException, LexerException, IOException {");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("    Node tree = null;");
        sb.append(System.getProperty("line.separator"));
        sb.append("    while(tree == null) {");
        sb.append(System.getProperty("line.separator"));
        sb.append("      tree = stack.getState().apply(this);");
        sb.append(System.getProperty("line.separator"));
        sb.append("    }");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("    return tree;");
        sb.append(System.getProperty("line.separator"));
        sb.append("  }");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("  ParseStack getStack() {");
        sb.append(System.getProperty("line.separator"));
        sb.append("    return this.stack;");
        sb.append(System.getProperty("line.separator"));
        sb.append("  }");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb
                .append("  private LinkedList<Token> lookList = new LinkedList<Token>();");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("  Token look(int distance)");
        sb.append(System.getProperty("line.separator"));
        sb.append("      throws LexerException, IOException {");
        sb.append(System.getProperty("line.separator"));
        sb.append("    while(lookList.size() < distance) {");
        sb.append(System.getProperty("line.separator"));
        sb.append("      lookList.addLast(lexer.next());");
        sb.append(System.getProperty("line.separator"));
        sb.append("    }");
        sb.append(System.getProperty("line.separator"));
        sb.append("    return lookList.get(distance - 1);");
        sb.append(System.getProperty("line.separator"));
        sb.append("  }");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("  void shift()");
        sb.append(System.getProperty("line.separator"));
        sb
                .append("      throws ParserException, LexerException, IOException {");
        sb.append(System.getProperty("line.separator"));
        sb.append("    Token token;");
        sb.append(System.getProperty("line.separator"));
        sb.append("    if(lookList.size() > 0) {");
        sb.append(System.getProperty("line.separator"));
        sb.append("      token = lookList.removeFirst();");
        sb.append(System.getProperty("line.separator"));
        sb.append("    }");
        sb.append(System.getProperty("line.separator"));
        sb.append("    else {");
        sb.append(System.getProperty("line.separator"));
        sb.append("      token = lexer.next();");
        sb.append(System.getProperty("line.separator"));
        sb.append("    }");
        sb.append(System.getProperty("line.separator"));
        sb.append("    stack.push(token, stack.getState().getTarget(token));");
        sb.append(System.getProperty("line.separator"));
        sb.append("  }");
        sb.append(System.getProperty("line.separator"));
        sb.append("}");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("class ParseStack {");
        sb.append(System.getProperty("line.separator"));
        sb
                .append("  private ParseStackEntry stack = new ParseStackEntry(null, null, L_0.instance);");
        sb.append(System.getProperty("line.separator"));
        sb.append("  private ParseStackEntry freeList;");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("  void push(Node node, LRState state) {");
        sb.append(System.getProperty("line.separator"));
        sb.append("    ParseStackEntry entry;");
        sb.append(System.getProperty("line.separator"));
        sb.append("    if(freeList != null) {");
        sb.append(System.getProperty("line.separator"));
        sb.append("      entry = freeList;");
        sb.append(System.getProperty("line.separator"));
        sb.append("      freeList = freeList.previous;");
        sb.append(System.getProperty("line.separator"));
        sb.append("      entry.set(stack, node, state);");
        sb.append(System.getProperty("line.separator"));
        sb.append("    }");
        sb.append(System.getProperty("line.separator"));
        sb.append("    else {");
        sb.append(System.getProperty("line.separator"));
        sb.append("      entry = new ParseStackEntry(stack, node, state);");
        sb.append(System.getProperty("line.separator"));
        sb.append("    }");
        sb.append(System.getProperty("line.separator"));
        sb.append("    stack = entry;");
        sb.append(System.getProperty("line.separator"));
        sb.append("  }");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("  LRState getState() {");
        sb.append(System.getProperty("line.separator"));
        sb.append("    return stack.state;");
        sb.append(System.getProperty("line.separator"));
        sb.append("  }");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("  Node pop() {");
        sb.append(System.getProperty("line.separator"));
        sb.append("    Node node = stack.node;");
        sb.append(System.getProperty("line.separator"));
        sb.append("    ParseStackEntry entry = stack;");
        sb.append(System.getProperty("line.separator"));
        sb.append("    stack = stack.previous;");
        sb.append(System.getProperty("line.separator"));
        sb.append("    entry.set(freeList, null, null);");
        sb.append(System.getProperty("line.separator"));
        sb.append("    freeList = entry;");
        sb.append(System.getProperty("line.separator"));
        sb.append("    return node;");
        sb.append(System.getProperty("line.separator"));
        sb.append("  }");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("  private static class ParseStackEntry {");
        sb.append(System.getProperty("line.separator"));
        sb.append("    ParseStackEntry previous;");
        sb.append(System.getProperty("line.separator"));
        sb.append("    Node node;");
        sb.append(System.getProperty("line.separator"));
        sb.append("    LRState state;");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("    ParseStackEntry(");
        sb.append(System.getProperty("line.separator"));
        sb.append("        ParseStackEntry previous,");
        sb.append(System.getProperty("line.separator"));
        sb.append("        Node node,");
        sb.append(System.getProperty("line.separator"));
        sb.append("        LRState state) {");
        sb.append(System.getProperty("line.separator"));
        sb.append("     this.previous = previous;");
        sb.append(System.getProperty("line.separator"));
        sb.append("     this.node = node;");
        sb.append(System.getProperty("line.separator"));
        sb.append("     this.state = state;");
        sb.append(System.getProperty("line.separator"));
        sb.append("    }");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("    void set(");
        sb.append(System.getProperty("line.separator"));
        sb.append("        ParseStackEntry previous,");
        sb.append(System.getProperty("line.separator"));
        sb.append("        Node node,");
        sb.append(System.getProperty("line.separator"));
        sb.append("        LRState state) {");
        sb.append(System.getProperty("line.separator"));
        sb.append("     this.previous = previous;");
        sb.append(System.getProperty("line.separator"));
        sb.append("     this.node = node;");
        sb.append(System.getProperty("line.separator"));
        sb.append("     this.state = state;");
        sb.append(System.getProperty("line.separator"));
        sb.append("   }");
        sb.append(System.getProperty("line.separator"));
        sb.append("  }");
        sb.append(System.getProperty("line.separator"));
        sb.append("}");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("abstract class LRState {");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("  abstract Node apply(Parser parser)");
        sb.append(System.getProperty("line.separator"));
        sb.append("      throws ParserException, LexerException, IOException;");
        sb.append(System.getProperty("line.separator"));
        sb.append("  abstract LRState getTarget(Node node)");
        sb.append(System.getProperty("line.separator"));
        sb.append("      throws ParserException, LexerException, IOException;");
        sb.append(System.getProperty("line.separator"));
        sb.append("}");
        sb.append(System.getProperty("line.separator"));
        for (Object oLrStateSingleton : this.eLrStateSingleton) {
            sb.append(oLrStateSingleton.toString());
        }
        return sb.toString();
    }

}
