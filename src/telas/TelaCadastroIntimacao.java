package telas;

import componentes.MeuCampoComboBox;
import componentes.MeuCampoDBComboBox;
import componentes.MeuCampoData;
import componentes.MeuCampoNumIntimacao;
import componentes.MeuCampoTexto;
import dao.IntimacaoDao;
import dao.PropriedadeDao;
import pojo.Intimacao;

public class TelaCadastroIntimacao extends TelaCadastro{

    private Intimacao intimacao = new Intimacao();
    private IntimacaoDao intimacaoDao = new IntimacaoDao();

    private MeuCampoTexto mctCodigo = new MeuCampoTexto(5, "Código", false){
        public void setEnabled(boolean status){
            super.setEnabled(false);
        }
    };
    private MeuCampoComboBox mcsnAtivo = new MeuCampoComboBox("Ativo", new Object[][] {{1, "Sim"}, {2, "Não"}}, true);
    private MeuCampoData mcdDataEntrega = new MeuCampoData("Data Entrega", false);
    private MeuCampoData mcdDataPostagem = new MeuCampoData("Data Postagem", false);
    private MeuCampoNumIntimacao mcniNumInt = new MeuCampoNumIntimacao("Numero Intimação", true);
    private MeuCampoNumIntimacao mcniNumConst = new MeuCampoNumIntimacao("Numero Constatação", true);
    private MeuCampoNumIntimacao mcniNumIntConst = new MeuCampoNumIntimacao("Numero Intimação/Const", true);
    private MeuCampoTexto mctRastreio = new MeuCampoTexto(10, "Cód. Rastreio", false);
    private MeuCampoDBComboBox mccbPropriedade = new MeuCampoDBComboBox(true, PropriedadeDao.SQL_COMBOBOX, "Propriedade");

    public TelaCadastroIntimacao() {
        super("Cadastro da Intimação");

        adicionaComponente(mctCodigo, 1, 1, 1, 1);
        adicionaComponente(mccbPropriedade, 2, 1, 1, 1);
        adicionaComponente(mctRastreio, 3,1,1,1);
        adicionaComponente(mcdDataEntrega, 4, 1, 1, 1);
        adicionaComponente(mcdDataPostagem, 5, 1, 1, 1);
        adicionaComponente(mcniNumInt, 6,1,1,1);
        adicionaComponente(mcniNumConst, 7,1,1,1);
        adicionaComponente(mcniNumIntConst, 8,1,1,1);
        adicionaComponente(mcsnAtivo, 9, 1, 1, 1);
        habilitaCampos(false);
        pack();        
        setVisible(true);

    }

    public void setaPojoIntimacao(){
        intimacao.setIdIntimacao(Integer.parseInt("0" + mctCodigo.getValor()));
        intimacao.setCodRastreioIntimacao(mctRastreio.getValor());
        intimacao.setDataPostagemIntimacao(mcdDataPostagem.getValor());
        intimacao.setDataEntregaIntimacao(mcdDataEntrega.getValor());
        intimacao.setNumIntimacao(mcniNumInt.getValor());
        intimacao.setNumIntimacaoConstatacao(mcniNumIntConst.getValor());
        intimacao.setAtivoIntimacao(mcsnAtivo.getValor().charAt(0));
        intimacao.setIdPropriedade(Integer.parseInt(mccbPropriedade.getValor()));
        intimacao.setNumConstatacao(mcniNumConst.getValor());
    
    }

    @Override
    public boolean incluir() {
        setaPojoIntimacao();
        boolean resultado = intimacaoDao.incluir(intimacao);
        if(resultado == true){
            mctCodigo.setText("" + intimacao.getIdIntimacao());
        }
        return resultado;
    }

    @Override
    public boolean alterar() {
        setaPojoIntimacao();
        return intimacaoDao.alterar(intimacao);
    }

    @Override
    public boolean excluir() {
        setaPojoIntimacao();
        return intimacaoDao.excluir(intimacao);
    }

    @Override
    public boolean consultar() {
        new TelaConsulta(this, "Consulta de Intimacao", new String[]{"Código", "Propriedade", "Num. Intimacao", "Num. Constatacao", "Num. Intimacao e Constatacao", "Cod. Rastreio"}, new int[]{100}, IntimacaoDao.SQL_COMBOBOX);
        return false;
    }

    @Override
    public void preencherDados(int id){
        intimacao.setIdIntimacao(id);
        intimacaoDao.consultar(intimacao);
        
        mctCodigo.setValor("" + intimacao.getIdIntimacao());
        mccbPropriedade.setValor(intimacao.getIdPropriedade());
        mctRastreio.setValor(intimacao.getCodRastreioIntimacao());
        mcdDataEntrega.setValor(intimacao.getDataEntregaIntimacao());
        mcdDataPostagem.setValor(intimacao.getDataPostagemIntimacao());
        mcniNumInt.setValor(intimacao.getNumIntimacao());
        mcniNumIntConst.setValor(intimacao.getNumIntimacaoConstatacao());
        mcniNumConst.setValor(intimacao.getNumConstatacao());
        mcsnAtivo.setValor(intimacao.getAtivoIntimacao() == 'S' ? 1 : 2);
        super.preencherDados(id);
    }
    
}
