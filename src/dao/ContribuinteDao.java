package dao;

import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import pojo.Contribuinte;

public class ContribuinteDao {
    public final String SQL_INCLUIR = "INSERT INTO CONTRIBUINTE VALUES (?,?,?,?,?,?,?,?,?,?)";
    public final String SQL_ALTERAR = "UPDATE CONTRIBUINTE SET nomeContribuinte = ?, telefoneContribuinte = ?, cpfCnpjContribuinte = ?, logradouroContribuinte = ?, numeroContribuinte = ?, bairroContribuinte = ?, complementoContribuinte = ?, ativoContribuinte = ?, idCidade = ? WHERE idContribuinte = ?";
    public final String SQL_EXCLUIR = "DELETE FROM CONTRIBUINTE WHERE idContribuinte = ?";
    public final String SQL_CONSULTAR = "SELECT * FROM CONTRIBUINTE WHERE idContribuinte = ?";
    public final static String SQL_PESQUISAR = "SELECT * FROM Contribuinte";

    public boolean incluir(Contribuinte contribuinte){
        try {
            contribuinte.setIdContribuinte(Conexao.getGenerator("G_CONTRIBUINTE"));
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INCLUIR);
            ps.setString(1, contribuinte.getNomeContribuinte());
            ps.setInt(10, contribuinte.getIdContribuinte());
            ps.setString(8, "" + contribuinte.getAtivoContribuinte());
            ps.setString(2, contribuinte.getTelefoneContribuinte());
            ps.setString(3, contribuinte.getCpfCnpjContribuinte());
            ps.setString(4, contribuinte.getLogradouroContribuinte());
            ps.setString(5, contribuinte.getNumeroContribuinte());
            ps.setString(6, contribuinte.getBairroContribuinte());
            ps.setString(7, contribuinte.getComplementoContribuinte());
            ps.setInt(9, contribuinte.getIdCidade());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel incluir o Contribuinte");
            return false;
        }
    }

    public boolean alterar(Contribuinte contribuinte){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_ALTERAR);
            ps.setString(1, contribuinte.getNomeContribuinte());
            ps.setInt(10, contribuinte.getIdContribuinte());
            ps.setString(8, "" + contribuinte.getAtivoContribuinte());
            ps.setString(2, contribuinte.getTelefoneContribuinte());
            ps.setString(3, contribuinte.getCpfCnpjContribuinte());
            ps.setString(4, contribuinte.getLogradouroContribuinte());
            ps.setString(5, contribuinte.getNumeroContribuinte());
            ps.setString(6, contribuinte.getBairroContribuinte());
            ps.setString(7, contribuinte.getComplementoContribuinte());
            ps.setInt(9, contribuinte.getIdCidade());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar o Contribuinte");
            return false;
        }
    }

    public boolean excluir(Contribuinte contribuinte){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, contribuinte.getIdContribuinte());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir o Contribuinte");
            return false;
        }
    }

    public boolean consultar(Contribuinte contribuinte){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_CONSULTAR);
            ps.setInt(1, contribuinte.getIdContribuinte());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                contribuinte.setNomeContribuinte(rs.getString("nomeContribuinte"));
                contribuinte.setCpfCnpjContribuinte(rs.getString("cpfCnpjContribuinte"));
                contribuinte.setTelefoneContribuinte(rs.getString("telefoneContribuinte"));
                contribuinte.setLogradouroContribuinte(rs.getString("logradouroContribuinte"));
                contribuinte.setNumeroContribuinte(rs.getString("numeroContribuinte"));
                contribuinte.setBairroContribuinte(rs.getString("bairroContribuinte"));
                contribuinte.setComplementoContribuinte(rs.getString("complementoContribuinte"));
                contribuinte.setAtivoContribuinte(rs.getString("ativoContribuinte").charAt(0));
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel consultar o Contribuinte");
            return false;
        }
    }

}
