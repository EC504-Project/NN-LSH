# EC504 Project -- Nearest Neighbor Search
## Rough Timeline:
- March 24 - March 31: implement kd-tree and LSH
- March 31 - April 7: Test both algorithm and compare performance
- **April 9: Midterm Report Due**
- **May 2: Final Presentation**
- **May 4: Final Report Due**
## kd-tree
- Group Members: Zheng Gu, Zhiyu Wang
- Development Language: Java
## Locality Sensistive Hashing
- Group Members: Yutong Gao, Zhiyuan Ruan, Hongtao Zhao
- Development Language: Java
### LSH
- Locality sensitive hashing(LSH): hashing items into bins many times and looking only at those items that fall into the same bin at least once (without looking at every pair). How do we arrange the only high-similarity items are likely to fall into the same bucket.
- Cosine similarity is a measure of similarity between two non-zero vectors of an inner product space that measures the cosine of the angle between them. If the angle is 0 degree the cosine value will be zero and if the angle is 90 degree the cosine value will be 0. In paper 'Kernelized Locality-Sensitive Hashing for Scalable Image Search', it is proved that we can find a vector r and transfer of r multiply the vector of picture can be used to generate hash codes for pictures. Using different vector r to create hash tables and we can put similar picture to the same bucket theoretically. 
- Because we ignore the length of the vector. We need to do double check when we input a picture to find similiarity. Hamming distance will be helpful. We transfer the picture to gray version and caculate the mean of all the pixels. Compare the value of pixels with mean, if it's large assign 1, otherwise assign 0. Now we get the fingureprint of every picture in the bucket. And we find the bucket input belong to, compare the input fingerprint wich is a list of 0 and 1 to the picture in the bucket then we can find the similarity.
## Resources
- [Intro to LSH Video on Youtube](https://www.youtube.com/watch?v=bQAYY8INBxg&t=403s)
- [Locality-Sensitive Hashing for Scalable Image Search](http://www.cs.utexas.edu/users/grauman/papers/iccv2009_klsh.pdf)
- [Nearest Neighbor Search MIT Lecture](https://www.youtube.com/watch?v=vAboxtLEeH0)
