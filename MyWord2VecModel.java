import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.text.sentenceiterator.LineSentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentencePreProcessor;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;

public class MyWord2VecModel {

    private static Logger log = LoggerFactory.getLogger(MyWord2VecModel.class);
    public static void main(String[] args) throws FileNotFoundException {



        // Gets Path to Text file
        SentenceIterator iter = new LineSentenceIterator(new File("ARCHEAGE_raw.txt"));
        iter.setPreProcessor(new SentencePreProcessor() {
            public String preProcess(String sentence) {
                return sentence.toLowerCase();
            }
        });

        log.info("Load & Vectorize Sentences....");
        // Split on white spaces in the line to get words
        TokenizerFactory t = new DefaultTokenizerFactory();


        /*
            CommonPreprocessor will apply the following regex to each token: [\d\.:,"'\(\)\[\]|/?!;]+
            So, effectively all numbers, punctuation symbols and some special symbols are stripped off.
            Additionally it forces lower case for all tokens.
         */
        t.setTokenPreProcessor(new CommonPreprocessor());


        Word2Vec vec = new Word2Vec.Builder()
            .minWordFrequency(1) // discard words that appear less than the times of set value
            .iterations(1)       // number of iterations done for each mini-batch during training
            .layerSize(100)        // size of word vectors
            .seed(42)
            .windowSize(10)         // set max skip length between words
            .iterate(iter)
            .tokenizerFactory(t)
            .build();

        log.info("Fitting Word2Vec model....");
        int nEpochs = 1; // //Number of epochs (full passes of training data) to train on
        for (int i = 0; i < nEpochs; i++) {
            vec.fit();
        }


        WordVectorSerializer.writeFullModel(vec, "pathToSaveModelArcheage.txt");

        WordVectorSerializer.loadFullModel("pathToSaveModelArcheage.txt");


        Collection<String> lst = vec.wordsNearest("game", 10);
        System.out.println(lst);

        double cosSim = vec.similarity("mobile", "game");
        System.out.println(cosSim);


        //SerializationUtils.saveObject(vec, new File("complex_vector.txt")); // Alternative version to save model vector

    }
}

