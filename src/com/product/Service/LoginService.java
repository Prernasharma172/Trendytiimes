package com.product.Service;

public interface LoginService {

	public boolean customerLogin(String username ,String password); 

		public boolean adminLogin(String username ,String password);

		public boolean changeCustpassword(String username ,String oldpassword,String newpassword);
		public boolean changeAdminpassword(String username ,String oldpassword,String newpassword);
}
