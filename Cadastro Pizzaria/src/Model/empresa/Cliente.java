package Model.empresa;


import Model.infos.Logradouro;
import Model.infos.Pessoa;


public class Cliente extends Pessoa {
    /**
     * media de consumo
     * enviar desconto para consumo acima de X
     * total de pedidos
     */
    private double totalGasto;
    private int totalPedidos;
    private String ultimoPedido;
    private double valorDoUltimoPedido;


    public Cliente(String telefone, Logradouro endereco, String nome, String cpf, double totalGasto, int totalPedidos, String ultimoPedido, double valorDoUltimoPedido) {
        super(telefone, endereco, nome, cpf);
        this.totalGasto = totalGasto;
        this.totalPedidos = totalPedidos;
        this.ultimoPedido = ultimoPedido;
        this.valorDoUltimoPedido = valorDoUltimoPedido;
    }


    public double getMediaGasto() {
        return totalGasto/totalPedidos;    
    }

    public double getTotalGasto() {
        return totalGasto;
    }


    public void setTotalGasto(double ultimoPedido) {
        this.totalGasto += ultimoPedido;
        setValorDoUltimoPedido(ultimoPedido);
    }


    public int getTotalPedidos() {
        return totalPedidos;
    }


    private void addTotalPedidos() {
        this.totalPedidos++;
    }


    public String getUltimoPedido() {
        return ultimoPedido;
    }


    public void setUltimoPedido(Produto p) {
        this.ultimoPedido = p.getNome();
        setTotalGasto(p.getValor());
    }


    public double getValorDoUltimoPedido() {
        return valorDoUltimoPedido;
    }


    private void setValorDoUltimoPedido(double valorDoUltimoPedido) {
        this.valorDoUltimoPedido = valorDoUltimoPedido;
        addTotalPedidos();
    }


    @Override
    public String toString() {
        
        return super.toString() + "Cliente [totalGasto=" + totalGasto + ", totalPedidos=" + totalPedidos + ", ultimoPedido=" + ultimoPedido
                + ", valorDoUltimoPedido=" + valorDoUltimoPedido + "]";
    }

    
}
