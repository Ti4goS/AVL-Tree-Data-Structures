package Controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Model.empresa.Empresa;
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

                    try {
                        if(line.contains("Numero="))
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
                        
                    EmpresaController.empresa = new Empresa(nome, cnpj, nomeRepresentante, tipoDeEmpresa, new Logradouro(rua, numero, bairro, cidade, estado), email, null);
                }
                
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
