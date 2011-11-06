Dyna
Michael Vorburger, November 2011

Data Structures don't always have to be statically typed.
There is a need for something... between a Map<String, Object> and a static Java Bean POJO DTO type class. 

It is useful to be able to map e.g. an incoming UI Model (say from a Web HTTP POST) to
a dynamic bean, and then send that DTO along marshalled as e.g. XML or JSON to some service (or say store it as such),
without necessarily having to have a statically typed bean. 

It is even more useful if you are into model driven development (MDD), and do type checking at design time,
and really don't see any need to bother the business end-users of your workbench with generating loads of trivial Java Beans.

Apache Commons BeanUtils DynaBean is the most well-known implementation of this pattern.  But BeanUtils DynaBean ...
  * does not appear to be actively maintained
  * does not support nested dynamic structures!!!
  * does not use modern Java Generics (i.e. <T> T get(String path, Class<T> type)
  * does not integrate with Spring
  * DynaBean API does not allow even simply navigation expressions, need to go through PropertyUtils  

The Eclipse Modeling Framework (EMF) has a very similar approach.  But EMF ...
  * mixes Resource etc. stuff with basic Dyna
  * while it can run "standalone", has Eclipse-ish internal dependencies
  * is perceived to be complex by some beginners (ecore)
  * does not integrate with Spring
 
Common/J Service Data Objects (SDO) defined a clean Dyna API.  But SDO ...
  * does not appear to be actively maintained
  * does not use modern Java Generics
  * does not integrate with Spring

Spring's Dynamic language support is related, but not quite applicable (still statically typed).
