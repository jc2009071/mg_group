package com.master.group.application;

import com.master.group.application.bean.Credential;
import com.master.group.application.proxy.MasterGroupApiProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class Application{
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    private MasterGroupApiProxy masterGroupApiProxy;

    @Autowired
    public Application(MasterGroupApiProxy masterGroupApiProxy){
        this.masterGroupApiProxy = masterGroupApiProxy;
        this.init();
    }

    public void init(){
        // Get Messages by id
        this.masterGroupApiProxy.getMessageById(1).getBody();
        // Get Messages by tag
        this.masterGroupApiProxy.getMessageByTag("Tag").getBody();
        // Save Credential
        this.masterGroupApiProxy.saveCredential(new Credential("6712","skajhksjhKJAKHm198a"));
        // Save Credential
        this.masterGroupApiProxy.getCredentials();

    }

    public static void main(String args[]){
        SpringApplication.run(Application.class);
    }
}
