/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.errormessage;

public class MIncorrectMacroType {

  private final String pExpected;
  private final String pFound;
  private final String pIndex;
  private final String pLine;
  private final String pChar;
  private final MIncorrectMacroType mIncorrectMacroType = this;

  public MIncorrectMacroType(String pExpected, String pFound, String pIndex, String pLine, String pChar) {
    if(pExpected == null) throw new NullPointerException();
    this.pExpected = pExpected;
    if(pFound == null) throw new NullPointerException();
    this.pFound = pFound;
    if(pIndex == null) throw new NullPointerException();
    this.pIndex = pIndex;
    if(pLine == null) throw new NullPointerException();
    this.pLine = pLine;
    if(pChar == null) throw new NullPointerException();
    this.pChar = pChar;
  }

  String pExpected() {
    return this.pExpected;
  }

  String pFound() {
    return this.pFound;
  }

  String pIndex() {
    return this.pIndex;
  }

  String pLine() {
    return this.pLine;
  }

  String pChar() {
    return this.pChar;
  }

  private String rLine() {
    return this.mIncorrectMacroType.pLine();
  }

  private String rChar() {
    return this.mIncorrectMacroType.pChar();
  }

  private String rIndex() {
    return this.mIncorrectMacroType.pIndex();
  }

  private String rExpected() {
    return this.mIncorrectMacroType.pExpected();
  }

  private String rFound() {
    return this.mIncorrectMacroType.pFound();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(new MSemanticErrorHead().toString());
    sb.append(System.getProperty("line.separator"));
    sb.append("Line : ");
    sb.append(rLine());
    sb.append(System.getProperty("line.separator"));
    sb.append("Char : ");
    sb.append(rChar());
    sb.append(System.getProperty("line.separator"));
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    sb.append("Incorrect macro type at index ");
=======
    sb.append("You provided a wrong argument type at index ");
>>>>>>> Add semantic verification on argument type provided in a macro reference
=======
    sb.append("Incorrect macro type at index ");
>>>>>>> Update error message incorrect macro type
=======
    sb.append("Incorrect macro type at index ");
>>>>>>> object-macro2.1
    sb.append(rIndex());
    sb.append(". (expected : ");
    sb.append(rExpected());
    sb.append(", found : ");
    sb.append(rFound());
    sb.append(")");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

}
