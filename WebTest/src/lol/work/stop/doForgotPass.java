package lol.work.stop;

import lol.work.stop.DB.ConnectionDB;
import lol.work.stop.Model.SendMail;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.regex.Pattern;


@WebServlet({"/doForgotPass"})
public class doForgotPass extends HttpServlet {

    private String host;
    private String port;
    private String user;
    private String pass;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ServletContext context = getServletContext();
            host = context.getInitParameter("host");
            port = context.getInitParameter("port");
            user = context.getInitParameter("user");
            pass = context.getInitParameter("pass");

            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");

            String email = request.getParameter("email")==null?"":request.getParameter("email");
            int code = (int) Math.floor(((Math.random() * 899999) + 10000000));
            ConnectionDB con = new ConnectionDB();
            String sqlcheckExitsMail = "SELECT user.email FROM user WHERE email=?";
            String errmail="";
            String regexMail = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
            Pattern paMail = Pattern.compile(regexMail);
            boolean checkMail = false;
            PreparedStatement psMail = con.getPreparedStatement(sqlcheckExitsMail);

            psMail.setString(1,email);
            ResultSet rsMail = psMail.executeQuery();
            boolean exitEmail = rsMail.next();
            psMail.setString(1, email);
            if (paMail.matcher(email).matches() == false) {
                errmail = "Email của bạn không hợp lê";
            }else  if (exitEmail==false){
                errmail="Email của bạn không tồn tại trong hệ thống chúng tôi";
            }
            else {
                errmail = "Chúng tôi đã gửi mail cho bạn";
                checkMail = true;
            }

            if (checkMail==true){

                String sqlCheckForgot="SELECT forgotpass.email FROM forgotpass WHERE forgotpass.email=?";
                PreparedStatement psCheckForgot=con.getPreparedStatement(sqlCheckForgot);
                psCheckForgot.setString(1,email);
                ResultSet rsCheckForgot=psCheckForgot.executeQuery();
                boolean checkForgot=rsCheckForgot.next();

                if (checkForgot==false){
                    long millis = System.currentTimeMillis();
                    java.sql.Date date = new java.sql.Date(millis);
                    String sqlUpdateforgot="INSERT INTO forgotpass(forgotpass.idforgot,forgotpass.email,forgotpass.dayforgot) VALUES (?,?,?)";
                    PreparedStatement psUpdateforgot=con.getPreparedStatement(sqlUpdateforgot);
                    psUpdateforgot.setInt(1,code);
                    psUpdateforgot.setString(2,email);
                    psUpdateforgot.setDate(3,date);
                    psUpdateforgot.executeUpdate();
                    String mess= util.fullPath("changepassword2.jsp")+System.lineSeparator()+"Mã xác thực của bạn là" +code  ;

                    SendMail.sendEmail(host, port, user, pass, email, mess);

                }
                if (checkForgot == true) {
                    long millis = System.currentTimeMillis();
                    java.sql.Date date = new java.sql.Date(millis);
                    String sqlUpdateforgot="UPDATE forgotpass SET idforgot=?,dayforgot=? WHERE forgotpass.email=?";
                    PreparedStatement psUpdateforgot=con.getPreparedStatement(sqlUpdateforgot);
                    psUpdateforgot.setInt(1,code);
                    psUpdateforgot.setDate(2,date);
                    psUpdateforgot.setString(3,email);
                    psUpdateforgot.executeUpdate();
                    String mess= util.fullPath("changepassword2.jsp")+System.lineSeparator()+"Mã xác thực của bạn là    " +code  ;

                    SendMail.sendEmail(host, port, user, pass, email, mess);

                }




            }
            request.setAttribute("email",email);
            request.setAttribute("errmail",errmail);
            request.getRequestDispatcher("forgotpassword.jsp").forward(request,response);


        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
