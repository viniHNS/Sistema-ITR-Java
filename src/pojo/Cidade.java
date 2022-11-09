package pojo;

public class Cidade {
    private int idCidade;
    private String cepCidade;
    private String nomeCidade;
    private char ativoCidade;
    private int idEstado;


    public int getIdCidade() {
        return this.idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getCepCidade() {
        return this.cepCidade;
    }

    public void setCepCidade(String cepCidade) {
        this.cepCidade = cepCidade;
    }

    public String getNomeCidade() {
        return this.nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public char getAtivoCidade() {
        return this.ativoCidade;
    }

    public void setAtivoCidade(char ativoCidade) {
        this.ativoCidade = ativoCidade;
    }

    public int getIdEstado() {
        return this.idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

}
