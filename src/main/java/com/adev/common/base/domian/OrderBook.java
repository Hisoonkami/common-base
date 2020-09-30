package com.adev.common.base.domian;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
public class OrderBook {
    private String exchange;

    private String currencyPair;

    private List<PriceAndVolume> bids;

    private List<PriceAndVolume> asks;

    private Long timestamp;
}
