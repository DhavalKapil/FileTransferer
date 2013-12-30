package dhaval;

import java.io.*;

public class Packets
{   static void divide(File f)
    throws Exception
    {   FileInputStream in = new FileInputStream(f);
        long length = f.length();
        long limit = length/10;
        int bytes_read;
        long total_bytes = 0;
        byte[] buffer = new byte[4096];
        for(int i = 0;i<10;i++)
        {   FileOutputStream out = new FileOutputStream(Settings.packetSendFile + i);
            while((bytes_read=in.read(buffer))!=-1)
            {   out.write(buffer, 0, bytes_read);
                total_bytes += bytes_read;
                if(total_bytes>limit)
                break;            
            }        
            out.close();
            total_bytes = 0;
        }
        in.close();
    }
    static void conquer(File f)
    throws Exception
    {   FileOutputStream out = new FileOutputStream(f);
        int bytes_read;
        byte[] buffer = new byte[4096];
        for(int i = 0;i<10;i++)
        {   FileInputStream in = new FileInputStream(Settings.packetReceiveFile + i);
            while((bytes_read=in.read(buffer))!=-1)
            {   out.write(buffer, 0, bytes_read);                      
            }
            in.close();
        }
        out.close();
    }   
}