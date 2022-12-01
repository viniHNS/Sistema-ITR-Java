package dao;

import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import pojo.Propriedade;

public class PropriedadeDao {
    public final String SQL_INCLUIR = "INSERT INTO PROPRIEDADE VALUES (?,?,?,?,?,?,?,?)";
    public final String SQL_ALTERAR = "UPDATE PROPRIEDADE SET NOMEPROPRIEDADE = ?, NIRFPROPRIEDADE = ?, AREATOTALPROPRIEDADE = ?, PARAMETROSELECAOPROPRIEDADE = ?, STATUSPROPRIEDADE = ?, ATIVOPROPRIEDADE = ? WHERE IDPROPRIEDADE = ?";
    public final String SQL_EXCLUIR = "DELETE FROM PROPRIEDADE WHERE IDPROPRIEDADE = ?";
    public final String SQL_CONSULTAR = " SELECT * FROM PROPRIEDADE WHERE IDPROPRIEDADE = ?";
    public final static String SQL_PESQUISAR = "SELECT IDPROPRIEDADE, NOMEPROPRIEDADE, AREATOTALPROPRIEDADE, NIRFPROPRIEDADE, STATUSPROPRIEDADE, ATIVOPROPRIEDADE FROM PROPRIEDADE ORDER BY NOMEPROPRIEDADE";
    public final static String SQL_COMBOBOX = "SELECT IDPROPRIEDADE, NOMEPROPRIEDADE || ' - ' || NOMECONTRIBUINTE FROM PROPRIEDADE JOIN CONTRIBUINTE ON PROPRIEDADE.IDCONTRIBUINTE = CONTRIBUINTE.IDCONTRIBUINTE ORDER BY NOMEPROPRIEDADE";

    public boolean incluir(Propriedade propriedade){
        try {
            propriedade.setIdPropriedade(Conexao.getGenerator("G_PROPRIEDADE"));
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INCLUIR);
            ps.setInt(1, propriedade.getIdPropriedade());
            ps.setString(2, propriedade.getNomePropriedade());
            ps.setString(3, propriedade.getNirfPropriedade());
            ps.setString(4, propriedade.getAreaTotalPropriedade());
            ps.setString(5, propriedade.getParametroSelecaoPropriedade());
            ps.setString(6, propriedade.getStatusPropriedade());
            ps.setString(7, "" + propriedade.getAtivoPropriedade());
            ps.setInt(8, propriedade.getIdContribuinte());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel incluir a propriedade");
            return false;
        }
    }

    public boolean alterar(Propriedade propriedade){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_ALTERAR);
            ps.setInt(7, propriedade.getIdPropriedade());
            ps.setString(1, propriedade.getNomePropriedade());
            ps.setString(2, propriedade.getNirfPropriedade());
            ps.setString(3, propriedade.getAreaTotalPropriedade());
            ps.setString(4, propriedade.getParametroSelecaoPropriedade());
            ps.setString(5, propriedade.getStatusPropriedade());
            ps.setString(6, "" + propriedade.getAtivoPropriedade());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar a propriedade");
            return false;
        }
    }

    public boolean excluir(Propriedade propriedade){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, propriedade.getIdPropriedade());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel excluir a propriedade");
            return false;
        }
    }

    public boolean consultar(Propriedade propriedade){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_CONSULTAR);
            ps.setInt(1, propriedade.getIdPropriedade());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                propriedade.setIdContribuinte(Integer.parseInt(rs.getString("idContribuinte")));
                propriedade.setNomePropriedade(rs.getString("nomePropriedade"));
                propriedade.setNirfPropriedade(rs.getString("NirfPropriedade"));
                propriedade.setAreaTotalPropriedade(rs.getString("AreaTotalPropriedade"));
                propriedade.setParametroSelecaoPropriedade(rs.getString("parametroSelecaoPropriedade"));
                propriedade.setStatusPropriedade(rs.getString("statusPropriedade"));
                propriedade.setAtivoPropriedade(rs.getString("ativoPropriedade").charAt(0));
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possivel consultar o propriedade");
            return false;
        }
    }
}
