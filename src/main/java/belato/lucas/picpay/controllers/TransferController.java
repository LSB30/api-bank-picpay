package belato.lucas.picpay.controllers;

import belato.lucas.picpay.entities.Transfer;
import belato.lucas.picpay.services.TransferSerivice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    private final TransferSerivice transferSerivice;

    public TransferController(TransferSerivice transferSerivice) {
        this.transferSerivice = transferSerivice;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> transfer(@RequestBody TransferDto) {

    }
}
