package telas;

import bd.Conexao;
import java.lang.Integer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class TelaConsulta extends JInternalFrame implements MouseListener{

    private TelaCadastro telaChamadora;
    private DefaultTableModel dtm = new DefaultTableModel();
    private JTable tabela = new JTable(dtm){
        @Override
        public boolean isCellEditable(int linha, int coluna){
            return false;
        }
    };
    private JScrollPane jsp = new JScrollPane(tabela);

    public TelaConsulta(TelaCadastro telaChamadora, String titulo, String[] colunas, int[] larguras, String sql){
        super(titulo);
        this.telaChamadora = telaChamadora;
        tabela.getTableHeader().setReorderingAllowed(false);
        insereColunas(colunas);
        insereDados(sql);
        if(dtm.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Não existem dados");
            return;
        }
        getContentPane().add(jsp);

        TableColumnModel columnModel = tabela.getColumnModel();
        for(int i = 0; i < larguras.length; i++) {
            columnModel.getColumn(i).setPreferredWidth(larguras[i]);
        }
        setSize(900, 400);
        setClosable(true);
        setVisible(true);

        ImageIcon icon = new ImageIcon("res/lupa.png");
        setFrameIcon(icon);

        TelaSistema.jdp.add(this);
        TelaSistema.jdp.moveToFront(this);
        tabela.addMouseListener(this);
    }

    public void insereColunas(String[] colunas){
        for(int i = 0; i < colunas.length; i++){
            dtm.addColumn(colunas[i]);
        }
    }

    public void insereDados(String sql){
        List<List<String>> dados = Conexao.executaQuery(sql);
        for(int i = 0; i < dados.size(); i++){
            dtm.addRow(dados.get(i).toArray());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            telaChamadora.preencherDados(Integer.parseInt((String)dtm.getValueAt(tabela.getSelectedRow(), 0)));
            dispose();
            TelaSistema.jdp.remove(this);
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}