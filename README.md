# Coding-challenge-Hiberus

![Solution Architecture](https://raw.githubusercontent.com/username/projectname/branch/path/to/img.png)





Set up the RabbitMQ Broker
Before you can build your messaging application, you need to set up a server to handle receiving and sending messages.

RabbitMQ is an AMQP server. The server is freely available at https://www.rabbitmq.com/download.html. You can download it manually or, if you use a Mac with Homebrew, by running the following command in a terminal window:

brew install rabbitmq

Unpack the server and launch it with default settings by running the following command in a terminal window:

rabbitmq-server


Install and Launch MongoDB
With your project set up, you can install and launch the MongoDB database.

If you use a Mac with Homebrew, you can run the following command:

$ brew install mongodb
With MacPorts, you can run the following command:

$ port install mongodb
For other systems with package management, such as Redhat, Ubuntu, Debian, CentOS, and Windows, see the instructions at https://docs.mongodb.org/manual/installation/.

After you install MongoDB, you can launch it in a console window by running the following command (which also starts up a server process):

$ mongod
You should see output similar to the following:

all output going to: /usr/local/var/log/mongodb/mongo.log
