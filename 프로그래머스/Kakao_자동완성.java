package 프로그래머스;

import java.util.*;

public class Kakao_자동완성 {

    public int solution(String[] words) {
        int answer = 0;

        Trie trie = new Trie();

        for(int i=0; i< words.length; i++){
            trie.insert(words[i]);
        }

        for(int i=0; i<words.length; i++){
            answer += trie.containsWithDepth(words[i]);
        }

        return answer;
    }

    public class TrieNode {
        private Map<Character, TrieNode> childNodes = new HashMap<>();
        private int childrenCnt;

        Map<Character, TrieNode> getChildNodes() {
            return this.childNodes;
        }

        int getChildrenCnt(){
            return this.childrenCnt;
        }

        void plusChildrenCnt(){
            this.childrenCnt++;
        }


    }

    public class Trie {
        private TrieNode rootNode;

        Trie() {
            rootNode = new TrieNode();
        }

        void insert(String word) {
            TrieNode thisNode = this.rootNode;

            for (int i = 0; i < word.length(); i++) {
                thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
                thisNode.plusChildrenCnt();
            }
        }

        int containsWithDepth(String word) {
            TrieNode thisNode = this.rootNode;
            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);
                TrieNode node = thisNode.getChildNodes().get(character);
                if (node.getChildrenCnt() == 1)
                    return i+1;
                thisNode = node;
            }
            return word.length();
        }


    }

    public static void main(String[] args) {
        Kakao_자동완성 temp = new Kakao_자동완성();
        String[] words = {"go", "gone", "guild"};
        temp.solution(words);
    }

}
