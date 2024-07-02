package belato.lucas.picpay.dtos;

import belato.lucas.picpay.entities.Wallet;
import belato.lucas.picpay.entities.WalletType;

public record CreateWalletDto(
        String fullName,
        String cnpjOrCnpj,
        String email,
        String password,
        WalletType.Enum walletType) {

    public Wallet toWallet() {
        return new Wallet(
                fullName,
                cnpjOrCnpj,
                email,
                password,
                walletType.get()
        );
    }
}
