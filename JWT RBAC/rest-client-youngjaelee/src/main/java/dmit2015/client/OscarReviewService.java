package dmit2015.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

/**
 * The baseUri for the web service be set in either microprofile-config.properties (recommended)
 * or in this file using @RegisterRestClient(baseUri = "http://server/path").
 *
 * To set the baseUri in microprofile-config.properties:
 *    1) Open src/main/resources/META-INF/microprofile-config.properties
 *    2) Add a key/value pair in the following format:
 *          package-name.ClassName/mp-rest/url=baseUri
 *       For example:
 *          package-name:    dmit2015.client
 *          ClassName:       EmployeeService
 *          baseUri:         https://localhost:8443/contextName
 *       The key/value pair you need to add is:
 *          dmit2015.client.EmployeeService/mp-rest/url=https://localhost:8443/backend/webapi
 *
 *
 * To use the client interface from an environment does support CDI, add @Inject and @RestClient before the field declaration such as:
 *
 *     @Inject
 *     @RestClient
 *     private EmployeeService _employeeService;
 *
 * To use the client interface from an environment that does not support CDI, you can use the RestClientBuilder class to programmatically build an instance as follows:
 *
 *      URI apiURi = new URI("http://sever/contextName");
 *      EmployeeService _EmployeeService = RestClientBuilder.newBuilder()
 *                 .baseUri(apiURi)
 *                 .build(EmployeeService.class);
 *
 */
@RegisterRestClient(baseUri = "https://localhost:8443/rest-services-youngjaelee/webapi")
@Path("/OscarReviews")
public interface OscarReviewService {

    @GET
    List<OscarReview> findAll();

    @GET
    @Path("/user")
    List<OscarReview> findAllForUser(@HeaderParam("Authorization") String authorization);

    @POST
    Response create(OscarReview newReview, @HeaderParam("Authorization") String authorization);

}