package com.master.group.application.proxy;

import com.master.group.application.bean.Credential;
import com.master.group.application.bean.Message;
import com.master.group.application.configuration.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class MasterGroupApiProxy {
    private final RestTemplate restClient;
    private ApplicationProperties applicationProperties;

    @Autowired
    public MasterGroupApiProxy(ApplicationProperties applicationProperties){
        restClient = new RestTemplate();
        this.applicationProperties = applicationProperties;
    }

    public ResponseEntity<List<Message>> getMessageByTag(String tagName){
        ResponseEntity<List<Message>> response = restClient.exchange(
                String.format(this.applicationProperties.getRest().getApiUri().concat("Message/%s"), tagName),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Message>>(){}
        );
        return response;
    }

    public ResponseEntity<List<Message>> getMessageById(int id){
        ResponseEntity<List<Message>> response = restClient.exchange(
                String.format(this.applicationProperties.getRest().getApiUri().concat("Message/%d"), id),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Message>>(){}
        );
        return response;
    }

    public ResponseEntity<List<Credential>> getCredentials(){
        ResponseEntity<List<Credential>> response = restClient.exchange(
                this.applicationProperties.getRest().getApiUri().concat("Credential/"),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Credential>>(){}
        );
        return response;
    }

    public void saveCredential(Credential credential){
        this.restClient.put(
                this.applicationProperties.getRest().getApiUri().concat("Credential/"),
                credential
        );
    }
}
