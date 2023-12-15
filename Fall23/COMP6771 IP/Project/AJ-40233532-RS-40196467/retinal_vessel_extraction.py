import cv2
import numpy as np
from skimage import exposure, morphology
from skimage.measure import label, regionprops
from scipy.signal import convolve
import matplotlib.pyplot as plt
from PIL import Image
import os

s_thin = 1
s_thick = 1.5

L_thin = 5
L_thick = 9

directions = 8

c = 2.3

def create_filter_kernel(s, L, angle, kernel_type):
    # Create kernels for Matched Filter and Gaussian Derivative
    kernel_width = int(np.ceil(np.sqrt((6 * np.ceil(s) + 1)**2 + L**2)))
    kernel_width += 1 if kernel_width % 2 == 0 else 0
    half_width = (kernel_width - 1) // 2
    kernel = np.zeros((kernel_width, kernel_width))

    for coord_y in range(-half_width, half_width + 1):
        for coord_x in range(-half_width, half_width + 1):
            rotation_x = coord_x * np.cos(angle) + coord_y * np.sin(angle)
            rotation_y = coord_y * np.cos(angle) - coord_x * np.sin(angle)
            if np.abs(rotation_x) > 3.5 * np.ceil(s) or np.abs(rotation_y) > (L - 1) / 2:
                kernel[coord_y + half_width, coord_x + half_width] = 0
            else:
                if kernel_type == 0:
                    kernel[coord_y + half_width, coord_x + half_width] = -np.exp(-0.5 * (rotation_x / s)**2) / (np.sqrt(2 * np.pi) * s)
                else:
                    kernel[coord_y + half_width, coord_x + half_width] = -np.exp(-0.5 * (rotation_x / s)**2) * rotation_x / (np.sqrt(2 * np.pi) * s**3)

    if kernel_type == 0:
        mean_value = np.mean(kernel[kernel < 0])
        kernel[kernel < 0] -= mean_value

    return kernel

def vessel_detection_via_matched_filter(image, s, L, orientations, region_mask, contrast_factor):
    # Apply Matched Filtering and Gaussian Derivatives
    if image.dtype != np.double:
        image = image.astype(np.double)
    area_threshold = 30
    rows, cols = image.shape
    matched_filter_response = np.zeros((rows, cols, orientations))
    gaussian_derivative_response = np.zeros((rows, cols, orientations))

    for direction in range(orientations):
        matched_filter_kernel = create_filter_kernel(s, L, np.pi / orientations * direction, 0)
        gaussian_derivative_kernel = create_filter_kernel(s, L, np.pi / orientations * direction, 1)

        matched_filter_response[:, :, direction] = convolve(image, matched_filter_kernel, mode='same')
        gaussian_derivative_response[:, :, direction] = convolve(image, gaussian_derivative_kernel, mode='same')

    max_matched_filter = np.max(matched_filter_response, axis=2)
    max_gaussian_derivative = np.max(gaussian_derivative_response, axis=2)

    smoothing_window = np.ones((31, 31)) / 31 ** 2
    normalized_derivative = convolve(max_gaussian_derivative, smoothing_window, mode='same')
    normalized_derivative = (normalized_derivative - np.min(normalized_derivative)) / np.max(normalized_derivative)

    adaptive_threshold = (1 + normalized_derivative) * contrast_factor * np.mean(max_matched_filter)

    detected_vessels = (max_matched_filter >= adaptive_threshold) & region_mask
    detected_vessels = morphology.closing(detected_vessels, morphology.square(3))

    labeled_vessels, _ = label(detected_vessels, connectivity=2, background=0, return_num=True)
    props = regionprops(labeled_vessels)

    for prop in props:
        if prop.area <= area_threshold:
            detected_vessels[labeled_vessels == prop.label] = 0

    return detected_vessels.astype(np.uint8)


def calculate_accuracy(ground_truth, predicted):
    matching_pixels = np.sum(ground_truth == predicted)
    total_pixels = np.prod(ground_truth.shape)
    accuracy = matching_pixels / total_pixels
    return accuracy

def test_vessel_extraction(image_folder, ground_truth_folder):
    output_folder = 'output_images'
    all_accuracies = []

    # Create the output folder if it doesn't exist
    if not os.path.exists(output_folder):
        os.makedirs(output_folder)

    for i in range(1, 21):  # Assuming you have images from 01 to 20
        image_path = os.path.join(image_folder, f"{i:02d}_test.tif")
        ground_truth_path = os.path.join(ground_truth_folder, f"{i:02d}_test.png")
        output_path = os.path.join(output_folder, f"{i:02d}_output_extracted.png")

        # Load and preprocess the image
        original_image = cv2.imread(image_path) / 255.0
        green_channel = original_image[:, :, 1]
        vessel_mask = green_channel > (20 / 255)
        vessel_mask = morphology.binary_erosion(vessel_mask)
        enhanced_image = exposure.equalize_adapthist(green_channel, clip_limit=0.01)

        # Perform vessel extraction
        # Assume vessel_detection_via_matched_filter is defined elsewhere
        thick_vessels = vessel_detection_via_matched_filter(enhanced_image, s_thick, L_thick, directions, vessel_mask, c)
        thin_vessels = vessel_detection_via_matched_filter(enhanced_image, s_thin, L_thin, directions, vessel_mask, c)
        combined_vessels = np.logical_or(thick_vessels, thin_vessels).astype(np.uint8)

        # Save the combined vessel image
        cv2.imwrite(output_path, combined_vessels * 255)  # Multiply by 255 to scale the image back to 8-bit format

        # Load and preprocess the ground truth image
        ground_truth_pil_image = Image.open(ground_truth_path)
        ground_truth_image = np.array(ground_truth_pil_image) / 255.0

        # Compare the result with the ground truth
        # Assume calculate_accuracy is defined elsewhere
        accuracy = calculate_accuracy(ground_truth_image, combined_vessels)
        all_accuracies.append(accuracy)

        print(f"Image {i:02d} - Accuracy: {accuracy * 100:.2f}%")

    # Calculate average accuracy
    print("All Extracted Images saved in 'output_images' folder")
    average_accuracy = np.mean(all_accuracies)
    print(f"Average Accuracy: {average_accuracy * 100:.2f}%")
    
# Load and preprocess the image
original_image = cv2.imread('fundus/images/01_test.tif') / 255.0
#green channel Extraction
green_channel = original_image[:, :, 1]
vessel_mask = green_channel > (20 / 255)
vessel_mask = morphology.binary_erosion(vessel_mask)

# Apply CLAHE
enhanced_image = exposure.equalize_adapthist(green_channel, clip_limit=0.01)


# Vessel Extraction
# Thick Vessels
thick_vessels = vessel_detection_via_matched_filter(enhanced_image, s_thick, L_thick, directions, vessel_mask, c)
# Thin Vessels
thin_vessels = vessel_detection_via_matched_filter(enhanced_image, s_thin, L_thin, directions, vessel_mask, c)

# Combine Thick and Thin Vessels
combined_vessels = np.logical_or(thick_vessels, thin_vessels).astype(np.uint8)
image = cv2.imread("fundus/images/01_test.tif")
ground_truth = cv2.imread("fundus/vessel/01_test.png")
plt.figure(figsize=(12, 9))
# Visualization
plt.subplot(1,3,1)
plt.imshow(cv2.cvtColor(image, cv2.COLOR_BGR2RGB))
plt.title('Original Image')
plt.axis('off')
plt.subplot(1,3,2)
plt.imshow(combined_vessels, cmap='gray')
plt.title('Extracted Vessels')
plt.axis('off')
plt.subplot(1,3,3)
plt.imshow(ground_truth)
plt.title("Ground Truth Image")
plt.axis('off')
plt.savefig('Output.png', bbox_inches='tight')
plt.show()
print('Output saved as "output.png"')

# Test on DRIVE dataset
image_folder = 'fundus/images/'
ground_truth_folder = 'fundus/vessel/'
test_vessel_extraction(image_folder, ground_truth_folder)