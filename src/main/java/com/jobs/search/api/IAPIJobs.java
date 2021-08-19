package com.jobs.search.api;

import com.jobs.search.JobPosition;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;
import java.util.List;
import java.util.Map;

@Headers("Accept: application/json")
public interface IAPIJobs {

    @RequestLine("GET /position.json")
    List<JobPosition> jobs(@QueryMap Map<String, Object> query);


}
