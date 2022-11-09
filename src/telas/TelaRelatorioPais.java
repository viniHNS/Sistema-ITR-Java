package telas;

import java.sql.Connection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import bd.Conexao;
import dao.PaisDao;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import pojo.Pais;

public class TelaRelatorioPais {
    
    void gerarRelatorio(String caminhoRelatorio, Map parametros){

       try {
            JasperReport relatorio = JasperCompileManager.compileReport(caminhoRelatorio);
            JasperPrint relatorioPreenchido = JasperFillManager.fillReport(relatorio, parametros, Conexao.getConexao());
            JasperViewer.viewReport(relatorioPreenchido);
       } catch (JRException ex) {
         Logger.getLogger(TelaRelatorioPais.class.getName()).log(Level.SEVERE, null, ex);
         JOptionPane.showMessageDialog(null, "Erro ao carregar relatório");
       } 
       
    }
}
