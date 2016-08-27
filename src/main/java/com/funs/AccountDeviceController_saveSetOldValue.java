package com.funs;

import com.mossle.user.persistence.domain.AccountDevice;

public class AccountDeviceController_saveSetOldValue implements FunInterFace_Save {
	private AccountDevice dest;
	@Override
	public void execute() {
		dest.setStatus("new");
	}
	public void setValue(Object dest){
		this.dest=(AccountDevice)dest;
	}
}
