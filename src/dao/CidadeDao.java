package dao;

import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import pojo.Cidade;

public class CidadeDao {
    public final String SQL_INCLUIR = "INSERT INTO CIDADE VALUES (?,?,?,?,?)";
    public final String SQL_ALTERAR = "UPDATE ESTADO SET nomeEstado = ?, ufEstado = ?, ativoEstado = ? WHERE idEstado = ?";
    public final String SQL_EXCLUIR = "DELETE FROM ESTADO WHERE idEstado = ?";
    public final String SQL_CONSULTAR = "SELECT * FROM ESTADO WHERE idEstado = ?";
    public final static String SQL_PESQUISAR = "SELECT * FROM Estado";

    public boolean incluir(Cidade cidade){
        try {
            cidade.setIdCidade(Conexao.getGenerator("G_CIDADE"));
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INCLUIR);
            ps.setInt(1, cidade.getIdCidade());
            ps.setString(2, cidade.getNomeCidade());
            ps.setString(3, cidade.getCepCidade());
            ps.setString(4, "" + cidade.getAtivoCidade());
            ps.setInt(5, cidade.getIdEstado());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel incluir a Cidade");
            return false;
        }
    }

    public boolean alterar(Cidade cidade){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, cidade.getIdCidade());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir a Cidade");
            return false;
        }
    }

    public boolean consultar(Cidade cidade){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_CONSULTAR);
            ps.setInt(1, cidade.getIdCidade());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                cidade.setNomeCidade(rs.getString("nomeCidade"));
                cidade.setCepCidade(rs.getString("cepCidade"));
                cidade.setAtivoCidade(rs.getString("ativoCidade").charAt(0));
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel consultar a cidade");
            return false;
        }
    }
}
