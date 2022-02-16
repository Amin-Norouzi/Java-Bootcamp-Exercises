package com.aminnorouzi.banksystem.helper;

import java.util.Random;

public class StringUtils {

    public static String getRandomInt(int count) {
        StringBuilder str = new StringBuilder();
        while (str.length() < count) {
            str.append(new Random().nextInt(10));
        }
        return str.toString();
    }
}
