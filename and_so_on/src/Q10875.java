import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10875 {
    static class Command{
        int t;
        char direction;
        public Command(int t, char direction){
            this.t = t;
            this.direction = direction;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[][] move = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};

        int L = Integer.parseInt(bf.readLine());
        int size = 2*L+1;
        int[][] map = new int[size][size];
        map[L][L] = 1;
        int N = Integer.parseInt(bf.readLine());
        Command[] commands = new Command[N];
        for(int i = 0 ; i < N ; i ++){
            String[] str = bf.readLine().split(" ");
            commands[i] = new Command(Integer.parseInt(str[0]),str[1].charAt(0));
        }

        int cIdx = 0; // 커맨드 인덱스
        int ans = 0;  // 뱀의 생존시간
        int turn = 0; // 회전 시 초기화
        int curDirection = 2; // 현재 뱀의 이동 방향
                              // 0 : 좌, 1: 상, 2: 우, 3: 하
        int curI = L;         // 현재 뱀의 위치
        int curJ = L;         // 현재 뱀의 위치
        while(cIdx < N){
            turn ++;
            ans ++;
            curI = curI + move[curDirection][0];
            curJ = curJ + move[curDirection][1];
            if(0 > curI || 0 > curJ || curI >= size || curJ >= size)break;
            if(map[curI][curJ] == 1)break;
            map[curI][curJ] = 1;
            if(commands[cIdx].t == turn){
                turn = 0;
                curDirection = calc(curDirection,commands[cIdx].direction);
                cIdx ++;
            }
        }
        while(0 <= curI && curI < size && 0 <= curJ && curJ < size){
            ans ++;
            curI += move[curDirection][0];
            curJ += move[curDirection][1];
            if(0 > curI || 0 > curJ || curI >= size || curJ >= size)break;
            if(map[curI][curJ] == 1)break;
            map[curI][curJ] = 1;
        }
        System.out.println(ans);
    }
    public static int calc(int curDirect, char command){
        if(command == 'L'){
            curDirect --;
            curDirect = curDirect < 0 ? 3 : curDirect;
        }
        else{
            curDirect ++;
            curDirect = curDirect >= 4 ? 0 : curDirect;
        }
        return curDirect;
    }
}
