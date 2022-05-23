package Controller;

import Model.Node;
import Model.empresa.Cliente;

public class Tree {
    public Node root;

    public Tree() {
        this.root = null;
    }

    int height(Node N) {
        if (N == null)
          return 0;
        return N.height;
      }
    
      int max(int a, int b) {
        return (a > b) ? a : b;
      }


    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        return x;
      }
    
      Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return y;
      }
    
      // Get balance factor of a node
      int getBalanceFactor(Node N) {
        if (N == null)
          return 0;
        return height(N.left) - height(N.right);
      }
    

      // Insert a node
      public Node insert(Node node, Cliente key) {
 
        /* 1.  Perform the normal BST insertion */
        if (node == null)
            return (new Node(key));
 
        if (key.getNome().compareToIgnoreCase(node.cliente.getNome()) < 0)
            node.left = insert(node.left, key);
        else if (key.getNome().compareToIgnoreCase(node.cliente.getNome()) > 0)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;
 
        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),
                              height(node.right));
 
        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalanceFactor(node);
 
        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key.getNome().compareToIgnoreCase(node.cliente.getNome()) < 0)
            return rightRotate(node);
 
        // Right Right Case
        if (balance < -1 && key.getNome().compareToIgnoreCase(node.cliente.getNome()) > 0)
            return leftRotate(node);
 
        // Left Right Case
        if (balance > 1 && key.getNome().compareToIgnoreCase(node.cliente.getNome()) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
 
        // Right Left Case
        if (balance < -1 && 0>key.getNome().compareToIgnoreCase(node.cliente.getNome())) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
 
        /* return the (unchanged) node pointer */
        return node;
    }
      Node nodeWithMimumValue(Node node) {
        Node current = node;
        while (current.left != null)
          current = current.left;
        return current;
      }
    
      // Delete a node
    // A utility function to get the height of the tree
    Node deleteNode(Node root, Cliente item) {

        // Find the node to be deleted and remove it
        if (root == null)
          return root;
        if (item.getNome().compareToIgnoreCase(root.cliente.getNome()) < 0)
          root.left = deleteNode(root.left, item);
        else if (item.getNome().compareToIgnoreCase(root.cliente.getNome()) < 0)
          root.right = deleteNode(root.right, item);
        else {
          if ((root.left == null) || (root.right == null)) {
            Node temp = null;
            if (temp == root.left)
              temp = root.right;
            else
              temp = root.left;
            if (temp == null) {
              temp = root;
              root = null;
            } else
              root = temp;
          } else {
            Node temp = nodeWithMimumValue(root.right);
            root.cliente = temp.cliente;
            root.right = deleteNode(root.right, temp.cliente);
          }
        }
        if (root == null)
          return root;
    
        // Update the balance factor of each node and balance the tree
        root.height = max(height(root.left), height(root.right)) + 1;
        int balanceFactor = getBalanceFactor(root);
        if (balanceFactor > 1) {
          if (getBalanceFactor(root.left) >= 0) {
            return rightRotate(root);
          } else {
            root.left = leftRotate(root.left);
            return rightRotate(root);
          }
        }
        if (balanceFactor < -1) {
          if (getBalanceFactor(root.right) <= 0) {
            return leftRotate(root);
          } else {
            root.right = rightRotate(root.right);
            return leftRotate(root);
          }
        }
        return root;
      }
    

      public Node search(String nome, String CPF){ 
        return search_Recursive(root, nome,CPF); 
        
    } 
 
    

    // recursive insert function
    public Node search_Recursive(Node r, String nome, String CPF) {
        // Base Cases: root is null or key is present at root
        if (r == null
                || (r.cliente.getNome().toLowerCase().contains(nome) && r.cliente.getCpf().toLowerCase().contains(CPF)))
            return r;
        // val is greater than root's key

        if (r.cliente.getNome().compareToIgnoreCase(nome) > 1)
            return search_Recursive(r.left, nome, CPF);
        // val is less than root's key
        return search_Recursive(r.right, nome, CPF);
    }

    // A utility function to print preorder traversal
    // of the tree.
    // The function also prints height of every node
    public void preOrder(Node node) {

        if (node != null) {
            System.out.println(node.cliente.toString() + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}