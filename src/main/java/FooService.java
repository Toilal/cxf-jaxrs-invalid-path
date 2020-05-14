import javax.ws.rs.GET;
import javax.ws.rs.Path;

public interface FooService {
    @GET
    @Path("bar")
    void bar();
}
