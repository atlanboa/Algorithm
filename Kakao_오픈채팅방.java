import java.util.*;

public class Kakao_오픈채팅방 {

    public String[] solution(String[] record) {
        String[] answer;

        Map<String, String> uid = new HashMap<>();
        LinkedList<User> log = new LinkedList<>();

        for(String r : record){
            String[] split = r.split(" ");

            if(split[0].equals("Enter") ){
                User user = new User(split[1], split[0]);
                log.add(user);

            }else if(split[0].equals("Leave")){
                User user = new User(split[1], split[0]);
                log.add(user);
            }

            if(!split[0].equals("Leave") ){
                uid.put(split[1], split[2]);
            }

        }

        answer = new String[log.size()];

        int loop = log.size();

        for(int i=0; i<loop; i++){
            User temp = log.poll();

            answer[i] = uid.get(temp.uid)
                    .concat("님이 ")
                    .concat(temp.state.equals("Enter")?"들어왔습니다":"나갔습니다")
                    .concat(".");

            System.out.println(answer[i]);
        }

        return answer;
    }

    public class User {
        String uid;
        String state;

        public User(String uid, String state){
            this.uid =uid;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        Kakao_오픈채팅방 temp = new Kakao_오픈채팅방();
        temp.solution(record);
    }
}
