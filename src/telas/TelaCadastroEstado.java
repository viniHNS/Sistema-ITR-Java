package telas;

import componentes.MeuCampoComboBox;
import componentes.MeuCampoTexto;

public class TelaCadastroEstado extends TelaCadastro{

    private MeuCampoTexto mctCodigo = new MeuCampoTexto(5, "Código", true);
    private MeuCampoTexto mctNome = new MeuCampoTexto(30, "Nome", true);
    private MeuCampoTexto mctNomeUf = new MeuCampoTexto(5, "UF", true);
    private MeuCampoComboBox mcsnAtivo = new MeuCampoComboBox("Ativo", new Object[][] {{1, "Sim"}, {2, "Não"}}, true);

    public TelaCadastroEstado(){

        super("Cadastro de Estado");

        adicionaComponente(mctCodigo, 1, 1, 1, 1);
        adicionaComponente(mctNome, 2, 1, 1, 2);
        adicionaComponente(mctNomeUf, 2, 4, 1, 1);
        adicionaComponente(mcsnAtivo, 4, 1, 1, 1);

        habilitaCampos(false);
        pack();
        setVisible(true);
    }
}
