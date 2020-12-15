package View;

import Controller.BillManager;
import Model.Bill;
import Model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HoaDon extends javax.swing.JFrame {
    public HoaDon() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);   
        try {           
            BillManager bm = new BillManager();            
            this.listHD = bm.getListHD_follow_MaMH();
            Model model = new Model();
            this.tb_Bill.setModel(model);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
    List<Bill> listHD = new ArrayList<>();
    
    private class Model extends DefaultTableModel{

        @Override
        public Object getValueAt(int row, int column) {
            switch (column){
                case 0:
                    return listHD.get(row).getSttHD();
                case 1:
                    return listHD.get(row).getMaMH();
                case 2:
                    return listHD.get(row).getTenMH();
                case 3:
                    return listHD.get(row).getSoLuongMua();
                case 4:
                    return listHD.get(row).getDonGia();
                case 5:
                    return listHD.get(row).getThanhTien();
            }
            return null;
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false; 
        }

        @Override
        public String getColumnName(int column) {
            switch (column){
                case 0:
                    return "STT";
                case 1:
                    return "Mã mặt hàng";    
                case 2:
                    return "Tên mặt hàng";
                case 3: 
                    return "Số lượng mua";
                case 4:
                    return "Đơn giá";
                case 5:
                    return "Thành tiền";
            }
            return null; 
        }

        @Override
        public int getColumnCount() {
            return 6;
        }

        @Override
        public int getRowCount() {
            return listHD.size();
        }
        
    }

    @SuppressWarnings("unchecked")                      
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Bill = new javax.swing.JTable();
        btn_OutHD = new javax.swing.JButton();
        jl_Bill = new javax.swing.JLabel();
        btn_PrintHD = new javax.swing.JButton();
        btn_DeleteHD = new javax.swing.JButton();
        jl_InfoHD = new javax.swing.JLabel();
        jl_InfoKH = new javax.swing.JLabel();
        jl_NameKH = new javax.swing.JLabel();
        tf_NameKH = new javax.swing.JTextField();
        jl_PhoneKH = new javax.swing.JLabel();
        tf_PhoneKH = new javax.swing.JTextField();
        jl_CodeKH = new javax.swing.JLabel();
        jl_AddressKH = new javax.swing.JLabel();
        tf_CodeKH = new javax.swing.JTextField();
        tf_AddressKH = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tb_Bill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tb_Bill);

        btn_OutHD.setText("Quay lại");
        btn_OutHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_OutHDActionPerformed(evt);
            }
        });

        jl_Bill.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jl_Bill.setText("HÓA ĐƠN");

        btn_PrintHD.setText("In hóa đơn");
        btn_PrintHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PrintHDActionPerformed(evt);
            }
        });

        btn_DeleteHD.setText("Xóa");
        btn_DeleteHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteHDActionPerformed(evt);
            }
        });

        jl_InfoHD.setFont(new java.awt.Font("Tahoma", 3, 12)); 
        jl_InfoHD.setText("Thông tin hóa đơn");

        jl_InfoKH.setFont(new java.awt.Font("Tahoma", 3, 12));
        jl_InfoKH.setText("Thông tin khách hàng");

        jl_NameKH.setText("Họ tên");

        jl_PhoneKH.setText("Số điện thoại");

        jl_CodeKH.setText("Mã số thuế");

        jl_AddressKH.setText("Địa chỉ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(btn_PrintHD)
                        .addGap(101, 101, 101)
                        .addComponent(btn_DeleteHD)
                        .addGap(95, 95, 95)
                        .addComponent(btn_OutHD))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jl_InfoHD))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jl_InfoKH)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jl_PhoneKH)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jl_NameKH)
                                        .addGap(42, 42, 42)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_NameKH, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                    .addComponent(tf_PhoneKH))
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_CodeKH)
                                    .addComponent(jl_AddressKH))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_CodeKH, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(tf_AddressKH, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(jl_Bill)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jl_Bill)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jl_InfoKH)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_NameKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_CodeKH)
                    .addComponent(tf_CodeKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_NameKH))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_PhoneKH)
                    .addComponent(tf_PhoneKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_AddressKH)
                    .addComponent(tf_AddressKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jl_InfoHD)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_DeleteHD)
                    .addComponent(btn_PrintHD)
                    .addComponent(btn_OutHD))
                .addGap(24, 24, 24))
        );

        pack();
    }                 

    private void btn_OutHDActionPerformed(java.awt.event.ActionEvent evt) {                                          
        this.setVisible(false);
    }                                         

    private void btn_PrintHDActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }  
    
    
     //Xóa hóa đơn
    private void btn_DeleteHDActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try {
            BillManager bm = new BillManager(); 
            Model model = new Model();
            int row = -1;
            row = tb_Bill.getSelectedRow();              //Lấy hàng được click
            if (row != -1) 
            {
                int Stt = (int) tb_Bill.getValueAt(row, 0);  //Lấy giá trị của phần tử hàng được chọn, cột 0
                bm.deleteBill(Stt);                          //Xóa hàng được chọn theo SttHD
                JOptionPane.showMessageDialog(null, "Xóa thành công!");
            } 
            else JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng hóa đơn cần xóa!");
            this.listHD = bm.getListHD_follow_MaMH();         //Cập nhật lại database hóa đơn sau khi xóa 
            this.tb_Bill.setModel(model);                     //Cập nhật hóa đơn lên bảng
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }                                            
                   
    private javax.swing.JButton btn_DeleteHD;
    private javax.swing.JButton btn_OutHD;
    private javax.swing.JButton btn_PrintHD;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jl_AddressKH;
    private javax.swing.JLabel jl_Bill;
    private javax.swing.JLabel jl_CodeKH;
    private javax.swing.JLabel jl_InfoHD;
    private javax.swing.JLabel jl_InfoKH;
    private javax.swing.JLabel jl_NameKH;
    private javax.swing.JLabel jl_PhoneKH;
    private javax.swing.JTable tb_Bill;
    private javax.swing.JTextField tf_AddressKH;
    private javax.swing.JTextField tf_CodeKH;
    private javax.swing.JTextField tf_NameKH;
    private javax.swing.JTextField tf_PhoneKH;              
}
