package com.iag.service.impl;

import com.iag.model.IagMessage;
import com.iag.service.MessageService;
import org.springframework.stereotype.Service;

/**
 * Created by beishan on 2017/3/8.
 */
@Service("messageService")
public class MessageServiceImpl extends BaseService<IagMessage> implements MessageService {
}
