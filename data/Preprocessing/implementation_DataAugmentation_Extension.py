﻿from DataAugmentation_Extension import DataAugmentation_Extension

#directories
target_directory = "./images"
output_directory = './Output'
#create an instance of the class
datasetda = DataAugmentation_Extension()
datasetda.extend_dataset(target_directory, output_directory)
