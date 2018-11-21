<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSON</title>
</head>
<body>
   <script type="text/javascript">
      
      /*
         JAVA语言创建的类
         public class person() {
            private String name;
            private int age;
            
            public void show() {
            
            }
         }
      */
      
      /* 
	      function Person() {
	         var name = "tom";//声明一个局部变量
	         this.age = 10 ;//声明一个成员变量
	         this.show = function() {
	            alert(name);
	         }
	      }
	      
	      var p = new Person();
	      document.write(p.name);
	      document.write(p.age);
	      p.show(); 
      */
      
     /*  
            一个JSON对象
	     var pp = {name:"tom",age:18,
	                show:function() {
	                     alert("hello");
	                     }
	               };//一个JSON对象
	      
	      document.write(pp.name);
	      document.write(pp.age);
	      document.write(pp.show); 
	  */
      
      //数组套JSON
      var ppp = [{name:"tom",age:18},{name:"jerry",age:18}];
      document.write(ppp[1].name);
   </script>
</body>
</html>



