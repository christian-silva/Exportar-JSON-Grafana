/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.util.Date;

/**
 *
 * @author Christian
 */
public class dashboard {
    private String  data_criacao;
    private String  data_modificacao;
    private String slug;
    private String titulo;
    private String dados;
    private int id_organizacao;
    private String nome_organizacao;

    public dashboard() {
    }

    public dashboard(String data_criacao, String data_modificacao, String slug, String titulo, String dados, int id_organizacao, String nome_organizacao) {
        this.data_criacao = data_criacao;
        this.data_modificacao = data_modificacao;
        this.slug = slug;
        this.titulo = titulo;
        this.dados = dados;
        this.id_organizacao = id_organizacao;
        this.nome_organizacao = nome_organizacao;
    }

    
    

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(String data_criacao) {
        this.data_criacao = data_criacao;
    }

    public String getData_modificacao() {
        return data_modificacao;
    }

    public void setData_modificacao(String data_modificacao) {
        this.data_modificacao = data_modificacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    public int getId_organizacao() {
        return id_organizacao;
    }

    public void setId_organizacao(int id_organizacao) {
        this.id_organizacao = id_organizacao;
    }

    public String getNome_organizacao() {
        return nome_organizacao;
    }

    public void setNome_organizacao(String nome_organizacao) {
        this.nome_organizacao = nome_organizacao;
    }

    @Override
    public String toString() {
        return "dashboard{" + "data_criacao=" + data_criacao + ", data_modificacao=" + data_modificacao + ", slug=" + slug + ", titulo=" + titulo + ", dados=" + dados + ", id_organizacao=" + id_organizacao + ", nome_organizacao=" + nome_organizacao + '}';
    }

}
