package com.server.api.feign.client.dto;

import com.server.api.feign.client.enums.SortEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilterListDto implements Serializable {
    private Long limit;
    private SortEnum sort;
}
