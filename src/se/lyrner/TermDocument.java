package se.lyrner;

public class TermDocument {

    private Integer documentId;
    private Integer termCount;

    public TermDocument(Integer documentId, Integer termCount) {
        this.documentId = documentId;
        this.termCount = termCount;
    }

    public Integer incrementTermCount() {
        termCount++;
        return termCount;
    }
}
