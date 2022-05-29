package com.example.demo3.dao;

import com.example.demo3.database.connectUtili;
import com.example.demo3.model.employess;
import com.google.protobuf.Any;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class employessDao {
    Connection connection = connectUtili.getConnection();

    public List<employess> getEmployess(int id){
        List<employess> list = new ArrayList<>();
        if(id > 0){
            String sql = "SELECT * FROM `employess`where id = ?";
            try{
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    employess e = new employess();
                    e.setId(rs.getInt("id"));
                    e.setName(rs.getString("name"));
                    e.setAddress(rs.getString("address"));
                    e.setPhone(rs.getString("phone"));
                    e.setEmail(rs.getString("email"));
                    list.add(e);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            return list;
        }else{

        }
        String sql = "SELECT * FROM `employess`";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                employess e = new employess();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setAddress(rs.getString("address"));
                e.setPhone(rs.getString("phone"));
                e.setEmail(rs.getString("email"));
                list.add(e);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public String updateEmployess(employess e){
        String sql = "UPDATE `employess` SET name = ?, email = ?, address = ?, phone = ? where id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,e.getName());
            ps.setString(2,e.getEmail());
            ps.setString(3,e.getAddress());
            ps.setString(4,e.getPhone());
            ps.setInt(5,e.getId());
            int suss = ps.executeUpdate();
            if(suss > 0){
                return "Success";
            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return "fail";
    }
    public String insertEmployess(employess e){
        String sql = "insert into `employess` (name,email,address,phone) values (?,?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,e.getName());
            ps.setString(2,e.getEmail());
            ps.setString(3,e.getAddress());
            ps.setString(4,e.getPhone());
            int suss = ps.executeUpdate();
            if(suss > 0){
                return "Success";
            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return "fail";
    }
    public String deleteEmployess(int id){
        String sql = "DELETE `employess`  where id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            int suss = ps.executeUpdate();
            if(suss > 0){
                return "Success";
            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return "fail";
    }
}
