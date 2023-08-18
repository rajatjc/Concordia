import socket

HOST = "127.0.0.1"  # The server's hostname or IP address
PORT = 6565  # The port used by the server

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.connect((HOST, PORT))
    print('Connected to:', HOST, PORT)
    file_name = input('Enter your message to server: ')  # user input to block the client
    s.sendall(file_name.encode())
    f = open(file_name, "wb")
    while True:
        packet = s.recv(1024)
        if packet[-5:] == '<EOF>'.encode():
            f.write(packet[:-5])
            break
        f.write(packet)
