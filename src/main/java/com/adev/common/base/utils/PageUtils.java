package com.adev.common.base.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;


public class PageUtils {
	
    public static PageRequest pageRequest(Integer pageNumber, Integer pageSize, String sort){
        if(null==pageNumber){
            pageNumber=1;
        }
        if(null==pageSize){
            pageSize=20;
        }
        Sort sortBy=null;
        if(!StringUtils.isEmpty(sort)){
            String[] sortArray=sort.split(",");
            Sort.Direction direction= Sort.Direction.ASC;
            String field=sortArray[0];
            if(sortArray.length>1){
                direction= Sort.Direction.fromString(sortArray[1]);
            }
            sortBy=Sort.by(direction, field);
        }
        if(null==sortBy) {
        	return PageRequest.of(pageNumber,pageSize);
        }
        return PageRequest.of(pageNumber,pageSize,sortBy);
    }
}
