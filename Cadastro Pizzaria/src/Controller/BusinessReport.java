package Controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import Model.Node;

public class BusinessReport {

    private String path;
    private FileWriter fileName;
    private PrintWriter writeFile;

    public BusinessReport(String path) throws IOException {
        this.path = path;
        fileName = new FileWriter(this.path);
        writeFile = new PrintWriter(fileName);
    }

    public void buildBusinessReport() throws IOException {
        writeFile.println("Nome;Numero;Total De Vendas;Media de Vendas;Ultimo Pedido");
        writeClients(EmpresaController.empresa.tree.root);
        writeFile.close();
        JOptionPane.showMessageDialog(null, "Relatório Gerado Com Sucesso", "Sucesso!", JOptionPane.OK_OPTION);
    }

    private void writeClients(Node node) {
        if (node != null) {
            writeFile.printf(
                    "%s;%s;%.0f.00;%.2f;%s\n",
                    node.cliente.getNome(), node.cliente.getTelefone(), node.cliente.getTotalGasto(),
                    getMedia(node.cliente.getTotalGasto(), node.cliente.getTotalPedidos()),
                    node.cliente.getUltimoPedido());

            writeClients(node.left);
            writeClients(node.right);
        }
    }

    private double getMedia(double totalGasto, int pedidos) {
        return (double) totalGasto / pedidos;
    }
}
