FileTransferer
==============

A socket based program to send a file over the network after dividing it into parts and sending each part separately

<h3>Description:</h3>
A simple file transfer program developed around 2011 by me as a replacement of the usual method using e-mail.
<ol>
<li>E-mail has a limit on the file size that can be sent</li>
<li>While e-mailing one user uploads the file and after that the other one downloads</li>
</ol>
Both these restrictions do not operate in this program. Any file can be sent and as one user uploads, the other one downloads simultaneously. Also it divides the file into packets and sends each one individually over the network.

<h3>License:</h3>
MIT license http://www.opensource.org/licenses/mit-license.php

<h3>Working:</h3>
First compile the .java files and create the jar file:<br><br>
jar -cvmf MANIFEST.MF FileTransferer.jar dhaval LICENSE README.md splash.png<br><br>
Simply run the jar file. One user chooses to host and the other one join.
Note: temp directories are created relative to the jar file.
