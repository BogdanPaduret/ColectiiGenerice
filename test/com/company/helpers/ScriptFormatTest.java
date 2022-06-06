package com.company.helpers;

import org.junit.jupiter.api.Test;

class ScriptFormatTest {

    @Test
    public void test() {
        String input = "123.456,789";
        System.out.println("2" + ScriptFormat.toSuperscript(input));
    }

}