import java.util.Arrays;

class Solution_자물쇠와열쇠 {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        int keySize = key.length;
        int lockSize = lock.length;
        
        int[][] spin90 = new int[keySize][keySize];
        int[][] spin180 = new int[keySize][keySize];
        int[][] spin270 = new int[keySize][keySize];
        
        int[][] map = new int[lockSize+(keySize-1)*2][lockSize+(keySize-1)*2];
        
        for(int i=0; i<keySize; i++) {
        	for(int j=0; j<keySize; j++) {
        		spin90[j][keySize-1-i] = key[i][j];
        		spin180[keySize-1-i][keySize-1-j] = key[i][j];
        		spin270[keySize-1-j][i] = key[i][j];
        	}
        }
        

        
        for(int i=0; i<keySize+lockSize-1; i++) {
        	for(int j=0; j<keySize+lockSize-1; j++) {
        		setMap(map, lock, keySize, lockSize);
        		answer = insertKey(map, key, i, j, keySize, lockSize);
        		if(answer) return answer;
        		setMap(map, lock, keySize, lockSize);
        		answer = insertKey(map, spin90, i, j, keySize, lockSize);    
        		if(answer) return answer;
        		setMap(map, lock, keySize, lockSize);
        		answer = insertKey(map, spin180, i, j, keySize, lockSize);  
        		if(answer) return answer;
        		setMap(map, lock, keySize, lockSize);
        		answer = insertKey(map, spin270, i, j, keySize, lockSize); 
        		if(answer) return answer;
        		
        		
    		}
        }
        
        
        
        return answer;
    }

    private boolean insertKey(int[][] map, int[][] key, int startX, int startY, int keySize, int lockSize) {
		
    	boolean answer = true;
    	
    	for(int i=0; i<key.length; i++) {
    		for(int j=0; j<key.length; j++) {
    			if(map[startX+i][startY+j]==1 && key[i][j]==1) return false;
    			else if(map[startX+i][startY+j]==0 && key[i][j]==1) map[startX+i][startY+j] = 1;
    		}
    	}
    	
    	for(int i=keySize-1; i<lockSize+keySize-1; i++) {
    		for(int j=keySize-1; j<lockSize+keySize-1; j++) {
    			if(map[i][j]==0) return false;
    		}
    	}
    	
    	return answer;
    	
		
	}

	private void setMap(int[][] map, int[][] lock, int keySize, int lockSize) {
		for(int i=0; i<map.length; i++) {
			Arrays.fill(map[i], 0);
		}
        for(int i=0; i<lockSize; i++) {
        	for(int j=0; j<lockSize; j++) {
        		map[i+keySize-1][j+keySize-1] = lock[i][j];
        	}
        }
		
	}


	public static void main(String[] args) {
		Solution_자물쇠와열쇠 s = new Solution_자물쇠와열쇠();
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock =  {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		System.out.println(s.solution(key, lock));
	}
}