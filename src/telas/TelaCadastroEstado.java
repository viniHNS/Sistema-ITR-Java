package telas;

import componentes.MeuCampoComboBox;
import componentes.MeuCampoTexto;

public class TelaCadastroEstado extends TelaCadastro{

    private MeuCampoTexto mctCodigo = new MeuCampoTexto(5, "Código", false);
    private MeuCampoTexto mctNome = new MeuCampoTexto(20, "Nome", true);
    private MeuCampoTexto mctNomeUf = new MeuCampoTexto(5, "Sigla UF", true);
    private MeuCampoComboBox mcsnAtivo = new MeuCampoComboBox("Ativo", new Object[][] {{1, "Sim"}, {2, "Não"}}, true);

    public TelaCadastroEstado(){

        super("Cadastro de Estado");

        adicionaComponente(mctCodigo, 1, 2, 1, 1);
        adicionaComponente(mctNome, 2, 2, 1, 3);
        adicionaComponente(mctNomeUf, 3, 2, 1, 3);
        adicionaComponente(mcsnAtivo, 1, 4, 1, 1);

        habilitaCampos(false);
        pack();
        setVisible(true);
    }
}
