package HomeWork6;

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;
    private int[] A = {0, 0};

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int size;
        private int deep = 0;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            size = 1;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public int getDeep() {
        return getDeep(root, 0);
    }

    public int getDeepLeft() {
        return getDeep(root.left, 1);
    }

    public int getDeepRight() {
        return getDeep(root.right, 1);
    }

    private int getDeep(Node node, int deep) {

        if (node == null) {
            A[0] = deep;
            A[1] = deep;
            return deep;
        }
        int rightDeep = getDeep(node.right, deep + 1);
        int leftDeep = getDeep(node.left, deep + 1);


        if (leftDeep >= rightDeep) {
            return leftDeep;
        } else {
            return rightDeep;
        }
        //A[0={leftDeep,rightDeep};
        //return A;

    }

    public boolean isEmpty() {
        return root == null;
    }

    private boolean isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не должен быть null");
        }
        return true;
    }

    public boolean contains(Key key) {
        isKeyNotNull(key);
        return get(key) != null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        isKeyNotNull(key);
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }

    }

    public void put(Key key, Value value) {
        isKeyNotNull(key);
        if (value == null) {
            //delete(key);
        }
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public Key minKey() {
        return min(root).key;
    }

    public Key maxKey() {
        return max(root).key;
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key) {
        isKeyNotNull(key);
        root = delete(root, key);

    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node tempNode = node;
            node = min(node.right);
            node.right = deleteMin(tempNode.right);
            node.left = tempNode.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }


    @Override
    public String toString() {
        return "BST{" +
                toString(root) +
                ')';
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }
        return toString(node.left) + " "
                + node.value.toString() + " "
                + toString(node.right);
    }


}
