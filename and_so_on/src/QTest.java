import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 *  두 문자열이 주어질 때 두 문자열의 공통 부분을 합쳐 이어 붙인 문자열 중 길이가 가장 짧은 문자열을 반환하라 (단, 길이가 같은 문자열이 여러개일 경우
 * 그 중 사전순으로 가장 먼저 위치하는 문자열을 반환 할 겻)
 * 예1 ) AxA, AyA 일 경우 AxAyA 출력
 * 예2 ) abcXY XYZa 일 경우 abcXYZa 출력
 *
 * */
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
