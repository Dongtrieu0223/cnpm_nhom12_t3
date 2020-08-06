

<%@ page import="lol.work.stop.util" %>
<%@ page import="lol.work.stop.Model.Checknumlog" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link href="bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="bootstrap.min.js"></script>
    <script src="jquery.min.js"></script>
    <title>Login Page</title>
    <!--Made with love by Mutiullah Samim -->

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!--Bootsrap 4 CDN-->
    <link rel="stylesheet" href="bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!--Fontawesome CDN-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <!--Custom styles-->
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%
    String uname = (String) request.getAttribute("uname");
    String errorUser = (String) request.getAttribute("errorUser");
    String errorPass = (String) request.getAttribute("errorPass");
    String errorCapt = (String) request.getAttribute("errorCapt");


    String unamenew = (String) request.getAttribute("unamenew")==null?"":(String) request.getAttribute("unamenew");
    String upassnew = (String) request.getAttribute("upassnew")==null?"":(String) request.getAttribute("upassnew");
    String upassnewcon = (String) request.getAttribute("upassnewcon")==null?"":(String) request.getAttribute("upassnewcon");
    String umail = (String) request.getAttribute("umail")==null?"":(String) request.getAttribute("umail");


    String errtaikhoan = (String) request.getAttribute("errtaikhoan")==null?"":(String) request.getAttribute("errtaikhoan");
    String errmatkhau = (String) request.getAttribute("errmatkhau")==null?"":(String) request.getAttribute("errmatkhau");
    String errmatkhaucon = (String) request.getAttribute("errmatkhaucon")==null?"":(String) request.getAttribute("errmatkhaucon");

    String errmail = (String) request.getAttribute("errmail")==null?"":(String) request.getAttribute("errmail");


    Checknumlog check = (Checknumlog) session.getAttribute("Check");



%>
<div  class="row">

    <div  class="col-md-6 mx-auto p-0" >

        <div  class="card" >
            <img id="bonus" src="image/screenshot_1593856325.png" alt="">
            <div class="login-box">
                <div class="login-snip"> <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Login</label> <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
                    <div class="login-space">
                        <form class="login" id="myform"   action=<%=util.fullPath("Login")%> >
                            <div class="group"> <label for="user" class="label">Username</label> <input name="uname" id="user" type="text" class="input" placeholder="Enter your username" value= <%=uname == null ? "" :uname%>> </div>
                            <div class="alert-danger"><%= errorUser == null ? "" : errorUser %></div>
                            <div class="group"> <label for="pass" class="label">Password</label> <input name="pass" id="pass" type="password" class="input" data-type="password" placeholder="Enter your password"> </div>
                                <div class="alert-danger"><%= errorPass == null ? "" : errorPass%></div>
                            <div class="group"> <input id="check" name="checkbox" type="checkbox" class="check" checked> <label for="check"><span class="icon"></span> Keep me Signed in</label> </div>
<%  if(check!=null)  {

    if(check.getNumlog()>=3)     {

%>
                            <div class="form-group" >
                                <input  type="text" name="num" id="num1" class="d-inline" readonly >
                                <p class="d-inline opstyle" > + </p>
                                <input type="text" name="num2" id="num2" class="d-inline" readonly >
                                <p class="d-inline opstyle" > = </p>

                                <input type="text" id="capt" class="rsstyle d-inline" name="captcha" />

                            </div>
                            <div class="alert-danger"><%= errorCapt== null ? "" : errorCapt%></div>
                            <% }%>
                            <% }%>
                            <div class="group"> <input type="submit" class="button" value="Sign In" > </div>

                            <div class="hr"></div>
                            <div class="foot"> <a href="forgotpassword.jsp">Forgot Password?</a> </div>



                            <div id="choices">
                            <a id="icon1" href="https://www.facebook.com/dialog/oauth?client_id=3183327778383252&redirect_uri=https://localhost:8443/login-fb"><img src="image/fb.png" alt="" class="img1"> </a>
                            <a id="icon2" href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=https://localhost:8080/login-google&response_type=code
    &client_id=450020186857-712ujs7enb5qfh1e7i2le6cga2kt90i4.apps.googleusercontent.com&approval_prompt=force"><img src="image/unnamed.jpg" alt="" class="img1"></a>
                            </div>

                        </form>
                        <form class="sign-up-form" action=<%=util.fullPath("Register") %>>
                            <div class="group"> <label for="user" class="label">Username</label> <input id="user" onblur="checkTaikhoan()" name="unamenew" type="text" class="input" placeholder="Create your Username" value="<%=unamenew%>" required>
                                <div id="error_unamenew"></div>
                                <div class=" alert-danger">
                                    <%=errtaikhoan%>
                                </div>
                            </div>
                            <div class="group"> <label for="pass" class="label">Password</label> <input id="pass" onblur="checkPass()" name="upassnew" type="password" class="input" data-type="password" placeholder="Create your password" required>
                                <div id="error_upassnew"></div>
                                <div class=" alert-danger">
                                    <%=errmatkhau%>
                                </div>
                            </div>
                            <div class="group"> <label for="pass" class="label">Repeat Password</label> <input id="pass" onblur="checkPassCon()" name="upassnewcon" type="password" class="input" data-type="password" placeholder="Repeat your password" required>
                                <div id="error_upassnewcon"></div>
                                <div class=" alert-danger">
                                    <%=errmatkhaucon%>
                                </div>
                            </div>
                            <div class="group"> <label for="pass" class="label">Email Address</label> <input id="pass" onblur="checkEmail()" name="umail" type="text" class="input" placeholder="Enter your email address" value="<%=umail%>" required>
                                <div id="error_umail"></div>
                                <div class=" alert-danger">
                                    <%=errmail%>
                                </div>
                            </div>
                            <div class="group"> <input type="submit" class="button" value="Sign Up"> </div>
                            <div class="hr"></div>
                            <div class="foot"> <label for="tab-1">Already Member?</label> </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
<script src="<%=util.fullPath("validinfo.js")%>"></script>
    <script>
document.getElementById("num1").value= Math.floor(Math.random() * 100).toString();
document.getElementById("num2").value= Math.floor(Math.random() * 100).toString();

</script>
</html>