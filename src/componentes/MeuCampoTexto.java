
package componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MeuCampoTexto extends JTextField implements MeuComponente{
    private String nome;
    private boolean obrigatorio;
    
    public MeuCampoTexto(int tamanho, String nome, boolean obrigatorio){
        super(tamanho);
        this.nome = nome;
        this.obrigatorio = obrigatorio;
        adicionaFocusListener();
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
    
    public void adicionaFocusListener() {
        Border bordaPadrao = getBorder();
        Color corPadrao = getBackground();
        
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
               setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
               setBackground(new Color(200, 200, 200));
            }

            @Override
            public void focusLost(FocusEvent fe) {
                setBorder(bordaPadrao);
                setBackground(corPadrao);
                
            }
        });
    }

    @Override
    public boolean isValido() {
        return true;
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
