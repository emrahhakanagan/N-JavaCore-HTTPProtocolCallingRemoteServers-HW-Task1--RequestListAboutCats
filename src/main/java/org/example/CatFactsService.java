package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CatFactsService {
    private static final String CAT_FACTS_URL = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";
    private static final ObjectMapper mapper = new ObjectMapper();

    public List<CatFact> fetchCatFacts() throws IOException {
        try (CloseableHttpClient httpClient = HttpClientUtil.createHttpClient()) {
            HttpGet request = new HttpGet(CAT_FACTS_URL);
            request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                List<CatFact> catFacts = mapper.readValue(response.getEntity().getContent(), new TypeReference<>() {});
                return catFacts.stream()
                        .filter(fact -> fact.getUpvotes() != null && fact.getUpvotes() > 0)
                        .collect(Collectors.toList());
            }
        }
    }


}
