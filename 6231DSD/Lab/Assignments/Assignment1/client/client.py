import os
import socket


def receive_message_ending_with_token(active_socket, buffer_size, eof_token):
    # initializing bytearray and eof length
    file_content = bytearray()
    eof_length = len(eof_token)
    while True:
        # receiving the packet size of buffer_Size(1024)
        packet = active_socket.recv(buffer_size)
        # concatenating it to file content
        file_content += packet
        # checking if the packet with eof token is received that will indicate the last packet
        if file_content[-eof_length:] == eof_token.encode():
            # STRIPPING THE EOF TOKEN AND RETURNING
            return file_content[:len(file_content) - eof_length]


def initialize(host, port):
    new_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    new_socket.connect((host, port))

    print('Connected to server at IP:', host, 'and Port:', port)

    # receiving eof token of 10 bytes used to indicate end of messages.
    eof_token = new_socket.recv(10).decode()

    print('Handshake Done. EOF is:', eof_token)

    # receiving info for cwd from the server
    curr_working_dir = receive_message_ending_with_token(new_socket, 1024, eof_token)

    print(curr_working_dir.decode())
    return new_socket, eof_token


def issue_cd(command_and_arg, client_socket, eof_token):
    message = (command_and_arg + eof_token).encode()
    client_socket.send(message)
    print(receive_message_ending_with_token(client_socket, 1024, eof_token).decode())


def issue_mkdir(command_and_arg, client_socket, eof_token):
    message = (command_and_arg + eof_token).encode()
    client_socket.send(message)
    print(receive_message_ending_with_token(client_socket, 1024, eof_token).decode())


def issue_rm(command_and_arg, client_socket, eof_token):
    message = (command_and_arg + eof_token).encode()
    client_socket.send(message)
    print(receive_message_ending_with_token(client_socket, 1024, eof_token).decode())


def issue_ul(command_and_arg, client_socket, eof_token):
    message = (command_and_arg + eof_token).encode()
    client_socket.send(message)

    file_name = command_and_arg.split()[1]

    with open(file_name, 'rb') as f:
        file_content = f.read()

    # EOF token
    file_content_with_token = file_content + eof_token.encode()
    # print(file_content_with_token)
    client_socket.send(file_content_with_token)
    print(receive_message_ending_with_token(client_socket, 1024, eof_token).decode())


def issue_dl(command_and_arg, client_socket, eof_token):
    message = (command_and_arg + eof_token).encode()
    client_socket.send(message)
    packet = receive_message_ending_with_token(client_socket, 1024, eof_token)
    file_name = command_and_arg.split()[1]
    f = open(file_name, "wb")
    f.write(packet)
    f.close()
    print(receive_message_ending_with_token(client_socket, 1024, eof_token).decode())


def main():
    HOST = "127.0.0.1"  # The server's hostname or IP address
    PORT = 65432  # The port used by the server
    s, eof = initialize(HOST, PORT)
    while True:
        print("Choose a command: cd, mkdir, rm, ul, dl, exit")
        inp = input('>>>')
        print('========================================================================================')
        if inp.split()[0] == "cd":
            issue_cd(inp, s, eof)
        elif inp.split()[0] == "mkdir":
            issue_mkdir(inp, s, eof)
        elif inp.split()[0] == "rm":
            issue_rm(inp, s, eof)
        elif inp.split()[0] == "ul":
            issue_ul(inp, s, eof)
        elif inp.split()[0] == "dl":
            issue_dl(inp, s, eof)
        elif inp == "exit":
            break

    print('Exiting the application.')


if __name__ == '__main__':
    main()
