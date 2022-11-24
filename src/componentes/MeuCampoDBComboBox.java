package componentes;

import bd.Conexao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class MeuCampoDBComboBox extends JComboBox implements MeuComponente{

    private boolean obrigatorio;
    private String sql;
    private String nome;
    private List<Integer> pks;

    public MeuCampoDBComboBox(boolean obrigatorio, String sql, String nome){
        this.obrigatorio = obrigatorio;
        this.sql = sql;
        this.nome = nome;
        preencher();
    }

    public void preencher(){
        removeAllItems();
        pks = new ArrayList();
        List<List<String>> dados = Conexao.executaQuery(sql);
        pks.add(-1);
        addItem("Selecione...");
        for(int i = 0; i < dados.size(); i++){
            pks.add(Integer.parseInt(dados.get(i).get(0)));
            addItem(dados.get(i).get(1));
        }
        setSelectedIndex(0);
    }

    @Override
    public boolean isObrigatorio() {
        return obrigatorio;
    }

    @Override
    public boolean isVazio() {
        return true;
    }

    @Override
    public String getNome() {
       return nome;
    }

    @Override
    public String getValor() {
        return "" + pks.get(getSelectedIndex());
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
        for(int i = 0; i < pks.size(); i++){
            if(pks.get(i) == (int) valor){
                setSelectedIndex(i);
                return;
            }
        }
        setSelectedIndex(0);
    }
    
}
