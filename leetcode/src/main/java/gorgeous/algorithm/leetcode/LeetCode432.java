package gorgeous.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode432 {

    public static class AllOne {

        private final Bucket head;
        private final Bucket tail;
        private final Map<String, Bucket> map;

        public AllOne() {
            this.head = new Bucket(0);
            this.tail = new Bucket(Integer.MAX_VALUE);
            this.head.setNext(this.tail);
            this.tail.setPrevious(this.head);
            this.map = new HashMap<>();
        }

        public void inc(String key) {
            if (this.map.containsKey(key)) {
                Bucket bucket = this.map.get(key);
                if (bucket.getNext().label == bucket.getLabel() + 1) {
                    bucket.getNext().addElement(key);
                    this.map.put(key, bucket.getNext());
                } else {
                    Bucket next = new Bucket(bucket.getLabel() + 1);
                    next.addElement(key);
                    bucket.insertAfter(next);
                    this.map.put(key, next);
                }
                bucket.removeElement(key);
                if (bucket.isEmpty()) {
                    bucket.removeSelf();
                }
            } else {
                if (this.head.getNext().getLabel() == 1) {
                    this.head.getNext().addElement(key);
                    this.map.put(key, this.head.getNext());
                } else {
                    Bucket one = new Bucket(1);
                    one.addElement(key);
                    one.insertAfter(this.head);
                }
            }
        }

        public void dec(String key) {
            if (this.map.containsKey(key)) {
                Bucket bucket = this.map.get(key);
                this.map.remove(key);
                if (bucket.getLabel() != 1) {
                    if (bucket.getPrevious().getLabel() == bucket.getLabel() - 1) {
                        bucket.getPrevious().addElement(key);
                        this.map.put(key, bucket.getPrevious());
                    } else {
                        Bucket previous = new Bucket(bucket.getLabel() - 1);
                        previous.addElement(key);
                        bucket.insertBefore(previous);
                        this.map.put(key, previous);
                    }
                }
                bucket.removeElement(key);
                if (bucket.isEmpty()) {
                    bucket.removeSelf();
                }
            }
        }

        public String getMaxKey() {
            return this.tail.getPrevious().getElement();
        }

        public String getMinKey() {
            return this.head.getNext().getElement();
        }

        class Bucket {

            private final Set<String> set;
            private Integer label;
            private Bucket previous;
            private Bucket next;

            public Bucket(Integer lable) {
                this.set = new HashSet<>();
                this.label = lable;
            }

            public void addElement(String s) {
                this.set.add(s);
            }

            public void removeElement(String s) {
                this.set.remove(s);
            }

            public String getElement() {
                return this.set.iterator().next();
            }

            public Boolean isEmpty() {
                return this.set.isEmpty();
            }

            public void insertAfter(Bucket bucket) {
                bucket.setPrevious(this);
                bucket.setNext(this.next);
                this.next.setPrevious(bucket);
                this.next = bucket;
            }

            public void insertBefore(Bucket bucket) {
                bucket.setNext(this);
                bucket.setPrevious(this.previous);
                this.previous.setNext(bucket);
                this.previous = bucket;
            }

            public void removeSelf() {
                this.previous.setNext(this.next);
                this.next.setPrevious(this.previous);
            }

            public Integer getLabel() {
                return label;
            }

            public Bucket getPrevious() {
                return previous;
            }

            public void setPrevious(Bucket previous) {
                this.previous = previous;
            }

            public Bucket getNext() {
                return next;
            }

            public void setNext(Bucket next) {
                this.next = next;
            }
        }
    }
}
