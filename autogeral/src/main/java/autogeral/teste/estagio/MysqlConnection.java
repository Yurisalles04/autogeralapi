package autogeral.teste.estagio;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;

public class MysqlConnection {
    public Connection connectDb(){
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/autogeral?user=root&password=root";
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        MysqlConnection mysqlConnection = new MysqlConnection();
        Connection connection = mysqlConnection.connectDb();

        if (connection != null) {
            System.out.println("Conexão estabelecida com sucesso!");
        } else {
            System.out.println("Falha ao estabelecer a conexão.");
        }
    }
}
