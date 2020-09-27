package com.adev.common.base.domian;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
public class Kline {
    private String exchange;

    private String currencyPair;

    private BigDecimal last;// 收盘价

    private BigDecimal open;

    private BigDecimal high;

    private BigDecimal low;

    private BigDecimal priceChange;// 涨幅

    private BigDecimal amplitude;// 振幅

    private BigDecimal originalAmount;// 成交量

    private Long timestamp;// 行情时间
}
