import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A {
    static int N;
    static int ans;
    static ArrayList<String>[] list;
    static int zIdx;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        N = Integer.parseInt(bf.readLine());
        zIdx = 'z'-'a';
        list = new ArrayList[zIdx+1];
        for(int i = 0 ; i <= zIdx ; i ++){
            list[i] = new ArrayList<>();
        }
        boolean[][] check = new boolean[zIdx+1][100];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i < N ; i ++){
            String tmp = st.nextToken();
            char start = tmp.charAt(0);
            list[start-'a'].add(tmp);
        }
//        for(int i = 0 ; i <= zIdx ; i ++){
//            System.out.print((char)(i+'a')+"] ");
//            for(String str : list[i]){
//                System.out.print(str+" ");
//            }
//            System.out.println("");
//        }
        for(int i = 0 ; i <= zIdx ; i ++){
            if(list[i].isEmpty())continue;
            for(int j = 0 ; j < list[i].size(); j ++){
                String target = list[i].get(j);
                int sure = target.charAt(target.length()-1)-'a';
                if(list[sure].isEmpty())continue;
                check[i][j] = true;
                solve(target,1,check);
                if(ans == 1){
                    break;
                }
                check[i][j] = false;
            }
            if(ans == 1){
                break;
            }
        }
        System.out.println(ans);
    }
    public static void solve(String before,int select,boolean[][] check){
        if(select >= N){
            ans = 1;
            return ;
        }
        int end = before.charAt(before.length()-1) - 'a';
        if(!list[end].isEmpty()){
            for(int i = 0 ; i < list[end].size(); i ++){
                if(check[end][i])continue;
                check[end][i] = true;
                String target = list[end].get(i);
                solve(target,select+1,check);
                if(ans == 1){
                    return;
                }
                check[end][i] = false;
            }
        }
    }
}
