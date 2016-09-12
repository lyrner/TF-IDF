package se.lyrner;

/**
 * Created by Emil on 2016-09-12.
 */
public class Parser {

    private String[] fakeFiles = {
            "Resultat från tävlingarna i backhoppning vid olympiska vinterspelen 1988. lagtävling i backhoppning arrangerades för första gången i OS-sammanhang.",
            "Gus Lesnevich, egentligen Gustav George Lesnevich, amerikansk proffsboxare, född i Cliffside Park, New Jersey 22 februari 1915, död 28 februari 1964. Världsmästare i lätt tungvikt 1946-48. Lesnevichs professionella boxarkarriär varade 1934-49. Han började den i mellanvikt och gjorde snabba framsteg. Endast en förlust noterades på de 30 första matcherna. Men 1936 ställdes han mot The Tacoma Assassin Freddie Steele, regerande världsmästare i mellanvikt, som gjorde processen kort med uppkomlingen. Redan i andra ronden slängde Lesnevichs tränare in handduken. Förlusten stärkte inte Lesnevichs självförtroende och redan 1937 åkte han på en knockoutförlust mot f d världsmästaren i weltervikt Young Corbett III som gått upp i mellanvikt.",
            "Partha Chatterjees forskning har främst gällt nationalismens utveckling i tredje världen, särskilt Asien, och han har utgett flera böcker kring dessa frågor. I The Nation and Its Fragments (1993) analyserar han nationalismens roll i Indiens historiska utveckling, ett arbete som han grundlade med sin studie av Bengal 1920-1947: The Land Question (1984). Partha Chatterjees mest kända bok är Nationalist Thought and the Colonial World: A Derivative Discourse (1986). Boken handlar, som titeln anger, om nationalismen i den koloniala världen, men i praktiken kretsar det mesta av den kring nationalismen i Indien. Vad Partha Chatterjee i själva verket gör är att han skildrar övergången från en kolonial till en postkolonial stat under 1900-talet, en övergång som han anser har giltighet inte bara för Indien utan också för andra postkoloniala samhällen. Partha Chatterjee tänker sig att denna övergång schematiskt sker i tre stadier eller faser: uppbrottets, manövrerandets och ankomstens.",
            "Informationssökning innebär inom informationsteknik att information i datorlagrad form söks ut med hjälp av olika tekniker och teknologier. Informationssökning levererar en mängd dokumentreferenser till användare för vidare urval. Sökmotorer är den kanske vanligaste tillämpningen av informationssökningsteknologi. Informationssökningssystem har traditionellt delats in i booleska system och probabilistiska system. Båda typerna av informationsökningssystem är byggda med algoritmer grundar sig på att ord i text är lätta att identifiera och räkna. De första någorlunda systematiska formella ansatserna att använda ordstatistik publicerades i slutet av 1950-talet av pionjärern Hans-Peter Luhn [1]. Tanken är att ord som har rimlig förekomststatistik är mest informativa i en text: de vanligaste orden i en text är inte innehållsbärande (\"och\", \"att\", \"det\" \"är\") och de ovanliga mest slumpmässiga förekomster eller brus.",
            "Brunbjörnen känns igen på sitt stora huvud, små ögon och öron samt puckeln över frambogen/skulderpartiet. Pälsen är tjock och färgen varierar från ljusbrun till mörkbrun, även brungrå päls kan förekomma. Yngre björnar har ofta en ljusare halsbandslik teckning runt halsen. Brunbjörnen har sommar- och vinterpäls och byter dessa under senvåren respektive tidig höst.[2] Brunbjörnen uppvisar en rad lokala variationer över sitt stora utbredningsområde vad gäller storlek, vikt, skallform och färg på päls. Generellt kan man säga att brunbjörnen är större ju längre norrut den förekommer. För lokala morfologiska variationer se Underarter. I en normalt byggd individ har den en längd, från nos till svansrot, mellan 1,7 till 2,8 meter och en mankhöjd på cirka 90 till 150 centimeter. Vikten varierar beroende på årstid, men är som störst på hösten innan vintersömnen. Vikten för en hanne är normalt 100–300 kg, för en hona 60–200 kg. Den största svenska björnen vägde 343 kg."
    };

    public Parser() {

    }

    public String[] getDocuments() {
        return fakeFiles;
    }

    public Corpus parseCorpus() {
        Corpus corpus = new Corpus();

        for (int i = 0; i < fakeFiles.length; i++) {
            String[] tokenizedText = tokenizeText(fakeFiles[i]);
            for (String token : tokenizedText) {
                Term term = corpus.addNewTerm(token);
                term.increment(i);
            }
        }



        return corpus;
    }

    private String[] tokenizeText(String fileText) {
        fileText = fileText.toLowerCase();
        return fileText.split("[^a-zåäöA-ZÅÄÖ\\d]+");
    }


}
