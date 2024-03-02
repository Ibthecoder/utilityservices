package utilityServices;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewJobs extends JFrame implements ActionListener {

    JTable recentJobTable;
    Choice choiceuserId;
    JButton SearchBtn,printBtn, updateBtn, backBtn;

    //constructor:
    ViewJobs(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        //searcher:
        JLabel searchLabel = new JLabel("Search by UserID ");
        searchLabel.setBounds(20,20,150,20);
        add(searchLabel);

        choiceuserId = new Choice();
        choiceuserId.setBounds(180,20,150,20);
        add(choiceuserId);

        try{
            MyConnection connection = new MyConnection();
            ResultSet rs = connection.getStatement().executeQuery("SELECT * FROM jobs");
            while (rs.next()){
                choiceuserId.add(rs.getString("user_id"));
            }

        } catch (Exception e){
           e.printStackTrace();
        }






        recentJobTable = new JTable();

        try{
            MyConnection connection = new MyConnection();
            ResultSet rs = connection.getStatement().executeQuery("SELECT * FROM jobs");
            recentJobTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
           e.printStackTrace();
        }

        JScrollPane jScrollPane = new JScrollPane(recentJobTable);
        jScrollPane.setBounds(0,100,900,600);
        add(jScrollPane);


        SearchBtn = new JButton("Search");
        SearchBtn.setBounds(20,70,80,20);
        SearchBtn.addActionListener(this);
        add(SearchBtn);

        printBtn = new JButton("Print");
        printBtn.setBounds(120,70,80,20);
        printBtn.addActionListener(this);
        add(printBtn);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(220,70,80,20);
        updateBtn.addActionListener(this);
        add(updateBtn);


        backBtn = new JButton("Back");
        backBtn.setBounds(220,70,80,20);
        backBtn.addActionListener(this);
        add(backBtn);






        setSize(900,700);
        setLocation(300,100);
        setTitle("ViewJobPage");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == SearchBtn){
            //This condition will Search for recent-job:
            String query = "select * from jobs where user_id = '"+choiceuserId.getSelectedItem()+"' ";
            try{
                MyConnection connection = new MyConnection();
                ResultSet rs = connection.getStatement().executeQuery(query);
                recentJobTable.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e){

            }

        }
        else if (ae.getSource() == printBtn) {
            //just to print:
            try{
                recentJobTable.print();
            } catch (Exception e){
               e.printStackTrace();
            }

        }
        else if (ae.getSource() == updateBtn) {
            setVisible(false);
            new UpdateJob(choiceuserId.getSelectedItem());
        }
        else  {
            setVisible(false);
            new DashBoard();
        }

    }







}
