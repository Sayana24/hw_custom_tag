package com.taraskina.hw_custom_tag;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StudentMap {
    private Map<String, Integer> students = new HashMap<String, Integer>();

    {
        HashMap<String, Integer> students = new HashMap<String, Integer>();

        try(Connection connection = DbManager.createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select name, result from student " +
                            "where result in (select result from student " +
                            "                 group by result " +
                            "                 having count(*)>1)")) {

            int i = 0;
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                int result = resultSet.getInt(2);
                this.students.put(name, result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private Iterator<Map.Entry<String, Integer>> iterator = students.entrySet().iterator();
    public int getSize(){
        return students.size();
    }
    public String getRating(){
        if (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            return entry.getKey() + "  " + entry.getValue();
        } else {
            return null;
        }
    }
}
