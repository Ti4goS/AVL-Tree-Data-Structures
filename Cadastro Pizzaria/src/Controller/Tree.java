package Controller;

import Model.empresa.Pizzaria;

class Tree{
    Pizzaria root;

    int height(Pizzaria N)
    {
        if (N == null)
            return 0;
        return N.getHeight();
    }
 
    int max(int a, int b)
    {
        return (a > b) ? a : b;
    }
 
    Pizzaria rightRotate(Pizzaria y)
    {
        Pizzaria x = y.getLeft();
        Pizzaria T2 = x.getRight();
 

        x.setRight(y);
        y.setLeft(T2);
 
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
 
        return x;
    }
 
    Pizzaria leftRotate(Pizzaria x)
    {
        Pizzaria y = x.getRight();
        Pizzaria T2 = y.getLeft();
 
        y.setLeft(x);
        x.setRight(T2);
 
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
 
        return y;
    }
 
    int getBalance(Pizzaria N)
    {
        if (N == null)
            return 0;
        return height(N.getLeft()) - height(N.getRight());
    }
 
    Pizzaria insert(Pizzaria node, int key)
    {
        
        if (node == null)
            return (new Pizzaria(key));
 
        if (key < node.getKey())
            node.setLeft(insert(node.getLeft(), key));
        else if (key > node.getKey())
            node.setRight(insert(node.getRight(), key));
        else 
            return node;
 
        node.setHeight(1 + max(height(node.getLeft()),
        height(node.getRight())));
 

        int balance = getBalance(node);
 
        if (balance > 1 && key < node.getLeft().getKey())
            return rightRotate(node);
 
        if (balance < -1 && key > node.getRight().getKey())
            return leftRotate(node);
 
        if (balance > 1 && key > node.getLeft().getKey())
        {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }
 
        if (balance < -1 && key < node.getRight().getKey())
        {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }
 
        return node;
    }
 
    Pizzaria minValueNode(Pizzaria node)
    {
        Pizzaria current = node;
 
        while (current.getLeft() != null)
        current = current.getLeft();
 
        return current;
    }
 
    Pizzaria deleteNode(Pizzaria root, int key)
    {

        if (root == null)
            return root;
 
        if (key < root.getKey())
            root.setLeft(deleteNode(root.getLeft(), key));
 
        else if (key > root.getKey())
            root.setRight(deleteNode(root.getRight(), key));
 
        else
        {
 
            if ((root.getLeft() == null) || (root.getRight() == null))
            {
                Pizzaria temp = null;
                if (temp == root.getLeft())
                    temp = root.getRight();
                else
                    temp = root.getLeft();
 
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else 
                    root = temp;
                                
            }
            else
            {
 
             
                Pizzaria temp = minValueNode(root.getRight());
 
                root.setKey(temp.getKey());
 
                root.setRight(deleteNode(root.getRight(), temp.getKey()));
            }
        }
 
        if (root == null)
            return root;
 
        root.setHeight(max(height(root.getLeft()), height(root.getRight())) + 1);
 
        int balance = getBalance(root);
 
        if (balance > 1 && getBalance(root.getLeft()) >= 0)
            return rightRotate(root);
 
        if (balance > 1 && getBalance(root.getLeft()) < 0)
        {
            root.setLeft(leftRotate(root.getLeft()));
            return rightRotate(root);
        }
 
        if (balance < -1 && getBalance(root.getRight()) <= 0)
            return leftRotate(root);
 
        if (balance < -1 && getBalance(root.getRight()) > 0)
        {
            root.setRight(rightRotate(root.getRight()));
            return leftRotate(root);
        }
 
        return root;
    }
 
    void preOrder(Pizzaria node)
    {
        if (node != null)
        {
            System.out.print(node.getKey() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
}