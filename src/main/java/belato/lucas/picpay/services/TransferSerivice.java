package belato.lucas.picpay.services;

import belato.lucas.picpay.dtos.TransferDto;
import belato.lucas.picpay.entities.Transfer;

public class TransferSerivice {

    private final AuthorizationService authorizationService;
    private final NotificationService notificationService;

    public TransferSerivice(AuthorizationService authorizationService, NotificationService notificationService) {
        this.authorizationService = authorizationService;
        this.notificationService = notificationService;
    }

    public Transfer transfer(TransferDto dto) {
        return null;
    }
}
