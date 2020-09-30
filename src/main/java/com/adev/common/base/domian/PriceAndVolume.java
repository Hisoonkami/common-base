package com.adev.common.base.domian;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class PriceAndVolume {
    private BigDecimal price;

    private BigDecimal volume;
}
