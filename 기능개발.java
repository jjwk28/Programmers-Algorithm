import java.util.ArrayList;
import java.util.Stack;

class Solution {
    
    public int[] solution(int[] progresses, int[] speeds) {
        
      int[] answer = {};
		  Stack<Integer> stack = new Stack<Integer>();
		
		  for(int i = progresses.length - 1; i >= 0; i--) {
			  stack.add((100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] != 0 ? 1 : 0));
		  }
        
		  ArrayList<Integer> list = new ArrayList<Integer>();
		
		  while(!stack.isEmpty()) {
            
			  int count = 1;
			  int top = stack.pop();
            
			  while(!stack.isEmpty() && stack.peek() <= top) {
				  count++;
				  stack.pop();
			  }
            
			  list.add(count);
            
		  }
        
		  answer = new int[list.size()];
        
		  for(int i = 0; i < answer.length; i++) {
			  answer[i] = list.get(i);
		  }
        
	  	return answer;
    }
    
}