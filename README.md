install
        java -version
        javac -version

  git clone https://github.com/Syed-Sameer-Ahemed/Chat-Application-Java-Sockets-.git

  Step 1: Start the Chat Server

  go to this source cd ChatApplication/server/src


javac com/chatapp/server/*.java
java com.chatapp.server.ServerMain

     
Step 2: Compile the Chat Client (GUI)

 go to this source cd ChatApplication/client/src

javac com/chatapp/client/ChatClient.java
javac com/chatapp/client/ui/*.java
java com.chatapp.client.ui.LoginFrame
