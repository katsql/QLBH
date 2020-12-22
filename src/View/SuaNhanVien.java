package View;
import Controller.StaffManager;
import Model.Staff;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class SuaNhanVien extends javax.swing.JFrame {
    public SuaNhanVien() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }


    @SuppressWarnings("unchecked")                     
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jl_ChangeNV = new javax.swing.JLabel();
        jl_IDNV = new javax.swing.JLabel();
        jl_Gender = new javax.swing.JLabel();
        jl_NameNV = new javax.swing.JLabel();
        jl_AddressNV = new javax.swing.JLabel();
        jl_PhoneNV = new javax.swing.JLabel();
        jl_DateofbirthNV = new javax.swing.JLabel();
        jl_CoefficientsNV = new javax.swing.JLabel();
        jl_Workdays = new javax.swing.JLabel();
        btn_UpdateNV = new javax.swing.JButton();
        btn_BackUpdateNV = new javax.swing.JButton();
        tf_IDNV = new javax.swing.JTextField();
        btn_ShowInfoNV = new javax.swing.JButton();
        RbtnNam = new javax.swing.JRadioButton();
        RbtnNu = new javax.swing.JRadioButton();
        tf_NameNV = new javax.swing.JTextField();
        tf_AddressNV = new javax.swing.JTextField();
        tf_Workday = new javax.swing.JTextField();
        tf_DateofbirthNV = new javax.swing.JTextField();
        tf_PhoneNV = new javax.swing.JTextField();
        tf_CoefficientsNV = new javax.swing.JTextField();
        jl_Salary = new javax.swing.JLabel();
        lbLuong = new javax.swing.JLabel();
        btn_Salary = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jl_ChangeNV.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jl_ChangeNV.setText("THAY ĐỔI THÔNG TIN NHÂN VIÊN");

        jl_IDNV.setText("Mã nhân viên");

        jl_Gender.setText("Giới tính:");

        jl_NameNV.setText("Họ tên:");

        jl_AddressNV.setText("Địa chỉ:");

        jl_PhoneNV.setText("Số điện thoại:");

        jl_DateofbirthNV.setText("Ngày sinh:");

        jl_CoefficientsNV.setText("Hệ số lương:");

        jl_Workdays.setText("Ngày công:");

        btn_UpdateNV.setText("Cập nhật");
        btn_UpdateNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateNVActionPerformed(evt);
            }
        });

        btn_BackUpdateNV.setText("Quay lại");
        btn_BackUpdateNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BackUpdateNVActionPerformed(evt);
            }
        });

        btn_ShowInfoNV.setText("Hiển thị");
        btn_ShowInfoNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ShowInfoNVActionPerformed(evt);
            }
        });

        buttonGroup1.add(RbtnNam);
        RbtnNam.setText("Nam");

        buttonGroup1.add(RbtnNu);
        RbtnNu.setText("Nữ");


        jl_Salary.setText("Lương:");

        btn_Salary.setText("Tính lương");
        btn_Salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalaryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_PhoneNV)
                                    .addComponent(jl_AddressNV))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_AddressNV, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(tf_PhoneNV)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_DateofbirthNV)
                                    .addComponent(jl_NameNV))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_DateofbirthNV, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_NameNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(btn_Salary)
                                .addGap(91, 91, 91)
                                .addComponent(btn_UpdateNV, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btn_BackUpdateNV, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(25, 25, 25))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jl_Gender)
                                    .addGap(22, 22, 22)
                                    .addComponent(RbtnNam)
                                    .addGap(3, 3, 3)
                                    .addComponent(RbtnNu)
                                    .addGap(14, 14, 14)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jl_CoefficientsNV, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tf_CoefficientsNV, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jl_Workdays, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tf_Workday, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jl_Salary)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(357, 357, 357)
                                .addComponent(lbLuong))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_IDNV)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_IDNV, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_ShowInfoNV, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jl_ChangeNV)
                .addGap(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jl_ChangeNV, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_IDNV, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_IDNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ShowInfoNV))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_NameNV)
                    .addComponent(tf_NameNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_Gender)
                    .addComponent(RbtnNam)
                    .addComponent(RbtnNu))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_DateofbirthNV)
                    .addComponent(tf_DateofbirthNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_CoefficientsNV)
                    .addComponent(tf_CoefficientsNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_AddressNV, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_AddressNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_Workdays)
                    .addComponent(tf_Workday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_PhoneNV)
                    .addComponent(tf_PhoneNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_Salary))
                .addGap(18, 18, 18)
                .addComponent(lbLuong)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_UpdateNV)
                    .addComponent(btn_BackUpdateNV)
                    .addComponent(btn_Salary))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }               

    private void btn_BackUpdateNVActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        this.setVisible(false);
    }                                                
    
    private void btn_UpdateNVActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try {           
            String maNV = tf_IDNV.getText();
            String hoTen = tf_NameNV.getText();
            String ngaySinh = tf_DateofbirthNV.getText();
            String diaChi = tf_AddressNV.getText();
            String phone = tf_PhoneNV.getText();
            String ngayCong = tf_Workday.getText();
            String heSoLuong = tf_CoefficientsNV.getText();    
            String luong = lbLuong.getText();
            Date ngaySinh1 = new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinh);
            if (maNV.equals("") || hoTen.equals("") || ngaySinh.equals("") || diaChi.equals("") ||
                    (!RbtnNam.isSelected() && !RbtnNu.isSelected()) || phone.equals("") || ngayCong.equals("") || heSoLuong.equals("") ){
                JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
            }
            else {
                try {

                    int check;
                    StaffManager sm = new StaffManager();
                    check = (sm.updateStaff((Integer.parseInt(maNV)), hoTen, ngaySinh1, diaChi, RbtnNam.isSelected()?true:false, phone, Integer.parseInt(ngayCong), Float.parseFloat(heSoLuong), Integer.parseInt(luong)))?1:0;
                    switch (check){
                        case 0:
                            JOptionPane.showMessageDialog(null, "Không tìm thấy mã nhân viên");
                            break;
                        case 1:
                            sm.updateStaff(Integer.parseInt(maNV), hoTen, ngaySinh1, diaChi, RbtnNam.isSelected()?true:false, phone, Integer.parseInt(ngayCong), Float.parseFloat(heSoLuong), Integer.parseInt(luong));
                            JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
                            tf_IDNV.setText("");
                            tf_NameNV.setText("");
                            tf_DateofbirthNV.setText("");
                            tf_AddressNV.setText("");
                            tf_PhoneNV.setText("");
                            tf_Workday.setText("");
                            tf_CoefficientsNV.setText("");
                            lbLuong.setText("");
                            buttonGroup1.clearSelection(); 
                            break;
                    }
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SuaNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(SuaNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        } catch (ParseException ex) {
            Logger.getLogger(SuaNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }                                            
    private int maNV;    
    private int load(int manv){
        manv = Integer.parseInt(tf_IDNV.getText());
        return manv;
    }
    
    private void loadDetail(int manv){
        manv = Integer.parseInt(tf_IDNV.getText());
        this.maNV = manv;
        try {
            StaffManager sm = new StaffManager();
            Staff nv = sm.getDetail(manv);
            tf_NameNV.setText(nv.getName());
            SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
            String stringDate= DateFor.format(nv.getNgaySinh());
            tf_DateofbirthNV.setText(stringDate);
            tf_AddressNV.setText(nv.getAddress());
            tf_PhoneNV.setText(Integer.toString(nv.getPhone()));
            tf_Workday.setText(Float.toString(nv.getNgayCong()));
            tf_CoefficientsNV.setText(Float.toString(nv.getHeSoLuong()));
            lbLuong.setText(Float.toString(nv.getLuong()));
            String gt;           
            gt = (sm.checkSexStaff(manv))?"Nam":"Nữ";
            System.out.print("Nam".equals(gt));
            if("Nam".equals(gt)){
                RbtnNam.setSelected(true);
            }
            else{
                RbtnNu.setSelected(true);
            }
            
 //           System.out.print("Nam".equals(nv.isGender()));
 //           System.out.print(nv.isGender());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SuaNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SuaNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void btn_ShowInfoNVActionPerformed(java.awt.event.ActionEvent evt) {                                               
        String maNv = tf_IDNV.getText();
        if (maNv.equals("")){
            JOptionPane.showMessageDialog(null, "Chưa nhập mã nhân viên");
        }
        else{
            try {
                StaffManager sm = new StaffManager();
                int manv = 0;
                this.maNV = load(manv);
                int check;
                check = (sm.checkStaff(this.maNV))?1:0;
                switch (check){
                    case 0:
                        JOptionPane.showMessageDialog(null, "Mã nhân viên không tồn tại");
                        break;
                    case 1:
                        loadDetail(this.maNV);
                        break;
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SuaNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(SuaNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }                                                                                     

    private void btn_SalaryActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String ngayCong = tf_Workday.getText();
        String heSoLuong = tf_CoefficientsNV.getText(); 
        if (ngayCong.equals("") || heSoLuong.equals("")){
            JOptionPane.showMessageDialog(null, "Chưa nhập Ngày công hoặc Hệ số lương");
        }
        else{
            float Luong = Integer.parseInt(ngayCong)*Float.parseFloat(heSoLuong)*200000;
            int luong = (int)Luong;
            lbLuong.setText(Integer.toString(luong));
        }       
    }                                          
               
    private javax.swing.JRadioButton RbtnNam;
    private javax.swing.JRadioButton RbtnNu;
    private javax.swing.JButton btn_BackUpdateNV;
    private javax.swing.JButton btn_Salary;
    private javax.swing.JButton btn_ShowInfoNV;
    private javax.swing.JButton btn_UpdateNV;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jl_AddressNV;
    private javax.swing.JLabel jl_ChangeNV;
    private javax.swing.JLabel jl_CoefficientsNV;
    private javax.swing.JLabel jl_DateofbirthNV;
    private javax.swing.JLabel jl_Gender;
    private javax.swing.JLabel jl_IDNV;
    private javax.swing.JLabel jl_NameNV;
    private javax.swing.JLabel jl_PhoneNV;
    private javax.swing.JLabel jl_Salary;
    private javax.swing.JLabel jl_Workdays;
    private javax.swing.JLabel lbLuong;
    private javax.swing.JTextField tf_AddressNV;
    private javax.swing.JTextField tf_CoefficientsNV;
    private javax.swing.JTextField tf_DateofbirthNV;
    private javax.swing.JTextField tf_IDNV;
    private javax.swing.JTextField tf_NameNV;
    private javax.swing.JTextField tf_PhoneNV;
    private javax.swing.JTextField tf_Workday;               
}








