package xicraft.xicraft;

import java.sql.*;
import java.util.Properties;


class SqlCo {
    // init SqlCo constants
    private static final String SqlCo_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String SqlCo_URL = "jdbc:mysql://localhost:3306/xibot?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "7aXqVk.83";
    private static final String MAX_POOL = "250";

    // init connection object
    private Connection connection;
    // init properties object
    private Properties properties;

    // create properties
    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }

    // connect SqlCo
    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName(SqlCo_DRIVER);
                connection = DriverManager.getConnection(SqlCo_URL, getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // disconnect SqlCo
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

public class DB {
    private final SqlCo mysqlConnect = new SqlCo();

    public static void main(String[] args) {
    }

    public void registerPlayer(String uuid, String DN) {
        try {
            Connection con = mysqlConnect.connect();
            Statement statement = con.createStatement();
            String query = String.format("select data from minecraft_players where uuid = '%s'", uuid);
            ResultSet res = statement.executeQuery(query);
            int points = 0;
            while (res.next()) {
                points++;
            }
            if (points == 0) {
                String register_query = String.format("INSERT INTO minecraft_players VALUES ('{}', '%s')", uuid);
                statement.executeUpdate(register_query);
            }
            Statement statement_2 = con.createStatement();
            String query_2 = String.format("update minecraft_players set data = JSON_SET(data, '$.display_name', '%s') where uuid = '%s'", DN, uuid);
            statement_2.executeUpdate(query_2);
            mysqlConnect.disconnect();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public int getXicoin(String uuid) {
        try {
            Connection con = mysqlConnect.connect();
            Statement statement = con.createStatement();
            String query = String.format("select infos->'$.xicoin' from users where infos->'$.minecraft_id' = '%s'", uuid);
            ResultSet res = statement.executeQuery(query);
            int xicoins = 0;
            while (res.next()) {
                xicoins = res.getInt(1);
            }
            mysqlConnect.disconnect();
            return xicoins;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    public int getPoints(String uuid) {
        try {
            Connection con = mysqlConnect.connect();
            Statement statement = con.createStatement();
            String query = String.format("select data->'$.xite_event_pts' from minecraft_players where uuid = '%s'", uuid);
            ResultSet res = statement.executeQuery(query);
            int points = -1;
            while (res.next()) {
                points = res.getInt(1);
            }
            if (points == -1) {
                String register_query = String.format("INSERT INTO minecraft_players VALUES ('{}', '%s')", uuid);
                statement.executeUpdate(register_query);
                points = 0;
            }
            mysqlConnect.disconnect();
            return points;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    public int getHome(String uuid) {
        try {
            Connection con = mysqlConnect.connect();
            Statement statement = con.createStatement();
            String query = String.format("select data->'$.has_home' from minecraft_players where uuid = '%s'", uuid);
            ResultSet res = statement.executeQuery(query);
            int points = 0;
            while (res.next()) {
                points = res.getInt(1);
            }
            mysqlConnect.disconnect();
            return points;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    public void setXicoin(String uuid, int amount) {
        try {
            Connection con = mysqlConnect.connect();
            Statement statement = con.createStatement();
            String query = String.format("update users set infos = JSON_SET(infos, '$.xicoin', %d) where infos->'$.minecraft_id' = '%s'", amount, uuid);
            statement.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void setPoints(String uuid, int amount) {
        try {
            Connection con = mysqlConnect.connect();
            Statement statement = con.createStatement();
            String query = String.format("update minecraft_players set data = JSON_SET(data, '$.xite_event_pts', %d) where uuid = '%s'", amount, uuid);
            statement.executeUpdate(query);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void setHome(String uuid, int owner) {
        try {
            Connection con = mysqlConnect.connect();
            Statement statement = con.createStatement();
            String query = String.format("update minecraft_players set data = JSON_SET(data, '$.has_home', %d) where uuid = '%s'", owner, uuid);
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Object[] getRanks() {
        try {
            Object[] obj = new Object[24];
            Connection con = mysqlConnect.connect();
            Statement statement = con.createStatement();
            String query = "select data->'$.display_name', data->'$.xite_event_pts' from minecraft_players order by data->'$.xite_event_pts' desc ";
            ResultSet res = statement.executeQuery(query);
            int n = 0;
            while (res.next() && n <= 20) {
                obj[n] = res.getString(1);
                obj[n + 1] = res.getInt(2);
                n += 2;
            }
            mysqlConnect.disconnect();
            return obj;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
