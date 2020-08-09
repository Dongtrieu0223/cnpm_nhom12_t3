package lol.work.stop;

import lol.work.stop.DB.ConnectionDB;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

@WebServlet({"/ChangePassword2"})
public class ChangePassword2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            ConnectionDB con = new ConnectionDB();
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);

            String upassnew = request.getParameter("upassnew") == null ? "" : request.getParameter("upassnew");
            String upassnewcon = request.getParameter("upassnewcon") == null ? "" : request.getParameter("upassnewcon");
            String maxacthuc = request.getParameter("maxacthuc") == null ? "" : request.getParameter("maxacthuc");

            String errmatkhau = "";
            String errmatkhaucon = "";
            String errmaxacthuc = "";

            boolean checkMatKhau = false;
            boolean checkMatKhauCon = false;
            boolean checkMaXacThuc = false;

            String regexPass = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

            Pattern paPass = Pattern.compile(regexPass);
            Pattern paMa = Pattern.compile("-?\\d+(\\.\\d+)?");

            paPass.matcher(upassnew).matches();

            String sqlCheckMa = "SELECT forgotpass.* FROM forgotpass WHERE idforgot=?";
            PreparedStatement psCheckMa = con.getPreparedStatement(sqlCheckMa);
            psCheckMa.setString(1,maxacthuc);
            ResultSet rsCheckMa = psCheckMa.executeQuery();
            boolean checkMa = rsCheckMa.next();

            if (upassnew.length() < 8) {
                errmatkhau = "Mật khẩu phải hơn 8 ký tự";
            } else if (paPass.matcher(upassnew).matches() == false) {
                errmatkhau = "Phải có ít nhật 1 ký tự thường,hoa,số,ký tự đặc biệt";
            } else {
                errmatkhau = "";
                checkMatKhau = true;
            }

            if (upassnew.equals(upassnewcon) == false) {
                errmatkhaucon = "Mật khẩu không trùng khớp";
            } else {
                errmatkhaucon = "";
                checkMatKhauCon = true;
            }

            if (paMa.matcher(maxacthuc).matches() == false) {
                errmaxacthuc = "Mã xác thực là 1 chuỗi số";
            } else if (checkMa == false) {
                errmaxacthuc = "Mã xác thực không trùng khớp";
            } else if (date.toString().equals(rsCheckMa.getString(3))==false){
                errmaxacthuc="Mã xác thực của bạn đã hết hạn";
            }
            else {
                errmaxacthuc = "";
                checkMaXacThuc = true;
            }


            // check thấy sai => quay về trang changepassword hiển thị thông báo
            if (checkMatKhau == false || checkMatKhauCon == false || checkMaXacThuc == false) {
                request.setAttribute("errmatkhau", errmatkhau);
                request.setAttribute("errmatkhaucon", errmatkhaucon);
                request.setAttribute("errmaxacthuc", errmaxacthuc);
                request.getRequestDispatcher("changepassword2.jsp").forward(request, response);
            }
            // check thấy đúng=> update vào cơ sở dữ liệu và quay về trang login
            if (checkMatKhau == true && checkMatKhauCon == true && checkMaXacThuc == true) {
                String sqlChangePass="UPDATE user SET user.password=MD5(?)  WHERE user.email=?";
                String sqlDeleteForgot="DELETE FROM forgotpass WHERE forgotpass.email=?";
                PreparedStatement psChangePass=con.getPreparedStatement(sqlChangePass);
                psChangePass.setString(1,upassnew);
                psChangePass.setString(2,rsCheckMa.getString(2));
                PreparedStatement psDeleteForgot=con.getPreparedStatement(sqlDeleteForgot);
                psDeleteForgot.setString(1,rsCheckMa.getString(2));
                psChangePass.executeUpdate();
                psDeleteForgot.executeUpdate();
                response.sendRedirect("Login.jsp");
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
