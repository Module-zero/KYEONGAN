import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1541 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        char[] charArr = bf.readLine().toCharArray();
        Stack<Integer> num = new Stack<>();
        Stack<Character> oper = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c : charArr){
            if(c == '+' || c == '-'){
                oper.push(c);
                num.push(Integer.parseInt(sb.toString()));
                sb = new StringBuilder();
            }
            else {
                sb.append(c);
            }
        }
        num.push(Integer.parseInt(sb.toString()));
        int tmp = 0 ;
        while(!num.isEmpty()){
            int tmpNum = num.pop();
            char tmpOper;
            if(!oper.isEmpty()){
                tmpOper = oper.pop();
                if(tmpOper == '+'){
                    if(!num.isEmpty()){
                        num.push(tmpNum + num.pop());
                    }
                }
                else{
                    tmp += (tmpNum*(-1));
                }
            }
            else{
                tmp += (tmpNum);
                break;
            }
        }
        System.out.println(tmp);
    }
}
