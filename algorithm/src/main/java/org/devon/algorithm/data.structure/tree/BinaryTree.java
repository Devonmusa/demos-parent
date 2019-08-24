package org.devon.algorithm.data.structure.tree;

/**
 * @author Devonmusa
 * @date 2019/8/24 2:59
 * @since
 */
public class BinaryTree<Key extends Comparable<Key>, Value> {

    private Node root;

    public int size() {
        return size(root);
    }

    public int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.count;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    public Key min() {
        Node minNode = min(root);
        if (minNode == null) {
            return null;
        } else {
            return minNode.key;
        }
    }

    public Key max() {
        Node maxNode = max(root);
        if (maxNode == null) {
            return null;
        } else {
            return maxNode.key;
        }
    }

    public void preOrderTraversal() {

        System.out.println(root);
        if (root.left != null) {
            preOrderTraversal();
        }
    }

    public void inOrderIterator() {

    }

    public void postOrderIterator() {

    }


    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }

    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            node =new Node(key, value, 1);
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            return put(node.left, key, value);
        } else if (cmp > 0) {
            return put(node.right, key, value);
        } else {
            node.value = value;
        }

        node.count = size(node.left) + size(node.right) + 1;

        return node;

    }

    private Node min(Node node) {
        if (node == null) {
            return null;
        }

        if (node.left != null) {
            return min(node.left);
        }

        if (node.right != null) {
            return min(node.right);
        }

        return node;
    }

    private Node max(Node node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            return max(node.right);
        }

        if (node.left != null) {
            return max(node.left);
        }

        return node;
    }

    public void preOrderTraversal(Node root) {

        if (root.left != null) {
            preOrderTraversal(root.left);
        } else {
            preOrderTraversal(root.right);
        }

        if (root.right != null) {
            preOrderTraversal(root.right);
        } else {
            preOrderTraversal(root.left);
        }
    }


    private class Node {
        /**
         * key
         */
        private Key key;
        /**
         * value
         */
        private Value value;
        /**
         * left node reference
         */
        private Node left;
        /**
         * right node reference
         */
        private Node right;
        /**
         * current node of root, sub tree node count
         */
        private int count;

        public Node(Key key, Value value, int count) {
            this.key = key;
            this.value = value;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    ", count=" + count +
                    '}';
        }
    }


}
