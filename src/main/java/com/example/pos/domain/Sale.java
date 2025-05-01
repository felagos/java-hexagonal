package com.example.pos.domain;

import java.time.LocalDateTime;
import java.util.List;

public record Sale(Integer id, LocalDateTime date, Double total, List<Concept> concepts) {

    public Sale(LocalDateTime date, List<Concept> concepts) {
        this(null, date, calculateTotal(concepts), concepts);
    }

    private static Double calculateTotal(List<Concept> concepts) {
        return concepts.stream().reduce(0.0, (acc, concept) -> acc + concept.price(), Double::sum);
    }

    private Boolean hasTotal() {
        return this.total != null && this.total > 0;
    }

    private Boolean hasConcepts() {
        return !this.concepts.isEmpty();
    }

    public Boolean isValid() {
        return this.hasTotal() && this.hasConcepts();
    }
}
