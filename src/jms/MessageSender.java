package jms;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.sun.corba.se.impl.orb.ParserTable.TestAcceptor1;

import dto.TestPay;
/**
 * 消息发送器
 * 基于Spring的MessageCreator来创建消息，通过调用JmsTemplate的send方法发送出去
 * @author wangtingliang
 *
 */
public class MessageSender {
	private static final Logger LOG = Logger.getLogger(MessageSender.class);  
	@Resource(name="messageQueue")
	private Queue messageQueue;
    @Autowired
	private JmsTemplate jmsTemplate;  
  
      
//    public void sendMessage(final String message) {  
//        LOG.info("Send message: " + message);  
//        jmsTemplate.send(new MessageCreator() {  //匿名内部类实现MessageCreator接口
//  
//            public Message createMessage(Session session) throws JMSException {  
//                TextMessage textMessage = session.createTextMessage(message);  
//                return textMessage;  
//            }  
//              
//        });  
//    }  
    
    
    //自己编写方法，以此支持多种类型参数
    public void sendMessage(final Object model) {  
    	LOG.info("Send message: " + model);  
    	
    	this.jmsTemplate.convertAndSend(this.messageQueue, model);
    }  
    
}
