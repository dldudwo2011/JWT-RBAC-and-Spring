package dmit2015.view;

import dmit2015.client.OscarReview;
import dmit2015.client.OscarReviewService;


import lombok.Getter;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.omnifaces.util.Messages;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("currentOscarReviewCreateController")
@RequestScoped
public class OscarReviewCreateController {

    @Inject
    @RestClient
    private OscarReviewService _oscarReviewService;

    @Inject
    private LoginSession _loginSession;

    @Getter
    private OscarReview newOscarReview = new OscarReview();

    public String onCreateNew() {
        String nextPage = "";
        try {
            nextPage = _loginSession.checkForToken();
            if (nextPage == null) {
                String authorization = _loginSession.getAuthorization();
                _oscarReviewService.create(newOscarReview, authorization);
                Messages.addFlashGlobalInfo("Create was successful.");
                nextPage = "index?faces-redirect=true";
            }
        } catch (Exception e) {
            e.printStackTrace();
            Messages.addGlobalError("Create was not successful. {0}", e.getMessage());
        }
        return nextPage;
    }

}