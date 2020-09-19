﻿import os
from sklearn.model_selection import train_test_split
import numpy as np
import glob
import shutil
from DataAugmentation import DataAugmentation #import library from the python file



class DataAugmentation_Extension:

	#root_dir = "D:/Desktop/Hack Zurich/Preprocessing"
	#output_dir = "D:/Desktop/Hack Zurich/Preprocessing/Output"
	def __init__(self, directory=""):
		self.directory = directory
		print("Instance of DataAugmentation_Extension class created")

	def printnow(self, dir):
		print("Just testing that the method calling is working "+ dir)


	def extend_dataset(self,directory, output_dir):
		#Create an instance of class 
		print("HEY")
		library_augment= DataAugmentation();
		self.directory = directory 
		if not os.path.exists(self.directory):
			print("ERROR! Couldn't find directory!")
		else:
			print("Directory exists")
		for file in os.listdir(directory):            #for any file inside the root directory 
			print('dadada', file)
			classes_path = os.path.join(directory, file)  #So for every folder class we create a class directory
			class_files = [name for name in glob.glob(os.path.join(classes_path,'*.jpg'))]  #alternatively we can use the globe as mentioned
			print(class_files); #call augmentation for all class_files
			for i in range(len(class_files)):
				print()
				library_augment.augmentation_of_image(class_files[i], output_dir, file)


			
			

		




