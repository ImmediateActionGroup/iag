package com.iag.service.impl;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.iag.model.IagNotice;
import com.iag.service.NoticeService;
import org.springframework.stereotype.Service;

/**
 * Created by beishan on 2017/3/8.
 */
@Service("noticeService")
public class NoticeServiceImpl extends BaseService<IagNotice> implements NoticeService {
}
