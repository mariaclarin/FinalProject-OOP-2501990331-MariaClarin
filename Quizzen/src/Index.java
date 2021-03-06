//Importing necessary libraries
import javax.swing.JOptionPane;

//Index.java inherits the class from the JFrame STL in order to make it a JFrame Form to create UI
public class Index extends javax.swing.JFrame {
    
    //Public constructor of the Index class
    public Index() {
        initComponents();
    }
    
    /** NETBEANS GENERATED CODE FROM THE FRONT END DESIGN CONSOLE
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        studentButton = new javax.swing.JButton();
        adminButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        indexBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentButton.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        studentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/student.png"))); // NOI18N
        studentButton.setText("Student");
        studentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentButtonActionPerformed(evt);
            }
        });
        getContentPane().add(studentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 620, -1, -1));

        adminButton.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        adminButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin.png"))); // NOI18N
        adminButton.setText("Admin");
        adminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminButtonActionPerformed(evt);
            }
        });
        getContentPane().add(adminButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 620, -1, -1));

        exitButton.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1720, 30, -1, -1));

        indexBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgroundIndex.png"))); // NOI18N
        getContentPane().add(indexBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">    
    
    
    
    
    //STUDENT LOGIN BUTTON EVENT
    private void studentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentButtonActionPerformed
        // when the student button is pressed, it will direct the user to the student login page.
        setVisible(false);                      // Index.java page will nolonger be visible
        new StudentLogin().setVisible(true);    // StudentLogin.java will popup and function
    }//GEN-LAST:event_studentButtonActionPerformed

    //EXIT BUTTON EVENT
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
       // when the exit button is pressed, there will be a confirm dialog popup with a Yes or No option.
        int userConfirmation=JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Select", JOptionPane.YES_NO_OPTION); 
        
        //if the user clicks on the button Yes (the syntax is ==0) the system will exit.
        //if the user clicks on the button No, the popup will disappear and the current page will be accessible.
        if(userConfirmation==0)
        {
            System.exit(0); 
        }
    }//GEN-LAST:event_exitButtonActionPerformed
    
    //ADMIN LOGIN BUTTON EVENT
    private void adminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminButtonActionPerformed
        // when the admin button is pressed, it will direct the user to the admin login page.
        setVisible(false);                  // Index.java page will nolonger be visible
        new AdminLogin().setVisible(true);  // AdminLogin.java will popup and function
    }//GEN-LAST:event_adminButtonActionPerformed
    
    //RUN COMMAND GENERATED BY NETBEANS
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }
    
    //JFrame Variables generated with the front end design console from Netbeans
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel indexBackground;
    private javax.swing.JButton studentButton;
    // End of variables declaration//GEN-END:variables
}
