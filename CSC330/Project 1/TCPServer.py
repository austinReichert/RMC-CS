from socket import *

serverPort = 12345

serverSocket = socket(AF_INET, SOCK_STREAM)
serverSocket.bind(('', serverPort))
serverSocket.listen(1)
print('The server is ready to receive.')
connectionSocket, addr = serverSocket.accept()

# output stuff
clientName = ''

while True:
    try:
        originalSentence = connectionSocket.recv(1024).decode()
    except OSError:
        print("Client disconnected.")
        connectionSocket.close()
        exit()

    clientNameIndex = (originalSentence.find(':') + 1)
    if clientName == '':
        clientName = originalSentence[0:(clientNameIndex-1)]
    # I really don't like the look of the server returning the clients name to itself.
    # This index shows where ':' is and will be used to return everything BEHIND it.
    # If you don't like this functionality, feel free to delete/comment it out :)

    if 'quit' in originalSentence:
        print("Client attempted to disconnect")
        exit()
    else:
        print("Received:", originalSentence)
        responseSentence = originalSentence[clientNameIndex:len(originalSentence)].upper()
        # also remove the [clientNameIndex:len(originalSentence)] part too if you mess with stuff up there! :)
        print("Sent", clientName, ":", responseSentence, "\n")
        connectionSocket.send(responseSentence.encode())