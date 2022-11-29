package telas;

import componentes.MeuCampoComboBox;
import componentes.MeuCampoDBComboBox;
import componentes.MeuCampoTexto;
import dao.EstadoDao;
import dao.PaisDao;
import pojo.Estado;

public class TelaCadastroEstado extends TelaCadastro{

    private Estado estado = new Estado();
    private EstadoDao estadoDao = new EstadoDao();

    private MeuCampoTexto mctCodigo = new MeuCampoTexto(5, "Código", false){
        public void setEnabled(boolean status){
            super.setEnabled(false);
        }
    };
    private MeuCampoTexto mctNome = new MeuCampoTexto(30, "Nome", true);
    private MeuCampoTexto mctNomeUf = new MeuCampoTexto(5, "UF", true);
    private MeuCampoDBComboBox mccbPais = new MeuCampoDBComboBox(true, PaisDao.SQL_COMBOBOX, "Pais"); 
    private MeuCampoComboBox mcsnAtivo = new MeuCampoComboBox("Ativo", new Object[][] {{1, "Sim"}, {2, "Não"}}, true);

    public TelaCadastroEstado(){

        super("Cadastro de Estado");

        adicionaComponente(mctCodigo, 1, 1, 1, 1);
        adicionaComponente(mccbPais, 2, 1, 1, 1);
        adicionaComponente(mctNome, 3, 1, 1, 2);
        adicionaComponente(mctNomeUf, 3, 4, 1, 1);
        adicionaComponente(mcsnAtivo, 4, 1, 1, 1);

        habilitaCampos(false);
        pack();
        setVisible(true);
    }

    public void setaPojoEstado(){
        estado.setIdEstado(Integer.parseInt("0" + mctCodigo.getValor()));
        estado.setNomeEstado(mctNome.getValor());
        estado.setUfEstado(mctNomeUf.getValor());
        estado.setAtivoEstado(mcsnAtivo.getValor().charAt(0));
        estado.setIdPais(Integer.parseInt(mccbPais.getValor()));
    }

    @Override
    public boolean incluir() {
        setaPojoEstado();
        boolean resultado = estadoDao.incluir(estado);
        if(resultado == true){
            mctCodigo.setText(String.valueOf(estado.getIdEstado()));
        }
        return resultado;
    }

    @Override
    public boolean alterar() {
        setaPojoEstado();
        return estadoDao.alterar(estado);
    }

    @Override
    public boolean excluir() {
        setaPojoEstado();
        return estadoDao.excluir(estado);
    }

    @Override
    public boolean consultar() {
        new TelaConsulta(this, "Consulta de Estado", new String []{"Código", "Nome", "UF", "Ativo"}, new int[]{100}, EstadoDao.SQL_PESQUISAR);
        return false;
    }

    @Override
    public void preencherDados(int id){
        estado.setIdEstado(id);
        estadoDao.consultar(estado);
        mctCodigo.setValor("" + estado.getIdEstado());
        mctNome.setValor(estado.getNomeEstado());
        mctNomeUf.setValor(estado.getUfEstado());
        mccbPais.setValor(estado.getIdPais());
        mcsnAtivo.setValor(estado.getAtivoEstado() == 'S' ? 1 : 2);
        super.preencherDados(id);
    }
}
