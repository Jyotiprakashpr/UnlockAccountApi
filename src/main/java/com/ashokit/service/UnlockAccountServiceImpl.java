package com.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.bindings.UnlockAccRequest;
import com.ashokit.constants.AppConstants;
import com.ashokit.entities.UserEntity;
import com.ashokit.props.AppProperties;
import com.ashokit.repositories.UserRepository;

@Service
public class UnlockAccountServiceImpl implements UnlockAccountService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AppProperties appProps;

	@Override
	public String unlockAccount(UnlockAccRequest request) {
		UserEntity user = userRepo.findByUserEmailandUserPwd(request.getEmail(),request.getTempPwd());
		if (user != null ) {
			user.setUserPwd(request.getNewPwd());
			user.setUserAccStatus(AppConstants.UNLOCKED);
			userRepo.save(user);
			 return appProps.getMessages().get(AppConstants.ACC_UNLOCK_SUCCESS);
			//return "User Account Unlocked Successfully";
		}
		return appProps.getMessages().get(AppConstants.INVALID_TEMP_PWD);
		//return "Invalid Temp Pwd";
	}

}
