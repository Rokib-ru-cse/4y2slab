from tensorflow.keras.layers import Input, Dense, Flatten
from tensorflow.keras import Model

m = 28
n = 28
h = 4
c = 10
input_layer = Input((m, n))
x = Flatten()(input_layer)
x = Dense(8, activation='softmax')(x)
for i in range(h - 1):
    x = Dense(8, activation='softmax')(x)
output_layer = Dense(c)(x)
model = Model(input_layer, output_layer)
model.summary()



# The softmax function is used as the activation function in the output layer of neural 
# network models that predict a multinomial probability distribution. That is , softmax is used as 
# the activation function for multi-class classification problems where class membership is required 
# on more than two class labels
