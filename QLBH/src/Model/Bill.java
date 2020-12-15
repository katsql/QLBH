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
public class Bill extends Product{
    private int SttHD;
    private String MaMH;
    private int SoLuongMua;
    private int ThanhTien;
    private String NgayTao;
    
    
    public Bill(){
        
    }
    public Bill(int SttHD, String MaMH, int SoLuongMua, int ThanhTien) {
        this.SttHD = SttHD;
        this.MaMH = MaMH;
        this.SoLuongMua = SoLuongMua;
        this.ThanhTien = ThanhTien;
    }
    
    
    
     public int getSttHD() {
        return SttHD;
    }

    public void setSttHD(int SttHD) {
        this.SttHD = SttHD;
    }
    
    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String MaMH) {
        this.MaMH = MaMH;
    } 
    
    public int getSoLuongMua() {
        return SoLuongMua;
    }

    public void setSoLuongMua(int SoLuongMua) {
        this.SoLuongMua = SoLuongMua;
    }    

    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(int ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }
}

