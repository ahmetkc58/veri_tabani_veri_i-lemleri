package mysql1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySql_bağlantı_oluşturma {

    public static void main(String[] args) throws SQLException {

        selectDemo();
    }

    public static void kayıtEkleme() throws SQLException {

        Connection connection = null;
        DpHelper helper = new DpHelper();// veri tabanaı giriş sekmesi olaarak düşünelim
        PreparedStatement statement = null; // statement kullanmamızın nedeni mysql de komut yazıp 
        ResultSet resultset; // resulseti kullanmamızın nedeni sql den gelen verileri depolamak için kullanılır

        try {
            connection = helper.getConnection();// bağlantıyı sağladık
            //   System.out.println("bağlantı okey");
            String sql = "insert into deneme.otomobil_fiyatlari (marka,model) values (?,?)";// burada kullandığımız soru işaretleri ilerki satırlarda tanımlayabiliyoruz 
            statement.setString(1, "tog");// burada 1. soru işaretinin yerine ne yazacağımızı yazıyoruz
            statement.setString(2, "x500");// burada 2. soru işaretinin yerine ne yazacağımızı yazıyoruz
            statement = connection.prepareStatement(sql);//burada sql sorgusunda herhangi bir hata oluşursa hata yollayacak

            int result = statement.executeUpdate();// yukarda yazdığımız kod parçasını çalıştırır ve kaç tane kayıt eklediğini return eder
            System.out.println(result);
            System.out.println("kayıt eklendi");

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }

    public static void selectDemo() throws SQLException {
        Connection connection = null;
        DpHelper helper = new DpHelper(); // veri tabanına bağlantı sağladığımız kısım 
        Statement statement = null;// sql kodlarını yazacağımız kısım 
        ResultSet resultset;// sql den gelen verileri saaklayacağımız kısım
        try {
            connection = helper.getConnection(); // sql ile bağlantı sağlıyoruz
            //   System.out.println("bağlantı okey");
            statement = connection.createStatement();// veri tabanına bağlantı sağlayacağımız kısım 
            resultset = statement.executeQuery("select marka from deneme.otomobil_fiyatlari");// burada sql sorgusu yazıp sql sorgusundan gelen verileri resulsete aktarıyoruz
            ArrayList<country> list = new ArrayList();// country cinsinden verileri tutan bir liste oluşturduk

            while (resultset.next()) {// while nin içindeki yazı bir sonraki satıra geçmemizi sağlamaktadır
                //System.out.println(resultset.getString("sehiradi"));    profosyonelleşmek adına bu ismi nesne haline getiriyorum 
              country ct =null;
                System.out.println((resultset.getString("marka"))); //araçların markalarını yazdırdık
            }

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            connection.close();
        }
    }

}
