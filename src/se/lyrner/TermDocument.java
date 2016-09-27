package se.lyrner;

/**
 * Created by Emil on 2016-08-24.
 */
class TermDocument implements Comparable<TermDocument> {

    private Integer documentId;
    private int termFrequency;
    private double tfidfScore;

    TermDocument(Integer documentId) {
        this.documentId = documentId;
    }

    int incrementTermCount() {
        termFrequency++;
        return termFrequency;
    }

    int getTermFrequency() {
        return termFrequency;
    }

    int getDocumentId() {
        return documentId;
    }

    double getTfidfScore() {
        return tfidfScore;
    }

    void setTfidfScore(double tfidfScore) {
        this.tfidfScore = tfidfScore;
    }

    @Override
    public int compareTo(TermDocument termDocument) {
        double tfidf = termDocument.getTfidfScore();
        if (tfidf > tfidfScore) {
            return 1;
        }
        return tfidf < tfidfScore ? -1 : 0;
    }
}
