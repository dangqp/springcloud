package com.example.springbootbatch.basebatch;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

import java.util.Map;

/**
 * Title:com.example.springbootbatch.basebatch
 * Description:
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/09/13  09:41
 */

public class BookPartionerConfig implements Partitioner {

    @Override
    public Map<String, ExecutionContext> partition(int i) {
        return null;
    }
}
