package demo.assets.sms.service;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;

import java.io.IOException;

import org.osgi.service.component.annotations.Component;

import demo.assets.sms.service.api.DemoAssetsSmsService;

/**
 * @author dfrancisco
 */
@Component(
	immediate = true,
	property = {
		// TODO enter required service properties
	},
	service = DemoAssetsSmsService.class
)
public class DemoAssetsSmsServiceImpl implements DemoAssetsSmsService {

	public void sendSMS(String smsText) {
	NexmoClient client = new NexmoClient.Builder()
			  .apiKey("bbfcc11e")
			  .apiSecret("DeIFw6Jph86HWvIY")
			  .build();

			String messageText = smsText;
			TextMessage message = new TextMessage("Vonage APIs", "34645876576", messageText);

			SmsSubmissionResponse response=null;
			try {
				response = client.getSmsClient().submitMessage(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NexmoClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (response!=null) {
			for (SmsSubmissionResponseMessage responseMessage : response.getMessages()) {
			    System.out.println(responseMessage);
			}
			}
	}

}