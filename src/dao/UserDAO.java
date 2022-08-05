package dao;

import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserDAO extends DAO {
    public UserDAO() {
        super();
    }
    public boolean checkLogin(User user) {
        boolean flag = false;
        String sqlQuery = "SELECT name, pos FROM user WHERE username = ? AND password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            System.out.println(preparedStatement.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user.setName(resultSet.getString("name"));
                user.setPos(resultSet.getString("pos"));
                flag = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return flag;
    }
}
