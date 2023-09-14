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
