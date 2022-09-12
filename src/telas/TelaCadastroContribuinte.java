package telas;

import componentes.MeuCampoCEP;
import componentes.MeuCampoComboBox;
import componentes.MeuCampoTexto;

public class TelaCadastroContribuinte extends TelaCadastro{

    private MeuCampoTexto mctCodigo = new MeuCampoTexto(10, "Código", false);
    private MeuCampoTexto mctNome = new MeuCampoTexto(50, "Nome", true);
    private MeuCampoComboBox mcsnAtivo = new MeuCampoComboBox("Ativo", new Object[][] {{1, "Sim"}, {2, "Não"}}, true);
    private MeuCampoCEP mccCEP = new MeuCampoCEP("CEP", true);

    public TelaCadastroContribuinte(){

        super("Cadastro de Contribuinte");

        adicionaComponente(mctCodigo, 1, 2, 1, 1);
        adicionaComponente(mctNome, 2, 2, 1, 4);
        adicionaComponente(mcsnAtivo, 1, 4, 1, 1); 
        adicionaComponente(mccCEP, 3, 2, 1, 1); 
        

        habilitaCampos(false);
        pack();
        setVisible(true);
    }
}
