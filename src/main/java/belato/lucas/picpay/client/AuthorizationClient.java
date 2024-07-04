package belato.lucas.picpay.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        url = "${client.authorization-service.url}"
)
public interface AuthorizationClient {
    @GetMapping
}
