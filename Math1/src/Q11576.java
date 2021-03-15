import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q11576 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        int a = Integer.parseInt(strArr[0]);
        int b = Integer.parseInt(strArr[1]);

        int m = Integer.parseInt(bf.readLine());

        String[] strNumArr = bf.readLine().split(" ");
        int dec = 0 ;
        for(String str : strNumArr){
            dec += Integer.parseInt(str) * Math.pow(a,--m);
        }
        Stack<Integer> stack = new Stack<>();
        while(dec != 0){
            int r = dec%b;
            stack.push(r);
            dec/=b;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop()+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
        //
    }


}
