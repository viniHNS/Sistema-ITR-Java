package telas;

import componentes.MeuCampoCEP;
import componentes.MeuCampoComboBox;
import componentes.MeuCampoTexto;

public class TelaCadastroCidade extends TelaCadastro{

    private MeuCampoTexto mctCodigo = new MeuCampoTexto(5, "Código", true);
    private MeuCampoTexto mctNome = new MeuCampoTexto(30, "Nome", true);
    private MeuCampoComboBox mcsnAtivo = new MeuCampoComboBox("Ativo", new Object[][] {{1, "Sim"}, {2, "Não"}}, true);
    private MeuCampoComboBox mcsnUF = new MeuCampoComboBox("UF", new Object[][] {{1, "PR"}, {2, "SP"}}, true);
    private MeuCampoCEP mcCEP = new MeuCampoCEP("CEP", true);


    public TelaCadastroCidade(){
        super("Cadastro de Cidade");

        adicionaComponente(mctCodigo, 1, 1, 1, 1);
        adicionaComponente(mcsnAtivo, 5, 1, 1, 1);
        adicionaComponente(mctNome, 2, 1, 1, 2);
        adicionaComponente(mcsnUF, 2, 4, 1, 1);
        adicionaComponente(mcCEP, 4, 1, 1, 1);

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
