package org.example.model;

import lombok.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class PhishingChecker {

        @Value("${google.webrisk.api.key}")
        private String apiKey;

        private final RestTemplate restTemplate;

        public PhishingChecker(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        public boolean isPhishingURL(String url) {
            try {
                HttpHeaders headers = new HttpHeaders();
                headers.set("x-api-key", apiKey);
                headers.setContentType(MediaType.APPLICATION_JSON);

                WebRiskEvaluationRequest request = new WebRiskEvaluationRequest(url);

                HttpEntity<WebRiskEvaluationRequest> requestEntity = new HttpEntity<>(request, headers);

                ResponseEntity<WebRiskEvaluationResponse> responseEntity = restTemplate.exchange(
                        "https://cloud.google.com/web-risk/docs/reference/rest/v1eap1/TopLevel/evaluateUri",
                        HttpMethod.POST,
                        requestEntity,
                        WebRiskEvaluationResponse.class
                );

                if (responseEntity.getStatusCode() == HttpStatus.OK) {
                    WebRiskEvaluationResponse response = responseEntity.getBody();

                    if (response != null && response.isPhishing()) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }
    }
