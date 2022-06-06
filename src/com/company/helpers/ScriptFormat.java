package com.company.helpers;

public class ScriptFormat {

    public static String toSuperscript(String input) throws NumberFormatException {
        int size = input.length();

        String output = "";
        for (int i = 0; i < size; i++) {
            char c = input.charAt(i);
            output += toSuperscript(c);
        }

        return output;
    }
    public static char toSuperscript(char input) throws NumberFormatException {
        switch (input) {
            default:
                throw new NumberFormatException("invalid character");
            case '0':
                return '\u2070';
            case '1':
                return '\u00b9';
            case '2':
                return '\u00b2';
            case '3':
                return '\u00b3';
            case '4':
                return '\u2074';
            case '5':
                return '\u2075';
            case '6':
                return '\u2076';
            case '7':
                return '\u2077';
            case '8':
                return '\u2078';
            case '9':
                return '\u2079';
            case 'i':
                return '\u2071';
            case '+':
                return '\u207a';
            case '-':
                return '\u207b';
            case '=':
                return '\u207c';
            case '(':
                return '\u207d';
            case ')':
                return '\u207e';
            case 'n':
                return '\u207f';
            case '.':
            case ',':
                return '\u22c5';
        }

    }

}
