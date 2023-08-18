import os
import random, string
import sys


# x = ''.join(random.choice(string.ascii_uppercase + string.ascii_lowercase + string.digits) for _ in range(8))
# print(x)
# print(bytearray(b'<i2RwO4Ij>').decode())

def handle_cd(current_working_directory, new_working_directory):
    """
    Handles the client cd commands. Reads the client command and changes the current_working_directory variable
    accordingly. Returns the absolute path of the new current working directory.
    :param current_working_directory: string of current working directory
    :param new_working_directory: name of the sub directory or '..' for parent
    :return: absolute path of new current working directory
    """
    print(os.getcwd())
    print(current_working_directory + " " + new_working_directory)
    # os.chdir(current_working_directory)
    os.chdir(new_working_directory)
    return os.path.abspath(os.getcwd())
    # raise NotImplementedError('Your implementation here.')


print("\033[32;5mPress ENTER\033[0m")