package Controller;

import Model.DBConnector;
import Model.Bill;
import Model.Cart;
import Model.Product;
import java.sql.Statement;
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
public class BillManager {
    Connection conn;
    public BillManager() throws SQLException, ClassNotFoundException, Exception{
        DBConnector db = new DBConnector();
        this.conn = db.getConnect();
    }
    
    public Bill getDetail(int maHD) throws SQLException{
        String query = "Select * from HOADON hd where hd.mahd = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setInt(1, maHD);
        ResultSet rs = ps.executeQuery();
        Bill hd = null; 
        while (rs.next()){
            hd = new Bill(maHD, rs.getString("MaMH"), rs.getInt("SoLuongMua"), rs.getInt("ThanhTien"));
        }
        return hd;
    }
    
    public void addCart(String TenMHGH, int DonGiaGH, int SoLuongMua, int ThanhTien) throws SQLException{
        String query2 = "insert into GIOHANG(TenMHGH, DonGiaGH, SoLuongMua, ThanhTien) values(?, ?, ?, ?)";
        PreparedStatement ps2 = this.conn.prepareStatement(query2);
        ps2.setString(1, TenMHGH);
        ps2.setInt(2, DonGiaGH);
        ps2.setInt(3, SoLuongMua);
        ps2.setInt(4, ThanhTien);
        ps2.execute();
}
    
    public List<Cart> getListGH_follow_TenMH() throws SQLException{
        List<Cart> ListGH_follow_TenMH = new ArrayList<>();
        String query = "Select * from GIOHANG gh, MATHANG mh where gh.TenMHGH=mh.TenMH";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        Cart gh = null;
        while(rs.next()){
            gh = new Cart();
            gh.setStt(rs.getInt("Stt"));
            gh.setTenMHGH(rs.getString("TenMHGH"));
            gh.setDonGiaGH(rs.getInt("DonGiaGH"));
            gh.setSoLuongMua(rs.getInt("SoLuongMua"));
            gh.setThanhTien(rs.getInt("ThanhTien"));
            
            ListGH_follow_TenMH.add(gh);
        }
        return ListGH_follow_TenMH;
        
        
    }

    
    public int TongHD() throws SQLException{
        String query = "Select hd.mahd, hd.makh, hd.manvban, sum(ThanhTien) 'TongTien'\n" +
                        "from HOADON hd\n" +
                        "group by hd.mahd, hd.makh, hd.manvban";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        int tongHD = rs.getInt("TongTien");
        return tongHD;
    }
    
    public int getDonGia(String tenMH) throws SQLException{
        String query = "Select DonGia from MATHANG where tenmh = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString(1, tenMH);
        ResultSet rs = ps.executeQuery();
        int donGia = 0;
        if(rs.next()){
            donGia = rs.getInt("DonGia");            
        }
        return donGia;
    }
    
    public String getTenNV(int maNV) throws SQLException{
        String query = "Select HoTen from NHANVIEN nv where nv.manv = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setInt(1, maNV);
        ResultSet rs = ps.executeQuery();
        String tenNV = null;
        if(rs.next()){
            tenNV = rs.getString("TenNV");            
        }
        return tenNV;
    }
    
    public String getTenKH(int maKH) throws SQLException{
        String query = "Select HoTen from KHACHHANG kh where kh.makh = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setInt(1, maKH);
        ResultSet rs = ps.executeQuery();
        String tenKH = null;
        if(rs.next()){
            tenKH = rs.getString("HoTen");            
        }
        return tenKH;
    }
    
    public boolean deleteBill (int MaHD) throws SQLException{
            String query =  "DELETE FROM HOADON WHERE MaHD =?";
            PreparedStatement ps = this.conn.prepareStatement(query);
            ps.setInt(1, MaHD);
            ps.execute();
            return true;
    }
    
    public String getMaMH(String tenMH) throws SQLException{
        String query = "Select MaMH from MATHANG  where TenMH = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString(1, tenMH);
        ResultSet rs = ps.executeQuery();
        String maMH = "";
        if(rs.next()){
            maMH = rs.getString("MaMH");            
        }      
        return maMH;
    }
    
    
// Đưa ra ds tất cả mặt hàng   
    public List<Product> getListAllMH() throws SQLException{
        List<Product> ListAllMH = new ArrayList<>();
        String query = "Select TenMH from MATHANG mh group by TenMH";
        Statement st = this.conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        Product mh = null;
        while(rs.next()){
            mh = new Product();
            mh.setTenMH(rs.getString("TenMH"));
            ListAllMH.add(mh);
        }
        return ListAllMH;
    }
    
// Đưa ra ds tất cả hãng sản xuất   
    public List<Product> getListAllHangSX() throws SQLException{
        List<Product> ListAllHangSX = new ArrayList<>();
        String query = "Select HangSX from MATHANG mh group by HangSX";
        Statement st = this.conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        Product mh = null;
        while(rs.next()){
            mh = new Product();
            mh.setHangSX(rs.getString("HangSX"));
            ListAllHangSX.add(mh);
        }
        return ListAllHangSX;
    }

 // Đưa ra ds tất cả loại mặt hàng   
    public List<Product> getListAllLoaiMH() throws SQLException{
        List<Product> ListAllLoaiMH = new ArrayList<>();
        String query = "Select LoaiMH from MATHANG mh group by LoaiMH";
        Statement st = this.conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        Product mh = null;
        while(rs.next()){
            mh = new Product();
            mh.setLoaiMH(rs.getString("LoaiMH"));
            ListAllLoaiMH.add(mh);
        }
        return ListAllLoaiMH;
    }
    
   
                      ////// Đưa ra DS Tên Mặt Hàng
           ////theo Hãng Sản Xuất
    public List<Product> getListTenMH_follow_HangSX(String HangSX) throws SQLException{
        List<Product> ListTenMH_follow_HangSX = new ArrayList<>();
        String query = "Select distinct TenMH from MATHANG mh where HangSX = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString(1, HangSX);
        ResultSet rs = ps.executeQuery();
        Product mh = null;
        while(rs.next()){
            mh = new Product();
            mh.setTenMH(rs.getString("TenMH"));
            ListTenMH_follow_HangSX.add(mh);
        }
        return ListTenMH_follow_HangSX;
    }
    
          //// theo Loại Mặt Hàng
    public List<Product> getListTenMH_follow_LoaiMH(String LoaiMH) throws SQLException{
        List<Product> ListTenMH_follow_LoaiMH = new ArrayList<>();
        String query = "Select distinct TenMH from MATHANG mh where LoaiMH = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString(1, LoaiMH);
        ResultSet rs = ps.executeQuery();
        Product mh = null;
        while(rs.next()){
            mh = new Product();
            mh.setTenMH(rs.getString("TenMH"));
            ListTenMH_follow_LoaiMH.add(mh);
        }
        return ListTenMH_follow_LoaiMH;
    }
    
         //// theo Loại Mặt Hàng và Hãng Sản Xuất
    public List<Product> getListTenMH_follow_LoaiMH_and_HangSX(String LoaiMH, String HangSX) throws SQLException{
        List<Product> TenMH_follow_LoaiMH_and_HangSX = new ArrayList<>();
        String query = "Select distinct TenMH from MATHANG mh where LoaiMH = ? and HangSX = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString(1, LoaiMH);
        ps.setString(2, HangSX);
        ResultSet rs = ps.executeQuery();
        Product mh = null;
        while(rs.next()){
            mh = new Product();
            mh.setTenMH(rs.getString("TenMH"));
            TenMH_follow_LoaiMH_and_HangSX.add(mh);
        }
        return TenMH_follow_LoaiMH_and_HangSX;
    }
    
        
    
    
    
                            ////// Đưa ra DS Loại Mặt Hàng
        //// theo Hãng Sản Xuất
    public List<Product> getListLoaiMH_follow_HangSX(String HangSX) throws SQLException{
        List<Product> ListLoaiMH_follow_HangSX = new ArrayList<>();
        String query = "Select distinct LoaiMH from MATHANG mh where HangSX = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString(1, HangSX);
        ResultSet rs = ps.executeQuery();
        Product mh = null;
        while(rs.next()){
            mh = new Product();
            mh.setLoaiMH(rs.getString("LoaiMH"));
            ListLoaiMH_follow_HangSX.add(mh);
        }
        return ListLoaiMH_follow_HangSX;
    }
    
         //// theo Tên Mặt Hàng
    public List<Product> getListLoaiMH_follow_TenMH(String TenMH) throws SQLException{
        List<Product> ListLoaiMH_follow_TenMH = new ArrayList<>();
        String query = "Select distinct LoaiMH from MATHANG mh where TenMH = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString(1, TenMH);
        ResultSet rs = ps.executeQuery();
        Product mh = null;
        while(rs.next()){
            mh = new Product();
            mh.setLoaiMH(rs.getString("LoaiMH"));
            ListLoaiMH_follow_TenMH.add(mh);
        }
        return ListLoaiMH_follow_TenMH;
    }
    
         //// theo Hãng Sản Xuất và Tên Mặt Hàng
    public List<Product> getListLoaiMH_follow_HangSX_and_TenMH(String HangSX, String TenMH) throws SQLException{
        List<Product> ListLoaiMH_follow_HangSX_and_TenMH = new ArrayList<>();
        String query = "Select distinct LoaiMH from MATHANG mh where HangSX = ? and TenMH = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString(1, HangSX);
        ps.setString(2, TenMH);
        ResultSet rs = ps.executeQuery();
        Product mh = null;
        while(rs.next()){
            mh = new Product();
            mh.setLoaiMH(rs.getString("LoaiMH"));
            ListLoaiMH_follow_HangSX_and_TenMH.add(mh);
        }
        return ListLoaiMH_follow_HangSX_and_TenMH;
    }
    
 
    
      
    
                               ////// Đưa ra DS Hãng Sản Xuất
        //// theo Loại Mặt Hàng
    public List<Product> getListHangSX_follow_LoaiMH(String LoaiMH) throws SQLException{
        List<Product> ListHangSX_follow_LoaiMH = new ArrayList<>();
        String query = "Select distinct HangSX from MATHANG mh where LoaiMH = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString(1, LoaiMH);
        ResultSet rs = ps.executeQuery();
        Product mh = null;
        while(rs.next()){
            mh = new Product();
            mh.setHangSX(rs.getString("HangSX"));
            ListHangSX_follow_LoaiMH.add(mh);
        }
        return ListHangSX_follow_LoaiMH;
    }
      
      ///// theo Tên Mặt Hàng   
    public List<Product> getListHangSX_follow_TenMH(String TenMH) throws SQLException{
        List<Product> ListHangSX_follow_TenMH = new ArrayList<>();
        String query = "Select distinct HangSX from MATHANG mh where TenMH = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString(1, TenMH);
        ResultSet rs = ps.executeQuery();
        Product mh = null;
        while(rs.next()){
            mh = new Product();
            mh.setHangSX(rs.getString("HangSX"));
            ListHangSX_follow_TenMH.add(mh);
        }
        return ListHangSX_follow_TenMH;
    }
    
      //// theo Loại Mặt Hàng và Tên Mặt Hàng
    public List<Product> getListHangSX_follow_LoaiMH_and_TenMH(String LoaiMH, String TenMH) throws SQLException{
        List<Product> ListHangSX_follow_LoaiMH_and_TenMH = new ArrayList<>();
        String query = "Select distinct HangSX from MATHANG mh where LoaiMH = ? and TenMH = ?";
        PreparedStatement ps = this.conn.prepareStatement(query);
        ps.setString(1, LoaiMH);
        ps.setString(2, TenMH);
        ResultSet rs = ps.executeQuery();
        Product mh = null;
        while(rs.next()){
            mh = new Product();
            mh.setHangSX(rs.getString("HangSX"));
            ListHangSX_follow_LoaiMH_and_TenMH.add(mh);
        }
        return ListHangSX_follow_LoaiMH_and_TenMH;
    }
}