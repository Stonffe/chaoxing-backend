package com.example.exam.utils;

import java.util.Random;

/**
 * @Classname: InviteCodeGenerator
 * @Author: Stonffe
 * @Date: 2024/4/18 16:34
 */
public class InviteCodeGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    /**
     * 定义邀请码长度为6位
     */
    private static final int CODE_LENGTH = 6;

    /**
     * 生成随机邀请码
     *
     * @return
     */
    public static String generateInviteCode() {
        StringBuilder inviteCode = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < CODE_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            inviteCode.append(CHARACTERS.charAt(randomIndex));
        }
        return inviteCode.toString();
    }

    public static void main(String[] args) {
        // 生成一个邀请码示例
        String inviteCode = generateInviteCode();
        System.out.println("Generated Invite Code: " + inviteCode);
    }
}
