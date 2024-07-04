package belato.lucas.picpay.respositories;

import belato.lucas.picpay.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet,Long> {
    Optional<Wallet> findBycpfCnpjOrEmail(String cpfCnpj, String email);
}
