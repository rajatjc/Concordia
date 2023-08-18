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
        while True:  # handle all requests from the client
            data = self.service_socket.recv(1024)
            if not data:
                break
            message = f'I got "{data.decode()}" from you and I am sending it back.'
            self.service_socket.sendall(str.encode(message))
            print(f'Sent back "{data.decode()}" to: {self.address}')

        self.service_socket.close()

HOST = "172.17.0.2"  # localhost
PORT = 65432  # Port to listen on
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.bind((HOST, PORT))
    s.listen()
    while True:
        conn, addr = s.accept()
        client_thread = ClientThread(conn, addr)
        client_thread.start()
