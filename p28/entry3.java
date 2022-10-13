interface View{
  getText1();
  getText2();
  setText3(val);
}
class Dialog implements View{
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
  View view;
  Controller(View view){
      this.view = view;
  }
  onAdd(){
     int i = int.parse(view.getText1());
     int j = int.parse(view.getText2());
     Math obj = new Math();
     int k = obj.add(10,20);
     view.setText3(k.toString());
  }
}
