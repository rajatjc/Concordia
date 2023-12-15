# Read frequency.txt and create a map of word positions
word_positions = {}
with open("frequency.txt", "r") as file:
    words = file.read().split()
    i = 0
    for word in words:
        if word not in word_positions:
            word_positions[word] = i
            i += 1


decompressed_word = ""

def is_number(word):
    try:
        float(word)
        return True
    except ValueError:
        return False
 # Helper function to check if a word is a number
    def is_number(word):
        try:
            float(word)
            return True
        except ValueError:
            return False
        
def decompress_file(encoded_text):
    decompressed_text = []
    compressed_words = encoded_text.split()
    capitalize_next = True  # Flag to indicate if the next word should be capitalized

    for compressed_word in compressed_words:
        if compressed_word.startswith("@") and compressed_word.endswith("@") and compressed_word != "@":
            decompressed_word = compressed_word[1:-1]
        elif is_number(compressed_word):
            position = int(compressed_word)
            words = list(word_positions.keys())
            decompressed_word = words[position] if position < len(words) else compressed_word
        else:
            decompressed_word = compressed_word

        capitalized_word = decompressed_word.capitalize() if capitalize_next else decompressed_word
        decompressed_text.append(capitalized_word)

        if decompressed_word.endswith(('.', '!', '?')):
            capitalize_next = True
        else:
            capitalize_next = False

    decompressed_text = " ".join(decompressed_text)

    # decompressed_text="In the python language, the expression [[ 34, house, 14], [administation, 123, cat]] represents a structure called a list, while the expression (dog, 26, apple, (age, 76)) is a tuple. Cool, eh"
    # Characters to add spaces before
    characters = ['(', '[',',', '.', '?', '!', ')', ']', '@', '$']

    # Add spaces before characters
    for char in characters:
        if char in ['@', '$']:
            decompressed_text = decompressed_text.replace(f'{char} ', char)
        elif char in ['(', '[']:
            decompressed_text = decompressed_text.replace(f' {char} ', f' {char}')
            
        else:
            decompressed_text = decompressed_text.replace(f' {char}', char)
    return decompressed_text
    




# Test encoding
original_text = "hello 490 139 6 chut ( ( ( ( ( [ 41 ] ) ) ) ) ) 74 131 ( ( [ ( [ ( @2@ , @3@ ) ] ) ] ) )"
# modified_text = add_spaces_to_punctuation(original_text)

print(decompress_file(original_text))
# print(word_positions)
