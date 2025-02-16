package gorgeous.algorithm.leetcode;

public class TreapNode<K, V> {

    private K key;
    private V value;
    private TreapNode<K, V> left;
    private TreapNode<K, V> right;
    private Integer height;
    private Integer size;

    public TreapNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.height = 1;
        this.size = 1;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public TreapNode<K, V> getLeft() {
        return left;
    }

    public void setLeft(TreapNode<K, V> left) {
        this.left = left;
    }

    public TreapNode<K, V> getRight() {
        return right;
    }

    public void setRight(TreapNode<K, V> right) {
        this.right = right;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

}
