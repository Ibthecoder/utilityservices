package utilityServices;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener {
  public   HomePage(){
        setLayout(null);

        // DashBoard landing page:
        ImageIcon imageIcon1 = new ImageIcon("image4.jpg");
        Image image1 = imageIcon1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image1);
        JLabel image = new JLabel(imageIcon2);
        image.setBounds(0,0,1120,630);
        add(image);


        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0,0,1550,30);
        image.add(menuBar);

        JMenu homeWriteUp = new JMenu("UtilityServices");
        homeWriteUp.setForeground(Color.RED);
        menuBar.add(homeWriteUp);

        JMenu users = new JMenu("Users");
        users.setForeground(Color.blue);
        menuBar.add(users);

        JMenuItem login = new JMenuItem("Login");
        login.setBackground(Color.white);
        login.addActionListener(this);
        users.add(login);

        JMenuItem registration = new JMenuItem("Register");
        registration.setBackground(Color.white);
        registration.addActionListener(this);
        users.add(registration);


        JLabel text = new JLabel("UTILITY SERVICES");
        text.setBounds(20,430,1000,90);
        text.setForeground(Color.white);
         text.setFont(new Font("serif",Font.PLAIN,65));
        image.add(text);

        setVisible(true);
        setSize(1120,630);
        setTitle("UtilityServices-HomePage");
        setLocation(250,100);

        //text-animation:
        while (true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }


    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getActionCommand().equals("Login")){
            new Login();
            setVisible(false);
        }
        else if (ae.getActionCommand().equals("Register")){
            new Register();
        }

    }








}
