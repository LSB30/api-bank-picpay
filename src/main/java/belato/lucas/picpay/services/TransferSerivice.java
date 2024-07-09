package belato.lucas.picpay.services;

import belato.lucas.picpay.dtos.TransferDto;
import belato.lucas.picpay.entities.Transfer;
import belato.lucas.picpay.entities.Wallet;
import belato.lucas.picpay.expections.WalletNotFoundException;
import belato.lucas.picpay.respositories.TransferRepository;
import belato.lucas.picpay.respositories.WalletRepository;

public class TransferSerivice {

    private final TransferRepository transferRepository;
    private final AuthorizationService authorizationService;
    private final NotificationService notificationService;

    private final WalletRepository walletRepository;

    public TransferSerivice(TransferRepository transferRepository, AuthorizationService authorizationService, NotificationService notificationService, WalletRepository walletRepository) {
        this.transferRepository = transferRepository;
        this.authorizationService = authorizationService;
        this.notificationService = notificationService;
        this.walletRepository = walletRepository;
    }

    public Transfer transfer(TransferDto transferdto) {

        var sender = walletRepository.findById(transferdto.payer())
                .orElseThrow(() -> new WalletNotFoundException(transferdto.payer()));

        var receiver = walletRepository.findById(transferdto.payee())
                .orElseThrow(() -> new WalletNotFoundException(transferdto.payee()));

        validateTransfer(transferdto, sender);

        return null;
    }

    private void validateTransfer(TransferDto transferdto, Wallet sender) {
        if(!sender.isTransferWalletForWalletType()) {
            throw new TransferNotAllowedForWalletTypeExecption();
        }
    }
}
