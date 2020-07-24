package com.pekah.dto;

import lombok.Data;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Data
@Resource
public class PageDTO {
    private List<PostDTO> postDTOList;
    private boolean showFirst;
    private boolean showEnd;
    private Integer colPage;        //当前页面
    private Integer totalPage;
    private Integer prePage;
    private Integer nextPage;
    private List<Integer> pageList = new ArrayList<>();

    public void back(Integer sum, Integer page, Integer size) {
        Integer sumPage;
        if(sum%size==0){
            sumPage = sum/size;
        }
        else{
            sumPage = sum/size+1;
        }

        if(page<1){
            page=1;
        }
        if(page>sumPage){
            page=sumPage;
        }

        this.colPage=page;
        this.totalPage=sumPage;

        if(page>=5){
            showFirst=true;
        }
        if(page<=sumPage-4){
            showEnd=true;
        }

        pageList.add(page);

        if(page<=3){
            for(int i=1;i<=3;i++){
                if(page - i>0){
                    pageList.add(0,page-i);
                }
                if(page+i<=sumPage){
                    pageList.add(page+i);
                }
            }
        }
    }
}
