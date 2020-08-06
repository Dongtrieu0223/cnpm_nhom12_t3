<%@ page import="lol.work.stop.util" %>
<%@ page import="lol.work.stop.Model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>HomePage</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">

    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">


    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
    <script language="JavaScript" type="text/javascript">
        function requestconfirmlogout() {

            if (confirm('Are you sure you want to log out?')) {
                // Do it!
                window.location.href="<%=util.fullPath("Logout")%>"

            } else {
                // Do nothing!

            }
        }
    </script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active"><a href="" class="nav-link">Trang Chủ</a></li>
                <li class="nav-item"><a href="" class="nav-link">Liên Hệ</a></li>
                <li class="nav-item"><a href="" class="nav-link">Tìm Kiếm</a></li>
                <li class="nav-item"><a href="" class="nav-link">Hướng dẫn</a></li>
                <li class="nav-item"><a href="" class="nav-link">Hóa Đơn</a></li>
                <%  User u2= (User) session.getAttribute("User");
                    if (u2 == null) {
                %>
                <li class="nav-item cta"><a href="Login.jsp" class="nav-link">Login</a></li>
                <%
                    }
                    else {
                %>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Hello <%= u2.getUname() %>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" onclick="requestconfirmlogout()" id="log" href="#">Log out</a>


                    </div>
                </li>
<%--                <p style="color: white;margin-top: 22px"></p>--%>
                <% }
                %>

            </ul>
        </div>
    </div>
</nav>
<!-- END nav -->

<div class="hero-wrap js-fullheight" style="background-image: url('image/Image_2.png');" data-stellar-background-ratio="0.5">
    <div class="overlay"></div>
    <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-center" data-scrollax-parent="true">
            <div class="col-md-9 text text-center ftco-animate" data-scrollax=" properties: { translateY: '70%' }">

                <p class="caps" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">Đi đến bất cứ đâu trong nước.Tiện lợi và dễ dàng </p>
                <h1 data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">Tổng Công Ty Đường Sắt Việt Nam</h1>
            </div>
        </div>
    </div>
</div>
<section class="ftco-counter img" id="section-counter">
    <div class="container">
        <div class="row d-flex">
            <div class="col-md-6 d-flex">
                <div class="img d-flex align-self-stretch" style="background-image:url(image/img2.jpg);margin-top: 30px"></div>
            </div>
            <div class="col-md-6 pl-md-5 py-5">
                <div class="row justify-content-start pb-3">
                    <div class="col-md-12 heading-section ftco-animate">
                        <h2 class="mb-4">Khiến việc di chuyển an toàn và tiện lợi</h2>
                        <p>Đặt vé,xem chuyến đi,quản lý hành trình có thể thực hiện ở bất cứ đâu tiện lợi,nhanh chóng.Đồng thời thanh toán chính xác,uy tín,thông tin cập nhật liên tục không sợ nhầm lẫn.Hoạt động 24/24.Đảm bảo quyền lợi của khách hàng.</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 justify-content-center counter-wrap ftco-animate">
                        <div class="block-18 text-center mb-4">
                            <div class="text">
                                <strong class="number" data-number="300">0</strong>
                                <span>Chuyến đi</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 justify-content-center counter-wrap ftco-animate">
                        <div class="block-18 text-center mb-4">
                            <div class="text">
                                <strong class="number" data-number="24000">0</strong>
                                <span>Khách hài lòng</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 justify-content-center counter-wrap ftco-animate">
                        <div class="block-18 text-center mb-4">
                            <div class="text">
                                <strong class="number" data-number="200">0</strong>
                                <span>Địa điểm</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center pb-4">
            <div class="col-md-12 heading-section text-center ftco-animate">
                <h2 class="mb-4">Tuyến đường nổi tiếng</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 ftco-animate">
                <div class="project-destination">
                    <a href="#" class="img" style="background-image: url(image/BinhThuan.jpg);">
                        <div class="text">
                            <h3>Bình Thuận</h3>
                            <span>8 Tours</span>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-md-3 ftco-animate">
                <div class="project-destination">
                    <a href="#" class="img" style="background-image: url(image/HaNoi.jpg);">
                        <div class="text">
                            <h3>Đà Lạt</h3>
                            <span>2 Tours</span>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-md-3 ftco-animate">
                <div class="project-destination">
                    <a href="#" class="img" style="background-image: url(image/img3.jpg);">
                        <div class="text">
                            <h3>SA PA</h3>
                            <span>5 Tours</span>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-md-3 ftco-animate">
                <div class="project-destination">
                    <a href="#" class="img" style="background-image: url(image/metro_re.jpg);">
                        <div class="text">
                            <h3>Đèo Hải Vân</h3>
                            <span>5 Tours</span>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>



<footer class="ftco-footer bg-bottom" style="background-image: url(image/footer-bg.jpg);">
    <div class="container">
        <div class="row mb-5">
            <div class="col-md">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2">Về chúng tôi</h2>
                    <p>Giấy chứng nhận ĐKKD số 113642 theo QĐ thành lập số 973/QĐ-TTg ngày 25/06/2010 của Thủ tướng Chính phủ.<br/>Mã số doanh nghiệp: 0100105052, đăng ký lần đầu ngày 26/07/2010, đăng ký thay đổi lần 4 ngày 27/06/2014 tại Sở KHĐT Thành phố Hà Nội</p>
                    <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                        <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                        <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                        <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md">
                <div class="ftco-footer-widget mb-4 ml-md-5">
                    <h2 class="ftco-heading-2">Infromation</h2>
                    <ul class="list-unstyled">
                        <li><a href="#" class="py-2 d-block">Online Enquiry</a></li>
                        <li><a href="#" class="py-2 d-block">General Enquiries</a></li>
                        <li><a href="#" class="py-2 d-block">Booking Conditions</a></li>
                        <li><a href="#" class="py-2 d-block">Privacy and Policy</a></li>
                        <li><a href="#" class="py-2 d-block">Refund Policy</a></li>
                        <li><a href="#" class="py-2 d-block">Call Us</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2">Experience</h2>
                    <ul class="list-unstyled">
                        <li><a href="#" class="py-2 d-block">Adventure</a></li>
                        <li><a href="#" class="py-2 d-block">Hotel and Restaurant</a></li>
                        <li><a href="#" class="py-2 d-block">Beach</a></li>
                        <li><a href="#" class="py-2 d-block">Nature</a></li>
                        <li><a href="#" class="py-2 d-block">Camping</a></li>
                        <li><a href="#" class="py-2 d-block">Party</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2">Have a Questions?</h2>
                    <div class="block-23 mb-3">
                        <ul>
                            <li><span class="icon icon-map-marker"></span><span class="text">Số 118 Lê Duẩn, Hoàn Kiếm, Hà Nội.</span></li>
                            <li><a href="#"><span class="icon icon-phone"></span><span class="text">19006469</span></a></li>
                            <li><a href="#"><span class="icon icon-envelope"></span><span class="text">dsvn@vr.com.vn</span></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </div>
</footer>



<!-- loader -->
<div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


<script src="js/jquery.min.js"></script>
<script src="js/jquery-migrate-3.0.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/jquery.waypoints.min.js"></script>
<script src="js/jquery.stellar.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/aos.js"></script>
<script src="js/jquery.animateNumber.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="js/scrollax.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
<script src="js/google-map.js"></script>
<script src="js/main.js"></script>

</body>
</html>