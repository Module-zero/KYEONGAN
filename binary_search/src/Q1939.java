import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Q1939 {
    static int n;
    static ArrayList<long[]>[] bridge;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] size = bf.readLine().split(" ");
        n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);
        bridge = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i ++){
            bridge[i] = new ArrayList<>();
        }
        long max = 0;
        for(int i = 0 ; i < m ; i++){
            String[] str = bf.readLine().split(" ");
            long land1 = Long.parseLong(str[0]);
            long land2 = Long.parseLong(str[1]);
            long weight = Long.parseLong(str[2]);
            bridge[(int)land1].add(new long[]{land2,weight});
            bridge[(int)land2].add(new long[]{land1,weight});
            max = Math.max(max,weight);
        }

        String[] land = bf.readLine().split(" ");
        int start = Integer.parseInt(land[0]);
        int end = Integer.parseInt(land[1]);
        long left = 1;
        long right = max;
        boolean[]check = new boolean[n+1];
        long answer = 0;
        while(left <= right) {
            long mid = (left + right) / 2;
            if (dfs(start,end,mid,check)) {
                left = mid + 1;
                answer = Math.max(mid,answer);
            } else {
                right = mid - 1;
            }
            Arrays.fill(check,false);
        }
        System.out.println(answer);

    }
    public static boolean dfs(int start,int end,long weight,boolean[] check){
        if(start == end){
            return true;
        }
        check[start] = true;
        for(long[] i : bridge[start]){
            if(i[1] < weight || check[(int)i[0]])continue;
            if(dfs((int)i[0],end,weight,check)){
                return true;
            }
        }
        return false;
    }
}
