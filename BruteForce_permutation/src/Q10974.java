import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q10974 {
    static int num;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        num = Integer.parseInt(bf.readLine());
        boolean[] check = new boolean[num+1];
        StringBuilder sb = new StringBuilder();
        int[] answer = new int[num];
        select(check,sb,0,answer);
        System.out.println(sb);
    }
    public static void select(boolean[] check, StringBuilder sb, int cnt, int[] answer){
        if(cnt >= num){
            for(int answerNum : answer){
                sb.append(answerNum+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1 ; i <= num; i ++){
            if(!check[i]){
                check[i] = true;
                answer[cnt] = i;
                select(check,sb,cnt+1,answer);
                check[i] = false;
            }
        }
    }
}
