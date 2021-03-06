/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countryflags;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.awt.event.*; 
/**
 *
 * @author davem
 */
public class countryForm extends javax.swing.JFrame {

    /**
     * Creates new form countryForm
     */
    public countryForm() {
        initComponents();
        
        setUpCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboCountry = new javax.swing.JComboBox<>();
        lblCapital = new javax.swing.JLabel();
        lblFlag = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comboCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCountryActionPerformed(evt);
            }
        });

        lblCapital.setText("Place holder for Capital");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFlag)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                        .addComponent(lblCapital)
                        .addGap(84, 84, 84))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCapital))
                .addGap(18, 18, 18)
                .addComponent(lblFlag)
                .addContainerGap(215, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCountryActionPerformed
        // TODO add your handling code here 
        //comboChange();
    }//GEN-LAST:event_comboCountryActionPerformed

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
            java.util.logging.Logger.getLogger(countryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(countryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(countryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(countryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new countryForm().setVisible(true);
            }
        });
    }
    
    private void setUpCombo(){
        try
        {
                ResultSet rs = DataAccessLayer.GetCountries();
                    comboCountry.removeAllItems();
                while (rs.next()) 
                {   String  Country = rs.getString("Country");
                    comboCountry.addItem(Country);
                }    
                
                comboCountry.setSelectedIndex(0);
                String theSelectedImageFilePath = "/images/" + comboCountry.getSelectedItem().toString()+ ".png";
                //lblOutput.setText(theSelectedImageFilePath);
                //lblFlag.setText("");
              lblCapital.setText(DataAccessLayer.GetCapital(comboCountry.getSelectedItem().toString()));
               lblFlag.setIcon(new javax.swing.ImageIcon(getClass().getResource(theSelectedImageFilePath)));
               
               //comboCountry.setActionCommand(comboChange());
               comboCountry.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent arg0) {
            //Do Something
            comboChange();
        }
                });
        }
        catch(SQLException e)
        {
                System.out.println("SQL exception occured" + e);
             
        }

    }
  
    private void comboChange(){
        try
        {   
            
            String theSelectedImageFilePath = "/images/" + comboCountry.getSelectedItem().toString()+ ".png";
            //lblOutput.setText(theSelectedImageFilePath);
            lblFlag.setIcon(new javax.swing.ImageIcon(getClass().getResource(theSelectedImageFilePath)));
            lblCapital.setText( DataAccessLayer.GetCapital( comboCountry.getSelectedItem().toString()));
          
            
        }
        catch(SQLException e)
        {
                System.out.println("SQL exception occured" + e);
             
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboCountry;
    private javax.swing.JLabel lblCapital;
    private javax.swing.JLabel lblFlag;
    // End of variables declaration//GEN-END:variables
}
