package com.demo.aws.sqs;



import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootApplication(exclude = {ContextStackAutoConfiguration.class})
@Async
@RestController
public class SpringbootAwsSqsExeApplication {


    Logger logger= LoggerFactory.getLogger(SpringbootAwsSqsExeApplication.class);

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;
    
    
    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;

    
    @PostMapping(value = "/posts")
    public ResponseEntity<Msg> createPost(HttpServletRequest request,
                                        UriComponentsBuilder uriComponentsBuilder) {
    	
    	try {
//    		Msg m = new Msg();
//        	m.setMessage(request.getParameter("msg"));
        	queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(request.getParameter("msg")).build());							
        	
        	
//        	UriComponents uriComponents =
//                    uriComponentsBuilder.path("/posts/{id}").buildAndExpand(m.getId());
//            URI location = uriComponents.toUri();
           return ResponseEntity.created(null).build();
            
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    	

    	
    }
    


    public static void main(String[] args) {
        SpringApplication.run(SpringbootAwsSqsExeApplication.class, args);
        
    }

}
