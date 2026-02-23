public interface Persistence {
    void save(String id, String content);
    int countLines(String id);
}
