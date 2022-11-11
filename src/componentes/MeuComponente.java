package componentes;

public interface MeuComponente {
    public boolean isObrigatorio();
    public boolean isVazio();
    public String getNome();
    public String getValor();
    public boolean isValido();
    public void limpar();
    public void setValor(Object valor);
}
