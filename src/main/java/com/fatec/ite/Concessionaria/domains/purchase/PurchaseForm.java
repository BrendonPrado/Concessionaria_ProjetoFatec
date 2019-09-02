package com.fatec.ite.Concessionaria.domains.purchase;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class PurchaseForm {

    @NotNull
    private Integer buyerId;

    @NotNull
    private Integer AdId;
}
