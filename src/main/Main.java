/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import view.JanelaDoGrafico;


/**
 *
 * @author Christian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());

        } catch (Exception e) {
            System.out.println("Erro ao carregar um layout.");
            JOptionPane.showMessageDialog(null, "Erro ao carregar um layout.");
        }
        JanelaDoGrafico tela = new JanelaDoGrafico();
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);

    }

}
