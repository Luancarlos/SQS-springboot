# SPRING BOOT WITH SQS
## Example use spring boot with SQS

###### LOCALSTACK
Commands:
```sh
#CREATE QUEUE SQS
aws sqs create-queue --endpoint-url=http://localhost:4566 --queue-name product;

#CREATE QUEUE DLQ
aws sqs create-queue --endpoint-url=http://localhost:4566 --queue-name dlq;

#ARN QUEUE DLQ
arn:aws:sqs:us-east-1:000000000001:dlq

#ADD ATTRIBUTES QUEUE
aws --endpoint-url=http://localhost:4566 sqs set-queue-attributes --queue-url http://localhost:4566/000000000000/product --attributes file://queue-attributes.json

#LIST QUEUES SQS
aws --endpoint-url=http://localhost:4566 sqs list-queues;

#SEND MESSAGE
aws --endpoint-url=http://localhost:4566 sqs send-message --queue-url http://localhost:4566/000000000000/product --message-body '{"id":3, "name":"Product 1","description":"teste"}'

#RECEIVE MESSAGE
aws --endpoint-url=http://localhost:4566 sqs receive-message --queue-url http://localhost:4566/000000000000/product

#RECEIVE MESSAGE DLQ
aws --endpoint-url=http://localhost:4566 sqs receive-message --queue-url http://localhost:4566/000000000000/dlq

#DELETE MESSAGE
ws --endpoint-url=http://localhost:4566 sqs delete-message --queue-url http://localhost:4566/000000000000/product --receipt-handle ''
```
