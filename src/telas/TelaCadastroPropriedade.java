package telas;

import componentes.MeuCampoComboBox;
import componentes.MeuCampoDBComboBox;
import componentes.MeuCampoNumero;
import componentes.MeuCampoTexto;
import dao.ContribuinteDao;
import dao.PropriedadeDao;
import pojo.Propriedade;

public class TelaCadastroPropriedade extends TelaCadastro{

    private Propriedade propriedade = new Propriedade();
    private PropriedadeDao propriedadeDao = new PropriedadeDao();

    private MeuCampoTexto mctCodigo = new MeuCampoTexto(5, "Código", false){
        public void setEnabled(boolean status){
            super.setEnabled(false);
        }
    };
    private MeuCampoTexto mctNome = new MeuCampoTexto(20, "Nome", true);
    private MeuCampoComboBox mcsnAtivo = new MeuCampoComboBox("Ativo", new Object[][] {{1, "Sim"}, {2, "Não"}}, true);
    private MeuCampoNumero mcnNIRF = new MeuCampoNumero(5, "NIRF", true);
    private MeuCampoNumero mcnArea = new MeuCampoNumero(5, "Area Total", true);
    private MeuCampoDBComboBox mccbContribuinte = new MeuCampoDBComboBox(true, ContribuinteDao.SQL_COMBOBOX, "Contribuinte");
    private MeuCampoComboBox mccbSituacao = new MeuCampoComboBox("Situação", new Object[][] {{1, "Em análise"},{2, "Liberado"}, {3, "Protocolado"}, {4, "Vencido"}, {5, "Levar RFB"}}, true);

    public TelaCadastroPropriedade() {
        super("Cadastro da Propriedade");

        adicionaComponente(mctCodigo, 1, 1, 1, 1);
        adicionaComponente(mctNome, 2, 1, 1, 1);
        adicionaComponente(mcnNIRF, 3,1,1,1);
        adicionaComponente(mcnArea, 3,3,1,1);
        adicionaComponente(mccbContribuinte, 4,1,1,1);
        adicionaComponente(mccbSituacao, 5,1,1,1);
        adicionaComponente(mcsnAtivo, 6, 1, 1, 1);

        habilitaCampos(false);
        pack();        
        setVisible(true);

    }

    public void setaPojoPropriedade(){
        propriedade.setIdPropriedade(Integer.parseInt("0" + mctCodigo.getValor()));
        propriedade.setNomePropriedade(mctNome.getValor());
        propriedade.setNirfPropriedade(mcnNIRF.getValor());
        propriedade.setAreaTotalPropriedade(mcnArea.getValor());
        propriedade.setStatusPropriedade(mccbSituacao.getValor());
        propriedade.setParametroSelecaoPropriedade(mccbSituacao.getValor());
        propriedade.setAtivoPropriedade(mcsnAtivo.getValor().charAt(0));
        propriedade.setIdContribuinte(Integer.parseInt(mccbContribuinte.getValor()));

    }

    @Override
    public boolean incluir() {
        setaPojoPropriedade();
        boolean resultado = propriedadeDao.incluir(propriedade);
        if(resultado == true){
            mctCodigo.setText("" + propriedade.getIdContribuinte());
        }
        return resultado;
    }

    @Override
    public boolean alterar() {
        setaPojoPropriedade();
        return propriedadeDao.alterar(propriedade);
    }

    @Override
    public boolean excluir() {
        setaPojoPropriedade();
        return propriedadeDao.excluir(propriedade);
    }

    @Override
    public boolean consultar() {
        new TelaConsulta(this, "Consulta de Propriedade", new String[]{"Código", "Nome", "Área", "NIRF", "Status", "Ativo"}, new int[]{150}, PropriedadeDao.SQL_PESQUISAR);
        return false;
    }

    @Override
    public void preencherDados(int id){
        propriedade.setIdPropriedade(id);
        propriedadeDao.consultar(propriedade);
        mctCodigo.setValor("" + propriedade.getIdPropriedade());
        mccbContribuinte.setValor(propriedade.getIdContribuinte());
        mctNome.setValor(propriedade.getNomePropriedade());
        mcnNIRF.setValor(propriedade.getNirfPropriedade());
        mcnArea.setValor(propriedade.getAreaTotalPropriedade());

        System.out.println(propriedade.getStatusPropriedade());

        if(propriedade.getStatusPropriedade().equalsIgnoreCase("Em analise")){
            mccbSituacao.setValor(1);
        } if (propriedade.getStatusPropriedade().equalsIgnoreCase("Liberado")) {
            mccbSituacao.setValor(2);
        } if (propriedade.getStatusPropriedade().equalsIgnoreCase("Protocolado")){
            mccbSituacao.setValor(3);
        } if (propriedade.getStatusPropriedade().equalsIgnoreCase("Vencido")){
            mccbSituacao.setValor(4);
        } if (propriedade.getStatusPropriedade().equalsIgnoreCase("Levar RFB")){
            mccbSituacao.setValor(5);
        } 
        mcsnAtivo.setValor(propriedade.getAtivoPropriedade() == 'S' ? 1 : 2);
        super.preencherDados(id);
    }
    
}
