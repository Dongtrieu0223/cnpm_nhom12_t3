package lol.work.stop;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.spi.FileSystemProvider;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lol.work.stop.DB.ConnectionDB;
import lol.work.stop.Model.Checknumlog;
import lol.work.stop.Model.User;

@WebServlet("/Login")
public class Login extends HttpServlet{

        private static final long serialVersionUID = 1L;

        /**
         * @see HttpServlet#HttpServlet()
         */
        public Login() {
            super();
            // TODO Auto-generated constructor stub
        }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
         *      response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                todo(request, response);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
         *      response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                todo(request, response);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        private void todo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException {
            try {
                request.setCharacterEncoding("utf8");
                response.setCharacterEncoding("utf8");
                String uname = request.getParameter("uname") == null ? "" : request.getParameter("uname");
                String pass = request.getParameter("pass") == null ? "" : request.getParameter("pass");
                String number1 = request.getParameter("num") == null ? "" : request.getParameter("num");
                String number2 = request.getParameter("num2") == null ? "" : request.getParameter("num2");
                String result = request.getParameter("captcha") == null ? "" : request.getParameter("captcha");
                String proPass = protecctPass(pass);
                String checkkeep=request.getParameter("checkbox");
                String errorUser = "";
                String errorPass = "";
                String checklog="";

                boolean rs2=true;


                if (checksignin(request)) {
                    response.sendRedirect("Login.jsp");
                } else {
                    ConnectionDB con = new ConnectionDB();
                    String sql = "Select * from user where username= ? and password= ? and active=1";
                    PreparedStatement pscheckUser = con.getPreparedStatement(sql);

                    pscheckUser.setString(1, uname);
                    pscheckUser.setString(2, proPass);
                    ResultSet rs = pscheckUser.executeQuery();
                    boolean checkUser = rs.next();
                    HttpSession s2 = request.getSession(false);
                    Checknumlog cn = (Checknumlog) s2.getAttribute("Check");
                    if (cn == null) {

                        HttpSession s3 = request.getSession(true);
                        Checknumlog cn2 = new Checknumlog();
                        cn2.setNumlog(1);
                        cn2.setIp(getClientIpAddr(request));
                        s3.setAttribute("Check", cn2);
                    }
                    else{
                        if(cn.getNumlog()>=4){
                        if((!result.contains(" "))&&(!result.equals(""))){
                            if((Integer.valueOf(result) != Integer.valueOf(number1) + Integer.valueOf(number2))){
                                rs2=false;
                            }
                            else rs2=true;
                        }
                        else{
                            rs2=false;
                            checklog="Sai captcha xin moi thu lai";
                            request.setAttribute("errorCapt", checklog);
                        }
                    }}
                    if ((checkUser == false)||(rs2==false)) {


                        errorUser = "Tài khoản hoặc mật khẩu của bạn không đúng";
                        request.setAttribute("uname", uname);
                        request.setAttribute("upass", pass);
                        request.setAttribute("errorUser", errorUser);
                        request.setAttribute("errorPass", errorPass);
                        if(cn!=null){

                        cn.setNumlog(cn.getNumlog() + 1);

                        }
                        request.getRequestDispatcher("Login.jsp").forward(request,response);
                    }


                    if (checkUser == true) {
                        s2.invalidate();


                        HttpSession session = request.getSession(true);
                        User u = new User();
                        u.setId(rs.getInt(1));
                        u.setUname(rs.getString(3));
                        session.setAttribute("User", u);
                        response.sendRedirect("MainP.jsp");
                    }
                } }catch ( ClassNotFoundException | SQLException e ) {
                e.printStackTrace();
            }

        }
        private String protecctPass(String password) throws NoSuchAlgorithmException {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashInBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        }
    public static String getClientIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

public boolean checksignin(HttpServletRequest request){
    HttpSession s = request.getSession(false);
    User u2 = (User) s.getAttribute("User");
    if(u2==null){
        return false;
    }
    else return true;
}




}
