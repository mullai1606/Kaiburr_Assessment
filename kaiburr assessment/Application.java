@Document(collection = "servers")
public class Server {

    @Id
    private String id;

    private String name;
    private String language;
    private String framework;

    // getters and setters
}

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

public interface ServerRepository extends MongoRepository<Server, String> {

    List<Server> findByNameContains(String name);
}

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


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
