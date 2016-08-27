package com.mossle.user.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.comm.Filter.Operator;
import com.comm.Order.Direction;
import com.comm.Page;
import com.comm.Pageable;
import com.comm.Tools;
import com.mossle.api.store.StoreConnector;
import com.mossle.api.tenant.TenantHolder;
import com.mossle.api.user.UserCache;
import com.mossle.api.user.UserDTO;

import com.mossle.core.auth.CustomPasswordEncoder;
import com.mossle.core.export.Exportor;
import com.mossle.core.mapper.BeanMapper;
import com.mossle.core.query.PropertyFilter;
import com.mossle.core.spring.MessageHelper;

import com.mossle.user.persistence.domain.AccountAvatar;
import com.mossle.user.persistence.domain.AccountCredential;
import com.mossle.user.persistence.domain.AccountInfo;
import com.mossle.user.persistence.domain.PersonInfo;
import com.mossle.user.persistence.manager.AccountAvatarManager;
import com.mossle.user.persistence.manager.AccountCredentialManager;
import com.mossle.user.persistence.manager.AccountInfoManager;
import com.mossle.user.persistence.manager.PersonInfoManager;
import com.mossle.user.publish.UserPublisher;

import org.hibernate.cfg.beanvalidation.GroupsPerOperation.Operation;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("user")
public class AccountInfoController {
    private AccountInfoManager accountInfoManager;
    private AccountCredentialManager accountCredentialManager;
    private AccountAvatarManager accountAvatarManager;
    private PersonInfoManager personInfoManager;
    private UserCache userCache;
    private MessageHelper messageHelper;
    private Exportor exportor;
    private BeanMapper beanMapper = new BeanMapper();
    private CustomPasswordEncoder customPasswordEncoder;
    private StoreConnector storeConnector;
    private UserPublisher userPublisher;
    private TenantHolder tenantHolder;

    @RequestMapping("account-info-list")
    public String list(Pageable pageable,@RequestParam Map<String, Object> parameterMap, Model model) {
    		Tools tools=new Tools();
        model.addAttribute("page", tools.listForPage(tenantHolder, pageable, parameterMap, accountInfoManager,"AccountInfo"));
        return "user/account-info-list";
    }

    @RequestMapping("account-info-input")
    public String input(@RequestParam(value = "id", required = false) Long id,Model model) {
        Tools.infoInput(accountInfoManager, model, id);
        return "user/account-info-input";
    }

    //两次输入密码不符
    private String passWordEequalsNull(String password,String confirmPassword,RedirectAttributes redirectAttributes){
	    	if (password != null && !password.equals(confirmPassword)) {
	    		messageHelper.addFlashMessage(redirectAttributes,"user.user.input.passwordnotequals", "两次输入密码不符");
	    		return "user/account-info-input";
	    	}
	    return null;
    }
    //有记录就取原来的记录
    private AccountInfo hasRecordCopyTo(AccountInfo dest,AccountInfo accountInfo,Long id){
        dest = accountInfoManager.get(id);
        dest.setStatus("active");
        beanMapper.copy(accountInfo, dest);
        return dest;
    }
    //没有记录就设置新的值
    private AccountInfo noRecordSetValue(AccountInfo dest,AccountInfo accountInfo,String tenantId ){
        dest = accountInfo;
        dest.setCreateTime(new Date());
        dest.setTenantId(tenantId);
        return dest;
    }
    //有记录就取原来的记录,没有记录就设置新的值
    private AccountInfo hasRecordCopyNoRecordSetValue(AccountInfo dest,AccountInfo accountInfo,Long id,String tenantId ){
        if (id != null)
        		dest=hasRecordCopyTo(dest,accountInfo,id);
        	else
        		dest=noRecordSetValue(dest,accountInfo,tenantId);
        return dest;
    }
    //保存账号密码和账号信息
    private AccountCredential accountCredentialSetValue(AccountCredential accountCredential,AccountInfo accountInfo){
        accountCredential = new AccountCredential();
        accountCredential.setAccountInfo(accountInfo);
        accountCredential.setType("normal");
        accountCredential.setCatalog("default");
        return accountCredential;
    }
    private void savePassWordPasswordIsNoNull(String password,AccountInfo accountInfo){
	    	Pageable pageable =new Pageable();
	    	pageable.addFilter("accountInfo", Operator.eq, accountInfo);
	    	pageable.addFilter("catalog", Operator.eq, "default");
	    	AccountCredential accountCredential=(AccountCredential)accountCredentialManager.find(pageable,"AccountCredential");
		if (accountCredential == null)
			accountCredential=accountCredentialSetValue(accountCredential,accountInfo);
	    if (customPasswordEncoder != null)
	        accountCredential.setPassword(customPasswordEncoder.encode(password));
	    else 
	        accountCredential.setPassword(password);
	    accountCredentialManager.save(accountCredential);
    }
    //保存密码
    private void savePassWord(String password,AccountInfo accountInfo){
        if (password != null)
        		savePassWordPasswordIsNoNull(password,accountInfo);
    }
    //清理账号缓存
    private void clearUserCache(AccountInfo dest,String tenantId){
        UserDTO userDto = new UserDTO();
        userDto.setId(Long.toString(dest.getId()));
        userDto.setUsername(dest.getUsername());
        userDto.setRef(dest.getCode());
        userDto.setUserRepoRef(tenantId);
        userCache.removeUser(userDto);
    }
    //通知
    private void notify(Long id,AccountInfo dest){
        if (id != null)
            userPublisher.notifyUserUpdated(this.convertUserDto(dest));
        else 
            userPublisher.notifyUserCreated(this.convertUserDto(dest));
    }
    @RequestMapping("account-info-save")
    public String save(
            @ModelAttribute AccountInfo accountInfo,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "confirmPassword", required = false) String confirmPassword,
            RedirectAttributes redirectAttributes) throws Exception {
        String tenantId = tenantHolder.getTenantId();
        // 先进行校验
        	String retstr=null;
    		if((retstr=passWordEequalsNull(password,confirmPassword,redirectAttributes))!=null)
    			return retstr;
        // 再进行数据复制
        AccountInfo dest = null;
        Long id = accountInfo.getId();
        dest=hasRecordCopyNoRecordSetValue(dest,accountInfo,id,tenantId);
        accountInfoManager.save(dest);
        if (dest.getCode() == null) {
            dest.setCode(Long.toString(dest.getId()));
            accountInfoManager.save(dest);
        }
        savePassWord( password, accountInfo);
        messageHelper.addFlashMessage(redirectAttributes, "core.success.save","保存成功");
        //清缓存
        clearUserCache(accountInfo,tenantId);
        //通知
        notify(id,dest);
        return "redirect:/user/account-info-list.do";
    }

    //清理账号和密码，还有账号缓存
    private void removeAccountCredentialAndAccountAvatarAndUserCache(AccountInfo accountInfo,String tenantId){
        for (AccountCredential accountCredential : accountInfo.getAccountCredentials())
            accountCredentialManager.remove(accountCredential);
        for (AccountAvatar accountAvatar : accountInfo.getAccountAvatars())
            accountAvatarManager.remove(accountAvatar);
        accountInfoManager.remove(accountInfo);
        clearUserCache(accountInfo, tenantId);
        userPublisher.notifyUserRemoved(this.convertUserDto(accountInfo));
    }
    @RequestMapping("account-info-remove")
    public String remove(@RequestParam("selectedItem") List<Long> selectedItem,RedirectAttributes redirectAttributes) {
        String tenantId = tenantHolder.getTenantId();
        List<AccountInfo> accountInfos = accountInfoManager.findByIds(selectedItem);
        for (AccountInfo accountInfo : accountInfos)
        		removeAccountCredentialAndAccountAvatarAndUserCache(accountInfo,tenantId);
        messageHelper.addFlashMessage(redirectAttributes,"core.success.delete", "删除成功");
        return "redirect:/user/account-info-list.do";
    }

    @RequestMapping("account-info-active")
    public String active(@RequestParam("id") Long id,RedirectAttributes redirectAttributes) {
        AccountInfo accountInfo = accountInfoManager.get(id);
        accountInfo.setStatus("active");
        accountInfoManager.save(accountInfo);
        messageHelper.addFlashMessage(redirectAttributes,"core.success.update", "操作成功");
        userPublisher.notifyUserUpdated(this.convertUserDto(accountInfo));
        return "redirect:/user/account-info-list.do";
    }

    @RequestMapping("account-info-disable")
    public String disable(@RequestParam("id") Long id,RedirectAttributes redirectAttributes) {
        AccountInfo accountInfo = accountInfoManager.get(id);
        accountInfo.setStatus("disabled");
        accountInfoManager.save(accountInfo);
        messageHelper.addFlashMessage(redirectAttributes,"core.success.update", "操作成功");
        userPublisher.notifyUserUpdated(this.convertUserDto(accountInfo));
        return "redirect:/user/account-info-list.do";
    }

    @RequestMapping("account-info-checkUsername")
    @ResponseBody
    public boolean checkUsername(@RequestParam("username") String username, @RequestParam(value = "id", required = false) Long id)throws Exception {
        String tenantId = tenantHolder.getTenantId();
        Pageable pageable =new Pageable();
        pageable.addFilter("username", Operator.eq, username);
        pageable.addFilter("tenantId", Operator.eq, tenantId);
        if (id != null)
        		pageable.addFilter("id", Operator.ne, id);
        Long ret=accountInfoManager.findCount(pageable, "AccountInfo");
        if(ret!=null && ret>0 )
        		return false;
        	else
        		return true;
    }

    public UserDTO convertUserDto(AccountInfo accountInfo) {
        String hql = "from PersonInfo where code=? and tenantId=?";
        PersonInfo personInfo = personInfoManager.findUnique(hql,accountInfo.getCode(), accountInfo.getTenantId());
        UserDTO userDto = new UserDTO();
        userDto.setId(Long.toString(accountInfo.getId()));
        userDto.setUsername(accountInfo.getUsername());
        userDto.setDisplayName(accountInfo.getDisplayName());
        userDto.setNickName(accountInfo.getNickName());
        userDto.setUserRepoRef(accountInfo.getTenantId());
        if (personInfo != null) {
            userDto.setEmail(personInfo.getEmail());
            userDto.setMobile(personInfo.getCellphone());
        }
        return userDto;
    }

    // ~ ======================================================================
    @Resource
    public void setAccountInfoManager(AccountInfoManager accountInfoManager) {
        this.accountInfoManager = accountInfoManager;
    }

    @Resource
    public void setAccountCredentialManager(
            AccountCredentialManager accountCredentialManager) {
        this.accountCredentialManager = accountCredentialManager;
    }

    @Resource
    public void setAccountAvatarManager(
            AccountAvatarManager accountAvatarManager) {
        this.accountAvatarManager = accountAvatarManager;
    }

    @Resource
    public void setPersonInfoManager(PersonInfoManager personInfoManager) {
        this.personInfoManager = personInfoManager;
    }

    @Resource
    public void setUserCache(UserCache userCache) {
        this.userCache = userCache;
    }

    @Resource
    public void setMessageHelper(MessageHelper messageHelper) {
        this.messageHelper = messageHelper;
    }

    @Resource
    public void setCustomPasswordEncoder(
            CustomPasswordEncoder customPasswordEncoder) {
        this.customPasswordEncoder = customPasswordEncoder;
    }

    @Resource
    public void setExportor(Exportor exportor) {
        this.exportor = exportor;
    }

    @Resource
    public void setStoreConnector(StoreConnector storeConnector) {
        this.storeConnector = storeConnector;
    }

    @Resource
    public void setUserPublisher(UserPublisher userPublisher) {
        this.userPublisher = userPublisher;
    }

    @Resource
    public void setTenantHolder(TenantHolder tenantHolder) {
        this.tenantHolder = tenantHolder;
    }
}
