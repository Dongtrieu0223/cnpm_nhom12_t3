<%@ page import="lol.work.stop.util" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="bootstrap.min.js"></script>
    <script src="jquery.min.js"></script>
    <title>Change PassWord</title>
    <!--Made with love by Mutiullah Samim -->

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!--Bootsrap 4 CDN-->
    <link rel="stylesheet" href="bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!--Fontawesome CDN-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

</head>
<body>

<link rel="stylesheet" href="threeform.css">
<%
    String errmatkhau = (String) request.getAttribute("errmatkhau")==null?"":(String) request.getAttribute("errmatkhau");
    String errmatkhaucon = (String) request.getAttribute("errmatkhaucon")==null?"":(String) request.getAttribute("errmatkhaucon");
    String errmaxacthuc = (String) request.getAttribute("errmaxacthuc")==null?"":(String) request.getAttribute("errmaxacthuc");
%>
<section id="threeform" class="register p-5" style="min-height: 650px">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <header class="card-header">
                        <h4 class="card-title mt-2">Đổi mật khẩu</h4>
                    </header>
                    <article class="card-body">
                        <form action="<%=util.fullPath("ChangePassword2")%>" method="post">
                            <div class="form-group">
                                <label>Mã xác thực của bạn</label>
                                <input id="maxacthuc" onblur="" name="maxacthuc" value="" class="form-control"
                                       type="text" required>
                                <div id="error_maxacthuc"></div>
                                <div class=" alert-danger">
                                  <%=errmaxacthuc%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Mật khẩu của bạn</label>
                                <input id="upassnew" onblur="checkPass()" name="upassnew"  value="" class="form-control"
                                       type="password" required>
                                <div id="error_upassnew"></div>
                                <div class=" alert-danger">
                                    <%=errmatkhau%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Nhập lại mật khẩu</label>
                                <input id="upassnewcon" onblur="checkPassCon()" value="" name="upassnewcon"
                                       class="form-control" type="password" required>
                                <div id="error_upassnewcon"></div>
                                <div class=" alert-danger">
                                    <%=errmatkhaucon%>
                                </div>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-block"> Đổi</button>
                            </div>
                        </form>
                    </article>
                </div>
            </div>
        </div>
    </div>
    <br><br>
</section>


<script src="validinfo.js">

</script>

</body>
</html>
