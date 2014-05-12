/**
 * A socket based program to send a file over the network after dividing it into parts and sending each part separately
 * @author Dhaval Kapil
 * MIT license http://www.opensource.org/licenses/mit-license.php
 */

package dhaval;

import java.io.*;

class Settings
{   final static String packetSendFile = "temp_send" + File.separator + "pack";
    final static String packetReceiveFile = "temp_receive" + File.separator + "pack";
    final static int noOfPackets = 10;
    final static int port = 9999;
}