package dao;

import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import pojo.Pais;

public class PaisDao {
    public final String SQL_INCLUIR = "INSERT INTO PAIS VALUES (?,?,?)";
    public final String SQL_ALTERAR = "UPDATE PAIS SET nomePais = ?, ativoPais = ? WHERE idPais = ?";
    public final String SQL_EXCLUIR = "DELETE FROM PAIS WHERE idPais = ?";
    public final String SQL_CONSULTAR = "SELECT * FROM PAIS WHERE idPais = ?";
    public final static String SQL_PESQUISAR = "SELECT * FROM Pais";
    public final static String SQL_COMBOBOX = "SELECT idPais, nomePais FROM Pais ORDER BY nomePais";

    public boolean incluir(Pais pais){
        try {
            pais.setIdPais(Conexao.getGenerator("G_PAIS"));
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INCLUIR);
            ps.setInt(1, pais.getIdPais());
            ps.setString(2, pais.getNomePais());
            ps.setString(3, String.valueOf(pais.getAtivoPais()));
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel incluir o Pais");
            return false;
        }
    }

    public boolean alterar(Pais pais){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_ALTERAR);
            ps.setInt(3, pais.getIdPais());
            ps.setString(1, pais.getNomePais());
            ps.setString(2, "" + pais.getAtivoPais());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar o Pais");
            return false;
        }
    }

    public boolean excluir(Pais pais){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, pais.getIdPais());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir o Pais");
            return false;
        }
    }

    public boolean consultar(Pais pais){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_CONSULTAR);
            ps.setInt(1, pais.getIdPais());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                pais.setNomePais(rs.getString("nomePais"));
                pais.setAtivoPais(rs.getString("ativoPais").charAt(0));
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel consultar o Pais");
            return false;
        }
    }
}
   



