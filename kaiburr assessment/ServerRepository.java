public interface ServerRepository extends MongoRepository<Server, String> {

    List<Server> findByNameContains(String name);
}
