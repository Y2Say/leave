package com.yj2.leave.util;

import java.util.Random;

/**
 * 生成随机ID
 */
public class UUIDUtil {

    private static Random strGen = new Random();;
    private static char[] numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();;
    /** * 产生随机字符串 * */
    public static final String randomString() {
        //生成32位随机字符
        char[] randBuffer = new char[32];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = numbersAndLetters[strGen.nextInt(61)];
        }
        return new String(randBuffer);
    }

}
