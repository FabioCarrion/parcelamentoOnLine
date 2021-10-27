package bethaCode.javaspringideaparcelamentoonLine.repository;

import bethaCode.javaspringideaparcelamentoonLine.ConnectionManager;
import bethaCode.javaspringideaparcelamentoonLine.model.Dividas;
import bethaCode.javaspringideaparcelamentoonLine.model.Solicitacao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DividasRepository {
    public static  Dividas findBycpfcnpj(String cpfcnpj) throws SQLException, ClassNotFoundException {
        Dividas dividas = new Dividas();
        Solicitacao solicitacao = new Solicitacao();
        Connection conn = ConnectionManager.getConnection();
        PreparedStatement statement3 = conn.prepareStatement("SELECT receita,valor,ano  FROM dividas.dividas where cpfcnpj = ? and  situacao  = 'A'");
        statement3.setString(1, cpfcnpj);
        ResultSet resultSet3 = null;
        resultSet3 = statement3.executeQuery();
        if (resultSet3.next()) {
            dividas.setValor(resultSet3.getFloat("valor"));
        } else {
            return null;
        }
        System.out.println("---- Listagem INI  DividasRepository----");
        Float index3 = resultSet3.getFloat(2);
        System.out.println("Resultado da consulta : " + index3 + " Nome :" + index3);
        System.out.println("Resultado da consulta 2 : " + dividas.getValor());
        conn.close();

        if (index3 < 1) {
            return null;
        } else {
            return dividas;
        }

    }
}
