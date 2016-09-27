package se.lyrner;

import java.util.*;

/**
 * Created by Emil on 2016-08-24.
 */
class Corpus {

    private int numberOfDocuments;
    private List<Integer> documentsLength = new ArrayList<>();
    private Map<String, Term> termIndex = new HashMap<>();

    Term addTerm(String term) {
        if (!termIndex.containsKey(term)) {
            termIndex.put(term, new Term());
        }
        return termIndex.get(term);
    }

    Term getTerm(String term) {
        return termIndex.get(term);
    }

    void setNumberOfDocuments(int numberOfDocuments) {
        this.numberOfDocuments = numberOfDocuments;
    }

    void setDocumentsLength(int length) {
        documentsLength.add(length);
    }

    void rankTerms() {
        for (Map.Entry pair : termIndex.entrySet()) {
            Term term = (Term) pair.getValue();
            term.rankTerm(numberOfDocuments, documentsLength);
        }
    }
}
