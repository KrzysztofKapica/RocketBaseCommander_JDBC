package org.example;

import java.sql.*;

public class Repository {

    String url = "jdbc:mysql://localhost:3306/rocketbasecom?useSSL=false";
    String user = "root";
    String password = "12345";

    public void getListOfTargets() {

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery("SELECT * FROM target")) {

            System.out.println("List of targets in Mordor:");

            while (rs.next()) {
                System.out.print(rs.getInt(1));
                System.out.print(": ");
                System.out.print(rs.getString(2) + " |");
                System.out.print(" ");
                System.out.print(rs.getInt(3) + " kilometers away |");
                System.out.print(" ");
                System.out.print(rs.getInt(4) + "% damaged");
                System.out.print(" ");
                System.out.println();
            }
        } catch (
                SQLException e) {
            System.out.println(e);
        }
    }

    public void getOneTarget(int givenId) {

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery("SELECT * FROM target")) {

            rs.absolute(givenId);
                System.out.print(rs.getInt(1));
                System.out.print(": ");
                System.out.print(rs.getString(2) + " |");
                System.out.print(" ");
                System.out.print(rs.getInt(3) + " kilometers away |");
                System.out.print(" ");
                System.out.print(rs.getInt(4) + "% damaged");
                System.out.print(" ");
                System.out.println();

        } catch (
                SQLException e) {
            System.out.println(e);
        }
    }

    public int getDistanceToTarget(int givenId) {

        int targetDdistance = 0;

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery("SELECT distance FROM target")) {

            rs.absolute(givenId);
            targetDdistance = rs.getInt(1);

        } catch (
                SQLException e) {
            System.out.println(e);
        }
        return targetDdistance;
    }

    public int getDamageOfTarget(int givenId) {

        int targetDamage = 0;

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery("SELECT damage FROM target")) {

            rs.absolute(givenId);
            targetDamage = rs.getInt(1);

        } catch (
                SQLException e) {
            System.out.println(e);
        }
        return targetDamage;
    }

    public void damageToTarget(int whichTarget, int causedDamage) { //metoda do zmiany damage targetu w db

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery("SELECT id, damage FROM target")) {

            rs.absolute(whichTarget);

            int oldValue = rs.getInt("damage");
            rs.updateInt("damage", oldValue + causedDamage);
            rs.updateRow();

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void getListOfRockets() {

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery("SELECT * FROM rocket")) {

            System.out.println("List of rockets:");

            while (rs.next()) {
                System.out.print(rs.getInt(1));
                System.out.print(": ");
                System.out.print(rs.getString(2) + " |");
                System.out.print(" ");
                System.out.print(rs.getInt(3) + " kilometers of range |");
                System.out.print(" ");
                System.out.print("can cause " + rs.getInt(4) + "% of damage");
                System.out.print(" ");
                System.out.println();
            }
        } catch (
                SQLException e) {
            System.out.println(e);
        }
    }

    public int getRangeOfRocket(int givenId) {

        int rocketRange = 0;

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery("SELECT rangeOfFire FROM rocket")) {

            rs.absolute(givenId);
            rocketRange = rs.getInt(1);

        } catch (
                SQLException e) {
            System.out.println(e);
        }
        return rocketRange;
    }

    public int getDamageByRocket(int givenId) {

        int rocketDamage = 0;

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery("SELECT causingDamage FROM rocket")) {

            rs.absolute(givenId);
            rocketDamage = rs.getInt(1);

        } catch (
                SQLException e) {
            System.out.println(e);
        }
        return rocketDamage;
    }
}