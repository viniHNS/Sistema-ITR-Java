package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Conexao {
    private static Connection conexao = null;

    public static Connection getConexao(){
        if (conexao != null){
            return conexao;
        } else {
            try {
                Class.forName("org.firebirdsql.jdbc.FBDriver");
                conexao = DriverManager.getConnection("jdbc:firebirdsql://localhost:3050/" + System.getProperty("user.dir") + "/SISTEMA.FDB", "SYSDBA", "masterkey");
                System.out.println(System.getProperty("user.dir"));  
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
                JOptionPane.showMessageDialog(null,"Erro no driver jdbc");
            } catch (SQLException se){
                se.printStackTrace();
                JOptionPane.showMessageDialog(null,"Erro de SQL");

            }
            return conexao;
        }  
    }

    public static int getGenerator(String nomeGenerator){
        try {
            String sql = "SELECT GEN_ID(" + nomeGenerator + ", 1) FROM RDB$DATABASE";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return rs.getInt(1);
            } else {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Houve um problema ao tentar obter o generator " + nomeGenerator);
            return -1;
        }
    }

    public static List<List<String>> executaQuery(String sql){
        List<List<String>> retorno = new ArrayList<>();
        try {
            Statement st = Conexao.getConexao().createStatement();
            ResultSet rs = st.executeQuery(sql);
            int qtdeColunas = rs.getMetaData().getColumnCount();
            for (int c = 1; c <= qtdeColunas; c++){
                System.out.println(rs.getMetaData().getColumnName(c) + "\t");
            }
            System.out.println("");
            while(rs.next()){
                List<String> valores = new ArrayList<>();
                for (int c = 1; c <= qtdeColunas; c++){
                    valores.add(rs.getString(c));
                }
                retorno.add(valores);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao consultar dados");
        }
        return retorno;

        
    }

}
