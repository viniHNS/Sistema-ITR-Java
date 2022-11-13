package telas;

import componentes.MeuCampoNumero;
import componentes.MeuCampoComboBox;
import componentes.MeuCampoTexto;
import dao.PaisDao;
import pojo.Pais;

public class TelaCadastroPais extends TelaCadastro{

    private Pais pais = new Pais();
    private PaisDao paisDao = new PaisDao();
    private MeuCampoNumero mctCodigo = new MeuCampoNumero(5, "Código", false) {
        
        public void setEnabled(boolean status){
            super.setEnabled(false);
        }
    };
    private MeuCampoTexto mctNome = new MeuCampoTexto(40, "Nome", true);
    private MeuCampoComboBox mcsnAtivo = new MeuCampoComboBox("Ativo", new Object[][] {{1, "S"}, {2, "N"}}, true);
    
    public TelaCadastroPais(){
        
        super("Cadastro de Pais");
        
        adicionaComponente(mctCodigo, 1, 1, 1, 1);
        adicionaComponente(mctNome, 2, 1, 1, 1);
        adicionaComponente(mcsnAtivo, 3, 1, 1, 1);
        
        habilitaCampos(false);
        pack();        
        setVisible(true);
    }

    public void setaPojoPais(){
        pais.setIdPais(Integer.parseInt("0" + mctCodigo.getValor()));
        pais.setNomePais(mctNome.getValor());
        pais.setAtivoPais(mcsnAtivo.getValor().charAt(0));
    }

    @Override
    public boolean incluir() {
        setaPojoPais();
        boolean resultado = paisDao.incluir(pais);
        if(resultado = true) {
            mctCodigo.setText(String.valueOf(pais.getIdPais()));
        }
        return resultado;
    }

   

    @Override
    public boolean alterar() {
        setaPojoPais();
        return paisDao.alterar(pais);
    }

    @Override
    public boolean excluir() {
        setaPojoPais();
        return paisDao.excluir(pais);
    }

    @Override
    public boolean consultar() {
        new TelaConsulta(this, "Consulta de Pais", new String []{"Código", "Nome", "Ativo"}, PaisDao.SQL_PESQUISAR);
        return true;
    }

    @Override
    public void preencherDados(int id) {
        pais.setIdPais(id);
        paisDao.consultar(pais);
        mctCodigo.setValor("" + pais.getIdPais() );
        mctNome.setValor(pais.getNomePais());
        mcsnAtivo.setValor(pais.getAtivoPais() == 'S' ? 1 : 2);
        super.preencherDados(id);
    }

}
