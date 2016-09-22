package se.lyrner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Emil on 2016-08-24.
 */
public class Corpus {

    private int numberOfDocuments;
    private Map<String, Term> termIndex = new HashMap<String, Term>();

    public Corpus() {

    }

    public Term addNewTerm(String term) {
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
}
