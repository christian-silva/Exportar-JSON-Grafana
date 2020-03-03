/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Christian
 */
public class ConexaoPermanente {

    private static final String DRIVER = "org.sqlite.JDBC";
    private static String localBD = "";
    private static Connection conexao = null;

    public static Connection getConexao() {
        return conexao;
    }

    public static void CriaConexao(String path) {
        //System.out.println("Conexão Criada: " + path);
        if (path != null) {
            try {
                Class.forName(DRIVER);
                conexao = DriverManager.getConnection("jdbc:sqlite:" + path);
                localBD = (path);
            } catch (ClassNotFoundException | SQLException ex) {
                throw new RuntimeException("Erro na conexão Driver", ex);
            }
        } else {
            conexao = null;
            throw new RuntimeException("Erro na localização do Banco de Dados.");
        }
    }

    public static void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar Connection", ex);
            }
        }
    }

    public static void fecharConexao(Connection conexaoRecebida) {
        if (conexaoRecebida != null) {
            try {
                conexaoRecebida.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar Connection", ex);
            }
        }
    }

    public static void fecharConexao(Connection conexaoRecebida, PreparedStatement prepstmtRecebido) {
        if (prepstmtRecebido != null) {
            try {
                prepstmtRecebido.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar o PreparedStatement", ex);
            }
        }
        fecharConexao(conexaoRecebida);
    }

    public static void fecharConexao(Connection conexaoRecebida, PreparedStatement prepstmtRecebido, ResultSet rsRecebido) {
        if (rsRecebido != null) {
            try {
                rsRecebido.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar o ResultSet", ex);
            }
        }
        fecharConexao(conexaoRecebida, prepstmtRecebido);
    }

    public static String getLocalBD() {
        return localBD;
    }
}
