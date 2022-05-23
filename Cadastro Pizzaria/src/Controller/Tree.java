package Controller;

import Model.Node;
import Model.empresa.Cliente;

public class Tree {
    public Node root;

    public Tree() {
        this.root = null;
    }

    void deleteKey(Cliente c) { 
      root = deleteRecursive(root, c); 
  } 
 
  //recursive delete function
  Node deleteRecursive(Node root, Cliente c)  { 
      //tree is empty
      if (root == null)  return root; 
 
      //traverse the tree
      if (c.getNome().compareToIgnoreCase(root.cliente.getNome()) < 0)     //traverse left subtree 
          root.left = deleteRecursive(root.left, c); 
      else if (c.getNome().compareToIgnoreCase(root.cliente.getNome()) > 0)  //traverse right subtree
          root.right = deleteRecursive(root.right, c); 
      else  { 
          // node contains only one child
          if (root.left == null) 
              return root.right; 
          else if (root.right == null) 
              return root.left; 
 
          // node has two children; 
          //get inorder successor (min value in the right subtree) 
          root.cliente = minValue(root.right); 
 
          // Delete the inorder successor 
          root.right = deleteRecursive(root.right, root.cliente); 
      } 
      return root; 
  } 
 
  Cliente minValue(Node root)  { 
      //initially minval = root
      Cliente minval = root.cliente; 
      //find minval
      while (root.left != null)  { 
          minval = root.left.cliente; 
          root = root.left; 
      } 
      return minval; 
  } 
 
  // insert a node in BST 
  void insert(Cliente key)  { 
      root = insertRecursive(root, key); 
  } 
 
  //recursive insert function
  Node insertRecursive(Node root, Cliente c) { 
        //tree is empty
      if (root == null) { 
          root = new Node(c); 
          return root; 
      } 
      //traverse the tree
      if (c.getNome().compareToIgnoreCase(root.cliente.getNome()) < 0)     //insert in the left subtree
          root.left = insertRecursive(root.left, c); 
      else if (c.getNome().compareToIgnoreCase(root.cliente.getNome()) > 0)    //insert in the right subtree
          root.right = insertRecursive(root.right, c); 
        // return pointer
      return root; 
  } 


  
  public Node search(String nome, String cpf)  { 
      return searchRecursive(root, nome,cpf); 
    
  } 
 
  //recursive insert function
  private Node searchRecursive(Node root, String nome, String cpf)  { 
      // Base Cases: root is null or key is present at root 
      if (root==null || root.cliente.igual(nome,cpf)) 
          return root; 
      // val is greater than root's key 
      if (root.cliente.getNome().compareToIgnoreCase(nome) > 0) 
          return searchRecursive(root.left, nome,cpf); 
      // val is less than root's key 
      return searchRecursive(root.right, nome,cpf); 
  } 
}