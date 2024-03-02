package utilityServices;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField userInput,passwordInput;
    JButton loginBtn,cancelBtn;

    Login(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Login Here");
        heading.setBounds(130,0,180,70);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);


        JLabel user = new JLabel("userName:");
        user.setBounds(40,70,100,30);
        add(user);

         userInput = new JTextField();
        userInput.setBounds(150,70,150,30);
        userInput.addActionListener(this);
        add(userInput);


        JLabel password = new JLabel("passWord:");
        password.setBounds(40,120,100,30);
        add(password);

         passwordInput = new JTextField();
        passwordInput.setBounds(150,120,150,30);
        passwordInput.addActionListener(this);
        add(passwordInput);

         loginBtn = new JButton("Login");
        loginBtn.setBounds(40,172,120,30);
        loginBtn.setBackground(Color.BLACK);
        loginBtn.setForeground(Color.white);
        loginBtn.addActionListener(this);
        add(loginBtn);


         cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(180,172,120,30);
        cancelBtn.setBackground(Color.BLACK);
        cancelBtn.setForeground(Color.white);
        cancelBtn.addActionListener(this);
        add(cancelBtn);


        ImageIcon loginImg1 = new ImageIcon("Login.png");
        Image loginImg2 = loginImg1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon loginImg3 = new ImageIcon(loginImg2);
        JLabel imageLabel = new JLabel(loginImg3);
        imageLabel.setBounds(350,10,200,200);
        add(imageLabel);




        setBounds(500,200,600,300);
        setTitle("LoginPage");
        setVisible(true);
    }
       @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginBtn){
            String user_name = userInput.getText();
            String pass_word = passwordInput.getText();

            try{
                MyConnection connection = new MyConnection();

                String query = "select * from users where user_name = '"+user_name+"' and pass_word = '"+pass_word+"' ";
                ResultSet rs =  connection.getStatement().executeQuery(query);
            if (rs.next()){
                setVisible(false);
                new DashBoard();

            } else {
                JOptionPane.showMessageDialog(null,"Invalid username or password");
                setVisible(false);
            }


            } catch (Exception e){
                e.printStackTrace();
            }



        }  else {
            setVisible(false);
        }


    }


}
