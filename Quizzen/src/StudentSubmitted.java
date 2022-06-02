//importing necessary libraries
import SQLManage.Connector;
import java.sql.*;
import javax.swing.JOptionPane;

//StudentSubmitted class inherits the class from the JFrame STL to create UI
public class StudentSubmitted extends javax.swing.JFrame {

    //public default constructor for the StudentSubmitted class
    public StudentSubmitted() {
        initComponents();
    }
    
    //overloading the constructor for StudentSubmitted class taking in the parameter of studentID and score
    public StudentSubmitted(String studentID,String score) {
        initComponents();
        
        //displaying the quizscore and the student ID
        quizScoreLabel.setText(score);
        studentIDLabel.setText(studentID);
        
        //the try block will create a connection between the mysql database and this file
        try
        {
            Connection con = Connector.getCon();
            Statement st = con.createStatement(); //create statement to execute query in the mysql database
            
            //executing query to select all the data in the row where the student id matches
            ResultSet rs = st.executeQuery("select *from student where StudentID ='"+studentID+"'");
            
            //displaying student name in the data panel
            while(rs.next())
            {
                nameLabel.setText(rs.getString(1));
            }
        }
        
        //a catch block to go alongside the try block to catch any errors that may occur from the try block
        catch(Exception e)
        {
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

        quizScoreTitle = new javax.swing.JLabel();
        quizScoreLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameTitle = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        studentIDTitle = new javax.swing.JLabel();
        studentIDLabel = new javax.swing.JLabel();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jSeparator1 = new javax.swing.JSeparator();
        exitButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        quizScoreTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        quizScoreTitle.setText("Quiz Score :");
        getContentPane().add(quizScoreTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, -1, -1));

        quizScoreLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        quizScoreLabel.setForeground(new java.awt.Color(204, 0, 0));
        quizScoreLabel.setText("00");
        getContentPane().add(quizScoreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/student.png"))); // NOI18N
        jLabel2.setText("Successfully Submitted !");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        nameTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        nameTitle.setText("Name : ");
        getContentPane().add(nameTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, -1, -1));

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        nameLabel.setText("name");
        getContentPane().add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, -1, -1));

        studentIDTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        studentIDTitle.setText("Student ID :");
        getContentPane().add(studentIDTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, -1));

        studentIDLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        studentIDLabel.setText("00");
        getContentPane().add(studentIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Congratulations on finishing the quiz !!!\n\nWe hope your scores are satisfactory. In case of any needs please\nreach out to your teachers.\n\nThank you for using Quizzen <3 ");
        getContentPane().add(jTextArea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 280, -1, -1));
        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2547, 1092, 766, 227));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 1920, 10));

        exitButton.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1720, 30, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addQuestionBackground.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    //EXIT BUTTON EVENT
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // if the user clicks the exit button, they will return to Index.java
        setVisible(false);
        new Index().setVisible(true);
    }//GEN-LAST:event_exitButtonActionPerformed

    //RUN COMMAND GENERATED BY NETBEANS
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentSubmitted().setVisible(true);
            }
        });
    }

    //JFrame variables generated by the front end design console of netbeans
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameTitle;
    private javax.swing.JLabel quizScoreLabel;
    private javax.swing.JLabel quizScoreTitle;
    private javax.swing.JLabel studentIDLabel;
    private javax.swing.JLabel studentIDTitle;
    // End of variables declaration//GEN-END:variables
}
