# Grayscale Image
## src
This file contains two pieces of codes which are 'togray' and 'readFile'. 'readFile' is used to read all the images from the document and record there abosolute path in a text file. 'togray' reads the path from that file and use it to transfer image to grayscale.

In the 'readFile' part, if use MAC OS there will be a document end with ".DS_Store", you need to delete it in the system.How to do it?
Open Terminal cd to the document directory and input ' find ./ -name ".DS_Store" -depth -exec rm {} \; ' then this file is removed.
To forbid .DS_Store file generation, use ' defaults write com.apple.desktopservices DSDontWriteNetworkStores true '.

Both of the codes use abosolute path on my computer so you may need to change some of the path to run it on your computer.

## image 
This document contains several color examples of images.

## grayv
This document contains the transfered grayscale images and a txt file contains the path of all color images.

