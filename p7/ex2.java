interface AppHandler{
  string getTitle();
  string getImage();
  string getIcon();
}
class JavaAppHandler implements AppHandler{
  public string getTitle(){
    if(enabled.TITLE)
      ...
  }
  public string getImage(){
     if(enabled.IMAGE)
       ...
  }
  public string getIcon(){
    if(enabled.ICON)
       ...
  }
  ...
}
class WinAppHandler implements AppHandler{
  public string getTitle(){
    if(enabled.TITLE)
      ...
  }
  public string getImage(){
     if(enabled.IMAGE)
       ...
  }
  public string getIcon(){
    if(enabled.ICON)
       ...
  }
  ...
}
class MainframeAppHandler implements AppHandler{
  public string getTitle(){
    if(enabled.TITLE)
      ...
  }
  public string getImage(){
     if(enabled.IMAGE)
       ...
  }
  public string getIcon(){
    if(enabled.ICON)
       ...
  }
  ...
}
