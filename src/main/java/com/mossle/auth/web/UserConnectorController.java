package com.mossle.auth.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.comm.Page;
import com.comm.Pageable;
import com.comm.Tools;
import com.mossle.api.tenant.TenantHolder;
import com.mossle.api.user.UserConnector;
import com.mossle.api.user.UserDTO;

import com.mossle.auth.component.UserStatusConverter;
import com.mossle.auth.persistence.domain.UserStatus;
import com.mossle.auth.persistence.manager.UserStatusManager;
import com.mossle.auth.service.AuthService;
import com.mossle.auth.support.UserStatusDTO;
import com.mossle.core.util.ServletUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("auth")
public class UserConnectorController {
    private static Logger logger = LoggerFactory
            .getLogger(UserConnectorController.class);
    private UserStatusManager userStatusManager;
    private UserStatusConverter userStatusConverter;
    private UserConnector userConnector;
    private AuthService authService;
    private TenantHolder tenantHolder;

    @RequestMapping("user-connector-list")
    public String list(Pageable pageable,@RequestParam Map<String, Object> parameterMap, Model model) {
        Tools tools=new Tools();
        Page page=tools.listForPage(tenantHolder, pageable, parameterMap, userStatusManager,"UserStatus","username");
        List<UserStatus> userStatuses = (List<UserStatus>) page.getResult();
        List<UserStatusDTO> userStatusDtos = new ArrayList<UserStatusDTO>();
        for (UserStatus userStatus : userStatuses)
            userStatusDtos.add(userStatusConverter.createUserStatusDto(userStatus, tenantHolder.getUserRepoRef(),tenantHolder.getTenantId()));
        page.setResult(userStatusDtos);
        model.addAttribute("page", page);
        return "auth/user-connector-list";
    }

    @RequestMapping("user-connector-configRole")
    public String configRole(@RequestParam("ref") String ref) {
        logger.debug("ref : {}", ref);
        UserDTO userDto = userConnector.findById(ref);
        Long id = null;
        if (userDto != null) {
            String username = userDto.getUsername();
            UserStatus userStatus = authService.createOrGetUserStatus(username,userDto.getId(), tenantHolder.getUserRepoRef(),tenantHolder.getTenantId());
            id = userStatus.getId();
        }
        return "redirect:/auth/user-role-input.do?id=" + id;
    }

    // ~ ======================================================================
    @Resource
    public void setUserStatusManager(UserStatusManager userStatusManager) {
        this.userStatusManager = userStatusManager;
    }

    @Resource
    public void setUserStatusConverter(UserStatusConverter userStatusConverter) {
        this.userStatusConverter = userStatusConverter;
    }

    @Resource
    public void setUserConnector(UserConnector userConnector) {
        this.userConnector = userConnector;
    }

    @Resource
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @Resource
    public void setTenantHolder(TenantHolder tenantHolder) {
        this.tenantHolder = tenantHolder;
    }
}