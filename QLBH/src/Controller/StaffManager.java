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
            nv = new Staff(maNV, rs.getString("HoTen"), rs.getString("GioiTinh"), rs.getDate("NgaySinh"), rs.getString("DiaChi"), rs.getInt("SDT"), rs.getFloat("NgayCong"), rs.getFloat("HeSoLuong"), rs.getInt("Luong"));
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
    
    public void addStaff(String hoTen, Date ngaySinh, String diaChi, Boolean gioiTinh, String phone, float ngayCong, float heSoLuong, int luong) throws SQLException{
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
        ps2.setFloat(6, ngayCong);
        ps2.setFloat(7, heSoLuong);
        ps2.setInt(8, luong);
        ps2.execute();
    }
      
       
    
    public boolean updateStaff(int maNV, String hoTen, Date ngaySinh, String diaChi, Boolean gioiTinh, String phone, float ngayCong, float heSoLuong, int Luong) throws SQLException{
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
            ps2.setFloat(6, ngayCong);
            ps2.setFloat(7, heSoLuong);
            ps2.setInt(8, Luong);
            ps2.setInt(9, maNV);
            ps2.execute();
            return true;            
        } else{
            return false;
        }
    }
    
    
    public void addKH(String HoTen, String DiaChi, int Sđt, String MaSoThue, int TongGH) throws SQLException
    {
        String query2 = "insert into KHACHHANG(HoTen, DiaChi, SDT, MaSoThue, TongHD) values(?, ?, ?, ?, ?)";
        PreparedStatement ps2 = this.conn.prepareStatement(query2);
        ps2.setString(1, HoTen);
        ps2.setString(2, DiaChi);
        ps2.setInt(3, Sđt);
        ps2.setString(4, MaSoThue);
        ps2.setInt(5, TongGH);
        ps2.execute();
    }
    
    public int getMaKH(int Sdt) throws SQLException
    {
        String query = "Select MaKH from KHACHHANG where SDT = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setInt(1, Sdt);
        ResultSet rs = ps.executeQuery();
        int MaKH = 0;
        if(rs.next()){
            MaKH  = rs.getInt("MaKH");            
        } 
        return MaKH;
    }
    
    public List<Staff> getListKH(int TongHD) throws SQLException
    {
        List<Staff> ListKH = new ArrayList<>();
        String query = "Select * from KHACHHANG where TongHD = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setInt(1, TongHD);
        ResultSet rs = ps.executeQuery();
        Staff kh = new Staff();
        while(rs.next()){
            kh.setMaNV(rs.getInt("MaKH"));
            kh.setName(rs.getString("HoTen"));
            kh.setAddress(rs.getString("DiaChi"));
            kh.setPhone(rs.getInt("SDT"));
            kh.setMaSoThue(rs.getInt("MaSoThue"));
            kh.setLuong(rs.getInt("TongHD")); 
            ListKH.add(kh);
        } 
        return ListKH;
    }
    
     
    
             //DS nhân viên
     public List<Staff> getListNV() throws SQLException{
        List<Staff> ListNV = new ArrayList<>();
        String query = "Select * from NHANVIEN ";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        Staff nv = null;
        while(rs.next()){
            nv = new Staff();
            nv.setMaNV(rs.getInt("MaNV"));
            nv.setName(rs.getString("HoTen"));
            nv.setNgaySinh(rs.getDate("NgaySinh"));
            nv.setGender(rs.getString("GioiTinh"));
            nv.setAddress(rs.getString("DiaChi"));
            nv.setPhone(rs.getInt("SDT"));
            nv.setNgayCong(rs.getFloat("NgayCong"));
            nv.setHeSoLuong(rs.getFloat("HeSoLuong"));
            nv.setLuong(rs.getInt("Luong"));
            ListNV.add(nv);
        }
        return ListNV;
    }
    
    
                      ////Tìm kiếm theo Mã nhân viên
     //Kiểm tra mã nhân viên lấy từ ô tìm kiếm
    public boolean Check_MaNV(int MaNV) throws SQLException{
            String query = "Select *  FROM NHANVIEN WHERE MANV =?;";
            PreparedStatement ps = this.conn.prepareStatement(query);
            ps.setInt(1, MaNV);
            ResultSet rs = ps.executeQuery();
            if(rs.next())return true;
            else return false;
    }
     
    
       //Lấy DS nhân viên theo mã nhân viên(Lấy từ ô tìm kiếm) 
     public List<Staff> getListNV_follow_MaNV(int MaNV) throws SQLException{
        List<Staff> ListNV_follow_MaNV = new ArrayList<>();
        String query = "Select * from NHANVIEN where MaNV = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setInt(1, MaNV);
        ResultSet rs = ps.executeQuery();
        Staff nv = null;
        while(rs.next()){
            nv = new Staff();
            nv.setMaNV(rs.getInt("MaNV"));
            nv.setName(rs.getString("HoTen"));
            nv.setNgaySinh(rs.getDate("NgaySinh"));
            nv.setGender(rs.getString("GioiTinh"));
            nv.setAddress(rs.getString("DiaChi"));
            nv.setPhone(rs.getInt("SDT"));
            nv.setNgayCong(rs.getFloat("NgayCong"));
            nv.setHeSoLuong(rs.getFloat("HeSoLuong"));
            nv.setLuong(rs.getInt("Luong"));
            ListNV_follow_MaNV.add(nv);
        }
        return ListNV_follow_MaNV;
    }
     
     
     
                    ////Tìm kiếm theo Tên nhân viên
     //Kiểm tra Tên nhân viên lấy từ ô tìm kiếm
    public boolean Check_TenNV(String TenNV) throws SQLException{
            String query = "Select *  FROM NHANVIEN WHERE HoTen =?;";
            PreparedStatement ps = this.conn.prepareStatement(query);
            ps.setString(1, TenNV);
            ResultSet rs = ps.executeQuery();
            if(rs.next())return true;
            else return false;
    }
     
    
       //Lấy DS nhân viên theo Tên nhân viên(Lấy từ ô tìm kiếm) 
     public List<Staff> getListNV_follow_TenNV(String TenNV) throws SQLException{
        List<Staff> ListNV_follow_TenNV = new ArrayList<>();
        String query = "Select * from NHANVIEN where HoTen = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString(1, TenNV);
        ResultSet rs = ps.executeQuery();
        Staff nv = null;
        while(rs.next()){
            nv = new Staff();
            nv.setMaNV(rs.getInt("MaNV"));
            nv.setName(rs.getString("HoTen"));
            nv.setNgaySinh(rs.getDate("NgaySinh"));
            nv.setGender(rs.getString("GioiTinh"));
            nv.setAddress(rs.getString("DiaChi"));
            nv.setPhone(rs.getInt("SDT"));
            nv.setNgayCong(rs.getFloat("NgayCong"));
            nv.setHeSoLuong(rs.getFloat("HeSoLuong"));
            nv.setLuong(rs.getInt("Luong"));
            ListNV_follow_TenNV.add(nv);
        }
        return ListNV_follow_TenNV;
    }
     
          
     
                ////Tìm kiếm theo SĐT nhân viên
     //Kiểm tra SĐT nhân viên lấy từ ô tìm kiếm
    public boolean Check_SĐT(int SĐT) throws SQLException{
            String query = "Select *  FROM NHANVIEN WHERE SĐT =?;";
            PreparedStatement ps = this.conn.prepareStatement(query);
            ps.setInt(1, SĐT);
            ResultSet rs = ps.executeQuery();
            if(rs.next())return true;
            else return false;
    }
     
    
       //Lấy DS nhân viên theo SĐT nhân viên(Lấy từ ô tìm kiếm) 
     public List<Staff> getListNV_follow_SDT(int SĐT) throws SQLException{
        List<Staff> ListNV_follow_SDT = new ArrayList<>();
        String query = "Select * from NHANVIEN where SĐT = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setInt(1, SĐT);
        ResultSet rs = ps.executeQuery();
        Staff nv = null;
        while(rs.next()){
            nv = new Staff();
            nv.setMaNV(rs.getInt("MaNV"));
            nv.setName(rs.getString("HoTen"));
            nv.setNgaySinh(rs.getDate("NgaySinh"));
            nv.setGender(rs.getString("GioiTinh"));
            nv.setAddress(rs.getString("DiaChi"));
            nv.setPhone(rs.getInt("SDT"));
            nv.setNgayCong(rs.getFloat("NgayCong"));
            nv.setHeSoLuong(rs.getFloat("HeSoLuong"));
            nv.setLuong(rs.getInt("Luong"));
            ListNV_follow_SDT.add(nv);
        }
        return ListNV_follow_SDT;
    }
     
     
     
        //Xóa nhân viên theo chỉ số của hàng (tính từ 0)
     public boolean deleteNV_follow_MaNV (int MaNV) throws SQLException{
            String query =  "DELETE FROM NHANVIEN WHERE MaNV =?";
            PreparedStatement ps = this.conn.prepareStatement(query);
            ps.setInt(1, MaNV);
            ps.execute();
            return true;
    }
}

