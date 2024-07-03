package com.takeaway.case_study.util;

public class StringUtils {

    public static String convertToSentenceCase(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
