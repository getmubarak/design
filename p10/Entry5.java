class Builder{
  Account acc;
  
  Builder(){
    acc = new AccountImp();
  }
  AddOtp(){
    acc = new AccountOtpAuth(acc);
  }
  AddEmail(){
    acc = new AccountEmailNotify(acc);
  }
  ...
}
void Main(){
  Builder builder = new Builder();
  builder.AddOtp();
  builder.AddEmail();
  ...
  Account acc = builder.getAccount();
}
//-------------------------------------
void Main(){
	Account acc = new AccountOtpAuth(new AccountEmailNotify(new AccountSmsNotify(new AccountImp())));
	acc.withdraw(100); <-- 1
}
