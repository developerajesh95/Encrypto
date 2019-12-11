package com.encrypto;

class CommonFunctions {

    static String encrypt(String input) {
        StringBuilder sb = new StringBuilder();
        int j = 1;
        String lastChar = "";
        for (int i = 0; i < input.length(); i++) {
            String charAtI = Character.toString(input.charAt(i));
            if (!lastChar.equalsIgnoreCase(charAtI)) {
                j = 1;
                sb.append(charAtI + j);
                lastChar = charAtI;
            } else {
                j++;
                String substr = sb.toString().substring(0, sb.toString().length() - 2);
                sb.setLength(0);
                sb.append(substr + charAtI + j);
            }
        }
        return sb.toString();
    }

    static String decrypt(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                int digit = Character.getNumericValue(input.charAt(i));
                digit = digit - 1;
                while (digit != 0) {
                    sb.append(input.charAt(i - 1));
                    digit--;
                }
            } else {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

}
