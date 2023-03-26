# elg5164-account-microservice
This is a microservice for managing accounts in a SOA microservice architecture e-commerce platform. The microservice provides APIs for performing CRUD operations on accounts.
## API Endpoints 
Current Base URL: 34.23.38.111 

Get all accounts: 
```
[Get] <Base URL>/accounts
```
Get account by ID:
```
[Get] <Base URL>/accounts/<id>
```
Create a account:
```
[Post] <Base URL>/accounts
```
```
request body
{
    "username": "testname",
    "password": "1"
}
```
Creates a new account. The request body should be a JSON object containing the following fields:

- `username` (string, required): The username of the new account.
- `password` (string, required): The password of the new account.

Delete account by ID:
```
[Delete] <Base URL>/accounts/<id>
```
Delete all accounts:
```
[Delete] <Base URL>/accounts
```
## Getting Started

To get a local copy up and running follow these simple steps:

1. Clone the repository.
2. Build the project with Maven: `mvn clean install`.
3. Run the application: `java -jar target/elg5164-account-microservice-1.0.0.jar`.
4. Test the API endpoints using a tool like [Postman](https://www.postman.com/) or `curl`.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
