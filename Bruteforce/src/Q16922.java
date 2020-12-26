import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Q16922 {
    static int n;
    static int[] num = {1,5,10,50};
    static TreeSet<Integer> answer ;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        n = Integer.parseInt(bf.readLine());
        answer = new TreeSet<>();
        select(0,0,0);
        System.out.println(answer.size());
    }
    public static void select(int cnt,int idx,int ans){
        if(idx == 4 || cnt == n){
            if(cnt == n) {
                answer.add(ans);
            }
            return;
        }
        select(cnt+1,idx,ans+num[idx]);
        select(cnt,idx+1,ans);
    }
}
