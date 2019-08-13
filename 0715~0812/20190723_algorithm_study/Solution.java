//Brute Case
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String t = "java coding algo";
		String p = "coding";
//		int idx = findString(t, p);
//		boolean boo = t.contains(p);
		int idx = t.indexOf(p);
		System.out.println(idx);
	}

	static int findString(String t, String p) {
		char[] trr = t.toCharArray();
		char[] prr = p.toCharArray();
		
		int tSize = trr.length;
		int pSize = prr.length;
		if(pSize > tSize) return -1;
		
		int idx = -1;
		boolean flag;
		
		for(int i=0; i<tSize-pSize; i++) {
			flag = true;
			for(int j=0; j<pSize; j++) {
				if(trr[i+j] != prr[j]) {
					flag = false;
					break;
				}
			}
			if(flag) {
				idx = i;
				return i;
			}
			
		}
		
		return idx;
	}

}
