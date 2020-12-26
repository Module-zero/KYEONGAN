import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q16968 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String str = bf.readLine();
        int ans = 1;
        for(int i = 0 ; i < str.length(); i ++){
            if(str.charAt(i) == 'c'){
                if(i == 0 || i != 0 && str.charAt(i-1) != 'c'){
                    ans *= 26;
                }
                else{
                    ans *= 25;
                }
            }
            else {
                if (i == 0 || i != 0 && str.charAt(i - 1) != 'd') {
                    ans *= 10;
                } else {
                    ans *= 9;
                }
            }
        }
        System.out.println(ans);
    }
}
