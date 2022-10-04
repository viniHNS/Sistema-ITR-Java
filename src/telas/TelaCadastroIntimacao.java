package telas;

import componentes.MeuCampoComboBox;
import componentes.MeuCampoData;
import componentes.MeuCampoNumIntimacao;
import componentes.MeuCampoNumero;
import componentes.MeuCampoTexto;

public class TelaCadastroIntimacao extends TelaCadastro{

    private MeuCampoTexto mctCodigo = new MeuCampoTexto(5, "Código", false);
    private MeuCampoTexto mctNome = new MeuCampoTexto(20, "Nome", true);
    private MeuCampoComboBox mcsnAtivo = new MeuCampoComboBox("Ativo", new Object[][] {{1, "Sim"}, {2, "Não"}}, true);
    private MeuCampoData mcdDataEntrega = new MeuCampoData("Data Entrega", false);
    private MeuCampoData mcdDataPostagem = new MeuCampoData("Data Postagem", false);
    private MeuCampoNumero mcnNIRF = new MeuCampoNumero(5, "NIRF", true);
    private MeuCampoNumIntimacao mcniNumInt = new MeuCampoNumIntimacao("Numero Intimação", true);
    private MeuCampoNumIntimacao mcniNumIntConst = new MeuCampoNumIntimacao("Numero Intimação/Const", true);
    private MeuCampoTexto mctRastreio = new MeuCampoTexto(10, "Cód. Rastreio", false);
    private MeuCampoComboBox mccbContribuinte = new MeuCampoComboBox("Contribuinte", new Object[][] {{1, "Nome Contribuinte1"}, {2, "Nome Contribuinte2"}}, true);

    public TelaCadastroIntimacao() {
        super("Cadastro da Intimação");

        adicionaComponente(mctCodigo, 1, 1, 1, 1);
        adicionaComponente(mctNome, 2, 1, 1, 1);
        adicionaComponente(mcnNIRF, 3,1,1,1);
        adicionaComponente(mctRastreio, 4,1,1,1);
        adicionaComponente(mcdDataEntrega, 5, 1, 1, 1);
        adicionaComponente(mcdDataPostagem, 6, 1, 1, 1);
        adicionaComponente(mcniNumInt, 7,1,1,1);
        adicionaComponente(mcniNumIntConst, 8,1,1,1);
        adicionaComponente(mccbContribuinte, 9,1,1,1);
        adicionaComponente(mcsnAtivo, 10, 1, 1, 1);
        habilitaCampos(false);
        pack();        
        setVisible(true);

    }
    
}
