package com.aartek.prestigepoint.util;
import java.util.ArrayList;

import com.aartek.prestigepoint.model.Registration;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
public class Gcm {
	    
	public static void getGcm(Registration registration, Integer amount) {
			 final String gcm =registration.getGcmId();
			 final String firstName =registration.getFirstName();
			 final Double totalFee =registration.getTotalFee();
			 final Integer submittedFee =registration.getSubmittedFee();
			 final Integer emiAmount = amount;

        new Thread(){

            public void run(){
    
                try {
                    //Please add here your project API key: "Key for browser apps (with referers)".
                    //If you added "API key Key for server apps (with IP locking)" or "Key for Android apps (with certificates)" here
                    //then you may get error responses.
                    Sender sender = new  Sender("");
                    // use this to send message with payload data
                    Message message = new Message.Builder()
                    .collapseKey("message")
                    .timeToLive(3)
                    .delayWhileIdle(true)
                    .addData("message", "Dear  "+firstName+"  \nEmi paid " +emiAmount+ "   \nTotalFee  "+totalFee+ "   \nSubmittedFee  " +submittedFee).addData("topic", "") //you can get this message on client side app
                    .build(); 
                    //Use this code to send notification message to a single device
                    Result result = sender.send(message,gcm,
                            1);
                    System.out.println("Message Result: "+result.toString()); //Print message result on console

                    //Use this code to send notification message to multiple devices
                    ArrayList<String> devicesList = new ArrayList<String>();
                    //add your devices RegisterationID, one for each device               
                    devicesList.add(gcm);   

                    //Use this code for multicast messages   
                    MulticastResult multicastResult = sender.send(message, devicesList, 0);
                    System.out.println("Message Result: "+multicastResult.toString());//Print multicast message result on console

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();   
    }

}

