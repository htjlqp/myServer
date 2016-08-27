package com.funs;

import com.mossle.auth.persistence.domain.Role;
import com.mossle.auth.persistence.manager.RoleDefManager;

public class RoleController_Save implements FunInterFace{

	private Role dest;
	private RoleDefManager roleDefManager;
	private Long roleDefId;
	public RoleController_Save(Object roleDefManager,Object roleDefId){
		this.roleDefManager=(RoleDefManager)roleDefManager;
		this.roleDefId=(Long)roleDefId;
	}
	@Override
	public void execute() {
        dest.setName(roleDefManager.get(roleDefId).getName());
        dest.setRoleDef(roleDefManager.get(roleDefId));
	}
	public void setValue(Object dest) {
		this.dest=(Role)dest;
	}
}
