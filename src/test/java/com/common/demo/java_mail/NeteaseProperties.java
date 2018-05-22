package com.common.demo.java_mail;

import java.util.Properties;

public class NeteaseProperties extends Properties {

    private static final long serialVersionUID = -6623862312603756003L;

    {
        defaults = new Properties();
        defaults.put("mail.pop3.host", "pop.163.com");
        defaults.put("mail.imap.host", "imap.163.com");
        defaults.put("mail.store.protocol", "pop3"); // 默认使用pop3收取邮件
    }

}
