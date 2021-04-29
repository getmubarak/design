Creator method -> static/global fun
Factory method -> instance fun (overridable)
Class factory -> class full of creation logic (no domain logic)
Abstract factory -> family of class full of creation logic (no domain logic)

class Dept
{
   ... domain logic
      
   static Emp GetEmp(code){ ... } <-- Creator method
}
class Dept
{
   ... domain logic
      
   Emp GetEmp(code){ ... } <-- factory method
}
class Factory <-- class factory
{
   Connection getCon() { ... }<-- factory method
   Command getCmd() { ... }<-- factory method
   Transaction getTransaction() { ... }<-- factory method
}
interface Factory <-- abstract factory
{
   Connection getCon();<-- factory method
   Command getCmd();<-- factory method
   Transaction getTransaction();<-- factory method
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
