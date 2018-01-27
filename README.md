# Twitter Sentiment Analysis


# INTRODUCTION AND PURPOSE
The purpose of this project is to apply sentiment analysis on a dataset that is given. Our datasets are tweets about  Archeage, Hobbit and
Iphone6. As feature extractor CNN model and Word2Vec model (Enchanced with GoogleNews); as classifier Evaluation class; to seperate the 
dataset into multiple files, (our own program) DataSeperator is used.


# EQUIPMENTS
Display Adapter : Intel HD Graphics 4600 
Current Displaying Mode : 1366x768, 32-bit, 59Hz
IDE: Intellij 2017.2.6
JDK: 1.8.0_144
Project Management Tool : Apache-maven-3.5.2 


# METHODS


# WHAT IS CNN?	

In machine learning, a convolutional neural network (CNN, or ConvNet) is a class of deep, feed-forward artificial neural networksthat 
has 
successfully been applied to analyzing visual imagery.

A ConvNet arranges its neurons in three dimensions (width, height, depth), as visualized in one of the layers. Every layer of a ConvNet 
transforms the 3D input volume to a 3D output volume of neuron activations. In this example, the red input layer holds the image, so its 
width and height would be the dimensions of the image, and the depth would be 3.


# WHAT IS WORD2VEC?

•	word2vec is a group of Deep Learning models developed by Google with.The aim of capturing the context of words while at the same time 
proposing a very efficient way of preprocessing raw text data. 
•	This model takes as input a large corpus of documents like tweets or news articles and generates a vector space of typically several 
hundred dimensions. Each word in the corpus is being assigned a unique vector in the vector space. 
•	The powerful concept behind word2vec is that word vectors that are close to each other in the vector space represent words that are 
not only of the same meaning but of the same context as well. Since word2vec relies on Deep Neural Nets to detect patterns, we can rely 
on it to detect multiple features on different levels of abstractions. 
•	On a more general level, word2vec embeds non trivial semantic and syntactic relationships between words. This results in preserving a 
rich context. 
•	The purpose and usefulness of Word2vec is to group the vectors of similar words together in vectorspace. That is, it detects 
similarities mathematically. 
•	Word2vec creates vectors that are distributed numerical representations of word features, features such as the context of individual 
words. 
•	It does so without human intervention. 
•	Works similar with gene2vec, like2vec and follower2vec.



# DATASEPERATOR CLASS

To have more efficient outputs faster (due to the sentence based working principle of Word2vec) , a program is coded by us to split a 
whole dataset into multiple text files.
After the usage of DataSeperator, the output data is manually splitted into two categories which are Train and Test. %80 part of the d
ata is set as the Train category and the rest of  the data is set as the Test category as the project is prerequired that condition. 


# ABOUT MYWORD2VECMODEL - DEEP LEARNING ALGORITHM

1-	Dataset is introduced to program and is processed. 

2-	A custom neural network is created using Word2vec class.

3-	Best adjustments are found and applied to the dataset.

4-	How many times that Train transaction should be done is found and applied.

5-	Output file is saved then implemented into program.

6-	Program is used with two words for testing.


# MYCNN2MODEL WITH TWITTERDATASET

1-	Used Twitter datasets and word2vec model are defined.

2-	Required adjustments are made to create a CNN.

3-	Datasets are implemented into program with getDatasetIterator() function as train and test categories.

4-	Train transaction is continued  using necessary data.

5-	A prediction transaction is made to the first negative data in dataset. 

6-	Datas that compiled by Evaluation class, are seperated into needed categories.

