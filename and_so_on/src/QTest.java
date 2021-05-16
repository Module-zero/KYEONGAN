import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QTest {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        String str1 = stringConcat(str[0],str[1]);
        String str2 = stringConcat(str[1],str[0]);
        int len1 = str1.length();
        int len2 = str2.length();
        String answer = "";
        if( len1 != len2 ){
            answer = len1 < len2 ? str1 : str2;
        }
        else{
            answer = str1.compareTo(str2) < 0 ? str1 : str2;
        }
        System.out.println(answer);
    }
    public static String stringConcat(String front, String back){
        int bIdx = 0;
        int fLen = front.length();
        int bLen = back.length();
        for(int fIdx = 0 ; fIdx < fLen; fIdx++){
            while(front.charAt(fIdx) == back.charAt(bIdx)){
                fIdx ++;
                bIdx ++;
                if(fIdx >= fLen || bIdx >= bLen)break;
            }
        }
        return front + back.substring(bIdx);
    }
}
