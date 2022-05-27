// linked list

class Emp{
  Emp ref;
}

//tree of same class objects
class Emp{
  List<Emp> emps;
}

// Linked List of family members <-- Decorator , Chain of responsibility 
interface IEmp{}
class Emp implements IEmp {
  IEmp ref;
}

//tree of family members <-- composite pattern
interface IEmp{}
class Emp{
  List<IEmp> emps;
}
