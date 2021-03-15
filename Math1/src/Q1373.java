import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1373 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        char[] binaryArr = bf.readLine().toCharArray();
        Stack<Character> reverse = new Stack<>();

        for(char gin : binaryArr){
            reverse.push(gin);
        }
        int two = 2;
        int cnt = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        while(!reverse.empty()){
            int num = Integer.parseInt(reverse.pop()+"");
            sum+=num*Math.pow(two,(cnt++%3));
            if(cnt%3 == 0){
                sb.append(sum);
                sum = 0;
            }
        }
        if(cnt%3 != 0){
            sb.append(sum);
        }
        System.out.println(sb.reverse());
    }

}
