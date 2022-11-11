package componentes;

import javax.swing.JComboBox;

public class MeuCampoComboBox extends JComboBox implements MeuComponente {

    private String nome;
    private boolean obrigatorio;
    private Object[][] opcoes;

    public MeuCampoComboBox(String nome, Object[][] opcoes, boolean obrigatorio){
        this.nome = nome;
        this.obrigatorio = obrigatorio;
        this.opcoes = opcoes;
        adicionaOpcoes();
    }

    public void adicionaOpcoes() {
        addItem("Selecione...");
        for (Object[] opcao : opcoes) {
            addItem(opcao[1]);
        }
    }

    @Override
    public boolean isObrigatorio() {  
        return obrigatorio;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getValor() {
        if (getSelectedIndex() == 0){
            return "";
        } else {
            return "" + opcoes[getSelectedIndex() - 1][1];
        }
    }

    @Override
    public boolean isVazio() {
        return getSelectedIndex() <= 0;
    }

    @Override
    public boolean isValido() {
        return true;
    }

    @Override
    public void limpar() {
        setSelectedIndex(0);
        
    }

    @Override
    public void setValor(Object valor) {
        for (int i = 0; i < opcoes.length; i++) {
            if ((int) opcoes[i][0] == (int) valor) {
                setSelectedIndex(i+1);
                return;
            }
        }        
    } 
    
}
