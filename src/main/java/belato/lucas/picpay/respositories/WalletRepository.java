package belato.lucas.picpay.respositories;

import belato.lucas.picpay.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Long> {
}
