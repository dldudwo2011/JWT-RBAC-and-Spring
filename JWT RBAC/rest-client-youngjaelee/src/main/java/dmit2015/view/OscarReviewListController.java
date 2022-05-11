package dmit2015.view;

import dmit2015.client.OscarReview;
import dmit2015.client.OscarReviewService;
import lombok.Getter;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;


@Named("currentOscarReviewListController")
@ViewScoped
public class OscarReviewListController implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    @RestClient
    private OscarReviewService _oscarReviewService;


    @Inject
    LoginSession loginSession;

    @Getter
    private List<OscarReview> oscarReviewList;

    @PostConstruct  // After @Inject is complete
    public void init() {
        try {
            oscarReviewList = _oscarReviewService.findAllForUser(loginSession.getAuthorization());
        } catch (Exception ex) {
            Messages.addGlobalError(ex.getMessage());
        }
    }
}