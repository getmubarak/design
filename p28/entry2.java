class Dialog{
  TextBox t1;
  TextBox t2;
  TextBox t3;
  Button b1;
  Controller controller= new Controller(this);
  
  getText1(){
    return t1.getText();
  }
  getText2(){
    return t2.getText();
  }
  setText3(val){
    t3.setText(val);
  }
  b1_Onclick(){
   controller.onAdd(
  }
}

class Controller{
  Dialog dialog;
  Controller(Dialog dialog){
      this.dialog = dialog;
  }
  onAdd(){
     int i = int.parse(dialog.getText1());
     int j = int.parse(dialog.getText2());
     Math obj = new Math();
     int k = obj.add(10,20);
     dialog.setText3(k.toString());
  }
}
