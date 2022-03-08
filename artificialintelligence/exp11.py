from this import s
from tensorflow.keras.datasets import mnist 
from tensorflow.keras.layers import Input,Dense,Flatten,Conv2D,MaxPooling2D
from tensorflow.keras import Model
from tensorflow.keras.utils import to_categorical
import numpy as np 

(a,b),(c,d) = mnist.load_data()

ti = np.argwhere((b==1)|(b==2))
tj = np.argwhere((d==1)|(d==2))
ti = np.squeeze(ti)
tj = np.squeeze(tj)

a = a[ti]
b = b[ti]
c = c[tj]
d = d[tj]

b = to_categorical(b==1)
d = to_categorical(d==1)

a = a.astype(np.float32)
c = c.astype(np.float32)
a/=255
c/=255

m = a.shape[1]
n = a.shape[2]
h = 4
inputs = Input((m,n,1))
x = Conv2D(filters=3,kernel_size=(2,2),strides=(1,1),padding='same')(inputs)
x = MaxPooling2D(pool_size=(2,2))(x)
for i in range(h-1):
    x = Conv2D(filters=3,kernel_size=(2,2),strides=(1,1),padding='same')(x)
    x = MaxPooling2D(pool_size=(2,2))(x)

x = Flatten()(x)
outputs = Dense(2)(x)
model = Model(inputs,outputs)
model.compile(optimizer='rmsprop',loss='mse',metrics='accuracy')
model.fit(a,b,epochs=5,validation_split=0.2)
model.evaluate(c,d)