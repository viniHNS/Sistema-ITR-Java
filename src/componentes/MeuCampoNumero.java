package componentes;

import javax.swing.JTextField;

public class MeuCampoNumero extends JTextField implements MeuComponente{

    private String nome;
    private boolean obrigatorio;
    
    public MeuCampoNumero(int tamanho, String nome, boolean obrigatorio){
        super(tamanho);
        this.nome = nome;
        this.obrigatorio = obrigatorio;
    }

    public String getNome(){
        return nome;
    }
    
    public boolean isObrigatorio() {
        return obrigatorio;
    }

    public String getValor(){
        return getText().trim();
    }

    @Override
    public boolean isVazio(){
        return getValor().isEmpty();
    }

    @Override
    public boolean isValido() {
        String id = getValor();
        if (id.matches("^[0-9]*$")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void limpar() {
        setText("");
        
    }

    @Override
    public void setValor(Object valor) {
        setText((String) valor);
    }
}
