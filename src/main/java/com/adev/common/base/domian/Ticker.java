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
public class Ticker {

    private String exchange;

    private String currencyPair;

    private BigDecimal last;// 当前价格

    private BigDecimal open;// 开盘价格

    private BigDecimal high;

    private BigDecimal low;

    private BigDecimal volume;// 成交数量

    private BigDecimal quoteVolume;// 成交额

    private BigDecimal valueChange;// 涨跌量

    private BigDecimal priceChange;// 涨幅

    private Long timestamp;
}
