package Model.empresa;

public class Pizzaria extends Empresa{
    private int height;
    private Pizzaria left, right;

    public Pizzaria(Empresa empresa) {
        height = 1;

    }

  

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Pizzaria getLeft() {
        return left;
    }

    public void setLeft(Pizzaria left) {
        this.left = left;
    }

    public Pizzaria getRight() {
        return right;
    }

    public void setRight(Pizzaria right) {
        this.right = right;
    }

    
}
 
