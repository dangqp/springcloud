package com.example.springbootaop.service;

import com.example.springbootaop.domain.ResultVO;
import org.springframework.stereotype.Service;

/**
 * Title:com.example.springbootaop.service
 * Description:
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/10/12  15:34
 */
@Service
public class HelloServiceImple {

    public ResultVO get(){

        String str = "hello world";

        ResultVO resultVO = new ResultVO();
        resultVO.setMessage("斤斤计较军");
        resultVO.setCode(0);
        resultVO.setData(str);
        return resultVO;
    }
}
