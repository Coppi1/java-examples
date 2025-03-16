package com.example.servletEndPoints.exercicioServidorProdutos.Model;

public class Response {
    private Integer status;
    private String mensagem;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}