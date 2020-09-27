package com.adev.common.base.domian;

import java.io.Serializable;

import com.adev.common.base.enums.ResultEnum;

import lombok.Data;

@Data
public class BaseResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8675344779153880211L;

	private Integer code;

    private String msg;

    private Object data;
    
    public static BaseResult success() {
        BaseResult result = new BaseResult();
        result.setResultEnum(ResultEnum.SUCCESS);
        return result;
    }

    public static BaseResult success(Object data) {
        BaseResult result = new BaseResult();
        result.setResultEnum(ResultEnum.SUCCESS);
        result.setData(data);
        return result;
    }

    public static BaseResult failure(ResultEnum resultEnum) {
        BaseResult result = new BaseResult();
        result.setResultEnum(resultEnum);
        return result;
    }

    public static BaseResult failure(ResultEnum resultEnum, Object data) {
        BaseResult result = new BaseResult();
        result.setResultEnum(resultEnum);
        result.setData(data);
        return result;
    }

    private void setResultEnum(ResultEnum resultEnum) {
        this.code = resultEnum.code();
        this.msg = resultEnum.message();
    }
}
