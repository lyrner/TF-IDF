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
        return termIndex.putIfAbsent(term, new Term(term));
    }

    public Term searchCorpus(String term) {
        return termIndex.get(term);
    }
}
