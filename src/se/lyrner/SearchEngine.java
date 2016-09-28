package se.lyrner;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Emil on 2016-09-27.
 */
class SearchEngine {

    private String[] documents;
    private DecimalFormat df = new DecimalFormat("####0.0000");
    private Corpus corpus;
    private Scanner scanner;

    SearchEngine() {
        System.out.println("Welcome to this super search engine. Please wait while indexing...");

        documents = new FileReader().getDocuments();
        Parser parser = new Parser();
        corpus = parser.parseCorpus(documents);

        System.out.println("Indexing complete.");

        scanner = new Scanner(System.in);
        awaitInput();
    }

    private void awaitInput() {
        while (true) {
            System.out.println("Please enter a one word search term");
            String term = scanner.next();
            search(term);
        }
    }

    private void search(String searchTerm) {
        Term term = corpus.getTerm(searchTerm);
        if (term != null) {
            List<TermDocument> documentIndex = term.getTermDocumentIndex();
            for (TermDocument document : documentIndex) {
                System.out.println("TFIDF: " + df.format(document.getTfidfScore()) + "\ndocument: " + documents[document.getDocumentId()] + "\n");
            }
        } else {
            System.out.println("Your search \"" + searchTerm + "\" did not match any document.");
        }
    }
}
