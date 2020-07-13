class Factory
{
   Connection getCon() { ... }
   Command getCmd() { ... }
   Transaction getTransaction() { ... }
}


class Builder{
  AddAuthentication() { ... }
  AddAuthorization() { ... }
  AddEH() { ... }
  AddChache() { ... }
  AddTransaction(){ ... }
  getComponent() { ... }
}
//IX obj = new CB(new CB(new CB(new CA())));
Builder b = new Builder();
b.AddAuthentication();
b.AddCache();
IX obj = b.getComponent();
