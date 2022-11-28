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
    public final static String SQL_PESQUISAR = "SELECT * FROM Intimacao";
    public final static String SQL_COMBOBOX = "";

    public boolean incluir(Intimacao intimacao){
        try {
            intimacao.setIdIntimacao(Conexao.getGenerator("G_INTIMACAO"));
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQL_INCLUIR);
            ps.setInt(1, intimacao.getIdIntimacao());
            ps.setString(2, intimacao.getNumIntimacao());
            ps.setString(3, intimacao.getNumConstatacao());
            ps.setString(4, intimacao.getNumIntimacaoConstatacao());
            ps.setString(5, intimacao.getCodRastreioIntimacao());
            ps.setDate(6, intimacao.getDataPostagemIntimacao());
            ps.setDate(7, intimacao.getDataEntregaIntimacao());
            ps.setInt(8, intimacao.getAtivoIntimacao());
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}


