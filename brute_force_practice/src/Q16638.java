import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Q16638 {
    static int N ;
    static String modify;
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        N = Integer.parseInt(bf.readLine());
        modify = bf.readLine();
        select(new boolean[N],0,1,new int[N/2]);
        System.out.println(ans);
    }
    public static void select(boolean[] check,int select, int idx, int[] answer){
        if(idx >= N){
            Stack<Integer> stack = new Stack<>();
            for(int i = select-1 ; i >= 0 ; i --){
                stack.push(answer[i]);
            }
            solve(stack);
            return;
        }
        if(!check[idx] && modify.charAt(idx) != '*'){
            check[idx] = true;
            if(idx+2 < N) {
                check[idx + 2] = true;
            }
            answer[select] = idx;
            select(check,select+1,idx+2,answer);
            check[idx] = false;
            if(idx+2 < N) {
                check[idx + 2] = false;
            }
        }
        select(check,select,idx+2,answer);
    }
    public static void solve(Stack<Integer> idx){
        Stack<Integer> num = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for(int i = 0 ; i < N  ; i ++ ){
            char target = modify.charAt(i);
            if(0 <= target-'0' && target-'0' <= 9){
                num.push(target-'0');
            }
            else{
                if(!idx.isEmpty()&&i == idx.peek()){
                    idx.pop();
                    operator.push('(');
                    operator.push(target);
                    operator.push(')');
                }
                else if(target == '*'){
                    while(!operator.isEmpty()){
                        if(operator.peek() == ')'){
                            operator.pop(); // ) 빠짐
                            int b = num.pop();
                            int a = num.pop();
                            num.push(calc(operator.pop(),a,b)); // 괄호 안에 연산자 빠짐
                            operator.pop(); // ( 빠짐
                        }
                        else{
                            break;
                        }
                    }
                    operator.push(target);
                }
                else{
                    while(!operator.isEmpty()){
                        if(operator.peek() == ')'){
                            operator.pop(); // ) 빠짐
                            int b = num.pop();
                            int a = num.pop();
                            num.push(calc(operator.pop(),a,b)); // 괄호 안에 연산자 빠짐
                            operator.pop(); // ( 빠짐
                        }
                        else if(operator.peek() == '*'){
                            int b = num.pop();
                            int a = num.pop();
                            num.push(calc(operator.pop(),a,b)); // * 빠짐
                        }
                        else{
                            break;
                        }
                    }
                    operator.push(target);
                }
            }
        }
        while(!operator.isEmpty()){
            if(operator.peek()==')') {
                operator.pop();
                int b = num.pop();
                int a = num.pop();
                num.push(calc(operator.pop(), a, b));
                operator.pop();
            } else if (operator.peek() == '*') {
                int b = num.pop();
                int a = num.pop();
                num.push(calc(operator.pop(), a, b));
            }
            else{
                break;
            }
        }
        LinkedList<Integer> tmpNum = new LinkedList<>();
        LinkedList<Character> tmpOp = new LinkedList<>();
        while(!operator.isEmpty()){
            tmpOp.addFirst(operator.pop());
            tmpNum.addFirst(num.pop());
        }
        tmpNum.addFirst(num.pop());
        while(!tmpOp.isEmpty()){
            int a = tmpNum.remove(0);
            int b = tmpNum.remove(0);
            tmpNum.addFirst(calc(tmpOp.remove(0),a,b));
        }
        int tmp = tmpNum.pop();
        ans = Math.max(ans,tmp);
    }
    public static int calc(char oper, int a, int b){
        int ans = 0;
        switch(oper){
            case '+': ans = a + b;break;
            case '*': ans = a * b;break;
            case '-': ans = a - b;break;
            default: break;
        }
        return ans;
    }
}
