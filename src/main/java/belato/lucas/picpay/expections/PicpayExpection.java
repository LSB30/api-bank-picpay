package belato.lucas.picpay.expections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class PicpayExpection extends RuntimeException{

    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        pb.setTitle("PicPay internal server error");


        return pb;
    }
}
