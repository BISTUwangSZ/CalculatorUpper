package com.example.yoyo.calculatorupper;

import java.util.Stack;

/**
 * Created by Cathleen on 2016/9/9.
 */
public class Calculators {

    public static String calculate(String equation) {
        Double num1, num2;
        num1 = num2 = 1.0;
        Stack<Double> numStack = new Stack<Double>();// 存放数的栈
        Stack<Character> charStack = new Stack<Character>();// 存放符号的栈
        //sin
        if ('s' == equation.charAt(equation.length() - 1)) {
            num1 = Math.sin(Double.parseDouble(equation.substring(0, equation.length()-1))*Math.PI/180);
        }
        //cos
        else if ('c' == equation.charAt(equation.length() - 1)) {
            num1 = Math.cos(Double.parseDouble(equation.substring(0, equation.length()-1))*Math.PI/180);
        }
        //tan
        else if ('t' == equation.charAt(equation.length() - 1)) {
            num1 = Math.tan(Double.parseDouble(equation.substring(0, equation.length()-1))*Math.PI/180);
        }
        else {
            for (int i = 1, mark = 0; i < equation.length(); i++) {
                if ('.' == equation.charAt(i)) {
                    continue;
                }
                if ('0' > equation.charAt(i) || '9' < equation.charAt(i)) {
                    numStack.push(Double.parseDouble(equation.substring(0, i)));
                    if (1 == mark) {
                        // 计算乘法
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        numStack.push(num2 * num1);
                        mark = 0;
                    } else if (2 == mark) {
                        // 计算除法
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        numStack.push(num2 / num1);
                        mark = 0;
                    } else if (3 == mark) {
                        // 计算次幂
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        numStack.push(Math.pow(num2, num1));
                        mark = 0;
                    } else if (4 ==mark) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        numStack.push(num2*Math.sqrt(num1));
                        mark = 0;
                    }
                    // 遇到下面前5个符号则先计算，遇到等号则结束计算
                    if ('*' == equation.charAt(i)) {
                        mark = 1;
                    } else if ('/' == equation.charAt(i)) {
                        mark = 2;
                    } else if ('^' == equation.charAt(i)) {
                        mark = 3;
                    } else if ('√' == equation.charAt(i)){
                        mark = 4;
                    } else if ('=' == equation.charAt(i)) {
                        break;
                    }  else {
                        charStack.push(equation.charAt(i));
                    }
                    equation = equation.substring(i + 1);
                    i = 0;
                }
            }
            while (!charStack.empty()) {
                if ('+' == charStack.pop()) {
                    // 计算加法
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    numStack.push(num1 + num2);
                } else {
                    // 计算减法
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    numStack.push(num2 - num1);
                }
            }
            // 最后剩下结果
            return numStack.pop().toString();
        }
        return num1.toString();
    }


}
