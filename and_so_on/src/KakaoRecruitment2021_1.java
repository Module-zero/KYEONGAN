import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class KakaoRecruitment2021_1 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        String str = bf.readLine();
        System.out.println(solution(str));
    }

    public static String solution(String new_id){
        String answer = "";
        String tmp = new_id.toLowerCase();
        tmp = tmp.replaceAll("[^-_.a-z0-9]","");
        tmp = tmp.replaceAll("[.]{2,}",".");
        tmp = tmp.replaceAll("^[.]|[.]$","");
        StringBuilder sb = new StringBuilder(tmp);
        if(sb.toString().equals("")){
            sb.append("a");
        }
        while(sb.length() < 3){
            sb.append(sb.charAt(sb.length()-1));
            tmp = sb.toString();
        }
        if( tmp.length() >= 16){
            tmp = tmp.substring(0,15);
            tmp = tmp.replaceAll("^[.]|[.]$","");
        }
        answer = tmp;
        return answer;
    }

//    public static String solution(String new_id){
//        String answer = "";
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0 ; i < new_id.length(); i ++){
//            char target = new_id.charAt(i);
//            if(('0' <= target && target <= '9') || ( 'a' <= target && target <= 'z') || target == '-' || target == '_' ){
//                sb.append(target);
//            }
//            else if( 'A' <= target && target <= 'Z'){
//                target = (char)(target + ('a'-'A'));
//                sb.append(target);
//            }
//            else if( target == '.'){
//                if(sb.length() != 0 && sb.charAt(sb.length()-1) != '.'){
//                    sb.append(target);
//                }
//            }
//            if(sb.length() > 14){
//                break;
//            }
//        }
//        int l = sb.length();
//        if(l != 0 && sb.charAt(l-1) == '.'){
//            sb.deleteCharAt(sb.length()-1);
//        }
//        if(sb.length() == 0){
//            sb.append('a');
//        }
//        while(sb.length() < 3){
//            char t = sb.charAt(sb.length()-1);
//            sb.append(t);
//        }
//        answer = sb.toString();
//        return answer;
//    }
}
