/**
 * Axelor Business Solutions
 *
 * Copyright (C) 2012-2014 Axelor (<http://axelor.com>).
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.axelor.apps.account.service.user;

import com.axelor.apps.account.db.CashRegister;
import com.axelor.apps.base.db.Company;
import com.axelor.apps.base.db.Partner;
import com.axelor.apps.base.db.Team;
import com.axelor.apps.base.db.UserInfo;
import com.axelor.apps.base.service.user.UserInfoServiceImpl;
import com.axelor.auth.AuthUtils;
import com.axelor.auth.db.User;

/**
 * UserInfoService est une classe implémentant l'ensemble des services pour
 * les informations utilisateur.
 * 
 */
public class UserInfoServiceAccountImpl extends UserInfoServiceImpl  {

	/**
	 * Méthode qui retourne le userInfo de l'utilisateur connecté
	 * 
	 * @return UserInfo
	 * 		Le userInfo de l'utilisateur
	 */
	public UserInfo getUserInfo() {
		User user = null;
		try{
			user = AuthUtils.getUser();
		}
		catch(Exception ex){}
		if(user == null)
			user = User.findByCode("admin");
		if (user != null){
			UserInfo userInfo = UserInfo.findByUser(user);
			if (userInfo != null) { return userInfo; }
		}
	
		return null;
	}
	
	public Long getUserInfoId() {
		UserInfo userInfo = this.getUserInfo();
	
		if(userInfo != null)  {
			return userInfo.getId();
		}
		
		return null;
	}
	
	
	 /**
     * Méthode qui retourne l'agence de l'utilisateur connecté
     * 
     * @return CashRegister
     *      La caisse
     */
    public CashRegister getUserCashRegister() {
        
        UserInfo userInfo = getUserInfo();
        if (userInfo != null && userInfo.getActiveCashRegister() != null){
            return userInfo.getActiveCashRegister();
        }
    
        return null;
    }
    
	
	/**
	 * Méthode qui retourne la société active de l'utilisateur connecté
	 * 
	 * @return Company
	 * 		La société
	 */
	public Company getUserActiveCompany() {
		
		UserInfo userInfo = getUserInfo();
		if (userInfo != null && userInfo.getActiveCompany() != null){
			return userInfo.getActiveCompany();
		}
	
		return null;
	}
    

	/**
	 * Méthode qui retourne la société active de l'utilisateur connecté
	 * 
	 * @return Company
	 * 		La société
	 */
	public Long getUserActiveCompanyId() {
		
		UserInfo userInfo = getUserInfo();
		if (userInfo != null && userInfo.getActiveCompany() != null){
			return userInfo.getActiveCompany().getId();
		}
	
		return null;
	}
	
	
	/**
	 * Méthode qui retourne l'équipe active de l'utilisateur connecté
	 * 
	 * @return Team
	 * 		L'équipe
	 */
	public Team getUserActiveTeam() {
		
		UserInfo userInfo = getUserInfo();
		if (userInfo != null && userInfo.getActiveTeam() != null){
			return userInfo.getActiveTeam();
		}
	
		return null;
	}
	
	/**
	 * Méthode qui retourne l'équipe active de l'utilisateur connecté
	 * 
	 * @return Team
	 * 		L'équipe
	 */
	public Long getUserActiveTeamId() {
		
		UserInfo userInfo = getUserInfo();
		if (userInfo != null && userInfo.getActiveTeam() != null){
			return userInfo.getActiveTeam().getId();
		}
	
		return null;
	}
	
	/**
	 * Méthode qui retourne le tiers de l'utilisateur connecté
	 * 
	 * @return Partner
	 * 		Le tiers
	 */
	public Partner getUserPartner() {
		
		UserInfo userInfo = getUserInfo();
		if (userInfo != null && userInfo.getPartner() != null){
			return userInfo.getPartner();
		}
	
		return null;
	}
}
