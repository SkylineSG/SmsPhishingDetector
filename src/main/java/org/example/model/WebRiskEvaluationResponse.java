package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WebRiskEvaluationResponse {

    @JsonProperty("isPhishing")
    private boolean phishing;

    public boolean isPhishing() {
        return phishing;
    }

    public void setPhishing(boolean phishing) {
        this.phishing = phishing;
    }
}
