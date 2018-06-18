package jms;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JmsExceptionListener implements ExceptionListener{
 protected Logger logger = LoggerFactory.getLogger(JmsExceptionListener.class);
 
   public JmsExceptionListener() {}
   
   public void onException(JMSException ex) { 
	   ex.printStackTrace();
	   String message = ex.getMessage();
	   this.logger.error(message);
   }
}
