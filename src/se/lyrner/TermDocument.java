package se.lyrner;

public class TermDocument implements Comparable<TermDocument> {

    private Integer documentId;
    private int termFrequency;
    private double tfidfScore;

    public TermDocument(Integer documentId) {
        this.documentId = documentId;
    }

    public int incrementTermCount() {
        termFrequency++;
        return termFrequency;
    }

    public int getTermFrequency() {
        return termFrequency;
    }

    public int getDocumentId() {
        return documentId;
    }

    public double getTfidfScore() {
        return tfidfScore;
    }

    public void setTfidfScore(double tfidfScore) {
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
