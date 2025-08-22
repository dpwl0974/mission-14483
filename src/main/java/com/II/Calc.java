package com.II;

public class Calc {
    public static int run(String s) {
        String expr = s.replace(" ",""); //1+1

        for(int i = expr.length() - 1; i >= 0; i--) {
            char c = expr.charAt(i);

            if (isOp(c)) {
                // 단항 +/− 는 스킵: 문장의 처음이거나, 앞문자가 연산자면 단항
                if ((c == '+' || c == '-') && (i == 0 || isOp(expr.charAt(i - 1)))) {
                    continue;
                }

                String left  = expr.substring(0, i);
                String right = expr.substring(i + 1);

                int leftNum = run(left);
                int rightNum = run(right);

                if(c == '+' ) return  (leftNum + rightNum);
                else if(c == '-' ) return  (leftNum - rightNum);
                return  leftNum * rightNum;
            }
        }
        return Integer.parseInt(expr);
    }

    private static boolean isOp(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}
