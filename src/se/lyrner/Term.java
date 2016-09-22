package se.lyrner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Emil on 2016-08-24.
 */
public class Term {

    private String term;
    private int corpusTermFrequency;
    private Map<Integer, TermDocument> termDocumentIndex = new HashMap<Integer, TermDocument>();

    public Term(String term) {
        this.term = term;
    }

    public TermDocument getTermDocument(Integer documentId) {
        if (!termDocumentIndex.containsKey(documentId)) {
            termDocumentIndex.put(documentId, new TermDocument(documentId));
        }
        return termDocumentIndex.get(documentId);
    }

    public void increment(int documentId) {
        getTermDocument(documentId).incrementTermCount();
        corpusTermFrequency = corpusTermFrequency++;
    }
}
