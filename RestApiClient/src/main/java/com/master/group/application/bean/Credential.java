package com.master.group.application.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Credential {
    private String key;
    @JsonProperty("shared_secret")
    private String sharedSecret;

    public Credential() { }

    public Credential(String key, String sharedSecret) {
        this.key = key;
        this.sharedSecret = sharedSecret;
    }
}
