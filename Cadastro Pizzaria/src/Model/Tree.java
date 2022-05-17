package Model;

class Tree{
    Node root;
 
    // A utility function to get height of the tree
    int height(Node N)
    {
        if (N == null)
            return 0;
        return N.getHeight();
    }
 
    // A utility function to get maximum of two integers
    int max(int a, int b)
    {
        return (a > b) ? a : b;
    }
 
    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    Node rightRotate(Node y)
    {
        Node x = y.getLeft();
        Node T2 = x.getRight();
 
        // Perform rotation
        x.setRight(y);
        y.setLeft(T2);
 
        // Update heights
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
 
        // Return new root
        return x;
    }
 
    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node leftRotate(Node x)
    {
        Node y = x.getRight();
        Node T2 = y.getLeft();
 
        // Perform rotation
        y.setLeft(x);
        x.setRight(T2);
 
        // Update heights
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
 
        // Return new root
        return y;
    }
 
    // Get Balance factor of node N
    int getBalance(Node N)
    {
        if (N == null)
            return 0;
        return height(N.getLeft()) - height(N.getRight());
    }
 
    Node insert(Node node, int key)
    {
        /* 1. Perform the normal BST rotation */
        if (node == null)
            return (new Node(key));
 
        if (key < node.getKey())
            node.setLeft(insert(node.getLeft(), key));
        else if (key > node.getKey())
            node.setRight(insert(node.getRight(), key));
        else // Equal keys not allowed
            return node;
 
        /* 2. Update height of this ancestor node */
        node.setHeight(1 + max(height(node.getLeft()),
        height(node.getRight())));
 
        /* 3. Get the balance factor of this ancestor
        node to check whether this node became
        Wunbalanced */
        int balance = getBalance(node);
 
        // If this node becomes unbalanced, then
        // there are 4 cases Left Left Case
        if (balance > 1 && key < node.getLeft().getKey())
            return rightRotate(node);
 
        // Right Right Case
        if (balance < -1 && key > node.getRight().getKey())
            return leftRotate(node);
 
        // Left Right Case
        if (balance > 1 && key > node.getLeft().getKey())
        {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }
 
        // Right Left Case
        if (balance < -1 && key < node.getRight().getKey())
        {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }
 
        /* return the (unchanged) node pointer */
        return node;
    }
 
    /* Given a non-empty binary search tree, return the
    node with minimum key value found in that tree.
    Note that the entire tree does not need to be
    searched. */
    Node minValueNode(Node node)
    {
        Node current = node;
 
        /* loop down to find the leftmost leaf */
        while (current.getLeft() != null)
        current = current.getLeft();
 
        return current;
    }
 
    Node deleteNode(Node root, int key)
    {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;
 
        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if (key < root.getKey())
            root.setLeft(deleteNode(root.getLeft(), key));
 
        // If the key to be deleted is greater than the
        // root's key, then it lies in right subtree
        else if (key > root.getKey())
            root.setRight(deleteNode(root.getRight(), key));
 
        // if key is same as root's key, then this is the node
        // to be deleted
        else
        {
 
            // node with only one child or no child
            if ((root.getLeft() == null) || (root.getRight() == null))
            {
                Node temp = null;
                if (temp == root.getLeft())
                    temp = root.getRight();
                else
                    temp = root.getLeft();
 
                // No child case
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else // One child case
                    root = temp; // Copy the contents of
                                // the non-empty child
            }
            else
            {
 
                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                Node temp = minValueNode(root.getRight());
 
                // Copy the inorder successor's data to this node
                root.setKey(temp.getKey());
 
                // Delete the inorder successor
                root.setRight(deleteNode(root.getRight(), temp.getKey()));
            }
        }
 
        // If the tree had only one node then return
        if (root == null)
            return root;
 
        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.setHeight(max(height(root.getLeft()), height(root.getRight())) + 1);
 
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = getBalance(root);
 
        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.getLeft()) >= 0)
            return rightRotate(root);
 
        // Left Right Case
        if (balance > 1 && getBalance(root.getLeft()) < 0)
        {
            root.setLeft(leftRotate(root.getLeft()));
            return rightRotate(root);
        }
 
        // Right Right Case
        if (balance < -1 && getBalance(root.getRight()) <= 0)
            return leftRotate(root);
 
        // Right Left Case
        if (balance < -1 && getBalance(root.getRight()) > 0)
        {
            root.setRight(rightRotate(root.getRight()));
            return leftRotate(root);
        }
 
        return root;
    }
 
    // A utility function to print preorder traversal of
    // the tree. The function also prints height of every
    // node
    void preOrder(Node node)
    {
        if (node != null)
        {
            System.out.print(node.getKey() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
}