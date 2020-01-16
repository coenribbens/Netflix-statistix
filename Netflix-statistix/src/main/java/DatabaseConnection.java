
    import java.sql.*;

    /**
     * Dit is een voorbeeld Java toepassing waarin je verbinding maakt met een SQLServer database.
     */
    public class DatabaseConnection {
        private String connectionURL;

        public DatabaseConnection(String ConnectionURL){

            this.connectionURL=ConnectionURL;
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch(Exception e){
                e.printStackTrace();

            }
        }

        public static void main(String[] args) {

            // Dit zijn de instellingen voor de verbinding. Vervang de databaseName indien deze voor jou anders is.
            String connectionUrl = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=NetflixStatistics;integratedSecurity=true;";

            // Connection beheert informatie over de connectie met de database.
            Connection con = null;

            // Statement zorgt dat we een SQL query kunnen uitvoeren.
            Statement stmt = null;

            // ResultSet is de tabel die we van de database terugkrijgen.
            // We kunnen door de rows heen stappen en iedere kolom lezen.
            ResultSet rs = null;

            try {
                // 'Importeer' de driver die je gedownload hebt.
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                // Maak de verbinding met de database.
                con = DriverManager.getConnection(connectionUrl);

                // Stel een SQL query samen.
                String SQL = "SELECT TOP 100 * FROM Account";
                stmt = con.createStatement();
                // Voer de query uit op de database.
                rs = stmt.executeQuery(SQL);

                System.out.print(String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-"));

                // Als de resultset waarden bevat dan lopen we hier door deze waarden en printen ze.
                while (rs.next()) {
                    // Vraag per row de kolommen in die row op.
                    String ISBN = rs.getString("Username");
                    String title = rs.getString("Woonplaats");
                    String author = rs.getString("Adres");

                    // Print de kolomwaarden.
                    // System.out.println(ISBN + " " + title + " " + author);

                    // Met 'format' kun je de string die je print het juiste formaat geven, als je dat wilt.
                    // %d = decimal, %s = string, %-32s = string, links uitgelijnd, 32 characters breed.
                    System.out.format("| %7s | %-32s | %-24s | \n", ISBN, title, author);
                }
                System.out.println(String.format("| %7s | %-32s | %-24s |\n", " ", " ", " ").replace(" ", "-"));

            }

            // Handle any errors that may have occurred.
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                if (rs != null) try { rs.close(); } catch(Exception e) {}
                if (stmt != null) try { stmt.close(); } catch(Exception e) {}
                if (con != null) try { con.close(); } catch(Exception e) {}
            }
        }



        public boolean inloggen(String inlognaam, String Wachtwoord){
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;

            try{
                connection = DriverManager.getConnection(connectionURL);
                statement = connection.prepareStatement("SELECT count(*) Username FROM Account WHERE Username = ? AND Wachtwoord = ?");
                statement.setString(1,inlognaam);
                statement.setString(2,Wachtwoord);
                resultSet = statement.executeQuery();

                if (resultSet.next()){
                    int numberofrows = resultSet.getInt(1);
                    System.out.println(numberofrows);
                    if(numberofrows == 1){
                        return true;
                    }





                }} catch (Exception e){
                e.printStackTrace();
            }




            return false;}
    }

