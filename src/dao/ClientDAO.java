package dao;

import model.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends DAO {

    public ClientDAO() {
        super();
    }

    public ArrayList<Client> searchClient(String name) {
        ArrayList<Client> clientArrayList = new ArrayList<>();

        String querySql = "SELECT * FROM client WHERE name LIKE ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(querySql)) {
            preparedStatement.setString(1,"%" + name + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Client client = new Client();

                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setAddress(resultSet.getString("address"));
                client.setTel(resultSet.getString("tel"));
                client.setIdCard(resultSet.getString("id_card"));

                clientArrayList.add(client);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clientArrayList;
    }
}
