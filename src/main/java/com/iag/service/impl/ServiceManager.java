package com.iag.service.impl;

import com.iag.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service 集中管理类
 * Created by beishan on 2017/3/8.
 */
@Service
public class ServiceManager {
    @Autowired
    private AttentionService attentionService;
    @Autowired
    private BoardService boardService;
    @Autowired
    private CommentsService commentsService;
    @Autowired
    private LabelService labelService;
    @Autowired
    private LogService logService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private PostsService postsService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserBoardService userBoardService;
    @Autowired
    private UserConfigService userConfigService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserService userService;
    @Autowired
    private ResPerService resPerService;
    @Autowired
    private DarkroomService darkroomService;

    public AttentionService getAttentionService() {
        return attentionService;
    }

    public BoardService getBoardService() {
        return boardService;
    }

    public CommentsService getCommentsService() {
        return commentsService;
    }

    public LabelService getLabelService() {
        return labelService;
    }

    public LogService getLogService() {
        return logService;
    }

    public MessageService getMessageService() {
        return messageService;
    }

    public NoticeService getNoticeService() {
        return noticeService;
    }

    public PermissionService getPermissionService() {
        return permissionService;
    }

    public PostsService getPostsService() {
        return postsService;
    }

    public ResourceService getResourceService() {
        return resourceService;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public UserBoardService getUserBoardService() {
        return userBoardService;
    }

    public UserConfigService getUserConfigService() {
        return userConfigService;
    }

    public UserRoleService getUserRoleService() {
        return userRoleService;
    }

    public UserService getUserService() {
        return userService;
    }

    public ResPerService getResPerService() {
        return resPerService;
    }

    public DarkroomService getDarkroomService() {
        return darkroomService;
    }
}
