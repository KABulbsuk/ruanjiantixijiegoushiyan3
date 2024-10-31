package com.krf.twocs.domain.po.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageQuery {
    private String name;
    private int pageNum;
    private int pageSize;
}
