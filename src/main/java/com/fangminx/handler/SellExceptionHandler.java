package com.fangminx.handler;

import com.fangminx.Util.ResultVOUtil;
import com.fangminx.exception.ResponseBankException;
import com.fangminx.exception.SellException;
import com.fangminx.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SellExceptionHandler {

    /**
     * 当报错时防止json格式改变，但错误码会变为200
     */
    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }

    /**
     * 可以修改错误码，防止它为200
     */
    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleResponseBankException(){

    }
}
