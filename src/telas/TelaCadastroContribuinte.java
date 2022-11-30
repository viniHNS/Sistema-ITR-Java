package telas;

import componentes.MeuCampoComboBox;
import componentes.MeuCampoDBComboBox;
import componentes.MeuCampoNumero;
import componentes.MeuCampoTexto;
import dao.CidadeDao;
import dao.ContribuinteDao;
import pojo.Contribuinte;

public class TelaCadastroContribuinte extends TelaCadastro{

    private Contribuinte contribuinte = new Contribuinte();
    private ContribuinteDao contribuinteDao = new ContribuinteDao();

    private MeuCampoTexto mctCodigo = new MeuCampoTexto(10, "Código", false){
        public void setEnabled(boolean status){
            super.setEnabled(false);
        }
    };
    private MeuCampoTexto mctNome = new MeuCampoTexto(50, "Nome", true);
    private MeuCampoComboBox mcsnAtivo = new MeuCampoComboBox("Ativo", new Object[][] {{1, "Sim"}, {2, "Não"}}, true);
    private MeuCampoNumero mcnCPF = new MeuCampoNumero(10, "CPF", true);
    private MeuCampoNumero mcnTelefone = new MeuCampoNumero(10, "Telefone", false);
    private MeuCampoDBComboBox mccbCidade = new MeuCampoDBComboBox(true, CidadeDao.SQL_COMBOBOX, "Cidade");
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
        adicionaComponente(mccbCidade, 4,2,1,4);
        adicionaComponente(mctLogradouro, 5,2,1,1);
        adicionaComponente(mctNumero, 6,2,1,1);
        adicionaComponente(mctBairro, 7,2,1,1);
        adicionaComponente(mctComplemento, 8,2,1,1);

        habilitaCampos(false);
        pack();
        setVisible(true);
    }

    public void setaPojoContribuinte(){
        contribuinte.setIdContribuinte(Integer.parseInt("0" + mctCodigo.getValor()));
        contribuinte.setNomeContribuinte(mctNome.getValor());
        contribuinte.setAtivoContribuinte(mcsnAtivo.getValor().charAt(0));
        contribuinte.setCpfCnpjContribuinte(mcnCPF.getValor());
        contribuinte.setTelefoneContribuinte(mcnTelefone.getValor());
        contribuinte.setLogradouroContribuinte(mctLogradouro.getValor());
        contribuinte.setNumeroContribuinte(mctNumero.getValor());
        contribuinte.setBairroContribuinte(mctBairro.getValor());
        contribuinte.setComplementoContribuinte(mctComplemento.getValor());
        contribuinte.setIdCidade(Integer.parseInt(mccbCidade.getValor()));
    }

    @Override
    public boolean incluir() {
        setaPojoContribuinte();
        boolean resultado = contribuinteDao.incluir(contribuinte);
        if(resultado == true){
            mctCodigo.setText("" + contribuinte.getIdContribuinte());
        }
        return resultado;
    }

    @Override
    public boolean alterar() {
        setaPojoContribuinte();
        return contribuinteDao.alterar(contribuinte);
    }

    @Override
    public boolean excluir() {
        setaPojoContribuinte();
        return contribuinteDao.excluir(contribuinte);
    }

    @Override
    public boolean consultar() {
        new TelaConsulta(this, "Consulta de Contribuinte", new String[]{"Código", "Nome", "CPF","Cidade", "Logradouro", "Numero", "Bairro", "Ativo"}, new int[]{100}, ContribuinteDao.SQL_COMBOBOX);
        return false;
    }

    @Override
    public void preencherDados(int id){
        contribuinte.setIdContribuinte(id);
        contribuinteDao.consultar(contribuinte);
        mctCodigo.setValor("" + contribuinte.getIdContribuinte());
        mctNome.setValor(contribuinte.getNomeContribuinte());
        mcnCPF.setValor(contribuinte.getCpfCnpjContribuinte());
        mcnTelefone.setValor(contribuinte.getTelefoneContribuinte());
        mctLogradouro.setValor(contribuinte.getLogradouroContribuinte());
        mccbCidade.setValor(contribuinte.getIdCidade());
        mctNumero.setValor(contribuinte.getNumeroContribuinte());
        mctComplemento.setValor(contribuinte.getComplementoContribuinte());
        mctBairro.setValor(contribuinte.getBairroContribuinte());
        mcsnAtivo.setValor(contribuinte.getAtivoContribuinte() == 'S' ? 1 : 2);
        super.preencherDados(id);

    }
}
