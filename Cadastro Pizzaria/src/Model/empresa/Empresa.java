package Model.empresa;

import Model.infos.Logradouro;

import java.util.ArrayList;

import Controller.Tree;

public class Empresa {
    private String nomeFantasia;
    private String cnpj;
    private String nomeRepresentante;
    private String tipoDeEmpresa;
    private Logradouro endereco;
    private String email;
    public Tree tree;
    private ArrayList<Produto> produtos = new ArrayList<Produto>();

    public Empresa(String nomeFantasia, String cnpj, String nomeRepresentante, String tipoDeEmpresa,
            Logradouro endereco,
            String email, Tree tree, Produto prod) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.nomeRepresentante = nomeRepresentante;
        this.tipoDeEmpresa = tipoDeEmpresa;
        this.endereco = endereco;
        this.email = email;
        this.tree = tree;
        produtos.add(prod);
    }

    public Empresa(String nomeFantasia, String cnpj, String nomeRepresentante, String tipoDeEmpresa,
            Logradouro endereco,
            String email, Tree tree) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.nomeRepresentante = nomeRepresentante;
        this.tipoDeEmpresa = tipoDeEmpresa;
        this.endereco = endereco;
        this.email = email;
        this.tree = tree;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeRepresentante() {
        return nomeRepresentante;
    }

    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }

    public String getTipoDeEmpresa() {
        return tipoDeEmpresa;
    }

    public void setTipoDeEmpresa(String tipoDeEmpresa) {
        this.tipoDeEmpresa = tipoDeEmpresa;
    }

    public Logradouro getEndereco() {
        return endereco;
    }

    public void setEndereco(Logradouro endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public String[] getArrayStringProdutos() {
        String[] array = new String[produtos.size()];
        int i = 0;
        
        for (Produto p  : produtos) {
            array[i] = p.getNome();
            i++;
        }

        return array;
    }

    public void setProduto(Produto prod) {
        this.produtos.add(prod);
    }

    @Override
    public String toString() {
        return "Empresa [cnpj=" + cnpj + ", email=" + email + ", endereco=" + endereco + ", nomeFantasia="
                + nomeFantasia + ", nomeRepresentante=" + nomeRepresentante + ", tipoDeEmpresa=" + tipoDeEmpresa + "]";
    }

    public boolean cadastrarProduto(String produto, double valor) {
        return false;
    }
}
