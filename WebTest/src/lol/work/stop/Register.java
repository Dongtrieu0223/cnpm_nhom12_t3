package lol.work.stop;


import lol.work.stop.DB.ConnectionDB;
import lol.work.stop.Model.Mailtemp;
import lol.work.stop.Model.SendMail2;
import lol.work.stop.Model.User;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.regex.Pattern;

@WebServlet("/Register")
public class Register extends HttpServlet {
    private String host;
    private String port;
    private String user;
    private String pass;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ServletContext context = getServletContext();
            host = context.getInitParameter("host");
            port = context.getInitParameter("port");
            user = context.getInitParameter("user");
            pass = context.getInitParameter("pass");
            response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");


            String unamenew = request.getParameter("unamenew") == null ? "" : request.getParameter("unamenew");
            String upassnew = request.getParameter("upassnew") == null ? "" : request.getParameter("upassnew");
            String upassnewcon = request.getParameter("upassnewcon") == null ? "" : request.getParameter("upassnewcon");

            String umail = request.getParameter("umail") == null ? "" : request.getParameter("umail");



            //error
            String errtaikhoan = "";
            String errmatkhau = "";
            String errmatkhaucon = "";

            String errmail = "";

            //check tk, mk
            boolean checkTaikhoan = false;
            boolean checkMatKhau = false;
            boolean checkMatKhauCon = false;

            boolean checkMail = false;

            // ket noi database
            ConnectionDB con = new ConnectionDB();
            // lay ra username de kt
            String sqlcheckExits = "SELECT user.username FROM user WHERE username=?";
            PreparedStatement ps = con.getPreparedStatement(sqlcheckExits);
            ps.setString(1, unamenew);
            ResultSet rs = ps.executeQuery();

            boolean exit = rs.next();

             
            String sqlcheckExitsMail = "SELECT user.email FROM user WHERE email=?";
            PreparedStatement psMail=con.getPreparedStatement(sqlcheckExitsMail);
            psMail.setString(1,umail);
            ResultSet rsMail=psMail.executeQuery();
            boolean exitEmail=rsMail.next();



            // check xem 
            String regexUser = "^[a-z0-9._-]{8,15}$";
            String regexPass = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
            String regexMail = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";



            Pattern paUser = Pattern.compile(regexUser);
            Pattern paPass = Pattern.compile(regexPass);
            Pattern paMail = Pattern.compile(regexMail);



            paUser.matcher(unamenew).matches();
            paPass.matcher(upassnew).matches();
            paMail.matcher(umail).matches();



            if (unamenew.length() < 8) {
                errtaikhoan = "TÃ i khoáº£n pháº£i cÃ³ Ã­t nháº¥t 8 kÃ½ tá»±";
            } else if (paUser.matcher(unamenew).matches() == false) {
                errtaikhoan = "TÃ i khoáº£n khÃ´ng há»£p lá»‡";
            } else if (exit == true) {
                errtaikhoan = "TÃ i khoáº£n Ä‘Ã£ tá»“n táº¡i";
            } else {
                errtaikhoan = "";
                checkTaikhoan = true;
            }

            if (upassnew.length() < 8) {
                errmatkhau = "Máº­t kháº©u pháº£i hÆ¡n 8 kÃ½ tá»±";
            } else if (paPass.matcher(upassnew).matches() == false) {
                errmatkhau = "Pháº£i cÃ³ Ã­t nháº­t 1 kÃ½ tá»± thÆ°á»�ng,hoa,sá»‘,kÃ½ tá»± Ä‘áº·c biá»‡t";
            } else {
                errmatkhau = "";
                checkMatKhau = true;
            }

            if (upassnew.equals(upassnewcon) == false) {
                errmatkhaucon = "Máº­t kháº©u khÃ´ng trÃ¹ng khá»›p";
            } else {
                errmatkhaucon = "";
                checkMatKhauCon = true;
            }







            if (paMail.matcher(umail).matches() == false) {
                errmail = "Email cá»§a báº¡n khÃ´ng há»£p lÃª";
            }else  if (exitEmail==true){
                errmail="Email cá»§a báº¡n Ä‘Ã£ cÃ³ ngÆ°á»�i sá»­ dá»¥ng";
            }
            else {
                errmail = "";
                checkMail = true;
            }




            Enumeration<String> params = request.getParameterNames();
            while (params.hasMoreElements()) {
                System.out.println(params.nextElement());

            }

            System.out.println(upassnew);
            System.out.println(checkTaikhoan);
            System.out.println(checkMatKhau);
            System.out.println(checkMatKhauCon);
            System.out.println(checkMail);

            System.out.println(System.lineSeparator());
            if (checkTaikhoan == false
                    || checkMatKhau == false
                    || checkMatKhauCon == false
                    || checkMail == false
                 ) {
                request.setAttribute("unamenew", unamenew);
                request.setAttribute("upassnew", upassnew);
                request.setAttribute("upassnewcon", upassnewcon);


                request.setAttribute("umail", umail);

                request.setAttribute("errtaikhoan", errtaikhoan);
                request.setAttribute("errmatkhau", errmatkhau);
                request.setAttribute("errmatkhaucon", errmatkhaucon);

                request.setAttribute("errmail", errmail);

                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
            if (checkTaikhoan == true
                    && checkMatKhau == true
                    && checkMatKhauCon == true
                    && checkMail == true


            ) {
                HttpSession session = request.getSession(true);
                Mailtemp m = new Mailtemp();
                m.setMailtemp(umail);
                m.setUsername(unamenew);
                m.setPassword(upassnew);
                session.setAttribute("mail", m);
                String mess= util.fullPath("Waiting.jsp");


                SendMail2.sendEmail(host, port, user, pass, umail, mess);
                response.sendRedirect("Login.jsp");


            }

        } catch (ClassNotFoundException | SQLException | NoClassDefFoundError | NullPointerException e) {
            e.printStackTrace();
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
