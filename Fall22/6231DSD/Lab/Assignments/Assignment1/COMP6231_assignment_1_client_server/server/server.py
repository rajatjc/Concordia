import socket
import random
import sys
from threading import Thread
import os
import shutil
import string
from pathlib import Path


def get_working_directory_info(working_directory):
    dirs = '\n-- ' + '\n-- '.join([i.name for i in Path(working_directory).iterdir() if i.is_dir()])
    files = '\n-- ' + '\n-- '.join([i.name for i in Path(working_directory).iterdir() if i.is_file()])
    dir_info = f'Current Directory: {working_directory}:\n|{dirs}{files}'
    return dir_info


def generate_random_eof_token():
    # generating a random string with ascii of upper lower and digits
    random_string = ''.join(
        random.choice(string.ascii_uppercase + string.ascii_lowercase + string.digits) for _ in range(8))
    shuffled = ''.join(random.sample(random_string, len(random_string)))

    return "<" + str(shuffled) + ">"


def receive_message_ending_with_token(active_socket, buffer_size, eof_token):
    # initializing bytearray and eof length
    file_content = bytearray()
    eof_length = len(eof_token)
    while True:
        # receiving the packet size of buffer_Size(1024)
        packet = active_socket.recv(buffer_size)
        # concatenating it to file cotent
        file_content += packet
        # checking if the packet with eof token is received that will indicate the last packet
        if file_content[-eof_length:] == eof_token.encode():
            # STRIPPING THE EOF TOKEN AND RETURNING
            return file_content[:len(file_content) - eof_length]


def handle_cd(current_working_directory, new_working_directory):
    os.chdir(current_working_directory)
    try:
        if new_working_directory != "..":
            os.chdir(new_working_directory)
        else:
            os.chdir("..")

    # Caching the exception
    except:
        print("Something wrong with specified directory. Exception- ")
        print(sys.exc_info())
        print("Restoring the path")
        os.chdir(current_working_directory)
        print("Current directory is-", os.getcwd())

    # :return: absolute path of new current working directory
    return os.path.abspath(os.getcwd())


def handle_mkdir(current_working_directory, directory_name):
    os.mkdir(os.path.join(current_working_directory, directory_name))


def handle_rm(current_working_directory, object_name):
    path = os.path.join(current_working_directory, object_name)
    if os.path.isfile(path):
        os.remove(path)
    else:
        try:
            os.rmdir(path)
            print("% s removed successfully" % path)
        except OSError as error:
            print(error)
            print("File path can not be removed")


def handle_ul(current_working_directory, file_name, service_socket, eof_token):
    packet = receive_message_ending_with_token(service_socket, 1024, eof_token)
    f = open(file_name, "wb")
    f.write(packet)
    f.close()


def handle_dl(current_working_directory, file_name, service_socket, eof_token):
    with open(file_name, 'rb') as f:
        file_content = f.read()
    file_content_with_token = file_content + eof_token.encode()
    service_socket.send(file_content_with_token)
    f.close()


class ClientThread(Thread):
    def __init__(self, service_socket: socket.socket, address: str):
        Thread.__init__(self)
        self.service_socket = service_socket
        self.address = address

    def run(self):
        print("Connection from : ", self.address)

        # generating eof and getting info for curr working dir
        eof_token = generate_random_eof_token()
        curr_working_dir = os.getcwd()

        # sending eof token and cwd ifo to client side
        self.service_socket.send(eof_token.encode())
        self.service_socket.send((get_working_directory_info(curr_working_dir) + eof_token).encode())

        while True:

            # receiving command from client
            message = receive_message_ending_with_token(self.service_socket, 1024, eof_token)

            # splitting command into command(cd,mkdir...) and argument(folder name, file name)
            command = message.decode().split()[0]
            argument = message.decode().split()[1]

            # handling cases for each command
            if command == "cd":
                curr_working_dir = handle_cd(curr_working_dir, argument)
            elif command == "mkdir":
                handle_mkdir(curr_working_dir, argument)
            elif command == "rm":
                handle_rm(curr_working_dir, argument)
            elif command == "ul":
                handle_ul(curr_working_dir, argument, self.service_socket, eof_token)
            elif command == "dl":
                handle_dl(curr_working_dir, argument, self.service_socket, eof_token)

            # sending info of curr working directory to client
            self.service_socket.send((get_working_directory_info(curr_working_dir) + eof_token).encode())

        print('Connection closed from:', self.address)


def main():
    HOST = "172.17.0.2"
    PORT = 65432

    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind((HOST, PORT))
        s.listen(10)
        while True:
            conn, addr = s.accept()
            print(f"Connected by {addr}")
            client_thread = ClientThread(conn, addr)
            client_thread.start()


if __name__ == '__main__':
    main()
