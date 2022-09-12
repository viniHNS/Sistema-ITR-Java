package componentes;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MeuCampoSimNao extends JPanel implements MeuComponente{
    private String nome;
    private JRadioButton jrbSim = new JRadioButton("Sim");
    private JRadioButton jrbNao = new JRadioButton("Não");
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
            return "Sim";
        } else {
            return "Não";
        }
    }

    @Override
    public boolean isVazio() {
        return false;
    }
}
