package telas;

import componentes.MeuCampoCEP;
import componentes.MeuCampoComboBox;
import componentes.MeuCampoNumero;
import componentes.MeuCampoTexto;

public class TelaCadastroContribuinte extends TelaCadastro{

    private MeuCampoTexto mctCodigo = new MeuCampoTexto(10, "Código", false);
    private MeuCampoTexto mctNome = new MeuCampoTexto(50, "Nome", true);
    private MeuCampoComboBox mcsnAtivo = new MeuCampoComboBox("Ativo", new Object[][] {{1, "Sim"}, {2, "Não"}}, true);
    private MeuCampoNumero mcnCPF = new MeuCampoNumero(10, "CPF", true);
    private MeuCampoNumero mcnTelefone = new MeuCampoNumero(10, "Telefone", false);
    private MeuCampoCEP mcCEP = new MeuCampoCEP("CEP", true);
    private MeuCampoTexto mctCidade = new MeuCampoTexto(10, "Cidade", false);
    private MeuCampoTexto mctEstado = new MeuCampoTexto(10, "Estado", false);
    private MeuCampoTexto mctLogradouro = new MeuCampoTexto(40, "Logradouro", true);
    private MeuCampoTexto mctNumero = new MeuCampoTexto(10, "Numero", true);
    private MeuCampoTexto mctBairro = new MeuCampoTexto(25, "Bairro", true);
    private MeuCampoTexto mctComplemento = new MeuCampoTexto(25, "Complemento", true);

    public TelaCadastroContribuinte(){

        super("Cadastro de Contribuinte");

        adicionaComponente(mctCodigo, 1, 2, 1, 1);
        adicionaComponente(mctNome, 2, 2, 1, 4);
        adicionaComponente(mcsnAtivo, 10, 2, 1, 1); 
        adicionaComponente(mcnCPF, 3, 2, 1, 1);
        adicionaComponente(mcnTelefone, 3, 4, 1, 1);
        adicionaComponente(mcCEP, 4,2,1,1);
        adicionaComponente(mctCidade, 5,2,1,4);
        adicionaComponente(mctEstado, 5,4,1,1);
        adicionaComponente(mctLogradouro, 6,2,1,1);
        adicionaComponente(mctNumero, 7,2,1,1);
        adicionaComponente(mctBairro, 8,2,1,1);
        adicionaComponente(mctComplemento, 9,2,1,1);


         
        

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
