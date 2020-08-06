package lol.work.stop;



public class util {
    static final String HOST="http://localhost:8080/WebTest/";

    public util() {
    }
    public static String fullPath(String path){
        return HOST+path;
    }
}
