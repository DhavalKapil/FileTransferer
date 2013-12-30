package dhaval;

import java.io.*;
import java.net.*;

class Receiver extends Thread
{   private Socket s;
    private FileOutputStream out;
    private FileInputStream in;
    private boolean done;
    Receiver(Socket s, int id)
    throws Exception
    {   this.s = s;
        this.done = false;
        this.out = new FileOutputStream(Settings.packetReceiveFile + id);
        this.in = (FileInputStream)s.getInputStream();
    }
    boolean getDone()
    {   return done;
    }
    public void run()
    {   try
        {   int bytes_read;
            byte[] buffer = new byte[4096];
            while((bytes_read=in.read(buffer))!=-1)
                out.write(buffer, 0, bytes_read);
            in.close();
            out.close();
            s.close();
            this.done = true;
        }
        catch(Exception e)
        {   
        }
    }
}
