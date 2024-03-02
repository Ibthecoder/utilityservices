package utilityServices;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveJob extends JFrame implements ActionListener {


    Choice useridChoice;

    JButton delete , back;

    RemoveJob(){
       getContentPane().setBackground(Color.white); // set the frame background color:
       setLayout(null);


       JLabel userId = new JLabel("User Id");
       userId.setBounds(50,50,100,30);
       add(userId);

       useridChoice = new Choice();
       useridChoice.setBounds(200,50,100,30);
       add(useridChoice);

       try{
           MyConnection connection = new MyConnection();
           String query ="select * from jobs";
           ResultSet rs = connection.getStatement().executeQuery(query);
           while (rs.next()){
               useridChoice.add(rs.getString("user_id"));
           }

       } catch (Exception e){
          e.printStackTrace();
       }

        JLabel Labelname = new JLabel("Name");
        Labelname.setBounds(50,100,100,30);
        add(Labelname);

        JLabel name = new JLabel();
        name.setBounds(200,100,100,30);
        add(name);


        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(50,150,100,30);
        add(phoneLabel);

        JLabel phone = new JLabel();
        phone.setBounds(200,150,100,30);
        add(phone);


        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(50,200,100,30);
        add(emailLabel);

        JLabel email = new JLabel();
        email.setBounds(200,200,100,30);
        add(email);

        try{
            MyConnection connection = new MyConnection();
            String query ="select * from jobs where user_id = '"+useridChoice.getSelectedItem()+"' " ;
            ResultSet rs = connection.getStatement().executeQuery(query);
            while (rs.next()){
                //useridChoice.add(rs.getString("user_id"));
                name.setText(rs.getString("name"));
                phone.setText(rs.getString("phone"));
                email.setText(rs.getString("email"));

            }

        } catch (Exception e){
            e.printStackTrace();
        }

        useridChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                try{
                    MyConnection connection = new MyConnection();
                    String query ="select * from jobs where user_id = '"+useridChoice.getSelectedItem()+"' " ;
                    ResultSet rs = connection.getStatement().executeQuery(query);
                    while (rs.next()){
                        //useridChoice.add(rs.getString("user_id"));
                        name.setText(rs.getString("name"));
                        phone.setText(rs.getString("phone"));
                        email.setText(rs.getString("email"));

                    }

                } catch (Exception ae){
                    ae.printStackTrace();
                }

            }
        });

        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        add(delete);


        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);


        ImageIcon imageIcon1 = new ImageIcon("remove-main-Img.jpg");
        Image image1 = imageIcon1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image1);
        JLabel image = new JLabel(imageIcon2);
        image.setBounds(350,0,600,400);
        add(image);


        setSize(1000,500);
        setLocation(300,150);
        setTitle("RemoveJobPage");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == delete){
            try{
                MyConnection connection = new MyConnection();
                String query = "delete from jobs where user_id = '"+useridChoice.getSelectedItem()+"' ";
                connection.getStatement().executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Information Deleted Successfully");
                setVisible(true);

            } catch (Exception e){
                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new DashBoard();
        }

    }




}
