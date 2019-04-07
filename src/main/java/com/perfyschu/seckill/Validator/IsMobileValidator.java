package com.perfyschu.seckill.Validator;

import com.perfyschu.seckill.util.ValidatorUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 文件名：IsMobileValidator.java
 * 创建日期：2019/4/7 16:51
 * 说明：
 *
 * @author PerfySchu
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile, String>{

    private boolean required = false;

    @Override
    public void initialize(IsMobile isMobile) {
        required = isMobile.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(required){
            return ValidatorUtil.isMobile(value);
        }else{
            if(StringUtils.isEmpty(value)){
                return true;
            }else{
                return ValidatorUtil.isMobile(value);
            }
        }
    }
}
