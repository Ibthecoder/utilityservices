package utilityServices;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Register extends JFrame implements ActionListener {

    JTextField firstnameInput,lastnameInput,emailInput,phonenumberInput,usernameInput,passwordInput;

    JRadioButton maleRadioBtn,femaleRadioBtn;

    JButton submitBtn;

     Register(){

        setLayout(null);

        //Registration details:

         JLabel heading = new JLabel("Registration Form");
         heading.setBounds(90,0,350,50);
         heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
         add(heading);

        JLabel firstname = new JLabel("FirstName:");
        firstname.setFont(new Font("Tahoma",Font.PLAIN,14));
        firstname.setBounds(40,70,100,30);
        add(firstname);

        firstnameInput = new JTextField();
        firstnameInput.setBounds(150,70,150,30);
         add(firstnameInput);


        JLabel lastname = new JLabel("LastName:");
        lastname.setFont(new Font("Tahoma",Font.PLAIN,14));
        lastname.setBounds(40,120,100,30);
        add(lastname);

        lastnameInput = new JTextField();
        lastnameInput.setBounds(150,120,150,30);
         add(lastnameInput);


        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Tahoma",Font.PLAIN,14));
        email.setBounds(40,170,100,30);
        add(email);


        emailInput = new JTextField();
        emailInput.setBounds(150,170,150,30);
         add(emailInput);


        //JLabel gender = new JLabel();


         JLabel genderlist = new JLabel("Gender:");
         genderlist.setBounds(40,220,100,30);
         genderlist.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(genderlist);

         maleRadioBtn = new JRadioButton("Male");
        maleRadioBtn.setBounds(150,220,70,30);
        maleRadioBtn.setFont(new Font("Tahoma",Font.PLAIN,14));
        maleRadioBtn.setBackground(Color.white);
       add(maleRadioBtn);

         femaleRadioBtn = new JRadioButton("Female");
         femaleRadioBtn.setBounds(220,220,80,30);
         femaleRadioBtn.setFont(new Font("Tahoma",Font.PLAIN,14));
         femaleRadioBtn.setBackground(Color.white);
         add(femaleRadioBtn);

            ButtonGroup bg = new ButtonGroup();
            bg.add(maleRadioBtn);
            bg.add(femaleRadioBtn);




         JLabel phoneNumber = new JLabel("phoneNumber:");
         phoneNumber.setBounds(40,270,100,30);
         phoneNumber.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(phoneNumber);

         phonenumberInput = new JTextField();
         phonenumberInput.setBounds(150,270,150,30);
         add(phonenumberInput);

         JLabel userName = new JLabel("UserName:");
         userName.setBounds(40,320,100,30);
         userName.setFont(new Font("Tahoma",Font.PLAIN,14));
         add(userName);


          usernameInput = new JTextField();
          usernameInput.setBounds(150,320,150,30);
           add(usernameInput);

       JLabel passWord = new JLabel("PassWord:");
       passWord.setBounds(40,370,100,30);
       passWord.setFont(new Font("Tahoma",Font.PLAIN,14));
       add(passWord);

       passwordInput = new JTextField();
       passwordInput.setBounds(150,370,150,30);
        add(passwordInput);


            //Registration image:
            ImageIcon loginImg1 = new ImageIcon("register.png");
            Image loginImg2 = loginImg1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
            ImageIcon loginImg3 = new ImageIcon(loginImg2);
            JLabel imageLabel = new JLabel(loginImg3);
            imageLabel.setBounds(350,80,200,200);
            add(imageLabel);


         //Button:
         submitBtn = new JButton("Submit");
         submitBtn.setBounds(50,425,150,30);
         submitBtn.addActionListener(this);
         submitBtn.setBackground(Color.BLACK);
         submitBtn.setForeground(Color.white);

          add(submitBtn);




         getContentPane().setBackground(Color.white);
        setBounds(500,250,600,500);
        setTitle("RegisterPage");
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        String first_name = firstnameInput.getText();
        String last_name = lastnameInput.getText();
        String email = emailInput.getText();
        String phone = phonenumberInput.getText();
        String user_name = usernameInput.getText();
        String pass_word = passwordInput.getText();
        String user_gender = null;

        // Add more validation checks for other fields if needed:
        if (first_name.isEmpty()){
            JOptionPane.showMessageDialog(null,"FirstName should not be empty:");
            return;
        }

        //check condition for the Radio-btn:

        if (maleRadioBtn.isSelected () ){
            user_gender = "Male";
         }  else if (femaleRadioBtn.isSelected()) {
            user_gender = "Female";
        }




        //let store the userDetail from the Registration form:
                try{
                    MyConnection conn  = new MyConnection();

                    String myQuery = "INSERT INTO users (first_name, last_name, email, phone, user_name, pass_word, user_gender) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement statement = conn.getConnection().prepareStatement(myQuery);
                    statement.setString(1, first_name);
                    statement.setString(2, last_name);
                    statement.setString(3, email);
                    statement.setString(4, phone);
                    statement.setString(5, user_name);
                    statement.setString(6, pass_word);
                    statement.setString(7, user_gender);

                    int rowsInserted = statement.executeUpdate();

                  if (rowsInserted > 0) {
                      setVisible(false); // after the user registration is successful, the setVisible(false) should be false
                      // when means the Registration form will disappear:
                       JOptionPane.showMessageDialog(null, "Registration successful!");

                    } else {
                        JOptionPane.showMessageDialog(null, "Registration failed!");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage());
                    e.printStackTrace();
                }

                }



    }



