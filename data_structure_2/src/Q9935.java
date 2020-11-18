import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9935 {
    public static void main(String[] args)throws Exception{
    //        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String str = bf.readLine();
        String boom = bf.readLine();
        int boomNum = boom.length();
        Stack<int[]> stack = new Stack<>();
        for(int i = 0 ; i < str.length(); i ++){
            char target = str.charAt(i);
            if(target == boom.charAt(0)){
                stack.push(new int[]{i,1});
            }
            else{
                int compNum = 0;
                if(!stack.isEmpty()){
                    compNum = stack.peek()[1];
                }
                if(compNum == 0){
                    stack.push(new int[]{i,0});
                }
                else{
                    int stackNum = stack.peek()[1];
                    if(target == boom.charAt(stackNum)){
                        stackNum = stackNum+1 > boomNum ? boomNum : stackNum+1;
                        stack.push(new int[]{i,stackNum});
                    }
                    else{
                        stack.push(new int[]{i,0});
                    }
                }
            }
            if(stack.peek()[1] == boomNum){
                while(stack.pop()[1] != 1);
            }
        }
        Stack<Integer> reverse = new Stack<>();
        while(!stack.isEmpty()){
            reverse.push(stack.pop()[0]);
        }
        StringBuilder sb = new StringBuilder();
        while(!reverse.isEmpty()){
            sb.append(str.charAt(reverse.pop()));
        }
        if(sb.length() == 0){
            System.out.println("FRULA");
        }
        else {
            System.out.println(sb);
        }
    }
}
