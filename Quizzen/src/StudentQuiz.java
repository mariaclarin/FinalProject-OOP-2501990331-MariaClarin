//importing necessary libraries
import SQLManage.Connector;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;

//the StudentQuiz class inherits the class from the JFrame STL to create UI
public class StudentQuiz extends javax.swing.JFrame {
    
    //public attributes/variables declaration
    public String questionID="1";
    public int questionIDtemp;
    public String answer;
    public int minutes=0;
    public int seconds=0;
    public int marks=0;
    Timer timer;
    public String studentAnswer="";
    public String studentID;
    
    //ANSWER CHECK FUNCTION
    public void answerCheck(){
        //Synching student input on the radio buttons with the studentAnswer variable
        if(opt1Button.isSelected()){
            studentAnswer = opt1Button.getText();
        }
        else if(opt2Button.isSelected()){
            studentAnswer = opt2Button.getText();
        }
        else if(opt3Button.isSelected()){
            studentAnswer = opt3Button.getText();
        }
        else if(opt4Button.isSelected()){
            studentAnswer = opt4Button.getText();
        }
        else
        {
          studentAnswer = "";
        }

        //checking if the answer of the student is the correct answer
        //if it matches the correct answer, the student's marks will increment by 1
        if(studentAnswer.equalsIgnoreCase(answer))
        {
            marks = marks + 1;
        }
        
        //question number update
        //incrementing the question ID whenever the answerCheck() function is called
        questionIDtemp = Integer.parseInt(questionID);
        questionIDtemp = questionIDtemp + 1;
        questionID = String.valueOf(questionIDtemp);
        
        //clear radio button inputs after the answer is checked and the question ID is incremented
        opt1Button.setSelected(false);
        opt2Button.setSelected(false);
        opt3Button.setSelected(false);
        opt4Button.setSelected(false);
        
        //If the questionID/question number is on last number, hides the next question button will be hidden
        if(questionID.equals("10")){
            nextButton.setVisible(false);
        }
    }
    
    //QUESTION FUNCTION
    public void question(){
        
        //a try block to create connections between this file and the mysql database for quizzen
        try
        {
            Connection con = Connector.getCon();
            Statement st = con.createStatement(); //create statement to be executed as a query in the mysql database
            
            //executing the query to select the row of data where the id matches with the questionID variable in the question table
            ResultSet rs = st.executeQuery("select *from question where id='"+questionID+"'");
            
            //while the mysql database returns a result
            while(rs.next())
            {
                //the questions will be displayed alongside the options and question number
                questionNoLabel.setText(rs.getString(1));
                questionLabel.setText(rs.getString(2));
                opt1Button.setText(rs.getString(3));
                opt2Button.setText(rs.getString(4));
                opt3Button.setText(rs.getString(5));
                opt4Button.setText(rs.getString(6));
                
                //the variable answer will store the correct answer based on the database to compare with the student's answer
                //in the function answerCheck()
                answer = rs.getString(7);
            } 
        }
        
        //a catch block to go alongside the try block to catch any errors that may occur from the try block
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //SUBMIT FUNCTION
    public void submit(){
        //a variable to store the displayed studentID
        studentID = studentIDLabel.getText();
        
        //calling the answerCheck() function
        answerCheck();
        
        //the try block commands will create a connection between this file and the mysql database for quizzen
        try{
            Connection con = Connector.getCon();
            Statement st = con.createStatement(); //create a statement to execute query into the mysql database
            
            //executing the update with the query to update the student's Marks/score according to the student ID
            st.executeUpdate("update student set Marks='"+marks+"'where StudentID = '"+studentID+"'");
            
            //once the update is done, the timer ends and the StudentSubmitted file starts running
            setVisible(false);
            new StudentSubmitted(studentID,Integer.toString(marks)).setVisible(true);
            timer.stop();
        }
        
        //a catch block to go alongside the try block to catch any errors that may occur from the try block
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //constructor
    public StudentQuiz() {
        initComponents();
    }
    public StudentQuiz(String studentID) {
        initComponents();
        studentIDLabel.setText(studentID);
        //date setup
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        dateLabel.setText(dFormat.format(date));
        
        //first question and student details
        try
        {
            Connection con = Connector.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select *from student where StudentID ='"+studentID+"'");
            
            //displaying student name in the data panel
            while(rs.next())
            {
                nameLabel.setText(rs.getString(1));
            } 
            
            //displaying the question no in the data panel, question display and option display
            ResultSet rs1 = st.executeQuery("select *from question where id='"+questionID+"'");
            while(rs1.next())
            {
                questionNoLabel.setText(rs1.getString(1));
                questionLabel.setText(rs1.getString(2));
                opt1Button.setText(rs1.getString(3));
                opt2Button.setText(rs1.getString(4));
                opt3Button.setText(rs1.getString(5));
                opt4Button.setText(rs1.getString(6));
                answer = rs1.getString(7);
            }
            
            //displaying the total no. of questions in the data panel
            PreparedStatement ps = con.prepareStatement("select count(*) from question");
            ResultSet rs2 = ps.executeQuery();
            while(rs2.next()){
                String questionTotal = rs2.getString("count(*)");
                totalQuestionLabel.setText(questionTotal);
            }      
        }
        
        //a catch block to go alongside the try block to catch any errors that may occur from the try block
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        //TIMER OBJECT DECLARATION/INSTANTIATION
        timer = new Timer(1000, new ActionListener(){//1000 is 1 second 1 = 1 milisecond / program updates the program every 1 second
            @Override
            public void actionPerformed(ActionEvent e){ //what happens when the timer updates
                
                //displaying the timer labels on the right area, seconds and minutes
                timerSecLabel.setText(String.valueOf(seconds));
                timerMinLabel.setText(String.valueOf(minutes));
                
                //if the seconds has reach the value of 60, the value will reset to 0 and the minutes variable will be incremented by 1
                if(seconds == 60){
                    seconds = 0;
                    minutes++;
                    
                    //if the timer reaches 10 minutes, then the timer will stop immediately and submit as it is the maximum time of the quiz
                    if(minutes == 10){
                        timer.stop();
                        answerCheck();
                        submit();
                    }
                }
                //incrementing the seconds variable by 1
                seconds++;
            }
        });
        timer.start();
    }
    
    
    /**NETBEANS GENERATED CODE FROM THE FRONT END DESIGN CONSOLE
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timerMinLabel = new javax.swing.JLabel();
        quizTitle = new javax.swing.JLabel();
        dateTitle = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        totalTimeTitle = new javax.swing.JLabel();
        totalTimeLabel = new javax.swing.JLabel();
        timerTitle = new javax.swing.JLabel();
        questionLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        opt1Button = new javax.swing.JRadioButton();
        opt2Button = new javax.swing.JRadioButton();
        opt3Button = new javax.swing.JRadioButton();
        opt4Button = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        questionNoTitle = new javax.swing.JLabel();
        totalQuestionLabel = new javax.swing.JLabel();
        totalQuestionTitle = new javax.swing.JLabel();
        questionNoLabel = new javax.swing.JLabel();
        nameTitle = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        studentIDNoTitle = new javax.swing.JLabel();
        studentIDLabel = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        timerSecLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timerMinLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        timerMinLabel.setText("00");
        getContentPane().add(timerMinLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 140, -1, -1));

        quizTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        quizTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/student.png"))); // NOI18N
        quizTitle.setText("Quizzen Quiz");
        getContentPane().add(quizTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        dateTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        dateTitle.setText("Date :");
        getContentPane().add(dateTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, -1, -1));

        dateLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        dateLabel.setText("jLabel2");
        getContentPane().add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, -1, -1));

        totalTimeTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        totalTimeTitle.setText("Total Time   :");
        getContentPane().add(totalTimeTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 100, -1, -1));

        totalTimeLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        totalTimeLabel.setText("10 Minutes");
        getContentPane().add(totalTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 100, -1, -1));

        timerTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        timerTitle.setText("Time Taken :");
        getContentPane().add(timerTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 140, -1, -1));

        questionLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        questionLabel.setText("Question Display");
        getContentPane().add(questionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 1920, 10));

        opt1Button.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        opt1Button.setText("Option 1");
        opt1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt1ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(opt1Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, -1, -1));

        opt2Button.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        opt2Button.setText("Option 2");
        opt2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt2ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(opt2Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, -1, -1));

        opt3Button.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        opt3Button.setText("Option 3");
        opt3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt3ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(opt3Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, -1, -1));

        opt4Button.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        opt4Button.setText("Option 4");
        opt4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt4ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(opt4Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 520, -1, -1));

        jPanel1.setBackground(new java.awt.Color(236, 224, 208));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        questionNoTitle.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        questionNoTitle.setText("Question No.   :");

        totalQuestionLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        totalQuestionLabel.setText("10");

        totalQuestionTitle.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        totalQuestionTitle.setText("Total Question : ");

        questionNoLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        questionNoLabel.setText("00");

        nameTitle.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        nameTitle.setText("Name              :");

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        nameLabel.setText("name");

        studentIDNoTitle.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        studentIDNoTitle.setText("Student ID No. :");

        studentIDLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        studentIDLabel.setText("00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalQuestionTitle)
                            .addComponent(questionNoTitle))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(questionNoLabel)
                            .addComponent(totalQuestionLabel)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameTitle)
                            .addComponent(studentIDNoTitle))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studentIDLabel)
                            .addComponent(nameLabel))))
                .addContainerGap(219, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentIDNoTitle)
                    .addComponent(studentIDLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTitle)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalQuestionLabel)
                    .addComponent(totalQuestionTitle))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(questionNoTitle)
                    .addComponent(questionNoLabel))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 460, 190));

        submitButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        submitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        submitButton.setText("Submit and Finish");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 610, -1, -1));

        nextButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/next_1.png"))); // NOI18N
        nextButton.setText("Next Question");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        getContentPane().add(nextButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 610, -1, -1));

        timerSecLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        timerSecLabel.setText("00");
        getContentPane().add(timerSecLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 140, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addQuestionBackground.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    //RADIO BUTTON SYNCHING
    private void opt3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt3ButtonActionPerformed
        //if the option 3 button is selected, the rest of the button will be deselected
        if(opt3Button.isSelected()){
            opt2Button.setSelected(false);
            opt1Button.setSelected(false);
            opt4Button.setSelected(false);
        }
    }//GEN-LAST:event_opt3ButtonActionPerformed

    //SUBMIT BUTTON EVENT
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // if the student has not reach the total number of questions
        // a confirmation popup message will appear to ask for confirmation as the quiz has not been finished yet
        if(Integer.parseInt(questionID)!=10){
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            int userConfirmation = JOptionPane.showConfirmDialog(jf, "Are you sure you want to submit? You have not finished the quiz.", "Select", JOptionPane.YES_NO_OPTION);
            if(userConfirmation==0){
                answerCheck();
                submit();
            }
        }
        
        //else the confirmation popup message will appear to ask for confirmation to submit the answers
        else{
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            int userConfirmation = JOptionPane.showConfirmDialog(jf, "Are you sure you want to submit?", "Select", JOptionPane.YES_NO_OPTION);
            if(userConfirmation==0){
                answerCheck();
                submit();
            }
        }
        
    }//GEN-LAST:event_submitButtonActionPerformed
    
    //NEXT BUTTON EVENT
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        //if the user clicks on the next button, the answerCheck() and question() functions will be called
        answerCheck();
        question();
    }//GEN-LAST:event_nextButtonActionPerformed

    //RADIO BUTTON SYNCHING
    private void opt1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt1ButtonActionPerformed
        //if the option 1 button is selected, the rest of the button will be deselected
        if(opt1Button.isSelected()){
            opt2Button.setSelected(false);
            opt3Button.setSelected(false);
            opt4Button.setSelected(false);
        }
    }//GEN-LAST:event_opt1ButtonActionPerformed

    //RADIO BUTTON SYNCHING
    private void opt2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt2ButtonActionPerformed
        //if the option 2 button is selected, the rest of the button will be deselected
        if(opt2Button.isSelected()){
            opt1Button.setSelected(false);
            opt3Button.setSelected(false);
            opt4Button.setSelected(false);
        }
    }//GEN-LAST:event_opt2ButtonActionPerformed

    //RADIO BUTTON SYNCHING
    private void opt4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt4ButtonActionPerformed
        //if the option 2 button is selected, the rest of the button will be deselected
        if(opt4Button.isSelected()){
            opt2Button.setSelected(false);
            opt3Button.setSelected(false);
            opt1Button.setSelected(false);
        }
    }//GEN-LAST:event_opt4ButtonActionPerformed

    //RUN COMMAND GENERATED BY NETBEANS
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
            java.util.logging.Logger.getLogger(StudentQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentQuiz().setVisible(true);
            }
        });
    }

    //JFrame Variables generated by the front end design console of Netbeans
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel dateTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameTitle;
    private javax.swing.JButton nextButton;
    private javax.swing.JRadioButton opt1Button;
    private javax.swing.JRadioButton opt2Button;
    private javax.swing.JRadioButton opt3Button;
    private javax.swing.JRadioButton opt4Button;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel questionNoLabel;
    private javax.swing.JLabel questionNoTitle;
    private javax.swing.JLabel quizTitle;
    private javax.swing.JLabel studentIDLabel;
    private javax.swing.JLabel studentIDNoTitle;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel timerMinLabel;
    private javax.swing.JLabel timerSecLabel;
    private javax.swing.JLabel timerTitle;
    private javax.swing.JLabel totalQuestionLabel;
    private javax.swing.JLabel totalQuestionTitle;
    private javax.swing.JLabel totalTimeLabel;
    private javax.swing.JLabel totalTimeTitle;
    // End of variables declaration//GEN-END:variables
}
