package ru.stqa.study.addressbook.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import ru.stqa.study.addressbook.model.GroupDate;
import ru.stqa.study.addressbook.model.Groups;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import java.sql.*;


public class DBconnectionTest {


    public class LoadDriver {

        @Test
        public void testDbConnection() {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=&serverTimezone=UTC");
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select group_id, group_name, group_footer, group_header from group_list");
                Groups groups = new Groups();
                while (rs.next()) {
                    groups.add(new GroupDate().withId(rs.getInt("group_id")).withName(rs.getString("group_name"))
                            .withFooter(rs.getString("group_footer")).withHeader(rs.getString("group_header")));
                }
                rs.close();
                st.close();
                conn.close();

                System.out.println(groups);

                // Do something with the Connection

            } catch (SQLException ex) {
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        }
    }
}
