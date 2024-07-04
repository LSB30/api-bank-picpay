package belato.lucas.picpay.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransferDto(@DecimalMin("0.01") @NotNull BigDecimal value,
                          @NotNull long payer,
                          @NotNull long payee) {
}
