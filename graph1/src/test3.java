import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Inet4Address;
import java.util.Stack;

public class test3 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        String[] strArr = new String[n];
        for(int i = 0 ; i < n ; i ++){
            strArr[i] = bf.readLine();
        }
        solution(n,strArr);
    }
    public static void solution(int numOfOrder,String[] orderArr){
        Stack<Character> repeat = new Stack<>();
        Stack<String> oper = new Stack<>();
        Stack<String> printStack = new Stack<>();

        for(int i = 0 ; i < numOfOrder ; i ++){
            for(int j = 0 ; j < orderArr[i].length() ; j ++){
                char ch = orderArr[i].charAt(j);
                switch (ch){
                    case '(':
                        repeat.push(oper.pop().charAt(0));
                        oper.push(ch+"");
                        break;
                    case ')':
                        while(!oper.isEmpty()){
                            if(oper.peek().equals("(")){
                                oper.pop();
                                break;
                            }
                            printStack.push(oper.pop());
                        }
                        if( (repeat.peek()-'0') >=1 && (repeat.peek()-'0') <= 9 ){
                            int num = repeat.pop()-'0';
                            String tmp = "";
                            String tmp1 ="";
                            while(!printStack.isEmpty()){
                                tmp+=printStack.pop();
                            }
                            for(int k = 0 ; k < num ;  k++){
                                tmp1 += tmp;
                            }
                            oper.push(tmp1);
                        }
                        else{
                            char top = repeat.pop();
                            String tmp = "";
                            while(!printStack.isEmpty()){
                                tmp = tmp+top+printStack.pop();
                            }
                            oper.push(tmp);
                        }
                        break;
                    default:
                        if(!oper.isEmpty()) {
                            int confirm = oper.peek().charAt(0)-'0';
                            if(0<=confirm && confirm <= 9) {
                                int num = Integer.parseInt(oper.pop());
                                String tmp = "";
                                for (int k = 0; k < num; k++) {
                                    tmp += ch;
                                }
                                oper.push(tmp);
                                break;
                            }
                        }
                        oper.push(ch+"");
                        break;
                }
            }
            String tmp="";
            while(!oper.isEmpty()){
                printStack.push(oper.pop());
            }
            while(!printStack.isEmpty()){
                tmp += printStack.pop();
            }
            System.out.println(tmp);
        }
    }
}
