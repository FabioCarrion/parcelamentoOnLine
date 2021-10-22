package bethaCode.javaspringideaparcelamentoonLine.repository;

import bethaCode.javaspringideaparcelamentoonLine.ConnectionManager;
import bethaCode.javaspringideaparcelamentoonLine.model.Solicitacao;

import java.sql.*;

public class SolicitacaoRepository {


        public static void create (Solicitacao solicitacao) throws SQLException, ClassNotFoundException {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement statement = conn.prepareStatement("insert into telegram.solicitacao (?,?,?,?,?,?,?) ");
            statement.setLong(1,solicitacao.getIdSolicitacao());
            statement.setLong(2,solicitacao.getIdContato());
            statement.setLong(3,solicitacao.getEtapa());
            statement.setString(4,solicitacao.getSituacao());
            statement.setString(5,solicitacao.getCpfCnpj());
           statement.setDate(6, solicitacao.getDataSolicitacao());
            statement.setString(7,solicitacao.getNome());
            statement.executeUpdate();
            System.out.println("---- Create POR ID FIM ----");
            conn.close();
        }

        public static Solicitacao findById (Long id) throws SQLException, ClassNotFoundException {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement statement3 = conn.prepareStatement("SELECT idsolicitacao,idcontato,etapa,situacao,cpfcnpj,datasolicitacao,nome FROM telegram.solicitacao WHERE idcontato = ?");
            statement3.setLong(1, id);
            ResultSet resultSet3 = null;
            resultSet3 = statement3.executeQuery();
            if(!resultSet3.next()){
                return null;
            }

            System.out.println("---- Listagem INI ----");
            Solicitacao solicitacao =  new Solicitacao();
            Long index3 = resultSet3.getLong(3);
            String index7 = resultSet3.getString(7);
            System.out.println( "Resultado da consulta : " + index3 + "Nome :" + index7);
            solicitacao.setEtapa(resultSet3.getInt(3));
            conn.close();
            if(index3 < 1 ){
                return null;
            }
            return solicitacao ;
        }


}
