package componentes;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MeuCampoSimNao extends JPanel implements MeuComponente{
    private String nome;
    private JRadioButton jrbSim = new JRadioButton("S");
    private JRadioButton jrbNao = new JRadioButton("N");
    private ButtonGroup bg = new ButtonGroup();

    public MeuCampoSimNao(String nome){
        this.nome = nome;
        add(jrbSim);
        add(jrbNao);
        bg.add(jrbSim);
        bg.add(jrbNao);
        jrbSim.setSelected(true);
    }

    public boolean isObrigatorio(){
        return true;
    }

    public String getNome(){
        return nome;
    }

    public String getValor(){
        if (jrbSim.isSelected()){
            return "S";
        } else {
            return "N";
        }
    }

    @Override
    public boolean isVazio() {
        return false;
    }

    @Override
    public boolean isValido() {
        return true;
    }

    @Override
    public void limpar() {
        jrbSim.setSelected(true);
        
    }

    @Override
    public void setValor(Object valor) {
        if(((String)valor).equals("Sim")) {
            jrbSim.setSelected(true);
        } else {
            jrbNao.setSelected(true);
        }
    }
}