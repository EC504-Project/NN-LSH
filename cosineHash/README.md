# Cosine Hash
## Classes
### CosineHashFamily
CosineHashFamily contains three functions:
- dotProduct: compute dot product between two vectors
- generateGaussianVector: Generate a vector from N(0,I) distribution, where I has the same dimension as images
- hash: Apply dot product between image and vector r, return 1 if the product is greater than 0, 0 otherwise

#### Instructions
To test each functions in CosineHashFamily, a main is provided in this .java file. One sample data is provided inside
for testing purpose.
### hashData
Used to store each hash table and b hash vectors associated with the hash tables.
### SharedVariable
Used to store variables shared across classes
- numberOfHashes: b hashes
- numberOfHashTables: L hash tables
- dimensions: dimensions of image vector
- mean: mean of standard normal distribution
- collectionOfTables: store all hash tables in form of hashData
### preprocessing_Runner
All final connection between different modules will be implemented here. Since image to vector module is not
yet implemented, the connection between modules is not established.
#### Instruction
Two 1x3 fake image sample data are provided in main(). The code's ability to correctly hash image vectors and store them is tested in main().
