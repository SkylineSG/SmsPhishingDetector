package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WebRiskEvaluationRequest {

    @JsonProperty("url")
    private String url;

    public WebRiskEvaluationRequest(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
