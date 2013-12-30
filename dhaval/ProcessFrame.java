package dhaval;

import javax.swing.*;
import java.awt.event.*;

public class ProcessFrame extends JFrame implements ActionListener
{   JButton send, receive; 
    private boolean host;   
    ProcessFrame(boolean host)
    {   JPanel buttonPanel = new JPanel();
        send = new JButton("SEND FILE");
        send.addActionListener(this);
        receive = new JButton("RECEIVE FILE");
        receive.addActionListener(this);
        buttonPanel.add(send);
        buttonPanel.add(receive);
        this.host = host;
        this.add(buttonPanel);
    }
    public void actionPerformed(ActionEvent ae)
    {   JButton buttonClicked = (JButton)ae.getSource();
        boolean sendFile = false;
        if(buttonClicked.equals(send))
            sendFile = true;
        this.setVisible(false);
        Worker w = new Worker(host, sendFile);
    }   
}