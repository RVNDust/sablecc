/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.sablecc.codegeneration.java.macro;

import java.util.LinkedList;
import java.util.List;

public class MTransitionState {

    private final List<Object> eDefaultPackage_SpecifiedPackage = new LinkedList<Object>();

    public MTransitionState() {

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
        sb.append("abstract class TransitionState");
        sb.append(System.getProperty("line.separator"));
        sb.append("    extends State {");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("  abstract void setMarker(Lexer lexer);");
        sb.append(System.getProperty("line.separator"));
        sb.append("  abstract State getTarget(Symbol symbol);");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("  StateType getStateType() {");
        sb.append(System.getProperty("line.separator"));
        sb.append("    return State.StateType.TRANSITION;");
        sb.append(System.getProperty("line.separator"));
        sb.append("  }");
        sb.append(System.getProperty("line.separator"));
        sb.append("}");
        sb.append(System.getProperty("line.separator"));
        return sb.toString();
    }

}
