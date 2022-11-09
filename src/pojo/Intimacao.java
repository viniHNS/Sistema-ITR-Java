package pojo;

import java.util.Date;

public class Intimacao {
    private int idIntimacao;
    private String numIntimacao;
    private String numConstatacao;
    private String numIntimacaoConstatacao;
    private String codRastreioIntimacao;
    private Date dataPostagemIntimacao;
    private Date dataEntregaIntimacao;
    private char ativoIntimacao; 
    private int idPropriedade;


    public int getIdIntimacao() {
        return this.idIntimacao;
    }

    public void setIdIntimacao(int idIntimacao) {
        this.idIntimacao = idIntimacao;
    }

    public String getNumIntimacao() {
        return this.numIntimacao;
    }

    public void setNumIntimacao(String numIntimacao) {
        this.numIntimacao = numIntimacao;
    }

    public String getNumConstatacao() {
        return this.numConstatacao;
    }

    public void setNumConstatacao(String numConstatacao) {
        this.numConstatacao = numConstatacao;
    }

    public String getNumIntimacaoConstatacao() {
        return this.numIntimacaoConstatacao;
    }

    public void setNumIntimacaoConstatacao(String numIntimacaoConstatacao) {
        this.numIntimacaoConstatacao = numIntimacaoConstatacao;
    }

    public String getCodRastreioIntimacao() {
        return this.codRastreioIntimacao;
    }

    public void setCodRastreioIntimacao(String codRastreioIntimacao) {
        this.codRastreioIntimacao = codRastreioIntimacao;
    }

    public Date getDataPostagemIntimacao() {
        return this.dataPostagemIntimacao;
    }

    public void setDataPostagemIntimacao(Date dataPostagemIntimacao) {
        this.dataPostagemIntimacao = dataPostagemIntimacao;
    }

    public Date getDataEntregaIntimacao() {
        return this.dataEntregaIntimacao;
    }

    public void setDataEntregaIntimacao(Date dataEntregaIntimacao) {
        this.dataEntregaIntimacao = dataEntregaIntimacao;
    }

    public char getAtivoIntimacao() {
        return this.ativoIntimacao;
    }

    public void setAtivoIntimacao(char ativoIntimacao) {
        this.ativoIntimacao = ativoIntimacao;
    }

    public int getIdPropriedade() {
        return this.idPropriedade;
    }

    public void setIdPropriedade(int idPropriedade) {
        this.idPropriedade = idPropriedade;
    }

}
