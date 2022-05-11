/**
 * @author Youngjae Lee
 * @version 2022-02-13
 *
 * description: Entity class
 */

package dmit2015.client;



import lombok.Data;


/**
 * The persistent class for the OscarReviews database table.
 */

@Data
public class OscarReview {

    private Long id;
    private String category;
    private String nominee;
    private String review;
    private String username;
}