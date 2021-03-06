//importing necessary libraries
import java.sql.*;
import SQLManage.Connector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

//AdminViewQuestion.java inherits from the JFrame STL in order to make it a Jframe form to create UI
public class AdminViewQuestion extends javax.swing.JFrame {

    //a public constructor of the AdminViewQuestion class
    public AdminViewQuestion() {
        initComponents();
        
        //the try block commands will establish a connection between this file and the mysql database for quizzen
        try
        {
            Connection con = Connector.getCon();
            
            //creating a statement to declare as query in the mysql database
            Statement st = con.createStatement();
            
            //executing the query to select all the rows from the question table and displaying it into the questionTable
            ResultSet rs = st.executeQuery("select *from question");
            questionTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        
        //a catch block to go alongside the try block
        catch(Exception e)
        {
            //A message dialog popup that pops up if an error occurs within the try block.
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**NETBEANS GENERATED CODE FROM THE FRONT END DESIGN CONSOLE
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewQuestionTitle = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewQuestionTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        viewQuestionTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/viewallquestion.png"))); // NOI18N
        viewQuestionTitle.setText("View Questions");
        getContentPane().add(viewQuestionTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        exitButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1760, 30, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 1920, 10));

        questionTable.setModel(new javax.swing.table.DefaultTableModel(
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
        questionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                questionTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(questionTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 1750, 480));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addQuestionBackground.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    //EXIT BUTTON EVENT
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        //if the user clicks on the exit button, they will return to the AdminHomePage
        AdminHomePage.open=0;
        setVisible(false);
    }//GEN-LAST:event_exitButtonActionPerformed

    //TABLE DISPLAY SETUP
    private void questionTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_questionTableMouseClicked
        // if the user tries to edit the display table in this form
        boolean edits = questionTable.isEditing();
        if(edits==false){
            //a popup JFrame will appear stating that they can not do so.
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "You can not edit this table in this form.");
        }
    }//GEN-LAST:event_questionTableMouseClicked

    //RUN COMMAND GENERATED BY NETBEANS
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminViewQuestion().setVisible(true);
            }
        });
    }

    //Jframe variables generated with the front end design console from Netbeans
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable questionTable;
    private javax.swing.JLabel viewQuestionTitle;
    // End of variables declaration//GEN-END:variables
}
