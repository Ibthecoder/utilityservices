package utilityServices;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.JCheckBox;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;

public class AddJob extends JFrame  implements ActionListener {

    Random random = new Random();
    int number = random.nextInt(1101);
    JTextField usernameInput,userSalaryInput,userAddressInput,userNumberInput,userEmailInput,userdesignationInput,userYearInput;
    JDateChooser dbTable;
    JComboBox jobtype, checkEducation;

    JLabel userIDInput;
    JButton addDetails,back;

    AddJob(){
        setLayout(null);
        getContentPane().setBackground(Color.white);


        JLabel heading = new JLabel("Add Job Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);

        JLabel joyType = new JLabel("JOB");
        joyType.setBounds(50,150,150,30);
        joyType.setFont(new Font("serif",Font.PLAIN,20 ));
        add(joyType);

        String ListofJob[]  = {"softwareDeveloper","Teacher","Employee","Nurser"};
        jobtype = new JComboBox(ListofJob);
        jobtype.setBounds(200,150,150,30);
        jobtype.setBackground(Color.WHITE);
        add(jobtype);


        JLabel userName = new JLabel("Name");
        userName.setBounds(400,150,150,30);
        userName.setFont(new Font("serif",Font.PLAIN,20 ));
        add(userName);

        usernameInput = new JTextField();
        usernameInput.setBounds(600,150,150,30);
        add(usernameInput);

        JLabel dateBirth = new JLabel("DateBirth");
        dateBirth.setBounds(50,200,150,30);
        dateBirth.setFont(new Font("serif",Font.PLAIN,20 ));
        add(dateBirth);

         dbTable = new JDateChooser();
        dbTable.setBounds(200,200,150,30);
        add(dbTable);

        JLabel userSalary = new JLabel("Salary");
        userSalary.setBounds(400,200,150,30);
        userSalary.setFont(new Font("serif",Font.PLAIN,20 ));
        add(userSalary);

         userSalaryInput = new JTextField();
        userSalaryInput .setBounds(600,200,150,30);
        add( userSalaryInput );


        JLabel userAddress = new JLabel("Address");
        userAddress.setBounds(50,250,150,30);
        userAddress.setFont(new Font("serif",Font.PLAIN,20 ));
        add(userAddress);

        userAddressInput = new JTextField();
        userAddressInput.setBounds(200,250,150,30);
        add( userAddressInput );


        JLabel userNumber = new JLabel("Phone");
        userNumber.setBounds(400,250,150,30);
        userNumber.setFont(new Font("serif",Font.PLAIN,20 ));
        add(userNumber);

         userNumberInput = new JTextField();
        userNumberInput.setBounds(600,250,150,30);
        add( userNumberInput );


        JLabel userEmail = new JLabel("Email");
        userEmail.setBounds(50,300,150,30);
        userEmail.setFont(new Font("serif",Font.PLAIN,20 ));
        add(userEmail);

         userEmailInput = new JTextField();
        userEmailInput.setBounds(200,300,150,30);
        add( userEmailInput );


        JLabel userEducation = new JLabel("Highest Education");
        userEducation.setBounds(400,300,150,30);
        userEducation.setFont(new Font("serif",Font.PLAIN,20 ));
        add(userEducation);

        String courses[] = {"BBA","BCA","BA", "BSC","B.COM","BTech","MBA","MCA","MA","MTech","MSC","PHD"};
       checkEducation = new JComboBox(courses);
        checkEducation.setBounds(600,300,150,30);
        add(checkEducation);


        JLabel userDesignation = new JLabel("Designation");
        userDesignation.setBounds(50,350,150,30);
        userDesignation.setFont(new Font("serif",Font.PLAIN,20 ));
        add(userDesignation);

         userdesignationInput = new JTextField();
        userdesignationInput.setBounds(200,350,150,30);
        add( userdesignationInput );


        JLabel userYear = new JLabel("Years Experiences");
        userYear.setBounds(400,350,150,30);
        userYear.setFont(new Font("serif",Font.PLAIN,20 ));
        add(userYear) ;

        userYearInput = new JTextField();
        userYearInput.setBounds(600,350,150,30);
        add( userYearInput );

        JLabel userID = new JLabel("UserID");
        userID.setBounds(50,400,150,30);
        userID.setFont(new Font("serif",Font.PLAIN,20 ));
        add(userID) ;

        userIDInput = new JLabel(""+number);
        userIDInput.setBounds(200,400,150,30);
        add( userIDInput  );


        //Button:
         addDetails = new JButton("Add Details");
        addDetails .setBounds(250,550,150,40);
        addDetails.addActionListener(this);
        addDetails .setBackground(Color.BLACK);
        addDetails .setForeground(Color.white);
        add(addDetails);


        back = new JButton("Back");
        back.setBounds(450,550,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        add(back);



        setSize(900,700);
        setLocation(300,50);
        setTitle("AddJobPage");
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addDetails){
           String job_type = (String) jobtype.getSelectedItem();
           String name = usernameInput.getText();
           String date_birth = ((JTextField) dbTable.getDateEditor().getUiComponent()).getText();
           String salary = userSalaryInput.getText();
           String address = userAddressInput.getText();
           String phone = userNumberInput.getText();
           String email = userEmailInput.getText();
           String education = (String) checkEducation.getSelectedItem();
           String designation = userdesignationInput.getText();
           String experiences = userYearInput.getText();
           String user_id = userIDInput.getText();


           try{
               MyConnection conn = new MyConnection();
               String addJobQuery = " INSERT INTO Jobs (job_type,name,date_birth,salary,address,phone,email,education,designation,experiences,user_id) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
               PreparedStatement statement = conn.getConnection().prepareStatement(addJobQuery);
               statement.setString(1,job_type);
               statement.setString(2,name);
               statement.setString(3,date_birth);
               statement.setString(4,salary);
               statement.setString(5,address);
               statement.setString(6,phone);
               statement.setString(7,email);
               statement.setString(8,education);
               statement.setString(9,designation);
               statement.setString(10,experiences);
               statement.setString(11,user_id);
               int rowInserted = statement.executeUpdate();
               //let check condition for the user:
               if (rowInserted > 0){
                   JOptionPane.showMessageDialog(null, "Details Added successful!");
                   setVisible(false);
                   new DashBoard();
               } else {
                   JOptionPane.showMessageDialog(null, "Details Added  failed!");
               }

           } catch (SQLException e){
               JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage());
               e.printStackTrace();

           }


        } else {
            setVisible(false);
            new DashBoard();
        }
    }







}
