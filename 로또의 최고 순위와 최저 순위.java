class Solution {
    static public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = {};
		int correct = 0; // 맞은 개수
		int zero = 0; // 0의 개수
		
		for(int i = 0; i < lottos.length; i++) {
			int n = lottos[i];
			
			if(n == 0) {
				correct++;
                zero++;
				continue;
			}
			else {
				for(int j = 0; j < win_nums.length; j++) {
					if(n == win_nums[j]) {
						correct++;
						break;
					}
				}
			}
		}
		
		int max_rank = rank(correct);
		int min_rank = rank(correct - zero);
		
		answer = new int[2];
		answer[0] = max_rank;
		answer[1] = min_rank;
		
		return answer;
	}
    static int rank(int correct) {
    	switch(correct) {
    	case 6:
    		return 1;
    	case 5:
    		return 2;
    	case 4:
    		return 3;
    	case 3:
    		return 4;
    	case 2:
    		return 5;
    	}
    	return 6;
    }
}