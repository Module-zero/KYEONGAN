import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q4902 {
    static long answer;
    static int line;
    static ArrayList<Integer>[] triangle;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        int t = 1;
        while(true){
            answer = Integer.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(bf.readLine());
            line = Integer.parseInt(st.nextToken());
            if(line == 0)break;
            triangle = new ArrayList[line+1];
            for(int i = 1 ; i <= line ; i ++){
                triangle[i] = new ArrayList<>();
            }
            int curLine = 1;
            int cnt = 0;
            int[][] dp = new int[line+1][2*line];
            while(curLine <= line){
                int num = Integer.parseInt(st.nextToken());
                triangle[curLine].add(num);
                dp[curLine][cnt+1] = dp[curLine][cnt] + num;
                cnt ++ ;
                if((2 * curLine) - 1 <= cnt){
                    curLine++;
                    cnt = 0;
                }
            }
            for(int i = 1 ; i <= line ; i ++){
                for(int j = 1 ; j <= triangle[i].size();j++){
                    search(dp,i,j);
                }
            }
            System.out.println(t+". "+answer);
            t++;
        }
    }
    public static void search(int[][] dp,int startI,int startJ){
        long tmpAns = 0 ;
        int deep = startI;
        int width = startJ;
        int tmpStart = startJ;
        while (true) {
            tmpAns += (dp[deep][width] - dp[deep][tmpStart - 1]);
            if (answer < tmpAns) {
                answer = tmpAns;
            }
            if(startJ %2 != 0) {
                deep++;
                width += 2;
            }
            else{
                deep --;
                tmpStart -=2;
            }

            if (deep <= 0 || deep > line || tmpStart <= 0 || width > triangle[deep].size()) break;
        }
    }
    public static void print(ArrayList<Integer>[] triangle){
        for(int i = 1 ; i <= line ; i ++){
            for(int j = 0 ; j < triangle[i].size(); j ++){
                System.out.print(triangle[i].get(j)+" ");
            }
            System.out.println(" ");
        }
    } 
}
