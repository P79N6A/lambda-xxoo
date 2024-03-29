package com.yatop.lambda.portal.system.domain;


import lombok.Data;
import javax.persistence.*;


import java.io.Serializable;

@Table(name = "t_role_menu")
@Data
public class RoleMenu implements Serializable {
	
	private static final long serialVersionUID = -7573904024872252113L;

	@Column(name = "ROLE_ID")
    private Long roleId;

    @Column(name = "MENU_ID")
    private Long menuId;
}