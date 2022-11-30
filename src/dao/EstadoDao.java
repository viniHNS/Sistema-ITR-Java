package dao;

import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import pojo.Estado;

public class EstadoDao {
    public final String SQL_INCLUIR = "INSERT INTO ESTADO VALUES (?,?,?,?,?)";
    public final String SQL_ALTERAR = "UPDATE ESTADO SET nomeEstado = ?, ufEstado = ?, ativoEstado = ? WHERE idEstado = ?";
    public final String SQL_EXCLUIR = "DELETE FROM ESTADO WHERE idEstado = ?";
    public final String SQL_CONSULTAR = "SELECT * FROM ESTADO WHERE idEstado = ?";
    public final static String SQL_PESQUISAR = "SELECT IDESTADO, NOMEESTADO, UFESTADO, NOMEPAIS, ATIVOPAIS FROM Estado JOIN PAIS ON ESTADO.IDPAIS = PAIS.IDPAIS ORDER BY NOMEPAIS";
    public final static String SQL_COMBOBOX = "SELECT idEstado, nomeEstado || ' - ' || ufEstado FROM Estado ORDER BY nomeEstado";
    
    

    public boolean incluir(Estado estado){
        try {
            estado.setIdEstado(Conexao.getGenerator("G_ESTADO"));
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INCLUIR);
            ps.setInt(1, estado.getIdEstado());
            ps.setString(2, estado.getNomeEstado());
            ps.setString(3, estado.getUfEstado());
            ps.setString(4, "" + estado.getAtivoEstado());
            ps.setInt(5, estado.getIdPais());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel incluir o Estado");
            return false;
        }
    }

    public boolean alterar(Estado estado){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_ALTERAR);
            ps.setInt(4, estado.getIdEstado());
            ps.setString(1, estado.getNomeEstado());
            ps.setString(2, estado.getUfEstado());
            ps.setString(3, "" + estado.getAtivoEstado());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar o Estado");
            return false;
        }
    }

    public boolean excluir(Estado estado){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, estado.getIdEstado());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir o Estado");
            return false;
        }
    }

    public boolean consultar(Estado estado){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_CONSULTAR);
            ps.setInt(1, estado.getIdEstado());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                estado.setNomeEstado(rs.getString("nomeEstado"));
                estado.setUfEstado(rs.getString("ufEstado"));
                estado.setAtivoEstado(rs.getString("ativoEstado").charAt(0));
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel consultar o Estado");
            return false;
        }
    }
}


