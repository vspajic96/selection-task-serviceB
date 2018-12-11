# selection-task-serviceB
This microservice is developed using Spring Boot, and it's tasked with receiving and handling AMQP messages generated in Service A.
It's purpose is also to initialize a database with an account to perform transactions on.

Upon receiving a message, Service B logs the received `TransactionPerformedEvent` and updates the account balance accordingly.

Rest API has a single endpoint, `/balance`, that responds to GET requests by returning the state of the account in JSON form.

To run Service B you **must** have:
1. RabbitMQ server running with default configuration
2. MySQL database with the name db_example, and a user with the following credentials: name - springuser; password- ThePassword.
