
public class EndianTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 654321;
		
		byte[] arr = intToByteArr(a);
		
		int b = byteArrToInt(arr);
		System.out.println(b);
	}

	static int byteArrToInt(byte[] arr) {
		int num = (arr[0] & 0xff)
				+ ((arr[1] & 0xff)<<8)
				+ ((arr[2] & 0xff)<<16) 
				+ ((arr[3] & 0xff)<<24);
		
		
		
		return num;
	}

	static byte[] intToByteArr(int num) {
		
		byte[] res = new byte[4];
		res[0] = (byte)num;
		res[1] = (byte)(num>>8);
		res[2] = (byte)(num>>16);
		res[3] = (byte)(num>>24);
		
		return res;
	}

}
