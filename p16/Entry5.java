<Definition name="Bug" initial="Opened">
  <State name="Opened">
    <Transition name="assign" state="Assigned">
    <Transition name="reject" state="Closed">
  </State>
   <State name="Closed">
  </State>
   <State name="Assigned">
    <Transition name="resolved" state="Closed">
  </State>
<Definition>


Definition LoadStateMachine(){
  Definition definition = (Definition) XmlDeserializer("config.xml"); 
  return definition;
}
