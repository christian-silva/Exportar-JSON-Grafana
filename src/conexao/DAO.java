/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import dados.dashboard;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian
 */
public class DAO {

    private final Connection con;
    private Component jframeAtual = null;

    public DAO(Component jframe) {
        this.con = ConexaoPermanente.getConexao();
        this.jframeAtual = jframe;
        //System.out.println("Conexao Criada: " + con);
    }

    public List<dashboard> selecionarDashboards() {
        List<dashboard> listaDashboards = new ArrayList<>();

        String sql = "SELECT A.created, A.updated, A.slug, A.title,  A.data,  A.org_id, B.name FROM dashboard as A inner join org as B ON A.org_id = B.id;";
        PreparedStatement prpstmt = null;
        ResultSet rs = null;
        try {
            prpstmt = con.prepareStatement(sql);
            rs = prpstmt.executeQuery();
            
            while (rs.next()) {
                dashboard dados = new dashboard(
                        rs.getString("created"),
                        rs.getString("updated"), 
                        rs.getString("slug"), 
                        rs.getString("title"), 
                        rs.getString("data"), 
                        rs.getInt("org_id"), 
                        rs.getString("name")
                );
                listaDashboards.add(dados);
            }
            return listaDashboards;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(jframeAtual, "Erro no SELECT da listaDashboards de toda a tabela.\n" + ex.getMessage());
            System.err.println("Erro no SELECT da listaDashboards de toda a tabela: " +ex);
            return null;
        }
    }
}
