package LogIn;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
public class Account extends JFrame implements ActionListener
{
    protected JLabel name , surname , username , password , gender ;
    public TextField tname,tsurname,tusername,tpassword; 
    protected JFrame frame;
    private JButton button;
    String usern , pass3 , money;
    private JRadioButton male,female;
    private ButtonGroup group;
    Account(String username1 , String password1 ,String mo)
    {
        money=mo;
        usern = username1;
        pass3 = password1;
        frame = new JFrame();

        name = new JLabel("Your Name :");
        surname = new JLabel("Your Surname : ");
        username = new JLabel("Your Username : ");
        password = new JLabel("Your Password : ");
        gender = new JLabel("Your Gender :");


        name.setBounds(50, 50, 75, 25);
        surname.setBounds(50, 100, 100, 25);
        gender.setBounds(50, 150, 100, 25);
        username.setBounds(50, 200, 100, 25);
        password.setBounds(50, 250, 100, 25);


        frame.add(name);
        frame.add(surname);
        frame.add(gender);
        frame.add(username);
        frame.add(password);


        tname = new TextField(" ");
        tsurname = new TextField(" ");
        tusername = new TextField(username1+" ");
        tpassword = new TextField(password1+" ");

        tusername.setEditable(false);
        tpassword.setEditable(false);


        tname.setBounds(200, 50, 75, 25);
        tsurname.setBounds(200, 100, 100, 25);
        tusername.setBounds(200, 200, 100, 25);
        tpassword.setBounds(200, 250, 100, 25);


        frame.add(tname);
        frame.add(tsurname);
        frame.add(tusername);
        frame.add(tpassword);

        button = new JButton("Okey");
        button.addActionListener(this);
        button.setBounds(300,300,75,25);
        frame.add(button);


        male= new JRadioButton("Male");//buttons with something
        female=new JRadioButton("Female");

        male.setBounds(150, 150, 100 , 25);
        female.setBounds(250, 150, 100, 25);

        group=new ButtonGroup();//group this buttons
        group.add(male);
        group.add(female);
        frame.add(male);
        frame.add(female);


        frame.setLayout(null);
        frame.setTitle("Sign Up");
        frame.setSize(420,420);
        frame.setVisible(true);
    }

    Account()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==button)
        {
            try
            {
                String name1 = tname.getText();
                tname.setEditable(false);
                tsurname.setEditable(false);
                String sur = tsurname.getText();
                FileWriter writer = new FileWriter(usern+".txt");
                writer.append(pass3+"\n"+money+"\n"+name1+"\n"+sur);
                writer.close();
                frame.dispose();
            }
            catch(Exception w)
            {
                System.out.println("Sex");
            }
        }
    }
}
