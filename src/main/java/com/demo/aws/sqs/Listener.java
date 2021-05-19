package com.demo.aws.sqs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;

import org.springframework.stereotype.Component;


@Component(value = "listener")
public class Listener {
	


	    Logger logger= LoggerFactory.getLogger(SpringbootAwsSqsExeApplication.class);

	  
	    @Autowired
	    private MsgRepo msgRepo;

	   
	    @SqsListener("MyQUeue")
	    public void loadMessageFromSQS(String message)  {
	    	if(message != null) {
	    		Msg m = new Msg();
		    	m.setMessage(message);
		    	logger.info("sub1"+message);
		        msgRepo.save(m);
	    		
	    	}
	    }
	    


	}

