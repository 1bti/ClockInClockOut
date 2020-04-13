package multithreadedserver;

import java.io.*;
import java.net.Socket;

class ServerClientThread extends Thread {
	
	  Socket serverClient;
	  int clientNo;
	  int squre;
	  String url = "https://rollins.okta.com/login/login.htm?fromURI=%2Fhome%2Frollinscollege_timeclockplus_1%2F0oa1t9fmp5CiaW4J9357%2Faln1t9kgat2oTrfaq357";
	  String username = "";
	  String password = "";
	  String action = "";
	  ServerClientThread(Socket inSocket,int counter){
	    serverClient = inSocket;
	    clientNo=counter;
	  }
	  public void run(){
	    try{
	      DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
	      DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
	      String clientMessage="", serverMessage="";
	      while(!clientMessage.equals("bye")){
	        clientMessage=inStream.readUTF();
	        System.out.println("From Client-" +clientNo+ ": Username is :"+clientMessage);
	        username = clientMessage;
	        clientMessage=inStream.readUTF();
	        System.out.println("From Client-" +clientNo+ ": Password is :"+clientMessage);
	        password = clientMessage;
	        clientMessage=inStream.readUTF();
	        serverMessage="Info recieved.";
	        outStream.writeUTF(serverMessage);
	        outStream.flush();
	        if(clientMessage.equals("1")) {
	        	System.out.println("From Client-" +clientNo+ ": Action is :Clock In");
		        action = clientMessage;
		        Clock.clockin(url,username,password);
	        }
	        else {
	        	System.out.println("From Client-" +clientNo+ ": Action is :Clock Out");
		        action = clientMessage;
		        Clock.clockout(url,username, password);
	        }
			serverMessage="Action Completed.";
	        outStream.writeUTF(serverMessage);
	        outStream.flush();
	      }
	      inStream.close();
	      outStream.close();
	      serverClient.close();
	    }catch(Exception ex){
	      System.out.println(ex);
	    }finally{
	      System.out.println("Client -" + clientNo + " exit!! ");
	    }
	  }
	}