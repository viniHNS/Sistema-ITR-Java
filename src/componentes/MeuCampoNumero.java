package componentes;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class MeuCampoNumero extends JTextField implements MeuComponente{

    private String nome;
    private boolean obrigatorio;
    
    public MeuCampoNumero(int tamanho, String nome, boolean obrigatorio){
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
}
