import java.util.List;

public class Request {
    private String method;
    private String url;
    private String version;
    private List<String> header;
    private String body;

    public Request(){
    }

    public Request(String method, String url, String version, List<String> header, String body) {
        this.method = method;
        this.url = url;
        this.version = version;
        this.header = header;
        this.body = body;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<String> getHeader() {
        return header;
    }

    public void setHeader(List<String> header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
