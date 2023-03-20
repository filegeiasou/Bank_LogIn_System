package LogIn;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
import java.io.FileNotFoundException;
public class Log extends JFrame implements ActionListener
{
    private JFrame frame;
    private JButton logButton , signButton;
    private JLabel userLabel , passLabel;
    private JTextField userField ;
    private JPasswordField passField;
    private String username , password;
    Log()
    {
        frame = new JFrame("FileBank");
        logButton = new JButton("Log in");
        signButton = new JButton("Sign up");
        userField = new JTextField();
        passField = new JPasswordField();
        userLabel = new JLabel("Username:");
        passLabel = new JLabel("Password:");


        userLabel.setBounds(50, 100, 75, 25);
        passLabel.setBounds(50, 150, 75, 25);
        userField.setBounds(125, 100, 200, 25);
        passField.setBounds(125, 150, 200, 25);
        logButton.setBounds(125, 200, 100, 25);
        signButton.setBounds(225, 200, 100, 25);

        logButton.addActionListener(this);
        signButton.addActionListener(this);

        logButton.setFocusable(false);
        signButton.setFocusable(false);

        frame.add(userLabel);
        frame.add(passLabel);
        frame.add(userField);
        frame.add(passField);



        frame.add(logButton);
        frame.add(signButton);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(new FlowLayout(FlowLayout.LEADING));
        frame.setLayout(null);
        frame.setSize(420,420);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==logButton)
        {
            username = userField.getText();
            password = String.valueOf(passField.getPassword());
            System.out.println(username + " " +  password);
            try
            {
                String filename = username+".txt";
                File myObj = new File(filename);
                if(myObj.exists())
                {
                    Scanner myReader = new Scanner(myObj);
                    String data = myReader.nextLine();
                    String money = myReader.nextLine();//for bank system
                    String name= myReader.nextLine();
                    String surname = myReader.nextLine();
                    System.out.println(data);
                    if(data.equals(password))
                    {
                        new Bank(username,money,password,name,surname); // main page
                        frame.dispose();

                    }
                    else
                    {
                        System.out.println("The Password is no correct");
                        userField.setText("");
                        passField.setText("");
                    }
                    myReader.close();
                }
                else
                {
                    System.out.println("Account");
                }
            }
            catch(FileNotFoundException b)
            {
                System.out.println("This Account does not exist");
                userField.setText("");
                passField.setText("");
            }
        }
        else if(e.getSource()==signButton)
        {
            username = userField.getText();
            password = String.valueOf(passField.getPassword());
            try 
            {
                String filename1=username+".txt";
                File myObj = new File(filename1);
                if (myObj.createNewFile()) 
                {
                  System.out.println("File created: " + myObj.getName());
                  FileWriter my= new FileWriter(filename1);
                  my.write(password+"\n"+"0");
                  my.close();
                  new Account(username , password,"0");
                  userField.setText("");
                  passField.setText("");
                } 
                else 
                {
                  System.out.println("File already exists.");
                  userField.setText("");
                  passField.setText("");

                }
            }
            catch(Exception c)
            {
                System.out.println("BAnana");
                userField.setText("");
                passField.setText("");
            }
        }
    }
}
