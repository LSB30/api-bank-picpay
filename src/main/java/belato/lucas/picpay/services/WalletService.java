package belato.lucas.picpay.services;

import belato.lucas.picpay.dtos.CreateWalletDto;
import belato.lucas.picpay.entities.Wallet;
import belato.lucas.picpay.respositories.WalletTypeRepository;

public class WalletService {

    private final WalletTypeRepository walletTypeRepository;

    public WalletService(WalletTypeRepository walletTypeRepository) {
        this.walletTypeRepository = walletTypeRepository;
    }

    public Wallet createWallet(CreateWalletDto dto) {

    }
}
