package Controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Model.empresa.Cliente;
import Model.empresa.Empresa;
import Model.empresa.Produto;
import Model.infos.Logradouro;

public class ReadFile {
    private static String filepath = "./db.txt"; 

    public static void readDB() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.contains("Empresa:")) {
                    String nome = "";
                    String cnpj = "";
                    String email = "";
                    String nomeRepresentante = "";
                    String tipoDeEmpresa = "";
                    String rua = "";
                    int numero = 0;
                    String bairro = "";
                    String cidade = "";
                    String estado = "";

                    

                    if(line.contains("Nome="))
                        nome = getSubString(line, "Nome=");

                    if(line.contains("CNPJ="))
                        cnpj = getSubString(line,"CNPJ=");

                    

                    if(line.contains("email="))
                        email = getSubString(line,"email=");

                    if(line.contains("NomeRepresentante="))
                        nomeRepresentante = getSubString(line,"NomeRepresentante=");
                    
                    if(line.contains("tipoDeEmpresa="))
                        tipoDeEmpresa = getSubString(line,"tipoDeEmpresa=");

                    if(line.contains("Rua="))
                        rua = getSubString(line,"Rua=");

                    if(line.contains("Numero="))
                        try {
                            numero = Integer.parseInt(getSubString(line,"Numero="));
                        } catch (Exception e) {
                            numero = 00;
                        }    
                    
                    if(line.contains("Bairro="))
                        bairro = getSubString(line,"Bairro=");

                    if(line.contains("Cidade="))
                        cidade = getSubString(line,"Cidade=");

                    if(line.contains("Estado="))
                        estado = getSubString(line,"Estado=");  
                        
                    EmpresaController.empresa = new Empresa(nome, cnpj, nomeRepresentante, tipoDeEmpresa, new Logradouro(rua, numero, bairro, cidade, estado), email, new Tree());
                }

                if(line.contains("Produto:")){
                    String nome = "";
                    double valor = 0;

                    if(line.contains("Nome="))
                        nome = getSubString(line, "Nome=");

                    if(line.contains("Preco="))
                        try {
                            System.out.println(getSubString(line, "Preco="));
                            valor = Double.parseDouble(getSubString(line, "Preco="));
                        } catch (Exception e) {
                            valor = 0;
                        }

                    EmpresaController.empresa.setProduto(new Produto(valor, nome));
                }

                if (line.equals("No Clients")) {
                    reader.close();
                    return;
                }

                if(line.contains("Cliente:")){
                    String nome = "";
                    String telefone = "";
                    String cpf = "";
                    double totalGasto = 0;
                    int totalPedidos = 0;
                    String ultimoPedido = "";
                    double valorUltimoPedido = 0;
                    String rua = "";
                    int numero = 0;
                    String bairro = "";
                    String cidade = "";
                    String estado = "";

                    if(line.contains("Nome="))
                        nome = getSubString(line, "Nome=");

                    if(line.contains("Telefone="))
                        telefone = getSubString(line, "Telefone=");

                    if(line.contains("CPF="))
                    cpf = getSubString(line, "CPF=");

                    if(line.contains("TotalGasto="))
                        try {
                            totalGasto = Double.parseDouble(getSubString(line, "TotalGasto=")); 
                        } catch (Exception e) {
                            totalGasto = 0;
                        }
                        
                    if(line.contains("TotalPedidos="))
                        try {
                            totalPedidos = Integer.parseInt(getSubString(line, "TotalPedidos="));
                        } catch (Exception e) {
                            totalPedidos = 0;
                        }
                    
                    if(line.contains("UltimoPedido="))
                        ultimoPedido = getSubString(line, "UltimoPedido=");

                    if(line.contains("valorUltimoPedido="))
                        try {
                            valorUltimoPedido = Integer.parseInt(getSubString(line, "valorUltimoPedido="));
                        } catch (Exception e) {
                            valorUltimoPedido = 0;
                        }

                    if(line.contains("Rua="))
                        rua = getSubString(line, "Rua=");

                    if(line.contains("Numero="))
                        try {
                            numero = Integer.parseInt(getSubString(line, "Numero="));
                        } catch (Exception e) {
                            numero = 0;
                        }

                    if(line.contains("Bairro="))
                        bairro = getSubString(line, "Bairro=");

                    if(line.contains("Cidade="))
                        cidade = getSubString(line, "Cidade=");

                    if(line.contains("Estado="))
                        estado = getSubString(line, "Estado=");

                         EmpresaController.setRoot(new Cliente(telefone, new Logradouro(rua, numero, bairro, cidade, estado), nome, cpf, totalGasto, totalPedidos, ultimoPedido, valorUltimoPedido));
                }


                ///System.out.println(EmpresaController.empresa.toString());
            }
        }catch(FileNotFoundException e){
            System.out.println("Banco de Dados não foi encontrado");
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    private static String getSubString(String line,String lookFor) {
        int initial = line.indexOf(lookFor)+lookFor.length();
        Integer end = null;

        for (int i = initial+1; i < line.length(); i++) 
            if (line.charAt(i)=='\"') {
                end = i;
                break;
            }
        
        return line.substring(initial+1, end);
    }
}
