from tensorflow.keras.applications.vgg16 import VGG16
from tensorflow.keras.layers import Input,Dense,Flatten
from tensorflow.keras.datasets import mnist
from tensorflow.keras.utils import to_categorical
from tensorflow.keras import Model
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

trainX = np.pad(trainX,((0,0),(2,2),(2,2)),'constant')
testX = np.pad(testX,((0,0),(2,2),(2,2)),'constant')
trainX = np.stack((trainX,)*3,axis=-1)
testX = np.stack((testX,)*3,axis=-1)

M = trainX.shape[1]
N = trainX.shape[2]

base_model = VGG16(include_top=False,input_shape=(M,N,3))
for layer in base_model.layers:
    layer.trainable = False

inputs = base_model.input
x = Flatten()(inputs)
outputs = Dense(2)(x)
model = Model(inputs,outputs)
model.compile(optimizer='rmsprop',loss='mse',metrics=['accuracy'])
model.fit(trainX,trainY,epochs=5,validation_split=0.2)
model.evaluate(testX,testY)
