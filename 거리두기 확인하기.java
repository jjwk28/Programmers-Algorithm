import java.util.*;

class Solution {
    
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean check; // true일 경우 거리두기X, false일 경우 거리두기O
    static boolean[][] visit; // bfs탐색 시 이미 탐색한 사람의 경우 true
    
    public int[] solution(String[][] places) {
        int[] answer = {};
        answer = new int[5];
        
        // P : 사람, O : 빈자리, X : 파티션, places의 길이 : 5
        int len = places.length;
        
        for(int i = 0; i < len; i++){
            
            // room : 각 대기실에 해당하는 2차원 배열
            char[][] room = new char[len][len];
            check = false;
            
            for(int j = 0; j < len; j++){
                for(int k = 0; k < len; k++){
                    room[j][k] = places[i][j].charAt(k);
                }
            }
            
            for(int j = 0; j < len; j++){
                for(int k = 0; k < len; k++){
                    if(!check && room[j][k] == 'P'){
                        int d = 0; // 거리
                        visit = new boolean[len][len]; // 방문여부
                        bfs(d, j, k, room, visit);
                        
                        // 거리두기가 지켜지지 않은 경우
                        if(check){
                            answer[i] = 0;
                        }
                    }
                }
            }
            // 거리두기가 전부 지켜진 경우
            if(!check){
                answer[i] = 1;
            }
        }
        
        return answer;
    }
    static void bfs(int d, int x, int y, char[][] room, boolean[][] visit){
        visit[x][y] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        
        while(!queue.isEmpty()){
            Point p = queue.poll();
            x = p.x;
            y = p.y;
            d++;
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5){
                    // 거리가 2보다 큰 경우
                    if(d > 2){
                        continue;
                    }
                    // 이미 탐색한 사람의 경우
                    if(visit[nx][ny]){
                        continue;
                    }
                    // 거리2 이하에 사람이 있는 경우
                    if(room[nx][ny] == 'P'){
                        check = true;
                        break;
                    }
                    // 파티션이 있는 경우
                    if(room[nx][ny] == 'X'){
                        continue;
                    }
                    queue.add(new Point(nx, ny));
                    bfs(d, nx, ny, room, visit);
                    
                }
            }
        }
    }
}
class Point{
    int x;
    int y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}