/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.sablecc.core.errormessage;

public class MAmbiguousAlternativeTransformation {

    private final String pElemName;

    private final String pParserAltName;

    private final String pParserProdName;

    private final String pTreeLine;

    private final String pTreeChar;

    private final String pParserLine;

    private final String pFirstParserChar;

    private final String pSecondParserChar;

    private final MAmbiguousAlternativeTransformation mAmbiguousAlternativeTransformation = this;

    public MAmbiguousAlternativeTransformation(
            String pElemName,
            String pParserAltName,
            String pParserProdName,
            String pTreeLine,
            String pTreeChar,
            String pParserLine,
            String pFirstParserChar,
            String pSecondParserChar) {

        if (pElemName == null) {
            throw new NullPointerException();
        }
        this.pElemName = pElemName;
        if (pParserAltName == null) {
            throw new NullPointerException();
        }
        this.pParserAltName = pParserAltName;
        if (pParserProdName == null) {
            throw new NullPointerException();
        }
        this.pParserProdName = pParserProdName;
        if (pTreeLine == null) {
            throw new NullPointerException();
        }
        this.pTreeLine = pTreeLine;
        if (pTreeChar == null) {
            throw new NullPointerException();
        }
        this.pTreeChar = pTreeChar;
        if (pParserLine == null) {
            throw new NullPointerException();
        }
        this.pParserLine = pParserLine;
        if (pFirstParserChar == null) {
            throw new NullPointerException();
        }
        this.pFirstParserChar = pFirstParserChar;
        if (pSecondParserChar == null) {
            throw new NullPointerException();
        }
        this.pSecondParserChar = pSecondParserChar;
    }

    String pElemName() {

        return this.pElemName;
    }

    String pParserAltName() {

        return this.pParserAltName;
    }

    String pParserProdName() {

        return this.pParserProdName;
    }

    String pTreeLine() {

        return this.pTreeLine;
    }

    String pTreeChar() {

        return this.pTreeChar;
    }

    String pParserLine() {

        return this.pParserLine;
    }

    String pFirstParserChar() {

        return this.pFirstParserChar;
    }

    String pSecondParserChar() {

        return this.pSecondParserChar;
    }

    private String rTreeLine() {

        return this.mAmbiguousAlternativeTransformation.pTreeLine();
    }

    private String rTreeChar() {

        return this.mAmbiguousAlternativeTransformation.pTreeChar();
    }

    private String rParserAltName() {

        return this.mAmbiguousAlternativeTransformation.pParserAltName();
    }

    private String rParserProdName() {

        return this.mAmbiguousAlternativeTransformation.pParserProdName();
    }

    private String rElemName() {

        return this.mAmbiguousAlternativeTransformation.pElemName();
    }

    private String rParserLine() {

        return this.mAmbiguousAlternativeTransformation.pParserLine();
    }

    private String rFirstParserChar() {

        return this.mAmbiguousAlternativeTransformation.pFirstParserChar();
    }

    private String rSecondParserChar() {

        return this.mAmbiguousAlternativeTransformation.pSecondParserChar();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(new MSemanticErrorHead().toString());
        sb.append(System.getProperty("line.separator"));
        sb.append("Line: ");
        sb.append(rTreeLine());
        sb.append(System.getProperty("line.separator"));
        sb.append("Char: ");
        sb.append(rTreeChar());
        sb.append(System.getProperty("line.separator"));
        sb.append("The transformation for alternative \"");
        sb.append(rParserAltName());
        sb.append("\" of production \"");
        sb.append(rParserProdName());
        sb.append("\" is ambiguous.");
        sb.append(System.getProperty("line.separator"));
        sb.append("The element \"");
        sb.append(rElemName());
        sb.append("\" at line ");
        sb.append(rTreeLine());
        sb.append(", char ");
        sb.append(rTreeChar());
        sb.append(" match 2 candidate elements at line ");
        sb.append(rParserLine());
        sb.append(", char ");
        sb.append(rFirstParserChar());
        sb.append(" and char  ");
        sb.append(rSecondParserChar());
        sb.append(".");
        sb.append(System.getProperty("line.separator"));
        sb.append("You must define an alternative transformation for alternative \"");
        sb.append(rParserAltName());
        sb.append("\" of production \"");
        sb.append(rParserProdName());
        sb.append("\".");
        sb.append(System.getProperty("line.separator"));
        return sb.toString();
    }

}