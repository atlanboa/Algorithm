public class Kakao_비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        String[] map1 = new String[n];
        String[] map2 = new String[n];

        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toBinaryString(arr1[i]));
            if(sb.length() < n){
                int loop = n - sb.length();
                for(int j=0; j<loop; j++){
                    sb.insert(0, "0");
                }
            }
            map1[i] = sb.toString();
            sb.delete(0, sb.length());

            sb.append(Integer.toBinaryString(arr2[i]));
            if(sb.length() < n){
                int loop = n - sb.length();
                for(int j=0; j<loop; j++){
                    sb.insert(0, "0");
                }
            }
            map2[i] = sb.toString();

        }

        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                if(map1[i].charAt(j) == '1' || map2[i].charAt(j) == '1'){
                    sb.append('#');
                }else{
                    sb.append(' ');
                }
            }
            answer[i] = sb.toString();
            sb.delete(0, sb.length());
        }


        return answer;
    }

    public static void main(String[] args) {
        Kakao_비밀지도 temp = new Kakao_비밀지도();
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};



        temp.solution(n, arr1, arr2);
    }
}
