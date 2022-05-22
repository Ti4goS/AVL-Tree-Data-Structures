package Model.empresa;

import java.util.ArrayList;
import java.util.Set;

public class Produto {

    private String nome;
    private Double valor;

    public Produto(Double value, String name) {
        this.valor = value;
        this.nome = name;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", valor=" + valor + "]";
    }

}
