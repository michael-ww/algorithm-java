package gorgeous.algorithm;

import java.util.HashMap;

public class TrieNode<T> {

    private Integer pass;
    private Integer end;
    private T value;
    private HashMap<T, TrieNode<T>> nexts;

    public TrieNode() {
        this.pass = 0;
        this.end = 0;
        this.nexts = new HashMap<>();
    }

    public Integer getPass() {
        return pass;
    }

    public void setPass(Integer pass) {
        this.pass = pass;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public HashMap<T, TrieNode<T>> getNexts() {
        return nexts;
    }

    public void setNexts(HashMap<T, TrieNode<T>> nexts) {
        this.nexts = nexts;
    }
}
