/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DBConnector;
import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author huutr
 */
public class ProductManager {
    Connection conn;
    public ProductManager() throws SQLException, ClassNotFoundException, Exception{
        DBConnector db = new DBConnector();
        this.conn = db.getConnect();
    }
    
    public Product getDetail(String maMH) throws SQLException{
        String query = "Select * from MATHANG mh where mh.mamh = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString(1, maMH);
        ResultSet rs = ps.executeQuery();
        Product mh = null; 
        while (rs.next()){
            mh = new Product(rs.getInt("SttMH") ,maMH, rs.getString("TenMH"), rs.getString("hangSX"), rs.getInt("SoLuong"), rs.getInt("DonGia"),rs.getString("LoaiMH"));
        }
        return mh;
    }
    
    public boolean checkProduct(String maMH) throws SQLException{
        String query = "Select * from MATHANG  where mamh = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString(1, maMH);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            return true;
        }
        return false;
    }
    
    public void addProduct(String MaMH, String TenMH, String LoaiMH, String HangSx, int SoLuong, int DonGia) throws SQLException{
        String query2 = "insert MATHANG values(?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = this.conn.prepareStatement(query2);
        ps.setString(1, MaMH);
        ps.setString(2, TenMH);
        ps.setString(3, LoaiMH);
        ps.setString(4, HangSx);
        ps.setInt(5, SoLuong);
        ps.setInt(6, DonGia);
        ps.execute();
        }
   
    public boolean deleteProduct(String maMH) throws SQLException{
            String query =  "DELETE FROM HOADON WHERE MAMH =? DELETE FROM MATHANG WHERE MAMH =?";
            PreparedStatement ps = this.conn.prepareStatement(query);
            ps.setString(1, maMH);
            ps.setString(2, maMH);
            ps.execute();
            return true;
    }
    
    public List<Product> getListMH() throws SQLException{
        List<Product> listMH = new ArrayList<>();
        String query = "Select * from MATHANG order by SttMH\n";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        Product mh = null;
        while(rs.next()){
            mh = new Product();
            mh.setSttMH((rs.getInt("SttMH")));
            mh.setMaMH((rs.getString("MaMH")));
            mh.setTenMH(rs.getString("TenMH"));
            mh.setLoaiMH(rs.getString("LoaiMH"));
            mh.setHangSX(rs.getString("HangSX"));
            mh.setSoLuong(rs.getInt("SoLuong"));
            mh.setDonGia(rs.getInt("DonGia"));
            listMH.add(mh);
        }
        return listMH;
    }
    
    public String getMaMH(String tenMH) throws SQLException{
        String query = "Select * from MATHANG where tenmh = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString(1, tenMH);
        ResultSet rs = ps.executeQuery();
        String maMH = "";
        if (rs.next()){
            maMH = rs.getString("MaMH");
        }
        return maMH;
    }
}
