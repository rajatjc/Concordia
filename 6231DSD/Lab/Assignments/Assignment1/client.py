import socket

eof = ''
cwd = ''


def receive_message_ending_with_token(active_socket, buffer_size, eof_token):
    """
    Same implementation as in receive_message_ending_with_token() in server.py
    A helper method to receives a bytearray message of arbitrary size sent on the socket.
    This method returns the message WITHOUT the eof_token at the end of the last packet.
    :param active_socket: a socket object that is connected to the server
    :param buffer_size: the buffer size of each recv() call
    :param eof_token: a token that denotes the end of the message.
    :return: a bytearray message with the eof_token stripped from the end.
    """

    data = bytearray()
    while True:
        info = active_socket.recv(buffer_size)
        data += info
        size = len(eof_token)
        if data[-size:] == eof_token:
            return data[:len(data) - size].encode()


def initialize(host, port):
    """
    1) Creates a socket object and connects to the server.
    2) receives the random token (10 bytes) used to indicate end of messages.
    3) Displays the current working directory returned from the server (output of get_working_directory_info() at the server).
    Use the helper method: receive_message_ending_with_token() to receive the message from the server.
    :param host: the ip address of the server
    :param port: the port number of the server
    :return: the created socket object
    """
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.connect((host, port))

        global eof, cwd
        eof = s.recv(10).decode()

        # print('Connected to server at IP:', host, 'and Port:', port)
        print('Connected to server at IP:', host, 'and Port:', port)

        # print('Handshake Done. EOF is:', eof_token)
        print('Handshake Done. EOF is:', eof)
        cwd = receive_message_ending_with_token(s, 1024, eof)
        print('Current Working Directory: ', cwd.decode())
        # raise NotImplementedError('Your implementation here.')
        return s.dup()


def issue_cd(command_and_arg, client_socket, eof_token):
    """
    Sends the full cd command entered by the user to the server. The server changes its cwd accordingly and sends back
    the new cwd info.
    Use the helper method: receive_message_ending_with_token() to receive the message from the server.
    :param command_and_arg: full command (with argument) provided by the user.
    :param client_socket: the active client socket object.
    :param eof_token: a token to indicate the end of the message.
    """
    message = (command_and_arg + eof_token).encode()
    client_socket.send(message)

    x = receive_message_ending_with_token(client_socket, 1024, eof_token)
    print(x)


def issue_mkdir(command_and_arg, client_socket, eof_token):
    """
    Sends the full mkdir command entered by the user to the server. The server creates the sub directory and sends back
    the new cwd info.
    Use the helper method: receive_message_ending_with_token() to receive the message from the server.
    :param command_and_arg: full command (with argument) provided by the user.
    :param client_socket: the active client socket object.
    :param eof_token: a token to indicate the end of the message.
    """
    message = (command_and_arg + eof_token).encode()
    client_socket.send(message)

    x = receive_message_ending_with_token(client_socket, 1024, eof_token)
    print(x)


def issue_rm(command_and_arg, client_socket, eof_token):
    """
    Sends the full rm command entered by the user to the server. The server removes the file or directory and sends back
    the new cwd info.
    Use the helper method: receive_message_ending_with_token() to receive the message from the server.
    :param command_and_arg: full command (with argument) provided by the user.
    :param client_socket: the active client socket object.
    :param eof_token: a token to indicate the end of the message.
    """
    message = (command_and_arg + eof_token).encode()
    client_socket.send(message)

    x = receive_message_ending_with_token(client_socket, 1024, eof_token)
    print(x)


def issue_ul(command_and_arg, client_socket, eof_token):
    """
    Sends the full ul command entered by the user to the server. Then, it reads the file to be uploaded as binary
    and sends it to the server. The server creates the file on its end and sends back the new cwd info.
    Use the helper method: receive_message_ending_with_token() to receive the message from the server.
    :param command_and_arg: full command (with argument) provided by the user.
    :param client_socket: the active client socket object.
    :param eof_token: a token to indicate the end of the message.
    """
    message = (command_and_arg + eof_token).encode()
    client_socket.send(message)
    # Have to write more code
    x = receive_message_ending_with_token(client_socket, 1024, eof_token)
    print(x)


def issue_dl(command_and_arg, client_socket, eof_token):
    """
    Sends the full dl command entered by the user to the server. Then, it receives the content of the file via the
    socket and re-creates the file in the local directory of the client. Finally, it receives the latest cwd info from
    the server.
    Use the helper method: receive_message_ending_with_token() to receive the message from the server.
    :param command_and_arg: full command (with argument) provided by the user.
    :param client_socket: the active client socket object.
    :param eof_token: a token to indicate the end of the message.
    :return:
    """
    message = (command_and_arg + eof_token).encode()
    client_socket.send(message)
    # Have to write more code
    x = receive_message_ending_with_token(client_socket, 1024, eof_token)
    print(x)


def main():
    HOST = "127.0.0.1"  # The server's hostname or IP address
    PORT = 65432  # The port used by the server

    # raise NotImplementedError('Your implementation here.')

    # initialize
    s = initialize(HOST, PORT)

    # while True:
    while True:

        # get user input
        print('1.cd')
        print('2.mkdir')
        print('3.rm')
        print('4.ul')
        print('5.dl')
        print('6.exit')
        inp = input('Enter Your Choice from 1-6:')
        if inp == 1:
            c = input("Enter cd command")
            se = (inp + eof).encode()
            print(se)
            s.send(se)
            issue_cd(c, s, eof)

        se = (inp + eof).encode()
        s.send(se)
        u = receive_message_ending_with_token(s, 1024, eof)
        print(u.decode())
        # call the corresponding command function or exit

    # print('Exiting the application.')


if __name__ == '__main__':
    main()
