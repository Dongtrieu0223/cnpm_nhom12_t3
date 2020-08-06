
<%@ page import="lol.work.stop.util" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <style>
        body {
            margin: 0;
            color: #6a6f8c;
            background:url(image/544750.jpg);
            font: 600 16px/18px 'Open Sans', sans-serif


        }
        .form-gap {
            padding-top: 150px;
        }
    </style>
</head>
<body>

<link rel="stylesheet" type="text/css" href="threeform.css">
<%
    String email = (String) request.getAttribute("email") == null ? "" : (String) request.getAttribute("email");
    String errmail = (String) request.getAttribute("errmail") == null ? "" : (String) request.getAttribute("errmail");
%>
<section id="threeform" class="p-5" style="min-height: 650px">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <div class="form-gap"></div>
    <div class="container" >
        <div class="row">
            <div class="col-md-4 col-md-offset-4" >
                <div class="panel panel-default" style="width: 500px;height: 500px">
                    <div class="panel-body">
                        <div class="text-center">
                            <h3><i class="fa fa-lock fa-4x"></i></h3>
                            <h2 class="text-center">Forgot Password?</h2>
                            <p>You can reset your password here.</p>
                            <div class="panel-body">

                                <form action="<%=util.fullPath("doForgotPass")%>" method="post" id="register-form" role="form" autocomplete="off" class="form" method="post">

                                    <div class="form-group">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                                            <input style="height: 50px" id="email" name="email" placeholder="email address" class="form-control"  type="email" value="<%=email%>">
                                        </div>
                                    </div>
                                    <div class=" alert-danger">
                                                                                  <%=errmail%>
                                      </div>
                                    <div class="form-group">
                                        <input name="recover-submit" class="btn btn-lg btn-primary btn-block" value="Reset Password" type="submit">
                                    </div>

                                    <input type="hidden" class="hide" name="token" id="token" value="">
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


<%--    <div class="container">--%>
<%--        <div class="row justify-content-center">--%>
<%--            <div class="col-md-6">--%>
<%--                <div class="card">--%>
<%--                    <header class="card-header">--%>

<%--                        <h4 class="card-title mt-2">Quên mật khẩu</h4>--%>
<%--                    </header>--%>
<%--                    <article class="card-body">--%>
<%--                        <div class="text-center">--%>
<%--                            <h3><i class="fa fa-lock fa-4x"></i></h3>--%>
<%--                            <h2 class="text-center">Forgot Password?</h2>--%>
<%--                            <p>You can reset your password here.</p>--%>
<%--                            <div class="panel-body">--%>
<%--                                <form action="<%=util.fullPath("doForgotPass")%>" method="post">--%>
<%--                                    <div class="form-group">--%>
<%--                                        <div class="input-group">--%>
<%--                                            <span class="input-group-addon"><i--%>
<%--                                                    class="glyphicon glyphicon-envelope color-blue"></i></span>--%>
<%--                                            <input id="email" name="email" placeholder="email address"--%>
<%--                                                   value="<%=email%>" class="form-control" type="email">--%>
<%--                                        </div>--%>
<%--                                        <div class=" alert-danger">--%>
<%--                                            <%=errmail%>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                    <div class="form-group">--%>
<%--                                        <input  class="btn btn-lg btn-primary btn-block"--%>
<%--                                                type="submit">--%>
<%--                                    </div>--%>
<%--                                </form>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </article>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
</section>


</body>
</html>
