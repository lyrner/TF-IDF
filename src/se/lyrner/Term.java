package se.lyrner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Emil on 2016-08-24.
 */
public class Term {

    private List<TermDocument> termDocumentIndex = new ArrayList<>();

    public TermDocument newTermDocument(Integer documentId) {
        int index = termDocumentIndex.size() - 1;
        if (index == -1 || termDocumentIndex.get(index).getDocumentId() != documentId) {
            termDocumentIndex.add(new TermDocument(documentId));
        }
        index = termDocumentIndex.size() - 1;
        return termDocumentIndex.get(index);
    }

    public List<TermDocument> getTermDocumentIndex() {
        return termDocumentIndex;
    }

    public void increment(int documentId) {
        newTermDocument(documentId).incrementTermCount();
    }

    public void rankTerm(int numberOfDocuments, List<Integer> documentsLength) {
        double idf = calulateIDF(numberOfDocuments, termDocumentIndex.size());
        for (TermDocument document : termDocumentIndex) {
            double tf = calculateTF(document.getTermFrequency(), documentsLength.get(document.getDocumentId()));
            document.setTfidfScore(calculateTFIDF(tf, idf));
        }
        Collections.sort(termDocumentIndex);
    }

    private double calculateTFIDF(double tf, double idf) {
        return tf * idf;
    }

    private double calulateIDF(int totalNumberOfDocuments, int documentsWithTerm) {
        return Math.log((double) totalNumberOfDocuments/(double) documentsWithTerm);
    }

    private double calculateTF(int documentTermFrequency, int documentTermCount) {
        return ((double) documentTermFrequency/(double) documentTermCount);
    }
}
