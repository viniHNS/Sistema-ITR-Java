package telas;

import componentes.MeuCampoTexto;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaCadastroPais extends TelaCadastro{
     
    private MeuCampoTexto jtfCodigo = new MeuCampoTexto(5, "Código", false);
    private MeuCampoTexto jtfNome = new MeuCampoTexto(20, "Nome", true);
    private MeuCampoTexto jtfAtivo = new MeuCampoTexto(2, "Ativo", false);
    
    public TelaCadastroPais(){
        
        super("Cadastro de Pais");
        
        adicionaComponente(jtfCodigo, 1, 2, 1, 1);
        adicionaComponente(jtfNome, 2, 2, 1, 3);
        adicionaComponente(jtfAtivo, 1, 4, 1, 1);
        
        habilitaCampos(false);
        pack();        
        setVisible(true);
    }
}
