package Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import Model.empresa.Cliente;

public class CriaArquivo {
    public String caminho;

    public CriaArquivo() throws IOException{
        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".csv", "csv");
        file.setFileFilter(filter);

        file.setDialogType(JFileChooser.SAVE_DIALOG);
        int j= file.showSaveDialog(null);
        if (j!=1){
            File arquivo = file.getSelectedFile();
            FileWriter arq = new FileWriter(arquivo + ".csv");
            PrintWriter gravarArq = new PrintWriter(arq);
        }
        }   
}