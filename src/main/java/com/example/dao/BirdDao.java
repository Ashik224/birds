package com.example.dao;

import com.example.BirdInfo;
import com.example.Database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class BirdDao {
    Database database = new Database();

    public void insert(BirdInfo birdInfo) throws ClassNotFoundException, SQLException {
        Connection connection = database.getConnection();
        String name = birdInfo.getName();
        String scientificName = birdInfo.getScientificName();
        String category = birdInfo.getCategory();
        String region = birdInfo.getRegion();
        String description = birdInfo.getDescription();
        String image = birdInfo.getRealImage();

        String query = "insert into birdInfo(birdName, scientificName, category, region, description, birdImage) values(?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, scientificName);
        statement.setString(3, category);
        statement.setString(4, region);
        statement.setString(5, description);
        statement.setString(6, image);

        int count = statement.executeUpdate();
        System.out.println("Count: "+count);
    }

    public BirdInfo retrieve(String sciName) throws SQLException, ClassNotFoundException {
        Connection connection = database.getConnection();
        BirdInfo birdInfo = null;

        String query = "select * from birdInfo where scientificName = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, sciName);
        ResultSet rs = preparedStatement.executeQuery();

        if(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String category = rs.getString(4);
            String region = rs.getString(5);
            String description = rs.getString(6);
            String image = rs.getString(7);

            birdInfo = new BirdInfo(id,name,sciName,category,region,description,image);
        }
        return birdInfo;
    }

    public List<BirdInfo> retrieveAll() throws SQLException, ClassNotFoundException {
        Connection connection = database.getConnection();

        List <BirdInfo> info = new ArrayList<>();
        int count = 0;

        String query = "select * from birdInfo";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String scientificName = rs.getString(3);
            String category = rs.getString(4);
            String region = rs.getString(5);
            String description = rs.getString(6);
            String image = rs.getString(7);

            info.add(new BirdInfo(id, name, scientificName, category, region, description, image));
            count++;
        }
        return info;
    }

    public void delete(String scientific) throws SQLException, ClassNotFoundException {
        Connection connection = database.getConnection();
        String query = "delete from birdInfo where scientificName = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, scientific);
        int count = preparedStatement.executeUpdate();
        System.out.println("Count: "+count);
    }

    public void update(BirdInfo birdInfo) throws SQLException, ClassNotFoundException {
        int id = birdInfo.getId();
        String name = birdInfo.getName();
        String scientificName = birdInfo.getScientificName();
        String category = birdInfo.getCategory();
        String region = birdInfo.getRegion();
        String description = birdInfo.getDescription();
        String image = birdInfo.getRealImage();

        Connection connection = database.getConnection();
        String query = "update birdInfo set birdName = ? , scientificName = ? , category = ? , region = ? , description = ? , birdImage = ? where id = ?";
        PreparedStatement st = connection.prepareStatement(query);
        st.setString(1, name);
        st.setString(2, scientificName);
        st.setString(3, category);
        st.setString(4, region);
        st.setString(5, description);
        st.setString(6, image);
        st.setInt(7, id);

        st.executeUpdate();
    }

    public List<BirdInfo> retrieveSearch(String searchData) throws SQLException, ClassNotFoundException {
        List<BirdInfo> birdInfoList = new ArrayList<>();
        Connection connection = database.getConnection();
        searchData = searchData
                .replace("!", "!!")
                .replace("%", "!%")
                .replace("_", "!_")
                .replace("[", "![");
        String query = "select * from birdInfo where birdName LIKE ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, searchData + "%");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String scientificName = rs.getString(3);
            String category = rs.getString(4);
            String region = rs.getString(5);
            String description = rs.getString(6);
            String image = rs.getString(7);

            birdInfoList.add(new BirdInfo(id, name, scientificName, category, region, description, image));
        }
        return birdInfoList;
    }
}
