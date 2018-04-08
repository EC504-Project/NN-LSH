# encoding:utf-8
# author：yutong gap
# email：gyt@bu.edu


from scipy.misc import imsave
import numpy as np


def unpickle(file):
    import pickle
    fo = open(file, 'rb')
    dict = pickle.load(fo,encoding='iso-8859-1')
    fo.close()
    return dict


for j in range(1, 6):
    # read the data_batch1, 2, 3, 4, 5, put this piece of code into the same document
    dataName = "data_batch_" + str(j)
    Xtr = unpickle(dataName)
    print(dataName + " is loading...")

    # need to create document 'test', 'train' in the same document
    for i in range(0, 10000):
        img = np.reshape(Xtr['data'][i], (3, 32, 32))
        img = img.transpose(1, 2, 0)  # 读取image
        picName = 'train/' + str(Xtr['labels'][i]) + '_' + str(i + (j - 1)*10000) + '.jpg'

        imsave(picName, img)
    print(dataName + " loaded.")

print("test_batch is loading...")

# 生成测试集图片
testXtr = unpickle("test_batch")
for i in range(0, 10000):
    img = np.reshape(testXtr['data'][i], (3, 32, 32))
    img = img.transpose(1, 2, 0)
    picName = 'test/' + str(testXtr['labels'][i]) + '_' + str(i) + '.jpg'
    imsave(picName, img)
print("test_batch loaded.")