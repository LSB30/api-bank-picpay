package belato.lucas.picpay.services;

import belato.lucas.picpay.client.AuthorizationClient;
import belato.lucas.picpay.dtos.TransferDto;
import belato.lucas.picpay.expections.PicpayException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
    private  final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized(TransferDto transfer) {
        var resp = authorizationClient.isAuthorized();
        if(resp.getStatusCode().isError()) {
            throw new PicpayException();
        }

        return resp.getBody().authorized();
    }
}
