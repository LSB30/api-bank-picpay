package belato.lucas.picpay.expections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletNotFoundException extends PicpayExpection{

    private Long walletid;

    public WalletNotFoundException(Long walletid) {
        this.walletid = walletid;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("Wallet not found");
        pb.setDetail("There is no wallet with id" + walletid + "." );

        return pb;
    }
}
