package com.HZ_A9.utils;

import java.util.ArrayList;

public class checkChoice {
    public boolean checkLoginChoice(String choice){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        if(strings.contains(choice)){
            return true;
        }
        return false;
    }
}
