package com.company;

import java.sql.*;

public class Main {

    private static final String DBURl = "jdbc:mysql://localhost/universityapplication";
    private static final String DBUser = "root";
    private static final String DBPss = "";

    public static void main(String[] args) throws SQLException {
	// write your code here

        //SelectQuery();
        //InsertQuery();
        //UpdateQuery();
        //DeleteQuery();
    }

    private static void DeleteQuery() {
        Connection connection = null;
        PreparedStatement statement = null;

        String query = "DELETE FROM depatment WHERE deparment_id=?";
        try{
            connection = DriverManager.getConnection(DBURl,DBUser,DBPss);
            statement = connection.prepareStatement(query);
            statement.setInt(1,1);
            int count = statement.executeUpdate();
            if (count>0){
                System.out.println("department delete successfully");
            }else {
                System.out.println("Something error");
            }
        }catch (SQLException e ){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                if (connection!=null){
                    statement.close();
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void UpdateQuery() {
        Connection connection = null;
        PreparedStatement statement = null;

        String query = " UPDATE depatment SET deparment_name=? WHERE deparment_id=?;";
        try{
            connection = DriverManager.getConnection(DBURl,DBUser,DBPss);
            statement = connection.prepareStatement(query);
            statement.setString(1,"abc");
            statement.setInt(2,1);
            int count = statement.executeUpdate();
            if (count>0){
                System.out.println("department update successfully");
            }else {
                System.out.println("Something error");
            }
        }catch (SQLException e ){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                if (connection!=null){
                    statement.close();
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void InsertQuery() {
        Connection connection = null;
        PreparedStatement statement = null;

        String query = " INSERT INTO depatment  (deparment_name,deparment_code)  VALUES(?,?)";
        try{
            connection = DriverManager.getConnection(DBURl,DBUser,DBPss);
            statement = connection.prepareStatement(query);
            statement.setString(1,"Physice department");
            statement.setString(2,"phy");
            int count = statement.executeUpdate();
            if (count>0){
                System.out.println("department insert successfully");
            }else {
                System.out.println("Something error");
            }
        }catch (SQLException e ){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                if (connection!=null){
                     statement.close();
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void SelectQuery() {
        Connection connection= null;
        PreparedStatement statement = null;
        String deparmentcode = "bba";
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/universityapplication","root","");
            String qurey = "SELECT * FROM depatment WHERE deparment_code = ?";
            statement = connection.prepareStatement(qurey);
            statement.setString(1,deparmentcode);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                System.out.println("id:" + resultSet.getInt(1));
                System.out.println("name:" + resultSet.getString(2));
                System.out.println("code:" + resultSet.getString(3));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                if (connection!=null){
                    resultSet.close();
                    statement.close();
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
