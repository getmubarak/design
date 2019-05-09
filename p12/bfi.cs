1. interface
2. Data stucture ( stack, queue, list, dictionary)
3. Linq
4. 


interface Action
{
  void Do();
}

class JobApi
{
  Dictionary<int,Action> dict = new Dictionary<int,Action>();
 
  public JobApi()
  {
    dict[1] = new C1();
    dict[2] = new C2();
    dict[3] = new C3();
    dict[4] = new C4();
    dict[5] = new C5();
    dict[6] = new C6();
    dict[7] = new C7();
    dict[8] = new C8();
    dict[9] = new C9();
    dict[10] = new C10();
    dict[11] = new C11();
    //...
  }
  public void process(int id)
  {
    Action action=dict[id];
    action.Do();
  }
}


class C1 : Action
{
  public void Do()
  {
    //,,,
  }
}

class C2 : Action
{
  public void Do()
  {
    //,,,
  }
}


class C3 : Action
{
  public void Do()
  {
    //,,,
  }
}
class JobApi
{
  [HttpGet]
  void process(int id)
  {
    switch(id)
    {
      case 1:
        //...
        break;
      case 2:
        //...
        break;
      case 3:
        //...
        break;
      case 4:
        //...
        break;
      case 5:
        //...
        break;
      case 6:
        //...
        break;
      case 7:
        //...
        break;
      case 8:
        //...
        break;
      case 9:
        //...
        break;
      case 10:
        //...
        break;
      case 11:
        //...
        break;
      case 12:
        //...
        break;
      case 13:
        //...
        break;
      case 14:
        //...
        break;
      case 15:
        //...
        break;
      case 16:
        //...
        break;
      case 17:
        //...
        break;
      case 18:
        //...
        break;
    }
  }
}
