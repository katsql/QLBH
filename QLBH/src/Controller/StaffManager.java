/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DBConnector;
import Model.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author huutr
 */
public class StaffManager {
    Connection conn;
    public StaffManager() throws SQLException, ClassNotFoundException, Exception{
        DBConnector db = new DBConnector();
        this.conn = db.getConnect();
    }
    public int login(String userName, String passWord) throws SQLException{
        String query = "Select * from ACCOUNT where acc = ? and pass = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString(1, userName);
        ps.setString(2, passWord);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            String s1 = rs.getString("role");
            if(s1.equalsIgnoreCase("Admin")){
                return 0;
            }
            else if (s1.equalsIgnoreCase("User")){
                return 1;
            }
        }
        return 2;
    }
    
    public Staff getDetail(int maNV) throws SQLException{
        String query = "Select * from NHANVIEN nv where nv.manv = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setInt(1, maNV);
        ResultSet rs = ps.executeQuery();
        Staff nv = null; 
        while (rs.next()){
            nv = new Staff(maNV, rs.getString("HoTen"), rs.getBoolean("GioiTinh"), rs.getDate("NgaySinh"), rs.getString("DiaChi"), rs.getInt("SDT"), rs.getFloat("NgayCong"), rs.getFloat("HeSoLuong"), rs.getInt("Luong"));
        }
        return nv;
    }
    
    public boolean checkStaff(int maNV) throws SQLException{
        String query = "Select * from NHANVIEN nv where nv.manv = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setInt(1, maNV);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            return true;
        }
        return false;
    }
    
    public boolean checkSexStaff(int maNV) throws SQLException{
        String query = "Select GioiTinh from NHANVIEN nv where nv.manv = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setInt(1, maNV);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            if("Nam".equals(rs.getString("GioiTinh")))
                return true;
        }
        return false;
    }
    
    public void addStaff(String hoTen, Date ngaySinh, String diaChi, Boolean gioiTinh, String phone, int ngayCong, float heSoLuong, int luong) throws SQLException{
        String gt;
        gt = (gioiTinh = true)?"Nam":"Nữ";
        SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy");
        String stringDate= DateFor.format(ngaySinh);
        String query2 = "insert NHANVIEN " + "values(?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps2 = this.conn.prepareStatement(query2);
        ps2.setString(1, hoTen);
        ps2.setString(2, stringDate);
        ps2.setString(3, diaChi);
        ps2.setString(4, gt);
        ps2.setString(5, phone);
        ps2.setInt(6, ngayCong);
        ps2.setFloat(7, heSoLuong);
        ps2.setInt(8, luong);
        ps2.execute();
    }
    
    public boolean deleteStaff(int maNV) throws SQLException{
        if(this.checkStaff(maNV)){
            String query = "DELETE FROM NHANVIEN WHERE NHANVIEN.MANV =?;";
            PreparedStatement ps = this.conn.prepareStatement(query);
            ps.setInt(1, maNV);
            ps.execute();
            return true;
        }       
        return false;
    }
    
    public boolean updateStaff(int maNV, String hoTen, Date ngaySinh, String diaChi, Boolean gioiTinh, String phone, int ngayCong, float heSoLuong, int Luong) throws SQLException{
        if (this.checkStaff(maNV)){
            String gt;
            gt = (gioiTinh = true)?"Nam":"Nữ";
            SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
            String stringDate= DateFor.format(ngaySinh);
            String query = "update NHANVIEN " + "SET HoTen = ?, NgaySinh = ? , DiaChi = ?, GioiTinh = ?, SDT = ?, NgayCong = ?, HeSoLuong = ?, Luong = ? WHERE NHANVIEN.manv=?";
            PreparedStatement ps2 = this.conn.prepareStatement(query);
            ps2.setString(1, hoTen);
            ps2.setString(2, stringDate);
            ps2.setString(3, diaChi);
            ps2.setString(4, gt);
            ps2.setString(5, phone);
            ps2.setInt(6, ngayCong);
            ps2.setFloat(7, heSoLuong);
            ps2.setInt(8, Luong);
            ps2.setInt(9, maNV);
            ps2.execute();
            return true;            
        } else{
            return false;
        }
    }
    
    public List<Staff> getListStaff() throws SQLException{
        List<Staff> listStaff = new ArrayList<>();
        String query = "Select * from NHANVIEN nv";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        Staff nv = null;
        while(rs.next()){
            boolean gt;
            if("Nam".equals(rs.getString("GioiTinh"))){
                gt = true;
            }
            else{
                gt = false;
            }
            nv = new Staff();
            nv.setMaNV(rs.getInt("MaNV"));
            nv.setName(rs.getString("HoTen"));
            nv.setNgaySinh(rs.getDate("NgaySinh"));
            nv.setGender(gt);
            nv.setAddress(rs.getString("DiaChi"));
            nv.setPhone(rs.getInt("SDT"));
            nv.setNgayCong(rs.getFloat("NgayCong"));
            nv.setHeSoLuong(rs.getFloat("HeSoLuong"));
            nv.setLuong(rs.getInt("Luong"));
            listStaff.add(nv);
        }
        return listStaff;
    }
}

