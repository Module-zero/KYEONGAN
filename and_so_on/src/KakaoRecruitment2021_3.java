import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class KakaoRecruitment2021_3 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        String[] info = bf.readLine().split(",");
        String[] query = bf.readLine().split(",");
        for(int i : Solution.solution(info,query)){
            System.out.print(i+" ");
        }
    }
    static class Solution {
        static ArrayList<Integer>[][][][] list = new ArrayList[4][3][3][3];

        public static int[] solution(String[] info, String[] query) {
            int[] answer = {};
            init();
            for(int i = 0 ; i < info.length; i++){
                String[] target = info[i].split(" ");
                insertScore(target);
            }
//            print();
            int[] count = new int[query.length];
            for(int t = 0; t < query.length ; t++){
                count[t] = countInfo(query[t]);
            }
            answer = count;
            return answer;
        }
        public static void print(){
            for(int i = 0 ; i < 4 ; i ++){
                for(int ii = 0 ; ii < 3 ; ii ++){
                    for(int iii = 0 ; iii < 3 ; iii ++){
                        for(int iiii = 0 ; iiii < 3 ; iiii++){
                            System.out.println((list[i][ii][iii][iiii])+" ");
                        }
                        System.out.println(" ");
                    }
                    System.out.println(" ");
                }
                System.out.println(" ");
            }
        }
        public static int countInfo(String q){
            String[] target = q.replace(" and "," ").split(" ");
            int[] qArr = new int[5];
            qArr[0] = getNumber(target[0]);
            qArr[1] = getNumber(target[1]);
            qArr[2] = getNumber(target[2]);
            qArr[3] = getNumber(target[3]);
            qArr[4] = Integer.parseInt(target[4]);
            ArrayList<Integer> value = list[qArr[0]][qArr[1]][qArr[2]][qArr[3]];
            Collections.sort(value);
            int left = 0 ;
            int right = value.size();
            while(left < right){
                int mid = (left+right)/2;
                if(value.get(mid) < qArr[4]){
                    left = mid + 1;
                }
                else{
                    right = mid;
                }
            }
            return value.size() - right;
        }

        public static void insertScore(String[] target){
            int[] application = new int[5];
            application[0] = getNumber(target[0]);
            application[1] = getNumber(target[1]);
            application[2] = getNumber(target[2]);
            application[3] = getNumber(target[3]);
            application[4] = Integer.parseInt(target[4]);
            _insert(application,new int[4],0,0);
        }

        public static void _insert(int[] application,int[] ans, int idx, int cnt){
            if(idx >= 4){
                int[] tmp = application.clone();
                for(int a = 0 ; a < application.length; a++){
                    tmp[a] = application[a];
                }
                for(int i = 0 ; i < cnt; i ++){
                    tmp[ans[i]] = 0;
                }
                for(int i = 0 ; i < 4 ; i ++){
                    System.out.print(tmp[i]+" ");
                }
                System.out.println(" ");
                list[tmp[0]][tmp[1]][tmp[2]][tmp[3]].add(tmp[4]);
                return ;

            }
            _insert(application,ans,idx+1,cnt);
            ans[cnt] = idx;
            _insert(application,ans,idx+1,cnt+1);
        }

        public static int getNumber(String str){
            int res;
            switch(str){
                case "cpp":
                case "backend":
                case "junior":
                case "chicken":
                    res = 1 ;
                    break;
                case "java":
                case "frontend":
                case "senior":
                case "pizza":
                    res = 2;
                    break;
                case "python":
                    res = 3;
                    break;
                default:
                    res = 0;
                    break;
            }
            return res;
        }

        public static void init(){
            for(int i = 0 ; i < 4 ; i ++){
                for(int ii = 0 ; ii < 3 ; ii ++){
                    for(int iii = 0 ; iii < 3 ; iii ++){
                        for(int iiii = 0 ; iiii < 3 ; iiii++){
                            list[i][ii][iii][iiii] = new ArrayList<>();
                        }
                    }
                }
            }
        }
    }
}
