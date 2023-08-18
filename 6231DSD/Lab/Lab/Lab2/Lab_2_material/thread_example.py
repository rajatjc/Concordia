from threading import Thread

import username as username


class MyThread(Thread):
    def __init__(self, message):
        Thread.__init__(self)
        self.message = message  # save the message argument
        self.return_val = None  # variable to store return value

    def run(self):
        user_input = input(self.message)  # get input from the user (blocking)
        self.return_val = user_input  # store the input in return value

    def join(self, *args):
        Thread.join(self, *args)
        return self.return_val  # return the value upon join


myThread = MyThread('Enter user name.')
myThread.start()
print('Thread is now running.')
username = myThread.join()
print('Thread is done. Username is:', username)
