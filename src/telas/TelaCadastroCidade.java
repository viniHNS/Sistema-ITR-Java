package telas;

import componentes.MeuCampoComboBox;
import componentes.MeuCampoTexto;

public class TelaCadastroCidade extends TelaCadastro{

    private MeuCampoTexto mctCodigo = new MeuCampoTexto(5, "Código", false);
    private MeuCampoTexto mctNome = new MeuCampoTexto(20, "Nome", true);
    private MeuCampoComboBox mcsnAtivo = new MeuCampoComboBox("Ativo", new Object[][] {{1, "Sim"}, {2, "Não"}}, true);
    private MeuCampoComboBox mcsnUF = new MeuCampoComboBox("UF", new Object[][] {{1, "PR"}, {2, "SP"}}, true);


    public TelaCadastroCidade(){
        super("Cadastro de Cidade");

        adicionaComponente(mctCodigo, 1, 2, 1, 1);
        adicionaComponente(mctNome, 2, 2, 1, 3);
        adicionaComponente(mcsnAtivo, 1, 4, 1, 1);
        adicionaComponente(mcsnUF, 3, 2, 1, 3);

        habilitaCampos(false);
        pack();
        setVisible(true);
    }
}
