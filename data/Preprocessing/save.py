import cv2
import numpy as np
import os

output_path = "D:/Desktop/Hack Zurich/Preprocessing/Output"


img  = cv2.imread("test.jpg")
print(np.array(img).shape)
cv2.imwrite(os.path.join(output_path, "augmented_image.jpg"), img);
