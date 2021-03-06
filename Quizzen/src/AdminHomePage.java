//importing the necessary libraries
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//AdminHomePage.java inherits the class from the JFrame STL in order to make it a JFrame Form to create UI
public class AdminHomePage extends javax.swing.JFrame {
    
    //declaring a static attribute called open, will be used to run menu pages for the Admin
    public static int open=0;
    
    //public constructor of the AdminHomePage Class
    public AdminHomePage() {
        initComponents();
    }
    
    /**NETBEANS GENERATED CODE FROM THE FRONT END DESIGN CONSOLE
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adHomepageBackground = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        addNewQuestionMenu = new javax.swing.JMenu();
        updateQuestionMenu = new javax.swing.JMenu();
        viewQuestionsMenu = new javax.swing.JMenu();
        deleteQuestionMenu = new javax.swing.JMenu();
        viewStudResultsMenu = new javax.swing.JMenu();
        manageStudentMenu = new javax.swing.JMenu();
        logOutMenu = new javax.swing.JMenu();
        exitMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adHomepageBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgroundCentered.png"))); // NOI18N
        getContentPane().add(adHomepageBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -110, -1, -1));

        jMenuBar1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "WELCOME TO QUIZZEN!", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 36))); // NOI18N
        jMenuBar1.setMargin(new java.awt.Insets(0, 5, 0, 100));

        addNewQuestionMenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addNewQuestionMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addquestion.png"))); // NOI18N
        addNewQuestionMenu.setText("Add New Question  ");
        addNewQuestionMenu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addNewQuestionMenu.setMargin(new java.awt.Insets(3, 5, 3, 100));
        addNewQuestionMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addNewQuestionMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(addNewQuestionMenu);

        updateQuestionMenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateQuestionMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/updatemenuicon.png"))); // NOI18N
        updateQuestionMenu.setText("Update Question  ");
        updateQuestionMenu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateQuestionMenu.setMargin(new java.awt.Insets(3, 5, 3, 100));
        updateQuestionMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateQuestionMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(updateQuestionMenu);

        viewQuestionsMenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        viewQuestionsMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/viewallquestion.png"))); // NOI18N
        viewQuestionsMenu.setText("View All Question  ");
        viewQuestionsMenu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewQuestionsMenu.setMargin(new java.awt.Insets(3, 5, 3, 500));
        viewQuestionsMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewQuestionsMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(viewQuestionsMenu);

        deleteQuestionMenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteQuestionMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deletemenuicon.png"))); // NOI18N
        deleteQuestionMenu.setText("Delete Question  ");
        deleteQuestionMenu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deleteQuestionMenu.setMargin(new java.awt.Insets(3, 5, 3, 500));
        deleteQuestionMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteQuestionMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(deleteQuestionMenu);

        viewStudResultsMenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        viewStudResultsMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/studentresults.png"))); // NOI18N
        viewStudResultsMenu.setText("View Student Results  ");
        viewStudResultsMenu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewStudResultsMenu.setMargin(new java.awt.Insets(3, 5, 3, 500));
        viewStudResultsMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewStudResultsMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(viewStudResultsMenu);

        manageStudentMenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        manageStudentMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/manageStudents.png"))); // NOI18N
        manageStudentMenu.setText("Manage Student Data  ");
        manageStudentMenu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manageStudentMenu.setMargin(new java.awt.Insets(3, 5, 3, 500));
        manageStudentMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageStudentMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(manageStudentMenu);

        logOutMenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logOutMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoutmenuicon.png"))); // NOI18N
        logOutMenu.setText("Log Out  ");
        logOutMenu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logOutMenu.setMargin(new java.awt.Insets(3, 5, 3, 500));
        logOutMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(logOutMenu);

        exitMenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exitMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exitmenuicon.png"))); // NOI18N
        exitMenu.setText("Exit  ");
        exitMenu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exitMenu.setMargin(new java.awt.Insets(3, 5, 3, 500));
        exitMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(exitMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    //VIEW STUDENT RESULT MENU EVENT
    private void viewStudResultsMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewStudResultsMenuMouseClicked
        // if the user clicks on the View Student Results menu and the currently opened form for this menu is still 0
        if(open==0)
        {
            //the AdminViewStudentResult page will start running.
            new AdminViewStudentResult().setVisible(true);
            open=1;
        }
        
        //if there is already a running menu form, a JFrame message dialog will popup if the user clicks to open another form
        else
        {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "A View Student Result form is already open.");
        }
    }//GEN-LAST:event_viewStudResultsMenuMouseClicked

    //ADD NEW QUESTION MENU EVENT
    private void addNewQuestionMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNewQuestionMenuMouseClicked
        // if the user clicks on the Add New Question menu and the currently opened form for this menu is still 0
        if(open==0)
        {
            new AdminAddQuestion().setVisible(true);
            open=1;
        }
        
        //if there is already a running menu form, a JFrame message dialog will popup if the user clicks to open another form
        else
        {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "An Add Question form is already open.");
        }
    }//GEN-LAST:event_addNewQuestionMenuMouseClicked
    
    
    //UPDATE QUESTION MENU EVENT
    private void updateQuestionMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateQuestionMenuMouseClicked
        // if the user clicks on the Update Question menu and the currently opened form for this menu is still 0
        if(open==0)
        {
            new AdminUpdateQuestion().setVisible(true);
            open=1;
        }
        
        //if there is already a running menu form, a JFrame message dialog will popup if the user clicks to open another form
        else
        {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "An Update Question form is already open.");
        }
    }//GEN-LAST:event_updateQuestionMenuMouseClicked
    
    //VIEW QUESTIONS MENU EVENT
    private void viewQuestionsMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewQuestionsMenuMouseClicked
        // if the user clicks on the View Questions menu and the currently opened form for this menu is still 0
        if(open==0)
        {
            new AdminViewQuestion().setVisible(true);
            open=1;
        }
        
        //if there is already a running menu form, a JFrame message dialog will popup if the user clicks to open another form
        else
        {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "A View Question form is already open.");
        }
    }//GEN-LAST:event_viewQuestionsMenuMouseClicked

    
    //DELETE QUESTION MENU EVENT
    private void deleteQuestionMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteQuestionMenuMouseClicked
        // if the user clicks on the Delete Question menu and the currently opened form for this menu is still 0
        if(open==0)
        {
            new AdminDeleteQuestion().setVisible(true);
            open=1;
        }
        
        //if there is already a running menu form, a JFrame message dialog will popup if the user clicks to open another form
        else
        {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "A Delete Question form is already open.");
        }
    }//GEN-LAST:event_deleteQuestionMenuMouseClicked
    
    //MANAGE STUDENTS MENU EVENT
    private void manageStudentMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageStudentMenuMouseClicked
        // if the user clicks on the Manage Students menu and the currently opened form for this menu is still 0
        if(open==0)
        {
            new AdminManageStudents().setVisible(true);
            open=1;
        }
        
        //if there is already a running menu form, a JFrame message dialog will popup if the user clicks to open another form
        else
        {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, "A Manage Student Data form is already open.");
        }
    }//GEN-LAST:event_manageStudentMenuMouseClicked
    
    
    //LOG OUT MENU EVENT
    private void logOutMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutMenuMouseClicked
        //if the user clicks on the log out menu, a JFrame popup will appear to ask for user confirmation
        JFrame jf = new JFrame();
        jf.setAlwaysOnTop(true);
        int userConfirmation = JOptionPane.showConfirmDialog(jf, "Are you sure you want to log out?", "Select", JOptionPane.YES_NO_OPTION);
        
        //if the user clicks on the Yes button, they will return to the AdminLogin page.
        if(userConfirmation==0){
            setVisible(false);
            new AdminLogin().setVisible(true);
        }
    }//GEN-LAST:event_logOutMenuMouseClicked
    
    //EXIT MENU EVENT
    private void exitMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMenuMouseClicked
        // if the user clicks on the exit menu, a Jframe popup will appear to ask for user confirmation
        JFrame jf = new JFrame();
        jf.setAlwaysOnTop(true);
        int userConfirmation = JOptionPane.showConfirmDialog(jf, "Are you sure you want to exit?", "Select", JOptionPane.YES_NO_OPTION);
        
        //if the user clicks on the Yes button, the application will be terminated.
        if(userConfirmation==0){
            System.exit(0);
        }
    }//GEN-LAST:event_exitMenuMouseClicked

    //RUN COMMAND GENERATED BY NETBEANS
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHomePage().setVisible(true);
            }
        });
    }
    
    //JFrame Variables generated with the front end design console from Netbeans
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adHomepageBackground;
    private javax.swing.JMenu addNewQuestionMenu;
    private javax.swing.JMenu deleteQuestionMenu;
    private javax.swing.JMenu exitMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu logOutMenu;
    private javax.swing.JMenu manageStudentMenu;
    private javax.swing.JMenu updateQuestionMenu;
    private javax.swing.JMenu viewQuestionsMenu;
    private javax.swing.JMenu viewStudResultsMenu;
    // End of variables declaration//GEN-END:variables
}
