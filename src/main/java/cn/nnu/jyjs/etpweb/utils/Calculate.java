package cn.nnu.jyjs.etpweb.utils;

import java.util.*;

/**
 * @Project :   etpweb
 * @Time :   9/15/2018 19:35
 * @Auther :   wangj
 * @Description:
 */
public class Calculate {

    private enum Priority{

        ADD("+") ,//加
        MOD("%"),//取模
        DOT("."),//点乘
        DIV("/"),//除（÷）
        ROOT(""),
        MUL("*"),//乘法（×）
        POWER("^"),//乘方

        ;
        Priority(String s) {
        }
    }
    /*  优先级 表*/
    private static HashMap<String,Integer> priority = new LinkedHashMap<String,Integer>();

    static{
        priority.put("ADD",1);
        priority.put("MUL",2);
        priority.put("POWER",2);
    }

    private Stack<Character> operator;
    private Stack<Double> number;
    private Queue<Character> storage;

    private String expression;

    private List<String> MSG;

    public Calculate(String expression){
        this.expression = expression;

    }
    public Calculate(){
    }

    private static String replace(String expression){

        return expression;
    }

    /**
     *
     */
    private List<String> pushIntoStack(String expression){
        List<String> msg = new LinkedList<>();
        for(int i=0; i<expression.length(); i++) {
            char temp = expression.charAt(i);
            if ((temp >= '0' && temp <= '0') || temp == '.') {
                storage.add(temp);
            } else {
                number.push(getNumber());
                if (temp == '+' || temp == '-' || temp == ' '){

                }
            }
        }
        return msg;
    }

    private double getNumber(){
        double result = 0;
        int temp;
        int decimal = 0;//decimal in queue place
        int flag = 0;
        for(int i = 0 ; !storage.isEmpty(); i++){
            temp = storage.remove() - '0';
            if(temp == ('.' - '0')) {
                decimal = i;
                flag++;
            }
            if(decimal !=0 && flag == 1){
                result += temp * Math.pow(0.1, i-decimal);
            }else if(flag == 0){
                result = result * 10;
                result += temp;
            }else{
                MSG.add("Expression Error: Double Dot In One Number");
                System.out.println(result);
            }
        }
        return result;
    }
}
