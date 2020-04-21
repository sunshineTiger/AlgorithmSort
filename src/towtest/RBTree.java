package towtest;

import com.sun.org.apache.regexp.internal.RE;

import javax.xml.soap.Node;
import java.io.PipedReader;

public class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private RBNode root;

    public RBTree() {


    }

    public RBNode getRoot() {
        return root;
    }

    private RBNode getParent(RBNode RBNode) {
        if (null != RBNode) {
            return RBNode.getParent();
        }
        return null;
    }

    private boolean isRed(RBNode node) {
        if (null != node)
            return node.isColor() == RED;
        return false;
    }

    private boolean isBlack(RBNode node) {
        if (null != node)
            return node.isColor() == BLACK;
        return false;
    }

    private void setRBNodeRed(RBNode node) {
        if (null != node)
            node.setColor(true);
    }

    private void setRBNodeBlack(RBNode node) {
        if (null != node)
            node.setColor(false);
    }

    private void inOrderPrint(RBNode node) {
        if (node == null)
            return;
        inOrderPrint(node.leftChild);
        System.out.println(node.getValue());
        inOrderPrint(node.rightChild);
    }

    private void leftRotate(RBNode node) {

        if (null != node) {
            RBNode right = node.rightChild;
            node.rightChild = right.leftChild;//将node的左子点指向left的右子节点
            if (null != right.leftChild)
                right.leftChild.parent = node;//将node的左子节点孩子节点指向node当前节点
            if (null != node.parent) {
                right.parent = node.parent;
                if (node == node.parent.leftChild) {
                    node.parent.leftChild = right;
                } else {
                    node.parent.rightChild = right;
                }
            } else {
                this.root = right;
            }
            node.parent = right;
            right.leftChild = node;

        }
    }

    /**
     * p
     * |
     * x
     * /\
     * p  o
     * / \
     * i   u
     *
     * @param node
     */
    private void rightRotate(RBNode node) {
        if (null != node) {
            RBNode left = node.leftChild;
            node.leftChild = left.rightChild;//将node的左子点指向left的右子节点
            if (null != left.rightChild)
                left.rightChild.parent = node;//将node的左子节点孩子节点指向node当前节点
            if (null != node.parent) {
                left.parent = node.parent;
                if (node == node.parent.leftChild) {
                    node.parent.leftChild = left;
                } else {
                    node.parent.rightChild = left;
                }
            } else {
                this.root = left;
            }
            node.parent = left;
            left.rightChild = node;

        }
    }


    public void insert(K key, V val) {
        RBNode node = new RBNode();
        node.setKey(key);
        node.setValue(val);
        node.setColor(RED);
        insert(node);
    }

    private void insert(RBNode node) {
        RBNode parent = null;
        RBNode x = this.root;
        while (null != node && x != null) {
            //先搜索
            parent = x;
            int cmp = node.key.compareTo(x.key);
            if (cmp > 0) {
                x = x.rightChild;
            } else if (cmp == 0) {
                x.setValue(node.getValue());
                return;
            } else {
                x = x.leftChild;
            }
        }
        //再插入
        node.parent = parent;
        if (null != parent) {
            int cmp = node.key.compareTo(parent.key);
            if (cmp > 0) {
                parent.rightChild = node;
            } else {
                parent.leftChild = node;
            }
        } else {
            this.root = node;
        }
        insertFixup(node);
    }

    private void insertFixup(RBNode node) {
        this.root.setColor(BLACK);
        RBNode parent = getParent(node);
        RBNode gparent = getParent(parent);
        if (parent != null && isRed(parent)) {
            RBNode uncle = null;
            if (parent == gparent.leftChild) {
                uncle = gparent.rightChild;
                if (null != uncle) {
                    setRBNodeBlack(parent);
                    setRBNodeBlack(uncle);
                    setRBNodeRed(gparent);
                    insertFixup(node);
                    return;
                }
                if (uncle == null || isBlack(uncle)) {
                    if (node == parent.leftChild) {
                        setRBNodeRed(gparent);
                        setRBNodeBlack(parent);
                        rightRotate(gparent);
                        return;
                    }
                    if (node == parent.rightChild) {
                        leftRotate(parent);
                        insertFixup(parent);
                        return;
                    }
                }
            } else {
                uncle = gparent.leftChild;
                if (null != uncle) {
                    setRBNodeBlack(parent);
                    setRBNodeBlack(uncle);
                    setRBNodeRed(gparent);
                    insertFixup(gparent);
                    return;
                }
                if (uncle == null || isBlack(uncle)) {
                    if (node == parent.leftChild) {
                        rightRotate(parent);
                        insertFixup(parent);
                        return;
                    }
                    if (node == parent.rightChild) {
                        setRBNodeBlack(parent);
                        setRBNodeRed(gparent);
                        leftRotate(gparent);
                        return;
                    }
                }
            }
        }
    }


    public static class RBNode<K extends Comparable<K>, V> {
        private RBNode parent;
        public RBNode rightChild;
        public RBNode leftChild;
        private boolean color;
        private K key;
        public V value;

        public RBNode() {
        }

        public RBNode(RBNode parent, RBNode rightChild, RBNode leftChild, boolean color, K key, V value) {
            this.parent = parent;
            this.rightChild = rightChild;
            this.leftChild = leftChild;
            this.color = color;
            this.key = key;
            this.value = value;
        }

        public RBNode getParent() {
            return parent;
        }

        public void setParent(RBNode parent) {
            this.parent = parent;
        }

        public RBNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(RBNode rightChild) {
            this.rightChild = rightChild;
        }

        public RBNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(RBNode leftChild) {
            this.leftChild = leftChild;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
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
    }


}
