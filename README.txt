
Task 1: Java REST API example

Prerequisites:

Java 11+
Maven
MongoDB
Steps:

Create a new Maven project.

Add the following dependencies to your pom.xml file:

Create a new Java class called Server. This class will represent the server object in your REST API.

Create a new Java interface called ServerRepository. This interface will provide methods for interacting with the MongoDB database.

Create a new Java class called ServerService. This class will provide business logic for your REST API.


Create a new Java class called ServerController. This class will expose the REST API endpoints.

Create a new Java class called Application. This class will be the entry point for your application.

Start the MongoDB database.

Start the Spring Boot application.



Task 1: Java REST API example

Prerequisites:

Java 11+
Maven
MongoDB
Steps:

Create a new Maven project.
Add the following dependencies to your pom.xml file:
XML
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
Use code with caution. Learn more
Create a new Java class called Server. This class will represent the server object in your REST API.
Java
@Document(collection = "servers")
public class Server {

    @Id
    private String id;

    private String name;
    private String language;
    private String framework;

    // getters and setters
}
Use code with caution. Learn more
Create a new Java interface called ServerRepository. This interface will provide methods for interacting with the MongoDB database.
Java
public interface ServerRepository extends MongoRepository<Server, String> {

    List<Server> findByNameContains(String name);
}
Use code with caution. Learn more
Create a new Java class called ServerService. This class will provide business logic for your REST API.
Java
public class ServerService {

    private ServerRepository serverRepository;

    public ServerService(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    public List<Server> getAllServers() {
        return serverRepository.findAll();
    }

    public Server getServerById(String id) {
        return serverRepository.findById(id).orElse(null);
    }

    public Server createServer(Server server) {
        return serverRepository.save(server);
    }

    public void deleteServer(String id) {
        serverRepository.deleteById(id);
    }

    public List<Server> findServersByNameContains(String name) {
        return serverRepository.findByNameContains(name);
    }
}
Use code with caution. Learn more
Create a new Java class called ServerController. This class will expose the REST API endpoints.
Java
@RestController
public class ServerController {

    private ServerService serverService;

    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    @GetMapping("/servers")
    public List<Server> getAllServers() {
        return serverService.getAllServers();
    }

    @GetMapping("/servers/{id}")
    public Server getServerById(@PathVariable String id) {
        return serverService.getServerById(id);
    }

    @PutMapping("/servers")
    public Server createServer(@RequestBody Server server) {
        return serverService.createServer(server);
    }

    @DeleteMapping("/servers/{id}")
    public void deleteServer(@PathVariable String id) {
        serverService.deleteServer(id);
    }

    @GetMapping("/servers/find")
    public List<Server> findServersByNameContains(@RequestParam String name) {
        return serverService.findServersByNameContains(name);
    }
}
Use code with caution. Learn more
Create a new Java class called Application. This class will be the entry point for your application.
Java
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
Use code with caution. Learn more
Start the MongoDB database.
Start the Spring Boot application.
Testing the REST API with Postman:

Open Postman.

Create a new GET request to http://localhost:8080/servers.

Send the request.

You should see a list of all the servers in the response body.

Create a new POST request to http://localhost:8080/servers.

In the request body, add the following JSON payload:



