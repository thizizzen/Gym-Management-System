package gym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */


class BaseForm extends javax.swing.JFrame {
    Connection con;
    PreparedStatement pst;
    DefaultTableModel df;
    
}

public class Tracking extends BaseForm {
    /**
     * Creates new form Tracking
     */
     public Tracking() {
        initComponents();
        Connect();
        table_load1();
        table_load2();
        table_load3();
    }
    
    Connection con;
    PreparedStatement pst;
    DefaultTableModel df;
    
    public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/gymregistration", "root", "");
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Tracking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   public void table_load1() {
    try {
        pst = con.prepareStatement("SELECT a.fname, a.date FROM attendance a JOIN member m ON a.fname = m.fname WHERE m.subs = 'weekly'");
        ResultSet rs = pst.executeQuery();

        ResultSetMetaData rd = rs.getMetaData();
        int c;
        c = rd.getColumnCount();
        df = (DefaultTableModel) tblweekly.getModel();
        df.setRowCount(0);
        while (rs.next()) {
            Vector v2 = new Vector();

            for (int i = 1; i <= c; i++) {
                v2.add(rs.getString("fname"));
                v2.add(rs.getString("date"));
            }

            df.addRow(v2);
        }

    } catch (SQLException ex) {
        Logger.getLogger(Tracking.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
          public void table_load2()
    {
            try {
                pst = con.prepareStatement("SELECT a.fname, a.date FROM attendance a JOIN member m ON a.fname = m.fname WHERE m.subs = 'monthly'");
        ResultSet rs = pst.executeQuery();

        ResultSetMetaData rd = rs.getMetaData();
        int c;
        c = rd.getColumnCount();
        df = (DefaultTableModel) tblmonthly.getModel();
        df.setRowCount(0);
        while (rs.next()) {
            Vector v2 = new Vector();

            for (int i = 1; i <= c; i++) {
                v2.add(rs.getString("fname"));
                v2.add(rs.getString("date"));
                }
                
                df.addRow(v2);
            }
            
            } catch (SQLException ex) {
                Logger.getLogger(Tracking.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
         
         public void table_load3()
    {
            try {
                pst = con.prepareStatement("SELECT a.fname, a.date FROM attendance a JOIN member m ON a.fname = m.fname WHERE m.subs = 'yearly'");
        ResultSet rs = pst.executeQuery();

        ResultSetMetaData rd = rs.getMetaData();
        int c;
        c = rd.getColumnCount();
        df = (DefaultTableModel) tblyearly.getModel();
        df.setRowCount(0);
        while (rs.next()) {
            Vector v2 = new Vector();

            for (int i = 1; i <= c; i++) {
                v2.add(rs.getString("fname"));
                v2.add(rs.getString("date"));
                }
                
                df.addRow(v2);
            }
            
            } catch (SQLException ex) {
                Logger.getLogger(Tracking.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmonthly = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblweekly = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblyearly = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51,80));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblmonthly.setBackground(new java.awt.Color(51, 51, 51));
        tblmonthly.setForeground(new java.awt.Color(255, 255, 255));
        tblmonthly.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date"
            }
        ));
        jScrollPane1.setViewportView(tblmonthly);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Weekly");

        tblweekly.setBackground(new java.awt.Color(51, 51, 51));
        tblweekly.setForeground(new java.awt.Color(255, 255, 255));
        tblweekly.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date"
            }
        ));
        jScrollPane2.setViewportView(tblweekly);

        tblyearly.setBackground(new java.awt.Color(51, 51, 51));
        tblyearly.setForeground(new java.awt.Color(255, 255, 255));
        tblyearly.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date"
            }
        ));
        jScrollPane3.setViewportView(tblyearly);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Monthly");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Yearly");

        jButton1.setBackground(new java.awt.Color(51, 51, 51,80));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(255, 255, 255)
                .addComponent(jLabel3)
                .addGap(151, 151, 151))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(70, 140, 940, 440);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\OneDrive\\Documents\\image\\Untitled.png")); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(880, 20, 170, 110);

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\OneDrive\\Documents\\image\\—Pngtree—black and white gym room_3485114.jpg")); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 1071, 600);

        setSize(new java.awt.Dimension(1087, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();

        Main mainForm = new Main();
        mainForm.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tracking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tracking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tracking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tracking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
           java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tracking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblmonthly;
    private javax.swing.JTable tblweekly;
    private javax.swing.JTable tblyearly;
    // End of variables declaration//GEN-END:variables
}
