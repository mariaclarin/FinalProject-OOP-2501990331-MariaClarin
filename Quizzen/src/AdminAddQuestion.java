//importing necessary libraries
import java.sql.*;
import SQLManage.Connector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//AdminAddQuestion.java inherits the class from the JFrame STL in order to make it a JFrame Form to create UI
public class AdminAddQuestion extends javax.swing.JFrame {
    
    //public constructor of the AdminAddQuestion Class
    public AdminAddQuestion() {
        initComponents();
        
        //The try block commands will establish a connection between this file and the mysql database made for Quizzen
        try{
            Connection con = Connector.getCon();
            Statement st = con.createStatement();                             //creating a statement in mysql 
            ResultSet rs = st.executeQuery("select count(id) from question"); //takes the current question ID from the 'id' collumn of the mysql table 'question'
            if(rs.next())                                                     //if the mysql terminal comes up with a result
            {
                //the value of the current id will be displayed in the questionIDLabel
                int id = rs.getInt(1);
                id = id+1;
                String str = String.valueOf(id);
                questionIDlabel.setText(str);
            }
            else //if the mysql terminal doesnt have a result (the collumn is empty)
            {
                questionIDlabel.setText("1"); //the value '1' will be displayed in the questionIDLabel
            }
        } 
        
        //a catch block to go alongside the try block if the try block fails which catches an exception if an error occurs
        catch(Exception e){
            //displays a JFrame that is basically nothing. If the catch block is activated, I take it as an indication that there is an error.
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e);
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

        AddQuestionTitle = new javax.swing.JLabel();
        seperatorLine1 = new javax.swing.JSeparator();
        questionIDTitle = new javax.swing.JLabel();
        questionIDlabel = new javax.swing.JLabel();
        questionTitle = new javax.swing.JLabel();
        option1Title = new javax.swing.JLabel();
        option2Title = new javax.swing.JLabel();
        option3Title = new javax.swing.JLabel();
        option4Title = new javax.swing.JLabel();
        answerTitle = new javax.swing.JLabel();
        questionInputField = new javax.swing.JTextField();
        opt1InputField = new javax.swing.JTextField();
        opt2InputField = new javax.swing.JTextField();
        opt3InputField = new javax.swing.JTextField();
        opt4InputField = new javax.swing.JTextField();
        answerInputField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        addQuestionBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddQuestionTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        AddQuestionTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addquestion.png"))); // NOI18N
        AddQuestionTitle.setText("Add New Question");
        getContentPane().add(AddQuestionTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));
        getContentPane().add(seperatorLine1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 190, 2540, 20));

        questionIDTitle.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        questionIDTitle.setText("Question ID :");
        getContentPane().add(questionIDTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 250, -1, -1));

        questionIDlabel.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        questionIDlabel.setText("00");
        getContentPane().add(questionIDlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 250, -1, -1));

        questionTitle.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        questionTitle.setText("Question :");
        getContentPane().add(questionTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 290, -1, -1));

        option1Title.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        option1Title.setText("Option 1 :");
        getContentPane().add(option1Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 333, -1, -1));

        option2Title.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        option2Title.setText("Option 2 :");
        getContentPane().add(option2Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 376, -1, -1));

        option3Title.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        option3Title.setText("Option 3 :");
        getContentPane().add(option3Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 419, -1, -1));

        option4Title.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        option4Title.setText("Option 4 :");
        getContentPane().add(option4Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 462, -1, -1));

        answerTitle.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        answerTitle.setText("Answer :");
        getContentPane().add(answerTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 505, -1, -1));

        questionInputField.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        getContentPane().add(questionInputField, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 289, 1536, -1));

        opt1InputField.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        getContentPane().add(opt1InputField, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 332, 1536, -1));

        opt2InputField.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        getContentPane().add(opt2InputField, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 375, 1536, -1));

        opt3InputField.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        getContentPane().add(opt3InputField, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 418, 1536, -1));

        opt4InputField.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        getContentPane().add(opt4InputField, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 461, 1536, -1));

        answerInputField.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        getContentPane().add(answerInputField, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 504, 1536, -1));

        saveButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 550, -1, -1));

        exitButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1760, 30, -1, -1));

        clearButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 550, -1, -1));

        addQuestionBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addQuestionBackground.png"))); // NOI18N
        getContentPane().add(addQuestionBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    //SAVE BUTTON EVENT
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // creating variables to store the user inputs from the corresponding input fields.
        String id = questionIDlabel.getText();
        String name = questionInputField.getText();
        String opt1 = opt1InputField.getText();
        String opt2 = opt2InputField.getText();
        String opt3 = opt3InputField.getText();
        String opt4 = opt4InputField.getText();
        String answer = answerInputField.getText();
        
        //The try block commands will establish a connection between this file and the mysql database made for Quizzen
        try
        {
            Connection con= Connector.getCon();
            PreparedStatement ps = con.prepareStatement("insert into question values(?,?,?,?,?,?,?)"); //declaring the query into the mysql database 
            
            //inserting the data stored in the previously declared variables into the corresponding collumns of data in a row
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, opt1);
            ps.setString(4, opt2);
            ps.setString(5, opt3);
            ps.setString(6, opt4);
            ps.setString(7, answer);
            ps.executeUpdate(); //executing the update in the mysql database
            
            //creating a popup message dialog with JFrame to display success message.
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "Successfully Updated");
            
            //when the user exits the popup message dialog, the add question page will refresh.
            setVisible(false);
            new AdminAddQuestion().setVisible(true); 
        }
        
        //a catch block to go alongside the try block if the try block fails.
        catch(Exception e)
        {
            //displays a JFrame that is basically nothing. If the catch block is activated, I take it as an indication that there is an error.
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e);
        }
    }//GEN-LAST:event_saveButtonActionPerformed
    
    //CLEAR BUTTON EVENT
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // when the user presses the clear button, they will clear every single input field available on the screen.
        // this will not make changes to the mysql database
        questionInputField.setText("");
        opt1InputField.setText("");
        opt2InputField.setText("");
        opt3InputField.setText("");
        opt4InputField.setText("");
        answerInputField.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    //EXIT BUTTON EVENT 
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // when the user clicks on the exit button, they will return to the AdminHomePage while the 
        // AdminAddQuestion page will disappear.
        AdminHomePage.open=0;
        setVisible(false);
    }//GEN-LAST:event_exitButtonActionPerformed

    //RUN COMMAND GENERATED BY NETBEANS
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminAddQuestion().setVisible(true);
            }
        });
    }
    //JFrame Variables generated with the front end design console from Netbeans
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddQuestionTitle;
    private javax.swing.JLabel addQuestionBackground;
    private javax.swing.JTextField answerInputField;
    private javax.swing.JLabel answerTitle;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JTextField opt1InputField;
    private javax.swing.JTextField opt2InputField;
    private javax.swing.JTextField opt3InputField;
    private javax.swing.JTextField opt4InputField;
    private javax.swing.JLabel option1Title;
    private javax.swing.JLabel option2Title;
    private javax.swing.JLabel option3Title;
    private javax.swing.JLabel option4Title;
    private javax.swing.JLabel questionIDTitle;
    private javax.swing.JLabel questionIDlabel;
    private javax.swing.JTextField questionInputField;
    private javax.swing.JLabel questionTitle;
    private javax.swing.JButton saveButton;
    private javax.swing.JSeparator seperatorLine1;
    // End of variables declaration//GEN-END:variables
}