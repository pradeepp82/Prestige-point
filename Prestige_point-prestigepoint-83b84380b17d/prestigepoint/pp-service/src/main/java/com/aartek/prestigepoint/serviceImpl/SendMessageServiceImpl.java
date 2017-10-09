package com.aartek.prestigepoint.serviceImpl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.Batch;
import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.repository.RegistrationRepository;
import com.aartek.prestigepoint.service.SendMessageService;

@Service
public class SendMessageServiceImpl implements SendMessageService {

	@Autowired
	private RegistrationRepository registrationRepository;

	/*@Autowired
	private SendMessageRepository sendMessageRepository;*/

	public List<Batch> getAllStudentList(Batch batch) {
		List<Registration> studentList = new ArrayList<Registration>();
		studentList = registrationRepository.getBatchWiseStudentDetails(batch
				.getBatchId());
		// studentList =
		// sendMessageRepository.getBatchWiseStudentDetails(batch.getBatchId());
		//studentList.get(0).getContact();

        /*String recipient = "918120989865";
        String message =  "helloneha";*/
       

       /* try {
			String requestUrl  = "https://instantalerts.co/api/web/send/?apikey=62q3z3hs4941mve32s9kf10fa5074n76&sender=prestigepoint&" +
								
								 
								 "&recipient=" + URLEncoder.encode(recipient, "UTF-8") +
								 "&messagetype=SMS:TEXT" +
								 "&messagedata=" + URLEncoder.encode(message, "UTF-8") +
								
								 "&serviceprovider=GSMModem1" +
								 "&responseformat=html";
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/


		
		
		
		String message = batch.getMessageText();
		String mNo = "918120989865";
		
		
		
		

		try {
			URL myURL = new URL("https://instantalerts.co/api/web/send/?apikey=62q3z3hs4941mve32s9kf10fa5074n76&sender=prestigepoint&to="
							+ mNo + "&message=" + message + "");
			URLConnection myURLConnection = myURL.openConnection();
			myURLConnection.connect();


           

		} catch (MalformedURLException e) {
			// new URL() failed
			// ...
		} catch (IOException e) {

            System.out.println(e.getMessage());
		}
		return null;
	}

}
