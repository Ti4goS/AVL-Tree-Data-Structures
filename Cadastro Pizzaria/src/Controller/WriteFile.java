package Controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import Model.Node;
import Model.empresa.Empresa;
import Model.empresa.Produto;

public class WriteFile {

    private FileWriter fileName = new FileWriter("./db.txt");
    private PrintWriter writeFile = new PrintWriter(fileName);

    public WriteFile(Empresa empresa) throws IOException {

        if (empresa == null) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro com a empresa", "ERRO!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        writeFile.printf(
                "Empresa: Nome=\"%s\" CNPJ=\"%s\" email=\"%s\" NomeRepresentante=\"%s\" tipoDeEmpresa=\"%s\" Rua=\"%s\" Numero= \"%d\" Bairro=\"%s\" Cidade=\"%s\" Estado=\"%s\"\n",
                empresa.getNomeFantasia(),empresa.getCnpj(), empresa.getEmail(), empresa.getNomeRepresentante(),
                empresa.getTipoDeEmpresa(), empresa.getEndereco().getEndereço(), empresa.getEndereco().getNumero(),
                empresa.getEndereco().getBairro(), empresa.getEndereco().getBairro(), empresa.getEndereco().getCidade(),
                empresa.getEndereco().getEstado());


        for (Produto p : empresa.getProdutos()) {
            writeFile.printf("Produto: Nome=\"%s\" Preco=\"%.0f.00\"\n",p.getNome(),p.getValor());
        }
        
        if (empresa.tree.root == null) {
            writeFile.printf("No Clients\n");
            writeFile.close();
            return;
        }

        writeClients(empresa.tree.root);
        writeFile.close();

    }

    private void writeClients(Node node) {
        if (node != null) {
            writeFile.printf(
                    "Cliente: Nome=\"%s\" Telefone=\"%s\" CPF=\"%s\" TotalGasto=\"%.0f.00\" TotalPedidos=\"%d\" UltimoPedido=\"%s\" valorUltimoPedido=\"%.0f.00\" Rua=\"%s\" Numero=\"%d\" Bairro=\"%s\" Cidade=\"%s\" Estado=\"%s\" \n",
                    node.cliente.getNome(), node.cliente.getTelefone(), node.cliente.getCpf(),
                    node.cliente.getTotalGasto(), node.cliente.getTotalPedidos(), node.cliente.getUltimoPedido(),
                    node.cliente.getValorDoUltimoPedido(), node.cliente.getEndereco().getEndereço(),
                    node.cliente.getEndereco().getNumero(), node.cliente.getEndereco().getBairro(),
                    node.cliente.getEndereco().getCidade(), node.cliente.getEndereco().getEstado());
            
            writeClients(node.left);
            writeClients(node.right);
        }
    }
}
