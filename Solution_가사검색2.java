import java.util.Arrays;
import java.util.HashMap;

class Solution_가사검색2 {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Trie root = new Trie('*');
        for (int i = 0; i < words.length; i++) {
        	Trie prev = root;
        	for(char c : words[i].toCharArray()) {
                Trie curr = new Trie(c);
                prev = prev.putChild(curr, words[i].length());
        	}
        	
        }
        
        for(int i=0; i<queries.length; i++) {
        	String query = queries[i];
        	Trie trav = root;
        	if(query.charAt(0)=='?') continue;
        	for(char c : query.toCharArray()) {
        		if(c=='?') {
        			answer[i] = trav.getNumChildrenWithLen(query.length());
        			break;
        		}
        		trav = trav.getChild(c);
        		if(trav==null) {
        			answer[i] = 0;
        			break;
        		}
        	}
        }

        Trie rootReverse = new Trie('*');
        for (int i = 0; i < words.length; i++) {
        	Trie prev = rootReverse;
        	for(int j=words[i].length()-1; j>=0; j--) {
                Trie curr = new Trie(words[i].charAt(j));
                prev = prev.putChild(curr, words[i].length());
        	}
        	
        }
        
        for(int i=0; i<queries.length; i++) {
        	String query = queries[i];
        	Trie trav = rootReverse;
        	if(query.charAt(0)!='?') continue;
        	for(int j = query.length()-1; j>=0; j--) {
        		if(query.charAt(j)=='?') {
        			answer[i] = trav.getNumChildrenWithLen(query.length());
        			break;
        		}
        		
        		trav = trav.getChild(query.charAt(j));
        		if(trav == null) {
        			answer[i] = 0;
        			break;
        		}
        	}
        }
        
        return answer;
    }
    
    class Trie {
        char c;
        HashMap<Character, Trie> children;
        HashMap<Integer, Integer> numChildrenWithLen;
        
        Trie(char c) {
            this.c = c;
            children = new HashMap<Character, Trie>();
            numChildrenWithLen = new HashMap<Integer, Integer>();
        }
        
        Trie putChild(Trie t, int len) {
            if (!children.containsKey(t.c)) {
                children.put(t.c, t);
            }
            if (numChildrenWithLen.containsKey(len)) {
                numChildrenWithLen.put(len, numChildrenWithLen.get(len) + 1);
            }
            else {
                numChildrenWithLen.put(len, 1);
            }
            return children.get(t.c);
        }
        
        Trie getChild(char c) {
            return children.get(c);
        }
        
        int getNumChildrenWithLen(int len) {
            if (numChildrenWithLen.containsKey(len)) return numChildrenWithLen.get(len);
            return 0;
        }
    }
    
    public static void main(String[] args) {
		Solution_가사검색2 s = new Solution_가사검색2();
		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
		System.out.println(Arrays.toString(s.solution(words, queries)));
	}

}