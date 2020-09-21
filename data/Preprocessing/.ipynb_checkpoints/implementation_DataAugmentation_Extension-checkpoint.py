from DataAugmentation_Extension import DataAugmentation_Extension

#directories
target_directory = "/home/rosni/HackZurich2020/Dataset_complete/Trackpictures/night"
output_directory = '/home/rosni/HackZurich2020/Dataset_complete/Trackpictures/night/Output'
#create an instance of the class
datasetda = DataAugmentation_Extension()
datasetda.extend_dataset(target_directory, output_directory)
