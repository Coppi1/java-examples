/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginBarbersoft;

/**
 *
 * @author educo
 */
public class loginAdm {
    
    String nomeAdm, emailAdm, senhaAdm, cidadeAdm;

    public loginAdm(String emailAdm, String senhaAdm) {

        this.emailAdm = emailAdm;
        this.senhaAdm = senhaAdm;
    }

    public void cadastrarAdm(String nomeAdm, String emailAdm, String senhaAdm, String cidadeAdm) {
        this.emailAdm = emailAdm;
        this.senhaAdm = senhaAdm;
        this.nomeAdm = nomeAdm;
        this.cidadeAdm = cidadeAdm;

    }

    public String getNomeAdm() {
        return nomeAdm;
    }

    public void setNomeAdm(String nomeAdm) {
        this.nomeAdm = nomeAdm;
    }

    public String getEmailAdm() {
        return emailAdm;
    }

    public void setEmailAdm(String emailAdm) {
        this.emailAdm = emailAdm;
    }

    public String getSenhaAdm() {
        return senhaAdm;
    }

    public void setSenhaAdm(String senhaAdm) {
        this.senhaAdm = senhaAdm;
    }

    public String getCidadeAdm() {
        return cidadeAdm;
    }

    public void setCidadeAdm(String cidadeAdm) {
        this.cidadeAdm = cidadeAdm;
    }

}
