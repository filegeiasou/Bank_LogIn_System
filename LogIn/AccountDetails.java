package LogIn;
import javax.swing.*;
import java.awt.*;
public class AccountDetails extends JFrame
{
    private JLabel name , surname , username , password , gender ;
    private TextField tname,tsurname,tusername,tpassword; 
    private JFrame frame;
    private JRadioButton male,female;
    private ButtonGroup group;
    AccountDetails(String username3 , String password3 , String name3 , String surname3)
    {

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


        tname = new TextField(name3+" ");
        tsurname = new TextField(surname3+" ");
        tusername = new TextField(username3+" ");
        tpassword = new TextField(password3+" ");

        tname.setEditable(false);
        tsurname.setEditable(false);
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
        frame.setTitle("Account Details");
        frame.setSize(420,420);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
