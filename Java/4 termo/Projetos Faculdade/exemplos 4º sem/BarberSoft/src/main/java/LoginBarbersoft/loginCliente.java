/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginBarbersoft;

/**
 *
 * @author educo
 */
public class loginCliente {
    
    String nomeCliente, emailCliente, senhaCliente, cidadeCliente;

    public loginCliente(String emailCliente, String senhaCliente) {
        this.emailCliente = emailCliente;
        this.senhaCliente = senhaCliente;
    }
    
    public void cadastrarCliente(String nomeCliente,String emailCliente, String senhaCliente, String cidadeCliente){
        this.emailCliente = emailCliente;
        this.senhaCliente = senhaCliente;
        this.nomeCliente = nomeCliente;
        this.cidadeCliente = cidadeCliente;
    
}

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getSenhaCliente() {
        return senhaCliente;
    }

    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }

    public String getCidadeCliente() {
        return cidadeCliente;
    }

    public void setCidadeCliente(String cidadeCliente) {
        this.cidadeCliente = cidadeCliente;
    }
    
    
    
    
}
