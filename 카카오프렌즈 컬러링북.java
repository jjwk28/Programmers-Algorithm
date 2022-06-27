import java.util.*;

class Solution {
    
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] check;
    static int cnt;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        check = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] != 0 && !check[i][j]){
                    cnt = 0;
                    bfs(i, j, m, n, picture);
                    if(cnt > maxSizeOfOneArea){
                        maxSizeOfOneArea = cnt;
                    }
                    numberOfArea++;
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    
    static void bfs(int x, int y, int m, int n, int[][] picture){
        check[x][y] = true;
        cnt++;
        
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        
        while(!queue.isEmpty()){
            Point q = queue.poll();
            x = q.x;
            y = q.y;
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                    if(!check[nx][ny] && picture[nx][ny] == picture[x][y]){
                        check[nx][ny] = true;
                        queue.add(new Point(nx, ny));
                        bfs(nx, ny, m, n, picture);
                    }
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