package se.lyrner;

import java.util.*;

/**
 * Created by Emil on 2016-08-24.
 */
public class Corpus {

    private int numberOfDocuments;
    private List<Integer> documentsLength = new ArrayList<Integer>();
    private Map<String, Term> termIndex = new HashMap<String, Term>();

    public Corpus() {

    }

    public Term getTerm(String term) {
        if (!termIndex.containsKey(term)) {
            termIndex.put(term, new Term(term));
        }
        return termIndex.get(term);
    }

    public Term searchCorpus(String term) {
        return termIndex.get(term);
    }

    public void setNumberOfDocuments(int numberOfDocuments) {
        this.numberOfDocuments = numberOfDocuments;
    }

    public int getNumberOfDocuments() {
        return numberOfDocuments;
    }

    public void setDocumentsLength(int length) {
        documentsLength.add(length);
    }

    public Integer getDocumentLength(int documentIndex) {
        return documentsLength.get(documentIndex);
    }

    public void rankTerms() {
        Iterator terms = termIndex.entrySet().iterator();
        while (terms.hasNext()) {
            Map.Entry pair = (Map.Entry)terms.next();
            Term term = (Term) pair.getValue();
            term.rankTerm(numberOfDocuments, documentsLength);
        }
    }
}
