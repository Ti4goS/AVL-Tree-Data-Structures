package View;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class getCaminho {
    private  String caminho;
    public getCaminho() {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Informe o diretório onde quer salvar o arquivo",
                    "txt","csv");
            chooser.setFileFilter(filter);
            int retorno = chooser.showOpenDialog(null);
            if (retorno == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(null, caminho = chooser.getSelectedFile().getAbsolutePath());
            }
    }
    public String localDoAqruivo(){
        return caminho + ".csv";
    }

}
