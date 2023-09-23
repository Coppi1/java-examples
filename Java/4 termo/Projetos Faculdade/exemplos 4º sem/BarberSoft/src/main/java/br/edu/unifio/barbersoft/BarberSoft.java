/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.edu.unifio.barbersoft;

import LoginBarbersoftDAO.loginDAO;
import javax.swing.UIManager;
import javax.swing.text.View;
import br.edu.unifio.barbersoft.telaI1Login;

/**
 *
 * @author educo
 */
public class BarberSoft {

    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
        } catch (Exception e) {
        }
        
        telaI1Login Tlogin = new  telaI1Login();
        Tlogin.setVisible(true);
        
        
        
        
        
        
    }
}
