package com.HZ_A9.utils;

import java.util.regex.Pattern;

public class checkFormat {
    public boolean checkStudent(String username){
        String pattern = "student_.*";
        boolean isMatch  = Pattern.matches(pattern,username);
        return isMatch;
    }
    public boolean checkTeacher(String username){
        String pattern = "teacher_.*";
        boolean isMatch  = Pattern.matches(pattern,username);
        return isMatch;
    }
    public boolean checkCoursr(String courseNo){
        String pattern = "NJUPT-..-..-..";
        boolean isMatch  = Pattern.matches(pattern,courseNo);
        return isMatch;
    }
}
