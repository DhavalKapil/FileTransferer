package dhaval;

import java.io.*;
import java.net.*;

class Transmitter extends Thread
{   private Socket s;
    private FileOutputStream out;
    private FileInputStream in;
    private boolean done;
    Transmitter(Socket s, int id)
    throws Exception
    {   this.done = false;
        this.s = s;
        this.out = (FileOutputStream)s.getOutputStream();
        this.in = new FileInputStream(Settings.packetSendFile + id);
    }
    public boolean getDone()
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
        {   System.out.println(e);
        }
    }
}
