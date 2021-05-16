import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9251 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str1 = bf.readLine();
        String str2 = bf.readLine();
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] LCS = new int[len1+1][len2+1];
        int max = 0;
        for( int i = 1 ; i <= len1 ; i ++){
            char target = str1.charAt(i-1);

            for(int j = 1 ; j <= len2 ; j++){
                if(target == str2.charAt(j-1)){
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                }
                else{
                    LCS[i][j] = Math.max(LCS[i-1][j],LCS[i][j-1]);
                }
                max = Math.max(LCS[i][j],max);
            }
        }
        System.out.println(max);
    }
}
