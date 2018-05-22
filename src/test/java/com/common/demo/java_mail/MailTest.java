package com.common.demo.java_mail;

/**
 * 邮件测试类
 *
 * @author athena
 */
public class MailTest {

    public static void main(String[] args) {
        MessageParser.parse(SimpleMailReceiver.fetchInbox(HostType.NETEASE.getProperties(),
                AuthenticatorGenerator.getAuthenticator("zhyd704@126.com", "zhydaimm704")));
    }
}
