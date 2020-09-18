Factory
# creator Method
# Class Factory
# factory Method
# Abstract Factory

# creator Method

class Account
{
public:
     static Account Create(){
        return new Account;
     }
}

# Class Factory

class ClassFactory
{
public:
     static Account CreateSA(){ ... }
     static Account CreateCA(){ ... }
}

# factory Method

class Account
{
public:
      abstract Account Create();
}

# abstract factory 

interface Factory
{
public:
     Account CreateSA(){ ... }
     Account CreateCA(){ ... }
}
