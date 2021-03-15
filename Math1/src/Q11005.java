import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q11005 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        long n = Long.parseLong(strArr[0]);
        long b = Long.parseLong(strArr[1]);

        String sb = convert(n,b);
        System.out.println(sb);
    }

    public static String convert(long n,long b){
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        while(n != 0){
            int r = Integer.parseInt(n%b+"");
            stack.push(r);
            n/=b;
        }
        while(!stack.empty()){
            int num = stack.pop() ;
            if(num > 9 ){
                sb.append((char)(num+55));
            }
            else{
                sb.append(num);
            }
        }
        return sb.toString();
    }

}
