/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import Classes.User;
import Classes.Admin;
import Classes.Customer;
import Classes.File;
import Classes.Officer;
import Classes.SalesOrder;
import Classes.SalesPerson;
import Classes.Verify;
import java.awt.Graphics2D;
import java.util.List;
import java.security.SecureRandom;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author damonng
 */
public class Register extends javax.swing.JFrame {
    private static List<User> users;
    private MainPage parent;
    private String fullName,dob = null,userName,passWord,emailAddress,role = null,physicalAddress, //vars
                validGender,validRole,validName,validUName,validPass,validEmail,validDate,validPhysicalAddress; //validations
//    private boolean validUName,validPass;
    private char gndr = 0;
    
    /**
     * Creates new form Register
     */
    public Register() {
        this.users = User.list;
        parent = null;
        initComponents();
        address.setEnabled(false);
        address.setVisible(false);

    }
    public Register(MainPage parent) {
        this.parent = parent;
        setContentPane(new javax.swing.JPanel(){
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();
                java.awt.GradientPaint gp = new java.awt.GradientPaint(0, 0, parent.colorPrimary, 0, height, parent.colorSecondary);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, width, height);
            }
        });
        initComponents();
        pageTitle.setText("Customer Registration");
        username.setEnabled(false);
        password.setEnabled(false);
        username.setVisible(false);
        password.setVisible(false);
        retypePassword.setVisible(false);
        btnRedirect.setVisible(false);
        
    }

    private void registerUser(){
        //assign values
        userName=txtUsername.getText();
        passWord = String.valueOf(txtPassword.getPassword());
        //UserSpecific validation
        if (grpRole.getSelection() != null){
            if(radAdmin.isSelected())
                role=radAdmin.getText();
            else if (radOfficer.isSelected())
                role=radOfficer.getText();
            else if (radSalesPerson.isSelected())
                role=radSalesPerson.getText();
            role = role.toLowerCase();
            validRole = "";
        }else{
            validRole = "Role not selected.\n";
        }
        validUName = Verify.isValidUsername(userName);
        validPass = passWord.equals(String.valueOf(txtPasswordRetype.getPassword())) ? Verify.isStrongPassword(passWord) : "password and retyped password is different";
        String errors = validName+validEmail+validDate+validGender+validUName+validRole+validPass;
        if((errors.isEmpty())){
            String otp = sendEmail();
            String userInput = JOptionPane.showInputDialog(rootPane, "Please provide the OTP sent to your email");
            if(otp.equals(userInput)){
                User applicant;
                switch (role.toLowerCase()) {
                    case "admin" ->{
                            applicant = new Admin(userName, fullName, emailAddress, gndr, dob, passWord);
                        }
                    case "officer" ->{
                            applicant = new Officer(userName, fullName, emailAddress, gndr, dob, passWord);
                        }
                    case "sales person" ->{
                            applicant = new SalesPerson(userName, fullName, emailAddress, gndr, dob, passWord);
                        }
                    default -> {
                        applicant = null;
                    }
                }
                users.add(applicant);
                String res=File.write("user", users);
                if("Success".equals(res)){
                    JOptionPane.showMessageDialog(null,"Registration completed.","Success",JOptionPane.PLAIN_MESSAGE);
                }else{          
                    JOptionPane.showMessageDialog(null, res,"Error",JOptionPane.ERROR_MESSAGE);
                }
                MainPage page  = new MainPage(applicant);
                page.setVisible(true);
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null,"It seems that the one time password you gave us is wrong, please try again with a different email, preferrably gmail.","OTP mismatch",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,errors,"Invalid Information",JOptionPane.ERROR_MESSAGE);
        }
    }
    private void registerCustomer(){
        physicalAddress = txtAddress.getText().equals("Write Your address separated by ,")?"":txtAddress.getText();//assign value
        validPhysicalAddress = Verify.validateAddress(physicalAddress);//customer specific validation
        String error = validName+validEmail+validDate+validGender+validPhysicalAddress;
        if(error.isEmpty()){
            Customer customer=new Customer(fullName, emailAddress, dob, gndr, physicalAddress);
            Customer.list.add(customer);
            String res=File.write("customer", Customer.list);
            if("Success".equals(res)){
                JOptionPane.showMessageDialog(null,"Registration completed.","Success",JOptionPane.INFORMATION_MESSAGE);
                SalesOrder.populateList();
                parent.changeTab(4);
                parent.createSalesOrder.tfCustomer.setText(customer.getId());
                parent.PeopleList.loadData();
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, res,"Error",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,error,"Invalid Information",JOptionPane.ERROR_MESSAGE);
        }
    }
    public String sendEmail(){
        // Generate a random 6-digit OTP
        String oneTimePass = newOTP(), sender = "yoyosaleshelper@gmail.com", appPassword = "tsms fozl uvlo flie";

        // Email configuration
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        
        // Create a session with the email server
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, appPassword);
            }
        });
        try {
            // Create a MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set the sender's and recipient's email addresses
            message.setFrom(new InternetAddress(sender));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));

            // Set the email subject and body
            message.setSubject("OTP");
            message.setText("Hi new user, this is an automated mail from YOYO Sales Helper,\n please use the one time password below to complete your registration :\n "+oneTimePass);

            // Send the message
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return oneTimePass;
    }
    private static String newOTP() {
        SecureRandom secureRandom = new SecureRandom();
        int otp = 100000 + secureRandom.nextInt(900000);
        return String.valueOf(otp);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpGender = new javax.swing.ButtonGroup();
        grpRole = new javax.swing.ButtonGroup();
        pageTitle = new javax.swing.JLabel();
        divider = new javax.swing.JSeparator();
        name = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        email = new javax.swing.JPanel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        date = new javax.swing.JPanel();
        lblDOB = new javax.swing.JLabel();
        txtDate = new com.toedter.calendar.JDateChooser();
        gender = new javax.swing.JPanel();
        lblGender = new javax.swing.JLabel();
        radMale = new javax.swing.JRadioButton();
        radFemale = new javax.swing.JRadioButton();
        username = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        Role = new javax.swing.JPanel();
        lblRole = new javax.swing.JLabel();
        radAdmin = new javax.swing.JRadioButton();
        radSalesPerson = new javax.swing.JRadioButton();
        radOfficer = new javax.swing.JRadioButton();
        password = new javax.swing.JPanel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        retypePassword = new javax.swing.JPanel();
        lblPasswordRetype = new javax.swing.JLabel();
        txtPasswordRetype = new javax.swing.JPasswordField();
        address = new javax.swing.JPanel();
        lblAddress = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        buttons = new javax.swing.JPanel();
        btnRegister = new javax.swing.JButton();
        btnRedirect = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Rockwell", 0, 10)); // NOI18N

        pageTitle.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        pageTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pageTitle.setText("Staff Registration");
        pageTitle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        name.setOpaque(false);

        lblName.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblName.setLabelFor(txtUsername);
        lblName.setText("Name:");

        txtName.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(204, 204, 204));
        txtName.setText("Your name");
        txtName.setMinimumSize(new java.awt.Dimension(64, 26));
        txtName.setPreferredSize(new java.awt.Dimension(80, 26));
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });

        javax.swing.GroupLayout nameLayout = new javax.swing.GroupLayout(name);
        name.setLayout(nameLayout);
        nameLayout.setHorizontalGroup(
            nameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        nameLayout.setVerticalGroup(
            nameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nameLayout.createSequentialGroup()
                .addGroup(nameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName))
                .addGap(0, 0, 0))
        );

        email.setOpaque(false);

        lblEmail.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblEmail.setText("Email:");

        txtEmail.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(204, 204, 204));
        txtEmail.setText("example@mail.my");
        txtEmail.setMinimumSize(new java.awt.Dimension(64, 26));
        txtEmail.setPreferredSize(new java.awt.Dimension(80, 26));
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        javax.swing.GroupLayout emailLayout = new javax.swing.GroupLayout(email);
        email.setLayout(emailLayout);
        emailLayout.setHorizontalGroup(
            emailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        emailLayout.setVerticalGroup(
            emailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emailLayout.createSequentialGroup()
                .addGroup(emailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addGap(0, 0, 0))
        );

        date.setOpaque(false);

        lblDOB.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblDOB.setText("DOB:");

        txtDate.setOpaque(false);
        txtDate.setPreferredSize(new java.awt.Dimension(80, 26));

        javax.swing.GroupLayout dateLayout = new javax.swing.GroupLayout(date);
        date.setLayout(dateLayout);
        dateLayout.setHorizontalGroup(
            dateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        dateLayout.setVerticalGroup(
            dateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dateLayout.createSequentialGroup()
                .addGroup(dateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lblDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        gender.setOpaque(false);

        lblGender.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblGender.setText("Gender:");

        grpGender.add(radMale);
        radMale.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        radMale.setText("Male");

        grpGender.add(radFemale);
        radFemale.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        radFemale.setText("Female");

        javax.swing.GroupLayout genderLayout = new javax.swing.GroupLayout(gender);
        gender.setLayout(genderLayout);
        genderLayout.setHorizontalGroup(
            genderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, genderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radMale, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(radFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        genderLayout.setVerticalGroup(
            genderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(genderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender)
                    .addComponent(radFemale)
                    .addComponent(radMale))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        username.setOpaque(false);

        lblUsername.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblUsername.setLabelFor(txtUsername);
        lblUsername.setText("Username:");

        txtUsername.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(204, 204, 204));
        txtUsername.setText("Enter username");
        txtUsername.setPreferredSize(new java.awt.Dimension(80, 26));
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });

        javax.swing.GroupLayout usernameLayout = new javax.swing.GroupLayout(username);
        username.setLayout(usernameLayout);
        usernameLayout.setHorizontalGroup(
            usernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usernameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        usernameLayout.setVerticalGroup(
            usernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usernameLayout.createSequentialGroup()
                .addGroup(usernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Role.setOpaque(false);

        lblRole.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblRole.setText("Role :");

        grpRole.add(radAdmin);
        radAdmin.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        radAdmin.setText("Admin");

        grpRole.add(radSalesPerson);
        radSalesPerson.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        radSalesPerson.setText("Sales Person");

        grpRole.add(radOfficer);
        radOfficer.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        radOfficer.setText("Officer");

        javax.swing.GroupLayout RoleLayout = new javax.swing.GroupLayout(Role);
        Role.setLayout(RoleLayout);
        RoleLayout.setHorizontalGroup(
            RoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RoleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRole, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radOfficer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radSalesPerson)
                .addContainerGap())
        );
        RoleLayout.setVerticalGroup(
            RoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RoleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRole)
                    .addComponent(radAdmin)
                    .addComponent(radSalesPerson)
                    .addComponent(radOfficer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        password.setOpaque(false);

        lblPassword.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblPassword.setText("Password:");

        txtPassword.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtPassword.setPreferredSize(new java.awt.Dimension(80, 26));

        javax.swing.GroupLayout passwordLayout = new javax.swing.GroupLayout(password);
        password.setLayout(passwordLayout);
        passwordLayout.setHorizontalGroup(
            passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passwordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        passwordLayout.setVerticalGroup(
            passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblPassword))
        );

        retypePassword.setOpaque(false);

        lblPasswordRetype.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblPasswordRetype.setText("Retype Password:");

        txtPasswordRetype.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtPasswordRetype.setPreferredSize(new java.awt.Dimension(80, 26));

        javax.swing.GroupLayout retypePasswordLayout = new javax.swing.GroupLayout(retypePassword);
        retypePassword.setLayout(retypePasswordLayout);
        retypePasswordLayout.setHorizontalGroup(
            retypePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, retypePasswordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPasswordRetype)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtPasswordRetype, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        retypePasswordLayout.setVerticalGroup(
            retypePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(txtPasswordRetype, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblPasswordRetype, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        address.setOpaque(false);

        lblAddress.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblAddress.setText("Address");

        txtAddress.setColumns(20);
        txtAddress.setForeground(new java.awt.Color(204, 204, 204));
        txtAddress.setRows(5);
        txtAddress.setText("Write Your address separated by ,");
        txtAddress.setPreferredSize(new java.awt.Dimension(80, 26));
        txtAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAddressFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAddressFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(txtAddress);

        javax.swing.GroupLayout addressLayout = new javax.swing.GroupLayout(address);
        address.setLayout(addressLayout);
        addressLayout.setHorizontalGroup(
            addressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addressLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        addressLayout.setVerticalGroup(
            addressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addressLayout.createSequentialGroup()
                .addGroup(addressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddress)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttons.setOpaque(false);

        btnRegister.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegister.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnRedirect.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnRedirect.setText("Login");
        btnRedirect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedirectActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReset.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnBack.setText("Exit");
        btnBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsLayout = new javax.swing.GroupLayout(buttons);
        buttons.setLayout(buttonsLayout);
        buttonsLayout.setHorizontalGroup(
            buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(18, 18, 18)
                .addComponent(btnReset)
                .addGap(18, 18, 18)
                .addComponent(btnRedirect)
                .addGap(18, 18, 18)
                .addComponent(btnRegister)
                .addGap(0, 0, 0))
        );
        buttonsLayout.setVerticalGroup(
            buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsLayout.createSequentialGroup()
                .addGroup(buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegister)
                    .addComponent(btnRedirect)
                    .addComponent(btnReset)
                    .addComponent(btnBack))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(divider)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pageTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(address, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(username, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Role, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(retypePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(pageTitle)
                .addGap(12, 12, 12)
                .addComponent(divider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Role, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(retypePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(buttons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        //declare variables
        fullName=txtName.getText().equals("Your name")? "":txtName.getText();
        emailAddress = txtEmail.getText().equals("example@mail.my")? "":txtEmail.getText();
        //basic info validation
        if(txtDate.getDate()!=null){
            dob = Verify.DateToString(txtDate.getDate());
            validDate = Verify.validateDate(dob, false);
        }else{
            validDate = "Date is empty\n";
        }
        if (grpGender.getSelection() != null){
            if(radMale.isSelected())
                gndr=radMale.getText().charAt(0);
            else if (radFemale.isSelected())
                gndr=radFemale.getText().charAt(0);
            validGender = "";
        }else{
            validGender = "Gender not selected.\n";
        }
        validName = Verify.validateFullName(fullName);
        validEmail = Verify.validateEmail(emailAddress);
        if (parent!=null){
            registerCustomer();
        }else{
            registerUser();
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtName.setText("");
        grpGender.clearSelection();
        grpRole.clearSelection();
        txtDate.setDate(null);
        txtUsername.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        if(parent==null){
            int n = JOptionPane.showConfirmDialog(null,"Are you sure you want to quit the app.","Confirm Exit",JOptionPane.YES_NO_OPTION);
            if(n==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null,"Thank you for using the system.","Exiting System",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }else{
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        if (txtUsername.getText().equals("Enter username")){
            txtUsername.setText("");
            txtUsername.setForeground(new Color (69,69,69));
        }
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
        if (txtUsername.getText().equals("")){
            txtUsername.setText("Enter username");
            txtUsername.setForeground(new Color (204,204,204));
        }
    }//GEN-LAST:event_txtUsernameFocusLost

    private void txtNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusGained
        if (txtName.getText().equals("Your name")){
            txtName.setText("");
            txtName.setForeground(new Color (69,69,69));
        }
    }//GEN-LAST:event_txtNameFocusGained

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        if (txtName.getText().equals("")){
            txtName.setText("Your name");
            txtName.setForeground(new Color (204,204,204));
        }
    }//GEN-LAST:event_txtNameFocusLost

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        if (txtEmail.getText().equals("example@mail.my")){
            txtEmail.setText("");
            txtEmail.setForeground(new Color (69,69,69));
        }
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if (txtEmail.getText().equals("")){
            txtEmail.setText("example@mail.my");
            txtEmail.setForeground(new Color (204,204,204));
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void btnRedirectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedirectActionPerformed
        Login button = new Login();
        button.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRedirectActionPerformed

    private void txtAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusGained
        if (txtAddress.getText().equals("Write Your address separated by ,")){
            txtAddress.setText("");
            txtAddress.setForeground(new Color (69,69,69));
        }
    }//GEN-LAST:event_txtAddressFocusGained

    private void txtAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusLost
        if (txtAddress.getText().equals("")){
            txtAddress.setText("Write Your address separated by ,");
            txtAddress.setForeground(new Color (204,204,204));
        }
    }//GEN-LAST:event_txtAddressFocusLost

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Role;
    private javax.swing.JPanel address;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRedirect;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnReset;
    private javax.swing.JPanel buttons;
    private javax.swing.JPanel date;
    private javax.swing.JSeparator divider;
    private javax.swing.JPanel email;
    private javax.swing.JPanel gender;
    private javax.swing.ButtonGroup grpGender;
    private javax.swing.ButtonGroup grpRole;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblDOB;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPasswordRetype;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel name;
    private javax.swing.JLabel pageTitle;
    private javax.swing.JPanel password;
    private javax.swing.JRadioButton radAdmin;
    private javax.swing.JRadioButton radFemale;
    private javax.swing.JRadioButton radMale;
    private javax.swing.JRadioButton radOfficer;
    private javax.swing.JRadioButton radSalesPerson;
    private javax.swing.JPanel retypePassword;
    private javax.swing.JTextArea txtAddress;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordRetype;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JPanel username;
    // End of variables declaration//GEN-END:variables
}
