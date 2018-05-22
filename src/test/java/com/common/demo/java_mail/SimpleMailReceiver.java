package com.common.demo.java_mail;

import javax.mail.*;
import java.util.Properties;

/**
 * 简单的邮件接收类
 *
 * @author athena
 */
public class SimpleMailReceiver {

    /**
     * 收取收件箱里的邮件
     *
     * @param props         为邮件连接所需的必要属性
     * @param authenticator 用户验证器
     * @return Message数组（邮件数组）
     */
    public static Message[] fetchInbox(Properties props, Authenticator authenticator) {
        return fetchInbox(props, authenticator, null);
    }

    /**
     * 收取收件箱里的邮件
     *
     * @param props         收取收件箱里的邮件
     * @param authenticator 用户验证器
     * @param protocol      使用的收取邮件协议，有两个值"pop3"或者"imap"
     * @return Message数组（邮件数组）
     */
    public static Message[] fetchInbox(Properties props, Authenticator authenticator, String protocol) {
        Message[] messages = null;
        Session session = Session.getDefaultInstance(props, authenticator);
        // session.setDebug(true);
        Store store;
        Folder folder;
        try {
            store = protocol == null || protocol.trim().length() == 0 ? session.getStore() : session.getStore(protocol);
            store.connect();
            folder = store.getFolder("INBOX");// 获取收件箱
            folder.open(Folder.READ_ONLY); // 以只读方式打开
            messages = folder.getMessages();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return messages;
    }
}
