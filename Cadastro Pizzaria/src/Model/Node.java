package Model;

import Model.empresa.Cliente;

public class Node {
    public Cliente cliente;
    public int height;
    public Node left,right;

    public Node(Cliente cliente){
        this.height = 1;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Node [node=" + cliente.toString() + "]";
    }
}
