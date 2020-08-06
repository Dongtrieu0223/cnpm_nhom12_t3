package lol.work.stop;

import lol.work.stop.DB.ConnectionDB;
import lol.work.stop.Model.Mailtemp;
import org.apache.catalina.Session;
import sun.plugin.dom.core.Element;

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

@WebServlet("/Register2")

public class Register2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession s = request.getSession(false);
        Mailtemp mail= (Mailtemp) s.getAttribute("mail");
        String sqlcheckID = "SELECT * FROM user where user.id=(select max(id) from user)";
System.out.println(mail.getUsername());
        ResultSet rs2 = null;
        try {
            ConnectionDB con = new ConnectionDB();
            PreparedStatement ps2 = con.getPreparedStatement(sqlcheckID);
            rs2 = ps2.executeQuery();
            rs2.next();
            System.out.println(rs2.getInt(1));
        String sqlInsert = "INSERT INTO user (id,Fullname,username, password,address,phone,email,description,authority,active )";
                String sqlValue = " VALUES  (?,null,?,MD5(?),0,0,?,null,0,?)";
                String sql = sqlInsert + sqlValue;
                PreparedStatement ps3 = ConnectionDB.getPreparedStatement(sql);

                ps3.setInt(1, (rs2.getInt(1)+1));
                ps3.setString(2, mail.getUsername());
                ps3.setString(3, mail.getPassword());

                ps3.setString(4, mail.getMailtemp());
                ps3.setInt(5, 1);


                ps3.executeUpdate();
                s.invalidate();
                response.sendRedirect("Login.jsp");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
