package gorgeous.algorithm.common;

import java.util.Optional;

public class AVL<K extends Comparable<K>, V> {

    private TreapNode<K, V> root;

    public void add(K key, V value) {
        this.root = this.add(root, key, value);
    }

    public void remove(K key) {
        TreapNode<K, V> removing = this.Search(this.root, key);
        if (removing == null) {
            return;
        }
        this.root = this.remove(this.root, key);
    }

    public V get(K key) {
        TreapNode<K, V> searching = this.Search(this.root, key);
        if (searching == null) {
            return null;
        } else {
            return searching.getValue();
        }
    }

    public Boolean exist(K key) {
        return this.Search(this.root, key) != null;
    }

    public Boolean isEmpty() {
        return this.root == null;
    }

    public Integer size() {
        return Optional.ofNullable(this.root.getSize()).orElse(0);
    }

    public Integer rank(K key) {
        return this.small(this.root, key);
    }

    public K floor(K key) {
        TreapNode<K, V> less = this.floor(this.root, key);
        return less == null ? null : less.getKey();
    }

    public K celling(K key) {
        TreapNode<K, V> more = this.celling(this.root, key);
        return more == null ? null : more.getKey();
    }

    public void clear() {
        this.root = null;
    }

    private TreapNode<K, V> add(TreapNode<K, V> node, K key, V value) {
        if (node == null) {
            node = new TreapNode<>(key, value);
        } else {
            if (node.getKey().compareTo(key) > 0) {
                node.setLeft(this.add(node.getLeft(), key, value));
            } else if (node.getKey().compareTo(key) < 0) {
                node.setRight(this.add(node.getRight(), key, value));
            } else {
                node.setValue(value);
            }
        }
        this.update(node);
        return this.maintain(node);
    }

    private TreapNode<K, V> remove(TreapNode<K, V> node, K key) {
        if (node.getKey().compareTo(key) > 0) {
            node.setLeft(this.remove(node.getLeft(), key));
        } else if (node.getKey().compareTo(key) < 0) {
            node.setRight(this.remove(node.getRight(), key));
        } else {
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            } else if (node.getLeft() == null && node.getRight() != null) {
                node = node.getRight();
            } else if (node.getLeft() != null && node.getRight() == null) {
                node = node.getLeft();
            } else {
                TreapNode<K, V> mostLeft = node.getRight();
                while (mostLeft.getLeft() != null) {
                    mostLeft = mostLeft.getLeft();
                }
                node.setRight(this.removeMostLeft(node.getRight(), mostLeft));
                mostLeft.setLeft(node.getLeft());
                mostLeft.setRight(node.getRight());
                node = mostLeft;
            }
        }
        this.update(node);
        return this.maintain(node);
    }

    private TreapNode<K, V> Search(TreapNode<K, V> node, K key) {
        if (node == null) {
            return null;
        } else {
            if (node.getKey().compareTo(key) > 0) {
                return this.Search(node.getLeft(), key);
            } else if (node.getKey().compareTo(key) < 0) {
                return this.Search(node.getRight(), key);
            } else {
                return node;
            }
        }
    }

    private TreapNode<K, V> removeMostLeft(TreapNode<K, V> node, TreapNode<K, V> mostLeft) {
        if (node.getKey().compareTo(mostLeft.getKey()) == 0) {
            return node.getRight();
        } else {
            node.setLeft(this.removeMostLeft(node.getLeft(), mostLeft));
            this.update(node);
            return this.maintain(node);
        }
    }

    private void update(TreapNode<K, V> node) {
        node.setSize((node.getLeft() == null ? 0 : node.getLeft().getSize())
                + (node.getRight() == null ? 0 : node.getRight().getSize()) + 1);
        node.setHeight(Math.max(node.getLeft() == null ? 0 : node.getLeft().getHeight(),
                node.getRight() == null ? 0 : node.getRight().getHeight()) + 1);
    }

    private TreapNode<K, V> maintain(TreapNode<K, V> node) {
        if (node.getLeft().getHeight() - node.getRight().getHeight() > 1) {
            if (node.getLeft().getLeft().getHeight() >= node.getLeft().getRight().getHeight()) {
                node = this.rightRotate(node);
            } else {
                node.setLeft(this.leftRotate(node.getLeft()));
                node = this.rightRotate(node);
            }
        } else if (node.getRight().getHeight() - node.getLeft().getHeight() > 1) {
            if (node.getRight().getRight().getHeight() >= node.getRight().getLeft().getHeight()) {
                node = this.leftRotate(node);
            } else {
                node.setRight(this.rightRotate(node.getRight()));
                node = this.leftRotate(node);
            }
        }
        return node;
    }

    private TreapNode<K, V> leftRotate(TreapNode<K, V> node) {
        TreapNode<K, V> right = node.getRight();
        node.setRight(right.getLeft());
        right.setLeft(node);
        this.update(node);
        this.update(right);
        return right;
    }

    private TreapNode<K, V> rightRotate(TreapNode<K, V> node) {
        TreapNode<K, V> left = node.getLeft();
        node.setLeft(left.getRight());
        left.setRight(node);
        this.update(node);
        this.update(left);
        return left;
    }

    private Integer small(TreapNode<K, V> node, K key) {
        if (node == null) {
            return 0;
        } else {
            if (node.getKey().compareTo(key) > 0) {
                return this.small(node.getLeft(), key);
            } else {
                return 1 + node.getLeft().getSize() + this.small(node.getRight(), key);
            }
        }
    }

    private TreapNode<K, V> floor(TreapNode<K, V> node, K key) {
        if (node == null) {
            return null;
        } else {
            if (node.getKey().compareTo(key) >= 0) {
                return this.floor(node.getLeft(), key);
            } else {
                TreapNode<K, V> right = this.floor(node.getRight(), key);
                if (right != null && node.getKey().compareTo(right.getKey()) < 0) {
                    return right;
                } else {
                    return node;
                }
            }
        }
    }

    private TreapNode<K, V> celling(TreapNode<K, V> node, K key) {
        if (node == null) {
            return null;
        } else {
            if (node.getKey().compareTo(key) <= 0) {
                return this.celling(node.getRight(), key);
            } else {
                TreapNode<K, V> left = this.celling(node.getLeft(), key);
                if (left != null && node.getKey().compareTo(left.getKey()) > 0) {
                    return left;
                } else {
                    return node;
                }
            }
        }
    }
}
