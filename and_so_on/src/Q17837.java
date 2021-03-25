import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q17837 {
    static class Horse{
        public int i,j,direction;
        public int preNum;
        public int nextNum;
        public Horse(int i, int j,int direction){
            this.i = i;
            this.j = j;
            this.direction = direction;
            this.preNum = -1;
            this.nextNum = -1;
        }
        public void reverse() {
            if (this.direction % 2 == 0)
                this.direction++;
            else
                this.direction--;
        }
    }
    static class ChessBoard{
        public int value ;
        public int under;
        public ChessBoard(int value ) {
            this.value = value;
            this.under = -1;
        }
    }
    static ChessBoard[][] map ;
    static Horse[] horses ;
    static int N;
    static int K;
    public static void main(String[] args)throws Exception{
        init();
        solution();
    }
    public static void solution(){
        int[][] move = {{0,1},{0,-1},{-1,0},{1,0}};
        int cnt = 1;
        int turn = 0;
        while(cnt < 4 && turn < 1001){
            turn ++;
            System.out.println(turn);
            for(int i = 0 ; i < K ; i ++){
                print();
                int d = horses[i].direction;
                int nxtI = horses[i].i + move[d][0];
                int nxtJ = horses[i].j + move[d][1];
                if(0 > nxtI || 0 > nxtJ || nxtI >= N || nxtJ >= N || map[nxtI][nxtJ].value == 2){
                    horses[i].reverse();
                    d = horses[i].direction;
                    nxtI = horses[i].i + move[d][0];
                    nxtJ = horses[i].j + move[d][1];
                }
                if(0 > nxtI || 0 > nxtJ || nxtI >= N || nxtJ >= N || map[nxtI][nxtJ].value == 2)continue;
                int under = map[nxtI][nxtJ].under;
                while(under != -1 && horses[under].nextNum != -1){
                    under = horses[under].nextNum;
                }
                int target = i;
                if(map[nxtI][nxtJ].value == 1){
                    target = convertHorse(i);
                }
                if(under == -1){
                    map[nxtI][nxtJ].under = target ;
                }
                else {
                    horses[under].nextNum = target;
                }
                if(map[nxtI][nxtJ].value != 2){
                    int tmp = 0;
                    while(under != -1){
                        horses[under].i = nxtI;
                        horses[under].j = nxtJ;
                        under = horses[under].nextNum;
                        tmp++;
                    }
                    cnt = Math.max(cnt,tmp);
                }
            }
        }
        if(cnt >= 4){
            System.out.println(turn);
        }
        else{
            System.out.println("-1");
        }
    }
    public static void init()throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] init = bf.readLine().split(" ");
        N = Integer.parseInt(init[0]);
        K = Integer.parseInt(init[1]);
        map = new ChessBoard[N][N];
        horses = new Horse[K];
        for(int i = 0 ; i < N ; i ++){
            String[] str = bf.readLine().split(" ");
            for(int j = 0 ; j < N ; j ++){
                map[i][j] = new ChessBoard(Integer.parseInt(str[j]));
            }
        }
        for(int i = 0 ; i < K ; i ++){
            String[] str = bf.readLine().split(" ");
            int x = Integer.parseInt(str[0])-1;
            int y = Integer.parseInt(str[1])-1;
            horses[i] = new Horse(x,y,Integer.parseInt(str[2])-1);
            map[x][y].under = i;
        }
    }
    public static int convertHorse(int horse){
        Stack<Integer> stack = new Stack<>();
        int root = horse;
        while(horses[root].nextNum != -1){
            int nxt = horses[root].nextNum;
            horses[root].nextNum = -1;
            horses[root].preNum = -1;
            stack.push(root);
            root = nxt;
        }
        int res;
        if(!stack.isEmpty()) {
            res = stack.pop();
            int tmp = res;
            while(!stack.isEmpty()){
                horses[tmp].nextNum = stack.pop();
                tmp = horses[tmp].nextNum;
            }
        }
        else{
            res = root;
        }
        return res;
    }
    public static void print(){
        int cnt = 0 ;
        for(Horse h : horses){
            System.out.println(h.preNum +" ->["+ cnt +"] -> "+ h.preNum);
            cnt ++;
        }
    }
}
