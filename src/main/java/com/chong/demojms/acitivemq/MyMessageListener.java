package com.chong.demojms.acitivemq;


import javax.jms.*;

public class MyMessageListener implements MessageListener {


    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            //这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换，或者直接把onMessage方法的参数改成Message的子类TextMessage
            TextMessage textMsg = (TextMessage) message;
            System.out.println("接收到一个纯文本消息。");
            try {
                System.out.println("消息内容是：" + textMsg.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        } else if (message instanceof MapMessage) {
            MapMessage mapMessage = (MapMessage) message;
        } else if (message instanceof ObjectMessage) {
            ObjectMessage objMessage = (ObjectMessage) message;
            try {
				Object obj = objMessage.getObject();
                System.out.println("接收到一个ObjectMessage，包含Email对象。");
                System.out.println(obj);
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }
    }

}
