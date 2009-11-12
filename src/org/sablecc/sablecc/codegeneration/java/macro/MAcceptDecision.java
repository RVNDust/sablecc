/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.sablecc.codegeneration.java.macro;

public class MAcceptDecision {

    private final String pElementName;

    private final MAcceptDecision mAcceptDecision = this;

    MAcceptDecision(
            String pElementName) {

        if (pElementName == null) {
            throw new NullPointerException();
        }
        this.pElementName = pElementName;
    }

    String pElementName() {

        return this.pElementName;
    }

    private String rElementName() {

        return this.mAcceptDecision.pElementName();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("      // dummy test to fool the Java compiler");
        sb.append(System.getProperty("line.separator"));
        sb.append("      if(l");
        sb.append(rElementName());
        sb.append(" != null) {");
        sb.append(System.getProperty("line.separator"));
        sb.append("        return l");
        sb.append(rElementName());
        sb.append(";");
        sb.append(System.getProperty("line.separator"));
        sb.append("      }");
        sb.append(System.getProperty("line.separator"));
        return sb.toString();
    }

}
