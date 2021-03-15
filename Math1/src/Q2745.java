import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q2745 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        char[] num = strArr[0].toCharArray();
        int b = Integer.parseInt(strArr[1]);
        int strLength = num.length-1;
        int answer = 0;
        for(char str : num){
            int tmp = str >= 65 ? str - 55 : Integer.parseInt(str+"");
            answer += tmp*Math.pow(b,strLength--);
        }
        System.out.println(answer);
        //
    }
}
