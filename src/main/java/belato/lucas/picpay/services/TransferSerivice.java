package belato.lucas.picpay.services;

import belato.lucas.picpay.dtos.TransferDto;
import belato.lucas.picpay.entities.Transfer;
import belato.lucas.picpay.entities.Wallet;
import belato.lucas.picpay.expections.InsufficientBalanceException;
import belato.lucas.picpay.expections.TransferNotAllowedForWalletTypeException;
import belato.lucas.picpay.expections.TransferNotAuthorizedException;
import belato.lucas.picpay.expections.WalletNotFoundException;
import belato.lucas.picpay.respositories.TransferRepository;
import belato.lucas.picpay.respositories.WalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
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

    @Transactional
    public Transfer transfer(TransferDto transferdto) {

        var sender = walletRepository.findById(transferdto.payer())
                .orElseThrow(() -> new WalletNotFoundException(transferdto.payer()));

        var receiver = walletRepository.findById(transferdto.payee())
                .orElseThrow(() -> new WalletNotFoundException(transferdto.payee()));

        validateTransfer(transferdto, sender);

        sender.debit(transferdto.value());
        receiver.credit(transferdto.value());

        var transfer = new Transfer(sender, receiver, transferdto.value());

        walletRepository.save(sender);
        walletRepository.save(receiver);

        var transferResult = transferRepository.save(transfer);

        CompletableFuture.runAsync(() -> notificationService.sendNotification(transferResult));

        return transferResult;
    }

    private void validateTransfer(TransferDto transferdto, Wallet sender) {
        if(!sender.isTransferWalletForWalletType()) {
            throw new TransferNotAllowedForWalletTypeException();
        }

        if(!sender.isBalancerEqualOrGreaterThan(transferdto.value())) {
            throw new InsufficientBalanceException();
        };

        if(!authorizationService.isAuthorized(transferdto)) {
            throw new TransferNotAuthorizedException();
        }
    }
}
