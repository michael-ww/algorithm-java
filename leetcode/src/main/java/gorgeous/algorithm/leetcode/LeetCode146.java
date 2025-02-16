package gorgeous.algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LeetCode146 {

    public class LRUCache<K, V> {

        private final int capacity;
        private final Map<K, V> cache;
        private final LinkedList<K> visited;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>(2 * capacity - 1);
            this.visited = new LinkedList<>();
        }

        public V get(K key) {
            if (this.cache.containsKey(key)) {
                this.visited.remove(key);
                this.visited.addFirst(key);
                return this.cache.get(key);
            } else {
                return null;
            }
        }

        public void put(K key, V value) {
            if (this.cache.containsKey(key)) {
                this.visited.remove(key);
            } else {
                if (this.cache.size() >= this.capacity) {
                    K deleted = this.visited.removeLast();
                    this.cache.remove(deleted);
                }
            }
            this.cache.put(key, value);
            this.visited.addFirst(key);
        }
    }
}
