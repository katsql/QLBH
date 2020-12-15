/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author huutr
 */
public class Product {
    private String MaMH;
    private String tenMH;
    private String hangSX;
    private int SoLuong;
    private int DonGia;
    private String loaiMH;
    private int SttMH;

    public int getSttMH() {
        return SttMH;
    }

    public void setSttMH(int SttMH) {
        this.SttMH = SttMH;
    }
    
    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public Product(){
        
    }
    public Product(int SttMH, String MaMH, String tenMH, String hangSX, int soLuong, int DonGia, String loaiMH) {
        this.SttMH = SttMH;
        this.MaMH = MaMH;
        this.tenMH = tenMH;
        this.hangSX = hangSX;
        this.SoLuong = soLuong;
        this.DonGia = DonGia;
        this.loaiMH = loaiMH;
    }

    public String getLoaiMH() {
        return loaiMH;
    }

    public void setLoaiMH(String loaiMH) {
        this.loaiMH = loaiMH;
    }

    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String MaMH) {
        this.MaMH = MaMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public String getHangSX() {
        return hangSX;
    }

    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }
    
}

