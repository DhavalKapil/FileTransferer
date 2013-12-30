/**
 * A socket based program to send a file over the network after dividing it into parts and sending each part separately
 * @author Dhaval Kapil
 * MIT license http://www.opensource.org/licenses/mit-license.php
 */

package dhaval;

class Settings
{   final static String packetSendFile = "temp_send\\pack";
    final static String packetReceiveFile = "temp_receive\\pack";
    final static int noOfPackets = 10;
    final static int port = 9999;
}