package View;
import java.awt.event.WindowEvent;    
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import Controller.EmpresaController;
import Controller.ReadFile;
import Controller.WriteFile;   

public class Window implements WindowListener {

    @Override
    public void windowOpened(WindowEvent e) {
        try {
            ReadFile.readDB();
        } catch (Exception exp) {
            JOptionPane.showConfirmDialog(null, "Ainda não existe um banco de dados, falar com desenvolvedores");
        }
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            WriteFile wf = new WriteFile(EmpresaController.empresa);
        } catch (IOException e1) {
            JOptionPane.showConfirmDialog(null, "Erro ao salvar o Banco de Dados");
        }
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
     
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
       
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }


    
}
