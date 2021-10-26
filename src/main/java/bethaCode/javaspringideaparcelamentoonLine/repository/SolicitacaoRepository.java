package bethaCode.javaspringideaparcelamentoonLine.repository;

import bethaCode.javaspringideaparcelamentoonLine.ConnectionManager;
import bethaCode.javaspringideaparcelamentoonLine.model.Solicitacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SolicitacaoRepository {

    /*Efetua a inserção da solicitação*/
    public static void create(Solicitacao solicitacao) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement statement = conn.prepareStatement("insert into telegram.solicitacao values(?,?,?,?,?,?,?) ");
        statement.setLong(1, solicitacao.getIdSolicitacao());
        statement.setLong(2, solicitacao.getIdContato());
        statement.setLong(3, solicitacao.getEtapa());
        statement.setString(4, solicitacao.getSituacao());
        statement.setString(5, solicitacao.getCpfCnpj());
        statement.setTimestamp(6, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
        statement.setString(7, solicitacao.getNome());
        statement.executeUpdate();
        System.out.println("Criada nova solicitação : " + java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
        conn.close();
    }

    public static Solicitacao findById(Long id) throws SQLException, ClassNotFoundException {
        Solicitacao solicitacao = new Solicitacao();
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement statement3 = conn.prepareStatement("SELECT idsolicitacao,idcontato,etapa,situacao,cpfcnpj,datasolicitacao,nome FROM telegram.solicitacao WHERE idcontato = ? and situacao ='A'");
        statement3.setLong(1, id);
        ResultSet resultSet3 = null;
        resultSet3 = statement3.executeQuery();
        if (resultSet3.next()) {
            solicitacao.setEtapa(resultSet3.getInt("etapa"));
        } else {
            return null;
        }
        System.out.println("---- Listagem INI ----");
        int index3 = resultSet3.getInt(3);
        String index7 = resultSet3.getString(7);
        System.out.println("Resultado da consulta : " + index3 + " Nome :" + index7);
        System.out.println("Resultado da consulta 2 : " + solicitacao.getEtapa());
        conn.close();

        if (index3 < 1) {
            return null;
        } else {
            return solicitacao;
        }

    }

    public static void update(Solicitacao solicitacao) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement update = conn.prepareStatement("UPDATE telegram.solicitacao SET idsolicitacao = ?, etapa = ?, cpfcnpj = ? , datasolicitacao = ? WHERE idcontato = ?");
        update.setLong(1, solicitacao.getIdSolicitacao());
        update.setLong(2, solicitacao.getEtapa());
        update.setString(3, solicitacao.getCpfCnpj());
        update.setTimestamp(4, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
        update.setLong(5, solicitacao.getIdContato());
        update.executeUpdate();
        conn.close();
    }

    public static void updatePasso3(Solicitacao solicitacao) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement updatePasso3 = conn.prepareStatement("UPDATE telegram.solicitacao SET idsolicitacao = ?, etapa = ? , datasolicitacao = ? WHERE idcontato = ?");
        updatePasso3.setLong(1, solicitacao.getIdSolicitacao());
        updatePasso3.setLong(2, solicitacao.getEtapa());
        updatePasso3.setTimestamp(3, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
        updatePasso3.setLong(4, solicitacao.getIdContato());
        updatePasso3.executeUpdate();
        conn.close();
    }

    public static void delete(Solicitacao solicitacao) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement delete = conn.prepareStatement("DELETE FROM telegram.solicitacao WHERE idcontato = ? AND SITUACAO = 'A'");
        delete.setLong(1, solicitacao.getIdContato());
        delete.executeUpdate();
        conn.close();
    }

}
