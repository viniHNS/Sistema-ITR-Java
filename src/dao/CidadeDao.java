package dao;

import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import pojo.Cidade;

public class CidadeDao {
    public final String SQL_INCLUIR = "INSERT INTO Cidade VALUES (?,?,?,?,?)";
    public final String SQL_ALTERAR = "UPDATE Cidade SET cepCidade = ?, nomeCidade = ?, ativoCidade = ? WHERE idCidade = ?";
    public final String SQL_EXCLUIR = "DELETE FROM Cidade WHERE idCidade = ?";
    public final String SQL_CONSULTAR = "SELECT * FROM Cidade WHERE idCidade = ?";
    public final static String SQL_PESQUISAR = "SELECT IDCIDADE, NOMECIDADE, NOMEESTADO , CEPCIDADE, ATIVOCIDADE FROM CIDADE JOIN Estado ON Cidade.IdEstado = Estado.IdEstado";
    public final static String SQL_COMBOBOX = "SELECT idCidade, nomeCidade || ' - ' || ufEstado FROM Cidade JOIN Estado ON Cidade.IdEstado = Estado.IdEstado ORDER BY NomeCidade";
    
    public boolean incluir(Cidade cidade){
        try {
            cidade.setIdCidade(Conexao.getGenerator("G_CIDADE"));
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INCLUIR);
            ps.setInt(1, cidade.getIdCidade());
            ps.setString(3, cidade.getNomeCidade());
            ps.setString(2, cidade.getCepCidade());
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
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_ALTERAR);
            ps.setInt(4, cidade.getIdCidade());
            ps.setString(2, cidade.getNomeCidade());
            ps.setString(1, cidade.getCepCidade());
            ps.setString(3, "" + cidade.getAtivoCidade());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar a Cidade");
            return false;
        }
    }

    public boolean excluir(Cidade cidade){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, cidade.getIdCidade());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir a cidade");
            return false;
        }
    }

    public boolean consultar(Cidade cidade){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_CONSULTAR);
            ps.setInt(1, cidade.getIdCidade());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                cidade.setIdEstado(Integer.parseInt(rs.getString("idEstado")));
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
