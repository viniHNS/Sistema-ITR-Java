package telas;

import componentes.MeuCampoCEP;
import componentes.MeuCampoComboBox;
import componentes.MeuCampoDBComboBox;
import componentes.MeuCampoTexto;
import dao.CidadeDao;
import dao.EstadoDao;
import pojo.Cidade;

public class TelaCadastroCidade extends TelaCadastro{

    private Cidade cidade = new Cidade();
    private CidadeDao cidadeDao = new CidadeDao();

    private MeuCampoTexto mctCodigo = new MeuCampoTexto(5, "Código", false){
        public void setEnabled(boolean status){
            super.setEnabled(false);
        }
    };
    private MeuCampoTexto mctNome = new MeuCampoTexto(30, "Nome", true);
    private MeuCampoComboBox mcsnAtivo = new MeuCampoComboBox("Ativo", new Object[][] {{1, "Sim"}, {2, "Não"}}, true);
    private MeuCampoDBComboBox mcsnUF = new MeuCampoDBComboBox(true, EstadoDao.SQL_COMBOBOX, "Estado"); 
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

    public void setaPojoCidade(){
        cidade.setIdCidade(Integer.parseInt("0" + mctCodigo.getValor()));
        cidade.setNomeCidade(mctNome.getValor());
        cidade.setIdEstado(Integer.parseInt(mcsnUF.getValor()));
        cidade.setAtivoCidade(mcsnAtivo.getValor().charAt(0));
        cidade.setCepCidade(mcCEP.getValor());
    }

    @Override
    public boolean incluir() {
        setaPojoCidade();
        boolean resultado = cidadeDao.incluir(cidade);
        if(resultado == true){
            mctCodigo.setText("" + cidade.getIdCidade());
        }
        return resultado;
    }

    @Override
    public boolean alterar() {
        setaPojoCidade();
        return cidadeDao.alterar(cidade);
    }

    @Override
    public boolean excluir() {
        setaPojoCidade();
        return cidadeDao.excluir(cidade);
    }

    @Override
    public boolean consultar() {
        new TelaConsulta(this, "Consulta de Cidade", new String[]{"Código", "Nome", "Estado", "CEP", "Ativo"}, new int[]{100}, CidadeDao.SQL_PESQUISAR);
        return true;
    }

    @Override
    public void preencherDados(int id){
        cidade.setIdCidade(id);
        cidadeDao.consultar(cidade);
        mcCEP.setValor(cidade.getCepCidade());
        mctCodigo.setValor("" + cidade.getIdCidade());
        mctNome.setValor(cidade.getNomeCidade());
        mcsnUF.setValor(cidade.getIdEstado());
        mcsnAtivo.setValor(cidade.getAtivoCidade() == 'S' ? 1 : 2);
        super.preencherDados(id);
    }
}
