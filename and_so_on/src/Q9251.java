import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9251 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str1 = bf.readLine();
        String str2 = bf.readLine();
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] arr = new int[len1][len2];
        for(int i = 0 ; i < len1 ; i ++){
            char target = str1.charAt(i);
            int num = 0;
            for(int j = 0 ; j < len2 ; j ++){
                char comp = str2.charAt(j);
                if(comp == target){

                }
            }
        }
    }
}
