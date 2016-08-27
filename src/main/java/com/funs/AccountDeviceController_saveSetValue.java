package com.funs;

import java.util.Date;

import com.mossle.user.persistence.domain.AccountDevice;

public class AccountDeviceController_saveSetValue implements FunInterFace_Save{
	private AccountDevice dest;
	private String tenantId;
	public AccountDeviceController_saveSetValue(String tenantId){
		this.tenantId=tenantId;
	}
	public void setValue(Object dest){
		this.dest=(AccountDevice)dest;
	}
	@Override
	public void execute() {
		if(tenantId!=null){
	        dest.setCreateTime(new Date());
	        dest.setTenantId(tenantId);
		}
	}
}
