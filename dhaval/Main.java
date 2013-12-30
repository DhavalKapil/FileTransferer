package dhaval;

import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener
{   private JButton host, join;    
    Main()
    {   JPanel buttonPanel = new JPanel();
        host = new JButton("HOST");
        host.addActionListener(this);
        join = new JButton("JOIN");
        join.addActionListener(this);
        buttonPanel.add(host);
        buttonPanel.add(join);
        this.add(buttonPanel);
    }
    public void actionPerformed(ActionEvent ae)
    {   JButton buttonClicked = (JButton)ae.getSource();
        boolean host_ = false;
        if(buttonClicked.equals(host))
            host_ = true;
        this.setVisible(false);                
        JFrame frame = new ProcessFrame(host_);
        frame.setTitle("File Transferer");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250,70);
        frame.setVisible(true);
    }
    public static void main(String[] args)
    {   try
	{	Thread.sleep(2000);
	}
	catch(Exception e){}
	JFrame frame = new Main();
        frame.setTitle("File Transferer");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250,70);
        frame.setVisible(true);
    }
}