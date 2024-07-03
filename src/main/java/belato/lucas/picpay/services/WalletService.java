package belato.lucas.picpay.services;

import belato.lucas.picpay.dtos.CreateWalletDto;
import belato.lucas.picpay.entities.Wallet;
import belato.lucas.picpay.expections.WalletDataAlreadyExsitsException;
import belato.lucas.picpay.respositories.WalletRepository;
import belato.lucas.picpay.respositories.WalletTypeRepository;

public class WalletService {

   private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(CreateWalletDto dto) {
        var wallettDb = walletRepository.findBycpfOrCnpjOrEmail(dto.cnpjOrCnpj(), dto.email());
        if(wallettDb.isPresent()) {
            throw new WalletDataAlreadyExsitsException("Cpf,Cnpj or Email already exists");
        }
        return walletRepository.save(dto.toWallet());
    }
}
