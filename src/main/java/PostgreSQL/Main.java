package PostgreSQL;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        var url = "jdbc:postgresql://localhost:5432/";
        var username = "postgres";
        var password = "12345678";
        var nameDB = "newDB";
        try {
            Connection db = DriverManager.getConnection(url, username, password);
            Statement st = db.createStatement();

            st.execute("CREATE DATABASE " + nameDB);

            db = DriverManager.getConnection(url + nameDB, username, password);
            st = db.createStatement();

            st.execute("CREATE TABLE public.users (\n" +
                    "\tid int NOT NULL GENERATED ALWAYS AS IDENTITY,\n" +
                    "\t\"name\" varchar NULL,\n" +
                    "\tsurname varchar NULL,\n" +
                    "\tprofession varchar NULL" +
                    ");\n");
            st.execute("CREATE TABLE public.cities (\n" +
                    "\tid int NOT NULL GENERATED ALWAYS AS IDENTITY,\n" +
                    "\t\"name\" varchar NULL,\n" +
                    "\tcountry varchar NULL,\n" +
                    "\tcountry_code int NULL\n" +
                    ");\n");
            st.execute("CREATE TABLE public.professions (\n" +
                    "\tid int NOT NULL GENERATED ALWAYS AS IDENTITY,\n" +
                    "\tprofession varchar NULL,\n" +
                    "\tcountry varchar NULL,\n" +
                    "\tspecialization varchar NULL\n" +
                    ");\n");
            db.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
