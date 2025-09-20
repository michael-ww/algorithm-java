package gorgeous.algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LeetCode146 {

    public class LRUCache<K, V> {

        private final int capacity;
        private final Map<K, V> data;
        private final LinkedList<K> sequence;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.data = new HashMap<>(2 * capacity - 1);
            this.sequence = new LinkedList<>();
        }

        public V get(K key) {
            if (this.data.containsKey(key)) {
                this.sequence.remove(key);
                this.sequence.addFirst(key);
                return this.data.get(key);
            } else {
                return null;
            }
        }

        public void put(K key, V value) {
            if (this.data.containsKey(key)) {
                this.sequence.remove(key);
            } else {
                if (this.data.size() >= this.capacity) {
                    K deleted = this.sequence.removeLast();
                    this.data.remove(deleted);
                }
            }
            this.data.put(key, value);
            this.sequence.addFirst(key);
        }
    }
}
