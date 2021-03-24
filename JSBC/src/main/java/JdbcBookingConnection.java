import lombok.extern.log4j.Log4j2;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class JdbcBookingConnection {

    public static void main(String[] args) {
        Connection connection = newConnection(
                "postgresql",
                "localhost",
                "5432",
                "booking",
                "postgres",
                "1234"
        );
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            insertTableAccommodation(connection);
            insertTableFairEntry(connection);
            insertTableRelation(connection);
//            createTableRoomFair(connection);
//            createTableRelation(connection);
//            createTableAccommodation(connection);
//            createDataBaseBooking(connection);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from accommodation");

            List<Accommodation> accommodations = new ArrayList<>();
            while (resultSet.next()) {
                Accommodation accommodation = new Accommodation();
                accommodation.setId(resultSet.getInt("id"));
                accommodation.setType(resultSet.getString("type"));
                accommodation.setBed_type(resultSet.getString("bed_type"));
                accommodation.setMax_guests(resultSet.getInt("max_guests"));
                accommodation.setDescription(resultSet.getString("description"));

                accommodations.add(accommodation);
            }

            for (int i = 0; i < accommodations.size(); i++) {
                log.info(accommodations.get(i));
            }

            Statement statement2 = connection.createStatement();
            ResultSet resultSet2 = statement2.executeQuery("select * from room_fair");

            List<RoomFair> roomFairs = new ArrayList<>();
            while (resultSet2.next()) {
                RoomFair roomFair = new RoomFair();
                roomFair.setId(resultSet2.getInt("id"));
                roomFair.setValue(resultSet2.getDouble("value"));
                roomFair.setSeason(resultSet2.getString("season"));
                roomFairs.add(roomFair);
            }

            for (int i = 0; i < roomFairs.size(); i++) {
                log.info(roomFairs.get(i));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertTableRelation(Connection connection) throws SQLException {
        PreparedStatement insertRelation = connection.prepareStatement("insert into accommodation_to_room_fair_relation" +
//                   "(id_accommodation, id_room_fair) values (1, 1)");
//                    "(id_accommodation, id_room_fair) values (2, 2)");
                "(id_accommodation, id_room_fair) values (3, 3)");

        insertRelation.executeUpdate();
        connection.commit();
    }

    private static void insertTableFairEntry(Connection connection) throws SQLException {
        PreparedStatement insertRoomFair = connection.prepareStatement("insert into room_fair" +
//                   "(value, season) values (574.0,'summer')")
//                   "(value, season) values (172.5,'winter')");
                "(value, season) values (399.5,'fall')");

        insertRoomFair.executeUpdate();
        connection.commit();
    }

    private static void insertTableAccommodation(Connection connection) throws SQLException {
        PreparedStatement insertAccommodation =
                connection.prepareStatement("insert into accommodation" +
//                        "(type, bed_type, max_guests, description) values ('apartament1', " +
//                               "'double', 2, 'description1')");
//                         "(type, bed_type, max_guests, description) values ('apartament2', " +
//                                 "'single', 1, 'description2')");
                        "(type, bed_type, max_guests, description) values ('apartament3', " +
                        "'triple', 3, 'description2')");

        insertAccommodation.executeUpdate();
        connection.commit();
    }

    private static void createTableRelation(Connection connection) throws SQLException {
        PreparedStatement createRelationTable = connection.prepareStatement(
                "create table accommodation_to_room_fair_relation" +
                        "(" +
                        "id SERIAL not null, " +
                        "id_accommodation int, " +
                        "id_room_fair int, " +
                        "primary key(id), " +
                        "foreign key(id_accommodation) references accommodation(id), " +
                        "foreign key(id_room_fair) references room_fair(id))"
        );
        createRelationTable.executeUpdate();
        connection.commit();
    }

    private static void createTableRoomFair(Connection connection) throws SQLException {
        PreparedStatement createTable2 = connection.prepareStatement(
                "create table room_fair" +
                        "(" +
                        "id SERIAL not null," +
                        "value decimal, " +
                        "season varchar(32), " +
                        "primary key(id))"
        );
        createTable2.executeUpdate();
        connection.commit();
    }

    private static void createTableAccommodation(Connection connection) throws SQLException {
        PreparedStatement createTable = connection.prepareStatement(
                "create table accommodation " +
                        "(" +
                        "id SERIAL not null," +
                        "type varchar(32), " +
                        "bed_type varchar(32), " +
                        "max_guests int, " +
                        "description varchar(512), " +
                        "primary key(id))");

        createTable.executeUpdate();
        connection.commit();
    }

    private static void createDataBaseBooking(Connection connection) throws SQLException {
        PreparedStatement createDataBase =
                connection.prepareStatement(" create database booking ");
    }

    private static Connection newConnection(
            String type, String host, String port,
            String dbName, String user, String password) {

        String url = "jdbc:" + type + "://" + host + ":" + port + "/" + dbName +
                "?user=" + user + "&password=" + password;

        System.out.println(url);
        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}