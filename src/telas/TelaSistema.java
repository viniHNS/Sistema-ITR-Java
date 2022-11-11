package telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaSistema extends JFrame implements ActionListener {

    public static JDesktopPane jdp = new JDesktopPane();
    private JMenu jmCadastros = new JMenu("Cadastros");
    private JMenu jmMovimentos = new JMenu("Consulta");
    private JMenu jmRelatorios = new JMenu("Relatórios");

    private JMenuBar jmb = new JMenuBar();
    
    //Cadastro
    private JMenuItem jmiPais = new JMenuItem("Pais");
    private JMenuItem jmiEstado = new JMenuItem("Estado");
    private JMenuItem jmiCidade = new JMenuItem("Cidade");
    private JMenuItem jmiContribuinte = new JMenuItem("Contribuinte");
    private JMenuItem jmiIntimacao = new JMenuItem("Intimação");
    private JMenuItem jmiPropriedade = new JMenuItem("Propriedade");
    //-------


    private JMenuItem jmiRelatorioPais = new JMenuItem("Pais");

    public TelaSistema(String titulo) {
        try {
            setIconImage(ImageIO.read(new File("res/brotar.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setTitle(titulo);
        setSize(600, 600);
        setJMenuBar(jmb);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        getContentPane().add(jdp);
        
        jdp.setBackground(Color.GRAY);
        
        jmb.add(jmCadastros);
        jmb.add(jmMovimentos);
        jmb.add(jmRelatorios);
        
        //Cadastro
        adicionarMenuItem(jmCadastros, jmiPais);
        adicionarMenuItem(jmCadastros, jmiEstado);     
        adicionarMenuItem(jmCadastros, jmiCidade);
        adicionarMenuItem(jmCadastros, jmiContribuinte);
        adicionarMenuItem(jmCadastros, jmiIntimacao);
        adicionarMenuItem(jmCadastros, jmiPropriedade);
        //--------
 

        //Relatorio
        adicionarMenuItem(jmRelatorios, jmiRelatorioPais);
        //---------
    }

    
    private void adicionarMenuItem(JMenu menu, JMenuItem itemMenu){
        menu.add(itemMenu);
        itemMenu.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == jmiPais) {
            TelaCadastroPais telaCadastroPais = new TelaCadastroPais();
            jdp.add(telaCadastroPais);
            
        } else if (ae.getSource() == jmiEstado) {
            TelaCadastroEstado telaCadastroEstado = new TelaCadastroEstado();
             jdp.add(telaCadastroEstado);
             
        } else if (ae.getSource() == jmiCidade) {
            TelaCadastroCidade telaCadastroCidade = new TelaCadastroCidade();
             jdp.add(telaCadastroCidade);
             
        } else if (ae.getSource() == jmiContribuinte) {
             TelaCadastroContribuinte telaCadastroContribuinte = new TelaCadastroContribuinte();
              jdp.add(telaCadastroContribuinte);
        } else if (ae.getSource() == jmiIntimacao) {
            TelaCadastroIntimacao telaCadastroIntimacao = new TelaCadastroIntimacao();
             jdp.add(telaCadastroIntimacao);
        } else if (ae.getSource() == jmiPropriedade) {
            TelaCadastroPropriedade TelaCadastroPropriedade = new TelaCadastroPropriedade();
             jdp.add(TelaCadastroPropriedade);
        }   
    }    
}
