
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
   <head>
      <title>useBean Example</title>
   </head>
   <body>
         <jsp:useBean id = "date" class = "java.util.Date" />
         <p>The date/time is ${date} </p>
         <p>${ex}</p>
         <h1>Error Page</h1>
         <p>Application has encountered an error. Please contact support on ...</p>
         Exception:  ${ex.message}
         <c:forEach items="${ex.stackTrace}" var="ste">
         ${ste}
         </c:forEach>
   </body>
</html>