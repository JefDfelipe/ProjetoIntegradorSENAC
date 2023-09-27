package com.jovemprogramador.aproveitamais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class AproveitamaisApplication {

	public static void main(String[] args) {
		SpringApplication.run(AproveitamaisApplication.class, args);
		String url = "jdbc:mysql://localhost/aproveitamais";
        String usuario = "root";
        String senha = "root";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
             Statement stmt = conexao.createStatement()) {

            String sql = "ALTER TABLE pessoa_fisica " +
                         "ADD CONSTRAINT fk_cod_endereco " +
                         "FOREIGN KEY (codigo_endereço) " +
                         "REFERENCES endereço(codigo_endereço)";

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

		try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
             Statement stmt = conexao.createStatement()) {

            String sql = "ALTER TABLE pessoa_juridica " +
                         "ADD CONSTRAINT fk_codi_endereco " +
                         "FOREIGN KEY (codigo_endereço) " +
                         "REFERENCES endereço(codigo_endereço)";

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

	}
}