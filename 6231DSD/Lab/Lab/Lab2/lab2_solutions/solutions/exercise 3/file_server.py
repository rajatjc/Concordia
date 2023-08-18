import socket
from threading import Thread

class ClientThread(Thread):
    def __init__(self, service_socket : socket.socket,
                 address : str):
        Thread.__init__(self)
        self.service_socket = service_socket
        self.address = address

    def run(self):
        print(f"Connected by {self.address}")
        file_name = self.service_socket.recv(1024)
        with open(file_name.decode(), 'rb') as f:
            file_content = f.read()

        # EOF token
        file_content_with_token = file_content + '<EOF>'.encode()
        self.service_socket.sendall(file_content_with_token)
        print(f'Sent the contents of "{file_name.decode()}" to: {self.address}')
        self.service_socket.close()


HOST = "172.17.0.2"  # localhost
PORT = 6565  # Port to listen on
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.bind((HOST, PORT))
    s.listen()
    while True:
        conn, addr = s.accept()
        client_thread = ClientThread(conn, addr)
        client_thread.start()
