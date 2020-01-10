package com.example.imitatecommunity.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by MGZ
 * @date 2019/11/7
 * @DESC:
 */
@Data
public class PagInationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pageList;
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
       /* Integer totalPage ;*/
        totalPage = (totalCount % size == 0) ? (totalCount / size) : (totalCount / size + 1);
        if(page < 1){
            page = 1;
        }
        if(page > totalPage){
            page = totalPage;
        }
        this.page = page;
        pageList = new ArrayList<>();
        pageList.add(page);
        for(int i = 1 ; i <= 3 ; i++){
            if(page - i > 0){
                pageList.add(0,page - i);
            }
            if(page + i <= totalPage){
                pageList.add(page + i);
            }
        }
        if(page == 1){
            showNext = false;
        }else{
            showNext = false;
        }
        showPrevious = (page == 1) ? false : true;
        showNext = (page == totalPage) ? false : true;
        showFirstPage = (pageList.contains(1)) ? false : true;
        showEndPage = (pageList.contains(totalPage)) ? false : true;

    }
}
