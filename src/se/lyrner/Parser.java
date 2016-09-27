package se.lyrner;

import java.util.List;

/**
 * Created by Emil on 2016-09-12.
 */
public class Parser {

    public Corpus parseCorpus(String[] documents) {
        Corpus corpus = new Corpus();
        int documentIndex;
        for (documentIndex = 0; documentIndex < documents.length; documentIndex++) {
            String[] tokenizedText = tokenizeText(documents[documentIndex]);
            for (String token : tokenizedText) {
                Term term = corpus.addTerm(token);
                term.increment(documentIndex);
            }
            corpus.setDocumentsLength(tokenizedText.length);
        }
        corpus.setNumberOfDocuments(documentIndex);
        corpus.rankTerms();
        return corpus;
    }

    private String[] tokenizeText(String fileText) {
        fileText = fileText.toLowerCase();
        return fileText.split("[^a-zåäöA-ZÅÄÖ\\d]+");
    }


}
