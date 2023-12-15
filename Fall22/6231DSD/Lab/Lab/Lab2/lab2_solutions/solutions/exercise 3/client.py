import socket
from threading import Thread


class FileServerThread(Thread):
    def __init__(self):
        Thread.__init__(self)
        self.file_name = None
        self.file_size = None

    def run(self):
        self.file_name = input('Enter file name to fetch from file server: ')
        file_server_host = "172.17.0.2"
        file_server_port = 6565
        with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
            s.connect((file_server_host, file_server_port))
            print('Connected to file server at:', file_server_host, file_server_port)
            s.sendall(self.file_name.encode())
            file_content = bytearray()
            while True:
                packet = s.recv(1024)
                if packet[-5:] == '<EOF>'.encode():
                    file_content += packet[:-5]
                    break
                file_content += packet
            self.file_size = len(file_content)
            print(f'Got file: {self.file_name} from file server, size:', self.file_size)

    def join(self, *args):
        Thread.join(self, *args)
        return self.file_name, self.file_size


def main():
    hello_word_server_host = "172.17.0.2"
    hello_word_server_port = 65432
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.connect((hello_word_server_host, hello_word_server_port))
        print('Connected to hello world server at:', hello_word_server_host, hello_word_server_port)

        file_server_thread = FileServerThread()
        file_server_thread.start()
        file_name, file_size = file_server_thread.join()

        message = f'The size of {file_name} is {file_size}'
        s.sendall(message.encode())
        response = s.recv(1024)
        print('Response from Hello World Server:', response.decode())

if __name__ == '__main__':
    main()
