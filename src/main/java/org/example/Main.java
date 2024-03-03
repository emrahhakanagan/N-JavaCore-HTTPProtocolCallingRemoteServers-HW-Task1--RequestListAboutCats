package org.example;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            CatFactsService service = new CatFactsService();
            List<CatFact> filteredFacts = service.fetchCatFacts();
            filteredFacts.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
