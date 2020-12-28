import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q15686 {
    static int N;
    static int M;
    static ArrayList<int[]>home;
    static ArrayList<int[]>chicken;
    static int chickenNum = 0;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        for(int i = 1 ; i <= N ; i ++){
            String[] tmp = bf.readLine().split(" ");
            for(int j = 1 ; j <= N ; j ++){
                int thing = Integer.parseInt(tmp[j-1]);
                if(thing == 2){
                    chicken.add(new int[]{i,j});
                    chickenNum++;
                }
                if(thing == 1){
                    home.add(new int[]{i,j});
                }
            }
        }
        solve(0,new int[M],0);
        System.out.println(min);
    }
    public static void solve(int select, int[] answer, int idx){
        if(select >= M) {
            int sum = 0;
            for(int i = 0 ; i < home.size(); i++){
                int[] tmpHome = home.get(i);
                int tt = Integer.MAX_VALUE ;
                for(int j = 0 ; j < M ; j ++){
                    int[] chick = chicken.get(answer[j]);
                    int val = Math.abs(chick[0]-tmpHome[0]) + Math.abs(chick[1]-tmpHome[1]);
                    tt = Math.min(val,tt);
                }
                sum+= tt;
            }
            min = Math.min(min,sum);
            return ;
        }
        if(idx >= chickenNum){
            return ;
        }
        answer[select] = idx;
        solve(select+1,answer,idx+1);
        solve(select,answer,idx+1);
    }
}
