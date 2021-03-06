/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.JobController;
import icontrollers.IJobController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Job;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Sekar Ayu Safitri
 */
public class JIJob extends javax.swing.JInternalFrame {
    
    SessionFactory factory = HibernateUtil.getSessionFactory();
    IJobController ijc = new JobController(factory);

    /**
     * Creates new form JIJob
     */
    public JIJob() {
        initComponents();
        showTableJob();
    }
    
    public void resetTextJob(){
        jId.setText("");
        jTitle.setText("");
        jMinSalary.setText("");
        jMaxSalary.setText("");
        jInputSeacrh.setText("");
        jId.setEditable(true);
        btnInsert.setEnabled(true);
    }
    
    private void showTableJob() {
        DefaultTableModel model = (DefaultTableModel) jTableResult.getModel();
        Object[] row = new Object[4];
        List<Job> job = new ArrayList<>();
        job = ijc.getAll();
        for (int i = 0; i < job.size(); i++) {
            row[0] = job.get(i).getId();
            row[1] = job.get(i).getTitle();
//            row[2] = job.get(i).getMinSalary();
//            row[3] = job.get(i).getMaxSalary();
            model.addRow(row);
        }
    }

    private void showTableJob(String s) {
        DefaultTableModel model = (DefaultTableModel) jTableResult.getModel();
        Object[] row = new Object[4];
        List<Job> job = new ArrayList<>();
        job = ijc.getAll();
        for (int i = 0; i < job.size(); i++) {
            row[0] = job.get(i).getId();
            row[1] = job.get(i).getTitle();
//            row[2] = job.get(i).getMinSalary();
//            row[3] = job.get(i).getMaxSalary();
            model.addRow(row);
        }
    }

    public void updateTableJob(){
        DefaultTableModel model = (DefaultTableModel) jTableResult.getModel();
        model.setRowCount(0);
        showTableJob();
    }
    
    public void updateTableJob(String s){
        DefaultTableModel model = (DefaultTableModel) jTableResult.getModel();
        model.setRowCount(0);
        if (s == "") {
            showTableJob();
        }
        showTableJob(s);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jId = new javax.swing.JTextField();
        jTitle = new javax.swing.JTextField();
        jMinSalary = new javax.swing.JTextField();
        jMaxSalary = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jInputSeacrh = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResult = new javax.swing.JTable();

        jLabel1.setText("FORM JOB");

        jLabel2.setText("JOB ID");

        jLabel3.setText("JOB TITLE");

        jLabel4.setText("MINIMAL SALARY");

        jLabel5.setText("MAXIMAL SALARY");

        btnInsert.setText("INSERT");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jInputSeacrh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jInputSeacrhKeyReleased(evt);
            }
        });

        btnSearch.setText("SEARCH");

        jTableResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job Id", "Job Title", "Minimal Salary", "Maximal Salary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableResultMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableResult);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnInsert)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(91, 91, 91))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jInputSeacrh, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jMaxSalary)
                                    .addComponent(jMinSalary, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTitle, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jMinSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jMaxSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(jInputSeacrh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jInputSeacrhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jInputSeacrhKeyReleased
        // TODO add your handling code here:
        updateTableJob(jInputSeacrh.getText());
    }//GEN-LAST:event_jInputSeacrhKeyReleased

    private void jTableResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableResultMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTableResult.getModel();
        int SelectRowIndex = jTableResult.getSelectedRow();
        
        jId.setEditable(false);
        btnInsert.setEnabled(false);
        jId.setText(model.getValueAt(SelectRowIndex, 0).toString());
        jTitle.setText(model.getValueAt(SelectRowIndex, 1).toString());
        jMinSalary.setText(model.getValueAt(SelectRowIndex, 2).toString());
        jMaxSalary.setText(model.getValueAt(SelectRowIndex, 3).toString());
    }//GEN-LAST:event_jTableResultMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Ingin mengupdate data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, ijc.save(jId.getText(), jTitle.getText(), jMinSalary.getText(), jMaxSalary.getText()));
            updateTableJob();
            resetTextJob();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
          int confirm = JOptionPane.showConfirmDialog(this, "Ingin mengupdate data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, ijc.save(jId.getText(), jTitle.getText(), jMinSalary.getText(), jMaxSalary.getText()));
            updateTableJob();
            resetTextJob();
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
          int confirm = JOptionPane.showConfirmDialog(this, "Ingin mengupdate data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, ijc.delete(jId.getText()));
            updateTableJob();
            resetTextJob();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField jId;
    private javax.swing.JTextField jInputSeacrh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jMaxSalary;
    private javax.swing.JTextField jMinSalary;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableResult;
    private javax.swing.JTextField jTitle;
    // End of variables declaration//GEN-END:variables

}
