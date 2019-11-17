package com.springboot.demo;

public class RBTree<T extends Comparable<T>> {//红黑树
    private static final Boolean RED = false;
    private static final Boolean BLACK = true;
    private RBNode<T> root;//根结点
    private int nodeNum;//节点个数
    public RBTree(){
        root = null;
        nodeNum = 0;
    }

     class RBNode<T extends Comparable<T>> {//红黑树--节点类
        boolean color;//颜色
        T key;//关键值
        RBNode<T> left;//左子节点
        RBNode<T> right;//右子节点
        RBNode<T> parent;//父节点
        public RBNode(boolean color, T key, RBNode<T> parent, RBNode<T> left,RBNode<T> right){
            this.color = color;
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
        //获得节点的关键值
        public T getKey(){
            return key;
        }
        //打印节点的关键值和颜色信息
        public String toString(){
            return ""+key+(this.color == RED ? "R":"B");
        }
    }

    /*************对红黑树节点x进行左旋操作 ******************/
    /*
     * 左旋示意图：对节点x进行左旋
     *     p                       p
     *    /                       /
     *   x                      y
     *  / \                     / \
     * lx  y      ----->   x  ry
     *    / \                 / \
     *   ly ry             lx ly
     * 左旋做了三件事：
     * 1. 将y的左子节点赋给x的右子节点,并将x赋给y左子节点的父节点(y左子节点非空时)
     * 2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
     * 3. 将y的左子节点设为x，将x的父节点设为y
     */
    private void leftRotate(RBNode<T> x){
        //1.将y的左子节点赋给x的右子节点，并将x赋给y左子节点的父节点（y左子节点非空时）
        RBNode<T> y = x.right;
        x.right = y.left;
        if(y.left != null){
            y.left.parent = x;
        }
        //2.将x的父节点p（非空时）赋給y的父节点，同时更新p的子节点为y（左或右）
        y.parent = x.parent;
        if(x.parent == null){
            this.root = y;//如果x的父节点为空（即x为根结点），则将y设为根结点
        }
        else {
            if(x == x.parent.left){//如果x是左子节点
                x.parent.left = y;//将y设为左子节点
            }
            else{
                x.parent.right = y;//否则将y设为右子节点
            }
        }
        //3.将y的左子节点设为x，将x的父节点设为y
        y.left = x;
        x.parent = y;
    }

    /*************对红黑树节点y进行右旋操作 ******************/
    /*
     * 左旋示意图：对节点y进行右旋
     *        p                   p
     *       /                   /
     *      y                  x
     *     / \                 / \
     *    x  ry   -----> lx  y
     *   / \                     / \
     * lx  rx                 rx ry
     * 右旋做了三件事：
     * 1. 将x的右子节点赋给y的左子节点,并将y赋给x右子节点的父节点(x右子节点非空时)
     * 2. 将y的父节点p(非空时)赋给x的父节点，同时更新p的子节点为x(左或右)
     * 3. 将x的右子节点设为y，将y的父节点设为x
     */
    public void rightRotate(RBNode<T> y){
        //1.将y的左子节点赋给x的右子节点，并将x赋給y左子节点的父节点（y左子节点非空时）
        RBNode<T> x = y.left;
        y.left = x.right;
        if(x.right != null){
            x.right.parent = y;
        }
        //2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
        x.parent = y.parent;
        if(y.parent == null){
            this.root = x;//如果y的父节点为空(即y为根节点)，则旋转后将x设为根节点
        }else{
            if(y == y.parent.left){//如果y是左子节点
                y.parent.left = x;//则将x也设置为左子节点
            }else{
                y.parent.right = x;//否则将x设置为右子节点
            }
        }
        //3. 将x的左子节点设为y，将y的父节点设为y
        x.right = y;
        y.parent = x;
    }

    /*********************** 向红黑树中插入节点 **********************/
    public void insert(T key){
        RBNode<T> node = new RBNode<>(RED,key,null,null,null);
        if(node != null){
            insert(node);
        }
    }
    public void insert(RBNode<T> node){
        RBNode<T> current = null;//表示最后node的父节点
        RBNode<T> x = this.root;//用来向下索引
        //1.找到插入位置
        while(x != null){
            current = x;
            int cmp = node.key.compareTo(x.key);
            if(cmp < 0){
                x = x.left;
            }
            else{
                x = x.right;
            }
        }
        node.parent = current;//找到了插入的位置，将当前current作为node的父节点
        if(current != null){
            int cmp = node.key.compareTo(current.key);
            if(cmp < 0){
                current.left = node;
            }
            else{
                current.right = node;
            }
        }
        else{
            this.root = node;
        }
        //3.利用旋转操作将其修正为一颗红黑树
        insertFixUp(node);
    }

    private void insertFixUp(RBNode<T> node){
        RBNode<T> parent,gparent;//定义父节点和祖父节点
        //需要修正的条件，父节点存在，且父节点的颜色是红色
        while ((parent = node.parent) != null && parent.color == RED){
            gparent = parent.parent;//获得祖父节点
            //若父节点是祖父结点的左子节点，下面的else相反
            if(gparent.left == parent){//这里的祖父节点一定存在，如果不存在，那么parent节点就是根节点，则不需要修正
                RBNode<T> uncle = gparent.right;//获得叔叔结点
                //case1：叔叔节点也是红色
                if(uncle != null && uncle.color == RED){
                    setBlack(parent);//把父节点和叔叔节点涂黑
                    setBlack(uncle);
                    setRed(gparent);//祖父节点涂红
                    node = gparent;//把当前位置放到祖父节点处
                    continue;//继续循环重新判断
                }
                //case2：叔叔节点是黑色，且当前节点是右子节点
                if(node == parent.right){
                    leftRotate(parent);//以父节点为支点进行左旋
                    RBNode<T> temp = parent;//然后将父节点和自己调换一下，为下面右旋做准备
                    parent = node;
                    node  = temp;
                }
                //case3：叔叔节点是黑色，且当前节点是左子节点
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
            }
            else{//若父节点是祖父节点的右子节点，与上面的情况相反
                RBNode<T> uncle = gparent.left;
                //case1：叔叔节点也是红色
                if(uncle != null && uncle.color == RED){
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }
                //case2: 叔叔结点是黑色的，且当前结点是左子节点
                if(node == parent.left){
                    rightRotate(parent);
                    RBNode<T> temp = parent;
                    parent = node;
                    node = temp;
                }
                //case3: 叔叔结点是黑色的，且当前结点是右子节点
                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }
        //将根节点色设置为黑色
        setBlack(root);
    }
    public void setBlack(RBNode<T> node){
        node.color = true;
    }
    public void setRed(RBNode<T> node){
        node.color = false;
    }

}
