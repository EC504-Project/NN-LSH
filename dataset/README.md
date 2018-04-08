# Dataset
## MIT Dataset
The dataset consists of 79,302,017 images, each being a 32x32 color image. You will need around 400Gb of free disk space to store all the files. For the final project it is too large to use. 
To view and downlod the dataset go to http://horatio.cs.nyu.edu/mit/tiny/data/index.html.

## Cifar10 Dataset
The CIFAR-10 and CIFAR-100 are labeled subsets of the 80 million tiny images dataset. They were collected by Alex Krizhevsky, Vinod Nair, and Geoffrey Hinton. The CIFAR-10 dataset consists of 60000 32x32 colour images in 10 classes, with 6000 images per class. There are 50000 training images and 10000 test images. 
To view and downlod the dataset go to https://www.cs.toronto.edu/~kriz/cifar.html.

We download the python version of dataset and then write a piece of code to transfer them to .jpg version. You may have some difficulties when using this code because several problem below:
1. import cPickle
For python 2.0, you just use 'import cPickle fo = open(file, 'rb')  dict = pickle.load(fo)'. However for python 3.0, you need to use 'import pickle fo = open(file, 'rb') dict = pickle.load(fo,encoding='iso-8859-1')'.
2. Before running the code, you need to create two document named 'test' and 'train' in the same document of data_batch1, 2, 3, 4, 5.
