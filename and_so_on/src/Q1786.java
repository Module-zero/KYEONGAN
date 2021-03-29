import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1786 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] T = bf.readLine().toCharArray();
        char[] P = bf.readLine().toCharArray();
        int pl = P.length;
        int[] fail = new int[pl];
        failFunction(P,fail);
        solve(P,T,fail);
    }
    public static void solve(char[] P , char[] T, int[] fail){
        int pl = P.length;
        int tl = T.length;
        int answer = 0 ;
        StringBuilder sb = new StringBuilder();
        int pIdx = 0 ;
        for(int i = 0 ; i < tl ; i ++){
            if(P[pIdx] == T[i]){
                if(pIdx == pl-1){
                    answer++;
                    sb.append((i - pIdx + 1)).append(" ");
                    pIdx = fail[pIdx];
                }
                else{
                    pIdx ++;
                }
            }
            else{
                while(pIdx > 0 && T[i] != P[pIdx]){
                    pIdx = fail[pIdx-1];
                }
                if(T[i] == P[pIdx]){
                    pIdx ++;
                }
            }
        }
        System.out.println(answer);
        System.out.println(sb.toString());
    }
    public static void failFunction(char[] P,int[] fail){
        int j = 0 ;
        int pl = P.length;
        for(int i = 1 ; i < pl ; i ++){
            while(j > 0 && P[i] != P[j]){
                j = fail[j-1];
            }
            if(P[j] == P[i]){
                j ++;
                fail[i] = j;
            }
            else{
                fail[i] = 0;
            }
        }
    }

}
