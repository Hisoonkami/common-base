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
public class Trade {
    private String exchange;

    private String currencyPair;

    private String tradeType;// 交易类型

    private BigDecimal price;// 成交价格

    private BigDecimal originalAmount;// 成交量

    private Long tradeId;// 交易所的交易id

    private Long timestamp;
}
