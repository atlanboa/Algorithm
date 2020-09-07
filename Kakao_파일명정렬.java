import java.util.Arrays;

public class Kakao_파일명정렬 {
    public String[] solution(String[] files) {
        String[] answer;

        File[] f = new File[files.length];
        StringBuilder header = new StringBuilder();
        StringBuilder number = new StringBuilder();
        StringBuilder tail = new StringBuilder();

        for(int i=0; i<files.length; i++){
            f[i] = new File();
            boolean headerFlag = true;
            boolean numberFlag = true;

            for(char c : files[i].toCharArray()){

                if(headerFlag && !Character.isDigit(c)){
                    header.append(c);
                    continue;
                }else{
                    headerFlag = false;
                }

                if(numberFlag && Character.isDigit(c)){
                    number.append(c);
                    continue;
                }else{
                    numberFlag = false;
                }

                tail.append(c);
            }

            f[i].order = i;
            f[i].head = header.toString();
            f[i].number = number.toString();
            f[i].tail = tail.toString();

            header.delete(0, header.length());
            number.delete(0, number.length());
            tail.delete(0, tail.length());
        }

        for(File temp : f){
            System.out.println(temp.order +" / " + temp.head + temp.number + temp.tail);
        }

        Arrays.sort(f);

        answer = new String[f.length];

        for(int i=0; i<f.length; i++){
            answer[i] = f[i].head.concat(f[i].number).concat(f[i].tail);
        }


        return answer;
    }

    public class File implements Comparable<File>{
        int order;
        String head;
        String number;
        String tail;

        @Override
        public int compareTo(File o) {
            int headCompare = this.head.toLowerCase().compareTo(o.head.toLowerCase());
            if(headCompare == 0){
                int thisNumber = Integer.parseInt(number);
                int thatNumber = Integer.parseInt(o.number);
                int numberCompare = Integer.compare(thisNumber, thatNumber);
                if(numberCompare == 0){
                    return Integer.compare(this.order, o.order);
                }
                return numberCompare;
            }
            return headCompare;
        }
    }

    public static void main(String[] args) {
        Kakao_파일명정렬 temp = new Kakao_파일명정렬();
        String[] files = {
                "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"
        };
        temp.solution(files);
    }
}
