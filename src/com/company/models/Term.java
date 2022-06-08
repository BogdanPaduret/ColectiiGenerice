package com.company.models;

import com.company.helpers.ScriptFormat;

public class Term implements Comparable<Term> {

    private int coefficient;
    private int power;

    public Term(int coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    public int getCoefficient() {
        return coefficient;
    }
    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }

    public Term multiply(Term term) {
        return new Term(this.getCoefficient() * term.getCoefficient(), this.getPower() + term.getPower());
    }

    @Override
    public boolean equals(Object o) {
        Term term = (Term) o;
        return this.getPower() == term.getPower() &&
                this.getCoefficient() == term.getCoefficient();
    }

    @Override
    public int compareTo(Term o) {
        Integer thisPower = this.getPower();
        Integer oPower = o.getPower();
//        Integer thisCoef = this.getCoefficient();
//        Integer oCoef = o.getCoefficient();
//
//        if (thisCoef == 0 || oCoef == 0 || thisPower == oPower) {
//            return thisCoef.compareTo(oCoef);
//        }


        return thisPower.compareTo(oPower);
    }
    public int comparePower(Term o) {
        Integer thisPower = this.getPower();
        Integer oPower = o.getPower();

        return thisPower.compareTo(oPower);
    }

    @Override
    public String toString() {
        String coef = coefficient + "x";
        if (coefficient == 1) {
            coef = "x";
        } else if (coefficient == -1) {
            coef = "-x";
        }

        return coef + ScriptFormat.toSuperscript(power + "");
    }
    public String toStringNo0() {
        if (coefficient == 0) {
            return "";
        }
        return toString();
    }
}
