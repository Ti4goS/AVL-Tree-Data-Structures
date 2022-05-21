package Model.infos;

public class Pessoa {
    private int idade;
    private String telefone;
    private Logradouro endereco;
    private String nome;
    private String cpf;
    
    public Pessoa(int idade, String telefone, Logradouro endereco, String nome, String cpf) {
        this.idade = idade;
        this.telefone = telefone;
        this.endereco = endereco;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Pessoa(String telefone, Logradouro endereco, String nome, String cpf2) {
        this.telefone = telefone;
        this.endereco = endereco;
        this.nome = nome;
        this.cpf = cpf2;
    }

    @Override
    public String toString() {
        return "Pessoa [cpf=" + cpf + ", endereco=" + endereco.toString() + ", idade=" + idade + ", nome=" + nome + ", telefone="
                + telefone.toString() + "]";
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Logradouro getEndereco() {
        return endereco;
    }

    public void setEndereco(Logradouro endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
