package gorgeous.algorithm.leetcode;

public class LeetCode211 {

    public static class WordDictionary {

        private final TrieNode<Character> root;

        public WordDictionary() {
            this.root = new TrieNode<>();
        }

        public void addWord(String word) {
            if (word == null || word.isEmpty()) {
                return;
            }
            TrieNode<Character> current = root;
            for (Character character : word.toCharArray()) {
                if (!current.getNexts().containsKey(character)) {
                    TrieNode<Character> next = new TrieNode<>();
                    next.setValue(character);
                    current.getNexts().put(character, next);
                }
                current.setPass(current.getPass() + 1);
                current = current.getNexts().get(character);
            }
            current.setEnd(current.getEnd() + 1);
        }

        public boolean search(String word) {
            if (word == null || word.isEmpty()) {
                return false;
            }
            TrieNode<Character> current = this.root;
            for (Character character : word.toCharArray()) {
                if (!current.getNexts().containsKey(character)) {
                    return false;
                }
            }
            return current.getEnd() > 0;
        }
    }
}
