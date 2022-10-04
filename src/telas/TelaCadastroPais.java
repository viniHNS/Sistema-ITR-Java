package telas;

import componentes.MeuCampoNumero;
import componentes.MeuCampoComboBox;
import componentes.MeuCampoTexto;

public class TelaCadastroPais extends TelaCadastro{
     
    private MeuCampoNumero mctCodigo = new MeuCampoNumero(5, "Código", true);
    private MeuCampoTexto mctNome = new MeuCampoTexto(30, "Nome", true);
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

}
