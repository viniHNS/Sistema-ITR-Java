package dao;

import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import pojo.Intimacao;

public class IntimacaoDao {
    public final String SQL_INCLUIR = "INSERT INTO INTIMACAO VALUES (?,?,?,?,?,?,?,?,?)";
    public final String SQL_ALTERAR = "UPDATE INTIMACAO SET NUMINTIMACAO = ?, NUMCONSTATACAO = ?, NUMINTIMACAOCONSTATACAO = ?, CODRASTREIOINTIMACAO = ?, DATAPOSTAGEMINTIMACAO = ?, DATAENTREGAINTIMACAO = ?, ATIVOINTIMACAO = ? WHERE IDINTIMACAO = ?";
    public final String SQL_EXCLUIR = "DELETE FROM INTIMACAO WHERE IDINTIMACAO = ?";
    public final String SQL_CONSULTAR = " SELECT * FROM INTIMACAO WHERE IDINTIMACAO = ?";
    public final static String SQL_PESQUISAR = "SELECT IDINTIMACAO, NOMEPROPRIEDADE, NUMINTIMACAO, NUMCONSTATACAO, NUMINTIMACAOCONSTATACAO, CODRASTREIOINTIMACAO FROM INTIMACAO JOIN PROPRIEDADE ON INTIMACAO.IDPROPRIEDADE = PROPRIEDADE.IDPROPRIEDADE ORDER BY NOMEPROPRIEDADE";
    public final static String SQL_COMBOBOX = "SELECT IDINTIMACAO, NOMEPROPRIEDADE, NUMINTIMACAO, NUMCONSTATACAO, NUMINTIMACAOCONSTATACAO, CODRASTREIOINTIMACAO FROM INTIMACAO JOIN PROPRIEDADE ON INTIMACAO.IDPROPRIEDADE = PROPRIEDADE.IDPROPRIEDADE ORDER BY NOMEPROPRIEDADE";

    public boolean incluir(Intimacao intimacao){
        try {
            intimacao.setIdIntimacao(Conexao.getGenerator("G_INTIMACAO"));
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INCLUIR);
            ps.setInt(1, intimacao.getIdIntimacao());
            ps.setString(2, intimacao.getNumIntimacao());
            ps.setString(3, intimacao.getNumConstatacao());
            ps.setString(4, intimacao.getNumIntimacaoConstatacao());
            ps.setString(5, intimacao.getCodRastreioIntimacao());
            ps.setString(6, intimacao.getDataPostagemIntimacao());
            ps.setString(7, intimacao.getDataEntregaIntimacao());
            ps.setString(8, "" + intimacao.getAtivoIntimacao());
            ps.setInt(9, intimacao.getIdPropriedade());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "N??o foi possivel incluir a intimacao");
            return false;
        }
    }

    public boolean alterar(Intimacao intimacao){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_ALTERAR);
            ps.setInt(8, intimacao.getIdIntimacao());
            ps.setString(1, intimacao.getNumIntimacao());
            ps.setString(2, intimacao.getNumConstatacao());
            ps.setString(3, intimacao.getNumIntimacaoConstatacao());
            ps.setString(4, intimacao.getCodRastreioIntimacao());
            ps.setString(5, intimacao.getDataPostagemIntimacao());
            ps.setString(6, intimacao.getDataEntregaIntimacao());
            ps.setString(7, "" + intimacao.getAtivoIntimacao());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "N??o foi possivel alterar a intimacao");
            return false;
        }
    }

    public boolean excluir(Intimacao intimacao){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, intimacao.getIdIntimacao());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "N??o foi possivel excluir a intimacao");
            return false;
        }
    }

    public boolean consultar(Intimacao intimacao){
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_CONSULTAR);
            ps.setInt(1, intimacao.getIdIntimacao());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                intimacao.setIdPropriedade(Integer.parseInt(rs.getString("idPropriedade")));
                intimacao.setNumIntimacao(rs.getString("numIntimacao"));
                intimacao.setNumConstatacao(rs.getString("numConstatacao"));
                intimacao.setNumIntimacaoConstatacao(rs.getString("numIntimacaoConstatacao"));
                intimacao.setCodRastreioIntimacao(rs.getString("codRastreioIntimacao"));
                intimacao.setDataPostagemIntimacao(rs.getString("dataPostagemIntimacao"));
                intimacao.setDataEntregaIntimacao(rs.getString("dataEntregaIntimacao"));
                intimacao.setAtivoIntimacao(rs.getString("ativoIntimacao").charAt(0));
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "N??o foi possivel consultar a intimacao");
            return false;
        }
    }
}


