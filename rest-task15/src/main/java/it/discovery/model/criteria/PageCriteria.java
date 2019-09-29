package it.discovery.model.criteria;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PageCriteria {

    private final int pageIndex;

    private final int pageSize;
}
