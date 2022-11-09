package telas;

import componentes.MeuCampoComboBox;
import componentes.MeuCampoData;
import componentes.MeuCampoNumIntimacao;
import componentes.MeuCampoNumero;
import componentes.MeuCampoTexto;

public class TelaCadastroPropriedade extends TelaCadastro{

    private MeuCampoTexto mctCodigo = new MeuCampoTexto(5, "Código", false);
    private MeuCampoTexto mctNome = new MeuCampoTexto(20, "Nome", true);
    private MeuCampoComboBox mcsnAtivo = new MeuCampoComboBox("Ativo", new Object[][] {{1, "Sim"}, {2, "Não"}}, true);
    private MeuCampoNumero mcnNIRF = new MeuCampoNumero(5, "NIRF", true);
    private MeuCampoNumero mcnArea = new MeuCampoNumero(5, "Area Total", true);
    private MeuCampoComboBox mccbContribuinte = new MeuCampoComboBox("Contribuinte", new Object[][] {{1, "Nome Contribuinte1"}, {2, "Nome Contribuinte2"}}, true);
    private MeuCampoComboBox mccbSituacao = new MeuCampoComboBox("Situação", new Object[][] {{1, "Em análise"},{2, "Liberado"}, {3, "Protocolado"}, {4, "Vencido"}, {5, "Levar RFB"}}, true);

    public TelaCadastroPropriedade() {
        super("Cadastro da Propriedade");

        adicionaComponente(mctCodigo, 1, 1, 1, 1);
        adicionaComponente(mctNome, 2, 1, 1, 1);
        adicionaComponente(mcnNIRF, 3,1,1,1);
        adicionaComponente(mcnArea, 3,3,1,1);
        adicionaComponente(mccbContribuinte, 4,1,1,1);
        adicionaComponente(mccbSituacao, 5,1,1,1);
        adicionaComponente(mcsnAtivo, 6, 1, 1, 1);

        habilitaCampos(false);
        pack();        
        setVisible(true);

    }

    @Override
    public boolean incluir() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean alterar() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean excluir() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean consultar() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
