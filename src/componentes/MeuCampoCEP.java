package componentes;

import java.awt.Color;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

public class MeuCampoCEP extends JFormattedTextField implements MeuComponente{

    private String nome;
    private boolean obrigatorio;

    public MeuCampoCEP(String nome, boolean obrigatorio){
        
        try {
            this.nome = nome;
            this.obrigatorio = obrigatorio;
            MaskFormatter mf = new MaskFormatter("#####-###");
            mf.setPlaceholderCharacter('_');
            mf.install(this);

        } catch (Exception e) {
            e.printStackTrace();
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
        return getText();
    }

    @Override
    public boolean isVazio() {
        return getValor().equals("_____-___");
    }

    @Override
    public boolean isValido() {

        return getValor().replace("-", "").replace("_", "").length() == 8;

    //    String v1 = getValor();
    //    String v2 = v1.replace("-", "");
    //    String v3 = v2.replace("_", "");
    //    int n = v3.length();
    //    return n == 8;
        
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
