package se.lyrner;

import java.util.ArrayList;

/**
 * Created by Emil on 2016-08-24.
 */
public class Term {

    private String term;
    private ArrayList<TermDocument> termDocumentIndex = new ArrayList<>();

    public Term(String term) {
        this.term = term;
    }

    public void newTermDocument(Integer documentId, Integer termCount) {
        termDocumentIndex.add(new TermDocument(documentId, termCount));
    }

    public Integer increment(Integer documentId) {
        return termDocumentIndex.get(documentId).incrementTermCount();
    }
}
