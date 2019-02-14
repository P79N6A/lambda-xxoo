package com.yatop.lambda.portal.job.dao;


import com.yatop.lambda.portal.common.config.MyMapper;
import com.yatop.lambda.portal.job.domain.Job;

import java.util.List;

public interface JobMapper extends MyMapper<Job> {
	
	List<Job> queryList();
}