package LogIn;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class Bank extends JFrame implements ActionListener
{
    private JLabel  label1;
    private JTextField tfield;
    private JButton with , depos , account ;
    private int count;
    private String filename , password ;
    Bank(String username, String money , String password ,String name , String surname)
    {
        filename=username;
        this.password = password;
        count = Integer.valueOf(money);
        label1=new JLabel("Money :");
        label1.setBounds(100,100,75,25);
        this.add(label1);
        tfield = new JTextField();
        tfield.setText(money);
        tfield.setBounds(150,100,100,25);
        tfield.setEditable(false);
        this.add(tfield);

        with = new JButton("Withdraw");
        with.setBounds(225,200,100,25);
        with.addActionListener(this);
        this.add(with);

        depos= new JButton("Deposit");
        depos.setBounds(325,200,100,25);
        depos.addActionListener(this);
        this.add(depos);


        account = new JButton("Account Details");
        account.setBounds(200,400,180,25);
        account.addActionListener(this);
        this.add(account);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setTitle("Welcome "+username);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.lightGray);
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==depos)
        {
            try
            {
                //tfield.setEditable(true);
                ++count;
                tfield.setText(count+" ");
                //tfield.setEditable(false);
                File myObj = new File(filename+".txt");

                Scanner myReader = new Scanner(myObj);
                String pass = myReader.nextLine();
                String mon = myReader.nextLine();
                String na =  myReader.nextLine();
                String sur =  myReader.nextLine();

                FileWriter my= new FileWriter(myObj);
                String b = String.valueOf(count);
                mon=b;
                pass=password;
                my.write(pass+"\n"+mon+"\n"+na+"\n"+sur);
                my.close();
                //myObj.getName();
                myReader.close();
            }
            catch(Exception f)
            {
                System.out.println("You can not depositt");
            }
        }
        else if(e.getSource()==with)
        {
            try
            {
                if(count > 0)
                {
                    --count;
                    tfield.setText(count+" ");
                    File myObj1 = new File(filename+".txt");
    
                    Scanner myReader1 = new Scanner(myObj1);
                    String pass1 = myReader1.nextLine();
                    String mon1 = myReader1.nextLine();
                    String na1 =  myReader1.nextLine();
                    String sur1 =  myReader1.nextLine();
    
                    FileWriter my1= new FileWriter(myObj1);
                    String b1 = String.valueOf(count);
                    mon1=b1;
                    pass1=password;
                    my1.write(pass1+"\n"+mon1+"\n"+na1+"\n"+sur1);
                    my1.close();
                    myReader1.close();
                }
            }
            catch(Exception f)
            {
                System.out.println("You can not withdraw");
            }
        }
        else if(e.getSource()==account)
        {
            try
            {
                File myObj2 = new File(filename+".txt");
                Scanner myReader2 = new Scanner(myObj2);
                String pass2 = myReader2.nextLine();
                String mon2 = myReader2.nextLine();
                String na2 =  myReader2.nextLine();
                String sur2 =  myReader2.nextLine();
                myReader2.close();
                System.out.println(mon2);
                System.out.println(na2);
                new AccountDetails(filename,pass2,na2 , sur2 );
            }
            catch(Exception l)
            {
                System.out.println("a");
            }
        }
    }   
}
