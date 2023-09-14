@Document(collection = "servers")
public class Server {

    @Id
    private String id;

    private String name;
    private String language;
    private String framework;

    // getters and setters
}
