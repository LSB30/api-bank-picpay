package belato.lucas.picpay.dtos;

import java.math.BigDecimal;

public record TransferDto(BigDecimal value,
                          long payer,
                          long payee) {
}
