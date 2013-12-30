/**
 * A socket based program to send a file over the network after dividing it into parts and sending each part separately
 * @author Dhaval Kapil
 * MIT license http://www.opensource.org/licenses/mit-license.php
 */

package dhaval;

import javax.swing.*;
import java.net.*;
import java.io.*;

class Worker
{   private boolean sendFile;
    private Thread[] t;
    Worker(boolean host, boolean sendFile)
    {   this.sendFile = sendFile;        
        try
        {   if(!host)
                configureClient();        
            else
                configureServer();
            System.exit(0);
        }
        catch(Exception e){JOptionPane.showMessageDialog(null, e.toString());}
    }
    private void configureClient()
    throws Exception
    {   String ip = JOptionPane.showInputDialog("Please enter the ip address of the host:");
        if(sendFile)
        {   File dir = new File(Settings.packetSendFile.substring(0, Settings.packetSendFile.length() - 4));
            if(!dir.isDirectory())
                dir.mkdir();
            String fileLocation = JOptionPane.showInputDialog("Please enter the location of source file");
            t = new Transmitter[Settings.noOfPackets];
            Packets.divide(new File(fileLocation));
            for(int i = 0;i<Settings.noOfPackets;i++)
            {   Socket s = new Socket(ip, Settings.port);
                t[i] = new Transmitter(s, i);
                t[i].start();            
            }    
            for(int i = 0;i<Settings.noOfPackets;i++)
            {   t[i].join();            
            }  
        }
        else
        {   File dir = new File(Settings.packetReceiveFile.substring(0, Settings.packetReceiveFile.length() - 4));
            if(!dir.isDirectory())
                dir.mkdir();
            String fileLocation = JOptionPane.showInputDialog("Please enter the location of detination file");
            t = new Receiver[Settings.noOfPackets];
            for(int i = 0;i<Settings.noOfPackets;i++)
            {   Socket s = new Socket(ip, Settings.port);
                t[i] = new Receiver(s, i);
                t[i].start();                
            }
            for(int i = 0;i<Settings.noOfPackets;i++)
            {   t[i].join();            
            }
            Packets.conquer(new File(fileLocation));
        }
        JOptionPane.showMessageDialog(null, "Transfer done");
    }
    private void configureServer()
    throws Exception
    {   ServerSocket ss = new ServerSocket(Settings.port);
        if(sendFile)
        {   File dir = new File(Settings.packetSendFile.substring(0, Settings.packetSendFile.length() - 4));
            if(!dir.isDirectory())
                dir.mkdir();
            String fileLocation = JOptionPane.showInputDialog("Please enter the location of source file");
            t = new Transmitter[Settings.noOfPackets];
            Packets.divide(new File(fileLocation));
            for(int i = 0;i<Settings.noOfPackets;i++)
            {   Socket s = ss.accept();
                t[i] = new Transmitter(s, i);
                t[i].start();            
            }  
            for(int i = 0;i<Settings.noOfPackets;i++)
            {   t[i].join();            
            }
        }
        else
        {   File dir = new File(Settings.packetReceiveFile.substring(0, Settings.packetReceiveFile.length() - 4));
            if(!dir.isDirectory())
                dir.mkdir();
            String fileLocation = JOptionPane.showInputDialog("Please enter the location of detination file");
            t = new Receiver[Settings.noOfPackets];            
            for(int i = 0;i<Settings.noOfPackets;i++)
            {   Socket s = ss.accept();
                t[i] = new Receiver(s, i);
                t[i].start();            
            }
            for(int i = 0;i<Settings.noOfPackets;i++)
            {   t[i].join();            
            } 
            Packets.conquer(new File(fileLocation));
        }
        ss.close();
        JOptionPane.showMessageDialog(null, "Transfer done");
    }
}