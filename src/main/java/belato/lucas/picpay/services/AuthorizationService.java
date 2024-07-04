package belato.lucas.picpay.services;

import belato.lucas.picpay.client.AuthorizationClient;
import belato.lucas.picpay.entities.Transfer;
import belato.lucas.picpay.expections.PicpayExpection;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
    private  final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized(Transfer transfer) {
        var resp = authorizationClient.isAuthorized();
        if(resp.getStatusCode().isError()) {
            throw new PicpayExpection();
        }

        return resp.getBody().authorized();
    }
}
