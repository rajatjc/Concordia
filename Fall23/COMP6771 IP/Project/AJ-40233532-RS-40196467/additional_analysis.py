import cv2
import numpy as np
from skimage import exposure, morphology
from PIL import Image
import matplotlib.pyplot as plt
import os
from retinal_vessel_extraction import vessel_detection_via_matched_filter

# Set parameters
s_thin = 1
s_thick = 1.5
L_thin = 5
L_thick = 9
directions = 8
c = 2.3

def calculate_tpr_fpr(total_tp, total_fp, total_tn, total_fn):
    tpr = total_tp / (total_tp + total_fn) if (total_tp + total_fn) > 0 else 0
    fpr = total_fp / (total_fp + total_tn) if (total_fp + total_tn) > 0 else 0
    return tpr, fpr

def plot_roc_curve(image_folder, ground_truth_folder, thresholds):
    total_tpr_list = []
    total_fpr_list = []

    for c_value in thresholds:  # Adjusting the 'c' parameter
        total_tp, total_fp, total_tn, total_fn = 0, 0, 0, 0

        for i in range(1, 21):  # Iterate over the range of image numbers
            image_filename = f"{i:02d}_test.tif"
            ground_truth_filename = f"{i:02d}_test.png"  # Adjust the extension if necessary
            image_path = os.path.join(image_folder, image_filename)
            ground_truth_path = os.path.join(ground_truth_folder, ground_truth_filename)

            # Load and preprocess the image
            original_image = cv2.imread(image_path) / 255.0
            green_channel = original_image[:, :, 1]
            vessel_mask = green_channel > (20 / 255)
            vessel_mask = morphology.binary_erosion(vessel_mask)
            enhanced_image = exposure.equalize_adapthist(green_channel, clip_limit=0.01)

            # Perform vessel extraction
            thick_vessels = vessel_detection_via_matched_filter(enhanced_image, s_thick, L_thick, directions, vessel_mask, c_value)
            thin_vessels = vessel_detection_via_matched_filter(enhanced_image, s_thin, L_thin, directions, vessel_mask, c_value)
            combined_vessels = np.logical_or(thick_vessels, thin_vessels).astype(np.uint8)

            # Load and preprocess the ground truth image
            ground_truth_image = np.array(Image.open(ground_truth_path)) / 255.0
            ground_truth_image = ground_truth_image.astype(np.uint8)

            # Calculate TP, FP, TN, FN for the current image
            tp = np.sum((combined_vessels == 1) & (ground_truth_image == 1))
            fp = np.sum((combined_vessels == 1) & (ground_truth_image == 0))
            tn = np.sum((combined_vessels == 0) & (ground_truth_image == 0))
            fn = np.sum((combined_vessels == 0) & (ground_truth_image == 1))

            # Accumulate statistics
            total_tp += tp
            total_fp += fp
            total_tn += tn
            total_fn += fn

        # Calculate TPR and FPR for the dataset at the current threshold
        tpr, fpr = calculate_tpr_fpr(total_tp, total_fp, total_tn, total_fn)
        total_tpr_list.append(tpr)
        total_fpr_list.append(fpr)

    # Plotting the ROC Curve for the dataset
    plt.figure(figsize=(8, 6))
    plt.plot(total_fpr_list, total_tpr_list, marker='o')
    plt.xlabel('False Positive Ratio')
    plt.ylabel('True Positive Ratio')
    plt.title('ROC Curve for the Dataset')
    plt.grid(True)
    plt.savefig('roc.png', bbox_inches='tight')
    plt.show()
    print('plot saved as roc.png')


# Define the thresholds and paths
thresholds = [0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0]
image_folder = 'fundus/images/'
ground_truth_folder = 'fundus/vessel/'

# Generate ROC curve for the dataset
plot_roc_curve(image_folder, ground_truth_folder, thresholds)


