package com.storyhasyou.crystal.common.exception;

import com.storyhasyou.crystal.common.result.ResultCodeEnum;
import com.storyhasyou.kratos.exceptions.BusinessException;

/**
 * @author fangxi created by 2022/6/20
 */
public class CrystalException extends BusinessException {

    public CrystalException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getCode(), resultCodeEnum.getMessage());
    }
}
