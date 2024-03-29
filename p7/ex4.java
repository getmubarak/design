interface AppHandler{
  string getTitle();
  string getImage();
  string getIcon();
}
class CacheAppHandler implements AppHandler{
  AppHandler ref;
  public string getTitle(){
    if(!cache.getTitle())
      return ref.getTitle();
    else
      return cache.title;
  }
  ...
}
class DebugAppHandler implements AppHandler{
  AppHandler ref;
  public string getTitle(){
    if(enabled.TITLE)
      return ref.getTitle();
  }
  public string getImage(){
     if(enabled.IMAGE)
       return ref.getImage();
  }
  public string getIcon(){
    if(enabled.ICON)
       return ref.getIcon();
  }
  ...
}
class JavaAppHandler implements AppHandler{
  public string getTitle(){
    ...
  }
  public string getImage(){
    ...
  }
  public string getIcon(){
    ...
  }
  ...
}
class WinAppHandler implements AppHandler{
  public string getTitle(){
    ...
  }
  public string getImage(){
    ...
  }
  public string getIcon(){
    ...
  }
  ...
}
class MainframeAppHandler implements AppHandler{
  public string getTitle(){
    ...
  }
  public string getImage(){
    ...
  }
  public string getIcon(){
    ...
  }
  ...
}

class Factory{
  public AppHandler getHandler(){
       if(config== debug)
             return new CacheAppHandler(new DebugHandler(new JavaAppHandler()));
       else
            return new CacheAppHandler(new JavaAppHandler());
        
  }
}

Factory factory = new Factory();
AppHandler handler = factoryu.getHandler();
handler.getTitle();
