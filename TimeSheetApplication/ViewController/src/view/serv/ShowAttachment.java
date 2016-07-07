import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.math.BigDecimal;

import java.sql.Blob;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.servlet.*;
import javax.servlet.http.*;

import javax.sql.DataSource;


public class ShowAttachment extends HttpServlet {
    private static final String CONTENT_TYPE = "image/gif; charset=utf-8";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException,
                                                           IOException {
        

        response.setContentType(CONTENT_TYPE);
        String timeSheetId = request.getParameter("timeSheetId");
        OutputStream os = response.getOutputStream();
        Connection conn = null;
        try {
            Context ctx = new InitialContext();            
            conn = getOracleConnection();
            PreparedStatement statement =
                conn.prepareStatement("SELECT ATTACHMENT_ID,ATTACHED_FILE " +
                                      "FROM TIME_SHEET_ATTACHMENTS " +
                                      "WHERE TIMESHEET_ID = ?");
            statement.setBigDecimal(1, new BigDecimal(timeSheetId));
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Blob blob = rs.getBlob("ATTACHED_FILE");                
                BufferedInputStream in = new BufferedInputStream(blob.getBinaryStream());
                int b;
                byte[] buffer = new byte[10240];
                while ((b = in.read(buffer, 0, 10240)) != -1) {
                    os.write(buffer, 0, b);
                }
                os.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sqle) {
                System.out.println("SQLException error");
            }
        }
    }
    public static Connection getOracleConnection() throws Exception {
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:orcl";
      String username = "hr";
      String password = "hr";

      Class.forName(driver); // load Oracle driver
      Connection conn = DriverManager.getConnection(url, username, password);
      return conn;
    }

}