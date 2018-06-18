package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jms.MessageSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dto.TestPay;

@Controller
public class SendMessageController {
	@Autowired
	MessageSender messageSender;
	
	private int index = 0;
	
	@RequestMapping(value = "/sendMessage.do")
	 public ModelAndView sendMessage(HttpServletRequest request,  
	            HttpServletResponse response) throws Exception {  
	          
	        Map<String, Object> retMap = new HashMap<String, Object>();  
	        String message = request.getParameter("message");  
	        TestPay pay = new TestPay();
	        pay.setName(message);
	        pay.setCode(index + "");
	        pay.setDesc("send");
	        messageSender.sendMessage(pay);  
	        index ++;
	          
	        return new ModelAndView("/success", retMap);  
	    }  
	
	
	@RequestMapping(value = "/testCallPay.do")
	 public void testCallPay(HttpServletRequest request,  
	            HttpServletResponse response) throws Exception {  
	          
		String text = parseJson(request);
		System.out.println(text);
		
		response.getWriter().write("success");
	          
	} 
	
	
	
	/**
	 * 将I/O流按JSON格式转为map对象
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private String parseJson(HttpServletRequest request)
	{
		String jsonStr = "";
		InputStream inputStream = null;
		try {
		     inputStream = request.getInputStream();
		     BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		     StringBuffer buffer = new StringBuffer();
		     String tempOneLine = "";
		     while((tempOneLine = reader.readLine()) != null){
		    	 buffer.append(tempOneLine);
		     }
		     jsonStr = buffer.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			if(null != inputStream){
				try {
					inputStream.close();
					inputStream = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	    return jsonStr;
	}
}
