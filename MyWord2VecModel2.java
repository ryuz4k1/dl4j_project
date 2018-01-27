import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.text.sentenceiterator.FileSentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.deeplearning4j.util.SerializationUtils;
import org.nd4j.linalg.factory.Nd4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class MyWord2VecModel2 {

    private static Logger log = LoggerFactory.getLogger(MyWord2VecModel.class);
    public static void main(String[] args) throws IOException {



        File file = new File("ARCHEAGE_raw.txt");
        SentenceIterator iter = new FileSentenceIterator(file);

        TokenizerFactory t = new DefaultTokenizerFactory();

        int layerSize = 300;


        Word2Vec vec = new Word2Vec.Builder().sampling(1e-5)
            .minWordFrequency(5) // discard words that appear less than the times of set value
            .batchSize(1000)
            .useAdaGrad(false)
            .layerSize(layerSize)   // size of word vectors
            .iterations(3)     // number of iterations done for each mini-batch during training
            .learningRate(0.025)
            .minLearningRate(1e-2)
            .negativeSample(10)
            .iterate(iter)
            .tokenizerFactory(t)
            .build();

        log.info("Fitting Word2Vec model....");
        vec.fit();

        Nd4j.ENFORCE_NUMERICAL_STABILITY = true;



        SerializationUtils.saveObject(vec,new File("w2vectors_archeage.ser"));
        WordVectorSerializer.writeWordVectors(vec,"w2vectors_archeage.txt");


        double sim = vec.similarity("mobile", "game");
        System.out.println("Similarity between mobile and game " + sim);
        Collection<String> similar = vec.wordsNearest("game", 10);
        System.out.println(similar);


    }
}

