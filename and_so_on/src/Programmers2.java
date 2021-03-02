import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

// 리틀사천성
public class Programmers2 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        String[] str = bf.readLine().split(" ");
        int m = Integer.parseInt(str[0]);
        int n = Integer.parseInt(str[1]);
        String[] board = bf.readLine().split(" ");
        System.out.println(solution(m,n,board));
    }
    public static String solution(int m ,int n , String[] board){
        String answer = "";
        ArrayList<Character> charList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[][] map = new char[m][n];
        int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0 ; i < m ; i ++){
            for(int j = 0 ; j < n ; j++){
                 char word = board[i].charAt(j);
                 map[i][j] = word;
                 if(word != '*' && word != '.' && !charList.contains(word)){
                     charList.add(word);
                 }
            }
        }
        int cnt = charList.size();
        Collections.sort(charList);
        for(int t = 0 ; t < charList.size(); t ++){
            LinkedList<int []> queue = new LinkedList<>();
            char target = charList.get(t);
            int[] tarIdx = new int[2];
            boolean find = false;
            for(int i = 0 ; i < m ; i ++){
                for(int j = 0 ; j < n ; j ++){
                    if(map[i][j] == target){
                        queue.add(new int[]{i,j,4,0});
                        tarIdx[0] = i;
                        tarIdx[1] = j;
                        find = true;
                        // 4 시작 0 상 1 하 2 좌 3 우
                    }
                    if(find){
                        break;
                    }
                }
                if(find){
                    break;
                }
            }
            while(!queue.isEmpty()){
                int[] start = queue.remove();
                boolean remove = false;
                for(int k = 0 ; k < 4 ; k ++){
                    int curI = start[0] + move[k][0];
                    int curJ = start[1] + move[k][1];
                    if(0 > curI || 0 > curJ || curI >= m || curJ >= n)continue;
                    if(curI == tarIdx[0] && curJ == tarIdx[1])continue;
                    if(map[curI][curJ] == '.' || map[curI][curJ] == target) {
                        if (start[2] == 4 || start[3] == 0 || start[2] == k) {
                            if (map[curI][curJ] == target) {
                                map[curI][curJ] = '.';
                                map[tarIdx[0]][tarIdx[1]] = '.';
                                sb.append(target);
                                charList.remove(t);
                                cnt--;
                                remove = true;
                                break;
                            } else {
                                int con = 0;
                                if (start[2] != 4 && start[2] != k) {
                                    con++;
                                }
                                queue.add(new int[]{curI, curJ, k, start[3] + con});
                            }
                        }
                    }
                }
                if(remove){
                    t = -1;
                    break;
                }
            }
        }
        answer = sb.toString();
        return (cnt == 0 ? answer : "IMPOSSIBLE");
    }

}
