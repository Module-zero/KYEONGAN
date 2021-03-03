import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Programmers3 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        String str = bf.readLine();
        System.out.println(solution(str));
    }
    public static int solution(String s){
        int answer = 1 ;
        int minL = 0 ;
        int maxR = s.length()-1;
        while(minL != maxR){
            int l = minL;
            int r = maxR;
            boolean success = true;
            while(l < r){
                if(s.charAt(l) != s.charAt(r)){
                    success = false;
                    break;
                }
                l++;
                r--;
            }
            if(success){
                answer = maxR - minL + 1;
                break;
            }
            if(maxR + 1 == s.length()){
                maxR = maxR - minL - 1;
                minL = 0;
            }
            else{
                maxR ++;
                minL ++;
            }
        }
        return answer;
    }
}
