from ast import Num
from pyexpat import model
from tensorflow.keras.datasets import mnist
from tensorflow.keras.layers import Input, Dense, Flatten, Conv2D, MaxPooling2D
from tensorflow.keras import Model
from tensorflow.keras.utils import to_categorical
import numpy as np

# mnist = 70000,70000 = 60000+10000,60000+10000
(trainX, trainY), (testX, testY) = mnist.load_data()

train_indices = np.argwhere((trainY == 1) | (trainY == 2))
test_indices = np.argwhere((testY == 1) | (testY == 2))
train_indices = np.squeeze(train_indices)
test_indices = np.squeeze(test_indices)

trainX = trainX[train_indices]
trainY = trainY[train_indices]
testX = testX[test_indices]
testY = testY[test_indices]

trainY = to_categorical(trainY == 1, num_classes=2)
testY = to_categorical(testY == 1, num_classes=2)

trainX = trainX.astype(np.float32)
testX = testX.astype(np.float32)
trainX /= 255
testX /= 255

print(trainX.shape)

M = trainX.shape[1]
N = trainX.shape[2]
h = 4
inputs = Input((M,N,1))

x = Conv2D(filters=3,kernel_size=(2,2),padding='same')(inputs)
X = MaxPooling2D(pool_size=(2,2))(x)

for i in range(h-1):
    x = Conv2D(filters=3,kernel_size=(2,2),padding='same')(x)
    X = MaxPooling2D(pool_size=(2,2))(x)

x = Flatten()(x)
outputs = Dense(2)(x)
model = Model(inputs,outputs)

model.compile(optimizer='rmsprop',loss='mse',metrics=['accuracy'])
model.fit(trainX,trainY,epochs=5,validation_split=0.2)
model.evaluate(testX,testY)
