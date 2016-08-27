package com.funs;

import java.util.Date;

import com.mossle.group.persistence.domain.GroupInfo;
import com.mossle.user.persistence.domain.AccountDevice;

public class GroupInfoController_savaSetNewValue implements FunInterFace_Save{
	private GroupInfo dest;
	private String tenantId;
	public GroupInfoController_savaSetNewValue(String tenantId){
		this.tenantId=tenantId;
	}
	public void setValue(Object dest){
		this.dest=(GroupInfo)dest;
	}
	@Override
	public void execute() {
		if(tenantId!=null){
	        dest.setTenantId(tenantId);
		}
	}
}
