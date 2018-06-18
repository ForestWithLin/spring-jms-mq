package jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
/**
 * 我们使用Spring的org.springframework.jms.listener.DefaultMessageListenerContainer来收集消息，
 * 通过设置一个消息监听器，具体实现类为demo.ReceiveMessageListener
 * @author wangtingliang
 *
 */
public class ReceiveMessageListener implements MessageListener {
	private static final Logger LOG = Logger.getLogger(ReceiveMessageListener.class);  
   
	@Override
    public void onMessage(Message message) {  
        if (message instanceof TextMessage) {  
            TextMessage text = (TextMessage) message;  
            try {  
                LOG.info("Received textMessage:" + text.getText());  
            } catch (JMSException e) {  
                e.printStackTrace();  
            }  
        }  
        if (message instanceof ObjectMessage) {  
        	ObjectMessage text = (ObjectMessage) message;  
        	try {
				LOG.info("Received objectMessage:" + text.getObject());
			} catch (JMSException e) {
				e.printStackTrace();
			}  
        }  
    }  

}
