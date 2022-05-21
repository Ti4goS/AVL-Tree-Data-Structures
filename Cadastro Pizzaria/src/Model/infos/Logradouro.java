package Model.infos;

public class Logradouro {
    private String endereço;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;

    
    public Logradouro(String endereço, int d, String bairro, String cidade, String estado) {
        this.endereço = endereço;
        this.numero = d;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }


    public String getEndereço() {
        return endereço;
    }


    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }


    public Integer getNumero() {
        return numero;
    }


    public void setNumero(Integer numero) {
        this.numero = numero;
    }


    public String getBairro() {
        return bairro;
    }


    public void setBairro(String bairro) {
        this.bairro = bairro;
    }


    public String getCidade() {
        return cidade;
    }


    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {
        return "Logradouro [bairro=" + bairro + ", cidade=" + cidade + ", endereço=" + endereço + ", estado=" + estado
                + ", numero=" + numero + "]";
    }
}
