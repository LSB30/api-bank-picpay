package belato.lucas.picpay.client;

import belato.lucas.picpay.dtos.AuthorizationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "AuthorizationClient",
        url = "${client.authorization-service.url}"
)
public interface AuthorizationClient {
    @GetMapping
    ResponseEntity<AuthorizationResponse> isAuthorized();
}
