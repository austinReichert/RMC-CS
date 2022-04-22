from socket import *

serverName = 'localhost'
serverPort = 12345
clientName = input("Enter the clients name: ")
print("\n")
# this new line is purely because I am picky about output.

clientSocket = socket(AF_INET, SOCK_STREAM)
clientSocket.connect((serverName, serverPort))

while True:
    originalSentence = input('Input lowercase sentence: ')
    if originalSentence.lower() == 'quit':
        stringToSend = clientName + ':' + originalSentence
        clientSocket.send(stringToSend.encode())
        # SEND THE QUIT LINE FIRST, THEN CLOSE
        print("Connection Ended.")
        clientSocket.close()
        break
    else:
        stringToSend = clientName + ':' + originalSentence
        clientSocket.send(stringToSend.encode())
        modifiedSentence = clientSocket.recv(1024)
        print('From server:', modifiedSentence.decode(), "\n")