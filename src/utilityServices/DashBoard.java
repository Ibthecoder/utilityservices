package utilityServices;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashBoard extends JFrame implements ActionListener {

    JButton addJob,view,update,remove;

    DashBoard(){
        setLayout(null);

        // DashBoard landing page:
        ImageIcon imageIcon1 = new ImageIcon("image1.jpg");
        Image image1 = imageIcon1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image1);
        JLabel image = new JLabel(imageIcon2);
        image.setBounds(0,0,1120,630);
        add(image);


        JLabel heading = new JLabel("DashBoard Management System");
        heading.setBounds(620,20,450,40);
        heading.setFont(new Font("Raleway",Font.BOLD,26));
        heading.setForeground(Color.white);
        image.add(heading);


        addJob = new JButton("Add Job");
        addJob.setBounds(650,80,150,40);
        addJob.addActionListener(this);
        image.add(addJob);


        view = new JButton("View");
        view.setBounds(820,80,150,40);
        view.addActionListener(this);
        image.add(view);


         update = new JButton("Update");
        update.setBounds(650,140,150,40);
        update.addActionListener(this);
        image.add(update);

        remove = new JButton("Remove");
        remove.setBounds(820,140,150,40);
        remove.addActionListener(this);
        image.add(remove);









        setSize(1120,630);
        setLocation(250,100);
        setTitle("DashBoardPage");
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addJob ){
            setVisible(false);
            new AddJob();
        }
        else if (ae.getSource() == view) {
            setVisible(false);
            new ViewJobs();

        }
        else if (ae.getSource() == update) {
            setVisible(false);
            new ViewJobs();
        }
        else  {
            setVisible(false);
            new RemoveJob();

        }



    }




}
