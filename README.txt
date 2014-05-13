Eric
May 13, 2014
tomorrowsanewday.smile@gmail.com
======================================================================

Repository contents:
---------------------------------

MyClass.java: 	the entire program was written in one class. 
onetimepad.zip:	the NetBeans export of my project. 
MyClass.jar

Project background and interests:
---------------------------------

After thinking about some current events, e.g., Target's compromised 
database, the NSA bribing RSA, Heartbleed, et al., I am beginning to
take security more seriously. 

This small, proof-of-concept program is a stepping stone to another 
project I'm currently working on. Moreover, I intend to on integrating
this program into Mozilla Firefox, as an add-on, if possible. The prog-
ram would make it possible to send enciphered messages, relatively fast,
on social networks, e.g., Facebook, Twitter, et al. And it would even be
great for sending e-mails. However, this time of encryption is not desir-
able for large files - the key size is based entirely on the size of the 
data to be encrypted. Thus, the amount of storage needed to save the key 
for the enciphered messaged may become prohibitive, and counterproductive.

Running the program:
---------------------------------

WARNING! I wrote this program using:
java version "1.7.0_51"
OpenJDK Runtime Environment (IcedTea 2.4.4) (7u51-2.4.4-0ubuntu0.12.04.2)
OpenJDK Server VM (build 24.45-b08, mixed mode)

To find out which version of Jave you are running, issue the command:
java -showversion

Compiling MyClass.java:
------------------------
[1] download the file to a directory of your choice;
[2] open up the temrinal and 'cd' to the directory where MyClass.java is in;
[3] type: javac *.java  OR javac MyClass.java

There are two arguments you may supply when running the program: 
java MyClass -e or java MyClass -d 

java MyClass -e : This will encrypt a message!
----------------------------------------------
issue the command 'java MyClass -e' and press enter, you may begin typing your
message. When you are done with typing out your message an EOF signal needs 
to be issued - on windows CTRL+Z; on Unix/Linux CTRL-D. On my terminal I
have to CTRL-D twice. 

java MyClass -d : This will decipher the message!
-------------------------------------------------
issue the command 'java MyClass -d' and press enter. You may now enter the 
enciphered message and the key used to encipher the message, using the format:

enciphered_messaged : key_used_to_encipher_message

it doesn't matter if there is a newline, or and space, between the colon and both
the enciphered message and the encipher key. I used StringBuilder to read from
the console, thus, all newlines and spaces will be removed anyway.

When you are done with typing out your message an EOF signal needs 
to be issued - on windows CTRL+Z; on Unix/Linux CTRL-D. Again, on my terminal I
have to issue CTRL-D twice. 

Compiling MyClass.jar:
------------------------
[1] download the file to a directory of your choice;
[2] open up the temrinal and 'cd' to the directory where MyClass.jar is located;
[3] type: java -jar MyClass.jar -e or type: java -jar MyClass.jar -e

Running the program using the .jar file is the same as above.

