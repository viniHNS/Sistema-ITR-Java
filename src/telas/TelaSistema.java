package telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaSistema extends JFrame implements ActionListener {
    
    private JDesktopPane jdp = new JDesktopPane();
    private JMenu jmCadastros = new JMenu("Cadastros");
    private JMenu jmMovimentos = new JMenu("Movimentos");
    private JMenu jmRelatorios = new JMenu("Relatórios");
    
    

    private JMenuBar jmb = new JMenuBar();
    
    private JMenuItem jmiPais = new JMenuItem("Pais");
    private JMenuItem jmiEstado = new JMenuItem("Estado");
    private JMenuItem jmiCidade = new JMenuItem("Cidade");
    private JMenuItem jmiContribuinte = new JMenuItem("Contribuinte");
    private JMenuItem jmiIntimacao = new JMenuItem("Intimação");

    public TelaSistema(String titulo) {
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
        
        adicionarMenuItem(jmCadastros, jmiPais);
        adicionarMenuItem(jmCadastros, jmiEstado);     
        adicionarMenuItem(jmCadastros, jmiCidade);
        adicionarMenuItem(jmCadastros, jmiContribuinte);
        adicionarMenuItem(jmCadastros, jmiIntimacao);
           
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
        }
    }
}
