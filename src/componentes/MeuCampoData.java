package componentes;

import java.awt.Color;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

public class MeuCampoData extends JFormattedTextField implements MeuComponente{
    
    private String nome;
    private boolean obrigatorio;

    public MeuCampoData(String nome, boolean obrigatorio){
        
        try {
            this.nome = nome;
            this.obrigatorio = obrigatorio;
            adicionaFocusListener();
            MaskFormatter mf = new MaskFormatter("##/##/####");
            mf.setPlaceholderCharacter('_');
            mf.install(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void adicionaFocusListener() {
        Border bordaPadrao = getBorder();
        Color corPadrao = getBackground();
        
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
               setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
               setBackground(new Color(200, 250, 255));
            }

            @Override
            public void focusLost(FocusEvent fe) {
                setBorder(bordaPadrao);
                setBackground(corPadrao);
                
            }
        });
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
        return getValor().equals("__/__/____");
    }

    @Override
    public boolean isValido() {

        return getValor().replace("/", "").replace("_", "").length() == 8;
    }

    @Override
    public void limpar() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setValor(Object valor) {
        setText((String) valor);
    }
}    
