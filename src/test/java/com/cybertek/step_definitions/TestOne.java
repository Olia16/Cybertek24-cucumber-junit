package com.cybertek.step_definitions;

public class TestOne {

    public String reversed(String str){
        String reversed = "";
        for(int i = str.length() - 1; i >= 0; i--){
            reversed += str.charAt(i);
        }
        return reversed;
    }
}
