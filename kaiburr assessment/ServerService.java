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
