package pojo;

public class Estado {
    private int idEstado;
    private String nomeEstado;
    private String ufEstado;
    private char ativoEstado;
    private int idPais;


    public int getIdEstado() {
        return this.idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNomeEstado() {
        return this.nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public String getUfEstado() {
        return this.ufEstado;
    }

    public void setUfEstado(String ufEstado) {
        this.ufEstado = ufEstado;
    }

    public char getAtivoEstado() {
        return this.ativoEstado;
    }

    public void setAtivoEstado(char ativoEstado) {
        this.ativoEstado = ativoEstado;
    }

    public int getIdPais() {
        return this.idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

}
