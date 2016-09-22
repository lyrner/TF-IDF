package se.lyrner;

public class TermDocument {

    private Integer documentId;
    private int documentFrequency;

    public TermDocument(Integer documentId) {
        this.documentId = documentId;
    }

    public int incrementTermCount() {
        documentFrequency++;
        return documentFrequency;
    }

    public int getDocumentId() {
        return documentId;
    }
}
