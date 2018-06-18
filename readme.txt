通过tomcat运行时，注意：
1.在Tomcat的conf/context.xml中的<Context>元素里面需要加上如下配置：
  	<Resource name="myJMS/ConnectionFactory"   
    auth="Container"     
    type="org.apache.activemq.ActiveMQConnectionFactory"   
    description="JMS Connection Factory"  
    factory="org.apache.activemq.jndi.JNDIReferenceFactory"   
    brokerURL="tcp://localhost:61616"   
    brokerName="MyActiveMQBroker"/>  
  
	<Resource name="myJMS/MessageQueue"   
    auth="Container"   
    type="org.apache.activemq.command.ActiveMQQueue"  
    description="My Message Queue"  
    factory="org.apache.activemq.jndi.JNDIReferenceFactory"   
    physicalName="MyMessageQueue"/>
2.tomcat的lib包中需加入activeMQ的jar包；
3.启动tomcat前，要先启动activeMQ服务。
4.访问地址：http://localhost:[port]