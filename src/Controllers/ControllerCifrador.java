
package Controllers;

import Views.ViewCifrador;
import Models.ModelsCifrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ControllerCifrador {
   ViewCifrador viewcifrador;
    ModelsCifrador modelscifrador;
    ActionListener ac = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewcifrador.JM_ABRIR)
                    abrir();
            else if(e.getSource() == viewcifrador.JM_GUARDAR)
                    guardar();
            else if (e.getSource() == viewcifrador.JM_CIFRAR)
                    cifrar();
            else if(e.getSource() == viewcifrador.JM_DESCIFRAR)
                descifrar();
        }
    };
    public ControllerCifrador(ViewCifrador viewcifrador, ModelsCifrador modelscifrador) {
        this.viewcifrador = viewcifrador;
        this.modelscifrador = modelscifrador;
        this.viewcifrador.JM_GUARDAR.addActionListener(ac);
        this.viewcifrador.JM_ABRIR.addActionListener(ac);
        this.viewcifrador.JM_CIFRAR.addActionListener(ac);
        this.viewcifrador.JM_DESCIFRAR.addActionListener(ac);
        initComponents();
    }
    public void abrir(){
        modelscifrador.openFile();
        leer();
    }
    public void leer(){
        modelscifrador.readFile();
        viewcifrador.JTA_TEXTO.setText(modelscifrador.getMensaje());
    }
    public void cifrar(){
        modelscifrador.setMensaje(viewcifrador.JTA_TEXTO.getText());
        modelscifrador.stringCifrado();
        viewcifrador.JTA_TEXTO.setText(modelscifrador.getCaesar());
    }
    public void descifrar(){
        modelscifrador.setMensaje(viewcifrador.JTA_TEXTO.getText());
        modelscifrador.Cifrado2String();
        viewcifrador.JTA_TEXTO.setText(modelscifrador.getCaesar());
    }
    public void guardar(){
        modelscifrador.setMensaje(viewcifrador.JTA_TEXTO.getText());
        modelscifrador.writeFile();
        viewcifrador.JTA_TEXTO.setText("");
    }
    private void initComponents(){
        viewcifrador.setVisible(true);
    }
    
    
}
