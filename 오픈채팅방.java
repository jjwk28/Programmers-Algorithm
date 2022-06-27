import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        int cnt = 0;
        
        String[][] str = new String[record.length][];
        HashMap<String, String> hm = new HashMap<>();
        
        for(int i = 0; i < record.length; i++){
            str[i] = record[i].split(" ");
            
            if(!str[i][0].equals("Leave")){
                hm.put(str[i][1], str[i][2]);
            }
            if(!str[i][0].equals("Change")){
                cnt++;
            }
        }
        
        answer = new String[cnt];
        int idx = 0;
        
        for(int i = 0; i < record.length; i++){
            if(str[i][0].equals("Change")){
                continue;
            }
            if(str[i][0].equals("Enter")){
                answer[idx] = hm.get(str[i][1]) + "님이 들어왔습니다.";
            }
            else if(str[i][0].equals("Leave")){
                answer[idx] = hm.get(str[i][1]) + "님이 나갔습니다.";
            }
            idx++;
        }
        
        return answer;
    }
}