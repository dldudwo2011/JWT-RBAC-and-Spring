/**
 * @author Youngjae Lee
 * @version 2022-02-13
 *
 * description: Repository class
 */

package dmit2015.repository;

import common.jpa.AbstractJpaRepository;
import dmit2015.entity.OscarReview;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Transactional
public class OscarReviewRepository extends AbstractJpaRepository<OscarReview, Long> {

    public OscarReviewRepository() {
        super(OscarReview.class);
    }

    public List<OscarReview> findAllByUsername(String username) {
        List<OscarReview> queryResultList;

        queryResultList = super.getEntityManager().createQuery(
                        "SELECT o FROM OscarReview o WHERE o.username = :usernameValue", OscarReview.class)
                .setParameter("usernameValue", username).getResultList();
        return queryResultList;
    }
}